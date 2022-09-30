# JVM 参数

## 参数介绍

### 常用设置参数

> 表示设置JVM启动内存的最小值为20M，必须以M为单位

`-Xms20M`

> 表示设置JVM启动内存的最大值为20M，必须以M为单位。将-Xmx和-Xms设置为一样可以避免JVM内存自动扩展

`-Xmx20M`

> 表示可以设置虚拟机栈的大小为180k JDK 11 ,最小 180K

`-Xss180k`

> 表示让JVM使用G1垃圾收集器

`-XX:+UseG1GC`

> 表示使用并发模式的垃圾回收机制，该模式适用于对响应时间要求高，具有多cpu的环境下

`-XX:+UseConcMarkSweepGC`

>  设置此选项后，并行收集器会自动选择年轻代区大小和相应的Survivor区比例，以达到目标系统规定的最低响应时间或者收集频率等，此值建议使用并行收集器时，一直打开

`-XX:+UseAdaptiveSizePolicy`

> 表示可以让虚拟机在出现内存溢出异常时Dump出当前的堆内存转储快照

`-XX:+HeapDumpOnOutOfMemoryError`

> dump 文件存放位置

`-XX:HeapDumpPath=d:\`

> 表示对象大于3145728（3M）时直接进入老年代分配，这里只能以字节作为单位

`-XX:PretenureSizeThreshold=3145728`

> 设置原空间的大小

`-XX:MetaspaceSize=3M`

> 设置最大的元空间大小

` -XX:MaxMetaspaceSize=3M`

### 其他参数

> 表示输出虚拟机中GC的详细情况，在控制台打印

`-verbose:gc`

> 表示设置本地方法栈的大小为128k。不过HotSpot并不区分虚拟机栈和本地方法栈，因此对于HotSpot来说这个参数是无效的

`-Xoss128k`

> **注意**：该配置在jdk 8的时候已经被移除
>
> 表示JVM初始分配的永久代（方法区）的容量，必须以M为单位

`-XX:PermSize=10M`

> 表示关闭JVM对类的垃圾回收

`-Xnoclassgc`

> 表示设置 年轻代（包括Eden和两个Survivor区）/老年代 的大小比值为1：4，这意味着年轻代占整个堆的1/5

`-XX:NewRatio=4`

> 表示设置2个Survivor区：1个Eden区的大小比值为2:8，这意味着Survivor区占整个年轻代的1/5，这个参数默认为8

`-XX:SurvivorRatio=8`

`-XX:+PrintGCDetails`

>  表示在控制台上打印出GC具体细节

`-XX:+PrintGC`

> 表示在控制台上打印出GC信息



`-XX:MaxTenuringThreshold=1`

> 表示对象年龄大于1，自动进入老年代,如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。对于年老代比较多的应用，可以提高效率。如果将此值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，这样可以增加对象在年轻代的存活时间，增加在年轻代被回收的概率。

`-XX:CompileThreshold=1000`

> 表示一个方法被调用1000次之后，会被认为是热点代码，并触发即时编译

`-XX:+PrintHeapAtGC`

> 表示可以看到每次GC前后堆内存布局

`-XX:+PrintTLAB`

> 表示可以看到TLAB的使用情况

`-XX:+UseSpining`

> 开启自旋锁

`-XX:PreBlockSpin`

> 更改自旋锁的自旋次数，使用这个参数必须先开启自旋锁

`-XX:+UseSerialGC`

> 表示使用jvm的串行垃圾回收机制，该机制适用于丹cpu的环境下

`-XX:+UseParallelGC`

>  表示使用jvm的并行垃圾回收机制，该机制适合用于多cpu机制，同时对响应时间无强硬要求的环境下，使用-XX:ParallelGCThreads=<N>设置并行垃圾回收的线程数，此值可以设置与机器处理器数量相等。

`-XX:+UseParallelOldGC`

>  表示年老代使用并行的垃圾回收机制

`-XX:MaxGCPauseMillis=100`

> 设置每次年轻代垃圾回收的最长时间，如果无法满足此时间，JVM会自动调整年轻代大小，以满足此值。





## Dump 文件

### 什么是Dump文件

Dump文件是进程的[内存](https://so.csdn.net/so/search?q=内存&spm=1001.2101.3001.7020)镜像。可以把程序的执行状态通过调试器保存到dump文件中。
Dump文件是用来给程序编写人员调试程序用的，这种文件必须用专用工具软件打开。

### 如何生成Dump文件

1. 使用命令：jstack pid，可以查看到当前运行的java进程的dump信息。
2. 设置JVM参数，当发生异常是主动生产 dump 文件



### Dump文件结构

1. 其中每个空行用于分隔一个线程，
2. 每个线程的信息是以堆栈信息的方式展开，
3. 显示了目前正在调用的方法以及所在的代码行。
4. 每个线程信息的第一行是描述该线程的基本信息



如：`“http-nio-8081-exec-10” #25 daemon prio=5 os_prio=0 tid=0x00007f87e028c000 nid=0x6724 waiting on condition [0x00007f87b97d2000]`
每一个部分的含义如下：

