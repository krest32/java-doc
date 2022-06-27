# GC

###  性能指标

1. 吞吐量：用户代码的事件占总运行时间的比例
2. 垃圾收集开销：吞吐量的补数
3. 暂停时间：工作线程暂停的时间
4. 收集频率：GC的发生频率
5. 内存占用：Java堆区所占内存的大小
6. 快速：一个兑现从诞生到被回收所经历的事件

#### 吞吐量

1. 注重吞吐量大，但是 STW 的时间会比较长，但是回收的频率会低
2. 适合做生产性的工作

#### 低延迟

1. 注重低延迟，就代表尽可能让 STW 的时间最短，但是回收的频率会高，吞吐量会低
2. 适合交互性的应用程序

#### 如今标准

在最大的吞吐量优先的情况下，尽可能降低停顿时间（G1），专注一个指标，尽可能提升另外一个指标的性能



### 使用

#### 查看默认的垃圾回收器

~~~bash
-XX:+PrintCommandLineFlags
或者 
jinfo -flag
jinfo 线程号 查看多有的java运行参数指令
~~~



#### 其他指令

~~~bash
-XX:+UseParallelGC
-XX:UseParaLLeOldGC (使用UseParallelGC，会默认配置ParalleOldGC)
-XX:ParallelGCThreads(设置收集线程) 默认为8，如果CPU核心>8-> 3+[5+cpuCount]/8
-XX:MaxGCPauseMillis 慎用，最大停顿时间，但是收集器会根据这个参数调整Java堆的大小
-XX:GCTimeRatio 垃圾收集时间占总时间的比例
-XX:+UseAdaptiveSizePolicy 自适应调解策略：设置吞吐量、停顿时间以后，让虚拟机自己完成调优工作
~~~



### 日志分析

常用参数

-XX:+PrintGC

-XX:+PrintGCDetails

-XX：+PrintGCTimeStamps 输出GC的时间戳

-XX:+PrintHeapAtGC GC前后打印堆信息

-Xloggc:../logs/gc.log 日志文件输出



### 日志分析工具

GCviewer 、 GCeasy（功能强大些）