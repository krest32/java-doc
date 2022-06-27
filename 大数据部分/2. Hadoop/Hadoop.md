# Hadoop

## 概述

### hadoop 解决了什么问题？

1. 数据存储
2. 数据采集

### Hadoop 版本分类

1. Apache 免费
2. Cloudear 收费版

### 它的优势

1. 高可靠性： 维护了多个数据的可靠副本
2. 高扩展性，动态增加与删除：可以扩展数以千计的节点
3. 高效性：并行工作，加快任务的处理速度
4. 高容错性：能够将失败的任务进行自动迁移

### Hadoop的组成部分

1. 1.X版本
   1. map—reduce（计算+资源调度）
   2. HDFS
   3. Common （辅助工具类）
2. 2.X版本
   1. MapReduce 计算
   2. Yarn 资源调度
   3. HDFS
   4. Common
3. 3.X 版本

## 组件介绍

### **HDFS**

Hadoop分布式文件存储系统，处理海量数据

### Yarn

支持多个客户端访问，每个Node Manager 有多个可以运行的容器

1. Resource Manager -- 管理着所有Node Manager
2. Node Manager 管理者本机的资源
3. Application Master 单个任务的老大
4. Container 容器：任务运行的环境，也就是 Docker 了

### MapReduce

Map 阶段：对于大的任务进行拆分

Reduce 阶段：计算结果的汇总

## 关于Hadoop 生态圈

+ Hadoop是指Hadoop框架本身；
+ hadoop生态系统，不仅包含hadoop，还包括保证hadoop框架正常高效运行其他框架，比如
  + zookeeper、
  + Flume、
  + Hbase、
  + Hive、
  + Sqoop
  + ...等辅助框架。

### 数据传输

1. 结构化数据：Sqoop
2. 半结构化数据： Flume
3. 视频、ppt 等 ： Kafka

### 数据存储

1. HDFS

### 资源调度

1. yarn 

### 数据计算

1. 离线计算
   1. MapReduce
   2. Spark Core --> 内存计算
   3. Hive 数据查询

2. 实时计算
   1. Flink 很流行（重点）
   2. Spark Streaming
   3. Storm 已经过时

### 任务调度

1. Oozie
2. Azkaban

### 组件管理

zookeeper 

## 系统操作

### 环境安装

1. 安装虚拟机
2. 配置软件
   1. epel-release
   2. net-tool
   3. vim
3. 关闭防火墙 同时关闭开机启动
4. 创建用户，拥有相关权限
5. 安装Java环境
6. 安装Hadoop环境

### 运行模式

1. 本地
2. 伪分布式
3. 完全分布式

### 完全分布式搭建

1. 安装多台虚拟机
2. 配置JDK hadoop 在其中一台机器
   1. scp命令 实现服务器之间的数据拷贝
   2. rsync命令 实现服务器之间的数据同步
3. 远程通过脚本进行服务器之间的同步操作，SSH 远程登陆

## Hadoop集群需要启动哪些进程

1. NameNode：它是hadoop中的主服务器，管理文件系统名称空间和对集群中存储的文件的访问，保存有metadate。
2. SecondaryNameNode：它不是namenode的冗余守护进程，而是提供周期检查点和清理任务。帮助NN合并editslog，减少NN启动时间。
3. DataNode：它负责管理连接到节点的存储（一个集群中可以有多个节点）。每个存储数据的节点运行一个datanode守护进程。
4. ResourceManager（JobTracker）：JobTracker负责调度DataNode上的工作。每个DataNode有一个TaskTracker，它们执行实际工作。
5. NodeManager：（TaskTracker）执行任务。
6. DFSZKFailoverController：高可用时它负责监控NN的状态，并及时的把状态信息写入ZK。它通过一个独立线程周期性的调用NN上的一个特定接口来获取NN的健康状态。FC也有选择谁作为Active NN的权利，因为最多只有两个节点，目前选择策略还比较简单（先到先得，轮换）。
7. JournalNode：高可用情况下存放namenode的editlog文件。
   

## 常见面试题

### 搭建其他功能

1. 历史服务器
2. 日志聚集服务器
3. Node Manager
4. Resource Manager

### Hadoop运行的模式？

1. 单机版
2. 伪分布式
3. 完全分布式

### Hadoop的几个默认端口及其含义（5个）

1. dfs.namenode.http-address:50070
2. SecondaryNameNode辅助名称节点端口号：50090
3. dfs.datanode.address:50010
4. fs.defaultFS:8020 或者9000
5. yarn.resourcemanager.webapp.address:8088
   



# HDFS

## 概述

### HDFS产生的背景和定义

1. 用来存储文件，通过树形结构来定位文件
2. 适合一次写入，多次读取的情况
3. 分布式文件系统

### HDFS的优缺点

1. 优点
   1. 自动多个部分，提高容错
   2. 适合处理大数据
   3. 无关文件大小
   4. 可以构建在廉价的机器上，多副本，提高可靠性
2. 缺点
   1. 不适合低延时的数据访问
   2. 无法高效的存储小文件
   3. 小文件的寻址时间会超过读取时间，违反了HDFS的设计原则
   4. 不支持文件的并发写入、文件随机修改
   5. 仅支持数据追加、不支持文件的随机修改

### HDFS组成架构

架构主要由四个部分组成，分别为HDFS Client、NameNode、DataNode和Secondary NameNode。下面我们分别介绍这四个组成部分。

1. Client：就是客户端。
   1. 文件切分。文件上传HDFS的时候，Client将文件切分成一个一个的Block，然后进行存储；
   2. 与NameNode交互，获取文件的位置信息；
   3. 与DataNode交互，读取或者写入数据；
   4. Client提供一些命令来管理HDFS，比如启动或者关闭HDFS；
   5. Client可以通过一些命令来访问HDFS；
2. NameNode：就是Master，它是一个主管、管理者。
   1. 管理HDFS的名称空间；
   2. 管理数据块（Block）映射信息；
   3. 配置副本策略；
   4. 处理客户端读写请求。
3. DataNode：就是Slave。NameNode下达命令，DataNode执行实际的操作。
   1. 存储实际的数据块；
   2. 执行数据块的读/写操作。
4. Secondary NameNode：并非NameNode的热备。当NameNode挂掉的时候，它并不能马上替换NameNode并提供服务。
   1. 辅助NameNode，分担其工作量；
   2. 定期合并Fsimage和Edits，并推送给NameNode；
   3. 在紧急情况下，可辅助恢复NameNode。

## 

### 关于HDFS的文件块的大小