+ “http-nio-8081-exec-10” 线程名称
+ #25 线程编号
+ daemon 线程的类型
+ prio=5 线程的优先级别
+ os_prio=0 系统级别的线程优先级
+ tid=0x00007f87e028c000 线程ID
+ nid=0x6724 native线程的id
+ waiting on condition [0x00007f87b97d2000] 线程当前的状态
+ 线程当前的状态是我们主要关注的内容。



~~~plain
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.77-b03 mixed mode):

"Attach Listener" #37 daemon prio=9 os_prio=0 tid=0x00007f87b42b7000 nid=0x680f waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Druid-ConnectionPool-Destory-331358539" #36 daemon prio=5 os_prio=0 tid=0x00007f87a4278800 nid=0x67e4 waiting on condition [0x00007f87b8dce000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at com.alibaba.druid.pool.DruidDataSource$DestroyConnectionThread.run(DruidDataSource.java:1724)

"Druid-ConnectionPool-Create-331358539" #35 daemon prio=5 os_prio=0 tid=0x00007f87a4022000 nid=0x67e3 waiting on condition [0x00007f87ce86a000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x00000000b3804848> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
        at com.alibaba.druid.pool.DruidDataSource$CreateConnectionThread.run(DruidDataSource.java:1629)

"Abandoned connection cleanup thread" #31 daemon prio=5 os_prio=0 tid=0x00007f87e0d91800 nid=0x672b in Object.wait() [0x00007f87cd2c2000]
   java.lang.Thread.State: TIMED_WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
        - locked <0x00000000b422d1e8> (a java.lang.ref.ReferenceQueue$Lock)
        at com.mysql.jdbc.AbandonedConnectionCleanupThread.run(AbandonedConnectionCleanupThread.java:43)

"DestroyJavaVM" #30 prio=5 os_prio=0 tid=0x00007f87e0008800 nid=0x670b waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"http-nio-8081-AsyncTimeout" #28 daemon prio=5 os_prio=0 tid=0x00007f87e016e800 nid=0x6727 waiting on condition [0x00007f87b94cf000]
   java.lang.Thread.State: TIMED_WAITING (sleeping)
        at java.lang.Thread.sleep(Native Method)
        at org.apache.coyote.AbstractProtocol$AsyncTimeout.run(AbstractProtocol.java:1211)
        at java.lang.Thread.run(Thread.java:745)

"http-nio-8081-Acceptor-0" #27 daemon prio=5 os_prio=0 tid=0x00007f87e0166000 nid=0x6726 runnable [0x00007f87b95d0000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.ServerSocketChannelImpl.accept0(Native Method)
        at sun.nio.ch.ServerSocketChannelImpl.accept(ServerSocketChannelImpl.java:422)
        at sun.nio.ch.ServerSocketChannelImpl.accept(ServerSocketChannelImpl.java:250)
        - locked <0x00000000b410d480> (a java.lang.Object)
        at org.apache.tomcat.util.net.NioEndpoint$Acceptor.run(NioEndpoint.java:455)
        at java.lang.Thread.run(Thread.java:745)

