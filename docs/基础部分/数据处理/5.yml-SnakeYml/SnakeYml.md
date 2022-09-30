# Snake Yml

## 前言

1. Properties：我们学习 Java，都是先介绍 properties 文件，使用 properties 文件配合对象能够很方便的适用于应用配置上。
2. Properties 格式在表现层级关系和结构关系的时候，十分欠缺，而 Xml 在数据格式描述和较复杂数据内容展示方面，更加优秀。
3. Json：Json 格式比较 Xml 格式，更加方便（除去数据格式限制之外）所以现在很多配置文件（比如 Nginx 和大部分脚本语言的配置文件）都习惯使用 Json 的方式来完成，包括 Springboot 的出现目的也是在一定程度上去掉 Xml 的繁琐配置。
4. Yml：对于较复杂的数据结构来说，Yml 又远远优于 properties

## 简单使用

1. 依赖

~~~xml
<dependency>
    <groupId>org.yaml</groupId>
    <artifactId>snakeyaml</artifactId>
    <version>1.17</version>
</dependency>
~~~

2. 简单格式

~~~yaml
mybatis-filepath: xml\\mybatis-config.xml

  # 程序运行状态
saic-company-appId: 123456
saic-company-apiUrl: http://localhost:8001/EE/saicComp
saic-company-appKey: testCompanySaic
saic-individual-appId: 123456
saic-individual-apiUrl: http://localhost:8001/EE/saicIndi
saic-individual-appKey: testCompanySaic

a:
  b:
    c: 就是我
    d: 不是我
    e: 123456
    f:
    - haha
    - xixi
    - yuanyuan
~~~

3. 读取工具

~~~java
package Yml;

import lombok.Data;
import org.yaml.snakeyaml.Yaml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class YmlUtils {
    static Map<String,Object> configMap = new HashMap<>();
    static Yaml yaml = new Yaml();
    static {
        Map<String, Object> ret = (Map<String, Object>) yaml.load(yaml
                .getClass().getClassLoader().getResourceAsStream("application.yml"));
        configMap = ret;
    }

    /**
     * 获取最终的String值
     * @param configPath
     * @return
     */
    public static String getConfigStr(String configPath){
        String[] split = configPath.split("\\.");
        Map<String,Object> tempConfig = configMap;
        for (int i = 0; i < split.length; i++) {
            if (i<(split.length-1)){
                tempConfig = (Map<String, Object>)tempConfig.get(split[i]);
            }
            if (i==(split.length-1)){
                return tempConfig.get(split[i]).toString();
            }
        }
        return null;
    }

    /**
     * 获取配置对象
     * @param configPath
     * @return
     */
    public static Object getConfigObj(String configPath){
        String[] split = configPath.split("\\.");
        Map<String,Object> tempConfig = configMap;
        for (int i = 0; i < split.length; i++) {
            tempConfig = (Map<String, Object>)tempConfig.get(split[i]);
        }
        return tempConfig;
    }


    /**
     * 获取配置数组
     * @param configPath
     * @return
     */
    public static Object getConfigArr(String configPath){
        String[] split = configPath.split("\\.");
        List<Object> res = new ArrayList<>();
        Map<String,Object> tempConfig = configMap;
        for (int i = 0; i < split.length; i++) {
            if (i<(split.length-1)){
                tempConfig = (Map<String, Object>)tempConfig.get(split[i]);
            }else{
                return tempConfig.get(split[i]);
            }
        }
        return res;
    }
}

~~~

4. 测试类

~~~java
package Yml;

public class Test {
    public static void main(String[] args) {
        System.out.println(YmlUtils.configMap);
        System.out.println(YmlUtils.getConfig("a.b.c"));
        System.out.println(YmlUtils.getConfig("a.b.d"));
        System.out.println(YmlUtils.getConfig("a.b.e"));
    }
}

~~~

5. 测试结果

~~~bash
{mybatis-filepath=xml\\mybatis-config.xml, saic-company-appId=123456, saic-company-apiUrl=http://localhost:8001/EE/saicComp, saic-company-appKey=testCompanySaic, saic-individual-appId=123456, saic-individual-apiUrl=http://localhost:8001/EE/saicIndi, saic-individual-appKey=testCompanySaic, a={b={c=就是我, d=不是我, e=123456, f=[haha, xixi, yuanyuan]}}}
就是我
不是我
123456
{c=就是我, d=不是我, e=123456, f=[haha, xixi, yuanyuan]}
[haha, xixi, yuanyuan]
~~~





## YML讲解

​		相对于XML和JSON，YAML更容易被人阅读和编写，所以在存储信息时使用的更为广泛。但是YAML有着严格的缩进标准，不适合在不同设备中携带传递。

### 文件

1. 下面立刻展示YAML最基本，最常用的一些使用格式：
2. 首先YAML中允许表示三种格式，分别是常量值，对象和数组
3. 例如：

~~~yaml
#即表示url属性值；
url: http://www.wolfcode.cn 
#即表示server.host属性的值；
server:
    host: http://www.wolfcode.cn 
#数组，即表示server为[a,b,c]
server:
    - 120.168.117.21
    - 120.168.117.22
    - 120.168.117.23
#常量
pi: 3.14   #定义一个数值3.14
hasChild: true  #定义一个boolean值
name: '你好YAML'   #定义一个字符串
~~~

### 基本格式要求

~~~bash
1，YAML大小写敏感；
2，使用缩进代表层级关系；
3，缩进只能使用空格，不能使用TAB，不要求空格个数，只需要相同层级左对齐（一般2个或4个空格）对象
~~~

### 相对复杂结构

~~~yml
companies:
  -
    id: 1
    name: company1
    price: 200W
  -
    id: 2
    name: company2
    price: 500W
~~~

### 常量

~~~bash
boolean: 
    - TRUE  #true,True都可以
    - FALSE  #false，False都可以
float:
    - 3.14
    - 6.8523015e+5  #可以使用科学计数法
int:
    - 123
    - 0b1010_0111_0100_1010_1110    #二进制表示
null:
    nodeName: 'node'
    parent: ~  #使用~表示null
string:
    - 哈哈
    - 'Hello world'  #可以使用双引号或者单引号包裹特殊字符
    - newline
      newline2    #字符串可以拆成多行，每一行会被转化成一个空格
date:
    - 2018-02-17    #日期必须使用ISO 8601格式，即yyyy-MM-dd
datetime: 
    -  2018-02-17T15:02:31+08:00    #时间使用ISO 8601格式，时间和日期之间使用T连接，最后使用+代表时区

~~~





## Snake使用



