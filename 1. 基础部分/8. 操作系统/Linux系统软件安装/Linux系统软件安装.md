# LINUX

## Linux系统简介

### 简介

​		严格的来讲，Linux 不算是一个操作系统，只是一个 Linux 系统中的**内核**，即计算机软件与硬件通讯之间的平台；Linux的全称是GNU/Linux，这才算是一个真正意义上的Linux系统。GNU是Richard Stallman组织的一个项目，世界各地的程序员可以变形GNU程序，同时遵循GPL协议，允许任何人任意改动。但是，修改后的程序必须遵循GPL协议。

​		Linux 是一个多用户多任务的操作系统，也是一款自由软件，完全兼容POSIX标准，拥有良好的用户界面，支持多种处理器架构，移植方便。

​		为程序分配系统资源，处理计算机内部细节的软件叫做操作系统或者内核。用户通过Shell与Linux内核交互。

​		**Shell是一个命令行解释工具（是一个软件），它将用户输入的命令转换为内核能够理解的语言（命令）。**

​		Linux下，很多工作都是通过命令完成的，学好Linux，首先要掌握常用命令。

> **补充GPL协议**
>
> 如果你发布这样一个程序的副本，不管是收费的还是免费的，你必须将你具有的一切权利给予你的接受者；你必须保证他们能收到或得到[源程序](https://baike.baidu.com/item/源程序)；并且将这些条款给他们看，使他们知道他们有这样的权利。
>
> 我们采取两项措施来保护你的权利。
>
> （1）给软件以版权保护。
>
> （2）给你提供许可证。它给你复制，发布和修改这些软件的法律许可。



### Linux版本

​		内核版本指的是在 Linus 领导下的开发小组开发出的系统内核的版本号。Linux 的每个内核版本使用形式为 x.y.zz-www 的一组数字来表示。其中：

- x.y：为linux的主版本号。通常y若为奇数，表示此版本为测试版，系统会有较多bug，主要用途是提供给用户测试。

- zz：为次版本号。

- www：代表发行号（注意，它与发行版本号无关）。

  

​       当内核功能有一个飞跃时，主版本号升级，如 Kernel2.2、2.4、2.6等。如果内核增加了少量补丁时，常常会升级次版本号，如Kernel2.6.15、2.6.20等。

​		一些组织或厂家将 Linux 内核与GNU软件（系统软件和工具）整合起来，并提供一些安装界面和系统设定与管理工具，这样就构成了一个发型套件，例如Ubuntu、Red Hat、**Centos**、Fedora、SUSE、Debian、FreeBSD等。相对于内核版本，发行套件的版本号随着发布者的不同而不同，与系统内核的版本号是相对独立的。因此把Red Hat等直接说成是Linux是不确切的，它们是Linux的发行版本，更确切地说，应该叫做“以linux为核心的操作系统软件包”。

​		目前来说使用比较多的是Centos，主要原因是**CentOS 偏重于优化服务器端的稳定性**



### Linux体系结构

​		下面是Linux体系结构的示意图：

![img](http://c.biancheng.net/cpp/uploads/allimg/140720/1-140H01Z521963.jpg)

在所有Linux版本中，都会涉及到以下几个重要概念：

- 内核：内核是操作系统的核心。内核直接与硬件交互，并处理大部分较低层的任务，如内存管理、进程调度、文件管理等。
- Shell：Shell是一个处理用户请求的工具，它负责解释用户输入的命令，调用用户希望使用的程序。
- 命令和工具：日常工作中，你会用到很多系统命令和工具，如cp、mv、cat和grep等。在Linux系统中，有250多个命令，每个命令都有多个选项；第三方工具也有很多，他们也扮演着重要角色。
- 文件和目录：Linux系统中所有的数据都被存储到文件中，这些文件被分配到各个目录，构成文件系统。Linux的目录与Windows的文件夹是类似的概念。



## 常用命令

### 用户相关

1. **查看当前用户**

~~~
whoami
~~~

![image-20200625002643975](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625002643975.png)

2. **查看当前在线用户**

~~~
users
~~~

![image-20200625002808202](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625002808202.png)

~~~
//信息比users更加详细
who
~~~

![image-20200625002849810](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625002849810.png)

~~~
//信息显示会比who更加详细
W
~~~

![image-20200625003052556](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625003052556.png)

3. **退出登录**

~~~
logout
~~~

4. **关闭指令**

![image-20200625003407946](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625003407946.png)

### 文件管理

1. **简介**

   ​		Linux中的所有数据都被保存在文件中，所有的文件被分配到不同的目录。目录是一种类似于树的结构，称为文件系统。

   ​		当你使用Linux时，大部分时间都会和文件打交道，通过本节可以了解基本的文件操作，如创建文件、删除文件、复制文件、重命名文件以及为文件创建链接等。

2. **查看文件**

   查看当前目录下的文件和目录可以使用 **ls** 命令，通过-l可以获得更多的信息

   ~~~
   ls -l
   ~~~

   ![image-20200625004037819](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625004037819.png)

   

   每一列的含义如下：

- 第一列：文件类型。
- 第二列：表示文件个数。如果是文件，那么就是1；如果是目录，那么就是该目录中文件的数目。
- 第三列：文件的所有者，即文件的创建者。
- 第四列：文件所有者所在的用户组。在Linux中，每个用户都隶属于一个用户组。
- 第五列：文件大小（以字节计）。
- 第六列：文件被创建或上次被修改的时间。
- 第七列：文件名或目录名。


注意：每一个目录都有一个指向它本身的子目录"." 和指向它上级目录的子目录".."，所以对于一个空目录，第二列应该为 2。

通过 **ls -l** 列出的文件，每一行都是以 a、d、- 或 l 开头，这些字符表示文件类型：

| 前缀 | 描述                                                         |
| ---- | ------------------------------------------------------------ |
| -    | 普通文件。如文本文件、二进制可执行文件、源代码等。           |
| b    | 块设备文件。硬盘可以使用块设备文件。                         |
| c    | 字符设备文件。硬盘也可以使用字符设备文件。                   |
| d    | 目录文件。目录可以包含文件和其他目录。                       |
| l    | 符号链接（软链接）。可以链接任何普通文件，类似于 Windows 中的快捷方式。 |
| p    | 具名管道。管道是进程间的一种通信机制。                       |
| s    | 用于进程间通信的套接字。                                     |


提示：通俗的讲软连接就是windows的快捷方式，原来文件删了，快捷方式虽然在但是不起作用了。

3. **隐藏文件**

隐藏文件的第一个字符为英文句号或点号(.)，Linux程序（包括Shell）通常使用隐藏文件来保存配置信息。

>  下面是一些常见的隐藏文件：
>  .profile：Bourne shell (sh) 初始化脚本
>  .kshrc：Korn shell (ksh) 初始化脚本
>  .cshrc：C shell (csh) 初始化脚本
>  .rhosts：Remote shell (rsh) 配置文件

查看隐藏文件需要使用 **ls** 命令的 **-a** 选项：

```
$ ls -a

.         .profile       docs     lib     test_results
..        .rhosts        hosts    pub     users
.emacs    bin            hw1      res.01  work
.exrc     ch07           hw2      res.02
.kshrc    ch07.bak       hw3      res.03
$
```

一个点号(.)表示当前目录，两个点号(..)表示上级目录

4. **创建文件**

在Linux中，可以使用 vi 编辑器创建一个文本文件，例如：

```
$ vi filename
```

上面的命令会创建文件 filename 并打开，按下 i 键即可进入编辑模式，你可以向文件中写入内容。例如：

```
This is Linux file....I created it for the first time.....
I'm going to save this content in this file.
```

完成编辑后，可以按 esc 键退出编辑模式，也可以按组合键 Shift + ZZ 完全退出文件。这样，就完成了文件的创建。

```
$ vi filename
$
```

5. **编辑文件**

vi 编辑器可以用来编辑文件。由于篇幅限制，这里仅作简单介绍，将在后面章节进行详细讲解。

如下可以打开一个名为 filename 的文件：

```
$ vi filename
```

当文件被打开后，可以按 i 键进入编辑模式，按照自己的方式编辑文件。如果想移动光标，必须先按 esc 键退出编辑模式，然后使用下面的按键在文件内移动光标：

- l 键向右移动
- h 键向左移动
- k 键向上移动
- j 键向下移动


使用上面的按键，可以将光标快速定位到你想编辑的地方。定位好光标后，按 i 键再次进入编辑模式。编辑完成后按 esc 键退出编辑模式或者按组合键 Shift+ZZ 退出当前文件。

6. **查看文件内容**

可以使用 **cat** 命令来查看文件内容，下面是一个简单的例子：

```
$ cat filename
This is Linux file....I created it for the first time.....
I'm going to save this content in this file.
$
```

可以通过 **cat** 命令的 **-b** 选项来显示行号，例如：

```
$ cat -b filename
1   This is Linux file....I created it for the first time.....
2   I'm going to save this content in this file.
$
```

7. **统计文件内容**

可以使用 **wc** 命令来统计当前文件的行数、单词数和字符数，下面是一个简单的例子：

```
$ wc filename
2  19 103 filename
$
```

每一列的含义如下：

- 第一列：文件的总行数
- 第二列：单词数目
- 第三列：文件的字节数，即文件的大小
- 第四列：文件名


也可以一次查看多个文件的内容，例如：

```
$ wc filename1 filename2 filename3
```

8. **复制文件**

可以使用 **cp** 命令来复制文件。**cp** 命令的基本语法如下：

```
$ cp source_file destination_file
```

下面的例子将会复制 filename 文件：

```
$ cp filename copyfile
$
```

现在在当前目录中会多出一个和 filename 一模一样的 copyfile 文件。

9. **重命名文件**

重命名文件可以使用 **mv** 命令，语法为：

```
$ mv old_file new_file
```

下面的例子将会把 filename 文件重命名为 newfile：

```
$ mv filename newfile
$
```

现在在当前目录下，只有一个 newfile 文件。

**mv** 命令其实是一个移动文件的命令，不但可以更改文件的路径，也可以更改文件名。

10. **删除文件**

**rm**命令可以删除文件，语法为：

```
$ rm filename
```

注意：删除文件是一种危险的行为，因为文件内可能包含有用信息，建议结合 **-i** 选项来使用 **rm** 命令。

下面的例子会彻底删除一个文件：

```
$ rm filename
$
```

你也可以一次删除多个文件：

```
$ rm filename1 filename2 filename3
$
```

11. **标准的Linux流**

一般情况下，每个Linux程序运行时都会创建三个文件流（三个文件）：

- 标准输入流(stdin)：stdin的文件描述符为0，Linux程序默认从stdin读取数据。
- 标准输出流(stdout)：stdout 的文件描述符为1，Linux程序默认向stdout输出数据。
- 标准错误流(stderr)：stderr的文件描述符为2，Linux程序会向stderr流中写入错误信息。





### 进程管理

1. 查看当前进程

~~~
// -f full的缩写，显示所有的进程
ps -f
~~~

![image-20200625005425690](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625005425690.png)



每列的含义如下：

| 列    | 描述                                       |
| ----- | ------------------------------------------ |
| UID   | 进程所属用户的ID，即哪个用户创建了该进程。 |
| PID   | 进程ID。                                   |
| PPID  | 父进程ID，创建该进程的进程称为父进程。     |
| C     | CPU使用率。                                |
| STIME | 进程被创建的时间。                         |
| TTY   | 与进程有关的终端类型。                     |
| TIME  | 进程所使用的CPU时间。                      |
| CMD   | 创建该进程的命令。                         |


ps 命令还有其他一些选项：

| 选项 | 说明                           |
| ---- | ------------------------------ |
| -a   | 显示所有用户的所有进程。       |
| -x   | 显示无终端的进程。             |
| -u   | 显示更多信息，类似于 -f 选项。 |
| -e   | 显示所有进程。                 |





2. **终止进程**

当进程运行在前台时，可以通过 **kill** 命令或 Ctrl+C 组合键来结束进程。

如果进程运行在后台，那么首先要通过 **ps** 命令来获取进程ID，然后使用 **kill** 命令“杀死”进程，例如：

```
$ps -f
UID      PID  PPID C STIME    TTY   TIME CMD
amrood   6738 3662 0 10:23:03 pts/6 0:00 first_one
amrood   6739 3662 0 10:22:54 pts/6 0:00 second_one
amrood   3662 3657 0 08:10:53 pts/6 0:00 -ksh
amrood   6892 3662 4 10:51:50 pts/6 0:00 ps -f
$kill 6738
Terminated
```

如上所示，kill 命令终结了 first_one 进程。

如果进程忽略 kill 命令，那么可以通过 kill -9 来结束：

```
$kill -9 6738
Terminated
```





3. **Top命令**

   ​		top 命令是一个很有用的工具，它可以动态显示正在运行的进程，还可以按照指定条件对进程进行排序，与Windows的任务管理器类似。可以显示进程的很多信息，包括物理内存、虚拟内存、CPU使用率、平均负载以及繁忙的进程等。

![image-20200625010036774](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625010036774.png)







### 用户管理

1. **在Linux中，有三种用户：**

- Root 用户：也称为超级用户，对系统拥有完全的控制权限。超级用户可以不受限制的运行任何命令。Root 用户可以看做是系统管理员。
- 系统用户：系统用户是Linux运行某些程序所必须的用户，例如 mail 用户、sshd 用户等。系统用户通常为系统功能所必须的，不建议修改这些用户。
- 普通用户：一般用户都是普通用户，这些用户对系统文件的访问受限，不能执行全部Linux命令。

2. 查看防火墙

~~~
firewall-cmd --list-all
~~~

![image-20200625010529313](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200625010529313.png)

可以查看到目前开放的端口有哪些

3. **端口的使用举例**

   > 目的：linux系统会作为服务器使用，通常我们不是直接在Linux系统上操作，都是通过远程调用的方式，开启远程调用的方式需要两个步骤：**开放响应程序端口 和 开启程序本身的远程调用模式**

   > 【1】开放3306端口
   >
   > ```
   > firewall-cmd --permanent --add-port=3306``/tcp
   > ```
   >
   > 【2】重启防火墙
   >
   > ```
   > service firewalld restart
   > ```
   >
   > 【3】查看3306端口是否开放
   >
   > ```
   > firewall-cmd --query-port=3306``/tcp
   > ```
   >
   > ![img](https://img.jbzj.com/file_images/article/201907/201907310956328.png)





## 相关Linux面试文章

> 1. 46个Linux面试常见问题送给你
>
>    https://blog.csdn.net/weixin_30566063/article/details/96373607?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-3.nonecase

# Centos

1. 查看自己linux的信息

   ~~~
   lsb_release -a
   ~~~


> + 可以看到我自己的linux版本是Centos 7.8这里可以看一下Centos7和8之间的区别；目前国内各大云服务器的默认centos 系统版本还是7，vultr，centos只有8了
>
> + **CentOS7与CentOS8的区别**（参照redhat） https://www.cnblogs.com/iwalkman/p/11781234.html
>
>   开发语言支持区别
>   **8版本的**
>
>   > Python 3
>   > PHP 7.2
>   > Ruby 2.5
>   > Node.js 10
>   > java: OpenJDK 11、OpenJDK 8、IcedTea-Web和各种Java工具，如Ant、Maven或Scala。
>   >
>   > MySQL 8.0
>   > MariaDB 10.3
>   > PostgreSQL 10 and PostgreSQL 9.6
>   > Redis 5.0
>
>   **7支持以下编辑语言**
>
>   > Python 2 ( 2.7.X)
>   > PHP 5.4
>   > Ruby 2.0.0
>   > OpenJDK8用作默认的Java开发工具包(JDK)，而Java 8用作默认的Java版本。
>   > MariaDB是Red Hat Enterprise Linux 7中MySQL的默认实现
>
> + #### CentOS版本选择
>
>   > CentOS已经发行了很多个版本，最新的一版du是基于x86_64 平台的 CentOS 8.0.1905。
>   >
>   > 1、CentOS 7.4 以后的zhi新发行版，安全性相对比较高，一些漏洞（如openssh的）都修复了；镜像源的支持比较好。
>   >
>   > 2、如果想用相对比较稳定的，建议至少使用 CentOS 6.9或Centos6.4，最好不要再低了。
>   >
>   > 3、如果是个人的博客、网站，CentOS 6和7系列都可以。采用最新版，可尝试新鲜功能。
>   >
>   > 4、如果是公司的生产环境，还是以大环境为好，因为有一定的经验积累，推荐CentOS 6.5或者6.8。
>   >
>   > 5、有要安装宝塔Linux6.0版本的用户，因为宝塔是基于centos7开发的，建议使用centos7.x 系统。
>   >
>   > 6、如果需要使用docker镜像，那么最好使用CentOS7以上的版本

# Java1.8 安装

1. 安装Centos7之后，系统自带的JDK1.8版本，通过指令可以查看JDK版本

> ~~~
> Java -version
> ~~~

# linux卸载自带jdk并安装jdk8

### 卸载

rpm -qa |grep jdk 查看

rpm -e --nodeps 删除

![img](https://img-blog.csdnimg.cn/20200812131514241.png)

### 安装

![img](https://img-blog.csdnimg.cn/20200812131627332.png)

解压安装：tar -zxvf jdk-8u221-linux-x64.tar.gz 

配置环境变量： vim /etc/profile

![img](https://img-blog.csdnimg.cn/20200812132127221.png)

```
export JAVA_HOME=/usr/local/java/jdk1.8.0_221
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

使配置生效：source /etc/profile

![img](https://img-blog.csdnimg.cn/20200812132428382.png)

 

# Tomcat8.5

1. Linux下安装Tomcat，首先需要安装他的依赖包jdk并配置Java。通过命令java -version，检测版本，看是否成功。

2. 下载安装包Tomcat8.5，放在指定文件夹：usr/local/tomcat，并且进行解压：tar -xzvf  apache-tomcat（文件名称）

3. 然后进入安装好的tomcat的bin目录下,并启动它。

   ~~~
   cd /usr/local/Tomcat/apache-tomcat-8.5.40/bin
   	./startup.sh
   ~~~

4. 通过IP地址访问端口，如

~~~
192.168.254.128:8080   
~~~







# Git

1. 安装依赖

~~~bash
yum -y install curl-devel expat-devel gettext-devel openssl-devel zlib-devel gcc perl-ExtUtils-MakeMaker
~~~





# MySql

1. 当前我自己的Mysql密码:123456

2. CentOS 7之后的版本yum的默认源中使用MariaDB替代原先MySQL，因此安装方式较为以往有一些改变：

## 1. 安装

> 下载mysql的源
>
> ```
> wget http:``//dev``.mysql.com``/get/mysql57-community-release-el7-7``.noarch.rpm
> ```
>
> 安装yum库
>
> ```
> yum localinstall -y mysql57-community-release-el7-7.noarch.rpm
> ```
>
> 安装MySQL
>
> ```
> yum install -y mysql-community-server
> ```
>
> 启动MySQL服务
>
> ```
> systemctl start mysqld.service
> ```
>
> 

## 2. 设置密码

> MySQL5.7加强了root用户的安全性，因此在第一次安装后会初始化一个随机密码，以下为查看初始随机密码的方式
>
> ```
> grep 'temporary password' /var/log/mysqld.log
> ```
>
> 结果如下：
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956312.png)
>
> 进入mysql
>
> ```
> mysql -uroot -p
> ```
>
> 　　![img](https://img.jbzj.com/file_images/article/201907/201907310956313.png)
>
> 修改密码
>
> ```
> SET PASSWORD = PASSWORD('Bob.123456');
> ALTER USER 'root' @'localhost' PASSWORD EXPIRE NEVER;
> flush privileges;
> ```
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956314.png)
>
> 然后退出后即可用新密码登录。
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956315.png)
>
> 

## 3. 开启远程登陆

> **远程连接授权：**
>
> ```
> GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'Bob.123456' WITH GRANT OPTION;
> ```
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956316.png)
>
> 授权之后，用nevicat检查一下是否可以连接，如果不可以，可能是防火墙限制了。需要在防火墙里面加开放数据库端口的规则。
>
> **防火墙开放数据库端口（默认3306，可以在/etc/my.cnf中修改）**
>
> 【1】查看目前防火墙
>
> ```
> firewall-cmd --list-all
> ```
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956317.png)
>
> 【2】开放3306端口
>
> ```
> firewall-cmd --permanent --add-port=3306``/tcp
> ```
>
> 【3】重启防火墙
>
> ```
> service firewalld restart
> ```
>
> 【4】查看3306端口是否开放
>
> ```
> firewall-cmd --query-port=3306``/tcp
> ```
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956328.png)
>
> 【5】再次查看现在防火墙
>
> ```
> firewall-cmd --list-all
> ```
>
> ![img](https://img.jbzj.com/file_images/article/201907/201907310956329.png)
>
> 【6】再次测试是否可以远程连接
>
> ![img](https://img.jbzj.com/file_images/article/201907/2019073109563210.png)

## 4. **mysql设置开机启动**

> **1、cp /usr/local/mysql/support-files/mysql.server /etc/init.d/mysql  将服务文件拷贝到init.d下，并重命名为mysql**
>
> **2、chmod +x /etc/init.d/mysql   赋予可执行权限**
>
> **3、chkconfig --add mysql     添加服务**
>
> **4、chkconfig --list       显示服务列表**
>
> ![img](https://images2015.cnblogs.com/blog/856542/201512/856542-20151230173006385-797737235.png)
>
>  
>
> **如果看到mysql的服务，并且3,4,5都是on的话则成功，如果是off，则键入**
>
> **chkconfig --level 345 mysql on**
>
> **5、reboot重启电脑**
>
> **6、netstat -na | grep 3306，如果看到有监听说明服务启动了**
>
> ![img](https://images2015.cnblogs.com/blog/856542/201512/856542-20151230173051479-1444658170.png)

## 5. 设置环境变量

### 修改配置文件

vim /etc/profile

 ![img](https://img2018.cnblogs.com/blog/1536884/201901/1536884-20190115084246576-683519345.png)

### 设置环境变量

写一个MYSQL_HOME，值为“mysql的安装路径”

在PATH后面加上$MYSQL_HOME/bin

export后面加上MYSQL_HOME

MYSQL_HOME=/usr/local/mysql

PATH=$PATH:$MYSQL_HOME/bin

export MYSQL_HOME

 ![img](https://img2018.cnblogs.com/blog/1536884/201901/1536884-20190115084303623-2007534344.png)

### 重新加载配置文件

 	

 ![img](https://img2018.cnblogs.com/blog/1536884/201901/1536884-20190115084435982-1287819505.png)

这样就可以在任何地方进入数据库，不用到数据库bin目录下了

mysql -u root -p

 ![img](https://img2018.cnblogs.com/blog/1536884/201901/1536884-20190115084517724-2113948497.png)





### 主从复制（单一主从）

1. 添加配置

   主机配置

   ~~~
   server-id=1
   log-bin=mysql-bin
   binlog-do-db=demodb
   binlog_format=STATEMENT
   ~~~

   从机配置

   ~~~
   server-id=2
   relay-log=mysql-relay
   ~~~

2. 重启mysql

   ~~~
   systemctl restart mysqld
   或
   systemctl restart mysql
   ~~~

3. 查看状态

   ~~~
   systemctl status firewalld
   ~~~

4. 关闭防火墙

   ~~~
   systemctl  stop firewalld
   ~~~

5. 创建权限账户

   ~~~
   在主服务器登录mysql 给从服务器授权。
   
   mysql> grant replication slave on *.* to slave@'192.168.43.%' identified by '123456';
   
   授权用户slave 密码为123456 允许192.168.43.0的网络连接 一会儿要在slave上使用这个账号
   
   可以改为
   mysql> grant replication slave on *.* to 'slave'@'%' identified by '123456';
   mysql> flush privileges;
   
   # 查看用户
   mysql> use mysql;
   mysql> select host ,user from user;
   
   ~~~

6. 查看状态

   ~~~
   mysql> show master status;
   ~~~

   ![image-20201019212127184](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019212127184.png)

7. 从机准备命令

   ~~~
   CHANGE MASTER TO MASTER_HOST='192.168.254.134',
   MASTER_USER='slave',
   MASTER_PASSWORD='123456',
   MASTER_LOG_FILE='mysql-bin.000001',MASTER_LOG_POS=154;
   ~~~

   如果从机之前有设置主机，需要重置

   ~~~
   #停止复制
   stop slave;
   #重置master
   reset master;
   ~~~

8. 启动复制操作

   ~~~
   start slave;
   show slave status\G;
   ~~~

   ![image-20201019220352688](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019220352688.png)

   

### 读写分离

1. 进入mycat配置文件

![image-20201019224221167](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019224221167.png)

​	数据库的名称要保持一致，

![image-20201019224344270](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019224344270.png)

2. 开启读写分离

~~~~
<dataHost name="host1" maxCon="1000" minCon="10" balance="0"
			  writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
			  
其中的balance参数
参数=0，不开启读写分离；
参数=1，双主双从，负载均衡，
参数=2 读操作在读写主机之间随机分发
参数=3 所有请求随机发到读主机上
~~~~



3. 登录mycat

~~~
mysql -uroot -p123456 -h 192.168.254.134 -P 8066
~~~

4.使用

~~~
insert into singer values （1，@@hostname）
会在主从复制的库中生成不同的值，@@hostname代表变量
~~~

### 双主双从

1. 配置master1

~~~
server-id=1
log-bin=mysql-bin
binlog-do-db=demodb
binlog_format=STATEMENT
#作为从数据库时，写入操作也要更新二进制文件
log-slave-updates
#表示每次自增长字段每次递增的量，指自增字段的起始值，默认为1；
log-slave-increment=2
#表示自增长字段从哪个数字开始，指字段一次递增多少
auto-increment-offset=1

~~~

修改master2

~~~
server-id=3
log-bin=mysql-bin
binlog-do-db=demodb
binlog_format=STATEMENT
#作为从数据库时，写入操作也要更新二进制文件
log-slave-updates
#表示每次自增长字段每次递增的量，指自增字段的起始值，默认为1；
log-slave-increment=2
#表示自增长字段从哪个数字开始，指字段一次递增多少
auto-increment-offset=2
=======================================================
server-id=3
log-bin=mysql-bin
binlog-do-db=demodb
binlog_format=STATEMENT
log-slave-updates
auto-increment-increment=2
auto-increment-offset=2
~~~

M1和M2创建用户并授权

~~~
在主服务器登录mysql 给从服务器授权。

mysql> grant replication slave on *.* to slave@'192.168.43.%' identified by '123456';

授权用户slave 密码为123456 允许192.168.43.0的网络连接 一会儿要在slave上使用这个账号

可以改为
mysql> grant replication slave on *.* to 'slave'@'%' identified by '123456';
mysql> flush privileges;

# 查看用户
mysql> use mysql;
mysql> select host ,user from user;

~~~

查看M1和M2状态

~~~
mysql> show master status;
~~~

M2 133

![image-20201019235333396](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019235333396.png)

M1 134

![image-20201019235411533](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019235411533.png)



S1 135 添加配置信息 复制M1 134

~~~
CHANGE MASTER TO MASTER_HOST='192.168.254.134',
MASTER_USER='slave',
MASTER_PASSWORD='123456',
MASTER_LOG_FILE='mysql-bin.000007',MASTER_LOG_POS=485;

start slave;
show slave status\G;
~~~

S2 136 添加配置信息 复制M1 133

~~~
CHANGE MASTER TO MASTER_HOST='192.168.254.133',
MASTER_USER='slave',
MASTER_PASSWORD='123456',
MASTER_LOG_FILE='mysql-bin.000001',MASTER_LOG_POS=324;

start slave;
show slave status\G;
~~~

M1为M2 从

~~~
CHANGE MASTER TO MASTER_HOST='192.168.254.133',
MASTER_USER='slave',
MASTER_PASSWORD='123456',
MASTER_LOG_FILE='mysql-bin.000002',MASTER_LOG_POS=600;

start slave;
show slave status\G;
~~~

M2为M1 从

~~~
CHANGE MASTER TO MASTER_HOST='192.168.254.134',
MASTER_USER='slave',
MASTER_PASSWORD='123456',
MASTER_LOG_FILE='mysql-bin.000005',MASTER_LOG_POS=154;

start slave;
show slave status\G;
~~~

![image-20201020000507426](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201020000507426.png)



# Maven

现有的一个项目使用了Maven来管理，源代码放到了GitLab中。虽然Maven管理项目很方便，但是部署起来还是很麻烦的。先要在本地生成项目jar包，上传到服务器，然后再重启服务。如果在服务器上面安装Maven，便可以直接在服务器上面生成项目jar包，部署起来更加方便了。

Maven的下载地址是：http://maven.apache.org/download.cgi

安装Maven非常简单，只需要将下载的压缩文件解压就可以了。

```
cd /usr/local/src/
wget http://mirrors.hust.edu.cn/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
tar zxf apache-maven-3.6.3-bin.tar.gz
mv apache-maven-3.6.3 /usr/local/maven3
```


vi /etc/profile然后还需要 配置环境变量。

```
#在适当的位置添加
export M2_HOME=/usr/local/maven3
export PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin
```

 


保存退出后运行下面的命令使配置生效，或者重启服务器生效。

```
source /etc/profile
```

 

验证版本

```
mvn -v
```

如果安装正确就可以看到Maven的版本了。如果提示以下错误，请检查/etc/profile中PATH环境变量值中是否包含Maven可执行文件的路径，以及是否使该配置生效。

```
-bash: mvn: command not found
```

# Redis

### 安装

1. 上传文件，进行解压tar -xzvf redis

2. centos7安装redis6.0时make报错问题：

   服务器系统为centos7，直接在redis官网查找地址，wget、tar后，执行马克命令时发现报错

   

3. gcc等环境都已经安装，清除编译信息后重新编译、删除解压后的文件重新解压编译的方式都试过了没有改善，后来查到与gcc的版本有关

   //查看gcc版本

   ~~~
   gcc -v
   ~~~


   **centos7默认版本为4.8.5**

   **而redis6.0+需要的gcc版本为5.3及以上，所以升级gcc即可**

   ~~~
   //升级gcc到9以上
   yum -y install centos-release-scl
   yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
   ~~~

3. 还需要执行命令

   ~~~
   
   //临时将此时的gcc版本改为9
   scl enable devtoolset-9 bash
   //或永久改变
   echo "source /opt/rh/devtoolset-9/enable" >>/etc/profile
   ~~~

4. 查看gcc此时版本

5. 再执行编译命令即可完成编译

   make  make install

6. 修改配置文件

   ~~~
   bind 0.0.0.0
   daemonize yes
   protect-mode no
   ~~~

   

### 配置文件详解

~~~
1. Redis默认不是以守护进程的方式运行，可以通过该配置项修改，使用yes启用守护进程，后台运行
    daemonize no
2. 当Redis以守护进程方式运行时，Redis默认会把pid写入/var/run/redis.pid文件，可以通过pidfile指定
    pidfile /var/run/redis.pid
3. 指定Redis监听端口，默认端口为6379，作者在自己的一篇博文中解释了为什么选用6379作为默认端口，因为6379在手机按键上MERZ对应的号码，而MERZ取自意大利歌女Alessia Merz的名字
    port 6379
4. 绑定的主机地址
    bind 127.0.0.1
5.当 客户端闲置多长时间后关闭连接，如果指定为0，表示关闭该功能
    timeout 300
6. 指定日志记录级别，Redis总共支持四个级别：debug、verbose、notice、warning，默认为verbose
    loglevel verbose
7. 日志记录方式，默认为标准输出，如果配置Redis为守护进程方式运行，而这里又配置为日志记录方式为标准输出，则日志将会发送给/dev/null
    logfile stdout
8. 设置数据库的数量，默认数据库为0，可以使用SELECT <dbid>命令在连接上指定数据库id
    databases 16
9. 指定在多长时间内，有多少次更新操作，就将数据同步到数据文件，可以多个条件配合
    save <seconds> <changes>
    Redis默认配置文件中提供了三个条件：
    save 900 1
    save 300 10
    save 60 10000
    分别表示900秒（15分钟）内有1个更改，300秒（5分钟）内有10个更改以及60秒内有10000个更改。
10. 指定存储至本地数据库时是否压缩数据，默认为yes，Redis采用LZF压缩，如果为了节省CPU时间，可以关闭该选项，但会导致数据库文件变的巨大
    rdbcompression yes
11. 指定本地数据库文件名，默认值为dump.rdb
    dbfilename dump.rdb
12. 指定本地数据库存放目录
    dir ./
13. 设置当本机为slav服务时，设置master服务的IP地址及端口，在Redis启动时，它会自动从master进行数据同步
    slaveof <masterip> <masterport>
14. 当master服务设置了密码保护时，slav服务连接master的密码
    masterauth <master-password>
15. 设置Redis连接密码，如果配置了连接密码，客户端在连接Redis时需要通过AUTH <password>命令提供密码，默认关闭
    requirepass foobared
16. 设置同一时间最大客户端连接数，默认无限制，Redis可以同时打开的客户端连接数为Redis进程可以打开的最大文件描述符数，如果设置 maxclients 0，表示不作限制。当客户端连接数到达限制时，Redis会关闭新的连接并向客户端返回max number of clients reached错误信息
    maxclients 128
17. 指定Redis最大内存限制，Redis在启动时会把数据加载到内存中，达到最大内存后，Redis会先尝试清除已到期或即将到期的Key，当此方法处理 后，仍然到达最大内存设置，将无法再进行写入操作，但仍然可以进行读取操作。Redis新的vm机制，会把Key存放内存，Value会存放在swap区
    maxmemory <bytes>
18. 指定是否在每次更新操作后进行日志记录，Redis在默认情况下是异步的把数据写入磁盘，如果不开启，可能会在断电时导致一段时间内的数据丢失。因为 redis本身同步数据文件是按上面save条件来同步的，所以有的数据会在一段时间内只存在于内存中。默认为no
    appendonly no
19. 指定更新日志文件名，默认为appendonly.aof
     appendfilename appendonly.aof
20. 指定更新日志条件，共有3个可选值：
    no：表示等操作系统进行数据缓存同步到磁盘（快）
    always：表示每次更新操作后手动调用fsync()将数据写到磁盘（慢，安全）
    everysec：表示每秒同步一次（折衷，默认值）
    appendfsync everysec
21. 指定是否启用虚拟内存机制，默认值为no，简单的介绍一下，VM机制将数据分页存放，由Redis将访问量较少的页即冷数据swap到磁盘上，访问多的页面由磁盘自动换出到内存中（在后面的文章我会仔细分析Redis的VM机制）
     vm-enabled no
22. 虚拟内存文件路径，默认值为/tmp/redis.swap，不可多个Redis实例共享
     vm-swap-file /tmp/redis.swap
23. 将所有大于vm-max-memory的数据存入虚拟内存,无论vm-max-memory设置多小,所有索引数据都是内存存储的(Redis的索引数据 就是keys),也就是说,当vm-max-memory设置为0的时候,其实是所有value都存在于磁盘。默认值为0
     vm-max-memory 0
24. Redis swap文件分成了很多的page，一个对象可以保存在多个page上面，但一个page上不能被多个对象共享，vm-page-size是要根据存储的 数据大小来设定的，作者建议如果存储很多小对象，page大小最好设置为32或者64bytes；如果存储很大大对象，则可以使用更大的page，如果不 确定，就使用默认值
     vm-page-size 32
25. 设置swap文件中的page数量，由于页表（一种表示页面空闲或使用的bitmap）是在放在内存中的，，在磁盘上每8个pages将消耗1byte的内存。
     vm-pages 134217728
26. 设置访问swap文件的线程数,最好不要超过机器的核数,如果设置为0,那么所有对swap文件的操作都是串行的，可能会造成比较长时间的延迟。默认值为4
     vm-max-threads 4
27. 设置在向客户端应答时，是否把较小的包合并为一个包发送，默认为开启
    glueoutputbuf yes
28. 指定在超过一定的数量或者最大的元素超过某一临界值时，采用一种特殊的哈希算法
    hash-max-zipmap-entries 64
    hash-max-zipmap-value 512
29. 指定是否激活重置哈希，默认为开启（后面在介绍Redis的哈希算法时具体介绍）
    activerehashing yes
30. 指定包含其它的配置文件，可以在同一主机上多个Redis实例之间使用同一份配置文件，而同时各个实例又拥有自己的特定配置文件
    include /path/to/local.conf
~~~





### 主从配置

1. 启动redis

   ~~~
   #启动
   redis-server redis-conf
   # 进入客户端
   redis-cli
   ~~~

2. 查看Redis状态

   ~~~
   Info replication
   ~~~

   默认每个都是master节点

3. 启动三台redis

4. 配置方法

   1. 一般只需要配置从机即可（找到自己的老大）

      ~~~
      #slaveof 后面追加主机的ip和端口地址
      slaveof 192.168.254.134 6379
      ~~~
~~~
      
      ![image-20201019133406118](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019133406118.png)



​		2. 真实的配置通过配置文件进行配置

​	![image-20201019134653193](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019134653193.png)

  1. Redis关机指令

~~~
     ./src/redis-cli -h 127.0.0.1 -p 6379 shutdown
     ~~~


​     

### 哨兵模式自动搭建集群

1. 正常启动三台Redis

2. 修改配置文件

   sentinel.conf：

![image-20201019163920913](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019163920913.png)

3. 命令启动哨兵模式

   

~~~
./src/redis-sentinel sentinel-master134.conf
./src/redis-sentinel sentinel-slave135.conf
./src/redis-sentinel sentinel-slave136.conf
~~~



4. 总结

   哨兵模式会自动选取master 节点，保证了集群的高可用



### Spring整合哨兵模式

​	哨兵模式保证了Redis集群的高可用性，提升了整个系统的稳定性。

1. 添加依赖

~~~xml
 		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
 		<dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-pool2</artifactId>
        </dependency>

~~~

2. 在公共类中配置ReidsConfig.java

~~~java

@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // 配置序列化（解决乱码的问题）,过期时间600秒
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
        return cacheManager;
    }
}
~~~

3. 修改配置文件

~~~properties
####redis的配置信息###
spring.redis.sentinel.master=mymaster
spring.redis.sentinel.nodes=192.168.254.133:26377,192.168.254.133:26378,192.168.254.133:26379
spring.redis.cluster.nodes=192.168.254.134:6379,192.168.254.135:6379,192.168.254.136:6379
#spring.redis.password=password......
#采用哪个数据库,默认是0
spring.redis.database=0
# 连接池最大连接数,默认8个，（使用负值表示没有限制）
spring.redis.jedis.pool.max-idle=8
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.jedis.pool.max-wait=-1
# 连接池中的最大空闲连接
spring.redis.pool.max-waitx-idle=8
# 连接池中的最小空闲连接
spring.redis.pool.min-idlele=0
# 连接超时时间（毫秒）
spring.redis.timeout=5000
~~~

4. 在controller中进行测试

~~~java
 @ApiOperation(value = "测试Redis功能")
    @GetMapping("TestRedis/{a}/{b}")
    public R TestRedis(@PathVariable String a,
                          @PathVariable String b){
        String key=a;
        String value=b;
        //给Redis设置值，根据传入的内容进行设置相应的信息
        redisTemplate.opsForValue().set(key,value,1,TimeUnit.MINUTES);
        //通过变量进行取值
        String values=redisTemplate.opsForValue().get(key);
        return R.ok().data("values",values);
    }
~~~





### 本地Redis集群启动

~~~
==================== 133 节点 ====================================
# 跳转目录进入Redis
cd /usr/local/redis
#命令启动哨兵模式
./src/redis-sentinel sentinel-master134.conf
./src/redis-sentinel sentinel-slave135.conf
./src/redis-sentinel sentinel-slave136.conf

=========================134 节点 ================================
# 跳转目录进入Redis
cd /usr/local/redis
#命令启动Redis
./src/redis-server redis-master134.conf

=========================135 节点 ================================
# 跳转目录进入Redis
cd /usr/local/redis
#命令启动Redis
./src/redis-server redis-slave135.conf

=========================136 节点 ================================
# 跳转目录进入Redis
cd /usr/local/redis
#命令启动Redis
./src/redis-server redis-slave136.conf
~~~



###　执行命令详解

#### 1.性能测试

~~~
#性能测试，模拟一百个腾雾， 100个客户端请求
redis-benchmark -n 10000  -c 100
~~~

#### 2. 数据库操作

~~~
#redis默认16个数据库，从0-15 

#选择数据库 1 
select 1

#查看数据库大小
dbsize

#清空当前数据库
flush

#清空所有数据库
flushall
~~~

#### 3. Key-value

~~~
==========简单的键值对==================
#设置key value
SET runoobkey redis

#删除key valuse
del runoobkey

#得到所有的key
keys *


============对象存储HUSH==================
#存储键为runoobkey的key-value映射表
HMSET runoobkey name "redis tutorial" description "redis basic commands for caching" likes 20 visitors 23000

#测试1
HMSET 1234567 name "杜鑫" age "30" description "大帅哥"
##注意：中文会显示16进制


#得到对象的值
HGETALL runoobkey

#得到对象的对应key的值
HMGET runoobkey name

#得到对象的多个对应的key值
HMGET runoobkey name age

################列表Lst###########################
是一个简单的字符串集合
redis 127.0.0.1:6379> LPUSH runoobkey redis
(integer) 1
redis 127.0.0.1:6379> LPUSH runoobkey mongodb
(integer) 2
redis 127.0.0.1:6379> LPUSH runoobkey mysql
(integer) 3
redis 127.0.0.1:6379> LRANGE runoobkey 0 10

1) "mysql"
2) "mongodb"
3) "redis"

##################集合Set##########################
# 集合成员是唯一的，这就意味着集合中不能出现重复的数据。
redis 127.0.0.1:6379> SADD runoobkey redis
(integer) 1
redis 127.0.0.1:6379> SADD runoobkey mongodb
(integer) 1
redis 127.0.0.1:6379> SADD runoobkey mysql
(integer) 1
redis 127.0.0.1:6379> SADD runoobkey mysql
(integer) 0
redis 127.0.0.1:6379> SMEMBERS runoobkey
# 结果
1) "mysql"
2) "mongodb"
3) "redis"


##############有序集合Sorted Set##########################
每个元素都会关联一个 double 类型的分数。redis 正是通过分数来为集合中的成员进行从小到大的排序。有序集合的成员是唯一的,但分数(score)却可以重复。
redis 127.0.0.1:6379> ZADD runoobkey 1 redis
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 2 mongodb
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 3 mysql
(integer) 1
redis 127.0.0.1:6379> ZADD runoobkey 3 mysql
(integer) 0
redis 127.0.0.1:6379> ZADD runoobkey 4 mysql
(integer) 0
redis 127.0.0.1:6379> ZRANGE runoobkey 0 10 WITHSCORES

1) "redis"
2) "1"
3) "mongodb"
4) "2"
5) "mysql"
6) "4"

~~~

#### 4.查看Redis信息指令

~~~
#查看所有的Redis信息
info

#查看部分
info  [section]
#查看应用信息
info replication
#统计key的信息
info keyspace
~~~

#### 5.Redis Stream

~~~
Redis Stream 是 Redis 5.0 版本新增加的数据结构。
Redis Stream 主要用于消息队列（MQ，Message Queue），Redis 本身是有一个 Redis 发布订阅 (pub/sub) 来实现消息队列的功能，但它有个缺点就是消息无法持久化，如果出现网络断开、Redis 宕机等，消息就会被丢弃。
简单来说发布订阅 (pub/sub) 可以分发消息，但无法记录历史消息。
而 Redis Stream 提供了消息的持久化和主备复制功能，可以让任何客户端访问任何时刻的数据，并且能记住每一个客户端的访问位置，还能保证消息不丢失。


#Stream的消费模型借鉴了kafka的消费分组的概念，它弥补了Redis Pub/Sub不能持久化消息的缺陷。但是它又不同于kafka，kafka的消息可以分partition，而Stream不行。如果非要分parition的话，得在客户端做，

~~~

#### 6.最大连接数

~~~
# 在 Redis2.4 中，最大连接数是被直接硬编码在代码里面的，而在2.6版本中这个值变成可配置的。maxclients 的默认值是 10000，你也可以在 redis.conf 中对这个值进行修改。

config get maxclients
1) "maxclients"
2) "10000"
~~~

#### 7. 安全验证

~~~
#通过以下命令查看是否设置了密码验证：
127.0.0.1:6379> CONFIG get requirepass
1) "requirepass"
2) ""




~~~





#　Nginx

## 安装所需插件

### 1、安装gcc

gcc是linux下的编译器在此不多做解释，感兴趣的小伙伴可以去查一下相关资料，它可以编译 C,C++,Ada,Object C和Java等语言

命令：查看gcc版本 

```java
gcc -v
```

 

![img](https://img-blog.csdnimg.cn/20190509145141495.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MzQ1NjA0,size_16,color_FFFFFF,t_70)

一般阿里云的centOS7里面是都有的，没有安装的话会提示命令找不到，

安装命令:

```
yum -y install gcc
```

 

![img](https://img-blog.csdnimg.cn/20190509145218698.png)

### 2、pcre、pcre-devel安装

pcre是一个perl库，包括perl兼容的正则表达式库，nginx的http模块使用pcre来解析正则表达式，所以需要安装pcre库。

安装命令：

```
yum install -y pcre pcre-devel
```

![img](https://img-blog.csdnimg.cn/2019050914525680.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MzQ1NjA0,size_16,color_FFFFFF,t_70)

 

### 3、zlib安装

zlib库提供了很多种压缩和解压缩方式nginx使用zlib对http包的内容进行gzip，所以需要安装

安装命令：

```
yum install -y zlib zlib-devel
```

 

### 4、安装openssl

openssl是web安全通信的基石，没有openssl，可以说我们的信息都是在裸奔。。。。。。

安装命令：

```
yum install -y openssl openssl-devel
```

 

## 安装nginx

### 1、下载nginx安装包

```
wget http://nginx.org/download/nginx-1.9.9.tar.gz  
```

 

### 2、把压缩包解压到usr/local/java

```
tar -zxvf  nginx-1.9.9.tar.gz
```

 

### 3、切换到cd /usr/local/java/nginx-1.9.9/下面

执行三个命令：

```
./configure
make
make install
```

### 4. Make 报错

 在一台新的服务器上 准备安装nginx 一开始装的扩展什么的都很顺利 但是make的时候出了问题 我确定所有需要的扩展都已经安装好了，出现问题如下：

haiqi@haiqi-B85M-D2V:/nginx-1.10.3$ make

cc1: all warnings being treated as errors
objs/Makefile:458: recipe for target 'objs/src/core/ngx_murmurhash.o' failed
make[1]: *** [objs/src/core/ngx_murmurhash.o] Error 1
make[1]: Leaving directory '/nginx-1.10.3'
Makefile:8: recipe for target 'build' failed

make: *** [build] Error 2

![img](https://img-blog.csdn.net/20180302164058450?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY2Mzg1OTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)![img](https://img-blog.csdn.net/20180302164044852?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMzY2Mzg1OTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

折腾了一上午之后 终于在找到解决方法 

**将对应的makefile文件夹中（如本文中在 /nginx-1.10.3/objs/Makefile） 找到 -Werror 并去掉 在重新make即可**

**查了-Werrori意思之后 发现原来它要求GCC将所有的警告当成错误进行处理 所有导致错误输出 并不能进行下一步**



### 5、切换到/usr/local/nginx安装目录

![img](https://img-blog.csdnimg.cn/20190509145506224.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MzQ1NjA0,size_16,color_FFFFFF,t_70)

### 6、配置nginx的配置文件nginx.conf文件，主要也就是端口

![img](https://img-blog.csdnimg.cn/20190509145516758.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MzQ1NjA0,size_16,color_FFFFFF,t_70)

可以按照自己服务器的端口使用情况来进行配置

ESC键，wq！强制保存并退出

### 7、启动nginx服务

切换目录到/usr/local/nginx/sbin下面

![img](https://img-blog.csdnimg.cn/20190509145534295.png)

启动nginx命令：

```
./nginx
```

 

### 8、查看nginx服务是否启动成功

```
ps -ef | grep nginx
```

![img](https://img-blog.csdnimg.cn/20190509145628305.png)





### 9、 防火墙设置更改

### 10、访问你的服务器IP

显示

![img](https://img-blog.csdnimg.cn/2019050914564313.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3MzQ1NjA0,size_16,color_FFFFFF,t_70)

说明安装和配置都没问题OK了

## nginx.conf说明

```java
#user  nobody;
worker_processes  1; #工作进程：数目。根据硬件调整，通常等于cpu数量或者2倍cpu数量。
#错误日志存放路径
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;
#pid        logs/nginx.pid; # nginx进程pid存放路径
events {
    worker_connections  1024; # 工作进程的最大连接数量
}
http {
    include       mime.types; #指定mime类型，由mime.type来定义
    default_type  application/octet-stream;
    # 日志格式设置
    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';
    #access_log  logs/access.log  main; #用log_format指令设置日志格式后，需要用access_log来指定日志文件存放路径
    sendfile        on; #指定nginx是否调用sendfile函数来输出文件，对于普通应用，必须设置on。
			如果用来进行下载等应用磁盘io重负载应用，可设着off，以平衡磁盘与网络io处理速度，降低系统uptime。
    #tcp_nopush     on; #此选项允许或禁止使用socket的TCP_CORK的选项，此选项仅在sendfile的时候使用       
    #keepalive_timeout  0;  #keepalive超时时间
    keepalive_timeout  65;  
    #gzip  on; #开启gzip压缩服务
    #虚拟主机
    server {
        listen       80;  #配置监听端口号
        server_name  localhost; #配置访问域名，域名可以有多个，用空格隔开
        #charset koi8-r; #字符集设置
        #access_log  logs/host.access.log  main;
        location / {
            root   html;
            index  index.html index.htm;
        }
        #错误跳转页
        #error_page  404              /404.html; 
        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}
        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ { #请求的url过滤，正则匹配，~为区分大小写，~*为不区分大小写。
        #    root           html; #根目录
        #    fastcgi_pass   127.0.0.1:9000; #请求转向定义的服务器列表
        #    fastcgi_index  index.php; # 如果请求的Fastcgi_index URI是以 / 结束的, 该指令设置的文件会被附加到URI的后面并保存在变量$fastcig_script_name中
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}
        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }
    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;
    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}
    # HTTPS server
    #
    #server {
    #    listen       443 ssl;  #监听端口
    #    server_name  localhost; #域名
    #    ssl_certificate      cert.pem; #证书位置
    #    ssl_certificate_key  cert.key; #私钥位置
    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m; 
    #    ssl_ciphers  HIGH:!aNULL:!MD5; #密码加密方式
    #    ssl_prefer_server_ciphers  on; # ssl_prefer_server_ciphers  on; #
    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}
}
```

 

# Mycat

1. 上传安装包

   注意不要使用太新的版本1.6 就可以了

2. 启动

~~~
./bin/mycat start
~~~



# MayCat-Web

1. 上传安装包

   ![image-20201019184636673](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019184636673.png)

2. 启动命令

   ~~~
   sh start.sh
   ~~~

   代表已经启动：

   ![image-20201019184738123](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201019184738123.png)

3. 访问端口

   192.168.254.134:8082/mycat



# Zookeepr

1. 下载安装包

2. 解压到usr/local中

3. 在zookeeper中添加文件夹

4. 修改配置文件

   conf 目录下的 zoo_sample.cfg  

   改为 zoo.cfg

   配置：dataDir=/usr/local/zookeeper/data

5. 添加文佳佳访问权限

   ~~~
   chmod -R 777 zookeeper
   ~~~

6. 启动

   ~~~
   ./zkServer.sh start
   
   #查看状态
   ./zkServer.sh status
   ~~~

   









#  RabbitMQ



### 3.搭建RabbitMQ环境

#### 3.1.下载

下载地址：http://www.rabbitmq.com/download.html

#### 3.2.windows下安装

3.2.1.安装Erlang
下载：http://www.erlang.org/download/otp_win64_17.3.exe
安装：
![这里写图片描述](https://img-blog.csdn.net/20180805223840363?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/2018080522384887?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805223957290?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805224009766?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805224017109?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
安装完成。

3.2.2.安装RabbitMQ
![这里写图片描述](https://img-blog.csdn.net/20180805224030150?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805224038482?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805224045606?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
安装完成。

开始菜单里出现如下选项：
![这里写图片描述](https://img-blog.csdn.net/20180805224109656?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

启动、停止、重新安装等。

3.2.3.启用管理工具
1、双击![这里写图片描述](https://img-blog.csdn.net/20180805224130690?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
2、进入C:\Program Files (x86)\RabbitMQ Server\rabbitmq_server-3.4.1\sbin输入命令：
rabbitmq-plugins enable rabbitmq_management
![这里写图片描述](https://img-blog.csdn.net/20180805224137148?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

这样就启动了管理工具，可以试一下命令：
停止：net stop RabbitMQ
启动：net start RabbitMQ

3、在浏览器中输入地址查看：http://127.0.0.1:15672/
![这里写图片描述](https://img-blog.csdn.net/20180805224156458?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
4、使用默认账号登录：guest/ guest

#### 3.3.Linux下安装

https://www.rabbitmq.com/which-erlang.html#erlang-repositories

rabbit 与 Erlang 的版本关系

3.3.1.安装Erlang

上传文件 erlang-21.3.8.18-1.el7.x86_64.rpm

执行

rpm -ivh erlang-21.3.8.18-1.el7.x86_64.rpm



3.3.3.安装RabbitMQ
上传rabbitmq-server-3.8.8.noarch.rpm

安装：
rpm -ivh rabbitmq-server-3.8.8.noarch.rpm



vi /etc/hosts
加入一行
127.0.0.1 bogon



3.3.4.启动、停止
service rabbitmq-server start
service rabbitmq-server stop
service rabbitmq-server restart

3.3.5.设置开机启动
chkconfig rabbitmq-server on

3.3.6.设置配置文件

cd /etc/rabbitmq/

3.3.7.开启用户远程访问
vi /etc/rabbitmq/rabbitmq.config

使用默认的用户 guest / guest （此也为管理员用户）登陆，会发现无法登陆，报错：User can only log in via localhost。那是因为默认是限制了guest用户只能在本机登陆，也就是只能登陆localhost:15672。可以通过修改配置文件rabbitmq.conf，**取消这个限制： loopback_users这个项就是控制访问的**，如果只是取消guest用户的话，只需要loopback_users.guest = false 即可。

3.3.8.开启web界面管理工具
rabbitmq-plugins enable rabbitmq_management
service rabbitmq-server restart

3.3.9.防火墙开放15672端口
/sbin/iptables -I INPUT -p tcp --dport 15672 -j ACCEPT
/etc/rc.d/init.d/iptables save

#### 3.4.安装的注意事项

1、推荐使用默认的安装路径
2、系统用户名必须是英文
Win10改名字非常麻烦，具体方法百度
![这里写图片描述](https://img-blog.csdn.net/20180805224246731?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
3、计算机名必须是英文
![这里写图片描述](https://img-blog.csdn.net/20180805224301606?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
4、系统的用户必须是管理员

如果安装失败应该如何解决：
1、重装系统 – 不推荐
2、将RabbitMQ安装到linux虚拟机中
a)推荐
3、使用别人安装好的RabbitMQ服务
a)只要给你开通一个账户即可。
b)使用公用的RabbitMQ服务，在192.168.50.22
c)推荐

常见错误：
![这里写图片描述](https://img-blog.csdn.net/20180805224335326?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 3.5.安装完成后操作

1、系统服务中有RabbitMQ服务，停止、启动、重启
![这里写图片描述](https://img-blog.csdn.net/20180805224351447?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
2、打开命令行工具
![这里写图片描述](https://img-blog.csdn.net/20180805224408492?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
如果找不到命令行工具,直接cd到相应目录：
![这里写图片描述](https://img-blog.csdn.net/20180805224417869?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
输入命令rabbitmq-plugins enable rabbitmq_management启用管理插件
![这里写图片描述](https://img-blog.csdn.net/20180805224426564?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
查看管理页面
![这里写图片描述](https://img-blog.csdn.net/20180805224453753?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
通过默认账户 guest/guest 登录
如果能够登录，说明安装成功。
![这里写图片描述](https://img-blog.csdn.net/20180805224504687?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

### 4.添加用户

#### 4.1.添加admin用户

![这里写图片描述](https://img-blog.csdn.net/20180805224521190?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 4.2.用户角色

1、超级管理员(administrator)

可登陆管理控制台，可查看所有的信息，并且可以对用户，策略(policy)进行操作。

2、监控者(monitoring)
可登陆管理控制台，同时可以查看rabbitmq节点的相关信息(进程数，内存使用情况，磁盘使用情况等)

3、策略制定者(policymaker)
可登陆管理控制台, 同时可以对policy进行管理。但无法查看节点的相关信息(上图红框标识的部分)。

4、普通管理者(management)
仅可登陆管理控制台，无法看到节点信息，也无法对策略进行管理。

5、其他
无法登陆管理控制台，通常就是普通的生产者和消费者。

#### 4.3.创建Virtual Hosts

![这里写图片描述](https://img-blog.csdn.net/20180805224535905?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

选中Admin用户，设置权限：
![这里写图片描述](https://img-blog.csdn.net/20180805224551538?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
看到权限已加：
![这里写图片描述](https://img-blog.csdn.net/20180805224618404?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 4.4.管理界面中的功能

![这里写图片描述](https://img-blog.csdn.net/20180805224641957?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](https://img-blog.csdn.net/20180805224654453?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

### 5.学习五种队列

![这里写图片描述](https://img-blog.csdn.net/20180805224706123?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 5.1.导入my-rabbitmq项目

项目下载地址：
https://download.csdn.net/download/zpcandzhj/10585077
![这里写图片描述](https://img-blog.csdn.net/20180805224807881?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 5.2.简单队列

5.2.1.图示
![这里写图片描述](https://img-blog.csdn.net/20180805224818627?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

P：消息的生产者
C：消息的消费者
红色：队列

生产者将消息发送到队列，消费者从队列中获取消息。
5.2.2.导入RabbitMQ的客户端依赖

```
<dependency>
   <groupId>com.rabbitmq</groupId>
   <artifactId>amqp-client</artifactId>
   <version>3.4.1</version>
</dependency>
```

添加配置

~~~
##RabbitMQ
#连接地址
spring.rabbitmq.host=192.168.254.134
####端口号
spring.rabbitmq.port=15672
####账号
spring.rabbitmq.username=root
####密码
spring.rabbitmq.password=123456
### 地址
spring.rabbitmq.virtual-host= /admin_host
####开启消费者重试
spring.rabbitmq.listener.simple.retry.enabled=true
####最大重试次数
spring.rabbitmq.listener.simple.retry.max-attempts=5
####重试间隔次数
spring.rabbitmq.listener.simple.retry.initial-interval: 3000
~~~



5.2.3.获取MQ的连接

```bash
package com.zpc.rabbitmq.util;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("testhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}
```

5.2.4.生产者发送消息到队列

```bash
package com.zpc.rabbitmq.simple;

import com.zpc.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明（创建）队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 消息内容
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}

```

5.2.5.管理工具中查看消息
![这里写图片描述](https://img-blog.csdn.net/20180805224906551?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

点击上面的队列名称，查询具体的队列中的信息：
![这里写图片描述](https://img-blog.csdn.net/20180805224919622?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5.2.6.消费者从队列中获取消息

```bash
package com.zpc.rabbitmq.simple;

import com.zpc.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv {

    private final static String QUEUE_NAME = "q_test_01";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }
}
```

#### 5.3.Work模式

![这里写图片描述](https://img-blog.csdn.net/20180805224942304?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

5.3.1.图示
![这里写图片描述](https://img-blog.csdn.net/20180805224950612?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

一个生产者、2个消费者。

一个消息只能被一个消费者获取。

5.3.2.消费者1

```bash
package com.zpc.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.zpc.rabbitmq.util.ConnectionUtil;

public class Recv {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发一条消息给消费者
        //channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME, true, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [y] Received '" + message + "'");
            //休眠
            Thread.sleep(10);
            // 返回确认状态，注释掉表示使用自动确认模式
            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
```

5.3.3.消费者2

```bash
package com.zpc.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import com.zpc.rabbitmq.util.ConnectionUtil;

public class Recv2 {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 同一时刻服务器只会发一条消息给消费者
        //channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME, true, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
            // 休眠1秒
            Thread.sleep(1000);
            //下面这行注释掉表示使用自动确认模式
            //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}

```

5.3.4.生产者
向队列中发送100条消息。

```bash
package com.zpc.rabbitmq.work;

import com.zpc.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String QUEUE_NAME = "test_queue_work";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        for (int i = 0; i < 100; i++) {
            // 消息内容
            String message = "" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

            Thread.sleep(i * 10);
        }

        channel.close();
        connection.close();
    }
}
```

5.3.5.测试
测试结果：
1、消费者1和消费者2获取到的消息内容是不同的，同一个消息只能被一个消费者获取。
2、消费者1和消费者2获取到的消息的数量是相同的，一个是消费奇数号消息，一个是偶数。

- 其实，这样是不合理的，因为消费者1线程停顿的时间短。应该是消费者1要比消费者2获取到的消息多才对。
  RabbitMQ 默认将消息顺序发送给下一个消费者，这样，每个消费者会得到相同数量的消息。即轮询（round-robin）分发消息。
- 怎样才能做到按照每个消费者的能力分配消息呢？联合使用 Qos 和 Acknowledge 就可以做到。
  basicQos 方法设置了当前信道最大预获取（prefetch）消息数量为1。消息从队列异步推送给消费者，消费者的 ack 也是异步发送给队列，从队列的视角去看，总是会有一批消息已推送但尚未获得 ack 确认，Qos 的 prefetchCount 参数就是用来限制这批未确认消息数量的。设为1时，队列只有在收到消费者发回的上一条消息 ack 确认后，才会向该消费者发送下一条消息。prefetchCount 的默认值为0，即没有限制，队列会将所有消息尽快发给消费者。
- 2个概念
- 轮询分发 ：使用任务队列的优点之一就是可以轻易的并行工作。如果我们积压了好多工作，我们可以通过增加工作者（消费者）来解决这一问题，使得系统的伸缩性更加容易。在默认情况下，RabbitMQ将逐个发送消息到在序列中的下一个消费者(而不考虑每个任务的时长等等，且是提前一次性分配，并非一个一个分配)。平均每个消费者获得相同数量的消息。这种方式分发消息机制称为Round-Robin（轮询）。
- 公平分发 ：虽然上面的分配法方式也还行，但是有个问题就是：比如：现在有2个消费者，所有的奇数的消息都是繁忙的，而偶数则是轻松的。按照轮询的方式，奇数的任务交给了第一个消费者，所以一直在忙个不停。偶数的任务交给另一个消费者，则立即完成任务，然后闲得不行。而RabbitMQ则是不了解这些的。这是因为当消息进入队列，RabbitMQ就会分派消息。它不看消费者为应答的数目，只是盲目的将消息发给轮询指定的消费者。

为了解决这个问题，我们使用basicQos( prefetchCount = 1)方法，来限制RabbitMQ只发不超过1条的消息给同一个消费者。当消息处理完毕后，有了反馈，才会进行第二次发送。
还有一点需要注意，使用公平分发，必须关闭自动应答，改为手动应答。

#### 5.4.Work模式的“能者多劳”

打开上述代码的注释：

```bash
// 同一时刻服务器只会发一条消息给消费者
channel.basicQos(1);

123
//开启这行 表示使用手动确认模式
channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

123
```

同时改为手动确认：

```bash
// 监听队列，false表示手动返回完成状态，true表示自动
channel.basicConsume(QUEUE_NAME, false, consumer);
```

测试：
消费者1比消费者2获取的消息更多。

#### 5.5.消息的确认模式

消费者从队列中获取消息，服务端如何知道消息已经被消费呢？

模式1：自动确认
只要消息从队列中获取，无论消费者获取到消息后是否成功消息，都认为是消息已经成功消费。
模式2：手动确认
消费者从队列中获取消息后，服务器会将该消息标记为不可用状态，等待消费者的反馈，如果消费者一直没有反馈，那么该消息将一直处于不可用状态。

手动模式：
![这里写图片描述](https://img-blog.csdn.net/2018080522513442?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

自动模式：
![这里写图片描述](https://img-blog.csdn.net/20180805225140850?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 5.6.订阅模式

![这里写图片描述](https://img-blog.csdn.net/20180805225201424?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5.6.1.图示
![这里写图片描述](https://img-blog.csdn.net/20180805225208186?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

解读：
1、1个生产者，多个消费者
2、每一个消费者都有自己的一个队列
3、生产者没有将消息直接发送到队列，而是发送到了交换机
4、每个队列都要绑定到交换机
5、生产者发送的消息，经过交换机，到达队列，实现，一个消息被多个消费者获取的目的
注意：一个消费者队列可以有多个消费者实例，只有其中一个消费者实例会消费
![这里写图片描述](https://img-blog.csdn.net/20180805225218886?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

5.6.2.消息的生产者（看作是后台系统）
向交换机中发送消息。

```bash
package com.zpc.rabbitmq.subscribe;

import com.zpc.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        //参数1 交换机的名称 参数2 （写死的），代表广播类型
        // 如果没后，就会自动创建
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "Hello World!";
        
        //参数1：交换机名称
        //参数2：路由的配置
        //参数3：交换机的配置
        //参数4：交换机的发布内容
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
```

注意：消息发送到没有队列绑定的交换机时，消息将丢失，因为，交换机没有存储消息的能力，消息只能存在在队列中。

5.6.3.消费者1（看作是前台系统）

```bash
package com.zpc.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import com.zpc.rabbitmq.util.ConnectionUtil;

public class Recv {

    private final static String QUEUE_NAME = "test_queue_work1";

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 队列绑定到交换机
        
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
```

5.6.4.消费者2（看作是搜索系统）

```bash
package com.zpc.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import com.zpc.rabbitmq.util.ConnectionUtil;

public class Recv2 {

    private final static String QUEUE_NAME = "test_queue_work2";

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv2] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
```

5.6.5.测试
测试结果：
同一个消息被多个消费者获取。一个消费者队列可以有多个消费者实例，只有其中一个消费者实例会消费到消息。

在管理工具中查看队列和交换机的绑定关系：

![这里写图片描述](https://img-blog.csdn.net/2018080522525346?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 5.7.路由模式

![这里写图片描述](https://img-blog.csdn.net/20180805225305165?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5.7.1.图示
![这里写图片描述](https://img-blog.csdn.net/20180805225313904?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

5.7.2.生产者
![这里写图片描述](https://img-blog.csdn.net/20180805225321453?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5.7.3.消费者1(假设是前台系统)
![这里写图片描述](https://img-blog.csdn.net/20180805225409633?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
5.7.4.消费2（假设是搜索系统）
![这里写图片描述](https://img-blog.csdn.net/20180805225417771?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 5.8.主题模式（通配符模式）

![这里写图片描述](https://img-blog.csdn.net/20180805225457283?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![这里写图片描述](https://img-blog.csdn.net/20180805225508284?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

5.8.1.图示
![这里写图片描述](https://img-blog.csdn.net/20180805225515258?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
同一个消息被多个消费者获取。一个消费者队列可以有多个消费者实例，只有其中一个消费者实例会消费到消息。

5.8.2.生产者

```bash
package com.zpc.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import com.zpc.rabbitmq.util.ConnectionUtil;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        // 消息内容
        String message = "Hello World!!";
        channel.basicPublish(EXCHANGE_NAME, "routekey.1", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
```

5.8.3.消费者1（前台系统）

```bash
package com.zpc.rabbitmq.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import com.zpc.rabbitmq.util.ConnectionUtil;

public class Recv {

    private final static String QUEUE_NAME = "test_queue_topic_work_1";

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "routekey.*");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv_x] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
```

5.8.4.消费者2（搜索系统）

```bash
package com.zpc.rabbitmq.topic;

import com.zpc.rabbitmq.util.ConnectionUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

public class Recv2 {

    private final static String QUEUE_NAME = "test_queue_topic_work_2";

    private final static String EXCHANGE_NAME = "test_exchange_topic";

    public static void main(String[] argv) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.*");

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [Recv2_x] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
    }
}
```

### 6.Spring-Rabbit

#### 6.1.Spring项目

http://spring.io/projects

![这里写图片描述](https://img-blog.csdn.net/2018080522565520?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 6.2.简介

![这里写图片描述](https://img-blog.csdn.net/20180805225702128?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180805225716294?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 6.3.使用

6.3.1.消费者

```bash
package com.zpc.rabbitmq.spring;

/**
 * 消费者
 *
 * @author Evan
 */
public class Foo {

    //具体执行业务的方法
    public void listen(String foo) {
        System.out.println("\n消费者： " + foo + "\n");
    }
}
```

6.3.2.生产者

```bash
package com.zpc.rabbitmq.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/rabbitmq-context.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        //发送消息
        template.convertAndSend("Hello, 鸟鹏!");
        Thread.sleep(1000);// 休眠1秒
        ctx.destroy(); //容器销毁
    }
}
```

6.3.3.配置文件
1、定义连接工厂

```bash
<!-- 定义RabbitMQ的连接工厂 -->
<rabbit:connection-factory id="connectionFactory"
   host="127.0.0.1" port="5672" username="admin" password="admin"
   virtual-host="testhost" />