1. 默认大小Hadoop 2.x 3.x 是128M， 1.x 是64M
2. 如果寻址时间约为10ms， 即查找到目标的时间为10ms
3. 寻址时间为传输时间的1%时，为最佳状态
4. 目前磁盘的传输速率普遍为100MB/s
5. 所以文件快的大小 1s*100 MB/s = 100MB

1. 文件块不能设置的太小，也不能设置的太大
   1. 大小，程序会一直在寻址
   2. 太大，程序IO会一直阻塞

## Shell 相关操作（开发重点）

上传命令

~~~bash
# 建立sanguo文件夹
hadoop fs -mkdir /sanguo

# 上传类
cat 123>123.txt
# 上传本地文件到HDFS -- 会删除本地文件 
hadoop fs -movefromLocal ./12.txt /sanguo
# 拷贝 -- 不会删除本地文件
hadoop fs -copyFromLocal ./123.txt /sanguo 
# put 等同于 cpoyFromLocal
# appendToFile
vim liubei.txt
hadoop fs - appendToFile .123.txt /sanguo/123.txt



~~~

下载命令

~~~bash
hadoop fs -copyToLocal /sanguo/123.txt 12345.txrt
hadoop fs -get /sanguo/123.txt ./1234.txt
~~~

直接操作HDFS

~~~bash
# 查看文件夹
hadoop fs -ls /sanguo
hadoop fs -cat /sanguo/123.txt

# 修改权限
hadoop fs -chmod 666 /sanguo/123.txt
# 修改用户组
hadoop fs -chmod krest:krest /sanguo/123.txt

# 拷贝
hadoop fs -cp /sanguo/123.txt /jinguo
# 移动
hadoop fs -mv /sanguo/123.txt /jinguo
# 显示文件末尾1kb的内容
hadoop fs -tail /sanguo/123.txt
# 删除
hadoop fs -rm /sanguo/123.txt
# 删除文件夹及其子文件内容
hadoop fs -rm -r /sanguo

# 统计文件夹的大小信息
hadoop fs -du -s -h /sanguo
# 统计每个文件的大小
hadoop fs -du -s /sanguo
~~~

## HDFS API

可以使用 Windows 客户端操作HDFS 文件，

Idea 编写代码操作 HDFS

**导入依赖**

~~~xml
 <dependencies>
        <dependency>
            <groupId>org.apache.hadoop</groupId>
            <artifactId>hadoop-client</artifactId>
            <version>3.1.3</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </dependency>
    </dependencies>
~~~

**测试代码**

~~~java
package com.krest.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class HDFSClient {
	
    private FileSystem fs;

    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI("hdfs://hadoop102:8020");
        Configuration config = new Configuration();
        String user = "krest";
        fs = FileSystem.get(uri, config, user);

    }

    @After
    public void close() throws IOException {
        fs.close();
    }

    @Test
    public void mkdir() throws URISyntaxException, IOException, InterruptedException {
        fs.mkdirs(new Path("xityou/huaguoshan"));
    }
}
~~~

## 读写流程（面试重点）

### 文件写入

1. 客户端通过Distributed FileSystem模块向NameNode请求上传文件，NameNode检查目标文件是否已存在，父目录是否存在
2. NameNode返回是否可以上传。
3. 客户端请求第一个 Block上传到哪几个DataNode服务器上。
4. NameNode返回3个DataNode节点，分别为dn1、dn2、dn3。
5. 客户端通过FSDataOutputStream模块请求dn1上传数据，dn1收到请求会继续调用dn2，然后dn2调用dn3，将这个通信管道建立完成。
6. dn1、dn2、dn3逐级应答客户端。
7. 客户端开始往dn1上传第一个Block（先从磁盘读取数据放到一个本地内存缓存），以Packet为单位，dn1收到一个Packet就会传给dn2，dn2传给dn3；dn1每传一个packet会放入一个应答队列等待应答。
8. 当一个Block传输完成之后，客户端再次请求NameNode上传第二个Block的服务器。（重复执行3-7步）。

### 网络拓扑-节点距离计算

​		在HDFS写数据的过程中，NameNode会选择距离待上传数据最近距离的DataNode接收数据。那么这个最近距离怎么计算呢？

节点距离：两个节点到达最近的共同祖先的距离总和。

​		例如，假设有数据中心d1机架r1中的节点n1。该节点可以表示为/d1/r1/n1。利用这种标记，这里给出四种距离描述。

​		大家算一算每两个节点之间的距离。

### HDFS读数据流程

1. 客户端通过DistributedFileSystem向NameNode请求下载文件，NameNode通过查询元数据，找到文件块所在的DataNode地址。
2. 挑选一台DataNode（就近原则，然后随机）服务器，请求读取数据。
3. DataNode开始传输数据给客户端（从磁盘里面读取数据输入流，以Packet为单位来做校验）。
4. 客户端以Packet为单位接收，先在本地缓存，然后写入目标文件。

## secondary namenode工作机制

1. 第一阶段：NameNode启动
   1. 第一次启动NameNode格式化后，创建fsimage和edits文件。如果不是第一次启动，直接加载编辑日志和镜像文件到内存。
   2. 客户端对元数据进行增删改的请求。
   3. NameNode记录操作日志，更新滚动日志。
   4. NameNode在内存中对数据进行增删改查。
2. 第二阶段：Secondary NameNode工作
       1. Secondary NameNode询问NameNode是否需要checkpoint。直接带回NameNode是否检查结果。
         2. Secondary NameNode请求执行checkpoint。
           3. NameNode滚动正在写的edits日志。
             4. 将滚动前的编辑日志和镜像文件拷贝到Secondary NameNode。
               5. Secondary NameNode加载编辑日志和镜像文件到内存，并合并。
                 6. 生成新的镜像文件fsimage.chkpoint。
                   7. 拷贝fsimage.chkpoint到NameNode。
                     8. NameNode将fsimage.chkpoint重新命名成fsimage。

## NameNode与SecondaryNameNode 的区别与联系？

1. 区别
   1. NameNode负责管理整个文件系统的元数据，以及每一个路径（文件）所对应的数据块信息。
   2. SecondaryNameNode主要用于定期合并命名空间镜像和命名空间镜像的编辑日志。
2. 联系：
   1. SecondaryNameNode中保存了一份和namenode一致的镜像文件（fsimage）和编辑日志（edits）。
   2. 在主namenode发生故障时（假设没有及时备份数据），可以从SecondaryNameNode恢复数据。

## 其他 

### block 默认保存几份？

 默认保存3份

### HDFS 默认 BlockSize 是多大？
  在Hadoop2.7版本之前是64MB,之后就改为了128MB

### 负责HDFS数据存储的是哪一部分？
  DataNode负责数据存储

