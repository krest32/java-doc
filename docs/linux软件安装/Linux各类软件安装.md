# 防火墙

centOS6及以前版本使用命令：

~~~bash
systemctl stop iptables.service
~~~

centOS7关闭防火墙命令：

~~~bash
systemctl stop firewalld.service

#不过，关闭防火墙会导致服务器有一定风险，所以建议是单独开放服务端口：
firewall-cmd --zone=public --add-port=8089/tcp --permanent

#查询端口号8089 是否开启：
firewall-cmd --query-port=8089/tcp

#重启防火墙：
firewall-cmd --reload
# 查看firewall防火墙状态
systemctl status firewalld
# 查看firewall防火墙开放端口
firewall-cmd --list-ports
#禁止firewall开机启动 
systemctl disable firewalld.service

~~~





# 删除软件

+ 查看Linux自带Java软件：rpm -qa | grep java
+ 逐个删除自带软件：rpm -e --nodeps  软件名称
+ 查找存在的文件夹 如： find / -name mysql，然后逐个删除



# JDK

## 安装

+ java -version，查看当前是否有jdk版本

+ 查看Linux自带Java软件：rpm -qa | grep java

+ 逐个删除自带软件：rpm -e --nodeps  软件名称

+ 上传JDK安装包

+ 解压到对应的文件夹

+ 修改系统环境配置文件：vim /etc/profile

  ~~~bash
  export JAVA_HOME=/usr/local/software/jdk8
  export PATH=$JAVA_HOME/bin:$PATH
  export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
  ~~~

+ 使配置生效：source /etc/profile



# Maven

## 安装

下载

~~~bash
wget https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
~~~

解压缩maven
~~~bash
tar -zxvf apache-maven-3.3.9-bin.tar.gz
~~~

添加环境变量

~~~bash
vim /etc/profile

export MAVEN_HOME=/usr/local/software/maven/
export PATH=${PATH}:${MAVEN_HOME}/bin

~~~

验证结果

~~~bash
mvn -version
~~~

本地仓库

~~~bash
mkdir -p /usr/local/software/data/mvnRepo
~~~

修改配置

~~~bash
vim /usr/local/maven/apache-maven-3.3.9/conf/settings.xml


<mirror>
  <id>aliyunmaven</id>
  <mirrorOf>*</mirrorOf>
  <name>阿里云公共仓库</name>
  <url>https://maven.aliyun.com/repository/public</url>
</mirror>
<mirror>
    <id>nexus-163</id>
    <mirrorOf>*</mirrorOf>
    <name>Nexus 163</name>
    <url>http://mirrors.163.com/maven/repository/maven-public/</url>
</mirror>
<mirror>
    <id>nexus-tencentyun</id>
    <mirrorOf>*</mirrorOf>
    <name>Nexus tencentyun</name>
    <url>http://mirrors.cloud.tencent.com/nexus/repository/maven-public/</url>
</mirror> 
<!-- java1.8版本 --> 
<profile>
      <id>jdk-1.8</id>
      <activation>
	    <activeByDefault>true</activeByDefault>
        <jdk>1.8</jdk>
      </activation>

      <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
		<maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
      </properties>
</profile>
~~~









# Golang

## 安装

