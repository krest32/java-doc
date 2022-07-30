# Velocity



## 介绍

​		Velocity是一个基于Java的模板引擎，其提供了一个Context容器，在 Java 代码里面我们可以往容器中存值，然后在vm文件中使用特定的语法获取，这是velocity基本的用法，其与jsp、freemarker并称为三大视图展现技术，相对于jsp而言，velocity对前后端的分离更加彻底：在vm文件中不允许出现java代码，而jsp文件中却可以.作为一个模块引擎，除了作为前后端分离的MVC展现层，Velocity还有一些其他用途，比如源代码生成、自动email和转换xml等



## 应用场景

1. Web 应用：开发者在不使用 JSP 的情况下，可以用 Velocity 让 HTML 具有动态内容的特性
2. 源代码生成：Velocity 可以被用来生成 Java 代码、SQL 或者 PostScript
3. 自动 Email：很多软件的用户注册、密码提醒或者报表都是使用 Velocity 来自动生成的
4. 转换 xml



## 组成

1. app 模块：Velocit与好人Velocity Engine
2. Context 模块： 封装模版渲染需要的变量
3. Runtime 模块： 整个Velocity核心模块，解析语法
4. RuntimeInstance模块：将整个velocity渲染成为一个单利模式，拿到实例就可以完成渲染过程



## 基本流程

1. 初始化Velocity。Velocity可以使用两种模式，作为“单独的运行时实例”的单例模式(在下面的内容会介绍)，你仅仅只需要初始化一次。
2. 创建一个Context对象。
3. 把你的数据对象添加到Context（上下文）。
4. 选择一个模板。
5. ‘合并’ （merge）模板和你的数据输出。
6. 如果输出是文件，那么就需要释放IO资源

