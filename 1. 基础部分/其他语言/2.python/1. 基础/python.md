# 基本了解

## 概述

### Python 读音

​		Python（英国发音：/ˈpaɪθən/ 美国发音：/ˈpaɪθɑːn/），是一种面向对象的解释型计算机程序设计语言，由荷兰人 Guido van Rossum 于1989年发明，第一个公开发行版发行于1991年。

### Python 命名
​		Python 命名的由来颇具感性色彩，1989年圣诞节期间，在阿姆斯特丹，Guido 为了打发圣诞节的无趣，决心开发一个新的脚本解释程序，作为 ABC 语言的一种继承。之所以选中 Python（意为大蟒蛇）作为该编程语言的名字，是因为他是一个叫 Monty Python 的喜剧团体的爱好者。

### Python 特点
​		若有人问我 Python 最大的特点是什么，我会毫不犹豫的告诉他：简单易学，功能强大。作为一款纯粹的自由软件，Python 有很多优点：

1. 简单，基于“优雅”、“明确”、“简单”的设计哲学，Python 设计时尽量使用其它语言经常使用的标识符号和英文单词，优秀的 Python 程序具有如同英文般的易读性，这使得学习 Python 变得容易；		
2. 高级，Python 是一种高层次的编程语言，与 Java，C/C++ 相比，Python 距离真实的机器更远，它使你能够专注于解决问题而无需考虑诸如如何管理你的程序使用的内存一类的底层实现细节；
3. 易移植，正因为脱离了底层细节的约束，Python 非常易于移植，无需修改便可以在各个平台运行，包括：Linux、Windows、FreeBSD、Macintosh、Solaris、AROS 等等。
4. 解释性，Python 在执行时，首先会将 .py 文件中的源代码编译成 Python 的 Byte Code（字节码），然后再由 Python Virtual Machine（Python 虚拟机）来执行这些编译好的 Byte Code。用户不需要担心如何编译程序，如何确保连接装载正确的库等等。
5. 强大而丰富的库：Python 具有丰富和强大的库，它可以帮助你处理各种工作，包括数据库、网页浏览器、CGI、FTP、电子邮件、XML、XML-RPC、HTML、WAV 文件、密码系统、GUI、Tk 等标准库。除此以外，还有许多高质量的库，如十分经典的科学计算扩展库：NumPy、SciPy 和 matplotlib。
6. 面向对象，Python 既支持面向过程的编程也支持面向对象的编程。在“面向过程”的语言中，程序是由过程或仅仅是可重用代码的函数构建起来的。在“面向对象”的语言中，程序是由数据和功能组合而成的对象构建起来的。与其他主要的语言如 C++ 和 Java 相比，Python 以一种非常强大又简单的方式实现面向对象编程：Python 是完全面向对象的语言，函数、模块、数字、字符串都是对象，并且完全支持继承、重载、派生、多继承，有益于增强源代码的复用性。Python 支持重载运算符和动态类型。
7. 可扩充，Python 提供了丰富的 API 和工具，以便程序员能够轻松地使用 C 语言、C++、Cython 来编写扩充模块。Python 编译器本身也可以被集成到其它需要脚本语言的程序内。因此，很多人还把 Python 作为一种“胶水语言”（Glue Language）使用。使用 Python 将其他语言编写的程序进行集成和封装。

### Python 发展

​		Python 诞生至今已经成为最受欢迎的程序设计语言之一。自2004年以后，Python 的使用率一直呈线性增长。根据 TIOBE 编程语言社区发布的2018年1月排行榜，Python 已经超过 C# 跃居热门编程语言的第四位。

​		由于 Python 语言的简洁性、易读性以及可扩展性，在国外用 Python 做科学计算的研究机构日益增多，一些知名大学已经采用 Python 来教授程序设计课程。例如卡耐基梅隆大学的编程基础、麻省理工学院的计算机科学及编程导论就使用 Python 语言讲授。众多开源的科学计算软件包都提供了 Python 的调用接口，例如著名的计算机视觉库 OpenCV、三维可视化库 VTK、医学图像处理库 ITK。而 Python 专用的科学计算扩展库就更多了，例如十分经典的科学计算扩展库：NumPy、SciPy 和 Matplotlib，它们分别为 Python 提供了快速数组处理、数值运算以及绘图功能。因此 Python 语言及其众多的扩展库所构成的开发环境十分适合工程技术、科研人员处理实验数据、制作图表，甚至开发科学计算应用程序。

### Python 前景

​		未来是人工智能的时代，有理由相信 Python 将发挥更大的作用。经过多年的演进，人工智能发展进入了新阶段。为抢抓人工智能发展的重大战略机遇：

​		2017年7月20日，国务院印发了《新一代人工智能发展规划》，提出了面向2030年我国新一代人工智能发展的指导思想、战略目标、重点任务和保障措施。
​		2017年 10 月 11 日，教育部考试中心发布了“关于全国计算机等级（NCRE）体系调整”的通知，决定自 2018 年 3月起，在计算机二级考试加入了“Python 语言程序设计”科目。
​		2018年1月16日上午，教育部召开新闻发布会，介绍了《普通高中课程方案和语文等学科课程标准（2017年版）》的有关情况，在此次“新课标”改革中，正式将人工智能、物联网、大数据处理划入新课标，这也就意味着今年秋季入学的高中生，将要开始学习 Python 了。