```

2、定义模板（可以指定交换机或队列）

```bash
<rabbit:template id="amqpTemplate" connection-factory="connectionFactory" exchange="fanoutExchange" />

```

3、定义队列、交换机、以及完成队列和交换机的绑定

```bash
<!-- 定义队列，自动声明 -->
<rabbit:queue name="zpcQueue" auto-declare="true"/>

<!-- 定义交换器，把Q绑定到交换机，自动声明 -->
<rabbit:fanout-exchange name="fanoutExchange" auto-declare="true">
   <rabbit:bindings>
      <rabbit:binding queue="zpcQueue"/>
   </rabbit:bindings>
</rabbit:fanout-exchange>
```

4、定义监听

```bash
<rabbit:listener-container connection-factory="connectionFactory">
   <rabbit:listener ref="foo" method="listen" queue-names="zpcQueue" />
</rabbit:listener-container>

<bean id="foo" class="com.zpc.rabbitmq.spring.Foo" />
```

5、定义管理，用于管理队列、交换机等：

```bash
<!-- MQ的管理，包括队列、交换器等 -->
<rabbit:admin connection-factory="connectionFactory" />
```

完整配置文件rabbitmq-context.xml

```bash
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rabbit="http://www.springframework.org/schema/rabbit"
   xsi:schemaLocation="http://www.springframework.org/schema/rabbit
   http://www.springframework.org/schema/rabbit/spring-rabbit-1.4.xsd
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-4.1.xsd">

   <!-- 定义RabbitMQ的连接工厂 -->
   <rabbit:connection-factory id="connectionFactory"
      host="127.0.0.1" port="5672" username="admin" password="admin"
      virtual-host="testhost" />

   <!-- 定义Rabbit模板，指定连接工厂以及定义exchange -->
   <rabbit:template id="amqpTemplate" connection-factory="connectionFactory" exchange="fanoutExchange" />
   <!-- <rabbit:template id="amqpTemplate" connection-factory="connectionFactory"
      exchange="fanoutExchange" routing-key="foo.bar" /> -->

   <!-- MQ的管理，包括队列、交换器等 -->
   <rabbit:admin connection-factory="connectionFactory" />

   <!-- 定义队列，自动声明 -->
   <rabbit:queue name="zpcQueue" auto-declare="true"/>
   
   <!-- 定义交换器，把Q绑定到交换机，自动声明 -->
   <rabbit:fanout-exchange name="fanoutExchange" auto-declare="true">
      <rabbit:bindings>
         <rabbit:binding queue="zpcQueue"/>
      </rabbit:bindings>
   </rabbit:fanout-exchange>
   