下载 [网址](https://studygolang.com/dl)

~~~bash
wget https://dl.google.com/go/go1.17.8.linux-amd64.tar.gz
~~~

解压

~~~bash
tar -xzf go1.18.10.linux-arm64.tar.gz
~~~

配置环境

~~~bash
vi /etc/profile

export GOROOT=/usr/local/software/go
export GOPATH=/usr/local/software/data/go
export PATH=$PATH:$GOROOT/bin:$GOPATH
# 开启 Go moudles 特性
export GO111MODULE="on"
# 安装 Go 模块时，国内代理服务器设置
export GOPROXY=https://goproxy.cn,direct 
~~~



# Node.js

## 安装

下载

~~~bash
wget https://registry.npmmirror.com/-/binary/node/v14.18.1/node-v14.18.1-linux-x64.tar.xz

~~~

解压

~~~bash
tar -xvf node-v14.18.1-linux-x64.tar.xz

mv node-v14.18.1-linux-x64 node14
~~~



## 配置环境

~~~bash
vi /etc/profile

export NODE_HOME=/usr/local/software/node14
export PATH=$PATH:$NODE_HOME/bin
export NODE_PATH=$NODE_HOME/lib/node_mudules
export PATH NODE_HOME NODE_PATH

source /etc/profile
~~~



## 淘宝镜像

~~~bash
npm config set registry https://registry.npm.taobao.org

npm config get registry

npm install -g cnpm --registry=https://registry.npm.taobao.org

~~~







# Git

## 安装

+  yum -y install git 
+ git version

## 配置

配置用户名和用户邮件.(邮箱不一定要真实存在,一定保证要有的).

+ git config --global user.name "XXXX"
+ git config --global user.email  "XXXXXXXXXX@qq.com"  
+ git config --global user.password tianshan
+ git config --list (查看是否配置成功)



# Mysql

## yum安装5.7

+ 下载 mysql的yum仓库文件包

  ~~~bash
  wget http://repo.mysql.com/yum/mysql-5.7-community/el/7/x86_64/mysql57-community-release-el7-10.noarch.rpm
  rpm -ivh mysql57-community-release-el7-10.noarch.rpm
  ~~~

+ 安裝Mysql

  ~~~bash
  sudo yum -y install mysql-community-server
  ~~~

+ 如果报错：MySQL 5.7 Community Server“ 的 GPG 密钥已安装，但是不适用于此软件包

  ~~~bash
  rpm --import https://repo.mysql.com/RPM-GPG-KEY-mysql-2022
  ~~~

+ .启动mysql

  ~~~bash
  systemctl enable mysqld
  systemctl start mysqld
  systemctl status mysqld
  ~~~

+ 查看密码

  ~~~bash
  cat /var/log/mysqld.log |grep password
  ~~~

+ 登陆 mysql -u root -p

+ 修改密码

  ~~~bash
  SET PASSWORD = PASSWORD('root');
  alter user 'root'@'localhost' identified by 'Bob.123456';
  FLUSH PRIVILEGES;                                 
  ~~~

+ 远程登陆

  ~~~bash
  use mysql   #选择访问mysql库
  update user set host = '%' where user = 'root'; #使root能再任何host访问
  FLUSH PRIVILEGES;    #刷新
  ~~~



# Redis

## 安装

+ 生成文件夹

  ~~~bash
  mkdir redis
  ~~~

+ Redis 是基于 C语言编写的，所有还需要安装 Redis 所需要的 `gcc` 依赖：

  ~~~bash
  yum install -y  tcl
  yum install -y  cpp
  yum install -y binutils
  yum install -y  glibc
  yum install -y  glibc-kernheaders
  yum install -y  glibc-common
  yum install -y  glibc-devel
  yum install -y  gcc
  yum install -y  make
  ~~~

+ 上传Redis安装包

+ 解压

  ~~~bash
   tar -zxvf redis-6.0.9.tar.gz
  ~~~

+ 运行编译命令：make

## 修改配置文件

+ cp redis.conf redis.conf.bck

+ vi redis.conf

  ~~~conf
  # 监听地址，默认是 127.0.0.1，会导致只能在本地访问。修改成 0.0.0.0 则可以在任意 IP 访问，生产环境不要设置 0.0.0.0
  bind 0.0.0.0
  # 守护进程，修改为 yes 后即可后台运行
  daemonize yes
  # 密码，设置后访问 redis 必须输入密码
  requirepass 123456
  # 监听端口
  port 6379
  # 工作目录，默认是当前目录，也就是运行 redis-server 时的命令，日志、持久化等文件会保存在这个目录
  dir .
  # 数据库数量，设置为1，代表只使用1个库，默认有16个库，编号0~15
  databases 1
  # 设置 redis 能够使用的最大内存
  maxmemory 256mb
  # 日志文件，默认为空，不记录日志，可以指定日志文件名
  logfile "redis.log"
  
  ~~~

+ RDB 配置

  ~~~
  # 时间策略：当满足每900s/300s/60s内至少1/10/10000次写操作，则会触发bgsave命令进行持久化，三个策略中只需要满足其中任何一条即可持久化
  save 900 1
  save 300 10
  save 60 10000
  # 文件名称
  dbfilename dump.rdb
  # 文件保存路径
  dir /home/redis/data/
  # 如果持久化出错，主进程是否停止写入：是为了保证数据的一致性，工作进程（子进程）持久化出错后，主进程停止写入请求
  stop-writes-on-bgsave-error yes
  # 是否压缩
  rdbcompression yes
  # 导入时是否检查
  rdbchecksum yes
  ~~~

+ AOF 配置

  ~~~bash
  # 是否开启aof
  appendonly yes
  # 文件名称
  appendfilename "appendonly.aof"
  # 同步方式
  appendfsync everysec
   
  # aof重写操作是否同步，yes则不进行同步，no则同步
  no-appendfsync-on-rewrite no
   
  # 重写触发配置
  auto-aof-rewrite-percentage 100 # 当前AOF文件大小是上次日志重写时的AOF文件大小两倍时，发生BGREWRITEAOF操作。
  auto-aof-rewrite-min-size 64mb # 当前AOF文件执行BGREWRITEAOF命令的最小值，避免刚开始启动Reids时由于文件尺寸较小导致频繁的BGREWRITEAOF。
   
  # 加载aof时如果有错如何处理，忽略最后一条可能存在问题的指令
  aof-load-truncated yes
  # Redis4.0新增RDB-AOF混合持久化格式。
  aof-use-rdb-preamble no
  ~~~

  



## 启动

+ 指令

  ~~~bash
   ./src/redis-server redis.conf
  ~~~

+ 查看 redis 是否后台运行成功

  ~~~bash
  ps -ef | grep redis
  ~~~

## 设置开机启动

+ 新建一个系统服务文件：

  ~~~bash
  vi /etc/systemd/system/redis.service
  ~~~

+ 内容如下

  ~~~txt
  [Unit]
  Description=redis-server
  After=network.target
  
  [Service]
  Type=forking
  ExecStart=/usr/local/software/redis/src/redis-server /usr/local/software/redis/redis.conf
  PrivateTmp=true
  
  [Install]
  WantedBy=multi-user.target
  ~~~

+ 重载系统服务

  ~~~bash
  systemctl daemon-reload
  ~~~

+ 设置开机启动

  ~~~bash
  systemctl enable redis
  ~~~

+ 控制 Redis 服务

  ~~~bash
  systemctl start redis
  systemctl status redis
  systemctl stop redis
  systemctl restart redis
  ~~~



# Nginx 

## 安装

安装环境

~~~bash
#安装gcc
yum install gcc-c++
 
#安装PCRE pcre-devel
yum install -y pcre pcre-devel
 
#安装zlib
yum install -y zlib zlib-devel
 
#安装Open SSL
yum install -y openssl openssl-devel
~~~

下载nginx安装包

~~~bash
wget http://nginx.org/download/nginx-1.23.0.tar.gz 
~~~

安装

~~~bash
mv nginx-1.23.0 nginx
# 编译 执行命令 考虑到后续安装ssl证书 添加两个模块  如不需要直接执行./configure即可
./configure --with-http_stub_status_module --with-http_ssl_module
#执行make命令(要是执行不成功请检查最开始安装的四个依赖有没有安装成功)
make
#执行make install命令
make install
~~~

## 操作

~~~bash
cd /usr/local/nginx/sbin
# 默认配置文件启动
./nginx

# 指定配置文件启动
./nginx -c  /usr/local/nginx/conf/nginx.conf
~~~

localhost：80

停止重启nginx

~~~bash
cd /usr/local/nginx/sbin
# 停止指令
./nginx -s stop
# 或
./nginx -s quit

# 重启命令
./nginx -s reload

# 查看nginx进程
ps -ef|grep nginx
~~~

## 设置开机自启动nginx

~~~bash
#编辑
vim /etc/rc.local
 
#最底部增加这一行
/usr/local/nginx/sbin/nginx -c /usr/local/nginx/conf/nginx.conf

# 添加可执行权限
chmod +x /etc/rc.d/rc.local
~~~

## 配置nginx.conf

~~~bash
# 打开配置文件
vi /usr/local/nginx/conf/nginx.conf
~~~



# Tomcat

## 安装

+ 上传tomcat文件

+ 解压：tar  -zxvf apache-tomcat-9.0.48.tar.gz

+ 修改文件名称

  ~~~bash
  mv apache-tomcat-9.0.48 tomcat9
  ~~~

+ 启动 tomcat

  ~~~bash
  cd tomcat/bin
  ./startup.sh
  ~~~

+ 修改配置文件

  ~~~bash
  cd /usr/local/software/tomcat9/conf
  
  vi server.xml
  /8005 修改为9905
  /8080 修改为8002
  /8009 修改为9909
  修改完后保存，重启tomcat服务
  ~~~

+ 重新启动访问：http://192.168.160.128:8002/



# Docker

## 安装

卸载旧版本

~~~bahs
yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-selinux \
                  docker-engine-selinux \
                  docker-engine \
                  docker-ce

~~~

首先需要大家虚拟机联网，安装yum工具

~~~bash
yum install -y yum-utils \
           device-mapper-persistent-data \
           lvm2 --skip-broken
~~~

然后更新本地镜像源：

~~~bash
# 设置docker镜像源
yum-config-manager \
    --add-repo \
    https://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
    
sed -i 's/download.docker.com/mirrors.aliyun.com\/docker-ce/g' /etc/yum.repos.d/docker-ce.repo
yum makecache fast

~~~

下载安装

~~~bash
yum install -y docker-ce

docker -v
~~~

启动docker：

~~~bash
systemctl start docker  # 启动docker服务

systemctl status docker
systemctl enable docker

systemctl stop docker  # 停止docker服务

systemctl restart docker  # 重启docker服务

~~~

配置镜像加速

~~~bash
sudo mkdir -p /etc/docker

sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://akchsmlh.mirror.aliyuncs.com"]
}
EOF

