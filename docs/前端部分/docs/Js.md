## JS

### 概述

### 为什么学习 JavaScript?

JavaScript web 开发人员必须学习的 3 门语言中的一门：

1. **HTML** 定义了网页的内容
2. **CSS** 描述了网页的布局
3. **JavaScript** 网页的行为

### JavaScript 简介

​		JavaScript 是互联网上最流行的脚本语言，这门语言可用于 HTML 和 web，更可广泛用于服务器、PC、笔记本电脑、平板电脑和智能手机等设备。

### JavaScript 是脚本语言

+ JavaScript 是一种轻量级的编程语言。
+ JavaScript 是可插入 HTML 页面的编程代码。
+ JavaScript 插入 HTML 页面后，可由所有的现代浏览器执行。

### JS用法

HTML 中的脚本必须位于 <script> 与 </script> 标签之间。

1. 内置：脚本可被放置在 HTML 页面的 <body> 和 <head> 部分中。

2. 外置文件：当然也可以把脚本保存到外部文件中。通常外部文件会被多个网页使用。

3. 例如

   ~~~html
   <!DOCTYPE html>
   <html>
   
   <body>..
       <script>document.write("<h1>这是一个标题</h1>"); document.write("<p>这是一个段落</p>");</script>..
   </body>
   
   </html>
   ~~~

   

### JS语法

#### 变量

变量可以使用短名称（比如 x 和 y），也可以使用描述性更好的名称（比如 age, sum, totalvolume）。

- 变量必须以字母开头
- 变量也能以 $ 和 _ 符号开头（不过我们不推荐这么做）
- 变量名称对大小写敏感（y 和 Y 是不同的变量）
- JavaScript 语句和 JavaScript 变量都对大小写敏感。

**局部 JavaScript 变量**

在 JavaScript 函数内部声明的变量（使用 var）是*局部*变量，所以只能在函数内部访问它。（该变量的作用域是局部的）。

您可以在不同的函数中使用名称相同的局部变量，因为只有声明过该变量的函数才能识别出该变量。只要函数运行完毕，本地变量就会被删除。



**全局 JavaScript 变量**

在函数外声明的变量是*全局*变量，网页上的所有脚本和函数都能访问它。

**JavaScript 变量的生存期**

+ JavaScript 变量的生命期从它们被声明的时间开始。
+ 局部变量会在函数运行以后被删除。
+ 全局变量会在页面关闭后被删除。

####  操作符

#### 关键字

~~~
#　Js关键字  	
2. break   	
3. catch   	
4. continue   
5. for   	
6. for...in   	
7. function   	
8. if...else   	
9. return   	
10. Switch   	
11. throw   	
12. try   	
13. var   	
14. while
~~~

#### 注释

1. // 进行单行注释
2. /* */ 进行多行注释

#### 数据类型

1. **值类型(基本类型)**：字符串（String）、数字(Number)、布尔(Boolean)、对空（Null）、未定义（Undefined）、Symbol。
2. **引用数据类型**：对象(Object)、数组(Array)、函数(Function)。
3. **字符串**：使用比较多，可以被当成对象，会有许多操作方法
4. **数据类型转化**

#### 对象

​		在 JavaScript中，几乎所有的事物都是对象。 该含义和Java中相当类似

#### 函数

1. **函数就是包裹在花括号中的代码块**，前面使用了关键词 function： 当调用该函数时，会执行函数内的代码。可以在某事件发生时直接调用函数（比如当用户点击按钮时），并且可由 JavaScript 在任何位置进行调用。\
2. **带有返回值的函数**:有时，我们会希望函数将值返回调用它的地方。通过使用 return 语句就可以实现。在使用 return 语句时，函数会停止执行，并返回指定的值。
   1. 如下面的例子

~~~html
<!DOCTYPE html><html>
    <head>		
        <meta charset="utf-8" />
        <title>测试实例</title>		
        <script>
            function myFunction() {		
                alert("Hello World!");			}
        </script>	
    </head>
    <body>	
        <button onclick="myFunction()">点我</button>
    </body>
</html>
~~~

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>测试实例</title>
		<script>
			function myFunction() {
				alert("Hello World!");
			}
		</script>
	</head>
### 事件

**JavaScript 事件**

1. HTML 事件是发生在 HTML 元素上的事情。
2. 当在 HTML 页面中使用 JavaScript 时， JavaScript 可以触发这些事件。

**HTML 事件**

1. HTML 事件可以是浏览器行为，也可以是用户行为
2. 以下是 HTML 事件的实例：
   1. HTML 页面完成加载
   2. HTML input 字段改变时
   3. HTML 按钮被点击

通常，当事件发生时，你可以做些事情。

在事件触发时 JavaScript 可以执行一些代码。

HTML 元素中可以添加事件属性，使用 JavaScript 代码来添加 HTML 元素。



**JavaScript 可以做什么?**

事件可以用于处理表单验证，用户输入，用户行为及浏览器动作:

- 页面加载时触发事件
- 页面关闭时触发事件
- 用户点击按钮执行动作
- 验证用户输入内容的合法性
- 等等 ...

可以使用多种方法来执行 JavaScript 事件代码：

- HTML 事件属性可以直接执行 JavaScript 代码
- HTML 事件属性可以调用 JavaScript 函数
- 你可以为 HTML 元素指定自己的事件处理程序
- 你可以阻止事件的发生。
- 等等 ...

### 表单验证

~~~HTML
<!DOCTYPE html><html>
    <head>		
        <meta charset="utf-8" />		
        <title>菜鸟教程(runoob.com)</title>	
    </head>	
    <head>
        <script>			
            function validateForm() {		
                var x = document.forms["myForm"]["fname"].value;			
                if (x == null || x == "") {					
                    alert("姓必须填写");					
                    return false;				
                }			
            }		
        </script>	
    </head>	
    <body>		
        <form
              name="myForm"
              action="demo-form.php"
              onsubmit="return validateForm()"
              method="post"	
              >			
            姓: <input type="text" name="fname" />
            <input type="submit" value="提交" />
        </form>	
    </body>
</html>
~~~

### 高级

#### 异步编程

​		子线程独立于主线程，所以即使出现阻塞也不会影响主线程的运行。但是子线程有一个局限：一旦发射了以后就会与主线程失去同步，我们无法确定它的结束，如果结束之后需要处理一些事情，比如处理来自服务器的信息，我们是无法将它合并到主线程中去的。

​		为了解决这个问题，JavaScript 中的异步操作函数往往通过回调函数来实现异步任务的结果处理。

**回调函数**

回调函数就是一个函数，它是在我们启动一个异步任务的时候就告诉它：等你完成了这个任务之后要干什么。这样一来主线程几乎不用关心异步任务的状态了，他自己会善始善终。



###  函数

#### 类型

第一种

~~~js
function functionName(parameters) {  执行的代码}
~~~

第二章

~~~js
functionName(parameter1, parameter2, parameter3) {    // 要执行的代码……}
~~~

#### 调用

~~~js
function myFunction(a, b) {    return a * b;}myFunction(10, 2);           // myFunction(10, 2) 返回 20
~~~



### DOM

#### 概念

通过 HTML DOM，可访问 JavaScript HTML 文档的所有元素。

![DOM HTML tree](img/pic_htmltree.gif)

#### 作用

通过可编程的对象模型，JavaScript 获得了足够的能力来创建动态的 HTML。

- JavaScript 能够改变页面中的所有 HTML 元素
- JavaScript 能够改变页面中的所有 HTML 属性
- JavaScript 能够改变页面中的所有 CSS 样式
- JavaScript 能够对页面中的所有事件做出反应

### 对象

**所有事物都是对象**

JavaScript 提供多个内建对象，比如 String、Date、Array 等等。 对象只是带有属性和方法的特殊数据类型。

- 布尔型可以是一个对象。
- 数字型可以是一个对象。
- 字符串也可以是一个对象
- 日期是一个对象
- 数学和正则表达式也是对象
- 数组是一个对象
- 甚至函数也可以是对象

~~~~html
<!DOCTYPE html><html>	<head>		<meta charset="utf-8" />		<title>菜鸟教程(runoob.com)</title>	</head>	<body>		<script>			var person = new Object();			person.firstname = "John";			person.lastname = "Doe";			person.age = 50;			person.eyecolor = "blue";			document.write(				person.firstname + " is " + person.age + " years old."			);		</script>	</body></html>
~~~~



###  BOM

#### 介绍

**浏览器对象模型 (BOM)**

​		浏览器对象模型（**B**rowser **O**bject **M**odel (BOM)）尚无正式标准。

​		由于现代浏览器已经（几乎）实现了 JavaScript 交互性方面的相同方法和属性，因此常被认为是 BOM 的方法和属性。

#### 例子

~~~~html
<!DOCTYPE html><html>	<head>		<meta charset="utf-8" />		<title>菜鸟教程(runoob.com)</title>	</head>	<body>		<p id="demo"></p>		<script>			var w =				window.innerWidth ||				document.documentElement.clientWidth ||				document.body.clientWidth;			var h =				window.innerHeight ||				document.documentElement.clientHeight ||				document.body.clientHeight;			x = document.getElementById("demo");			x.innerHTML = "浏览器window宽度: " + w + ", 高度: " + h + "。";		</script>	</body></html>
~~~~

运行结果

~~~js
浏览器window宽度: 682, 高度: 300。
~~~



### JS 库

#### 概念

​		JavaScript 高级程序设计（特别是对浏览器差异的复杂处理），通常很困难也很耗时。为了应对这些调整，许多的 **JavaScript (helper)** 库应运而生。这些 JavaScript 库常被称为 **JavaScript 框架**。

一些广受欢迎的 JavaScript 框架：

- jQuery
- Prototype
- MooTools

所有这些框架都提供针对常见 JavaScript 任务的函数，包括动画、DOM 操作以及 Ajax 处理。






