# Xml

## 概述

### 概念

+ XML 被设计用来传输和存储数据。
+ HTML 被设计用来显示数据。

### 什么是Xml？

- XML 指可扩展标记语言（EXtensible Markup Language）。
- XML 是一种很像HTML的标记语言。
- XML 的设计宗旨是传输数据，而不是显示数据。
- XML 标签没有被预定义。您需要自行定义标签。
- XML 被设计为具有自我描述性。
- XML 是 W3C 的推荐标准。

## 使用

### 树结构

~~~xml
<bookstore>
    <book category="COOKING">
        <title lang="en">Everyday Italian</title>
        <author>Giada De Laurentiis</author>
        <year>2005</year>
        <price>30.00</price>
    </book>
    <book category="CHILDREN">
        <title lang="en">Harry Potter</title>
        <author>J K. Rowling</author>
        <year>2005</year>
        <price>29.99</price>
    </book>
    <book category="WEB">
        <title lang="en">Learning XML</title>
        <author>Erik T. Ray</author>
        <year>2003</year>
        <price>39.95</price>
    </book>
</bookstore>
~~~

### 语法

#### 必须有根元素

以下实例中 note 是根元素：

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
  <to>Tove</to>
  <from>Jani</from>
  <heading>Reminder</heading>
  <body>Don't forget me this weekend!</body>
</note>
~~~

#### 声明

XML 声明文件的可选部分，如果存在需要放在文档的第一行

~~~xml
<?xml version="1.0" encoding="utf-8"?>
~~~



#### 必须有一个关闭标签

~~~xml
<p>This is a paragraph.</p>
~~~



#### XML 标签对大小写敏感

~~~xml
<Message>这是错误的</message>
<message>这是正确的</message>
~~~



#### 属性值必须加引号

~~~xml
<note date="12/11/2007">
<to>Tove</to>
<from>Jani</from>
</note>
~~~



#### 注释

~~~xml
<!-- This is a comment -->
~~~

