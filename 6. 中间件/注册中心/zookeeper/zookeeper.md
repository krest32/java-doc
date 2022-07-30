# Zookeeper

## Zk的简介

+ 它是一个分布式、开放源码的分布式应用程序协调软件
+ 是 Google 的 chubby 开源的实现
+ 是 Hadoop 和 Hbase 的重要组件，同时也是Kafka的前提
+ 使用 Java 编写，但是支持 Java 和 C 两种编程语言



## ZK的内存数据模型

+ 类似与Linux的文件系统，很像树形结构，树形节点的结构
+ 每个节点，可以存储数据
+ 每个节点也可以存储版本，所以可以访问每个节点的多个版本数据
+ 每个节点可以被监控，当节点改变时，就可以通知设置监控的客户端



## ZK节点分类

+ 持久节点

  + 节点创建后会一直存在，持久化到磁盘，除非有明确的删除指令

+ 持久顺序节点

  + 让当前的持久节点变得有序，每个父节点会为第一个子节点维护一个时序，用来记录这个节点创建的相互顺序（可以自动维护，也可以手动维护）
  + 可以根据顺序进行相关操作

+ 临时节点

  + 临时与客户端会话绑定，会话失效，临时节点会被自动删除
  + 注意：临时节点是会话失效，而非连接失效，临时节点不能够创建子节点

+ 临时顺序节点

  + 等同于临时节点+有序

  


## 安装

### 基础Linux

#### 1. 下载ZK

#### 2. 进行解压

#### 3. 修改配置文件

#### 4. 防火墙处理

#### 5. 启动

#### 6. 查看状态

#### 7. 停止启动

#### 8. 集群管理



### 基于Docker

如果对于zk了解或者docker了解不深入，可以优先使用原生linux的zk，日后的生产实践，可以使用

~~~bash
# 查找zookeeper
docker search zookeeper

# 拉取镜像
docker pull Zookeeper:3.4.14

# docker 运行zookeeper
docker run --name zk -p 2181:2181 -d zookeeper:3.4.14

# 进入容器
docker exec -it zk bash

# 容器内部文件
root@d4136aed5991:/zookeeper-3.4.14# ls

LICENSE.txt  README_packaging.txt  conf
ivysettings.xml  src                      
zookeeper-3.4.14.jar.md5   
zookeeper-contrib  
zookeeper-jute
NOTICE.txt   
bin                   
dist-maven  lib             
zookeeper-3.4.14.jar      
zookeeper-3.4.14.jar.sha1  
zookeeper-docs     
zookeeper-recipes
README.md   
build.xml             
ivy.xml     
pom.xml          
zookeeper-3.4.14.jar.asc 
zookeeper-client           
zookeeper-it       
zookeeper-server

# 运行客户端(测试) 默认链接本地
./bin/zkCli.sh
# 也可以链接 远端的Server
./bin/zkCli.sh -server 192.168.42.132:2181

# 退出客户端，进入到conf目录，增加配置文件
touch zoo.cfg

# 编辑zoo.cfg
vi zoo.cfg(如果没有vi指令，那么就需要先添加vi指令)

# 安装vi/vim指令（推荐安装vim vi可能安装不成功）
在docker容器中vi指令找不到
在使用docker容器时，有时候里边没有安装vi，敲vi命令时提示说：vi: command not found，这个时候就需要安装vi，可是当你敲apt-get install vi命令时，提示：
Reading package lists… Done
Building dependency tree
Reading state information… Done
E: Unable to locate package vi
这时候需要敲：apt-get update，这个命令的作用是：同步 /etc/apt/sources.list 和 /etc/apt/sources.list.d 中列出的源的索引，这样才能获取到最新的软件包。
等更新完毕以后再敲命令：apt-get install vi 或者 命令 apt-get install vim 即可。

# 打开zoo.cfg 
# tickTime 集群节点的心跳时间
# initLimit 集群初始化时同步阶段的心跳时间
# syncLimit 发送和得到一个数据的时间间隔
# dataDir 默认数据的存储位置
# clientPort=2181 客户端监听端口号
# maxClientCnxns 最大客户端数量
# autopurge.snapRetainCount 快照数量
# autopurge.purgeInterval 合并快照的时间，默认为1（小时）
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/tmp/zookeeper
clientPort=2181
maxClientCnxns=60
autopurge.snapRetainCount=3
autopurge.purgeInterval=1

~~~

ZK Cli指令

~~~bash
# 查看所有节点
ls /

# 查看对应节点的子节点
ls /zookeeper
ls /quota

