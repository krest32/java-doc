## Html

### 概念

#### 基本概念

​		HTML5是HTML最新的修订版本，2014年10月由万维网联盟（W3C）完成标准制定。HTML5的设计目的是为了在移动设备上支持多媒体。HTML5 是 W3C 与 WHATWG 合作的结果,WHATWG 指 Web Hypertext Application Technology Working Group。WHATWG 致力于 web 表单和应用程序，而 W3C 专注于 XHTML 2.0。在 2006 年，双方决定进行合作，来创建一个新版本的 HTML。



#### HTML5 中的一些有趣的新特性：

1. 用于绘画的 canvas 元素
2. 用于媒介回放的 video 和 audio 元素
3. 对本地离线存储的更好的支持
4. 新的特殊内容元素，比如 article、footer、header、nav、section
5. 新的表单控件，比如 calendar、date、time、email、url、search



#### **一个Html的组成**

~~~html
<!DOCTYPE html>
<html>
	<head>
   <meta charset="utf-8">
		<title></title>
	</head>
	<body>
	</body>
</html>
~~~





### 更新

#### HTML5 的改进

- 新元素
- 新属性
- 完全支持 CSS3
- Video 和 Audio
- 2D/3D 制图
- 本地存储
- 本地 SQL 数据
- Web 应用

#### HTML5 应用

使用 HTML5 你可以简单地开发应用

- 本地数据存储
- 访问本地文件
- 本地 SQL 数据
- 缓存引用
- Javascript 工作者
- XHTMLHttpRequest 2

#### 为 HTML 添加新元素

​		你可以为 HTML 添加新的元素,，添加新的标签

#### HTML5 新元素

​		自1999年以后HTML 4.01 已经改变了很多,今天，在HTML 4.01中的几个已经被废弃，这些元素在HTML5中已经被删除或重新定义。

​		为了更好地处理今天的互联网应用，**HTML5添加了很多新元素及功能，比如: 图形的绘制，多媒体内容，更好的页面结构，更好的形式 处**理，和几个api拖放元素，定位，包括网页 应用程序缓存，存储，网络工作者，等

### 标签

~~~html
	<!-- 1. 标题一共6个等级 -->
	<h1>一级标题</h1>
	<h2>二级标题</h2>
	<h6>六级标题</h6>

	<!--2. 定义段落 -->
	<p>这是一个段落</p>

	<!-- 3. 链接 -->
	<a href="http://www.baidu.com">百度链接</a>
	
	<!-- 4. 添加图像  -->
	<p>下面的美女是舒畅</p>
	<img src="../Reource/timg.jpg" />
	
	<!-- 5. 换行符 -->
	<br>
~~~



### 属性

| class | 为html元素定义一个或多个类名（classname）(类名从样式文件引入) |
| ----- | ------------------------------------------------------------ |
| id    | 定义元素的唯一id                                             |
| style | 规定元素的行内样式（inline style）                           |
| title | 描述了元素的额外信息 (作为工具条使用)                        |



### Head元素

|   标签   | 描述                               |
| :------: | :--------------------------------- |
|  head  | 定义了文档的信息                   |
| title  | 定义了文档的标题                   |
| base | 定义了页面链接标签的默认链接地址   |
| link  | 定义了一个文档和外部资源之间的关系 |
| meta  | 定义了HTML文档中的元数据           |
| script | 定义了客户端的脚本文件             |
| style  | 定义了HTML文档的样式文件           |

### 表格

表格由 `table` 标签来定义。每个表格均有若干行（由 tr 标签定义），每行被分割为若干单元格（由 td 标签定义）。字母 td 指表格数据（table data），即数据单元格的内容。数据单元格可以包含文本、图片、列表、段落、表单、水平线、表格等等。 

~~~html
<table border="1">
<tr>
   <th>Header 1</th>
   <th>Header 2</th>
</tr>
<tr>
   <td>row 1, cell 1</td>
   <td>row 1, cell 2</td>
</tr>
<tr>
   <td>row 2, cell 1</td>
   <td>row 2, cell 2</td>
</tr>
</table>
~~~



### 更多的表格标签

| 标签       | 描述                 |
| :--------- | :------------------- |
| table    | 定义表格             |
| th       | 定义表格的表头       |
| tr      | 定义表格的行         |
| td       | 定义表格单元         |
| caption  | 定义表格标题         |
| colgroup | 定义表格列的组       |
| col    | 定义用于表格列的属性 |
| thead    | 定义表格的页眉       |
| tbody    | 定义表格的主体       |
| tfood    | 定义表格的页脚       |

