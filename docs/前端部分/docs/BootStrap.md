# Bootstrap4

## 概述

### 总结

​		随着Vue 的兴起，BootStrap的使用也越来越少了，本质上 bootstrap 的使用在 Vue 上面不太理想

### 简介

+ Bootstrap 是全球最受欢迎的前端组件库，用于开发响应式布局、移动设备优先的 WEB 项目。
+ Bootstrap4 是一套用于 HTML、CSS 和 JS 开发的开源工具集。利用我们提供的 Sass 变量和大量 mixin、响应式栅格系统、可扩展的预制组件、基于 jQuery 的强大的插件系统，能够快速为你的想法开发出原型或者构建整个 app 。

### 与 Bootstrap3

+ Bootstrap4 是 Bootstrap 的最新版本，与 Bootstrap3 相比拥有了更多的具体的类以及把一些有关的部分变成了相关的组件。同时 Bootstrap.min.css 的体积减少了40%以上。
+ Bootstrap4 放弃了对 IE8 以及 iOS 6 的支持，现在仅仅支持 IE9 以上 以及 iOS 7 以上版本的浏览器。如果对于其中需要用到以前的浏览器，那么请使用 [Bootstrap3](https://www.runoob.com/bootstrap/bootstrap-tutorial.html)。



## 实用

### 第一个 Bootstrap 4 页面

Bootstrap 要求使用 HTML5 文件类型，所以需要添加 HTML5 doctype 声明。

HTML5 doctype 在文档头部声明，并设置对应编码:

#### 移动设备优先

为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签，如下所示：

```
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
```

`width=device-width` 表示宽度是设备屏幕的宽度。

`initial-scale=1` 表示初始的缩放比例。

shrink-to-fit=no 自动适应手机屏幕的宽度。

### 容器类

Bootstrap 4 需要一个容器元素来包裹网站的内容。

我们可以使用以下两个容器类：

- .container 类用于固定宽度并支持响应式布局的容器。
- .container-fluid 类用
- 于 100% 宽度，占据全部视口（viewport）的容器。



### 网格系统

Bootstrap 4 网格系统有以下 5 个类:

- .col- 针对所有设备
- .col-sm- 平板 - 屏幕宽度等于或大于 576px
- .col-md- 桌面显示器 - 屏幕宽度等于或大于 768px)
- .col-lg- 大桌面显示器 - 屏幕宽度等于或大于 992px)
- .col-xl- 超大桌面显示器 - 屏幕宽度等于或大于 1200px)



###  文字排版

~~~html
<h1> - <h6>
~~~

#### Display 标题类

Bootstrap 还提供了四个 Display 类来控制标题的样式: .display-1, .display-2, .display-3, .display-4。

~~~html
<div class="container">
  <h1>Display 标题</h1>
  <p>Display 标题可以输出更大更粗的字体样式。</p>
  <h1 class="display-1">Display 1</h1>
  <h1 class="display-2">Display 2</h1>
  <h1 class="display-3">Display 3</h1>
  <h1 class="display-4">Display 4</h1>
</div>
~~~

#### Small 标题类

在 Bootstrap 4 中 HTML **<small>** 元素用于创建字号更小的颜色更浅的文本:

~~~html
<div class="container">
  <h1>更小文本标题</h1>
  <p>small 元素用于字号更小的颜色更浅的文本:</p>       
  <h1>h1 标题 <small>副标题</small></h1>
  <h2>h2 标题 <small>副标题</small></h2>
  <h3>h3 标题 <small>副标题</small></h3>
  <h4>h4 标题 <small>副标题</small></h4>
  <h5>h5 标题 <small>副标题</small></h5>
  <h6>h6 标题 <small>副标题</small></h6>
</div>
~~~

#### Mark 标签

Bootstrap 4 定义 **<mark>** 为黄色背景及有一定的内边距:

~~~html
<div class="container">
  <h1>高亮文本</h1>    
  <p>使用 mark 元素来 <mark>高亮</mark> 文本。</p>
