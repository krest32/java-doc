## CSS

### 概述：什么是 CSS?

- CSS 指层叠样式表 (**C**ascading **S**tyle **S**heets)
- 样式定义**如何显示** HTML 元素
- 样式通常存储在**样式表**中
- 把样式添加到 HTML 4.0 中，是为了**解决内容与表现分离的问题**
- **外部样式表**可以极大提高工作效率
- 外部样式表通常存储在 **CSS 文件**中
- 多个样式定义可**层叠**为一个



### 第一个CSS程序

~~~html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<title>菜鸟教程(runoob.com)</title> 
    <style>
        p
        {
            color:red;
            text-align:center;
        } 
    </style>
</head>
<body>
    <p>Hello World!</p>
    <p>这个段落采用CSS样式化。</p>
</body>
</html>
~~~



### id 和 class 选择器

1. id 选择器
   1. id 选择器可以为标有特定 id 的 HTML 元素指定特定的样式
   2. HTML元素以id属性来设置id选择器,CSS 中 id 选择器以 "#" 来定义。
2. class 选择器
   1. class 选择器用于描述一组元素的样式，class 选择器有别于id选择器，class可以在多个元素中使用
   2. class 选择器在HTML中以class属性表示, 在 CSS 中，类选择器以一个点"."号显示：

#### 如何插入样式表

插入样式表的方法有三种:

1. **外部样式表(External style sheet)**

   当样式需要应用于很多页面时，外部样式表将是理想的选择。在使用外部样式表的情况下，可以通过改变一个文件来改变整个站点的外观。每个页面使用 <link> 标签链接到样式表。 <link> 标签在（文档的）头部：

   ~~~html
   <head> <link rel="stylesheet" type="text/css" href="mystyle.css"> </head>
   ~~~

   浏览器会从文件 mystyle.css 中读到样式声明，并根据它来格式文档。

   外部样式表可以在任何文本编辑器中进行编辑。文件不能包含任何的 html 标签。样式表应该以 .css 扩展名进行保存。

   例子：

   ~~~html
   hr {color:sienna;}
   p {margin-left:20px;}
   body {background-image:url("/images/back40.gif");}
   ~~~

2. 内部样式表(Internal style sheet)

当单个文档需要特殊的样式时，就应该使用内部样式表。你可以使用 style标签在文档头部定义内部样式表，就像这样: 

~~~html
<head>
<style>
hr {color:sienna;}
p {margin-left:20px;}
body {background-image:url("images/back40.gif");}
</style>
</head>

~~~

1. 内联样式(Inline style)

​	由于要将表现和内容混杂在一起，内联样式会损失掉样式表的许多优势。请慎用这种方法，



###　功能实现

#### 1. 背景

####  2. 文本

#### 3. 字体

#### 4. 链接

#### 5. 列表

添加相应的小图片可以作为样式

#### 6. 盒子模型





#### 7 .Display(显示) 与 Visibility（可见性）

#### 8. Position(定位)



### 高级教程

#### 1. 导航

~~~ html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
        }

        li {
            float: left;
        }

        lia {
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #ddd;
        }

        li a.active {
            color: white;
            background-color: #4CAF50;
        }
    </style>
</head>

<body>
    <ul>
        <li><a class="active" href="#home">主页</a></li>
        <li><a href="#news">新闻</a></li>
        <li><a href="#contact">联系</a></li>
        <li><a href="#about">关于</a></li>
    </ul>
</body>

</html>
~~~

#### 2. 下拉菜单

~~~html
<!DOCTYPE html>
<html>

<head>
    <title>下拉菜单实例|菜鸟教程(runoob.com)</title>
    <meta charset="utf-8">
    <style>
        .dropbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
            cursor: pointer;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {
            background-color: #f1f1f1
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #3e8e41;
        }
    </style>
</head>