"http-nio-8081-ClientPoller-0" #26 daemon prio=5 os_prio=0 tid=0x00007f87e0292800 nid=0x6725 runnable [0x00007f87b96d1000]
   java.lang.Thread.State: RUNNABLE
        at sun.nio.ch.EPollArrayWrapper.epollWait(Native Method)
        at sun.nio.ch.EPollArrayWrapper.poll(EPollArrayWrapper.java:269)
        at sun.nio.ch.EPollSelectorImpl.doSelect(EPollSelectorImpl.java:93)
        at sun.nio.ch.SelectorImpl.lockAndDoSelect(SelectorImpl.java:86)
        - locked <0x00000000b410d6c0> (a sun.nio.ch.Util$2)
        - locked <0x00000000b410d6b0> (a java.util.Collections$UnmodifiableSet)
        - locked <0x00000000b410d668> (a sun.nio.ch.EPollSelectorImpl)
        at sun.nio.ch.SelectorImpl.select(SelectorImpl.java:97)
        at org.apache.tomcat.util.net.NioEndpoint$Poller.run(NioEndpoint.java:793)
        at java.lang.Thread.run(Thread.java:745)

"http-nio-8081-exec-10" #25 daemon prio=5 os_prio=0 tid=0x00007f87e028c000 nid=0x6724 waiting on condition [0x00007f87b97d2000]
   java.lang.Thread.State: WAITING (parking)
        at sun.misc.Unsafe.park(Native Method)
        - parking to wait for  <0x00000000b410d898> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
        at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)
        at java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject.await(AbstractQueuedSynchronizer.java:2039)
        at java.util.concurrent.LinkedBlockingQueue.take(LinkedBlockingQueue.java:442)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:103)
        at org.apache.tomcat.util.threads.TaskQueue.take(TaskQueue.java:31)
        at java.util.concurrent.ThreadPoolExecutor.getTask(ThreadPoolExecutor.java:1067)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1127)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Thread.java:745)


~~~



### dump文件中描述的线程状态

+ runnable：运行中状态，在虚拟机内部执行，可能已经获取到了锁，可以观察是否有locked字样。
+ blocked：被阻塞并等待锁的释放。
+ wating：处于等待状态，等待特定的操作被唤醒，一般停留在park(), wait(), sleep(),join() 等语句里。
+ time_wating：有时限的等待另一个线程的特定操作。
+ terminated：线程已经退出



### 进程区域的划分

+ 进入区（Entry Set）：等待获取对象锁，一旦对象锁释放，立即参与竞争。
+ 拥有区（The Owner）：已经获取到锁。
+ 等待区（Wait Set）：表示线程通过wait方法释放了对象锁，并在等待区等待被唤醒。



### 方法调用修饰

+ locked: 成功获取锁
+ waiting to lock：还未获取到锁，在进入去等待；
+ waiting on：获取到锁之后，又释放锁，在等待区等待；
+ parking to wait for：等待许可证； （参考LockSupport.park和unpark操作）



### 结尾

有了这些知识之后我们再看前面的Dump文件就非常清楚了，清楚的描述了线程当前所处的状态以及获取到的锁的信息，例如：

`“http-nio-8081-exec-2” #17 daemon prio=5 os_prio=0 tid=0x00007f87e0685800 nid=0x671c waiting on condition [0x00007f87cc5bd000]
java.lang.Thread.State: WAITING (parking)
at sun.misc.Unsafe.park(Native Method)`

`parking to wait for <0x00000000b410d898> (a java.util.concurrent.locks.AbstractQueuedSynchronizer$ConditionObject)
at java.util.concurrent.locks.LockSupport.park(LockSupport.java:175)`

名称为`‘http-nio-8081-exec-2’`的线程当前正处于等待状态，等待其他线程释放许可证。（请先了解`LockSupport`的`park`和`unpark`操作）

`“http-nio-8081-AsyncTimeout” #28 daemon prio=5 os_prio=0 tid=0x00007f87e016e800 nid=0x6727 waiting on condition [0x00007f87b94cf000]
java.lang.Thread.State: TIMED_WAITING (sleeping)
at java.lang.Thread.sleep(Native Method)`

名称为`‘http-nio-8081-AsyncTimeout’`的线程当前处于等待状态，经过一个特定的休眠时间之后将自动唤醒。