# 创建节点(默认持久节点)
create /node1 xiaocheng
# 创建持久顺序节点
create -s /node2 xiaobai
# 创建临时节点(默认持久节点)
create -e /node1 rempnode
# 创建临时顺序节点
create -s -e /node2  tempnode

# 退出客户端，会删除临时节点
quit

# 查看节点状态
stat /node1

# 获取节点的数据
get /node1

# 修改节点数据
set /node1 baibai

# 删除节点(只能删除没有子节点的节点)
delete /node

# 递归删除节点与其子节点
rmr /node

# ls2 ls和stat指令的组合
ls2 /node1

# 操作的历史记录
history
~~~



## 节点的监听机制

~~~bash
# 监听节点目录的变化
ls /path true

# 监听节点数据变化
ls /node true
~~~

一旦监听的事件触发时，会发生对应的时间，然后清除对于该节点的检测，所以监听机制是一次性的

Watcher 通知非常简单，只会告诉客户端发生了事件，而不会说明事件的具体内容。



## Java 操作Zk

~~~xml
 <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.10</version>
        </dependency>
    </dependencies>
~~~

~~~java
    @Test
    // 创建节点
    public void testCreateNode(){
        // server地址 会话超时时间，链接超时时间，序列化方式
        ZkClient zkClient = new ZkClient(
                "192.168.42.132:2181",
                6000*30,
                60000,
                new SerializableSerializer());
        System.out.println(zkClient);
        // 持久节点
       zkClient.create("/node1","ZhangSan", CreateMode.PERSISTENT);
        // 持久有序节点
        zkClient.create("/node2","lisi", CreateMode.PERSISTENT_SEQUENTIAL);
        // 临时节点
        zkClient.create("/node3","wangwu", CreateMode.EPHEMERAL);
        // 临时有序节点
        zkClient.create("/node4","zhaoliu", CreateMode.EPHEMERAL_SEQUENTIAL);

        // 删除
        zkClient.delete("/node1");
        // 递归删除
        zkClient.deleteRecursive("/node1");

        // 查询当前节点下的所有子节点
        List<String> children = zkClient.getChildren("/");
        for (String child : children) {
            System.out.println(child);
        }

        // 查看某个节点数据，需要保证序列化的方式一致
        zkClient.readData("/node1");

        // 查看节点的状态信息
        Stat stat = new Stat();
        zkClient.readData("/node1",stat);
        stat.getAversion();
        stat.getCtime();
        stat.getCzxid();


        // 修改节点的数据
        User user = new User();
        user.setAge(23);
        user.setId("1");
        user.setName("杜鑫");
        zkClient.writeData("/node1",user);

        // 监听节点数据的变化：永久监听
        zkClient.subscribeDataChanges("/node1", new IZkDataListener() {
            // 数据变化是触发方法
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                System.out.println("当前节点路径："+dataPath);
                System.out.println("节点变化后数据："+data);
            }

            // 节点被删除了对应的方法
            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                System.out.println("被删除的当前节点的路径："+dataPath);
            }
        });


        // 监听节点目录的变化：永久监听
        zkClient.subscribeChildChanges("node1", new IZkChildListener() {
            @Override
            public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
                System.out.println("父节点名称："+parentPath);
                for (String currentChild : currentChilds) {
                    System.out.println("子节点："+currentChild);
                }
            }
        });
   
     zkClient.close();
    }
~~~





## 集群

### 原理

+ 运行复制的Zookeeper
  + 会有一个主节点
  + 会有多个从节点（仲裁节点）（所有的配置文件一致）
  + 节点最好是奇数，个数不能少于3个
+ 集群原理
  + ZAB 原子广播协议
    + 所有的子节点发送写入确认信息给到主节点，主节点然后通过广播让所有节点写入数据，直到所有节点完成写入操作
    + 任意一个节点写入失败，那么所有节点取消写入操作

### 配置文件

~~~properties
tickTime=2000
initLimit=10
syncLimit=5
dataDir=/tmp/zookeeper
# 广播协议的端口 2888 心跳检查 3888
server.1=192.168.42.132:2888:3888
server.2=192.168.42.132:2888:3888
server.3=192.168.42.132:2888:3888
~~~

### 利用docker搭建集群

**一、前言**

在单台服务器上，部署三个docker容器，搭建zookeeper集群

**二、过程**

1.准备工作

这里我使用的是docker来搭建zookeeper集群，所以必须提前准备好以下内容：

```
安装docker
拉取zookeeper镜像（这里我用的是3.4.10版本）
```

docker pull zookeeper:3.4.10

2.开始搭建

单个节点不能叫做集群，而两个节点也不好做集群，这里我创建了三个zookeeper节点来搭建集群（友情提示：最好是用奇数个节点做集群）
（1）利用镜像启动三个zookeeper容器，分别运行以下三个命令