### SecondaryNameNode的目的是什么？
  他的目的使帮助NameNode合并编辑日志，减少NameNode 二次启动时间，备份数据

### 文件大小设置，增大有什么影响？
1. HDFS中的文件在物理上是分块存储（block），块的大小可以通过配置参数( dfs.blocksize)来规定，默认大小在hadoop2.x版本中是128M，老版本中是64M。  
2. 思考：为什么块的大小不能设置的太小，也不能设置的太大? 
   1. HDFS的块比磁盘的块大，其目的是为了最小化寻址开销。如果块设置得足够大，从磁盘传输数据的时间会明显大于定位这个块开始位置所需的时间。
   2. 因而，传输一个由多个块组成的文件的时间取决于磁盘传输速率。
   3. 如果寻址时间约为10ms，而传输速率为100MB/s，为了使寻址时间仅占传输时间的1%，我们要将块大小设置约为100MB。默认的块大小128MB。
      1. 块的大小：10ms×100×100M/s = 100M
      2. 增加文件块大小，需要增加磁盘的传输速率。

### hadoop的块大小，从哪个版本开始是128M
  Hadoop1.x都是64M，hadoop2.x开始都是128M。



### HDFS小文件优化方法

1. HDFS小文件弊端：
   1. HDFS上每个文件都要在namenode上建立一个索引，这个索引的大小约为150byte，这样当小文件比较多的时候，就会产生很多的索引文件，一方面会大量占用namenode的内存空间，另一方面就是索引文件过大是的索引速度变慢。
2. 解决的方式：
   1. Hadoop本身提供了一些文件压缩的方案。
   2. 从系统层面改变现有HDFS存在的问题，其实主要还是小文件的合并，然后建立比较快速的索引。
3. Hadoop自带小文件解决方案
   1. Hadoop Archive：
      是一个高效地将小文件放入HDFS块中的文件存档工具，它能够将多个小文件打包成一个HAR文件，这样在减少namenode内存使用的同时。
   2. Sequence file：
      sequence file由一系列的二进制key/value组成，如果为key小文件名，value为文件内容，则可以将大批小文件合并成一个大文件。
   3. combineFileInputFormat：
      CombineFileInputFormat是一种新的inputformat，用于将多个文件合并成一个单独的split，另外，它会考虑数据的存储位置。

### hadoop1与hadoop2 的架构异同

1. 加入了yarn解决了资源调度的问题。
2. 加入了对zookeeper的支持实现比较可靠的高可用。

# MapReduce

## 概述

分布式运算框架

![在这里插入图片描述](img/20200729201916243.png)

![img](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2xpaHVhemFpemhlbGk=,size_16,color_FFFFFF,t_70.jpeg)

### 优缺点是什么？

**优点**：

1. MapReduce易于编程：
2. 它简单的实现一些接口，就可以完成一个分布式程序，这个分布式程序可以分布到大量廉价的PC机器上运行。也就是说你写一个分布式程序，跟写一个简单的串行程序是一模一样的。就是因为这个特点使得MapReduce编程变得非常流行。

2. 良好的扩展性：当你的计算资源不能得到满足的时候，你可以通过简单的增加机器来扩展它的计算能力。

3. 高容错性：MapReduce设计的初衷就是使程序能够部署在廉价的PC机器上，这就要求它具有很高的容错性。比如其中一台机器挂了，它可以把上面的计算任务转移到另外一个节点上运行，不至于这个任务运行失败，而且这个过程不需要人工参与，而完全是由Hadoop内部完成的。

4. 适合PB级以上海量数据的离线处理：可以实现上千台服务器集群并发工作，提供数据处理能力。

**缺点**：

1. 不擅长实时计算
2. 不擅长流式计算
3. 不擅长DAG有向无环图计算：Spark 擅长

### 核心思想是什么？

1. 分布式的运算程序往往需要分成至少2个阶段
2. 第一个阶段的MapTask并发实例，完全并行运行，互不相干。
3. 第二个阶段的ReduceTask并发实例互不相干，但是他们的数据依赖于上一个阶段的所有MapTask并发实例的输出。
4. MapReduce编程模型只能包含一个Map阶段和一个Reduce阶段，如果用户的业务逻辑非常复杂，那就只能多个MapReduce程序，串行运行。

### MapReduce进程

 **一个完整的MapReduce程序在分布式运行时有三类实例进程**：

1. **MrAppMaster**：负责整个程序的过程调度及状态协调。
2. **MapTask**：负责Map阶段的整个数据处理流程。
3. **ReduceTask**：负责Reduce阶段的整个数据处理流程。

## MapReduce 变成规范

### Mapper 阶段

1. 用户自定义的Mapper要继承自己的父类

![img](img/20210505100503204.png)

2. Mapper的输入数据是KV对的形式（KV的类型可自定义）

> p.s. K是这一行的偏移量，V是这一行的内容。

3. Mapper中的业务逻辑写在map()方法中

![在这里插入图片描述](img/20210505100423915.png)

4. Mapper的输出数据是KV对的形式（KV的类型可自定义）
5. map()方法（MapTask进程）对每一个<K,V>调用一次

### Reducer阶段

1. 用户自定义的Reducer要继承自己的父类

![img](img/20210505100527982.png)

2. Reducer的输入数据类型对应Mapper的输出数据类型，也是KV
3. Reducer的业务逻辑写在reduce()方法中

![img](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L20wXzQ2NDEzMDY1,size_16,color_FFFFFF,t_70.png)

4. ReduceTask进程对每一组相同k的<k,v>组调用一次reduce()方法

### Driver阶段

相当于YARN集群的客户端，用于提交我们整个程序到YARN集群，提交的是封装了MapReduce程序相关运行参数的job对象



## WordCount 实例

### 需求

1. 在给定的文本文件中统计输出每一个单词出现的总次数

### 流程分析

按照 MapReduce 编程规范，分别编写 Mapper，Reducer，Driver。流程分析

1. 输入文本数据

2. Mapper阶段

   1. 将我们的问题内容转化为String

   2. 根据空格将这一行切分为一个个的单词

   3. 将单词输出为KV的形式

      ~~~java
      如 
      atgugui,1
      itheima,1
      ~~~

3. Reducer阶段

   1. 汇总各个Key的个数
   2. 输出该Key的总次数

4. Driver阶段

   1. 获取配置信息，获取Job对象实例
   2. 制定本程序的Jar包所在的本地路径
   3. 关联Mapper、Reduce业务类
   4. 指定Mapper输出数据的KV类型
   5. 指定最终输出的数据的KV类型
   6. 指定Job的输入原始文件所在目录
   7. 指定Job的输出结果所在目录
   8. 提交作业