##重新加载文件
sudo systemctl daemon-reload

##重启docker
sudo systemctl restart docker
~~~



# Rabbit MQ

## 安装

上传安装文件

~~~bash
erlang-21.3.8.18-1.el7.x86_64.rpm
rabbitmq-server-3.8.8-1.el7.noarch.rpm
~~~

安装erlang

~~~bash
# 解压
rpm -Uvh erlang-23.2.7-2.el7.x86_64.rpm

# 安装
yum install -y erlang


erl -v
~~~

安装RabbitMQ

~~~bash
yum install -y socat

# 解压
rpm -Uvh rabbitmq-server-3.8.8-1.el7.noarch.rpm

# 安装
yum install -y rabbitmq-server
~~~

启动

~~~bash
systemctl start rabbitmq-server

systemctl status rabbitmq-server

# 设置rabbitmq服务开机自启动
systemctl enable rabbitmq-server

# 关闭rabbitmq服务
systemctl stop rabbitmq-server

# 重启rabbitmq服务
systemctl restart rabbitmq-server

~~~

安装web端

~~~bash
# 默认情况下，rabbitmq没有安装web端的客户端软件，需要安装才可以生效
# 打开RabbitMQWeb管理界面插件
rabbitmq-plugins enable rabbitmq_management

~~~