```
docker run --name zk01 -p 2182:2181 -d zookeeper:3.4.14
docker run --name zk02 -p 2183:2181 -d zookeeper:3.4.14
docker run --name zk03 -p 2184:2181 -d zookeeper:3.4.14
```

可以看到我这里已经有了三个zookeeper容器，注意宿主机要用不同的端口去映射zookeeper的2181端口

![image-20210701132206624](img/image-20210701132206624.png)

（2）查看容器的运行状态（主要是ip地址,以zk01为例）

```
docker inspect zk01
```

![image-20210701132239142](img/image-20210701132239142.png)

在我的机器上zk01、zk02、zk03分别对应

```
172.17.0.2172.17.0.3172.17.0.4
```

（以个人机器为准）

（3）修改配置文件（这里以容器zk01为例）
进入容器

```
docker exec -it zk01 bash
```

查看配置文件

![image-20210701132257780](img/image-20210701132257780.png)

当启动zookeeper服务时，需要使用的配置文件是zoo.cfg，所以我们修改zoo.cfg

```
vim zoo.cfg
```

此时可能vi或者vim命令无法使用，需要在docker容器执行以下命令：

```
apt-get updateapt-get install vim
```

![image-20210701132322133](img/image-20210701132322133.png)

在配置文件中添加

```
clientPort=2181dataDir=/datadataLogDir=/datalogtickTime=2000initLimit=5syncLimit=5maxClientCnxns=60server.1=172.17.0.2:2888:3888server.2=172.17.0.3:2888:3888server.3=172.17.0.4:2888:3888
```

请注意，如果你是在**Linux环境下直接搭建zookeeper**，请修改本机所在节点的ip为0.0.0.0
例如我当前节点是server.1，则ip修改为0.0.0.0（非docker环境）

```
server.1=0.0.0.0:2888:3888server.2=172.17.0.8:2888:3888server.3=172.17.0.9:2888:3888
```

这里172.17.0.x表示的是三台zookeeper容器对应的ip地址；2888是zookeeper容器间通信的端口，3888是zookeeper选举投票的端口，一般来说都是固定的
而server后面的数字表示zk节点在容器中的编号，必须是唯一的，所以在这里也必须进行设置

进入到 /data目录

![image-20210701132342419](img/image-20210701132342419.png)

在这里用vi命令修改myid文件内的值为1即可

![image-20210701132354829](img/image-20210701132354829.png)

保存退出，查看myid文件的内容

![image-20210701132406277](img/image-20210701132406277.png)

同理，进入zk02和zk03容器内部修改zoo.cfg和myid文件的内容。

到这里我们就已经配置好了三台zk服务器，接下来只要将其启动起来即可。

**三、启动**

打开三个窗口，分别进入三个zk容器内部，然后切换到bin目录下

![image-20210701132429015](img/image-20210701132429015.png)

运行 zkServer.sh 脚本，开启zookeeper服务

![image-20210701132443895](img/image-20210701132443895.png)

![image-20210701132458255](img/image-20210701132458255.png)

![image-20210701132510599](img/image-20210701132510599.png)

可以看到zk集群已经启动起来了，完美！

**四、注意事项**

如果在运行 zkServer.sh 文件的过程中有什么错误的话，可以查看zookeeper.out文件，里面会有错误提示内容

修改完zoo.cfg配置文件后，需要用 docker restart [容器名] 重启zookeeper容器

### Java 客户端操作

~~~java
ZkClient zkClient = new ZkClient(                "192.168.42.132:2181,192.168.42.132:2182,192.168.42.132:2183",                6000*30,                60000,                new SerializableSerializer());
~~~





# 面试

##  ZooKeeper 是什么？

​		ZooKeeper 是一个开源的分布式协调服务。它是一个为分布式应用提供一致性服务的软件，分布式应用程序可以基于 Zookeeper 实现诸如数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理、Master 选举、分布式锁和分布式队列等功能。

​		ZooKeeper 的目标就是封装好复杂易出错的关键服务，将简单易用的接口和性能高效、功能稳定的系统提供给用户。

Zookeeper 保证了如下分布式一致性特性：

1. 顺序一致性
2. 原子性
3. 单一视图
4. 可靠性
5. 实时性（最终一致性）

​		客户端的读请求可以被集群中的任意一台机器处理，如果读请求在节点上注册了监听器，这个监听器也是由所连接的 zookeeper 机器来处理。对于写请求，这些请求会同时发给其他 zookeeper 机器并且达成一致后，请求才会返回成功。因此，随着 zookeeper 的集群机器增多，读请求的吞吐会提高但是写请求的吞吐会下降。