### 核心代码

#### 创建Maven工程

#### 导入相关依赖

~~~xml
<properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <encoding>UTF-8</encoding>
</properties>

<dependencies> 
    <dependency> 
        <groupId>org.apache.hadoop</groupId> 
        <artifactId>hadoop-client</artifactId> 
        <version>3.1.3</version> 
    </dependency> 
    <dependency> 
        <groupId>junit</groupId> 
        <artifactId>junit</artifactId> 
        <version>4.12</version> 
    </dependency> 
    <dependency> 
        <groupId>org.slf4j</groupId> 
        <artifactId>slf4j-log4j12</artifactId> 
        <version>1.7.30</version> 
    </dependency> 
</dependencies> 

~~~

#### 编写 Mapper 类

~~~java
package com.leokadia.mapreduce.wordcount;
/**
 * @author sa
 * @create 2021-05-05 10:46
 */
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/**
 * KEYIN, map阶段输入的key的类型：LongWritable
 * VALUEIN,map阶段输入value类型：Text
 * KEYOUT,map阶段输出的Key类型：Text
 * VALUEOUT,map阶段输出的value类型：IntWritable
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text outK = new Text();
    private IntWritable outV = new IntWritable(1);  //map阶段不进行聚合

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 1 获取一行
        // xxxxxx xxxxxx
        String line = value.toString();

        // 2 切割(取决于原始数据的中间分隔符)
        String[] words = line.split(" ");

        // 3 循环写出
        for (String word : words) {
            // 封装outk
            outK.set(word);
            // 写出
            context.write(outK, outV);
        }
    }
}

~~~

#### 编写 Reducer 类

~~~java
package com.leokadia.mapreduce.wordcount;

/**
 * @author sa
 * @create 2021-05-05 10:47
 */
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * KEYIN, reduce阶段输入的key的类型：Text
 * VALUEIN,reduce阶段输入value类型：IntWritable
 * KEYOUT,reduce阶段输出的Key类型：Text
 * VALUEOUT,reduce阶段输出的value类型：IntWritable
 */
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
    private IntWritable outV = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        int sum = 0;
        // xxxxxxx xxxxxxx ->(xxxxxxx,1),(xxxxxxx,1)
        // xxxxxxx, (1,1)
        // 将values进行累加
        for (IntWritable value : values) {
            sum += value.get();
        }

        outV.set(sum);
        // 写出
        context.write(key,outV);
    }
}

~~~

#### 编写 Driver 驱动类

~~~java
package com.leokadia.mapreduce.wordcount;
/**
 * @author sa
 * @create 2021-05-05 10:47
 */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        // 1 获取job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // 2 设置jar包路径
        job.setJarByClass(WordCountDriver.class);

        // 3 关联mapper和reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 4 设置map输出的kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 5 设置最终输出的kV类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 6 设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\input\\inputword"));
        FileOutputFormat.setOutputPath(job, new Path("D:\\hadoop\\output888"));

        // 7 提交job
        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }
}

~~~

#### 本地测试

#### 集群测试



## 序列化和反序列化

### 基本概念

1. 序列化就是把内存中的对象，转换成字节序列（或其他数据传输协议）以便于存储（持久化）和网络传输。
2. 反序列化就是将收到字节序列（或其他数据传输协议）或者是硬盘的持久化数据，转换成内存中的对象。

### 为什么不是用Java序列化？

​		Java的序列化是一个重量级序列化框架（Serializable），一个对象被序列化后，会附带很多额外的信息（各种校验信息，header，继承体系等），不便于在网络中高效传输。所以，hadoop自己开发了一套序列化机制（Writable），精简、高效。

### 使用Hadoop序列化

自定义bean对象要想序列化传输步骤及注意事项：

1. 必须实现Writable接口
2. 反序列化时，需要反射调用空参构造函数，所以必须有空参构造
3. 重写序列化方法
4. 重写反序列化方法
5. 注意反序列化的顺序和序列化的顺序完全一致
6. 要想把结果显示在文件中，需要重写toString()，且用"\t"分开，方便后续用
7. 如果需要将自定义的bean放在key中传输，则还需要实现comparable接口，因为mapreduce框中的shuffle过程一定会对key进行排序



### 程序示例

#### 需求

统计每个手机号耗费的总上行流量、下行流量、总流量

#### 流程分析

1. 输入数据格式

~~~csv
id 手机号码 网络ip  上行流量 下行流量 网络状态码
7 XXXXXX 192.168.1.1 1116 964 200
~~~

2. 输出数据格式

~~~csv
手机号码 上行流量 下行流量 总流量
xxxxxx	1116 	954	   2070
~~~

3. Map阶段
   1. 读取一行数据，切分字段
   2. 抽取数据
   3. 以手机号为Key，bean对象为value输出
   4. Bean对象如果想要被传输，就必须实现序列化
4. Reduce阶段
   1. 累加上行流量与下行流量得到总流量

#### 核心代码

##### 创建Bean对象

~~~java
package com.atguigu.mapreduce.writable;

import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//1 继承Writable接口
public class FlowBean implements Writable {

    private long upFlow; //上行流量
    private long downFlow; //下行流量
    private long sumFlow; //总流量

    //2 提供无参构造
    public FlowBean() {
    }

    //3 提供三个参数的getter和setter方法
    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }

    public void setSumFlow() {
        this.sumFlow = this.upFlow + this.downFlow;
    }

    //4 实现序列化和反序列化方法,注意顺序一定要保持一致
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readLong();
        this.downFlow = dataInput.readLong();
        this.sumFlow = dataInput.readLong();
    }

    //5 重写ToString
    @Override
    public String toString() {
        return upFlow + "\t" + downFlow + "\t" + sumFlow;
    }
}

~~~

##### 编写Mapper类

~~~java
package com.atguigu.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1 获取一行数据,转成字符串
        String line = value.toString();

        //2 切割数据
        String[] split = line.split("\t");

        //3 抓取我们需要的数据:手机号,上行流量,下行流量
        String phone = split[1];
        String up = split[split.length - 3];
        String down = split[split.length - 2];

        //4 封装outK outV
        outK.set(phone);
        outV.setUpFlow(Long.parseLong(up));
        outV.setDownFlow(Long.parseLong(down));
        outV.setSumFlow();

        //5 写出outK outV
        context.write(outK, outV);
    }
}

~~~



##### 编写Reducer类