## 基本语法

### 变量类型

1. int
2. float
3. string
4. boolean

~~~python
a, b, c, d = 20, 5.5, True, 4+3j
# 显示数据类型
print(type(a), type(b), type(c), type(d))

# 判断是哪种类型
a = 111
print(isinstance(a, int))

# bool 是 int 的子类
print(issubclass(bool, int))

print(True==1)
~~~

5. 列表-list

   1. 有序排序
   2. 索引可以获取元素
   3. 可以存储元素
   4. 数据类型多元化

6. 字典

   1. 元素是无需的
   2. key不愿虚重复
   3. key必须是不可变对象
   4. 可以动态扩容
   5. 字典浪费较大内存，用时间换取空间的一种数据结构

7. 元祖

   1. 不可变序列
   2. 没有增删改的操作
   3. 使用小括号定义

   ~~~python
   t=('a','b','c')
   t=tuple('c','d','e')
   ~~~

8. 集合

   1. 可变序列
   2. 集合是没有value的字典
   3. 两个集合之间的判断

9. 字符串

   1. 不可变
   2. 每次的操作都会产生新的对象
   3. 格式化字符串：按照一定的方式输出字符串
      1. %s 字符串
      2. %i或者%d 整数
      3. %f 浮点数
      4. %.3f 小数点后3位
      5. %10.3f 总长度为10，小数占3位

   4. 编码转换

   ~~~python
   s.encode(encoding='GBK')
   s.encode(encoding='UTF-8')
   ~~~

   







### 注释

#### 单行注释

~~~python
# 单行注释
~~~

#### 多行注释

~~~python
```
多行注释
```
~~~



### 运算法

1. 算术运算符号`+ - * /`

   ~~~python
   11//2 	#5	  整除运算
   11/2 	#5.5  除法运算
   11%2 	#1	  求余操作
   2**3	#8    2的3次方
   2**2    #4	  2的2次方
   9//-4   #-3	  -2.2向下取整为-3
   -9//4   #-3	  -2.2向下取整为-3
   ~~~

2. 赋值运算符

   ~~~python
   a=2		    # 单一赋值
   a=b=c=20	# 链式赋值
   a=2+1	    # 运算赋值
   a+=2		# 参数赋值		
   ~~~

3. 比较运算符

4. 布尔元素符

   ~~~python
   a==1 and b==2 # true 
   1>2  or 2>1   # true
   print(not True)  # 输出flase
   not #取反
   in 		# 在什么当中
   not in 		# 不在什么当中
   ~~~



## 程序结构

对象的布尔值，以下对象的布尔值为False

1. False
2. 数值为 0
3. 空字符串
4. 空列表
5. 空元组
6. 空字典
7. 空集合

### 顺序结构

### 条件分支结构

1. if

2. if....else

3. if...elseif...else

4. 嵌套分支结构

5. 条件表达式

   ~~~python
   # 简写if else语句
   ~~~

6. pass 语句

   ~~~python
   pass 
   # 只是一个占位符，什么都不做，用作搭建程序框架
   ~~~

### 循环结构

1. range函数三种创建方式

   ~~~python
   # 迭代器，默认从0开始：0,1,2
   r = range(3)
   
   # 给定两个参数，start 和 end:1,2
   r= range(1,3)
   
   # 给定3个参数，start、end、步长:1,3
   r=range(1,5,2)
   10 in r   # false
   1 in r 	# true
   ~~~

2. while

   ~~~python
   while a<10
   while True
   
   ~~~

3. for-in

   ~~~python
   for item in "Python"
   	print(item)
           
   for i in range(10)
   	print(i)
       
   for _ in range(10)  #表示这个不会在循环中使用
   	
   ~~~

4. break，跳出本次循环

5. continue 跳过本次循环

## 函数

### 含义

可以重复使用的，有一定功能的一段 代码

### 创建

~~~python
def 函数名 （输入参数）
	函数体
    return 返回值
~~~

### 返回值

函数返回对个值的时候，返回值为元祖

### 参数

1. 固定参数
2. 可变个数的参数

~~~python
def fun (**args)
~~~



## 异常处理

1. try...except
2. try...except...else
3. try...except...else...finally

常见的异常类型

1. ZerodivisionError 
2. IndexError
3. KeyError

### 打印异常信息

`traceback.print_exc()`



## 类和对象

~~~python
class Student:  # 类对象
    # 类属性
    native_place = '吉林'

    def __init__(self,name,age):
        self.name = name
        self.age = age
        print("初始化方法")

    # 实例方法
    def eat(self):
        print("在吃饭")

    # 静态方法
    @staticmethod
    def method():
        print("静态方法")

    # 类方法
    @classmethod
    def cm(cls):
        print("类方法")


def drink():
    print("在喝水")


# 类的调用
stu1 = Student('张三',23)
print(stu1.name)
stu1.eat()
Student.method()
Student.eat(stu1)
~~~





### 动态绑定属性和方法






