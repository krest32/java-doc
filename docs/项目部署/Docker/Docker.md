# Docker

## 介绍

### 概念

​		Docker是一个容器化平台，它以容器的形式将你的应用程序及所有的依赖项打包在一起，以确保你的应用程序在任何环境中无缝运行。

### 目的

​		安装一个比较稳定的环境运行程序，docker技术是在操作系统的基础之上，通过操作系统的复用，实现虚拟化，因此docker相比于传统虚拟化技术，资源占用更少，效率更高。

### 由来

1. 2010 年，一对年轻人创办Pass平台，到了2013年，亚马逊、微软、Google也开始做Pass，所以小公司开始对外开源核心技术，也就是Docker的前身，到了2014年，公司得到了C轮融资，专门用来维护Docker，到了2015年得到了D轮融资。

2. Docker的作者已经离开Docker

### 思想

1. 提供了一个标准化的运行环境
2. 轻量级的运行环境，启动更加方便，比虚拟机启动更快
3. 隔离性更加方便，模块下的使用，docker开辟了一个空间，然后提供了一个更好的隔离环境
4. 运行程序的集装箱

### 优势

1. 交付物标准化： Docker是软件工程领域的“标准化”交付组件，最恰到好处的类比是“集装箱”。

   集装箱将零散、不易搬运的大量物品封装成一个整体，集装箱更重要的意义在于它提供了一种通用的封装货物的标准，卡车、火车、货轮、桥吊等运输或搬运工具采用此标准，隧道、桥梁等也采用此标准。以集装箱为中心的标准化设计大大提高了物流体系的运行效率。

   传统的软件交付物包括：应用程序、依赖软件安装包、配置说明文档、安装文档、上线文档等非标准化组件。Docker的标准化交付物称为“镜像”，它包含了应用程序及其所依赖的运行环境，大大简化了应用交付的模式。

2. 一次构建，多次交付，更容易横向扩展

   类似于集装箱的“一次装箱，多次运输”，Docker镜像可以做到“一次构建，多次交付”。当涉及到应用程序多副本部署或者应用程序迁移时，更能体现Docker的价值。

3. 应用隔离，

   集装箱可以有效做到货物之间的隔离，使化学物品和食品可以堆砌在一起运输。Docker可以隔离不同应用程序之间的相互影响，但是比虚拟机开销更小。

4. 更容易进行迁移和扩展，移植性更强，屏蔽底层环境差异

   docker容器几乎可以在任意的平台上运行，包括乌力吉、虚拟机、公有云、私有云、个人电脑、服务器等，这种兼容性让用户可以在不同平台之间轻松的迁移应用。

### Docker优点

1. 标准化应用发布，docker容器包含了运行环境和可执行程序，可以跨平台和主机使用；
2. 节约时间，快速部署和启动，VM启动一般是分钟级，docker容器启动是秒级；
3. 方便构建基于SOA架构或微服务架构的系统，通过服务编排，更好的松耦合；
4. 节约成本，以前一个虚拟机至少需要几个G的磁盘空间，docker容器可以减少到MB级；
5. 方便持续集成，通过与代码进行关联使持续集成非常方便；
6. 可以作为集群系统的轻量主机或节点，在IaaS平台上，已经出现了CaaS，通过容器替代原来的主机。

### 容器的状态

1. 运行、
2. 已停止、
3. 重新启动、
4. 已退出

### 组成部分

1. Docker Client客户端
2. Docker Daemon守护进程
3. Docker Image镜像
4. Docker Container容器　　　　

## 镜像

1. 使用前先拉取镜像

~~~
docker pull 镜像名称[:tag]
#举例子
docker pull daocloud.io/library/tomcat:8.5.15-jre8
~~~

2. 查看本地的镜像

~~~
docker images
~~~

3. 删除本地镜像

~~~
docker rmi 镜像的唯一标识
# 删除本地所有镜像
docker rmi  -f  $(docker images -qa)

# 删除所有标签为空的镜像
docker rmi  -f  $(docker images -qf dangling=true)

~~~

4. 镜像的导入导出（不规范）

~~~
#将本地的镜像导出
docker save -o 导出的路径 镜像id
#加载本地的镜像文件
docker load -i 镜像名称
~~~

5. 改变docker的名称

~~~
docker tag 镜像标签 更改的名称：版本
~~~

## 容器的操作

1. 运行容器

~~~bash
#简单操作
docker run 镜像的标识|镜像的名称[:tag]
#常规操做
docker run -d -p 宿主机端口:容器端口 --name 容器名称 镜像的标识|镜像的名称[:tag]
#-d 代表后台运行，-p 宿主机端口:容器端口：为了映射当前linux的端口和容器的端口，外部能够访问到docker容器
#--name 容器名称：指定容器的名称
# docker run -d -p 6379:6379 --name myredis docker.io/redis  --net=host
~~~