~~~java
package com.atguigu.mapreduce.writable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
    private FlowBean outV = new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        long totalUp = 0;
        long totalDown = 0;

        //1 遍历values,将其中的上行流量,下行流量分别累加
        for (FlowBean flowBean : values) {
            totalUp += flowBean.getUpFlow();
            totalDown += flowBean.getDownFlow();
        }

        //2 封装outKV
        outV.setUpFlow(totalUp);
        outV.setDownFlow(totalDown);
        outV.setSumFlow();

        //3 写出outK outV
        context.write(key,outV);
    }
}

~~~

##### 编写Driver驱动类

~~~java
package com.atguigu.mapreduce.writable;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlowDriver {

  public static void main(String[] args)
    throws IOException, ClassNotFoundException, InterruptedException {
    //1 获取job对象
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf);

    //2 关联本Driver类
    job.setJarByClass(FlowDriver.class);

    //3 关联Mapper和Reducer
    job.setMapperClass(FlowMapper.class);
    job.setReducerClass(FlowReducer.class);

    //4 设置Map端输出KV类型
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(FlowBean.class);

    //5 设置程序最终输出的KV类型
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(FlowBean.class);

    //6 设置程序的输入输出路径
    FileInputFormat.setInputPaths(job, new Path("D:\\inputflow"));
    FileOutputFormat.setOutputPath(job, new Path("D:\\flowoutput"));

    //7 提交Job
    boolean b = job.waitForCompletion(true);
    System.exit(b ? 0 : 1);
  }
}

~~~



## Mapper 框架原理

### 概述

![image-20220610102844940](img/image-20220610102844940.png)

### inputFormat 与 Mapper

1. 通过split被切割为多个split文件, 逻辑切片<偏移-数据>，
2. 通过Record按行读取内容给map（自己写的处理逻辑的方法），
3. 对其结果key进行分区（默认使用的hashPartitioner），
4. 分区的数量就是 Reducer 任务运行的数量，
5. 然后写入buffer，
6. 每个map task 都有一个内存缓冲区（环形缓冲区），
7. 每个分区中对其键值对进行sort ，按照paritition和key排序，
8. 排序完后会创建一个溢出文件，然后把这部分数据溢出spill写到本地磁盘。
9. 通知master位置归并merge，
10. 当一个maptask处理数据很大时，
11. 对同一个map任务产生的多个spill文件进行归并生成最终的一个已分区且已排序的大文件

### 工作流程

1. MapTask收集我们的map()方法输出的kv对，放到内存缓冲区中
2. 从内存缓冲区不断溢出本地磁盘文件，可能会溢出多个文件
3. 多个溢出文件会被合并成大的溢出文件
4. 在溢出过程及合并的过程中，都要调用Partitioner进行分区和针对key进行排序
5. ReduceTask根据自己的分区号，去各个MapTask机器上取相应的结果分区数据
6. ReduceTask会抓取到同一个分区的来自不同MapTask的结果文件，ReduceTask会将这些文件再进行合并（归并排序）
7. 合并成大文件后，Shuffle的过程也就结束了，后面进入ReduceTask的逻辑运算过程（从文件中取出一个一个的键值对Group，调用用户自定义的reduce()方法）

**注意：**

1. Shuffle中的缓冲区大小会影响到MapReduce程序的执行效率，原则上说，缓冲区越大，磁盘io的次数越少，执行速度就越快。
2. 缓冲区的大小可以通过参数调整，参数：mapreduce.task.io.sort.mb默认100M。





### Shuffle

Map方法之后，Reduce方法之前的数据处理过程称之为Shuffle。

![img](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDMxMjIx,size_16,color_FFFFFF,t_70.png)

+ 目的：

  + 对Map机器上的数据进行重新分组
  + 让每个Reduce知道它需要的数据分别在每个Map机器的哪里。

+ shuffle阶段分为四个步骤：依次为**：分区，排序，规约（combiner），分组**，其中前三个步骤在map阶段完成，最后一个步骤在reduce阶段完成

+ shuffle 是 Mapreduce 的核心，它分布在 Mapreduce 的 map 阶段和 reduce 阶段。一般把从 Map 产生输出开始到 Reduce 取得数据作为输入之前的过程称作 shuffle。

+ shuffle中排序的目的

  + 这样每个Reducer都可以得知自己要处理的数据是哪些，直接拉取和计算对应的数据，避免了大量无用数据的存储和计算

+ map端shuffle

  + 后台线程根据Reducer的个数将输出结果进行分区，每一个分区对应一个Reducer，能够把map任务处理的结果**发给指定reduce执行，负载均衡，**避免数据倾斜。

  + 写入环形内存缓冲区，频繁I/O操作会严重降低效率，每个map任务都会分配一个环形内存缓冲区，用于存储map任务输出的键值对，默认大小100MB，

  + 执行溢出写 排序->合并->生成溢出写文件 一旦缓存区内容达到阈值，默认80%，就锁定着80%的内存，Map task的输出结果还可以往剩下的20MB内存中写，互不影响。并在每个分区中对其键值对进行sort**，按照paritition和key排序，排序完后会创建一个溢出文件，然后把这部分数据溢出spill写到本地磁盘。如果客户端自定义了Combiner（相当于map阶段的reduce），则会在分区排序后到溢写出前自动调用combiner，将相同的key的value相加，这样的好处就是减少溢写到磁盘的数据量。这个过程叫合并**）

  + 归并merge，当一个maptask处理数据很大时，对同一个map任务产生的多个spill文件进行归并生成最终的一个已分区且已排序的大文件

  + 合并（Combine）和归并（Merge）的区别：

    两个键值对<“a”,1>和<“a”,1>，如果合并，会得到<“a”,2>，如果归并，会得到<“a”,<1,1>>

+ reduce端shuffle

  + 复制copy，Reduce 任务通过HTTP向各个Map任务拖取它所需要的数据。在 ReduceTask 远程复制数据的同时，会在后台开启两个线程对内存到本地的数据文件进行合并操作
  + 归并merge，Map的输出数据已经是有序的，Merge进行一次合并排序，所谓Reduce端的 sort过程就是这个合并的过程。一般Reduce是一边copy一边sort，即copy和sort两个阶段是重叠而不是完全分开的。

+ 优化shuffle：增加combiner，压缩溢写的文件

+ 原则上缓冲区越大，磁盘io的次数越少，执行速度就越快缓冲区的大小可以通过参数调整, mapreduce.task.io.sort.mb 默认100M





### Reduce

### OutputFormat

#### 基本概念

OutputFormat 是MapReduce输出的基类，所有实现MapReduce输出都实现了OutputFormat接口

#### 实现类

OutPutFormat 有多种实现类

默认的输出格式是TextOutputFormat

#### 使用场景

1. 输出数据到Mysql中
2. 输出数据到HBase中
3. 输出数据到ES中
4. 等等