<body>
    <h2>下拉菜单</h2>
    <p>鼠标移动到按钮上打开下拉菜单。</p>
    <div class="dropdown"> <button class="dropbtn">下拉菜单</button>
        <div class="dropdown-content"> <a href="//www.runoob.com">菜鸟教程 1</a> <a href="//www.runoob.com">菜鸟教程 2</a> <a
                href="//www.runoob.com">菜鸟教程 3</a> </div>
    </div>
</body>

</html>
~~~





#### 3. 提示工具

~~~html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>
<style>
    .tooltip {
        position: relative;
        display: inline-block;
        border-bottom: 1px dotted black;
    }

    .tooltip .tooltiptext {
        visibility: hidden;
        width: 120px;
        background-color: black;
        color: #fff;
        text-align: center;
        border-radius: 6px;
        padding: 5px 0;
        position: absolute;
        z-index: 1;
        bottom: 100%;
        left: 50%;
        margin-left: -60px;
        /* 淡入 - 1秒内从 0% 到 100% 显示: */
        opacity: 0;
        transition: opacity 1s;
    }

    .tooltip:hover .tooltiptext {
        visibility: visible;
        opacity: 1;
    }
</style>

<body style="text-align:center;">
    <h2>提示工具淡入效果</h2>
    <p>鼠标移动到以下元素，提示工具会再一秒内从 0% 到 100% 完全显示。</p>
    <div class="tooltip">鼠标移动到我这 <span class="tooltiptext">提示文本</span></div>
</body>

</html><!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
</head>
<style>
    .tooltip {
        position: relative;
        display: inline-block;
        border-bottom: 1px dotted black;
    }

    .tooltip .tooltiptext {
        visibility: hidden;
        width: 120px;
        background-color: black;
        color: #fff;
        text-align: center;
        border-radius: 6px;
        padding: 5px 0;
        position: absolute;
        z-index: 1;
        bottom: 100%;
        left: 50%;
        margin-left: -60px;
        /* 淡入 - 1秒内从 0% 到 100% 显示: */
        opacity: 0;
        transition: opacity 1s;
    }

    .tooltip:hover .tooltiptext {
        visibility: visible;
        opacity: 1;
    }
</style>

<body style="text-align:center;">
    <h2>提示工具淡入效果</h2>
    <p>鼠标移动到以下元素，提示工具会再一秒内从 0% 到 100% 完全显示。</p>
    <div class="tooltip">鼠标移动到我这 <span class="tooltiptext">提示文本</span></div>
</body>

</html>
~~~



#### 4. 响应式图片

~~~html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <style>
        div.img {
            border: 1px solid #ccc;
        }

        div.img:hover {
            border: 1px solid #777;
        }

        div.img img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }

        * {
            box-sizing: border-box;
        }

        .responsive {
            padding: 0 6px;
            float: left;
            width: 24.99999%;
        }

        @media only screen and (max-width: 700px) {
            .responsive {
                width: 49.99999%;
                margin: 6px 0;
            }
        }

        @media only screen and (max-width: 500px) {
            .responsive {
                width: 100%;
            }
        }

        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }
    </style>
</head>

<body>
    <h2 style="text-align:center">响应式图片相册</h2>
    <div class="responsive">
        <div class="img"> <a target="_blank" href="img_fjords.jpg"> <img
                    src="//www.runoob.com/wp-content/uploads/2016/04/img_fjords.jpg" alt="Trolltunga Norway" width="300"
                    height="200"> </a>
            <div class="desc">Add a description of the image here</div>
        </div>
    </div>
    <div class="responsive">
        <div class="img"> <a target="_blank" href="img_forest.jpg"> <img
                    src="//www.runoob.com/wp-content/uploads/2016/04/img_forest.jpg" alt="Forest" width="600"
                    height="400"> </a>
            <div class="desc">Add a description of the image here</div>
        </div>
    </div>
    <div class="responsive">
        <div class="img"> <a target="_blank" href="img_lights.jpg"> <img
                    src="//www.runoob.com/wp-content/uploads/2016/04/img_lights.jpg" alt="Northern Lights" width="600"
                    height="400"> </a>
            <div class="desc">Add a description of the image here</div>
        </div>
    </div>
    <div class="responsive">
        <div class="img"> <a target="_blank" href="img_mountains.jpg"> <img
                    src="//www.runoob.com/wp-content/uploads/2016/04/img_mountains.jpg" alt="Mountains" width="600"
                    height="400"> </a>
            <div class="desc">Add a description of the image here</div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div style="padding:6px;">
        <h4>重置浏览器大小查看效果</h4>
    </div>