​		**有序性**是 zookeeper 中非常重要的一个特性，所有的更新都是全局有序的，每个更新都有一个唯一的时间戳，这个时间戳称为 zxid（Zookeeper Transaction Id）。而读请求只会相对于更新有序，也就是读请求的返回结果中会带有这个zookeeper 最新的 zxid。



## ZooKeeper 提供了什么？

+ 文件系统
+ 通知机制



## Zookeeper 文件系统

​		Zookeeper 提供一个多层级的节点命名空间（节点称为 znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行。

​		Zookeeper 为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得 Zookeeper 不能用于存放大量的数据，每个节点的存放数据上限为1M。





## 四种类型的数据节点 Znode

1. PERSISTENT-持久节点

   ​	除非手动删除，否则节点一直存在于 Zookeeper 上

2. EPHEMERAL-临时节点

   ​	临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper 连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除。

3. PERSISTENT_SEQUENTIAL-持久顺序节点

   ​	基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数

4. EPHEMERAL_SEQUENTIAL-临时顺序节点

   ​	基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。





## Zookeeper 怎么保证主从节点的状态同步？

​		Zookeeper 的核心是原子广播机制，这个机制保证了各个 server 之间的同步。实现这个机制的协议叫做 Zab 协议。Zab 协议有两种模式，它们分别是恢复模式和广播模式。

**恢复模式**
		当服务启动或者在领导者崩溃后，Zab就进入了恢复模式，当领导者被选举出来，且大多数 server 完成了和 leader 的状态同步以后，恢复模式就结束了。状态同步保证了 leader 和 server 具有相同的系统状态。

**广播模式**
		一旦 leader 已经和多数的 follower 进行了状态同步后，它就可以开始广播消息了，即进入广播状态。这时候当一个 server 加入 ZooKeeper 服务中，它会在恢复模式下启动，发现 leader，并和 leader 进行状态同步。待到同步结束，它也参与消息广播。ZooKeeper 服务一直维持在 Broadcast 状态，直到 leader 崩溃了或者 leader 失去了大部分的 followers 支持。



## Zookeeper Watcher 机制 – 数据变更通知

​		Zookeeper 允许客户端向服务端的某个 Znode 注册一个 Watcher 监听，当服务端的一些指定事件触发了这个 Watcher，服务端会向指定客户端发送一个事件通知来实现分布式的通知功能，然后客户端根据 Watcher 通知状态和事件类型做出业务上的改变。

工作机制：

1. 客户端注册 watcher

2. 服务端处理 watcher

3. 客户端回调 watcher

Watcher 特性总结：

1. 一次性

   ​	无论是服务端还是客户端，一旦一个 Watcher 被 触 发 ，Zookeeper 都会将其从相应的存储中移除。这样的设计有效的减轻了服务端的压力，不然对于更新非常频繁的节点，服务端会不断的向客户端发送事件通知，无论对于网络还是服务端的压力都非常大。

2. 客户端串行执行

   ​	客户端 Watcher 回调的过程是一个串行同步的过程。

3. 轻量 

   1. Watcher 通知非常简单，只会告诉客户端发生了事件，而不会说明事件的具体内容。
   2. 客户端向服务端注册 Watcher 的时候，并不会把客户端真实的 Watcher 对象实体传递到服务端，仅仅是在客户端请求中使用 boolean 类型属性进行了标记。

4. watcher event 异步发送 watcher 的通知事件从 server 发送到 client 是异步的，这就存在一个问题，不同的客户端和服务器之间通过 socket 进行通信，由于网络延迟或其他因素导致客户端在不通的时刻监听到事件，由于 Zookeeper 本身提供了 ordering guarantee，即客户端监听事件后，才会感知它所监视 znode发生了变化。所以我们使用 Zookeeper 不能期望能够监控到节点每次的变化。Zookeeper 只能保证最终的一致性，而无法保证强一致性。

5. 注册 watcher getData、exists、getChildren

6. 触发 watcher create、delete、setData

7. 当一个客户端连接到一个新的服务器上时，watch 将会被以任意会话事件触发。当与一个服务器失去连接的时候，是无法接收到 watch 的。而当 client 重新连接时，如果需要的话，所有先前注册过的 watch，都会被重新注册。通常这是完全透明的。只有在一个特殊情况下，watch 可能会丢失：对于一个未创建的 znode的 exist watch，如果在客户端断开连接期间被创建了，并且随后在客户端连接上之前又删除了，这种情况下，这个 watch 事件可能会被丢失。



## 客户端注册 Watcher 实现