然后我们打开浏览器，访问`服务器公网ip:15672`（注意打开阿里云安全组以及防火墙的15672端口），就可以看到管理界面

`rabbitmq`有一个默认的账号密码`guest`，但该情况仅限于本机localhost进行访问，所以需要添加一个远程登录的用户

~~~bash
# 添加用户
rabbitmqctl add_user krest 123456

# 设置用户角色,分配操作权限
rabbitmqctl set_user_tags krest administrator

# 为用户添加资源权限(授予访问虚拟机根节点的所有权限)
rabbitmqctl set_permissions -p / krest ".*" ".*" ".*"

~~~

**角色有四种**：

- `administrator`：可以登录控制台、查看所有信息、并对rabbitmq进行管理
- `monToring`：监控者；登录控制台，查看所有信息
- `policymaker`：策略制定者；登录控制台指定策略
- `managment`：普通管理员；登录控制

其他指令：

~~~bash
# 修改密码
rabbitmqctl change_ password 用户名 新密码

# 删除用户
rabbitmqctl delete_user 用户名

# 查看用户清单
rabbitmqctl list_users

~~~





# Rocket MQ

## 安装

安装 nameServer

Rocekt 的安装颇为繁琐，这里采用docker的方式进行启动和使用

~~~bash
# 搜索/拉取镜像
docker search rocketmq
docker pull rocketmqinc/rocketmq:4.4.0