<!--   <rabbit:topic-exchange name="myExchange">
      <rabbit:bindings>
         <rabbit:binding queue="myQueue" pattern="foo.*" />
      </rabbit:bindings>
   </rabbit:topic-exchange> -->

   <!-- 队列监听 -->
   <rabbit:listener-container connection-factory="connectionFactory">
      <rabbit:listener ref="foo" method="listen" queue-names="zpcQueue" />
   </rabbit:listener-container>

   <bean id="foo" class="com.zpc.rabbitmq.spring.Foo" />

</beans>
```

#### 6.4.持久化交换机和队列

![这里写图片描述](https://img-blog.csdn.net/20180805225806412?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

持久化：将交换机或队列的数据保存到磁盘，服务器宕机或重启之后依然存在。
非持久化：将交换机或队列的数据保存到内存，服务器宕机或重启之后将不存在。

非持久化的性能高于持久化。

如何选择持久化？非持久化？ – 看需求。

### 7.Spring集成RabbitMQ一个完整案例

创建三个系统A,B,C
A作为生产者，B、C作为消费者(B,C作为web项目启动)
项目下载地址：https://download.csdn.net/download/zpcandzhj/10585077

#### 7.1.在A系统中发送消息到交换机

7.1.1.导入依赖

```bash
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>

   <groupId>com.zpc</groupId>
   <artifactId>myrabbitA</artifactId>
   <version>0.0.1-SNAPSHOT</version>
   <packaging>jar</packaging>
   <name>myrabbit</name>

   <dependencies>
      <dependency>
         <groupId>org.springframework.amqp</groupId>
         <artifactId>spring-rabbit</artifactId>
         <version>1.4.0.RELEASE</version>
      </dependency>

      <dependency>
         <groupId>com.alibaba</groupId>
         <artifactId>fastjson</artifactId>
         <version>1.2.47</version>
      </dependency>
   </dependencies>
