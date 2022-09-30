# TS

## 前言

### GitHub

[GitHub地址](https://github.com/microsoft/TypeScript)：81.8K Star

### 为什么要学习TS



1. vue2.x中的组件是通过声明的方式传入一系列option，和[TypeScript](https://so.csdn.net/so/search?q=TypeScript&spm=1001.2101.3001.7020)的结合需要通过一些装饰器的方式来做，虽然能实现功能，但是比较麻烦。
2. 而3.0修改了组件的声明方式，改成了类式的写法，这样使得和TypeScript的结合变得很容易。
3. 此外，vue的源码也改用了TypeScript来写。其实当代码的功能复杂之后，必须有一个静态类型系统来做一些辅助管理，如React使用的Flow，Angular使用的TypeScript。
4. 现在vue3.0也全面改用TypeScript来重写了，更是使得对外暴露的api更容易结合TypeScript。静态类型系统对于复杂代码的维护确实很有必要。
5. 因此，我觉得TS对于前端从业者也是一个必须的基本技能。

### 什么是TS

1. TypeScript 是 JavaScript 的一个超集，主要提供了类型系统和对 ES6 的支持，它由 Microsoft 开发，代码开源于 GitHub 上。它可以编译成纯 JavaScript。编译出来的 JavaScript 可以运行在任何浏览器上。TypeScript 编译工具可以运行在任何服务器和任何系统上。
2. TypeScript 是开源的。
3. 它的第一个版本发布于 2012 年 10 月，经历了多次更新后，现在已成为前端社区中不可忽视的力量，不仅在 Microsoft 内部得到广泛运用，而且 Angular2、Vue3 也都使用了 TypeScript 作为开发语言。

### TS优缺点

#### 优点：

1. TypeScript 是 JavaScript 的超集，.js 文件可以直接重命名为 .ts 即可
2. 即使没有显式的定义类型，也能够自动做出类型推论
3. 可以定义从简单到复杂的几乎一切类型
4. 即使 TypeScript 编译报错，也可以生成 JavaScript 文件
5. 兼容第三方库，即使第三方库不是用 TypeScript 写的，也可以编写单独的类型文件供 TypeScript 读取
6. 类型系统增加了代码的可读性和可维护性
7. 拥有活跃的社区，并且支持ES6规范

#### 不足：

1. 对没有接触过静态语言的同学有一定的学习成本，需要理解接口（Interfaces）、泛型（Generics）、类（Classes）、枚举类型（Enums）等概念
2. 短期可能会增加一些开发成本，毕竟要多写一些类型的定义，不过对于一个需要长期维护的项目，TypeScript 能够减少其维护成本
3. 集成到构建流程需要一些工作量
4. 可能和一些库结合的不是很完美



### 总结

TS是JS的**超集**，JS有的Ts都有，所以学习Ts，有必要



## 安装

1.  npm 安装

   ~~~bash
   npm config set registry https://registry.npmmirror.com
   ~~~

2. 安装 typescript：

   ~~~bash
   npm install -g typescript
   ~~~

3. 查看情况

   ~~~bash
   tsc -v
   ~~~



## 语法

### 基本数据

#### Number

```typescript
var num = new Number(value);
```

示例1

~~~typescript
console.log("TypeScript Number 属性: "); 
console.log("最大值为: " + Number.MAX_VALUE); 
console.log("最小值为: " + Number.MIN_VALUE); 
console.log("负无穷大: " + Number.NEGATIVE_INFINITY); 
console.log("正无穷大:" + Number.POSITIVE_INFINITY);
~~~

Nav 示例

~~~typescript
var month = 0 
if( month<=0 || month >12) { 
    month = Number.NaN 
    console.log("月份是："+ month) 
} else { 
    console.log("输入月份数值正确。") 
}
~~~

prototype 实例

~~~typescript
function employee(id:number,name:string) { 
    this.id = id 
    this.name = name 
} 
 
var emp = new employee(123,"admin") 
employee.prototype.email = "admin@runoob.com" 
 
console.log("员工号: "+emp.id) 
console.log("员工姓名: "+emp.name) 
console.log("员工邮箱: "+emp.email)
~~~





#### String

#### Boolean

#### 数组

#### 元组

#### 枚举

#### null

### 变量声明

1. var

### 运算

- 算术运算符
- 逻辑运算符
- 关系运算符
- 按位运算符
- 赋值运算符
- 三元/条件运算符
- 字符串运算符
- 类型运算符

### 条件语句

- **if 语句** - 只有当指定条件为 true 时，使用该语句来执行代码
- **if...else 语句** - 当条件为 true 时执行代码，当条件为 false 时执行其他代码
- **if...else if....else 语句**- 使用该语句来选择多个代码块之一来执行
- **switch 语句** - 使用该语句来选择多个代码块之一来执行

### 循环

1. for

2. for...in

3. do...while

4. break

5. continue

6. 无限循环

   1. ```typescript
      while(true) {} 
      ```

   2. ```typescript
      for(;;) { }
      ```

### 函数

#### 函数定义

~~~typescript
function function_name()
{
    // 执行代码
}
~~~

#### 调用函数

~~~typescript
function test() {   // 函数定义
    console.log("调用函数") 
} 
test()   // 调用函数
~~~



#### 函数返回值

~~~typescript
function function_name():return_type { 
    // 语句
    return value; 
}
~~~

#### 带参数函数

~~~typescript
function add(x: number, y: number): number {
    return x + y;
}
console.log(add(1,2))
~~~

#### 可选参数和默认参数

~~~typescript
function buildName(firstName: string, lastName: string) {
    return firstName + " " + lastName;
}
 
let result1 = buildName("Bob");                  // 错误，缺少参数
let result2 = buildName("Bob", "Adams", "Sr.");  // 错误，参数太多了
let result3 = buildName("Bob", "Adams");         // 正确
~~~

#### 默认参数

~~~~typescript
function calculate_discount(price:number,rate:number = 0.50) { 
    var discount = price * rate; 
    console.log("计算结果: ",discount); 
} 
calculate_discount(1000) 
calculate_discount(1000,0.30)
~~~~

#### 剩余参数

~~~typescript
function buildName(firstName: string, ...restOfName: string[]) {
    return firstName + " " + restOfName.join(" ");
}
  
let employeeName = buildName("Joseph", "Samuel", "Lucas", "MacKinzie");
~~~

#### 匿名函数

~~~typescript
var msg = function() { 
    return "hello world";  
} 
console.log(msg())
~~~

#### 匿名函数自调用

~~~typescript
(function () { 
    var x = "Hello!!";   
    console.log(x)     
 })()
~~~

#### 构造函数

~~~typescript
var myFunction = new Function("a", "b", "return a * b"); 
var x = myFunction(4, 3); 
console.log(x);
~~~



### Map对象

~~~~typescript
let myMap = new Map();

let myMap = new Map([
        ["key1", "value1"],
        ["key2", "value2"]
    ]); 

~~~~

Map 相关的函数与属性：

- **map.clear()** – 移除 Map 对象的所有键/值对 。
- **map.set()** – 设置键值对，返回该 Map 对象。
- **map.get()** – 返回键对应的值，如果不存在，则返回 undefined。
- **map.has()** – 返回一个布尔值，用于判断 Map 中是否包含键对应的值。
- **map.delete()** – 删除 Map 中的元素，删除成功返回 true，失败返回 false。
- **map.size** – 返回 Map 对象键/值对的数量。
- **map.keys()** - 返回一个 Iterator 对象， 包含了 Map 对象中每个元素的键 。
- **map.values()** – 返回一个新的Iterator对象，包含了Map对象中每个元素的值 。



### 接口

~~~typescript
interface IPerson { 
    firstName:string, 
    lastName:string, 
    sayHi: ()=>string 
} 
 
var customer:IPerson = { 
    firstName:"Tom",
    lastName:"Hanks", 
    sayHi: ():string =>{return "Hi there"} 
} 
 
console.log("Customer 对象 ") 
console.log(customer.firstName) 
console.log(customer.lastName) 
console.log(customer.sayHi())  
 
var employee:IPerson = { 
    firstName:"Jim",
    lastName:"Blakes", 
    sayHi: ():string =>{return "Hello!!!"} 
} 
 
console.log("Employee  对象 ") 
console.log(employee.firstName) 
console.log(employee.lastName)
~~~

需要注意接口不能转换为 JavaScript。 它只是 TypeScript 的一部分。

编译以上代码，得到以下 JavaScript 代码：

~~~javascript
var customer = {
    firstName: "Tom",
    lastName: "Hanks",
    sayHi: function () { return "Hi there"; }
};
console.log("Customer 对象 ");
console.log(customer.firstName);
console.log(customer.lastName);
console.log(customer.sayHi());
var employee = {
    firstName: "Jim",
    lastName: "Blakes",
    sayHi: function () { return "Hello!!!"; }
};
console.log("Employee  对象 ");
console.log(employee.firstName);
console.log(employee.lastName);
~~~

### 类

~~~typescript
class Car { 
    // 字段 
    engine:string; 
 
    // 构造函数 
    constructor(engine:string) { 
        this.engine = engine 
    }  
 
    // 方法 
    disp():void { 
        console.log("发动机为 :   "+this.engine) 
    } 
}
~~~



### 对象

~~~typescript
var sites = { 
   site1:"Runoob", 
   site2:"Google" 
}; 
// 访问对象的值
console.log(sites.site1) 
console.log(sites.site2)
~~~



### 命名空间

命名空间一个最明确的目的就是解决重名问题。

~~~typescript
namespace Drawing { 
    export interface IShape { 
        draw(); 
    }
}



// <reference path = "IShape.ts" /> 
namespace Drawing { 
    export class Circle implements IShape { 
        public draw() { 
            console.log("Circle is drawn"); 
        }  
    }
}   
    
    /// <reference path = "IShape.ts" /> 
namespace Drawing { 
    export class Triangle implements IShape { 
        public draw() { 
            console.log("Triangle is drawn"); 
        } 
    } 
}
~~~



### 模块

TypeScript 模块的设计理念是可以更换的组织代码。

模块是在其自身的作用域里执行，并不是在全局作用域，这意味着定义在模块里面的变量、函数和类等在模块外部是不可见的，除非明确地使用 export 导出它们。类似地，我们必须通过 import 导入其他模块导出的变量、函数、类等。

两个模块之间的关系是通过在文件级别上使用 import 和 export 建立的。

~~~typescript
import someInterfaceRef = require("./SomeInterface");

/// <reference path = "IShape.ts" /> 
export interface IShape { 
   draw(); 
}
~~~



### 声明文件

1. 第三方演示库：CalcThirdPartyJsLib.js 

   ~~~javascript
   var Runoob;  
   (function(Runoob) {
       var Calc = (function () { 
           function Calc() { 
           } 
       })
       Calc.prototype.doSum = function (limit) {
           var sum = 0; 
    
           for (var i = 0; i <= limit; i++) { 
               sum = sum + i; 
           }
           return sum; 
       }
       Runoob.Calc = Calc; 
       return Calc; 
   })(Runoob || (Runoob = {})); 
   var test = new Runoob.Calc();
   ~~~

2. 如果我们想在 TypeScript 中引用上面的代码，则需要设置声明文件 Calc.d.ts，代码如下：

   ~~~typescript
   declare module Runoob { 
      export class Calc { 
         doSum(limit:number) : number; 
      }
   }
   ~~~

3. 声明文件不包含实现，它只是类型声明，把声明文件加入到 TypeScript 中：

   ~~~typescript
   /// <reference path = "Calc.d.ts" /> 
   var obj = new Runoob.Calc(); 
   // obj.doSum("Hello"); // 编译错误
   console.log(obj.doSum(10));
   ~~~

4. 下面这行导致编译错误，因为我们需要传入数字参数：

   ~~~typescript
   obj.doSum("Hello");
   ~~~

5. 使用 tsc 命令来编译以上代码文件：

   ~~~typescript
   tsc CalcTest.ts
   ~~~

6. 生成的 JavaScript 代码如下：

   ~~~javascript
   /// <reference path = "Calc.d.ts" /> 
   var obj = new Runoob.Calc();
   //obj.doSum("Hello"); // 编译错误
   console.log(obj.doSum(10));
   ~~~

7. 最后我们编写一个 runoob.html 文件，引入 CalcTest.js 文件及第三方库 CalcThirdPartyJsLib.js：

   ~~~html
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="utf-8">
   <title>菜鸟教程(runoob.com)</title>
   <script src = "CalcThirdPartyJsLib.js"></script> 
   <script src = "CalcTest.js"></script> 
   </head>
   <body>
       <h1>声明文件测试</h1>
       <p>菜鸟测试一下。</p>
   </body>
   </html>
   ~~~

   