</body>

</html>
~~~



#### 5. 计数器

~~~html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <style>
        body {
            counter-reset: section;
        }

        h1 {
            counter-reset: subsection;
        }

        h1::before {
            counter-increment: section;
            content: "Section "counter(section) ". ";
        }

        h2::before {
            counter-increment: subsection;
            content: counter(section) "."counter(subsection) " ";
        }
    </style>
</head>

<body>
    <h1>HTML 教程:</h1>
    <h2>HTML 教程</h2>
    <h2>CSS 教程</h2>
    <h1>Scripting 教程:</h1>
    <h2>JavaScript</h2>
    <h2>VBScript</h2>
    <h1>XML 教程:</h1>
    <h2>XML</h2>
    <h2>XSL</h2>
    <p><b>注意:</b> IE8 需要指定 !DOCTYPE 才可以支持该属性。</p>
</body>

</html>
~~~





### 网页布局

~~~ html
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>菜鸟教程(runoob.com)</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            padding: 10px;
            background: #f1f1f1;
        }

        /* 头部标题 */
        .header {
            padding: 30px;
            text-align: center;
            background: white;
        }

        .header h1 {
            font-size: 50px;
        }

        /* 导航条 */
        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        /* 导航条链接 */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* 链接颜色修改 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 75%;
        }

        /* 右侧栏 */
        .rightcolumn {
            float: left;
            width: 25%;
            background-color: #f1f1f1;
            padding-left: 20px;
        }

        /* 图像部分 */
        .fakeimg {
            background-color: #aaa;
            width: 100%;
            padding: 20px;
        }

        /* 文章卡片效果 */
        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }

        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 底部 */
        .footer {
            padding: 20px;
            text-align: center;
            background: #ddd;
            margin-top: 20px;
        }

        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
        @media screen and (max-width: 800px) {

            .leftcolumn,
            .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
    </style>
</head>

<body>
    <div class="header">
        <h1>我的网页</h1>
        <p>重置浏览器大小查看效果。</p>
    </div>
    <div class="topnav"> <a href="#">链接</a> <a href="#">链接</a> <a href="#">链接</a> <a href="#" style="float:right">链接</a>
    </div>
    <div class="row">
        <div class="leftcolumn">
            <div class="card">
                <h2>文章标题</h2>
                <h5>2019 年 4 月 17日</h5>
                <div class="fakeimg" style="height:200px;">图片</div>
                <p>一些文本...</p>
                <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
            </div>
            <div class="card">
                <h2>文章标题</h2>
                <h5>2019 年 4 月 17日</h5>
                <div class="fakeimg" style="height:200px;">图片</div>
                <p>一些文本...</p>
                <p>菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！菜鸟教程 - 学的不仅是技术，更是梦想！</p>
            </div>
        </div>
        <div class="rightcolumn">
            <div class="card">
                <h2>关于我</h2>
                <div class="fakeimg" style="height:100px;">图片</div>
                <p>关于我的一些信息..</p>
            </div>
            <div class="card">
                <h3>热门文章</h3>
                <div class="fakeimg">
                    <p>图片</p>
                </div>
                <div class="fakeimg">
                    <p>图片</p>
                </div>
                <div class="fakeimg">
                    <p>图片</p>
                </div>
            </div>
            <div class="card">
                <h3>关注我</h3>
                <p>一些文本...</p>
            </div>
        </div>
    </div>
    <div class="footer">
        <h2>底部区域</h2>
    </div>
</body>

</html>
~~~





### 总结

本教程已向你讲解了如何创建样式表来同时控制多重页面的样式和布局。

已经学会如何使用 CSS 来添加背景、格式化文本、以及格式化边框，并定义元素的填充和边距。

同时，你也学会了如何定位元素、控制元素的可见性和尺寸、设置元素的形状、将一个元素置于另一个之后，以及向某些选择器添加特殊的效果，比如链接。



## 面试题

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



### 盒模型

一个盒子，会有 content,padding,border,margin 四部分，

标准的盒模型的宽高指的是 content 部分

ie 的盒模型的宽高包括了 content+padding+border

我们可以通过 box-sizing 修改盒模型，box-sizing border-box content-box



### margin 合并
在垂直方向上的两个盒子，他们的 margin 会发生合并（会取最大的值），比如上边盒子设置margin-bottom:20px，下边盒子设置margin-top:30px;，那么两个盒子间的间距只有30px，不会是50px

解决 margin 合并，我们可以给其中一个盒子套上一个父盒子，给父盒子设置 BFC

### margin 塌陷
效果： 一个父盒子中有一个子盒子，我们给子盒子设置margin-top:xxpx结果发现会带着父盒子一起移动（就效果和父盒子设置margin-top:xxpx的效果一样）

解决： 1、给父盒子设置 border，例如设置border:1px solid red; 2、给父盒子设置 BFC



### 响应式布局

1. 百分比布局，但是无法对字体，边框等比例缩放
2. 弹性盒子布局 display:flex
3. rem 布局，1rem=html 的 font-size 值的大小
4. css3 媒体查询 @media screen and(max-width: 750px){}
5. vw+vh
6. 使用一些框架（bootstrap，vant）

什么是响应式设计：响应式网站设计是一个网站能够兼容多个终端，智能地根据不同设备环境进行相对应的布局

响应式设计的基本原理：基本原理是通过媒体查询检测不同的设备屏幕尺寸设置不同的 css 样式 页面头部必须有 meta 声明的



### 布局

- 两栏布局,左边定宽，右边自适应
- 三栏布局、圣杯布局、双飞翼布局



### 水平垂直居中
方法一：给父元素设置成弹性盒子，子元素横向居中，纵向居中

方法二：父相子绝后，子部分向上移动本身宽度和高度的一半，也可以用 transfrom:translate(-50%,-50%)（最常用方法）

方法三：父相子绝，子元素所有定位为 0，margin 设置 auto 自适应



### iframe 有哪些缺点？
iframe 是一种框架，也是一种很常见的网页嵌入方

#### iframe 的优点：

1. iframe 能够原封不动的把嵌入的网页展现出来。
2. 如果有多个网页引用 iframe，那么你只需要修改 iframe 的内容，就可以实现调用的每一个页面内容的更改，方便快捷。
3. 网页如果为了统一风格，头部和版本都是一样的，就可以写成一个页面，用 iframe 来嵌套，可以增加代码的可重用。
4. 如果遇到加载缓慢的第三方内容如图标和广告，这些问题可以由 iframe 来解决。

#### iframe 的缺点：

1. 会产生很多页面，不容易管理。
2. iframe 框架结构有时会让人感到迷惑，如果框架个数多的话，可能会出现上下、左右滚动条，会分散访问者的注意力，用户体验度差。
3. 代码复杂，无法被一些搜索引擎索引到，这一点很关键，现在的搜索引擎爬虫还不能很好的处理 iframe 中的内容，所以使用 iframe 会不利于搜索引擎优化。
4. 很多的移动设备（PDA 手机）无法完全显示框架，设备兼容性差。
5. iframe 框架页面会增加服务器的 http 请求，对于大型网站是不可取的。现在基本上都是用 Ajax 来代替 iframe，所以 iframe 已经渐渐的退出了前端开发。