</project>

1234567891011121314151617181920212223242526
```

7.1.2.队列和交换机的绑定关系
实现：
1、在配置文件中将队列和交换机完成绑定
2、可以在管理界面中完成绑定
a)绑定关系如果发生变化，需要修改配置文件，并且服务需要重启
b)管理更加灵活
c)更容易对绑定关系的权限管理，流程管理
本例选择第2种方式
7.1.3.配置
rabbitmq-context.xml

```bash
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rabbit="http://www.springframework.org/schema/rabbit"
   xsi:schemaLocation="http://www.springframework.org/schema/rabbit
   http://www.springframework.org/schema/rabbit/spring-rabbit-1.4.xsd
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-4.1.xsd">

   <!-- 定义RabbitMQ的连接工厂 -->
   <rabbit:connection-factory id="connectionFactory"
      host="127.0.0.1" port="5672" username="admin" password="admin"
      virtual-host="testhost" />

   <!-- MQ的管理，包括队列、交换器等 -->
   <rabbit:admin connection-factory="connectionFactory" />

   <!-- 定义交换器，暂时不把Q绑定到交换机，在管理界面去绑定 -->
   <!--<rabbit:topic-exchange name="topicExchange" auto-declare="true" ></rabbit:topic-exchange>-->
   <rabbit:direct-exchange name="directExchange" auto-declare="true" ></rabbit:direct-exchange>
   <!--<rabbit:fanout-exchange name="fanoutExchange" auto-declare="true" ></rabbit:fanout-exchange>-->

   <!-- 定义Rabbit模板，指定连接工厂以及定义exchange(exchange要和上面的一致) -->
   <!--<rabbit:template id="amqpTemplate" connection-factory="connectionFactory" exchange="topicExchange" />-->
   <rabbit:template id="amqpTemplate" connection-factory="connectionFactory" exchange="directExchange" />
   <!--<rabbit:template id="amqpTemplate" connection-factory="connectionFactory" exchange="fanoutExchange" />-->