# 创建一个数据目录
mkdir -p /usr/local/software/data/rocketmq/nameserver/logs
mkdir -p /usr/local/software/data/rocketmq/nameserver/store
mkdir -p /usr/local/software/data/rocketmq/broker/logs
mkdir -p /usr/local/software/data/rocketmq/broker/store
mkdir -p /usr/local/software/data/rocketmq/broker/


# 增加 broker 配置文件
vi /usr/local/software/data/rocketmq/broker/bocker.cnf

brokerClusterName = DefaultCluster
brokerName = broker-a
brokerId = 0
deleteWhen = 04
fileReservedTime = 48
brokerRole = ASYNC_MASTER
flushDiskType = ASYNC_FLUSH
brokerIP1 = 192.168.160.128


# 运行 nameserver
docker run -d \
--restart=always \
--name rmqnamesrv \
--privileged=true \
-p 9876:9876  \
-v /usr/local/software/data/rocketmq/nameserver/logs:/root/logs \
-v /usr/local/software/data/rocketmq/nameserver/store:/root/store \
-e "MAX_POSSIBLE_HEAP=100000000" rocketmqinc/rocketmq:4.4.0 sh mqnamesrv

~~~

安装 broker

创建broker.conf配置文件，我的目录是/opt/docker/rocketmq/broker.conf，文件内容如下

~~~
vi /usr/local/software/data/rocketmq/bocker.cnf

brokerClusterName = DefaultCluster
brokerName = broker-a
brokerId = 0
deleteWhen = 04
fileReservedTime = 48
brokerRole = ASYNC_MASTER
flushDiskType = ASYNC_FLUSH
brokerIP1 = 192.168.160.128

~~~

创建broker配置文件挂载文件夹

~~~bash
docker run -d \
--restart=always \
-p 10911:10911 \
-p 10909:10909  \
-v /usr/local/software/data/rocketmq/broker/logs:/root/logs \
-v /usr/local/software/data/rocketmq/broker/store:/root/store  \
-v /usr/local/software/data/rocketmq/broker/bocker.cnf:/opt/rocketmq-4.4.0/conf/broker.conf \
--name rmqbroker \
--link rmqnamesrv:namesrv \
-e "NAMESRV_ADDR=namesrv:9876" \
-e "MAX_POSSIBLE_HEAP=200000000" \
rocketmqinc/rocketmq:4.4.0 sh mqbroker \
-c /opt/rocketmq-4.4.0/conf/broker.conf
~~~

启动web容器、

~~~bash
docker run -d \
--restart=always \
-e "JAVA_OPTS=-Drocketmq.namesrv.addr=192.168.160.128:9876  -Dcom.rocketmq.sendMessageWithVIPChannel=false" \
-p 8081:8080 \
-t pangliang/rocketmq-console-ng
~~~

访问路径 ： http://192.168.160.128:8081/

# Canal

### 地址