1. 调用 getData()/getChildren()/exist()三个 API，传入 Watcher 对象
2. 标记请求 request，封装 Watcher 到 WatchRegistration
3. 封装成 Packet 对象，发服务端发送 request
4. 收到服务端响应后，将 Watcher 注册到 ZKWatcherManager 中进行管理
5. 请求返回，完成注册。



## 服务端处理 Watcher 实现

1. 服务端接收 Watcher 并存储

​		接收到客户端请求，处理请求判断是否需要注册 Watcher，需要的话将数据节点的节点路径和 ServerCnxn（ServerCnxn 代表一个客户端和服务端的连接，实现了 Watcher 的 process 接口，此时可以看成一个 Watcher 对象）存储在WatcherManager 的 WatchTable 和 watch2Paths 中去。

2. Watcher 触发：以服务端接收到 setData() 事务请求触发 NodeDataChanged 事件为例：
   1. 封装 WatchedEvent：将通知状态（SyncConnected）、事件类型（NodeDataChanged）以及节点路径封装成一个 WatchedEvent 对象
   2. 查询 Watcher：从 WatchTable 中根据节点路径查找 Watcher
   3. 没找到；说明没有客户端在该数据节点上注册过 Watcher
   4. 找到；提取并从 WatchTable 和 Watch2Paths 中删除对应 Watcher（从这里可以看出 Watcher 在服务端是一次性的，触发一次就失效了）

3. 调用 process 方法来触发 Watcher：这里 process 主要就是通过 ServerCnxn 对应的 TCP 连接发送 Watcher 事件通知。



## 客户端回调 Watcher

​		客户端 SendThread 线程接收事件通知，交由 EventThread 线程回调 Watcher。

​		客户端的 Watcher 机制同样是一次性的，一旦被触发后，该 Watcher 就失效了。



## ACL 权限控制机制

​		UGO（User/Group/Others）

​		目前在 Linux/Unix 文件系统中使用，也是使用最广泛的权限控制方式。是一种粗粒度的文件系统权限控制模式。

ACL（Access Control List）访问控制列表

包括三个方面：

权限模式（Scheme）

1. IP：从 IP 地址粒度进行权限控制
2. Digest：最常用，用类似于 username:password 的权限标识来进行权限配置，便于区分不同应用来进行权限控制
3. World：最开放的权限控制方式，是一种特殊的 digest 模式，只有一个权限标识“world:anyone”
4. Super：超级用户

授权对象

授权对象指的是权限赋予的用户或一个指定实体，例如 IP 地址或是机器灯。

权限 Permission

1. CREATE：数据节点创建权限，允许授权对象在该 Znode 下创建子节点
2. DELETE：子节点删除权限，允许授权对象删除该数据节点的子节点
3. READ：数据节点的读取权限，允许授权对象访问该数据节点并读取其数据内容或子节点列表等
4. WRITE：数据节点更新权限，允许授权对象对该数据节点进行更新操作
5. ADMIN：数据节点管理权限，允许授权对象对该数据节点进行 ACL 相关设置操作



## Chroot 特性

​		3.2.0 版本后，添加了 Chroot 特性，该特性允许每个客户端为自己设置一个命名空间。如果一个客户端设置了 Chroot，那么该客户端对服务器的任何操作，都将会被限制在其自己的命名空间下。

​		通过设置 Chroot，能够将一个客户端应用于 Zookeeper 服务端的一颗子树相对应，在那些多个应用公用一个 Zookeeper 进群的场景下，对实现不同应用间的相互隔离非常有帮助。

## 会话管理

分桶策略：将类似的会话放在同一区块中进行管理，以便于 Zookeeper 对会话进行不同区块的隔离处理以及同一区块的统一处理。

分配原则：每个会话的“下次超时时间点”（ExpirationTime）

计算公式：

ExpirationTime_ = currentTime + sessionTimeout

ExpirationTime = (ExpirationTime_ / ExpirationInrerval + 1) *

ExpirationInterval , ExpirationInterval 是指 Zookeeper 会话超时检查时间间隔，默认 tickTime

## 服务器角色

**Leader**

1. 事务请求的唯一调度和处理者，保证集群事务处理的顺序性
2. 集群内部各服务的调度者

**Follower**

1. 处理客户端的非事务请求，转发事务请求给 Leader 服务
2. 参与事务请求 Proposal 的投票
3. 参与 Leader 选举投票

**Observer**

1. 3.0 版本以后引入的一个服务器角色，在不影响集群事务处理能力的基础上提升集群的非事务处理能力
2. 处理客户端的非事务请求，转发事务请求给 Leader 服务器
3. 不参与任何形式的投票