</beans>

1234567891011121314151617181920212223242526
```

7.1.4.消息内容
方案：
1、消息内容使用对象做json序列化发送
a)数据大
b)有些数据其他人是可能用不到的
2、发送特定的业务字段，如id、操作类型

7.1.5.实现
生产者MsgSender.java：

```bash
package com.zpc.myrabbit;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 消息生产者
 */
public class MsgSender {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/rabbitmq-context.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        //发送消息
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("type", "1");
        msg.put("date", date);
        template.convertAndSend("type2", JSON.toJSONString(msg));
        Thread.sleep(1000);// 休眠1秒
        ctx.destroy(); //容器销毁
    }
}

12345678910111213141516171819202122232425262728293031323334
```

#### 7.2.在B系统接收消息

7.2.1.导入依赖

```bash
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.zpc</groupId>
    <artifactId>myrabbitB</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>myrabbit</name>
    <properties>
        <spring.version>4.1.3.RELEASE</spring.version>
        <fastjson.version>1.2.46</fastjson.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.rabbitmq</groupId>
            <artifactId>amqp-client</artifactId>
            <version>3.4.1</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.amqp</groupId>
            <artifactId>spring-rabbit</artifactId>
            <version>1.4.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.47</version>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <!-- web层需要配置Tomcat插件 -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <configuration>
                    <path>/testRabbit</path>
                    <uriEncoding>UTF-8</uriEncoding>
                    <port>8081</port>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

