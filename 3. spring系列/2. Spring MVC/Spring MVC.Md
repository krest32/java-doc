# Spring MVC

## 概述

### 什么是Spring MVC？简单介绍下你对Spring MVC的理解？

Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把模型-视图-控制器分离，将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合。

### Spring MVC的优点

1. 可以支持各种视图技术,而不仅仅局限于JSP；

2. 与Spring框架集成（如IoC容器、AOP等）；

3. 清晰的角色分配：前端控制器(dispatcherServlet) , 请求到处理器映射（handlerMapping), 处理器适配器（HandlerAdapter), 视图解析器（ViewResolver）。

4.  支持各种请求资源的映射策略。

## 核心组件

### Spring MVC的主要组件？

1. 前端控制器 DispatcherServlet（不需要程序员开发）

   作用：接收请求、响应结果，相当于转发器，有了DispatcherServlet 就减少了其它组件之间的耦合度。

2. 处理器映射器HandlerMapping（不需要程序员开发）

   作用：根据请求的URL来查找Handler

3. 处理器适配器HandlerAdapter

   注意：在编写Handler的时候要按照HandlerAdapter要求的规则去编写，这样适配器HandlerAdapter才可以正确的去执行Handler。

4. 处理器Handler（需要程序员开发）

5. 视图解析器 ViewResolver（不需要程序员开发）

   作用：进行视图的解析，根据视图逻辑名解析成真正的视图（view）

6. 视图View（需要程序员开发jsp）

   View是一个接口， 它的实现类支持不同的视图类型（jsp，freemarker，pdf等等）



### 什么是DispatcherServlet

​		Spring的MVC框架是围绕DispatcherServlet来设计的，它用来处理所有的HTTP请求和响应。



### 什么是Spring MVC框架的控制器？

​		控制器提供一个访问应用程序的行为，此行为通常通过服务接口实现。控制器解析用户输入并将其转换为一个由视图呈现给用户的模型。Spring用一个非常抽象的方式实现了一个控制层，允许用户创建多种用途的控制器。



### Spring MVC的控制器是不是单例模式,如果是,有什么问题,怎么解决？

​		答：是单例模式,所以在多线程访问的时候有线程安全问题,不要用同步,会影响性能的,解决方案是在控制器里面不能写字段。



## 工作原理

### 请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？

1. 用户发送请求至前端控制器`DispatcherServlet`；
2.  `DispatcherServlet`收到请求后，调用`HandlerMapping`处理器映射器，请求获取`Handle`；
3. 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给`DispatcherServlet`；
4. `DispatcherServlet` 调用 `HandlerAdapter`处理器适配器；
5. `HandlerAdapter` 经过适配调用 具体处理器(Handler，也叫后端控制器)；
6. `Handler`执行完成返回`ModelAndView`；
7. `HandlerAdapter`将`Handler`执行结果`ModelAndView`返回给`DispatcherServlet`；
8. `DispatcherServlet`将`ModelAndView`传给`ViewResolver`视图解析器进行解析；
9. `ViewResolver`解析后返回具体`View`；
10. `DispatcherServlet`对`View`进行渲染视图（即将模型数据填充至视图中）
11. `DispatcherServlet`响应用户。

<img src="img/20200208211439106.png" alt="img" style="zoom: 200%;" />



## MVC框架

### MVC是什么？MVC设计模式的好处有哪些

​		mvc是一种设计模式（设计模式就是日常开发中编写代码的一种好的方法和经验的总结）。模型（model）-视图（view）-控制器（controller），三层架构的设计模式。用于实现前端页面的展现与后端业务数据处理的分离。

mvc设计模式的好处

1.分层设计，实现了业务系统各个组件之间的解耦，有利于业务系统的可扩展性，可维护性。

2.有利于系统的并行开发，提升开发效率。



## 常用注解

### 注解原理是什么

​		注解本质是一个继承了Annotation的特殊接口，其具体实现类是Java运行时生成的动态代理类。我们通过反射获取注解时，返回的是Java运行时生成的动态代理对象。通过代理对象调用自定义注解的方法，会最终调用AnnotationInvocationHandler的invoke方法。该方法会从memberValues这个Map中索引出对应的值。而memberValues的来源是Java常量池。



### Spring MVC常用的注解有哪些？

###### @RequestMapping：用于处理请求 url 映射的注解，可用于类或方法上。用于类上，则表示类中的所有响应请求的方法都是以该地址作为父路径。

@RequestBody：注解实现接收http请求的json数据，将json转换为java对象。

@ResponseBody：注解实现将conreoller方法返回对象转化为json对象响应给客户。



### SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？

​		答：一般用@Controller注解,也可以使用@RestController,@RestController注解相当于@ResponseBody ＋ @Controller,表示是表现层,除此之外，一般不用别的注解代替。

### @Controller注解的作用

​		在Spring MVC 中，控制器Controller 负责处理由DispatcherServlet 分发的请求，它把用户请求的数据经过业务处理层处理之后封装成一个Model ，然后再把该Model 返回给对应的View 进行展示。在Spring MVC 中提供了一个非常简便的定义Controller 的方法，你无需继承特定的类或实现特定的接口，只需使用@Controller 标记一个类是Controller ，然后使用@RequestMapping 和@RequestParam 等一些注解用以定义URL 请求和Controller 方法之间的映射，这样的Controller 就能被外界访问到。此外Controller 不会直接依赖于HttpServletRequest 和HttpServletResponse 等HttpServlet 对象，它们可以通过Controller 的方法参数灵活的获取到。

​		@Controller 用于标记在一个类上，使用它标记的类就是一个Spring MVC Controller 对象。分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了@RequestMapping 注解。@Controller 只是定义了一个控制器类，而使用@RequestMapping 注解的方法才是真正处理请求的处理器。单单使用@Controller 标记在一个类上还不能真正意义上的说它就是Spring MVC 的一个控制器类，因为这个时候Spring 还不认识它。那么要如何做Spring 才能认识它呢？这个时候就需要我们把这个控制器类交给Spring 来管理。有两种方式：

- 在Spring MVC 的配置文件中定义MyController 的bean 对象。
- 在Spring MVC 的配置文件中告诉Spring 该到哪里去找标记为@Controller 的Controller 控制器。

### @RequestMapping注解的作用

RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。

RequestMapping注解有六个属性，下面我们把她分成三类进行说明（下面有相应示例）。

**value， method**

value： 指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；

method： 指定请求的method类型， GET、POST、PUT、DELETE等；

**consumes，produces**

consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;

produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

**params，headers**

params： 指定request中必须包含某些参数值是，才让该方法处理。

headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。

### @ResponseBody注解的作用

作用： 该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。

使用时机：返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；

### @PathVariable和@RequestParam的区别

请求路径上有个id的变量值，可以通过@PathVariable来获取 @RequestMapping(value = “/page/{id}”, method = RequestMethod.GET)

@RequestParam用来获得静态的URL请求入参 spring注解时action里用到。



