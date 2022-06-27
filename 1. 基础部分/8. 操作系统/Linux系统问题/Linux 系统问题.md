# 虚拟机磁盘扩容



原来centos里是20G，扩容成40G：

参考视频见：https://www.bilibili.com/video/BV1XK411V79z?from=search&seid=2073530284437499557

vmware里设置好之后，需要在centos里挂载上，过程如下：

查看分区情况：

```
df -h
```

![img](https://img-blog.csdnimg.cn/20200621215155546.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

```
sudo fdisk -l
```

![img](https://img-blog.csdnimg.cn/20200621215302458.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

 **fdisk**创建和维护分区表：

```
sudo fdisk /dev/sda
```

![img](https://img-blog.csdnimg.cn/20200621215328351.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

输入：

```
n
```

然后选择：

```
p
```

![img](https://img-blog.csdnimg.cn/20200622092726837.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

```
print
```

![img](https://img-blog.csdnimg.cn/20200622092909977.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

输入：

```
t
3
8e
```

![img](https://img-blog.csdnimg.cn/20200622093026896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

输入：

```
w
```

![img](https://img-blog.csdnimg.cn/20200622001204184.png)

通知系统分区表的变化:

```
partprobe
```

![img](https://img-blog.csdnimg.cn/20200622001253732.png)

查看硬盘及分区信息:

```
fdisk -l
```

![img](https://img-blog.csdnimg.cn/20200622001325801.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

将物理硬盘分区初始化为物理卷,以便LVM使用:

```
pvcreate /dev/sda3
```

![img](https://img-blog.csdnimg.cn/20200622001545406.png)

 

```
pvdisplay
```

![img](https://img-blog.csdnimg.cn/20200622001613320.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

```html
将初始化过的分区加入到虚拟卷组centos:
vgextend centos /dev/sda3
pvdisplay
```

![img](https://img-blog.csdnimg.cn/20200622001725651.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

![img](https://img-blog.csdnimg.cn/20200622001931373.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

试探一下20G：

```
lvresize -L +20G /dev/mapper/centos-root
```

发现不可以，改成19.9是可以的。

```
lvresize -L +19.9G /dev/mapper/centos-root
```

![img](https://img-blog.csdnimg.cn/20200622002056105.png)

 

```
xfs_growfs /dev/mapper/centos-root
```

![img](https://img-blog.csdnimg.cn/20200622002134631.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

最终用df -h看一下：

![img](https://img-blog.csdnimg.cn/20200622002154973.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3pzMzkxMDc3MDA1,size_16,color_FFFFFF,t_70)

成功！



# 内存拓展（内存不足SWAP解决方案）

## 下面是创建使用SWAP的方法：

一、创建文件

```bash
dd if=/dev/zero of=/etc/swapfile bs=1024 count=4096000
```

> SSH执行以上命令，创建一个名为vpppscom的4G 空文件（写0占用磁盘）。

二、制作为Swap文件

```bash
 mkswap /etc/swapfile
```

> SSH执行以上命令，将生成的vpppscom制作为SWAP文件，若没有制作SWAP文件，执行下一步可能会出现：“swapon: vpppscom: read swap header failed: Invalid argument”错误。

三、让Swap文件生效

```bash
 swapon /etc/swapfile
```

> SSH执行以上命令，使“vpppscom”这个Swap文件生效，并叠加进当前sawp空间中。

四、查看当前SWAP

```bash
swapon -s
```

> SSH执行以上命令，查看当前swap的情况。

五、自动挂载
1）编辑/etc/fstab

```bash
vi /etc/fstab
```

2）按格式填入

```bash
/etc/swapfile swap    swap    defaults      0    0
```

按格式填入以上信息：

```bash
/dev/vda1 / ext3 noatime,acl,user_xattr 1 1
proc /proc proc defaults 0 0
sysfs /sys sysfs noauto 0 0
debugfs /sys/kernel/debug debugfs noauto 0 0
devpts /dev/pts devpts mode=0620,gid=5 0 0
/etc/swapfile swap swap defaults 0 0
```

至此未出现任何错误，那么SWAP就创建好了，使用free -m命令就可以看到了。

## 下面是销毁停用SWAP的方法：

1、先停止swap分区

```bash
/sbin/swapoff /etc/swapfile
```

2、删除swap分区文件

```bash
rm -rf /etc/swapfile
```

3、修改/etc/fstab文件，把

```bash
/etc/swapfile swap swap defaults 0 0
```

这行删除。
这样就能把手动增加的分区删除了。

> PS：
>
> 1、增加删除swap的操作只能使用root用户来操作。
>
> 2、装系统时分配的swap分区貌似删除不了。
>
> 3、swap分区一般为内存的2倍，但最大不超过2G

然SWAP只是缓兵之计，实际使用中当然没能比的上真实的内存，所以要想得到更好的体验还是购买更大的内存吧！



# SSH 远程登陆

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
```

刚开始我是用这个方法去向目标主机发送公钥，然后我打算用ansible去ping这个主机的时候

```shell
#ping主机的命令
ansible all -m ping
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
![在这里插入图片描述](https://duxin2010.oss-cn-beijing.aliyuncs.com/20210202165017.png)
在我刚毕业的时候也接触了ansible，可是那时候我没有linux基础，那时候也遇到了这个问题，可是解决不了。现在熟悉了linux操作后，才发现这个问题解决的那么简单。学习的路还有很长啊！



# linux下用命令查看端口占用

其实我一般这样用:

[root@VM_39_230_centos bin]# **lsof -i:9990**
COMMAND  PID  USER  FD  TYPE  DEVICE SIZE/OFF NODE NAME
     java   27773 appusr  43u  IPv4 28814431       0t0  TCP *:osm-appsrvr (LISTEN)

或者

~~~
[root@VM_39_230_centos bin]# netstat -ntulp | grep 5601
tcp     0    0 0.0.0.0:9990         0.0.0.0:*          LISTEN    27773/java 
~~~





**找到pid  然后** 

~~~
[root@VM_39_230_centos bin]# **ps -aux | grep 27773**
appusr   744  0.0  0.0 103312  876 pts/9   S+  17:39  0:00 grep 27773
appusr  27773  0.2  2.9 4505632 241276 ?    Sl   2018 182:08 java -jar pic-api-1.0.0-SNAPSHOT.jar
~~~

杀死该进程

~~~
kill -9 27773
~~~