### 列表

| ol | 定义有序列表         |
| ---- | -------------------- |
| ul | 定义无序列表         |
| li | 定义列表项           |
| dl | 定义列表             |
| dt | 自定义列表项目       |
| dd | 定义自定列表项的描述 |



### 区块

1. HTML div 和 span ：HTML 可以通过 div 和 span 将元素组合起来。

2. HTML 区块元素
   1. 大多数 HTML 元素被定义为**块级元素**或**内联元素**。
   2. 块级元素在浏览器显示时，通常会以新行来开始（和结束）。
   3. 实例: h1, p, ul, table
3. HTML 内联元素
   1. 内联元素在显示时通常不会以新行开始。
   2. 实例: b, td, a, img
4. HTML div 元素
   1. HTML div 元素是块级元素，它可用于组合其他 HTML 元素的容器
   2. 如果与 CSS 一同使用，div 元素可用于对大的内容块设置样式属性。

5. HTML span 元素
   1. HTML span 元素是内联元素，可用作文本的容器
   2. span 元素也没有特定的含义。
   3. 当与 CSS 一同使用时，span 元素可用于为部分文本设置样式属性。

### 布局

编码：

~~~html
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8"> 
<title>测试布局</title> 
</head>
<body>
	<!-- 建立容器 -->
	<div id="container" style="width:500px">
	
	<!-- 标题的格式：背景颜色 -->
	<div id="header" style="background-color:#FFA500;">
	
	<h1 style="margin-bottom:0;">主要的网页标题</h1></div>
	<!-- 侧面菜单的大小以及背景颜色 -->
	<div id="menu" style="background-color:#FFD700;height:200px;width:100px;float:left;">
	<b>菜单</b><br>
	HTML<br>
	CSS<br>
	JavaScript</div>

	<div id="content" style="background-color:#EEEEEE;height:200px;width:400px;float:left;">
	内容在这里</div>

	<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
	版权 © runoob.com</div>

	</div>
	 
</body>
</html>
~~~

显示结果

### 表单

1. HTML 表单

   1. 表单是一个包含表单元素的区域
   2. 表单元素是允许用户在表单中输入内容,比如：文本域(textarea)、下拉列表、单选框(radio-buttons)、复选框(checkboxes)等等。
   3. 表单使用表单标签 form 来设置:

   ~~~html
   <form>
   .
   *input 元素*
   .
   </form>
   ~~~

2. HTML 表单 - 输入元素
   1. 多数情况下被用到的表单标签是输入标签（input>）。
   2. 输入类型是由类型属性（type）定义的。大多数经常被用到的输入类型如下：

3. 文本域（Text Fields）

   1. 文本域通过input type="text" 标签来设定，当用户要在表单中键入字母、数字等内容时，就会用到文本域。

   ~~~html
   <form>
   First name: <input type="text" name="firstname"><br>
   Last name: <input type="text" name="lastname">
   </form>
   ~~~

   2. **注意:**表单本身并不可见。同时，在大多数浏览器中，文本域的默认宽度是 20 个字符。

4. 密码字段

   1. 密码字段通过标签input type="password" 来定义:

   ~~~html
   <form>
   Password: <input type="password" name="pwd">
   </form>
   
   ~~~

5. 单选按钮（Radio Buttons）

   ~~~Html
   <form>
   <input type="radio" name="sex" value="male">Male<br>
   <input type="radio" name="sex" value="female">Female
   </form>
   ~~~

6. 复选框（Checkboxes）

   ~~~html
   <form>
   <input type="checkbox" name="vehicle" value="Bike">I have a bike<br>
   <input type="checkbox" name="vehicle" value="Car">I have a car 
   </form>
   ~~~

7. 提交按钮(Submit Button)

   ~~~html
   <form name="input" action="html_form_action.php" method="get">
   Username: <input type="text" name="user">
   <input type="submit" value="Submit">
   </form>
   ~~~

   

### 框架

~~~html
<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8"> 
<title>菜鸟教程(runoob.com)</title> 
</head> 
<body>

<iframe src="demo_iframe.htm" name="iframe_a"></iframe>
<p><a href="//www.runoob.com" target="iframe_a">RUNOOB.COM</a></p>