~~~java
public String GenerateCode() {
    // 初始化
    initVelocity();
    String vmFile = SystemConfig.getConfigByPath("SummaryReportConfig-Individual.vm-error-file");
    // 创建 Context 对象，将实例化对象放入进去
    VelocityContext context = VelocityUtilsError.prepareContext(params);
    StringWriter sw = new StringWriter();
    // 选择一个模版
    Template tpl = Velocity.getTemplate(vmFile, "UTF-8");
    // ‘合并’ （merge）模板和你的数据输出。
    tpl.merge(context, sw);
    return sw.toString();
}

    /**
     * Velocity 配置内容，初始化
     */
    private void initVelocity() {
        Properties p = new Properties();
        try {
            // 加载classpath目录下的vm文件
            p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // start 配置log4j
            p.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            p.setProperty("runtime.log.logsystem.log4j.logger", LOGGER_NAME);
            // end 配置log4j
            // 定义字符集
            p.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
            p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
~~~



## 基本语法

### 注释

1. 单行注释

~~~VM
## 这是单行注释

~~~

2. 多行注释

~~~VM
#*
 Thus begins a multi-line comment. Online visitors won’t
 see this text because the Velocity Templating Engine will
 ignore it.
 *#
~~~

3. 文档格式

~~~vm
#**
 This is a VTL comment block and
 may be used to store such information
 as the document author and versioning
information:
@version 1.1
@author xiao
*#

~~~

### 定义变量

~~~vm
#set($phone='18800000000')
#set($code='0086')
#set($mobile=$code+' - '+$phone)
$code - $phone <br/>
$mobile

#set(${!name} = "velocity")				 ## string
#set(${!foo} = $bar)					## variable reference
#set($foo =“hello”)						## string
#set($foo.name = $bar.name)				 ## property reference
#set($foo.name = $bar.getName($arg))	  ## method reference
#set($foo = 123)						## number
#set($foo = [“foo”,$bar])				 ## ArrayList

~~~

### 字符串替换Replace

~~~VM
#if($!{name} != '')
    #set($tempName = $!{name})
    #set($tempName = $tempName.Replace('abc','def'))
    $tempName
#end
~~~

### 截取部分字段subsubstring

~~~VM
#if($!result.result.nationalCode)
    #set($str=$!result.result.nationalCode)
    #if($str.indexOf("000")!=-1)
        #set($phoneFixCut=$!result.result.nationalCode.substring(3))
    #elseif($str.indexOf("00")!=-1)
        #set($phoneFixCut=$!result.result.nationalCode.substring(2))
    #elseif($str.indexOf("0")!=-1)
        #set($phoneFixCut=$!result.result.nationalCode.substring(1))
    #else
        #set($phoneFixCut=$!result.result.nationalCode)
    #end
#else
    #set($phoneFixCut=$!result.result.nationalCode)
#end
~~~



### 遍历

1. 简单循环

~~~VM
 #set($list = ["CTU", "SHA", "LAX"])
   #foreach ($item in $list)
      $velocityCount . $item <br/>
   #end
~~~

2. 语句嵌套

~~~vm
#foreach ($element in $list)
    ## inner foreach 内循环
    #foreach ($element in $list)
		This is $element. $velocityCount <br>inner<br>
	#end
  ## inner foreach 内循环结束
  ## outer foreach
  This is $element.
  $velocityCount <br>outer<br>
#end

~~~



### 判空

~~~VM

$null.isNull($orderList.orders) || $orderList.orders.size()==0  判断集合是否为空
#if(${value.length()}>0)
#end
 #if($(orderDto))
          订单对象有值
      #else
          订单对象为空
      #end
  
      #if(!$(orderDto))
          订单对象为空
      #else
         订单对象有值
     #end

~~~



### 分割字符串

~~~VM
#if($datetime)
    $datetime.ToString(""yyyy-MM-dd"")<br/>
#end <br/>

#if($date)
    $date.time.ToString(""yyyy-MM-dd hh:mm:ss"")<br/>
#end <br/>

#if($table)
    #foreach($model in $table.Rows)
        $model.time.ToString(""yyyy年MM月dd日"")<br/>
    #end
#end
~~~



### decimal数据类型转换成 tostring

~~~vm
需要计算的：如 （number/1000）.tostring("f1");
#if($strDecimal)
    $strDecimal.ToString(""f0"")<br/>
#end <br/>

#if($objectDecimal)
    $objectDecimal.Price.ToString(""f0"")<br/>
#end <br/>

#if($tableDecimal)
    #foreach($model in $tableDecimal.Rows)
        $model.Price.ToString(""f0"")<br/>
    #end
#end
~~~



### Trim() 去除空格

~~~vm
#if($!{name} != '')
    #set($tempName =$!{name})
    #if($tempName == ' abc ')
    还没有去除首尾空格<br/>
    #end
    #set($tempName =$tempName.Trim())
    #if($tempName == 'abc')
    去除成功
    #end
    $tempName
#end
~~~



### 分割字符串

~~~vm
#set($str="111#222")
#set($arr=$UtilHelper.SpiltString("$str","#"))
<p>$arr.length</p>
#foreach($item in $arr)
<h2>$item</h2>
#end
~~~



### 引入外部资源

#### #include 和 #parse

1. #include和#parse的作用都是引入本地文件, 为了安全的原因，被引入的本地文件只能在TEMPLATE_ROOT目录下。

2. 区别：

   1. 与#include不同的是，#parse只能指定单个对象。而#include可以有多个

      如果您需要引入多个文件，可以用逗号分隔就行：

      #include (“one.gif”, “two.txt”, “three.htm” )

      在括号内可以是文件名，但是更多的时候是使用变量的：

      #include ( “greetings.txt”, $seasonalstock )

   2. \#include被引入文件的内容将不会通过模板引擎解析；

      而#parse引入的文件内容Velocity将解析其中的velocity语法并移交给模板，意思就是说

      相当与把引入的文件copy到文件中。

      \#parse是可以递归调用的



#### #define

1. 定义重用模块，不能够传入参数，所以只能是一些静态的公用代码

2. 语法

   ~~~vm
   #define($模块名称)
   	模块内容
   #end
   ~~~

   

#### #evaluate

1. 在字符串中使用变量，动态解析属性

2. 语法

   可以后端保存velocity语句，传入解析：

   比如我们在java中：

   ```java
   context.put("v","#set($name = \"王尼玛\")");
   ```

   模板内容如下：

   ```bash
   #evaluate($v)
   $name
   ```

   解析结果：`王尼玛`



### 宏指令（可以携带参数）

~~~vm
#macro(method $name $age)
    hello!  $name, your age:$age
#end
## 调用宏，结果：hello!  Mike, your age:13
#method("Mike",13)

~~~

![在这里插入图片描述](https://img-blog.csdnimg.cn/68ac43effb9944cf8695a6afcfc43b88.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)




macro的注意
在使用中，有时候会用到嵌套循环，看一个例子。

java中定义一个list，内有 w1 w2 ccc 3个字符串

~~~vm
List<String> authRoleFind = new ArrayList<String>();
authRoleFind.add("w1");
authRoleFind.add("w2");
authRoleFind.add("ccc");
context.put("list",authRoleFind);

~~~

首先定义一个宏

![在这里插入图片描述](https://img-blog.csdnimg.cn/6c145ca8641f4e628ba140eff37630b9.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

这个时候，在一个和宏内调用了相同的List的循环，想当然的预想结果应该是：

~~~vm
w1 -> w1
w1 -> w2
w1 -> ccc
w2 -> w1
w2 -> w2
w2 -> ccc
~~~

![在这里插入图片描述](https://img-blog.csdnimg.cn/a1b685f6b88c441bb824f45eaf0b6531.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

但是它的结果却是这样的.$auth -> $name始终相等了！

![在这里插入图片描述](https://img-blog.csdnimg.cn/fd20ccbf89cf425784ec873f2c87ed42.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

那就和这个方法的结果一样了！

![在这里插入图片描述](https://img-blog.csdnimg.cn/da5ae8c5e1b94ab9a1ad3eaf904e3a7c.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

不知道有什么好的解决方案，反正不能用C、Java函数的思想去思考了。

或许它是将 #macro 的内容，直接copy过去再进行 编译/执行 ？

解决：在引入时，我们要防止调用时参数的名字 和 #macro中的变量名冲突！
像上面那个例子，#macro 内容中，就已经使用了$name这个参数了，所以在调用的时候#methodFind（）中不要再有$name了

![在这里插入图片描述](https://img-blog.csdnimg.cn/3107571cfef74c528d4bf17502ab8183.png?x-oss-process=image/watermark,type_ZHJvaWRzYW5zZmFsbGJhY2s,shadow_50,text_Q1NETiBAY29kZVlpbmc=,size_20,color_FFFFFF,t_70,g_se,x_16)

小结：我们在调用一个宏的时候 例#macro(methodFind $a $b) ，尽量以相同的参数名去调用#methodFind($a $b),以防止参数名冲突


# VelocityTools

​		应该算是Velocity的扩展，为了Velocity更好用。包括GenericTools 、VelocityView、 VelocityStruts三个子项目，其中VelocityStruts是为了与struts整合服务，此处不介绍。

1. GenericTools

   为j2se提供tools使用，具体tools如下：

   1. DateTool:  对Date操作：格式化、比较等
   2. EscapeTool：对template进行escaping
   3. IteratorTool：更好地控制 #foreach loop
   4. ListTool：透明地处理array和list
   5. MathTool：数学运算
   6. NumberTool：对数字格式化和convert
   7. RenderTool：对VTL的字符串执行 eval
   8. ResourceTool：国际化支持
   9. SortTool：对collections array iterator进行排序
   10. XMLTool：对xml文件读取，需要dom4j的支持

2. VelocityView
   1.  使用velocity快速且干净地构建应用程序，可以编写独立于特定技术的前台程序包含GenericTool，以及为J2EE扩展的tool;
   2.  有VelocityViewServlet  VelocityLayoutServlet  VelocityViewTag(嵌入velocity到jsp)  Maven plugin
3. VelocityViewServlet
   1. 就是一个servlet，用于向vm文件的context中插入 request response context对象。
