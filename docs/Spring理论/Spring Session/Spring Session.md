# Spring Session

## 概述

1. 解决该问题的关键就是如何让多个tomcat共享同一个session。我们自然而然就会想到，把session存储在一个公共的地方，这样每个tomcat就都会获取到了，这个公共的地方就是数据库（本文以Redis为例）。
2. spring session的实现原理，就是在tomcat中加入了一个优先级很高的filter，来一个偷天换日，将request中的session置换为spring session，
3. 而这个spring session就存储在数据库中（Redis）,这样一来，不同的tomca就可以共享同一个session