### MapTask

1. Read阶段：MapTask通过InputFormat获得的RecordReader，从输入InputSplit中解析出一个个key/value。
2. Map阶段：该节点主要是将解析出的key/value交给用户编写map()函数处理，并产生一系列新的key/value。
3. Collect收集阶段：在用户编写map()函数中，当数据处理完成后，一般会调用OutputCollector.collect()输出结果。在该函数内部，它会将生成的key/value分区（调用Partitioner），并写入一个环形内存缓冲区中。
4. Spill阶段：即“溢写”，当环形缓冲区满后，MapReduce会将数据写到本地磁盘上，生成一个临时文件。需要注意的是，将数据写入本地磁盘之前，先要对数据进行一次本地排序，并在必要时对数据进行合并、压缩等操作。
5. 溢写阶段详情：
   1. 利用快速排序算法对缓存区内的数据进行排序，排序方式是，先按照分区编号Partition进行排序，然后按照key进行排序。这样，经过排序后，数据以分区为单位聚集在一起，且同一分区内所有数据按照key有序。
   2. 按照分区编号由小到大依次将每个分区中的数据写入任务工作目录下的临时文件output/spillN.out（N表示当前溢写次数）中。如果用户设置了Combiner，则写入文件之前，对每个分区中的数据进行一次聚集操作。
   3. 将分区数据的元信息写到内存索引数据结构SpillRecord中，其中每个分区的元信息包括在临时文件中的偏移量、压缩前数据大小和压缩后数据大小。如果当前内存索引大小超过1MB，则将内存索引写到文件output/spillN.out.index中。
6. Merge阶段：当所有数据处理完成后，MapTask对所有临时文件进行一次合并，以确保最终只会生成一个数据文件。
7. 当所有数据处理完后，MapTask会将所有临时文件合并成一个大文件，并保存到文件output/file.out中，同时生成相应的索引文件output/file.out.index。
8. 在进行文件合并过程中，MapTask以分区为单位进行合并。对于某个分区，它将采用多轮递归合并的方式。每轮合并mapreduce.task.io.sort.factor（默认10）个文件，并将产生的文件重新加入待合并列表中，对文件排序后，重复以上过程，直到最终得到一个大文件
9. 让每个MapTask最终只生成一个数据文件，可避免同时打开大量文件和同时读取大量小文件产生的随机读取带来的开销。

### ReduceTask

1. Copy阶段：ReduceTask从各个MapTask上远程拷贝一片数据，并针对某一片数据，如果其大小超过一定阈值，则写到磁盘上，否则直接放到内存中。
2. Sort阶段：在远程拷贝数据的同时，ReduceTask启动了两个后台线程对内存和磁盘上的文件进行合并，以防止内存使用过多或磁盘上文件过多。按照MapReduce语义，用户编写reduce()函数输入数据是按key进行聚集的一组数据。为了将key相同的数据聚在一起，Hadoop采用了基于排序的策略。由于各个MapTask已经实现对自己的处理结果进行了局部排序，因此，ReduceTask只需对所有数据进行一次归并排序即可。
3. Reduce阶段：reduce()函数将计算结果写到HDFS上。



### Join应用

1. Map端的主要工作：为来自不同表或文件的key/value对，打标签以区别不同来源的记录。然后用连接字段作为key，其余部分和新加的标志作为value，最后进行输出。
2. Reduce端的主要工作：在Reduce端以连接字段作为key的分组已经完成，我们只需要在每一个分组当中将那些来源于不同文件的记录（在Map阶段已经打标志）分开，最后进行合并就ok了。



## MapReduce开发总结

1. 输入数据接口：InputFormat
   1. 默认使用的实现类是：TextInputFormat
   2. TextInputFormat的功能逻辑是：一次读一行文本，然后将该行的起始偏移量作为key，行内容作为value返回。
   3. CombineTextInputFormat可以把多个小文件合并成一个切片处理，提高处理效率。

2. 逻辑处理接口：Mapper
   1. 用户根据业务需求实现其中三个方法：map()  setup()  cleanup () 
3. Partitioner分区
   1. 有默认实现 HashPartitioner，逻辑是根据key的哈希值和numReduces来返回一个分区号；key.hashCode()&Integer.MAXVALUE % numReduces
   2. 如果业务上有特别的需求，可以自定义分区。
4. Comparable排序
   1. 当我们用自定义的对象作为key来输出时，就必须要实现WritableComparable接口，重写其中的compareTo()方法。
   2. 部分排序：对最终输出的每一个文件进行内部排序。
   3. 全排序：对所有数据进行排序，通常只有一个Reduce。
   4. 二次排序：排序的条件有两个。
5. Combiner合并
   1. Combiner合并可以提高程序执行效率，减少IO传输。但是使用时必须不能影响原有的业务处理结果。
6. 逻辑处理接口：Reducer
   1. 用户根据业务需求实现其中三个方法：reduce()  setup()  cleanup () 

7. 输出数据接口：OutputFormat
   1. 默认实现类是TextOutputFormat，功能逻辑是：将每一个KV对，向目标文本文件输出一行。
   2. 用户还可以自定义OutputFormat。



## 其他

### shuffle阶段的数据压缩机制了解吗

+ 在shuffle阶段，可以看到数据通过大量的拷贝，从map阶段输出的数据，都要通过网络拷贝，发送到reduce阶段，
+ hadoop当中支持的压缩算法：gzip、bzip2、LZO、LZ4、Snappy，这几种压缩算法综合压缩和解压缩的速率，谷歌的Snappy是最优的，一般都选择Snappy压缩。

### 如何判定一个job的map和reduce的数量?

1. map数量
   1. splitSize=max{minSize,min{maxSize,blockSize}}
   2. map数量由处理的数据分成的block数量决定default_num = total_size / split_size;
2. reduce数量
   1. reduce的数量job.setNumReduceTasks(x);x 为reduce的数量。不设置的话默认为 1。

### Maptask的个数由什么决定？

+ 一个job的map阶段MapTask并行度（个数），由客户端提交job时的切片个数决定。

### mapReduce有几种排序及排序发生的阶段