</div>
~~~

#### 更多排版类

[文字排版](https://www.runoob.com/bootstrap4/bootstrap4-typography.html)

### 颜色

#### 文档颜色

 		Bootstrap 4 提供了一些有代表意义的颜色类：**.text-muted**, **.text-primary**, **.text-success**, **.text-info**, **.text-warning**, **.text-danger**, **.text-secondary**, **.text-white**, **.text-dark** and **.text-light**:

~~~html
<div class="container">
  <h2>代表指定意义的文本颜色</h2>
  <p class="text-muted">柔和的文本。</p>
  <p class="text-primary">重要的文本。</p>
  <p class="text-success">执行成功的文本。</p>
  <p class="text-info">代表一些提示信息的文本。</p>
  <p class="text-warning">警告文本。</p>
  <p class="text-danger">危险操作文本。</p>
  <p class="text-secondary">副标题。</p>
  <p class="text-dark">深灰色文字。</p>
  <p class="text-light">浅灰色文本（白色背景上看不清楚）。</p>
  <p class="text-white">白色文本（白色背景上看不清楚）。</p>
</div>
~~~



#### 背景颜色

​		提供背景颜色的类有: **.bg-primary**, **.bg-success**, **.bg-info**, **.bg-warning**, **.bg-danger**, **.bg-secondary**, **.bg-dark** 和 **.bg-light**。

注意背景颜色不会设置文本的颜色，在一些实例中你需要与 **.text-\*** 类一起使用。

~~~html
<div class="container">
  <h2>背景颜色</h2>
  <p class="bg-primary text-white">重要的背景颜色。</p>
  <p class="bg-success text-white">执行成功背景颜色。</p>
  <p class="bg-info text-white">信息提示背景颜色。</p>
  <p class="bg-warning text-white">警告背景颜色</p>
  <p class="bg-danger text-white">危险背景颜色。</p>
  <p class="bg-secondary text-white">副标题背景颜色。</p>
  <p class="bg-dark text-white">深灰背景颜色。</p>
  <p class="bg-light text-dark">浅灰背景颜色。</p>
</div>
~~~



### 表格

[bootStrap表格](https://www.runoob.com/bootstrap4/bootstrap4-tables.html)



### 图像

[图片](https://www.runoob.com/bootstrap4/bootstrap4-images.html)

#### 不同形状图片

1. 圆角
2. 椭圆
3. 缩略图

#### 图片对齐方式



#### 响应式图片

图像有各种各样的尺寸，我们需要根据屏幕的大小自动适应。我们可以通过在 **<img>** 标签中添加 **.img-fluid** 类来设置响应式图片。



### 信息提示框

[信息提示框](https://www.runoob.com/bootstrap4/bootstrap4-alerts.html)

提示框可以使用 **.alert** 类, 后面加上 **.alert-success**, **.alert-info**, **.alert-warning**, **.alert-danger**, **.alert-primary**, **.alert-secondary**, **.alert-light** 或 **.alert-dark** 类来实现:

~~~html
<div class="alert alert-success">
  <strong>成功!</strong> 指定操作成功提示信息。
</div>
~~~

可以实现多种功能

1. 提示
2. 增加链接
3. 关闭提示框按钮
4. 关闭提示按钮+动画



### 按钮

[Bootstrap4 按钮](https://www.runoob.com/bootstrap4/bootstrap4-buttons.html)

~~~html
<button type="button" class="btn">基本按钮</button>
<button type="button" class="btn btn-primary">主要按钮</button>
<button type="button" class="btn btn-secondary">次要按钮</button>
<button type="button" class="btn btn-success">成功</button>
<button type="button" class="btn btn-info">信息</button>
<button type="button" class="btn btn-warning">警告</button>
<button type="button" class="btn btn-danger">危险</button>
<button type="button" class="btn btn-dark">黑色</button>
<button type="button" class="btn btn-light">浅色</button>
<button type="button" class="btn btn-link">链接</button>
~~~



