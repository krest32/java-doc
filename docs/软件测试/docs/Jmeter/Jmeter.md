

# Jmeter

## 参考资料

[CSDN JMeter](https://blog.csdn.net/Echo_165/article/details/124033651?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166120552116782246440183%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=166120552116782246440183&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-6-124033651-null-null.142^v42^pc_rank_34,185^v2^control&utm_term=jmeter&spm=1018.2226.3001.4187)

## 概念

### jmeter是什么？

jmeter：是Apche公司使用Java平台开发的一款测试工具

### jmeter 用来做什么？

- 接口测试
- 性能测试
- 压力测试（优势）
- 数据库测试
- Java程序测试 （因为本身就是Java语言编写的）

### 优点

- 开源免费
- 支持多协议 （http，tcp...）
- 轻量级
- 功能强大

### 缺点

无法验证JS程序，也无法验证页面UI，所以必须要和 selenium 配合来完成web2.0应用的测试

###  目录介绍

![image-20220823173416878](img/image-20220823173416878.png)

### jmeter测试计划要素

- 测试计划（项目名称）
- 测试计划中至少有一个线程组
- 线程组中至少有一个取样器
- 测试计划中必须有监听器



### 运行规则

#### 原则

**取样器**：以取样器为核心，取样器没有作用域

**逻辑控制器**：只对子节点的取样器和逻辑控制器起作用

**其他元件**：

- 如果父节点是取样器，则只对其父节点起作用
- 如果父节点不是取样器，则该作用域是其父节点下的其他所有后代节点（子节点，子节点的子节点）



#### 执行顺序

**同一作用域下不同元件执行顺序**

- 配置元件 -- 前置处理器 -- 定时器 -- **取样器** -- 后置处理器 -- 断言 -- 监听器

**同一作用域下相同元件的执行顺序**

- 从上到下依次执行

**案例：执行顺序案例**

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5aKo55G2XzE2NQ==,size_16,color_FFFFFF,t_70,g_se,x_16.png)



定时器1 -- 请求1 -- 定时器1 -- 定时器2 -- 请求2 -- 定时器1 -- 定时器3 -- 请求3

解析：定时器1 的父节点不是取样器，所以对父节点下的所有后代节点都起作用





## 安装与配置

### 配置jdk环境变量
1.新建环境变量变量名:JAVA_HOME变量值：（即JDK的安装路径）

2.编辑`Path%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;`

3.新建环境变量变量名：`CLASSPATH`变量值： `.;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar`

4.验证在`cmd`窗口中输入`java`



### 下载配置环境变量

（下载地址：[Apache JMeter - Download Apache JMeter](http://jmeter.apache.org/download_jmeter.cgi)）

1. 下载后无需安装，解压后即可使用。解压后目录如下
2. 环境配置
3. 新增JMETER_HOME环境变量，变量值为JMeter解压的路径

![img](img/61cec27d343729e2b76c3eae90ac564f.png)

4. 编辑CLASSPATH变量，加上

%JMETER_HOME%\lib\ext\ApacheJMeter_core.jar;%JMETER_HOME%\lib\jorphan.jar;%JMETER_HOME%\lib\logkit-2.0.jar;

![img](img/9b004a19207d3c2c12328afeefa52a72.png)



5. 完成以上操作后打开JMeter中bin目录下面的jmeter.bat文件即可打开JMeter了，打开的时候会有两个窗口，Jmeter的命令窗口和Jmeter的图形操作界面，不要关闭命令窗口

![img](img/8062946f534ffde8d5386d5e65854156.png)

![img](img/1e7133639c199476261eb35b1e791468.png)

### 设置成中文

方法一：

![img](img/c7501d4fa8514b0a506d93f2fac9ea60.png)

方法二：永久设置成中文

找到jmeter下的bin目录，打开jmeter.properties 文件

![img](img/bb85fa6270f28ada38d6d554ab18520a.png)

第三十七行修改为

language=zh_CN

去掉前面的#

![img](img/f3e01b0fbf78f9d15f8aad55261d695c.png)





## 接口测试

### 线程组

选择测试计划，右键-->添加-->线程-->线程组

![img](img/bc3befbf083818263ad3d0ca44dc3861.png)

![img](img/1e123b499c626911e4273ed2724b02f6.png)

说明：

1. 线程数：虚拟用户数。一个虚拟用户占用一个进程或线程。
2. 准备时长：设置的虚拟用户数需要多长时间全部启动。如果线程数为20 ，准备时长为10 ，那么需要10秒钟启动20个线程。也就是每秒钟启动2个线程。
3. 循环次数：每个线程发送请求的次数。如果线程数为20 ，循环次数为100 ，那么每个线程发送100次请求。总请求数为20*100=2000 。如果勾选了“永远”，那么所有线程会一直发送请求，一到选择停止运行脚本。

### HTTP请求

选择线程组：右键-->添加-->取样器-->HTTP请求

![img](img/6d8a87eb1b1340e2dea64366d4e4a1e8.png)

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXIuIEcgSw==,size_20,color_FFFFFF,t_70,g_se,x_16.png)