1. 排序的分类：

   1. 部分排序:MapReduce根据输入记录的键对数据集排序。保证输出的每个文件内部排序

   2. 全排序：如何用Hadoop产生一个全局排序的文件？最简单的方法是使用一个分区。但该方法在处理大型文件时效率极低，因为一台机器必须处理所有输出文件，从而完全丧失了MapReduce所提供的并行架构。

      替代方案：首先创建一系列排好序的文件；其次，串联这些文件；最后，生成一个全局排序的文件。主要思路是使用一个分区来描述输出的全局排序。例如：可以为待分析文件创建3个分区，在第一分区中，记录的单词首字母a-g，第二分区记录单词首字母h-n, 第三分区记录单词首字母o-z。

   3. 辅助排序：（GroupingComparator分组）
          Mapreduce框架在记录到达reducer之前按键对记录排序，但键所对应的值并没有被排序。甚至在不同的执行轮次中，这些值的排序也不固定，因为它们来自不同的map任务且这些map任务在不同轮次中完成时间各不相同。一般来说，大多数MapReduce程序会避免让reduce函数依赖于值的排序。但是，有时也需要通过特定的方法对键进行排序和分组等以实现对值的排序。
   4. 二次排序：
          在自定义排序过程中，如果compareTo中的判断条件为两个即为二次排序。

2. 自定义排序WritableComparabl e

   bean对象实现WritableComparable接口重写compareTo方法，就可以实现排序

~~~bash
@Override  
 public int compareTo(FlowBean o) {  
 // 倒序排列，从大到小  
 return this.sumFlow > o.getSumFlow() ? -1 : 1;  
~~~

3. 排序发生的阶段：
   1. 一个是在map side发生在spill后partition前。
   2. 一个是在reduce side发生在copy后 reduce前。

### MapReduce实现基本SQL操作的原理

**由于Join/GroupBy/OrderBy均需要在Reduce阶段完成**

### Join的实现原理

```
 select u.name, o.orderid from order o join user u on o.uid = u.uid;
```

sql语句中on后面的字段就是key，在map阶段的输出（value）中为不同表的数据打上tag标记，在reduce阶段根据tag判断数据来源。MapReduce的过程如下（这里只是说明最基本的Join的实现，还有其他的实现方式）

![img](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDMxMjIx,size_16,color_FFFFFF,t_70-16522789856514.png)

###  Group By的实现原理

~~~Sql
select rank, isonline, count(*) from city group by rank, isonline;
~~~

sql中 group by后面的字段组合(rank 和isonline的组合)作为map的输出key值，利用MapReduce的排序，在reduce阶段保存LastKey区分不同的key。MapReduce的过程如下（当然这里只是说明Reduce端的非Hash聚合过程)

![在这里插入图片描述](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDMxMjIx,size_16,color_FFFFFF,t_70-16522790210616.png)

### Distinct的实现原理

~~~sql
 select dealid, count(distinct uid) num from order group by dealid;
~~~


当只有一个distinct字段时，如果不考虑Map阶段的Hash GroupBy，只需要将GroupBy字段和Distinct字段组合为map输出key，利用mapreduce的排序，同时将GroupBy字段作为reduce的key，在reduce阶段保存LastKey即可完成去重

![在这里插入图片描述](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDMxMjIx,size_16,color_FFFFFF,t_70-16522790740898.png)

- 如果有多个distinct字段呢，如下面的SQL

~~~sql
 select dealid, count(distinct uid), count(distinct date) from order group by dealid;

~~~

+ 可以对所有的distinct字段编号，每行数据生成n行数据，那么相同字段就会分别排序，这时只需要在reduce阶段记录LastKey即可去重。这种实现方式很好的利用了MapReduce的排序，节省了reduce阶段去重的内存消耗，但是缺点是增加了shuffle的数据量。需要注意的是，在生成reduce value时，除第一个distinct字段所在行需要保留value值，其余distinct数据行value字段均可为空

![在这里插入图片描述](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMwMDMxMjIx,size_16,color_FFFFFF,t_70-165227911059110.png)

### 一个文件有上亿url，内存很小，找Top10

+ 外排序采用分块的方法（分而治之），首先将数据分块，对块内数据按选择一种高效的内排序策略进行排序。然后采用归并排序的思想对于所有的块进行排序，得到所有数据的一个有序序列。
+ 把磁盘上的1TB数据分割为40块（chunks），每份25GB。（注意，要留一些系统空间！）
+ 顺序将每份25GB数据读入内存，使用quick sort算法排序。
+ 把排序好的数据（也是25GB）存放回磁盘。
+ 循环40次，现在，所有的40个块都已经各自排序了。（剩下的工作就是如何把它们合并排序！）
+ 从40个块中分别读取25G/40=0.625G入内存（40 input buffers）。
+ 执行40路合并，并将合并结果临时存储于2GB 基于内存的输出缓冲区中。当缓冲区写满2GB时，写入硬盘上最终文件，并清空输出缓冲区；当40个输入缓冲区中任何一个处理完毕时，写入该缓冲区所对应的块中的下一个0.625GB，直到全部处理完成。

### MapReduce跑得慢的原因？

Mapreduce 程序效率的瓶颈在于两点：

1. 计算机性能
   CPU、内存、磁盘健康、网络
2. I/O 操作优化
   1. 数据倾斜
   2. map和reduce数设置不合理
   3. reduce等待过久
   4. 小文件过多
   5. 大量的不可分块的超大文件
   6. spill次数过多
   7. merge次数过多等

### SQL转化为MapReduce的过程

1. Antlr定义SQL的语法规则，完成SQL词法，语法解析，将SQL转化为抽象语法树AST Tree
   1. HiveLexerX，HiveParser分别是Antlr对语法文件Hive.g编译后自动生成的词法解析和语法解析类
2. 遍历AST Tree，抽象出查询的基本组成单元QueryBlock
   1. QueryBlock是一条SQL最基本的组成单元，包括三个部分：输入源，计算过程，输出。简单来讲一个QueryBlock就是一个子查询
3. 遍历QueryBlock，翻译为执行操作树OperatorTree
   1. Hive最终生成的MapReduce任务，Map阶段和Reduce阶段均由OperatorTree组成。逻辑操作符，就是在Map阶段或者Reduce阶段完成单一特定的操作。
