# protobuf

## 概述

1. protocol buffers 是一种灵活，高效，自动化机制的结构数据[序列化](https://so.csdn.net/so/search?q=序列化&spm=1001.2101.3001.7020)方法
2. 可类比 XML，但是比 XML 更小、更快、更为简单。
   1. 更简单
   2. 小 3 ~ 10 倍
   3. 快 20 ~ 100 倍
   4. 更加清晰明确
   5. 自动生成更易于以编程方式使用的数据访问类



## 特点

1. 一种二进制数据交换格式。可以将 C++ 中定义的存储类的内容与二进制序列串相互转换，主要用于数据传输或保存
2. 定义了一种源文件，扩展名为 `.proto`(类比`.cpp`文件)，使用这种源文件，可以定义存储类的内容
3. protobuf有自己的编译器`protoc`，可以将 `.proto` 编译成`.cc`文件，使之成为一个可以在 `C++` 工程中直接使用的类



## 语法

### proto文件的实例：

~~~~protobuf
syntax = "proto3";

import "address.proto";

package com.study.blog.protobuf;
option java_package = "com.study.blog.protobuf";/
option java_outer_classname="PersonProto";
option java_multiple_files = true;
option java_generic_services = true;
option optimize_for = SPEED;

/*
1、import "address.proto"; //引入其他的proto文件，如果是其他文件夹的文件也不需要加路径，
只需要在生成代码时，选择proto文件的扫描范围时，需要将所有导入proro文件都包含在内。
通过--proto_path属性指定。

2、package com.study.blog.protobuf;  proto文件的命名空间

3、option java_package = "com.study.blog.protobuf";//生成代码后的命令空间

4、option java_outer_classname="Person"; //这个名字不能与下文的message名字冲突，
Person已经是一个message类型，就不能作为ClassName

5、option java_multiple_files = true; //如果为true，每个message和service都会被生成为一个类。
如果是false，则所有的message和service都将会是java_outer_classname的内部类

6、option java_generic_services = true; //是否生成Service,如果这个属性为false，
将不会生成Service的代码，即使已经在proto文件编写了service结构

7、option optimize_for = SPEED;//对生成的代码的一种优化，有三个值:SPEED,  CODE_SIZE, LITE_RUNTIME;
表示希望生成代码是偏向执行速度，还是生成的文件大小，如果在app端，代码文件的大小是很重要的。
*/

message Person{
    enum PhoneType{ //枚举类型
        option allow_alias = true; //允许设置别名，意味着等号后面的数字（标记数字）可以重复
        HOME=0;
        MOBILE=1;
        WORK=2; //实际上只是为同一个值增加了一个别名，生成代码后的格式是work = company
        COMPANY =2;
    }

    //消息类型内嵌，在消息体内部可以直接引用。如果在外层消息体中引用，格式是：Person.PhoneNumber;
    message PhoneNumber{
        PhoneType type=1;
        string phoneNumber=2;
    }

    string name =1; //string
    int32 age =2;  //Integer
    int64 ageBySeconds=3 [deprecated=true];  //long,deprecated表示属性已过时，不建议再使用，一般是文件更新时使用。
    bool isMarry=4;  //boolean
    double hight = 5; //double
    float weight =6; //float
    repeated string position = 7; //由于repeated关键字修饰，这个属性将会生成一个集合
    map<string,string> email=8; //map类型的key不能是枚举类型(enum)

    /*引用其他proto文件的message；需要在引入的message前面加上被引入
    的proto文件的package的值，即Proto文件的命名空间*/
    com.study.blog.protobuf.Address address=10;

    oneof Profession{  //在使用时，下面的三个值，只能有一个值生效
        string math=11; //以最后一次设置的值为准，如果最后一次设置的值为math，那么Profession的值就是math
        string compute=12;//如果最后一次设置的值为compute，那么Profession的值就是compute
        string chemistry=13;
    }
    PhoneNumber phoneNumber=14;
}

message PersonRequest{
   string name=1;
   int32 age=2;
   Person.PhoneNumber phonenumber=3; //引起其他消息体中的内嵌消息体
}

message PersonResponse{
    string id=1;
    Person person=2;
}

/*定义Rpc的Service,这里需要注意:下面的方法的传入参数和返回类型都必须是message，
不能是string,int32等原始类型*/
service PersonService{
    rpc getFirstPersonInfo(PersonRequest) returns (PersonResponse){}
    rpc getPersonList(PersonRequest) returns (stream PersonResponse){}
    rpc savePerson(stream PersonRequest) returns (PersonResponse){}
    rpc updatePerson(stream PersonRequest) returns (stream PersonResponse){}
}
~~~~



### 代码生成


1. 下载proto编译器，下载链接： [windows版本](https://github.com/google/protobuf/releases/download/v3.5.1/protoc-3.5.1-win32.zip)， [linux-64](https://github.com/google/protobuf/releases/download/v3.5.1/protoc-3.5.1-linux-x86_64.zip)
2. 下载后，将其进行解压。然后配置path环境变量，环境变量指向{加压路径}/bin
3. 使用如下命令生成代码：

~~~bash
protoc --proto_path=src/main/proto --proto_path=src/main/protocbuf  
       --java_out=src/main/java src/main/proto/person.proto  src/main/proto/address.proto
说明：
	--proto_path,用于指定proto文件的扫描范围，可以指定多次
	--java_out,后面接了三个路径；第一个路径是生成代码的存放路径，第二个和第三个路径是需要生成代码的proto文件

~~~



### 代码使用

~~~java
package com.study.blog.protobuf;
 
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
 
/**
 * Created by zhang on 2018/2/4.
 */
public class TestMain {
    public static void main(String[] args) {
        //创建一个address
        AddressInfo.Address address = AddressInfo.Address.newBuilder()
                .setName("home_address")
                .setType(AddressInfo.Address.AddressType.HOME)
                .setDetail("tianjing_Road_123")
                .build();
 
        //创建PhoneNumber
        Person.PhoneNumber phoneNumber = Person.PhoneNumber.newBuilder()
                .setPhoneNumber("2132342134123412")
                .setType(Person.PhoneType.WORK)
                .build();
 
        //创建一个Person
        Person person = Person.newBuilder()
                .setName("zhangsan")
                .setAge(23)
                .setAgeBySeconds(12L)
                .setIsMarry(false)
                .addPosition("teacher") //repeated，生成的代码是一个集合
                .addPosition("student")
                .addPosition("policeman")
                .setHight(176.23)
                .setWeight(Float.valueOf(12))
                .setAddress(address)
                .setPhoneNumber(phoneNumber) //内嵌类型
                .putEmail("QQ_email","12323123@qq.com") //map类型的赋值
                .putEmail("163_email","2412341234@163.com")
                .setMath("math")  //oneof关键字修饰的属性进行赋值，设置三次，只有最后一次生效了
                .setChemistry("chemistry")
                .setCompute("compute")
                .build();
        System.out.println(person);
    }
}
~~~



### 输出结果

~~~json
name: "zhangsan"
age: 23
ageBySeconds: 12
hight: 176.23
weight: 12.0
position: "teacher" //repeated修饰的属性
position: "student"
position: "policeman"
email { //map类型的属性
  key: "QQ_email"
  value: "12323123@qq.com"
}
email {  //map类型的属性
  key: "163_email"
  value: "2412341234@163.com"
}
address {
  name: "home_address"
  detail: "tianjing_Road_123"
}
compute: "compute"  //oneof修饰的属性，只有最后一次生效
phoneNumber {
  type: WORK
  phoneNumber: "2132342134123412"
}
~~~