请求名称，可不改

1. Web服务器信息，网络协议、域名或IP、端口号，可自行修改
2. 接口请求：请求方法、请求路径、编码格式，可自行修改
3. 参数传递：消息体数据存储JSON信息

### HTTP信息头管理器

选择线程组：右键-->添加-->配置元件-->HTTP信息头管理器

作用：可以存储请求头里面的信息

![img](img/e4d924b2e32585db54b19d01d3ab1ab3.png)

![img](img/212d3dc5160491f7ae0878a7b2bbecaa.png)

### 查看结果

选择线程组：右键-->添加-->监听器-->查看结果树

![img](img/45936ee32b27b42a144269c87291ed6b.png)

![img](img/53630ed86c6793a8208f99ec8060065d.png)

#### 1.开始测试

![img](img/6e703dbc01c5f8b0bb235e8044171f77.png)

![img](img/5391f497433727dffbef64d094897999.png)

接口调用成功，通过修改http请求来验证返回值是否符合预期！

## Http请求默认值

选择测试计划：右键-->添加-->配置元件-->HTTP请求默认值

![img](img/335b9f32c9570e90ce68b24f45c22337.png)

![img](img/14f68e366ba895b9258549d446600e6d.png)



一个线程下可以同时存在多个http请求，可以把公共参数，提取到**HTTP请求默认值**组件中
比如：协议、IP、端口号、编码等

然后在每个http请求的元件中，编辑自己独有的信息即可。

![img](img/8a08277b80aeb9bbe5c3f73d339ff854.png)

![img](img/d58ecae650e9ac7907aac61e4475630e.png)

注：加了http请求默认值之后，在单个http请求里面还填写了同样的数据，那么以哪个为准就近原则——就近原则！

## Http cookie管理器

1. 添加HTTP cookie管理器之前：有报错，缺少cookies

![img](img/33ce1168cc5025ed27d4b2873955444d.png)

2. 选择测试计划：右键-->添加-->配置元件-->HTTP cookie管理器

![img](img/fd0811f8ce71f1f92ed9179f8b61131d.png)

![img](img/88f916f0318df7c3cafcad63b88c882f.png)

填写cookies信息

![image-20220823110909960](img/image-20220823110909960.png)

Tips:

1. 需要注意的是**域、路径必须填上，尤其是域**；因为Jmeter现版本默认不支持跨域的请求，不填的话设置的Cookie不会被带上。
2. 在需要取Cookie的线程里添加一个Http Cookie管理器，**可以默认为空，但是一定要添加，否则是不会存储cookie变量的**
3. 这样在同一个线程(组)内其它操作组件都是可以直接通过${COOKIE_xxxx}来获取
4. 目前jmeter在一个sampler中不能同时有多个cookie manager
5. 想要跨域存储cookies，需要设置 CookieManager.check.cookies =false

添加HTTP cookie管理器之后再次测试，不报错。

![img](img/e567c02815082f04c923fa5830ea2e16.png)



作用描述：HTTP Cookie管理器可以像浏览器一样存储和发送cookie，如果你要发送一个带cookie的http请求，cookie manager会自动存储该请求的cookies，并且后面如果发送同源站点的http请求时，都可以用这个cookies。