7.2.2.配置

```bash
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rabbit="http://www.springframework.org/schema/rabbit"
   xsi:schemaLocation="http://www.springframework.org/schema/rabbit
   http://www.springframework.org/schema/rabbit/spring-rabbit-1.4.xsd
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-4.1.xsd">

   <!-- 定义RabbitMQ的连接工厂 -->
   <rabbit:connection-factory id="connectionFactory"
      host="127.0.0.1" port="5672" username="admin" password="admin"
      virtual-host="testhost" />

   <!-- MQ的管理，包括队列、交换器等 -->
   <rabbit:admin connection-factory="connectionFactory" />

   <!-- 定义B系统需要监听的队列，自动声明 -->
   <rabbit:queue name="q_topic_testB" auto-declare="true"/>

   <!-- 队列监听 -->
   <rabbit:listener-container connection-factory="connectionFactory">
      <rabbit:listener ref="myMQlistener" method="listen" queue-names="q_topic_testB" />
   </rabbit:listener-container>

   <bean id="myMQlistener" class="com.zpc.myrabbit.listener.Listener" />
</beans>

1234567891011121314151617181920212223242526
```

7.2.3.具体处理逻辑

```java
public class Listener {
    //具体执行业务的方法
    public void listen(String msg) {
        System.out.println("\n消费者B开始处理消息： " + msg + "\n");
    }
}

1234567
```