+ [canal-github](https://github.com/alibaba/canal)

### 版本特色

1. canal 1.1.x 版本（[release_note](https://github.com/alibaba/canal/releases)）,性能与功能层面有较大的突破,重要提升包括:
   + 整体性能测试&优化,提升了150%. 
   + 原生支持prometheus监控 
   + 原生支持kafka消息投递 
   + 原生支持aliyun rds的binlog订阅 (解决自动主备切换/oss binlog离线解析) 
   + 原生支持docker镜像 
2. canal 1.1.4版本，迎来最重要的WebUI能力，引入canal-admin工程，支持面向WebUI的canal动态管理能力，支持配置、任务、日志等在线白屏运维能力，具体文档：[Canal Admin Guide](



# HBASE

## 基本安装部署

+  Zookeeper 正常部署

+ Hadoop 正常部署

+ HBase的解压

  + 解压 Hbase 到指定目录

  ~~~bash
  [atguigu@hadoop102 software]$ tar -zxvf hbase-2.4.11-bin.tar.gz -C 
  /opt/module/
  [atguigu@hadoop102 software]$ mv /opt/module/hbase-2.4.11
  /opt/module/hbase
  ~~~

  + 配置环境变量

  ~~~bash
  [atguigu@hadoop102 ~]$ sudo vim /etc/profile.d/my_env.sh
  
  #HBASE_HOME
  export HBASE_HOME=/opt/module/hbase
  export PATH=$PATH:$HBASE_HOME/bin
  ~~~

  + 使用 source 让配置的环境变量生效

  ~~~bash
  [atguigu@hadoop102 module]$ source /etc/profile.d/my_env.sh
  ~~~

+ HBase的配置文件

  + hbase-env.sh 修改内容，可以添加到最后：

  ~~~sh
  export HBASE_MANAGES_ZK=false
  ~~~

  + hbase-site.xml 修改内容

  ~~~xml
  <?xml version="1.0"?>
  <?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
  <configuration>
      <property>
          <name>hbase.zookeeper.quorum</name>
          <value>hadoop102,hadoop103,hadoop104</value>
          <description>The directory shared by RegionServers.
          </description>
      </property>
      <!-- <property>-->
      <!-- <name>hbase.zookeeper.property.dataDir</name>-->
      <!-- <value>/export/zookeeper</value>-->
      <!-- <description> 记得修改 ZK 的配置文件 -->
      <!-- ZK 的信息不能保存到临时文件夹-->
      <!-- </description>-->
      <!-- </property>-->
      <property>
          <name>hbase.rootdir</name>
          <value>hdfs://hadoop102:8020/hbase</value>
          <description>The directory shared by RegionServers.
          </description>
      </property>
      <property>
          <name>hbase.cluster.distributed</name>
          <value>true</value>
      </property>
  </configuration> 	
  ~~~

+ regionservers

  ~~~txt
  hadoop102
  hadoop103
  hadoop104
  ~~~

+ 解决 HBase 和 Hadoop 的 log4j 兼容性问题，修改 HBase 的 jar 包，使用 Hadoop 的 jar 包

  ~~~bash
  [atguigu@hadoop102 hbase]$ mv /opt/module/hbase/lib/client-facingthirdparty/slf4j-reload4j-1.7.33.jar /opt/module/hbase/lib/clientfacing-thirdparty/slf4j-reload4j-1.7.33.jar.bak
  ~~~

+  HBase 远程发送到其他集群

  ~~~bash
  [atguigu@hadoop102 module]$ xsync hbase/
  ~~~

+ 服务的启动

  + 单点启动

  ~~~bash
  [atguigu@hadoop102 hbase]$ bin/hbase-daemon.sh start master
  [atguigu@hadoop102 hbase]$ bin/hbase-daemon.sh start regionserver
  ~~~

  + 群启

  ~~~bash
  [atguigu@hadoop102 hbase]$ bin/start-hbase.sh
  ~~~

  + 对应的停止服务

  ~~~bash
  [atguigu@hadoop102 hbase]$ bin/stop-hbase.sh
  ~~~

+ 查看HBase 页面：启动成功后，可以通过“host:port”的方式来访问 HBase 管理页面，例如：

## 高可用（可选）

在 HBase 中 HMaster 负责监控 HRegionServer 的生命周期，均衡 RegionServer 的负载，如果 HMaster 挂掉了，那么整个 HBase 集群将陷入不健康的状态，并且此时的工作状态并不会维持太久。所以 HBase 支持对 HMaster 的高可用配置

+ 关闭HBase **集群（如果没有开启则跳过此步）**

  ~~~bash
  [atguigu@hadoop102 hbase]$ bin/stop-hbase.sh
  ~~~

+ 在conf目录下创建backup-masters文件

  ~~~bash
  [atguigu@hadoop102 hbase]$ touch conf/backup-masters
  ~~~

+ 在backup-masters文件中配置高可用HMaster节点

  ~~~bash
  [atguigu@hadoop102 hbase]$ echo hadoop103 > conf/backup-masters
  ~~~

+ 将整个conf目录scp到其他节点

  ~~~bash
  [atguigu@hadoop102 hbase]$ xsync conf
  ~~~

+ 重启 hbase,打开页面测试查看