4. 逻辑层优化器进行OperatorTree变换，减少mapreduce job，减少shuffle数据量
   1. 谓词下推、合并线性的OperatorTree中partition/sort key相同的reduce （from (select key,value from src group bu key, value）s select s.key group by s.key;
   2. Map端聚合
5. 遍历OperatorTree，翻译为MapReduce任务
6. 物理层优化器进行MapReduce任务的变换，生成最终的执行计划

### 什么是数据倾斜

- Hadoop能够进行对海量数据进行批处理的核心，在于它的**分布式思想，也就是多台服务器（节点）组成集群，进行分布式的数据处理**。
- 举例：如果有10亿数据，一台电脑可能要10小时，现在集群有10台，可能1小时就够了，但是有可能大量的数据集中到一台或几台上，要5小时，发生了数据倾斜

### 数据倾斜的表现

1. Mapreduce任务
   1. reduce阶段 卡在99.99%不动
   2. 各种container报错OOM
   3. 读写数据量很大，超过其他正常reduce
2. spark任务
   1. 个别task执行很慢
   2. 单个执行特别久
   3. shuffle出错
   4. sparkstreaming做实时算法使，会有executor出现内存溢出，但是其他的使用率很低

### 发生数据倾斜的原因

+ shuffle是按照key，来进行values的数据的输出、拉取和聚合的，一旦发生shuffle，所有相同key的值就会拉到一个或几个节点上，个别key对应的数据比较多，就容易发生单个节点处理数据量爆增的情况。
+ key分布不均匀
  + 存在大量相同值的数据
  + 存在大量异常值或者空值
+ 业务数据本身的特性
  + 例如某个分公司或某个城市订单量大幅提升几十倍甚至几百倍，对该城市的订单统计聚合时，容易发生数据倾斜。
+ 某些SQL语句本身就有数据倾斜
  + 两个表中关联字段存在大量空值（去除或者加随机数），或是关联字段的数据不统一（方法：把数字类型转为字符串类型，统一大小写）
  + join 一个key集中的小表 （方法：reduce join 改成 map join）
  + group by维度过小 某值的数量过多 （方法：两阶段聚合，放粗粒度）
  + count distinct 某特殊值过多 （方法：用group by）
+ 数据频率倾斜——某一个区域的数据量要远远大于其他区域。
+ 数据大小倾斜——部分记录的大小远远大于平均值。

### 排序选择

+ cluster by: 对同一字段分桶并排序，不能和sort by连用；
+ distribute by + sort by: 分桶，保证同一字段值只存在一个结果文件当中，结合sort by 保证每个reduceTask结果有序；
+ sort by: 单机排序，单个reduce结果有序
+ order by：全局排序，缺陷是只能使用一个reduce



# Yarn 

## 概述

### 什么是Yarn

​		Yarn是一个资源调度平台，负责为运算程序提供服务器运算资源，相当于一个分布式的操作系统平台，而MapReduce等运算程序则相当于运行于操作系统之上的应用程序。

### Yarn 的基本架构

1) ResourceManager（RM）：YARN分层结构的本质是ResourceManager。这个实体控制整个集群并管理应用程序向基础计算资源的分配。ResourceManager将各个资源部分（计算、内存、带宽等）精心安排给基础NodeManager（YARN的每节点代理）。ResourceManager还与ApplicationMaster一起分配资源，与NodeManager一起启动和监视它们的基础应用程序。在此上下文中，ApplicationMaster承担了以前的TaskTracker的一些角色，ResourceManager承担了JobTracker 的角色。总的来说，RM有以下作用：
   1) 处理客户端请求
   2) 启动或监控ApplicationMaster
   3) 监控NodeManager
   4) 资源的分配与调度


2) ApplicationMaster（AM）：ApplicationMaster管理在YARN内运行的每个应用程序实例。ApplicationMaster负责协调来自ResourceManager的资源，并通过NodeManager监视容器的执行和资源使用（CPU、内存等的资源分配）。请注意，尽管目前的资源更加传统（CPU 核心、内存），但未来会带来基于手头任务的新资源类型（比如图形处理单元或专用处理设备）。从YARN角度讲，ApplicationMaster是用户代码，因此存在潜在的安全问题。YARN假设ApplicationMaster存在错误或者甚至是恶意的，因此将它们当作无特权的代码对待。总的来说,AM有以下作用
   1) 负责数据的切分	
   2) 为应用程序申请资源并分配给内部的任务
   3) 任务的监控与容错


3) NodeManager（NM）：NodeManager管理YARN集群中的每个节点。NodeManager提供针对集群中每个节点的服务，从监督对一个容器的终生管理到监视资源和跟踪节点健康。MRv1通过插槽管理Map 和Reduce任务的执行，而NodeManager管理抽象容器，这些容器代表着可供一个特定应用程序使用的针对每个节点的资源。总的来说，NM有以下作用：
   1) 管理单个节点上的资源
   2) 处理来自ResourceManager的命令
   3) 处理来自ApplicationMaster的命令


4) Container：Container是YARN中的资源抽象，它封装了某个节点上的多维度资源，如内存、CPU、磁盘、网络等，当AM向RM申请资源时，RM为AM返回的资源便是用Container表示的。YARN会为每个任务分配一个Container，且该任务只能使用该Container中描述的资源。总的来说，Container有以下作用:
   1) 对任务运行环境进行抽象
   2) 封装CPU、内存等多维度的资源以及环境变量、启动命令等任务运行相关的信息




### Yarn 工作原理

### Job 提交流程

​		这里一共也有两个版本，分别是详细版和简略版，具体使用哪个还是分不同的场合。正常情况下，将简略版的回答清楚了就很OK，详细版的最多做个内容的补充：

![img](img/format,png.png)

- 简略版

![img](img/format,png-165228081322113.png)

1. client 向 RM 提交应用程序，其中包括启动该应用的ApplicationMaster的必须信息，例如ApplicationMaster程序、启动ApplicationMaster的命令、用户程序等
2. ResourceManager启动一个 container 用于运行ApplicationMaster
3. 启动中的ApplicationMaster向ResourceManager注册自己，启动成功后与RM保持心跳
4. ApplicationMaster向ResourceManager发送请求,申请相应数目的container
5. 申请成功的container，由ApplicationMaster进行初始化。container的启动信息初始化后，AM与对应的NodeManager通信，要求NM启动container
6. NM启动container
7. container运行期间，ApplicationMaster对container进行监控。container通过RPC协议向对应的AM汇报自己的进度和状态等信息
8. 应用运行结束后，ApplicationMaster向ResourceManager注销自己，并允许属于它的container被收回

### 调度器，调度器分类

​		关于Yarn的知识点考察实际上在面试中占的比重并的不多，像面试中常问的无非就Yarn的Job执行流程或者调度器的分类，答案往往也都差不多，以下回答做个参考：

Hadoop调度器主要分为三类：

- FIFO Scheduler：先进先出调度器：优先提交的，优先执行，后面提交的等待【生产环境不会使用】
- Capacity Scheduler：容量调度器：允许看创建多个任务对列，多个任务对列可以同时执行。但是一个队列内部还是先进先出。【Hadoop2.7.2默认的调度器】
- Fair Scheduler：公平调度器：第一个程序在启动时可以占用其他队列的资源（100%占用），当其他队列有任务提交时，占用资源的队列需要将资源还给该任务。还资源的时候，效率比较慢。【CDH版本的yarn调度器默认】