7.2.4.在界面管理工具中完成绑定关系
选中定义好的交换机(exchange)
![这里写图片描述](https://img-blog.csdn.net/20180805225931997?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
1）direct
![这里写图片描述](https://img-blog.csdn.net/20180805225943364?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
2）fanout
![这里写图片描述](https://img-blog.csdn.net/20180805225950165?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
3）topic
![这里写图片描述](https://img-blog.csdn.net/2018080522595647?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pwY2FuZHpoag==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

#### 7.3.在C系统中接收消息

（和B系统配置差不多，无非是Q名和Q对应的处理逻辑变了）

7.3.1.配置

```java
<beans xmlns="http://www.springframework.org/schema/beans"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:rabbit="http://www.springframework.org/schema/rabbit"
   xsi:schemaLocation="http://www.springframework.org/schema/rabbit
   http://www.springframework.org/schema/rabbit/spring-rabbit-1.4.xsd
   http://www.springframework.org/schema/beans
   http://www.springframework.org/schema/beans/spring-beans-4.1.xsd">

   <!-- 定义RabbitMQ的连接工厂 -->
   <rabbit:connection-factory id="connectionFactory"
      host="127.0.0.1" port="5672" username="admin" password="admin"
      virtual-host="testhost" />

   <!-- MQ的管理，包括队列、交换器等 -->
   <rabbit:admin connection-factory="connectionFactory" />

   <!-- 定义C系统需要监听的队列，自动声明 -->
   <rabbit:queue name="q_topic_testC" auto-declare="true"/>

   <!-- 队列监听 -->
   <rabbit:listener-container connection-factory="connectionFactory">
      <rabbit:listener ref="myMQlistener" method="listen" queue-names="q_topic_testC" />
   </rabbit:listener-container>

   <bean id="myMQlistener" class="com.zpc.myrabbit.listener.Listener" />
</beans>

```

7.3.2.处理业务逻辑

```java
public class Listener {

    //具体执行业务的方法
    public void listen(String msg) {
        System.out.println("\n消费者C开始处理消息： " + msg + "\n");
    }
}

```

7.3.3.在管理工具中绑定队列和交换机
见7.2.4

7.3.4.测试
分别启动B,C两个web应用，然后运行A的MsgSender主方法发送消息，分别测试fanout、direct、topic三种类型

### 8.Springboot集成RabbitMQ

- springboot集成RabbitMQ非常简单，如果只是简单的使用配置非常少，springboot提供了spring-boot-starter-amqp对消息各种支持。
  代码下载地址：https://download.csdn.net/download/zpcandzhj/10585077

#### 8.1.简单队列

1、配置pom文件，主要是添加spring-boot-starter-amqp的支持

```bash
<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>

```

2、配置application.properties文件
配置rabbitmq的安装地址、端口以及账户信息

```bash
spring.application.name=spirng-boot-rabbitmq
spring.rabbitmq.host=127.0.0.1
spring.rabbitmq.port=5672
spring.rabbitmq.username=admin
spring.rabbitmq.password=admin
```

3、配置队列

```bash
package com.zpc.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("q_hello");
    }
}
```

4、发送者

```bash
package com.zpc.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
        String context = "hello " + date;
        System.out.println("Sender : " + context);
        //简单对列的情况下routingKey即为Q名
        //注意队列中生产者无法创造队列，必须有消费者来创造
        this.rabbitTemplate.convertAndSend("q_hello", context);
    }
}
```

5、接收者

```bash
package com.zpc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare =@Queue(value = "q_hello"))  //用来声明队列的属性，持久化、自动删除等，默认非独占、持久化
public class HelloReceiver {

    @RabbitHandler //代表从队列中拿到消息后，使用这个方法来处理
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }
}
```

6、测试

```bash
package com.zpc.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
}
```

#### 8.2.多对多使用（Work模式）

注册两个Receiver:

```bash
package com.zpc.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver2 {

	//注解可以还可以放在方法上面
    @RabbitListener(queuesToDeclare =@Queue(value = "q_hello"))  //用来声明队列的属性，持久化、自动删除等，默认非独占、持久化
    public void process(String hello) {
        System.out.println("Receiver2  : " + hello);
    }
    
 	//注解可以还可以放在方法上面
    @RabbitListener(queuesToDeclare =@Queue(value = "q_hello"))  //用来声明队列的属性，持久化、自动删除等，默认非独占、持久化
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }

}

@Test
public void oneToMany() throws Exception {
    for (int i=0;i<100;i++){
        helloSender.send(i);
        Thread.sleep(300);
    }
}

public void send(int i) {
    String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());//24小时制
    String context = "hello " + i + " " + date;
    System.out.println("Sender : " + context);
    //简单对列的情况下routingKey即为Q名
    this.rabbitTemplate.convertAndSend("q_hello", context);
}

```

#### 8.3.Topic Exchange（主题模式）

- topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列

首先对topic规则配置，这里使用两个队列(消费者)来演示。
1)配置队列，绑定交换机

```bash
package com.zpc.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    final static String message = "q_topic_message";
    final static String messages = "q_topic_messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    /**
     * 声明一个Topic类型的交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("mybootexchange");
    }

    /**
     * 绑定Q到交换机,并且指定routingKey
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
```

2)创建2个消费者
q_topic_message 和q_topic_messages

```bash
package com.zpc.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_topic_message")
public class Receiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}

package com.zpc.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_topic_messages")
public class Receiver2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2 : " + hello);
    }
}

```

3)消息发送者（生产者）

```bash
package com.zpc.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mybootexchange", "topic.message", context);
    }


    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mybootexchange", "topic.messages", context);
    }
}

```

send1方法会匹配到topic.#和topic.message，两个Receiver都可以收到消息，发送send2只有topic.#可以匹配所有只有Receiver2监听到消息。
4)测试

```bash
package com.zpc.rabbitmq.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTopicTest {

    @Autowired
    private MsgSender msgSender;

    @Test
    public void send1() throws Exception {
        msgSender.send1();
    }

    @Test
    public void send2() throws Exception {
        msgSender.send2();
    }
}

```

#### 8.4.Fanout Exchange（订阅模式）

- Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
  1)配置队列，绑定交换机

```bash
package com.zpc.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

	//创建三个队列
    @Bean
    public Queue aMessage() {
        return new Queue("q_fanout_A");
    }

    @Bean
    public Queue bMessage() {
        return new Queue("q_fanout_B");
    }

    @Bean
    public Queue cMessage() {
        return new Queue("q_fanout_C");
    }

	//创建交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("mybootfanoutExchange");
    }
    

	//队列绑定绑定交换机
    @Bean
    Binding bindingExchangeA(Queue aMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(aMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue bMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue cMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(cMessage).to(fanoutExchange);
    }
}
```

2）创建3个消费者

```bash
package com.zpc.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_fanout_A")
public class ReceiverA {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("AReceiver  : " + hello + "/n");
    }
}


package com.zpc.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_fanout_B")
public class ReceiverB {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("BReceiver  : " + hello + "/n");
    }
}


package com.zpc.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_fanout_C")
public class ReceiverC {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("CReceiver  : " + hello + "/n");
    }
}


```

3）生产者

```bash
package com.zpc.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgSenderFanout {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("mybootfanoutExchange","", context);
    }
}

```

4）测试

```bash
package com.zpc.rabbitmq.fanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitFanoutTest {

    @Autowired
    private MsgSenderFanout msgSender;

    @Test
    public void send1() throws Exception {
        msgSender.send();
    }
}
```

结果如下，三个消费者都收到消息：
AReceiver : hi, fanout msg
CReceiver : hi, fanout msg
BReceiver : hi, fanout msg

### 9.解决分布式事务原理方案

#### 项目说明：

模拟外卖案例，用户下单之后，调用订单服务，然后订单服务间消息发给派送服务通知外卖人员送餐，订单系统与派单系统采用MQ异步通讯。

1. 确保生产者一定要将数据投递到MQ服务器中
   - 生产者采用confirm，确认应答机制
   - 如果失败，生产者进行重试。
2. MQ消费者消息能够正常消费消息。
   - 采用手动ACK模式，使用补偿机制，注意幂等性问题。
3. 采用补单机制。
   - 在创建一个补单消费者进行监听，如果订单创建后，又回滚了(数据不一致)，此时需要将订单进行补偿。
   - 交换机采用路由键模式，补单队列和派但队列都绑定同一个路由键。

#### **订单服务**

**配置交换机，可以配置多个**

```java
package com.gpdi.order.config;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Lxq
 * @Date 2020/3/7 13:59
 * @Version 1.0
 * 消息交换机配置，可以配置多个
 */


@Configuration
public class ExchangeConfig {

    private final String EXCHANGE_ORDER_DISPATCH = "order-dispatch";

    @Bean
   public DirectExchange directExchange() {
    DirectExchange directExchange = new DirectExchange(EXCHANGE_ORDER_DISPATCH, true, false);
        return directExchange;
    }
}
```

**配置队列信息**

```java
package com.gpdi.order.config;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Lxq
 * @Date 2020/3/7 14:06
 * @Version 1.0
 * 配置队列，这里只使用第一个
 */

@Configuration
public class QueueConfig {


    /*对列名称*/
    public static final String QUEUE_NAME1 = "dispatch-queue";
    public static final String QUEUE_NAME2 = "second-queue";
    public static final String QUEUE_NAME3 = "third-queue";


    @Bean
    public Queue DispatchQueue() {
        /**
         durable="true" 持久化消息队列 ， rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(QUEUE_NAME1,true,false,false);
    }



    @Bean
    public Queue SecondQueue() {
        return new Queue(QUEUE_NAME2,true,false,false);
    }
    @Bean
    public Queue ThirdQueue() {
        // 配置 自动删除
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl", 60000);//60秒自动删除
        return new Queue(QUEUE_NAME3,true,false,true,arguments);
    }

}
```

**将配置的交换机和队列进行绑定**

```java
package com.gpdi.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author Lxq
 * @Date 2020/3/7 14:10
 * @Version 1.0
 * 将交换机和队列进行绑定
 */
@Configuration
public class RabbitMqConfig {

    /**
     * key: queue在该direct-exchange中的key值，当消息发送给direct-exchange中指定key为设置值时，
     * 消息将会转发给queue参数指定的消息队列
     */
    /** 队列key*/
    public static final String ROUTING_KEY_ORDER_DISPATCH = "order-dispatch-key";

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 将消息队列和交换机进行绑定,指定队列ROUTING_KEY_ORDER_DISPATCH
     */

    @Bean
    public Binding bindingDispatch(){
        return BindingBuilder.bind(queueConfig.DispatchQueue())
                .to(exchangeConfig.directExchange())
                .with(ROUTING_KEY_ORDER_DISPATCH);
    }
}
```

新建两个表，一个订单表（存放下单信息），一个本地信息表（关联订单表，存放订单状态，是否发送给mq）

```
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户编号',
  `order_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单内容',
  `create_time` datetime(0) DEFAULT NULL COMMENT '订单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息编号',
  `msg_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消息内容',
  `msg_status` int(255) DEFAULT NULL COMMENT '消息状态',
  `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '本地消息表' ROW_FORMAT = Dynamic;
```

 **订单核心代码**

```java
package com.gpdi.order.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gpdi.order.dao.MessageMapper;
import com.gpdi.order.dao.OrderMapper;
import com.gpdi.order.domain.Message;
import com.gpdi.order.domain.Order;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
 * @Author Lxq
 * @Date 2020/3/7 15:56
 * @Version 1.0
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private MessageMapper messageMapper;


    @PostConstruct
    public void setUP() {

       // Mq的确认回执
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {

            @Override
            public void confirm(@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) {

                if (!ack) {
                    //mq没有接收到消息
                    //ToDo 忽略或者重新发送消息
                    return;

                }

                // 修改本地消息表
                int i = messageMapper.updateById(Long.valueOf(correlationData.getId()));

                if (i > 0){
                    System.out.println("消息发送成功");
                }
            }
        });
    }

    @Override
   public void createOrder(String order) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Order content = new Order();
        content.setUserId(1);
        content.setOrderContent(order);
        content.setCreateTime(sdf.format(new Date()));
        orderMapper.insert(content);
        System.out.println(content.getId());

        //存放到本地消息表
        Message message = new Message();
        message.setId(content.getId());
        message.setMsgContent(content.getOrderContent());
        message.setMsgStatus(0);
        message.setCreateTime(sdf.format(new Date()));
        messageMapper.insert(message);
        sendMessage(message);

    }

    @Override
    public void sendMessage(Message message) {
        rabbitTemplate.convertAndSend("order-dispatch", "order-dispatch-key", JSONObject.toJSONString(message),

                new CorrelationData(String.valueOf(message.getId())));
    }
}
```

 **派送订单核心代码**

```java
package com.gpdi.dispatch.service;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import java.io.IOException;