2. 查看正在运行的容器

~~~bash
docker ps [-a或者-q]
# -a 查看docker的全部
# -q 只查看docker的标识
~~~

3. 查看docker的日志（重要）

~~~bash
docker logs -f 容器id
# -f 代表可以滚动查看日志的最后几行
~~~

4. 进入到容器内部进行操作

~~~bash
docker  exec  -it 容器id bash
~~~

5. 删除容器

~~~bash
# 删除容器前需要先停止容器
docker rm 容器id
# 删除所有容器
docker rm $(docker ps -qa)
~~~

6. 停止容器

~~~bash
#停止容器
docker stop 容器id
#停止全部容器
docker stop $(docker ps -qa)
~~~

7. 启动容器

~~~bash
docker start 容器id
~~~

8. 删除标签为None的镜像

~~~bash
docker rmi $(docker images | grep "<none>" | awk '{print $3}')
~~~

# ElasticSearch 

搜索镜像

~~~
docker search elasticsearch
~~~

拉取镜像

~~~
 docker pull elasticsearch:7.1.1
~~~

查看拉取得到的镜像

~~~
docker images
~~~



通过镜像，启动一个容器，并将9200和9300端口映射到本机（`ElasticSearch`的默认端口是9200，我们把宿主环境9200端口映射到Docker容器中的9200端口）

~~~
docker run -d --name es -p 9200:9200 -p 9300:9300 -e ES_JAVA_OPTS="-Xms512m -Xmx512m" -e "discovery.type=single-node" elasticsearch:7.6.0
~~~



配置跨域，进入容器内部，修改`elasticsearch.yml`

~~~
docker exec -it es /bin/bash
~~~

~~~
[root@c11ef1beb4f3 elasticsearch]# ls
LICENSE.txt  NOTICE.txt  README.textile  bin  config  data  lib  logs  modules  plugins
[root@c11ef1beb4f3 elasticsearch]# cd config/
[root@c11ef1beb4f3 config]# ls
elasticsearch.keystore  ingest-geoip  log4j2.properties  roles.yml  users_roles
elasticsearch.yml       jvm.options   role_mapping.yml   users
[root@c11ef1beb4f3 config]# vi elasticsearch.yml
~~~

新增跨域配置

~~~
cluster.name: "docker-cluster"
network.host: 0.0.0.0
http.cors.enabled: true
http.cors.allow-origin: "*"
  
# minimum_master_nodes need to be explicitly set when bound on a public IP
# set to 1 to allow single node clusters
# Details: https://github.com/elastic/elasticsearch/pull/17288
discovery.zen.minimum_master_nodes: 1
~~~

退出容器

~~~
exit
~~~

重启`ElasticSearch`容器

~~~
docker restart es
~~~

# ElasticSearch-Head

查找镜像

~~~
docker search elasticsearch-Head
~~~

拉取镜像

~~~
# 没有找到7.1.1的版本
docker pull mobz/elasticsearch-head:5
~~~

查看镜像

~~~
docker images
~~~

启动镜像

~~~
docker run -d --name es_head -p 9100:9100 mobz/elasticsearch-head:5
~~~

# 部署ik中文分词插件

进入es容器内部，`/plugins`下新建`ik`文件夹

~~~
[root@iZwz99dhxbd6xwly17tb3bZ ~]# docker exec -it es /bin/bash
[root@970f612c5cac elasticsearch]# ls
LICENSE.txt  NOTICE.txt  README.textile  bin  config  data  lib  logs  modules  plugins
[root@970f612c5cac elasticsearch]# cd plugins/
[root@970f612c5cac plugins]# mkdir ik
[root@970f612c5cac plugins]# ls
ik 
~~~

下载与es对应版本的`ik`压缩包，并解压

注意：这一步有的人服务器不支持zip所以解压不了。我是从电脑上解压后弄成tar.gz文件上传到服务器然后cp到容器内部对应文件夹下，命令

~~~
[root@970f612c5cac plugins]# cd ik
[root@970f612c5cac ik]# wget https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.6.0/elasticsearch-analysis-ik-7.6.0.zip
[root@970f612c5cac ik]# unzip elasticsearch-analysis-ik-7.6.0.zip
[root@970f612c5cac ik]# ls
commons-codec-1.9.jar    elasticsearch-analysis-ik-6.3.2.jar  plugin-descriptor.properties
commons-logging-1.2.jar  httpclient-4.5.2.jar                 plugin-security.policy
config                   httpcore-4.4.4.jar
~~~

退出容器，重启es容器

~~~
[root@970f612c5cac ik]# exit
exit
[root@iZwz99dhxbd6xwly17tb3bZ ~]# docker restart es
~~~