## Zookeeper 下 节点工作状态有哪些？

服务器具有四种状态，分别是 LOOKING、FOLLOWING、LEADING、OBSERVING。

1. LOOKING：寻 找 Leader 状态。当服务器处于该状态时，它会认为当前集群中没有 Leader，因此需要进入 Leader 选举状态。
2. FOLLOWING：跟随者状态。表明当前服务器角色是 Follower。
3. LEADING：领导者状态。表明当前服务器角色是 Leader。
4. OBSERVING：观察者状态。表明当前服务器角色是 Observer。



## 数据同步

​		整个集群完成 Leader 选举之后，Learner（Follower 和 Observer 的统称）回向Leader 服务器进行注册。当 Learner 服务器想 Leader 服务器完成注册后，进入数据同步环节。

数据同步流程：（均以消息传递的方式进行）

+ Learner 向 Learder 注册
+ 数据同步
+ 同步确认

Zookeeper 的数据同步通常分为四类：

1. 直接差异化同步（DIFF 同步）
2. 先回滚再差异化同步（TRUNC+DIFF 同步）
3. 仅回滚同步（TRUNC 同步）
4. 全量同步（SNAP 同步）

在进行数据同步前，Leader 服务器会完成数据同步初始化：

peerLastZxid： 从 learner 服务器注册时发送的 ACKEPOCH 消息中提取 lastZxid（该Learner 服务器最后处理的 ZXID）

minCommittedLog：

+ Leader 服务器 Proposal 缓存队列 committedLog 中最小 ZXIDmaxCommittedLog：
+ Leader 服务器 Proposal 缓存队列 committedLog 中最大 ZXID直接差异化同步（DIFF 同步）
+ 场景：peerLastZxid 介于 minCommittedLog 和 maxCommittedLog之间先回滚再差异化同步（TRUNC+DIFF 同步）
+ 场景：当新的 Leader 服务器发现某个 Learner 服务器包含了一条自己没有的事务记录，那么就需要让该 Learner 服务器进行事务回滚–回滚到 Leader服务器上存在的，同时也是最接近于 peerLastZxid 的 ZXID仅回滚同步（TRUNC 同步）
+ 场景：peerLastZxid 大于 maxCommittedLog

全量同步（SNAP 同步）

+ 场景一：peerLastZxid 小于 minCommittedLog
+ 场景二：Leader 服务器上没有 Proposal 缓存队列且 peerLastZxid 不等于 lastProcessZxid

## zookeeper 是如何保证事务的顺序一致性的？

​		zookeeper 采用了全局递增的事务 Id 来标识，所有的 proposal（提议）都在被提出的时候加上了 zxid，zxid 实际上是一个 64 位的数字，高 32 位是 epoch（ 时期; 纪元; 世; 新时代）用来标识 leader 周期，如果有新的 leader 产生出来，epoch会自增，低 32 位用来递增计数。当新产生 proposal 的时候，会依据数据库的两阶段过程，首先会向其他的 server 发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行。



## 分布式集群中为什么会有 Master主节点？

​		在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行 leader 选举。



## zk 节点宕机如何处理？

Zookeeper 本身也是集群，推荐配置不少于 3 个服务器。Zookeeper 自身也要保证当一个节点宕机时，其他节点会继续提供服务。

+　如果是一个 Follower 宕机，还有 2 台服务器提供访问，因为 Zookeeper 上的数据是有多个副本的，数据并不会丢失
+　如果是一个 Leader 宕机，Zookeeper 会选举出新的 Leader。

​		ZK集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在 ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。

​		所以3个节点的 cluster 可以挂掉 1 个节点(leader 可以得到 2 票>1.5)，2 个节点的 cluster 就不能挂掉任何 1 个节点了(leader 可以得到 1 票<=1)



## zookeeper 负载均衡和 nginx 负载均衡区别

​		zk 的负载均衡是可以调控，nginx 只是能调权重，其他需要可控的都需要自己写插件；但是 nginx 的吞吐量比 zk 大很多，应该说按业务选择用哪种方式。

## Zookeeper 有哪几种几种部署模式？

Zookeeper 有三种部署模式：

1. 单机部署：一台集群上运行；
2. 集群部署：多台集群运行；
3. 伪集群部署：一台集群启动多个 Zookeeper 实例运行。



## 集群支持动态添加机器吗？

其实就是水平扩容了，Zookeeper 在这方面不太好。两种方式：

1. 全部重启：关闭所有 Zookeeper 服务，修改配置之后启动。不影响之前客户端的会话。

2. 逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。

**注意：**3.5 版本开始支持动态扩容。



## Zookeeper 对节点的 watch 监听通知是永久的吗？