## 接口与线程之间的传参

以查询全部课程接口为例，希望提取课程id

![img](img/085fc9e379a71a35393efff49bacf62a.png)

### 添加json提取器

右键http请求-》添加-》后置处理器-》json提取器

JSON提取公式：$..字段名

![img](img/2045644830764b30b044c8d513744204.png)

![img](img/cc0163ae814280bbfb0a0dd81ea0d0d4.png)

查看提取结果——调试取样器：course_id=63

![img](img/bc7dea29ad4b6f1737a87b7e5da68be1.png)

提取全部id如下：

![img](img/8713e8b6be268cab9e22690e520c339b.png)

![img](img/93af18f677a47e8d6c9d263ce06913f4.png)

### 引用提取出来的参数

### 同一线程下引用：${引用名}

![img](img/86e451a44ba425929035202ceafff2d6.png)

![img](img/f07af092aab02d3745a0bfd47b83edf1.png)

### 跨线程引用：后置处理程序

直接把进入课程详情接口拉到另一个线程下，课程id没有成功被引用

![img](img/f1abd9a84a77f566022bf2e485c2f9e8.png)

跨线程需要把提取出来的值设置为全局变量：

右键http请求-》添加-》后置处理器-》后置处理程序

在BeanShell后置处理器中使用__setProperty()函数把courses_id设置为全局变量

${__setProperty(新值,${提取值},)};

![img](img/9b6836de09910bca85d71d442c57a044.png)

![img](img/a09444b3db722d89b93c8093db402734.png)

设置全局变量成功，再次引用查看效果

跨线程引用方法：${__property(变量名)}

![img](img/70cecc3763d99989fd9b306802a757c7.png)

![img](img/79550f1150b97b970f85aa6090737e28.png)

跨线程调用成功！

报错是因为没有cookies，下面解决no cookies问题

## 跨线程调用cookies

1. 找到需要提取的内容

![img](img/4bb8c82fe7cc2287286b89576279d6b2.png)

2. 添加正则表达式提取器：右键http请求-》添加-》后置处理器-》json提取器

![img](img/7b9b2f1c706b0277d904b10af1e8deea.png)

![img](img/2d94ad8ce6ee06514110e2dfbf9ad0dc.png)

3. 查看提取结果——调试取样器

![img](img/671969881b3120747dafea71835ac213.png)



4. 成功提取！同样，跨线程需要把提取出来的值设置为全局变量：
   + 右键http请求-》添加-》后置处理器-》后置处理程序
   + ${__setProperty(nlqtoken,${lqtoken},)};

![img](img/50e6771aee076d9ed946feebcab0e168.png)

5. 在第二个线程下添加信息头管理器

![img](img/6992fc15412064f9315595a4864c8d93.png)

6. 跨线程引用函数：lqtoken=${__property(nlqtoken)}

![img](img/1627a9c9c73dcb0662fa884a6dc39ab5.png)

7. 开始测试

![img](img/dd1c342820aa957cb72323d8310ac5e9.png)

跨线程cookies调用成功！

## 参数化

CSV Data Set Config方式

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXIuIEcgSw==,size_20,color_FFFFFF,t_70,g_se,x_16-166122236133895.png)

![img](img/c30199c810fb5cb6197cb382c3d47ea7.png)



选择测试计划

右键-->添加-->元件-->CSV data Sat config

![img](img/2335f4007e5b8f544798651d862d9c69.png)

![img](img/a682b5a21ca233f596b08750ca6746c5.png)

3. 使用参数化变量：${变量名}

![img](img/9b40814cb1e8d4edf8f8d4b24b239918.png)

4. 开始测试

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXIuIEcgSw==,size_20,color_FFFFFF,t_70,g_se,x_16-1661222536653106.png)

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXIuIEcgSw==,size_20,color_FFFFFF,t_70,g_se,x_16-1661222544180109.png)

![img](img/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBATXIuIEcgSw==,size_20,color_FFFFFF,t_70,g_se,x_16-1661222551381112.png)

三个登录接口分别使用了不同的账号密码