# Kibana

查找镜像

~~~
docker search kibana
~~~

拉取镜像

```txt
docker pull docker.io/kibana:7.1.1
```

启动kibana我们的服务器IP是`172.18.63.211es`

```
docker run --restart=always -itd --name kibana --link es:elasticsearch -p 5601:5601 kibana:7.6.0
```

进入容器修改配置文件`kibana.yml`

```
docker exec  -it kibana bash
vi config/kibana.yml
########################
# 指定es的地址
elasticsearch.hosts: ["http://172.17.59.5:9200"]

# 修改外网访问 可选
server.host: "0.0.0.0"
exit
########################
docker restart kibana
```

打开地址：`http://172.18.63.211:5601`



测试分词工具

```
POST _analyze
{
  "text": "检测甘蓝型油菜抗磺酰脲类除草剂基因BnALS3R的引物与应用",
  "analyzer": "hanlp"
}
```

新增索引库

```
PUT achievement
{
  "settings": {
    "number_of_shards": 1,
    "number_of_replicas": 1
  }
}


PUT achievement/_mapping
{
  "properties": {
    "id": {
      "type": "text"
    },
    "owner": {
      "type": "text"
    },
    "title": {
      "type": "text",
      "analyzer": "hanlp"
    },
    "description": {
      "type": "text",
      "analyzer": "hanlp"
    },
    "update_time":{
      "type": "date"
    }
  }
}
```



#　LogStash



添加配置文件

~~~conf
input {        
  file {
    path => "/var/log/glog/*"
    type => "file_2_console"
    start_position => "beginning"
  }
}
output {
  if [type] == "file_2_console" {
      stdout {
       codec => rubydebug
    }
  }
}
~~~



~~~bash
 docker pull logstash:7.6.0
 
 # 
 docker run -d  -v /usr/local/logstash/config/:/usr/share/logstash/pipeline/ -p 4560:4560 -p 4561:4561 -p 4562:4562 -p 4563:4563  --net host --name logstash logstash:7.6.0
~~~







# Redis

首先我们通过Dockr搜索Redis有关的镜像源

```bash
docker search redis
```

接着我们通过Docker下载Redis镜像源

```bash
docker pull redis
```

这里没有设置版本好就会默认下载**latest**的镜像源。

```bash
[root@localhost ~]# docker images
REPOSITORY                TAG                 IMAGE ID            CREATED             SIZE
docker.io/tomcat          latest              aeea3708743f        9 days ago          529 MB
docker.io/rabbitmq        latest              2b5cda43d345        2 weeks ago         151 MB
docker.io/elasticsearch   7.6.0               5d2812e0e41c        2 weeks ago         790 MB
docker.io/redis           latest              44d36d2c2374        2 weeks ago         98.2 MB
docker.io/mysql           latest              791b6e40940c        2 weeks ago         465 MB
[root@localhost ~]# 
```

接着创建并启动Redis容器

首先启动Docker

```bash
[root@localhost ~]# systemctl start docker
```

在Docker中启动Redis

这里我们没有设置容器的别名，`-d`代表后台启动。

```bash
[root@localhost ~]# docker run -d redis
da45019bf760304a66c3dd96b8847a50eddd8c73ff77cd3b3f37a46d7f016834
```

也可以这样启动Redis，其中`-p`代表端口映射，将容器中的6379映射到运行Docker机器中的6379端口，`--name`表示自定义容器名

```bash
[root@localhost ~]# docker run -d -p 6379:6379   --name="myredis"  redis
249dd65794b32310dea5e094f41df845d971b623382ddc1179c404402f576750
[root@localhost ~]# 
```

进入Redis终端

```bash
docker exec ：在运行的容器中执行命令
# 语法
docker exec [OPTIONS] CONTAINER COMMAND [ARG...]
# OPTIONS说明：
-d :分离模式: 在后台运行
-i :即使没有附加也保持STDIN 打开
-t :分配一个伪终端
```

而Docker中的容器ID可以用`docker -ps`来查看

```bash
[root@localhost ~]# docker ps
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES
249dd65794b3        redis               "docker-entrypoint..."   3 minutes ago       Up 3 minutes        0.0.0.0:6379->6379/tcp   myredis
da45019bf760        redis               "docker-entrypoint..."   18 minutes ago      Up 18 minutes       6379/tcp                 naughty_pasteur
[root@localhost ~]# 
```

`redis-cli`表示运行一个`redis`客户端。

```bash
[root@localhost ~]# docker exec -it da45019bf760 redis-cli
127.0.0.1:6379> 
127.0.0.1:6379> set msg "Hello World Redis"
OK
127.0.0.1:6379> get msg
"Hello World Redis"
127.0.0.1:6379>
```