1. 不是。官方声明：一个 Watch 事件是一个一次性的触发器，当被设置了 Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了 Watch 的客户端，以便通知它们。
2. **为什么不是永久的**，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。

​		

## Zookeeper 的 java 客户端都有哪些？

​		java 客户端：zk 自带的 zkclient 及 Apache 开源的 Curator。



## chubby 是什么，和 zookeeper 比你怎么看？

+ chubby 是 google 的，完全实现 paxos 算法，不开源。
+ zookeeper 是 chubby的开源实现，使用 zab 协议，paxos 算法的变种。



## 说几个 zookeeper 常用的命令。

常用命令：ls get set create delete 等。

## ZAB 和 Paxos 算法的联系与区别？

相同点：

1. 两者都存在一个类似于 Leader 进程的角色，由其负责协调多个 Follower 进程的运行
2. Leader 进程都会等待超过半数的 Follower 做出正确的反馈后，才会将一个提案进行提交
3. ZAB 协议中，每个 Proposal 中都包含一个 epoch 值来代表当前的 Leader周期，Paxos 中名字为 Ballot

不同点：

1. ZAB 用来构建高可用的分布式数据主备系统（Zookeeper），Paxos 是用来构建分布式一致性状态机系统。



## Zookeeper 的典型应用场景

​		Zookeeper 是一个典型的发布/订阅模式的分布式数据管理与协调框架，开发人员可以使用它来进行分布式数据的发布和订阅。

​		通过对 Zookeeper 中丰富的数据节点进行交叉使用，配合 Watcher 事件通知机制，可以非常方便的构建一系列分布式应用中年都会涉及的核心功能，如：

1. 数据发布/订阅
2. 负载均衡
3. 命名服务
4. 分布式协调/通知
5. 集群管理
6. Master 选举
7. 分布式锁
8. 分布式队列

### 数据发布/订阅

介绍：数据发布/订阅系统，即所谓的配置中心，顾名思义就是发布者发布数据供订阅者进行数据订阅。



目的

1. 动态获取数据（配置信息）
2. 实现数据（配置信息）的集中式管理和数据的动态更新



设计模式

1. Push 模式
2. Pull 模式



数据（配置信息）特性

1. 数据量通常比较小
2. 数据内容在运行时会发生动态更新
3. 集群中各机器共享，配置一致

如：机器列表信息、运行时开关配置、数据库配置信息等



基于 Zookeeper 的实现方式

1. 数据存储：将数据（配置信息）存储到 Zookeeper 上的一个数据节点
2.  数据获取：应用在启动初始化节点从 Zookeeper 数据节点读取数据，并在该节点上注册一个数据变更 Watcher
3. 数据变更：当变更数据时，更新 Zookeeper 对应节点数据，Zookeeper会将数据变更通知发到各客户端，客户端接到通知后重新读取变更后的数据即可。



### 负载均衡

### zk 的命名服务

​		命名服务是指通过指定的名字来获取资源或者服务的地址，利用 zk 创建一个全局的路径，这个路径就可以作为一个名字，指向集群中的集群，提供的服务的地址，或者一个远程的对象等等。



### 分布式通知和协调

​		对于系统调度来说：操作人员发送通知实际是通过控制台改变某个节点的状态，然后 zk 将这些变化发送给注册了这个节点的 watcher 的所有客户端。

​		对于执行情况汇报：每个工作进程都在某个目录下创建一个临时节点。并携带工作的进度数据，这样汇总的进程可以监控目录子节点的变化获得工作进度的实时的全局情况。



### zk 的命名服务（文件系统）

​		命名服务是指通过指定的名字来获取资源或者服务的地址，利用 zk 创建一个全局的路径，即是唯一的路径，这个路径就可以作为一个名字，指向集群中的集群，提供的服务的地址，或者一个远程的对象等等。



### zk 的配置管理（文件系统、通知机制）

​		程序分布式的部署在不同的机器上，将程序的配置信息放在 zk 的 znode 下，当有配置发生改变时，也就是 znode 发生变化时，可以通过改变 zk 中某个目录节点的内容，利用 watcher 通知给各个客户端，从而更改配置。



### Zookeeper 集群管理（文件系统、通知机制）

​		所谓集群管理无在乎两点：是否有机器退出和加入、选举 master。

​		对于第一点，所有机器约定在父目录下创建临时目录节点，然后监听父目录节点的子节点变化消息。一旦有机器挂掉，该机器与 zookeeper 的连接断开，其所创建的临时目录节点被删除，所有其他机器都收到通知：某个兄弟目录被删除，于是，所有人都知道：它上船了。