/**
 * @Author Lxq
 * @Date 2020/3/7 17:43
 * @Version 1.0
 * 消费者
 */

@Component
public class OrderDispatchConsumer {


   @RabbitListener(queues = "dispatch-queue")
    public void messageConsumer(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        try {
            // 收到MQ消息

           System.out.println(message);

       	    // 插入到派送单中


   		      //todo
            // 给MQ回执

         channel.basicAck(tag,false);

        } catch (Exception e) {
            // 重新发一次
           channel.basicNack(tag, false, true);


        }

    }
}
```

直接下载源码：

```
链接：https://pan.baidu.com/s/1tR94adXviEFLEmQZ6G4iDw 
提取码：lnbq 
复制这段内容后打开百度网盘手机App，操作更方便哦
```

 



# docker

## 1. 介绍

### 1. 目的

> 安装一个比较稳定的环境运行程序

### 2. 由来

> 1. 2010 年，一对年轻人创办Pass平台，到了2013年，亚马逊、微软、Google也开始做Pass，所以小公司开始对外开源核心技术，也就是Docker的前身，到了2014年，公司得到了C轮融资，专门用来维护Docker，到了2015年得到了D轮融资。
> 2. Docker的作者已经离开Docker

### 3. 思想

> 1. 提供了一个标准化的运行环境
> 2. 轻量级的运行环境，启动更加方便，比虚拟机启动更快
> 3. 隔离性更加方便，模块下的使用，docker开辟了一个空间，然后提供了一个更好的隔离环境
> 4. 运行程序的集装箱

## 2 安装docker

~~~bash

# 移除老版本的Docker
sudo yum remove docker

# 添加Docker repository yum源
sudo yum-config-manager --add-repo  https://mirrors.ustc.edu.cn/docker-ce/linux/centos/docker-ce.repo

# 安装Docker Engine
sudo yum makecache fast
sudo yum install docker-ce docker-ce-cli containerd.io

# 开启Docker
sudo systemctl enable docker
sudo systemctl start docker

# 验证是否安装成功
sudo docker run hello-world

# 在前面不添加sudo, 可以执行如下命令
sudo usermod -aG docker $USER
~~~









~~~
yum install -y docker-io
~~~



### 1. Docker的安装和测试

![image-20200811200325201](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20200811200325201.png)

### 2.Docker的仓库

> # Docker的中央仓库
>
> 1. Docker官方的中央仓库：这个仓库的镜像最全，但是下载速度比较慢，服务器在国外
> 2. 国内的镜像网站：网易蜂巢（需要登陆，比较麻烦）、DaoCloud（主要使用daocloud）【http://hub.daocloud.io/】
> 3. 在公司内部会使用私服的方式拉去镜像
> 4. 您可以配置 Docker 守护进程默认使用 Docker 官方镜像加速。这样您可以默认通过官方镜像加速拉取镜像，而无需在每次拉取时指定 registry.docker-cn.com。
>
> 5. 您可以在 Docker 守护进程启动时传入 `--registry-mirror` 参数：
>
> ```
> $ docker --registry-mirror=https://registry.docker-cn.com daemon
> ```
>
> ​	为了永久性保留更改，您可以修改 `/etc/docker/daemon.json` 文件并添加上 registry-mirrors 键值。
>
> ```
> {
>   "registry-mirrors": ["https://registry.docker-cn.com"]
> }
> ```
>
> 修改保存后重启 Docker 以使配置生效。　　　　　　　　

### 3. Docker的镜像操作

>1. 使用前先拉取镜像
>
>~~~sh
>docker pull 镜像名称[:tag]
>#举例子
>docker pull daocloud.io/library/tomcat:8.5.15-jre8
>~~~
>
>2. 查看本地的镜像
>
>~~~sh
>docker images
>~~~
>
>3. 删除本地镜像
>
>~~~sh
>docker rmi 镜像的唯一标识
># 删除本地所有镜像
>docker rmi  -f  $(docker images -qa)
>
># 删除所有标签为空的镜像
>docker rmi  -f  $(docker images -qf dangling=true)
>
>~~~
>
>4. 镜像的导入导出（不规范）
>
>~~~sh
>#将本地的镜像导出
>docker save -o 导出的路径 镜像id
>#加载本地的镜像文件
>docker load -i 镜像名称
>~~~
>
>5. 改变docker的名称
>
>~~~sh
>docker tag 镜像标签 更改的名称：版本
>~~~

### 4. 容器的操作

> 1. 运行容器
>
>    ~~~sh
>    #简单操作
>    docker run 镜像的标识|镜像的名称[:tag]
>    #常规操做
>    docker run -d -p 宿主机端口:容器端口 --name 容器名称 镜像的标识|镜像的名称[:tag]
>    #-d 代表后台运行，-p 宿主机端口:容器端口：为了映射当前linux的端口和容器的端口，外部能够访问到docker容器
>    #--name 容器名称：指定容器的名称
>    # docker run -d -p 6379:6379 --name myredis docker.io/redis  --net=host
>    ~~~
>
> 2. 查看正在运行的容器
>
>    ~~~sh
>    docker ps [-a或者-q]
>    # -a 查看docker的全部
>    # -q 只查看docker的标识
>    ~~~
>
> 3. 查看docker的日志（重要）
>
>    ~~~
>    docker logs -f 容器id
>    # -f 代表可以滚动查看日志的最后几行
>    ~~~
>
> 4. 进入到容器内部进行操作
>
>    ~~~sh
>    docker  exec  -it 容器id bash
>    ~~~
>
> 5. 删除容器
>
>    ~~~sh
>    # 删除容器前需要先停止容器
>    docker rm 容器id
>    # 删除所有容器
>    docker rm $(docker ps -qa)
>    ~~~
>
> 6. 停止容器
>
>    ~~~sh
>    #停止容器
>    docker stop 容器id
>    #停止全部容器
>    docker stop $(docker ps -qa)
>    ~~~
>
> 7. 启动容器
>
>    ~~~sh
>    docker start 容器id
>    ~~~

##  3. Docker应用

### 1.准备SSM工程

### 2. 准备mysql容器

~~~
1.安装mysql
docker run -d -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 daocloud.io/library/mysql:5.7.4
~~~

## 4. Docker Componse

### 1. 目的

> 之前运行一个镜像，需要添加大量的参数，但是我们可以通过Docker-componse编写这些参数，他可以帮助我们批量管理容器，只要通过一个docker-componse.yml文件即可

### 2. 安装Docker Componse

~~~sh
安装
curl -L https://get.daocloud.io/docker/compose/releases/download/1.25.1/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose

配置权限
chmod +x /usr/local/bin/docker-compose

给docker-compose添加执行权限
sudo chmod +x /usr/local/bin/docker-compose

查看版本
docker-compose -version
~~~

### 3. 快速运行





## 5 .DockerFile

### 1.简介

> Dockerfile其实就是我们用来构建Docker镜像的源码，简单来说就是**自定义镜像的一个文件**

#  6.Harbor

1. 简介

> 作为私有仓库，性能够好

# Gitlab

##　1. 安装

1. 安装相关依赖

~~~
yum -y install policycoreutils openssh-server openssh-clients postfix
~~~

2 . 启动ssh服务&设置为开机启动

~~~ 
systemctl enable sshd && sudo systemctl start sshd
~~~



3 . 设置postfix开机自启，并启动，postfix支持gitlab发信功能

~~~
systemctl enable postfix && systemctl start postfix
~~~



4 . 开放ssh以及http服务，然后重新加载防火墙列表

~~~
firewall-cmd --add-service=ssh --permanent
firewall-cmd --add-service=http --permanent
firewall-cmd --reload
~~~

如果关闭防火墙就不需要做以上配置

5 . 下载gitlab包，并且安装

~~~
在线下载安装包：
wget  https://mirrors.tuna.tsinghua.edu.cn/gitlab-ce/yum/el6/gitlab-ce-12.4.2-ce.0.el6.x86_64.rpm

安装：
rpm -i gitlab-ce-12.4.2-ce.0.el6.x86_64.rpm
~~~

6 . 修改gitlab配置

~~~
vi /etc/gitlab/gitlab.rb
修改gitlab访问地址和端口，默认为80，我们改为82
external_url ' http://192.168.66.100:82'
nginx['listen_port'] = 82
~~~

7 . 重载配置及启动gitlab

~~~
gitlab-ctl reconfigure
gitlab-ctl restart
~~~

8 . 把端口添加到防火墙

~~~
firewall-cmd --zone=public --add-port=82/tcp --permanent
firewall-cmd --reload
~~~


启动成功后，看到以下修改管理员root密码的页面，修改密码后，然后登录即可

![image-20201022153021584](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153021584.png)

## 2. 基础应用（用户管理）

1. Gitlab添加组、创建用户、创建项目
   1）创建组
   使用管理员 root 创建组，一个组里面可以有多个项目分支，可以将开发添加到组里面进行设置权限，
   不同的组就是公司不同的开发项目或者服务模块，不同的组添加不同的开发即可实现对开发设置权限的
   管理![image-20201022153156593](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153156593.png)

   2）创建用户
   创建用户的时候，可以选择Regular或Admin类型。![image-20201022153210333](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153210333.png)

   ​		==创建完用户后，立即修改密码==



​			3）将用户添加到组中

​			选择某个用户组，进行Members管理组的成员![image-20201022153433768](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153433768.png)![image-20201022153445051](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153445051.png)







Gitlab 用户在组里面有5种不同权限：

Guest：可以创建issue、发表评论，不能读写版本库 Reporter：可以克隆代码，不能提交，QA、PM可以赋予这个权限

Developer：可以克隆代码、开发、提交、push，普通开发可以赋予这个权限

Maintainer：可以创建项目、添加tag、保护分支、添加项目成员、编辑项目，核心开发可以赋予这个

权限 Owner：可以设置项目访问权限 - Visibility Level、删除项目、迁移项目、管理组成员，开发组组长可以赋予这个权限

​		

4）在用户组中创建项目

以刚才创建的新用户身份登录到Gitlab，然后在用户组中创建新的项目

![image-20201022153631002](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153631002.png)![image-20201022153640474](C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022153640474.png)





## 3. 源码上传

1. 源码上传到Gitlab仓库下面来到IDEA开发工具，我们要把源码上传到Gitlab的项目仓库中。下图是简单的项目结构<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022154700651.png" alt="image-20201022154700651" style="zoom:80%;" />
2. 开启版本控制

<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022154727145.png" alt="image-20201022154727145" style="zoom:80%;" />

3. 提交代码到本地仓库，先ADD，然后在Commit<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022154809671.png" alt="image-20201022154809671" style="zoom:80%;" />



4. 推送到Gitlab项目仓库中

<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022154947396.png" alt="image-20201022154947396" style="zoom:80%;" />



<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022155010519.png" alt="image-20201022155010519" style="zoom:80%;" />



<img src="C:\Users\Krest\AppData\Roaming\Typora\typora-user-images\image-20201022155033836.png" alt="image-20201022155033836" style="zoom:80%;" />







# 持续化部署

## SSH辅助（方式一）

1. 生成SSH

~~~
ssh-keygen
~~~

2. 拷贝公钥

方便Jenkins做生产部署

~~~
#cd /root/.shh/
#可以查看是否有公钥,如果没有就复制
ssh-copy-id 192.168.66.103
#给予文件可执行权限
chmod +x authorized_keys 
~~~

## SSH辅助（方式二）

这两天在学习ansible，想要用ssh连接另一台linux服务器

```shell
#生成ssh，输入以下指令然后一直回车，在 .ssh/下会有公钥和私钥
ssh-keygen 

#发送公钥至目标主机，目标主机的.ssh/下会有authorized_keys，里面存放了公钥
ssh-copy-id root@xxx.xxx.xxx.xxx
12345
```

刚开始我是用这个方法去向目标主机发送公钥，然后我打算用ansible去ping这个主机的时候

```shell
#ping主机的命令
ansible all -m ping
12
```

却报错
**sh: .ssh/authorized_keys: Permission denied**
我查了好多资料，后面是解决了，接下来写出我的解决过程（把之前的.ssh下面的文件都删了，重新再来生成一边，把目标主机authorized_keys也删了）

```shell
#生成ssh
ssh-keygen 
#将公钥的内容写入authorized_keys中
cat id_rsa.pub >> authorized_keys

#将公钥发送给目标主机
scp id_rsa.pub xxx.xxx.xxx.xxx:/root/.ssh

#-----------------接下来是目标主机的操作----------
#刚开始删除的时候报Operation not permitted，用这个指令就可以了
chattr -i authorized_keys  
#删除原来的authorized_keys文件
rm -rf authorized_keys
cat id_rsa.pub >> authorized_keys
```

然后我再ping的时候就成功了
![在这里插入图片描述](https://duxin2010.oss-cn-beijing.aliyuncs.com/20210201230105.png)
在我刚毕业的时候也接触了ansible，可是那时候我没有linux基础，那时候也遇到了这个问题，可是解决不了。现在熟悉了linux操作后，才发现这个问题解决的那么简单。学习的路还有很长啊！