<p><b>注意：</b> 因为 a 标签的 target 属性是名为 iframe_a 的 iframe 框架，所以在点击链接时页面会显示在 iframe框架中。</p>

</body>
</html>
~~~

### 脚本



## 面试题

### 浏览器内核

+ IE: trident 内核
+ Firefox：gecko 内核
+ Safari: webkit 内核
+ Opera: 以前是 presto 内核，Opera 现已改用 GoogleChrome 的 Blink 内核
+ Chrome: Blink(基于 webkit，Google 与 Opera Software 共同开发)

### **怎么理解** **HTML** **语义化**

​		HTML 语义化简单来说就是用正确的标签来做正确的事。比如表示段落用 p 标签、表示标题用 h1-h6 标签、表示文章就用 article 等。

### DOCTYPE 的作用

!DOCTYPE 声明位于文档中的最前面，处于 html 标签之前。告知浏览器以何种模式来渲染文档。

1. 严格模式的排版和 JS 运作模式是 以该浏览器支持的最高标准运行。

2. 在混杂模式中，页面以宽松的向后兼容的方式显示。模拟老式浏览器的行为以防止站 点无法工作。
3. DOCTYPE 不存在或格式不正确会导致文档以混杂模式呈现。复制代码 你知道多少种 Doctype 文档类型？ 该标签可声明三种 DTD 类型，分别表示严格版本、过渡版本以及基于框架的 HTML 文档。 HTML 4.01 规定了三种文档类型：Strict、Transitional 以及 Frameset。 XHTML 1.0 规定了三种 XML 文档类型：Strict、Transitional 以及 Frameset。 Standards （标准）模式（也就是严格呈现模式）用于呈现遵循最新标准的网页，而 Quirks （包容）模式（也就是松散呈现模式或者兼容模式）用于呈现为传统浏览器而设计的网页。

### 行内元素、块级元素、 空元素有那些？

- 行内元素 (不能设置宽高，设置宽高无效) a,span,i,em,strong,label
- 行内块元素：img, input
- 块元素： div, p, h1-h6, ul,li,ol,dl,table…
- 知名的空元素 br, hr,img, input,link,meta

可以通过 display 修改 inline-block, block, inline

注意：只有文字才能组成段落，因此 p 标签里面不能放块级元素，特别是 p 标签不能放 div。同理还有这些标签h1,h2,h3,h4,h5,h6,dt ，他们都是文字类块级标签，里面不能放其他块级元素。



### **meta viewport** **是做什么用的，怎么写**

使用目的

告诉浏览器，用户在移动端时如何缩放页面

~~~html
<meta
  name="viewport"
  content="width=device-width, 
               initial-scale=1, 
               maximum-scale-1, minimum-scale=1"
/>
~~~

with=device-width 将布局视窗（layout viewport）的宽度设置为设备屏幕分辨率的宽度

initial-scale=1 页面初始缩放比例为屏幕分辨率的宽度

maximum-scale=1 指定用户能够放大的最大比例

minimum-scale=1 指定用户能够缩小的最大比例



### **label** **标签的作用**

label 标签来定义表单控制间的关系,当用户选择该标签时，浏览器会自动将焦点转到和标签相关的表单控件上。

~~~html
<label for="Name">Number:</label>
<input type="text" name="Name" id="Name" />

<label
  >Date:
  <input type="text" name="B" />
</label>

~~~



### **canvas** **在标签上设置宽高 和在** **style** **中设置宽高有什么** **区别**

canvas 标签的 width 和 height 是画布实际宽度和高度，绘制的图形都是在这个上面。
而 style 的 width 和 height 是 canvas 在浏览器中被渲染的高度和宽度。
如果 canvas 的 width 和 height 没指定或值不正确，就被设置成默认值 。



### html5 新特性

1. 语义化标签， header, footer, nav, aside,article,section
2. 增强型表单
3. 视频 video 和音频 audio
4. Canvas 绘图
5. SVG绘图
6. 地理定位
7. 拖放 API
8. WebWorker
9. WebStorage( 本地离线存储 localStorage、sessionStorage )
10. WebSocket

### css3 新特性

1. 圆角效果；
2. 图形化边界；
3. 块阴影与文字阴影；
4. 使用 RGBA 实现透明效果；
5. 渐变效果；
6. 使用“@Font-Face”实现定制字体；
7. 多背景图；
8. 文字或图像的变形处理；
9. 多栏布局；
10. 媒体查询等。