​		新机器加入也是类似，所有机器收到通知：新兄弟目录加入，highcount 又有了，对于第二点，我们稍微改变一下，所有机器创建临时顺序编号目录节点，每次选取编号最小的机器作为 master 就好。



### Zookeeper 分布式锁（文件系统、通知机制）

有了 zookeeper 的一致性文件系统，锁的问题变得容易。锁服务可以分为两类，一个是保持独占，另一个是控制时序。

对于第一类，我们将 zookeeper 上的一个 znode 看作是一把锁，通过 createznode的方式来实现。所有客户端都去创建 /distribute_lock 节点，最终成功创建的那个客户端也即拥有了这把锁。用完删除掉自己创建的 distribute_lock 节点就释放出锁。

对于第二类， /distribute_lock 已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选 master 一样，编号最小的获得锁，用完删除，依次方便。



### Zookeeper 队列管理（文件系统、通知机制）

两种类型的队列：

1. 同步队列，当一个队列的成员都聚齐时，这个队列才可用，否则一直等待所有成员到达。
2. 队列按照 FIFO 方式进行入队和出队操作。

第一类，在约定目录下创建临时目录节点，监听节点数目是否是我们要求的数目。

第二类，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。在特定的目录下创建 PERSISTENT_SEQUENTIAL 节点，创建成功时Watcher 通知等待的队列，队列删除序列号最小的节点用以消费。此场景下Zookeeper 的 znode 用于消息存储，znode 存储的数据就是消息队列中的消息内容，SEQUENTIAL 序列号就是消息的编号，按序取出即可。由于创建的节点是持久化的，所以不必担心队列消息的丢失问题。



## Zookeeper 都有哪些功能？

+ 集群管理：监控节点存活状态、运行请求等；
+ 主节点选举：主节点挂掉了之后可以从备用的节点开始新一轮选主，主节点选举说的就是这个选举的过程，使用 Zookeeper 可以协助完成这个过程；
+ 分布式锁：Zookeeper 提供两种锁：独占锁、共享锁。独占锁即一次只能有一个线程使用资源，共享锁是读锁共享，读写互斥，即可以有多线线程同时读同一个资源，如果要使用写锁也只能有一个线程使用。Zookeeper 可以对分布式锁进行控制。
+ 命名服务：在分布式系统中，通过使用命名服务，客户端应用能够根据指定名字来获取资源或服务的地址，提供者等信息。





## Zookeeper 和 Dubbo 的关系？

**Zookeeper的作用：**

​		zookeeper用来注册服务和进行负载均衡，哪一个服务由哪一个机器来提供必需让调用者知道，简单来说就是ip地址和服务名称的对应关系。当然也可以通过硬编码的方式把这种对应关系在调用方业务代码中实现，但是如果提供服务的机器挂掉调用者无法知晓，如果不更改代码会继续请求挂掉的机器提供服务。zookeeper通过心跳机制可以检测挂掉的机器并将挂掉机器的ip和服务对应关系从列表中删除。至于支持高并发，简单来说就是横向扩展，在不更改代码的情况通过添加机器来提高运算能力。通过添加新的机器向zookeeper注册服务，服务的提供者多了能服务的客户就多了。

**dubbo：**

​		是管理中间层的工具，在业务层到数据仓库间有非常多服务的接入和服务提供者需要调度，dubbo提供一个框架解决这个问题。
注意这里的dubbo只是一个框架，至于你架子上放什么是完全取决于你的，就像一个汽车骨架，你需要配你的轮子引擎。这个框架中要完成调度必须要有一个分布式的注册中心，储存所有服务的元数据，你可以用zk，也可以用别的，只是大家都用zk。

**zookeeper和dubbo的关系：**

​		Dubbo 的将注册中心进行抽象，它可以外接不同的存储媒介给注册中心提供服务，有 ZooKeeper，Memcached，Redis 等。

​		引入了 ZooKeeper 作为存储媒介，也就把 ZooKeeper 的特性引进来。首先是负载均衡，单注册中心的承载能力是有限的，在流量达到一定程度的时 候就需要分流，负载均衡就是为了分流而存在的，一个 ZooKeeper 群配合相应的 Web 应用就可以很容易达到负载均衡；资源同步，单单有负载均衡还不 够，节点之间的数据和资源需要同步，ZooKeeper 集群就天然具备有这样的功能；命名服务，将树状结构用于维护全局的服务地址列表，服务提供者在启动 的时候，向 ZooKeeper 上的指定节点 /dubbo/${serviceName}/providers 目录下写入自己的 URL 地址，这个操作就完成了服务的发布。 其他特性还有 Mast 选举，分布式锁等。



