# Properties

## 概述

1. 后缀`properties`是一种属性文件。这种文件以`key=value`格式存储内容，`Java`中可以使用`Properties`类来读取这个文件。`String value=p.getProperty(key)`就能得到对应的数据
2. 一般这个文件作为一些参数的存储，代码就可以灵活一点，用于适应多语言环境存放一组配置
3. 类似 `ini`, 还要简单些, 因为没有`section`，难以表达层次, 复杂点可以用`xml`或者`json`做配置