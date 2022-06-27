# Sprak

## 概述

### 什么是Spark

Spark 是一种基于内存的快速、通用、可扩展的大数据分析计算引擎。

### Spark and Hadoop

首先从时间节点上来看:

+ Hadoop
  + 2006 年 1 月，Doug Cutting 加入Yahoo，领导Hadoop 的开发
  + 2008 年 1 月，Hadoop 成为 Apache 顶级项目
  + 2011 年 1.0 正式发布
  + 2012 年 3 月稳定版发布
  + 2013 年 10 月发布 2.X (Yarn)版本

+ Spark
  + 2009 年，Spark 诞生于伯克利大学的AMPLab 实验室
  + 2010 年，伯克利大学正式开源了 Spark 项目
  + 2013 年 6 月，Spark 成为了 Apache 基金会下的项目
  + 2014 年 2 月，Spark 以飞快的速度成为了 Apache 的顶级项目
  + 2015 年至今，Spark 变得愈发火爆，大量的国内公司开始重点部署或者使用 Spark

然后我们再从功能上来看:

+ Hadoop
  + Hadoop 是由 java 语言编写的，在分布式服务器集群上存储海量数据并运行分布式分析应用的开源框架
  + 作为 Hadoop 分布式文件系统，HDFS 处于 Hadoop 生态圈的最下层，存储着所有的数据， 支持着 Hadoop 的所有服务。 它的理论基础源于 Google 的TheGoogleFileSystem 这篇论文，它是GFS 的开源实现。
  + MapReduce 是一种编程模型，Hadoop 根据 Google 的 MapReduce 论文将其实现， 作为 Hadoop 的分布式计算模型，是 Hadoop 的核心。基于这个框架，分布式并行程序的编写变得异常简单。综合了 HDFS 的分布式存储和 MapReduce 的分布式计算，Hadoop 在处理海量数据时，性能横向扩展变得非常容易。
  + HBase 是对 Google 的 Bigtable 的开源实现，但又和 Bigtable 存在许多不同之处。HBase 是一个基于HDFS 的分布式数据库，擅长实时地随机读/写超大规模数据集。它也是 Hadoop 非常重要的组件。

+ Spark
  + Spark 是一种由 Scala 语言开发的快速、通用、可扩展的大数据分析引擎
  + Spark Core 中提供了 Spark 最基础与最核心的功能
  + Spark SQL 是Spark 用来操作结构化数据的组件。通过 Spark SQL，用户可以使用SQL 或者 Apache Hive 版本的 SQL 方言（HQL）来查询数据。
  + Spark Streaming 是 Spark 平台上针对实时数据进行流式计算的组件，提供了丰富的处理数据流的API。

由上面的信息可以获知，Spark 出现的时间相对较晚，并且主要功能主要是用于数据计算， 所以其实 Spark 一直被认为是Hadoop 框架的升级版。

### Spark or Hadoop

Hadoop 的 MR 框架和Spark 框架都是数据处理框架，那么我们在使用时如何选择呢？

+ Hadoop MapReduce 由于其设计初衷并不是为了满足循环迭代式数据流处理，因此在多并行运行的数据可复用场景（如：机器学习、图挖掘算法、交互式数据挖掘算法）中存在诸多计算效率等问题。所以 Spark 应运而生，Spark 就是在传统的MapReduce 计算框架的基础上，利用其计算过程的优化，从而大大加快了数据分析、挖掘的运行和读写速度，并将计算单元缩小到更适合并行计算和重复使用的RDD 计算模型。
+ 机器学习中 ALS、凸优化梯度下降等。这些都需要基于数据集或者数据集的衍生数据反复查询反复操作。MR 这种模式不太合适，即使多 MR 串行处理，性能和时间也是一个问题。数据的共享依赖于磁盘。另外一种是交互式数据挖掘，MR 显然不擅长。而Spark 所基于的 scala 语言恰恰擅长函数的处理。
+ Spark 是一个分布式数据快速分析项目。它的核心技术是弹性分布式数据集（Resilient Distributed Datasets），提供了比MapReduce 丰富的模型，可以快速在内存中对数据集进行多次迭代，来支持复杂的数据挖掘算法和图形计算算法。
+ Spark 和Hadoop 的根本差异是多个作业之间的数据通信问题 : Spark 多个作业之间数据通信是基于内存，而 Hadoop 是基于磁盘。
+ Spark Task 的启动时间快。Spark 采用 fork 线程的方式，而 Hadoop 采用创建新的进程的方式。
+ Spark 只有在 shuffle 的时候将数据写入磁盘，而 Hadoop 中多个 MR 作业之间的数据交互都要依赖于磁盘交互
+ Spark 的缓存机制比HDFS 的缓存机制高效。

​        经过上面的比较，我们可以看出在绝大多数的数据计算场景中，Spark 确实会比 MapReduce 更有优势。但是Spark 是基于内存的，所以在实际的生产环境中，由于内存的限制，可能会由于内存资源不够导致 Job 执行失败，此时，MapReduce 其实是一个更好的选择，所以 **Spark 并不能完全替代 MR。**

### Spark 核心模块

+ Spark Core：提供了 Spark 最基础与最核心的功能，Spark 其他的功能如：Spark SQL， Spark Streaming，GraphX, MLlib 都是在 Spark Core 的基础上进行扩展的

+ Spark SQL：Spark SQL 是Spark 用来操作结构化数据的组件。通过 Spark SQL，用户可以使用 SQL或者Apache Hive 版本的 SQL 方言（HQL）来查询数据。 

+ Spark Streaming：是 Spark 平台上针对实时数据进行流式计算的组件，提供了丰富的处理数据流的API。

+ Spark MLlib：MLlib 是 Spark 提供的一个机器学习算法库。MLlib 不仅提供了模型评估、数据导入等额外的功能，还提供了一些更底层的机器学习原语。
+ Spark GraphX：GraphX 是 Spark 面向图计算提供的框架与算法库。



## 快速上手

### 创建Maven项目

### 增加Scala插件

### WordCount

~~~scala
// 创建 Spark 运行配置对象
val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")

// 创建 Spark 上下文环境对象（连接对象）
val sc : SparkContext = new SparkContext(sparkConf)

// 读取文件数据
val fileRDD: RDD[String] = sc.textFile("input/word.txt")

// 将文件中的数据进行分词
val wordRDD: RDD[String] = fileRDD.flatMap( _.split(" ") )

// 转换数据结构 word => (word, 1)
val word2OneRDD: RDD[(String, Int)] = wordRDD.map((_,1))

// 将转换结构后的数据按照相同的单词进行分组聚合
val word2CountRDD: RDD[(String, Int)] = word2OneRDD.reduceByKey(_+_)

// 将数据聚合结果采集到内存中
val word2Count: Array[(String, Int)] = word2CountRDD.collect()

// 打印结果
word2Count.foreach(println)

//关闭 Spark 连接
sc.stop()

~~~



## Spark 运行环境

### Local模式

所谓的Local 模式，就是不需要其他任何节点资源就可以在本地执行 Spark 代码的环境，一般用于教学，调试，演示等， 

### Standalone 模式

​		local 本地模式毕竟只是用来进行练习演示的，真实工作中还是要将应用提交到对应的集群中去执行，这里只使用 Spark 自身节点运行的集群模式，也就是我们所谓的独立部署（Standalone）模式

### Yarn 模式

​		独立部署（Standalone）模式由 Spark 自身提供计算资源，无需其他框架提供资源。这种方式降低了和其他第三方资源框架的耦合性，独立性非常强。但是你也要记住**，Spark 主要是计算框架**，而不是资源调度框架，所以本身提供的资源调度并不是它的强项，所以还是和其他专业的资源调度框架集成会更靠谱一些。其实是因为在国内工作中，Yarn 使用的非常多

### K8S & Mesos 模式

​		Mesos 是Apache 下的开源分布式资源管理框架，它被称为是分布式系统的内核,在Twitter 得到广泛使用,管理着 Twitter 超过 30,0000 台服务器上的应用部署，但是在国内，依然使用着传统的Hadoop 大数据框架，所以国内使用 Mesos 框架的并不多，但是原理其实都差不多，这里我们就不做过多讲解了。

​		容器化部署是目前业界很流行的一项技术，基于Docker 镜像运行能够让用户更加方便地对应用进行管理和运维。

### Windows 模式

​		Spark 非常暖心地提供了可以在windows 系统下启动本地集群的方式，这样，在不使用虚拟机的情况下，也能学习 Spark 的基本使用

### 部署模式对比

![image-20220610125327248](img/image-20220610125327248.png)



## Spark Core 运行架构

### 运行架构

​		Spark 框架的核心是一个计算引擎，整体来说，它采用了标准 master-slave 的结构。如下图所示，它展示了一个 Spark 执行时的基本结构。图形中的Driver 表示 master，负责管理整个集群中的作业任务调度。图形中的Executor 则是 slave，负责实际执行任务。

![image-20220610125449016](img/image-20220610125449016.png)

### 核心组件

#### Driver

Spark 驱动器节点，用于执行 Spark 任务中的 main 方法，负责实际代码的执行工作。 

Driver 在Spark 作业执行时主要负责：

+ 将用户程序转化为作业（job）
+ 在 Executor 之间调度任务(task)
+ 跟踪Executor 的执行情况
+ 通过UI 展示查询运行情况

实际上，我们无法准确地描述Driver 的定义，因为在整个的编程过程中没有看到任何有关Driver 的字眼。所以简单理解，所谓的 Driver 就是驱使整个应用运行起来的程序，也称之为Driver 类。

#### Executor

​		Spark Executor 是集群中工作节点（Worker）中的一个 JVM 进程，负责在 Spark 作业中运行具体任务（Task），任务彼此之间相互独立。Spark 应用启动时，Executor 节点被同时启动，并且始终伴随着整个 Spark 应用的生命周期而存在。如果有Executor 节点发生了故障或崩溃，Spark 应用也可以继续执行，会将出错节点上的任务调度到其他 Executor 节点上继续运行。

Executor 有两个核心功能： 

+ 负责运行组成 Spark 应用的任务，并将结果返回给驱动器进程
+ 它们通过自身的块管理器（Block Manager）为用户程序中要求缓存的 RDD 提供内存式存储。RDD 是直接缓存在 Executor 进程内的，因此任务可以在运行时充分利用缓存数据加速运算。

#### Master & Worker

​		Spark 集群的独立部署环境中，不需要依赖其他的资源调度框架，自身就实现了资源调度的功能，所以环境中还有其他两个核心组件：Master 和 Worker，

+ 这里的 Master 是一个进程，主要负责资源的调度和分配，并进行集群的监控等职责，
+ 类似于 Yarn 环境中的 RM, 而Worker 呢，也是进程，一个 Worker 运行在集群中的一台服务器上，由 Master 分配资源对数据进行并行的处理和计算，类似于 Yarn 环境中 NM。

#### ApplicationMaster

Hadoop 用户向 YARN 集群提交应用程序时,提交程序中应该包含ApplicationMaster，用于向资源调度器申请执行任务的资源容器 Container，运行用户自己的程序任务 job，监控整个任务的执行，跟踪整个任务的状态，处理任务失败等异常情况。

说的简单点就是，ResourceManager（资源）和Driver（计算）之间的解耦合靠的就是ApplicationMaster。



### 核心概念

#### Executor 与 Core

​		Spark Executor 是集群中运行在工作节点（Worker）中的一个 JVM 进程，是整个集群中的专门用于计算的节点。在提交应用中，可以提供参数指定计算节点的个数，以及对应的资源。这里的资源一般指的是工作节点 Executor 的内存大小和使用的虚拟 CPU 核（Core）数量。

![image-20220610125828268](img/image-20220610125828268.png)

#### 并行度

​		在分布式计算框架中一般都是多个任务同时执行，由于任务分布在不同的计算节点进行计算，所以能够真正地实现多任务并行执行，记住，这里是并行，而不是并发。这里我们将整个集群并行执行任务的数量称之为并行度。

#### 有向无环图

​		这里所谓的有向无环图，并不是真正意义的图形，而是由 Spark 程序直接映射成的数据流的高级抽象模型。简单理解就是将整个程序计算的执行过程用图形表示出来,这样更直观， 更便于理解，可以用于表示程序的拓扑结构。

​		DAG（Directed Acyclic Graph）有向无环图是由点和线组成的拓扑图形，该图形具有方向，不会闭环。

### 提交流程

​		所谓的提交流程，其实就是我们开发人员根据需求写的应用程序通过 Spark 客户端提交给 Spark 运行环境执行计算的流程。在不同的部署环境中，这个提交过程基本相同，但是又有细微的区别，我们这里不进行详细的比较，但是因为国内工作中，将 Spark 引用部署到Yarn 环境中会更多一些，所以本课程中的提交流程是基于 Yarn 环境的。

![image-20220610130101140](img/image-20220610130101140.png)

#### Yarn Client 模式

Client 模式将用于监控和调度的Driver 模块在客户端执行，而不是在 Yarn 中，所以一般用于测试。

+ Driver 在任务提交的本地机器上运行
+ Driver 启动后会和ResourceManager 通讯申请启动ApplicationMaster
+ ResourceManager 分配 container，在合适的NodeManager 上启动ApplicationMaster，负责向ResourceManager 申请 Executor 内存
+ ResourceManager 接到 ApplicationMaster 的资源申请后会分配 container，然后ApplicationMaster 在资源分配指定的NodeManager 上启动 Executor 进程
+ Executor 进程启动后会向Driver 反向注册，Executor 全部注册完成后Driver 开始执行main 函数
+ 之后执行到 Action 算子时，触发一个 Job，并根据宽依赖开始划分 stage，每个stage 生成对应的TaskSet，之后将 task 分发到各个Executor 上执行。

#### Yarn Cluster 模式

Cluster 模式将用于监控和调度的 Driver 模块启动在Yarn 集群资源中执行。一般应用于实际生产环境。

+ 在 YARN Cluster 模式下，任务提交后会和ResourceManager 通讯申请启动ApplicationMaster，
+ 随后ResourceManager 分配 container，在合适的 NodeManager 上启动 ApplicationMaster，此时的 ApplicationMaster 就是Driver。
+ Driver 启动后向 ResourceManager 申请Executor 内存，ResourceManager 接到ApplicationMaster 的资源申请后会分配container，然后在合适的NodeManager 上启动Executor 进程
+ Executor 进程启动后会向Driver 反向注册，Executor 全部注册完成后Driver 开始执行main 函数，
+ 之后执行到 Action 算子时，触发一个 Job，并根据宽依赖开始划分 stage，每个stage 生成对应的TaskSet，之后将 task 分发到各个Executor 上执行。

###  核心编程

Spark 计算框架为了能够进行高并发和高吞吐的数据处理，封装了三大数据结构，用于处理不同的应用场景。三大数据结构分别是：

+ RDD : 弹性分布式数据集
+ 累加器：分布式共享只写变量
+ 广播变量：分布式共享只读变量

 #### RDD

##### 概念

​		RDD（Resilient Distributed Dataset）叫做弹性分布式数据集，是 Spark 中最基本的数据处理模型。代码中是一个抽象类，它代表一个弹性的、不可变、可分区、里面的元素可并行计算的集合。

+ 弹性
  + 存储的弹性：内存与磁盘的自动切换；
  + 容错的弹性：数据丢失可以自动恢复；
  + 计算的弹性：计算出错重试机制；
  + 分片的弹性：可根据需要重新分片。

+ 分布式：数据存储在大数据集群不同节点上
+ 数据集：RDD 封装了计算逻辑，并不保存数据
+ 数据抽象：RDD 是一个抽象类，需要子类具体实现
+ 不可变：RDD 封装了计算逻辑，是不可以改变的，想要改变，只能产生新的RDD，在新的RDD 里面封装计算逻辑
+ 可分区、并行计算



#### 累加器

##### 实现原理

​		累加器用来把Executor 端变量信息聚合到Driver 端。在Driver 程序中定义的变量，在Executor 端的每个Task 都会得到这个变量的一份新的副本，每个 task 更新这些副本的值后， 传回Driver 端进行 merge。

#### 广播变量

##### 实现原理

​		广播变量用来高效分发较大的对象。向所有工作节点发送一个较大的只读值，以供一个或多个 Spark 操作使用。比如，如果你的应用需要向所有节点发送一个较大的只读查询表， 广播变量用起来都很顺手。在多个并行操作中使用同一个变量，但是 Spark 会为每个任务分别发送。





## Spark Sql

### 概述

#### 概念

​		Spark SQL 是Spark 用于结构化数据(structured data)处理的 Spark 模块。

#### Hive and SparkSQL

​		SparkSQL 的前身是 Shark，给熟悉RDBMS 但又不理解 MapReduce 的技术人员提供快速上手的工具。

​		Hive 是早期唯一运行在Hadoop 上的SQL-on-Hadoop 工具。但是 MapReduce 计算过程中大量的中间磁盘落地过程消耗了大量的 I/O，降低的运行效率，为了提高 SQL-on-Hadoop 的效率，大量的SQL-on-Hadoop 工具开始产生，其中表现较为突出的是：

+ Drill
+ Impala
+ Shark

​        其中 Shark 是伯克利实验室 Spark 生态环境的组件之一，是基于Hive 所开发的工具，它修改了内存管理、物理计划、执行三个模块，并使之能运行在 Spark 引擎上。Shark 的出现，使得SQL-on-Hadoop 的性能比Hive 有了 10-100 倍的提高。

​		但是，随着Spark 的发展，对于野心勃勃的Spark 团队来说，**Shark 对于 Hive 的太多依赖（如采用 Hive 的语法解析器、查询优化器等等），制约了 Spark 的One Stack Rule Them All 的既定方针，制约了 Spark 各个组件的相互集成，所以提出了 SparkSQL 项目。**SparkSQL 抛弃原有 Shark 的代码，汲取了 Shark 的一些优点，如内存列存储（In-Memory Columnar Storage）、Hive 兼容性等，重新开发了SparkSQL 代码；由于摆脱了对Hive 的依赖性，SparkSQL无论在数据兼容、性能优化、组件扩展方面都得到了极大的方便，真可谓“退一步，海阔天空”。2014 年 6 月 1 日 Shark 项目和 SparkSQL 项目的主持人Reynold Xin 宣布：停止对 Shark 的开发，团队将所有资源放SparkSQL 项目上，至此，Shark 的发展画上了句话，**但也因此发展出两个支线：SparkSQL 和 Hive on Spark**。

+ 数据兼容方面 SparkSQL 不但兼容Hive，还可以从RDD、parquet 文件、JSON 文件中获取数据，未来版本甚至支持获取RDBMS 数据以及 cassandra 等NOSQL 数据；
+ 性能优化方面 除了采取 In-Memory Columnar Storage、byte-code generation 等优化技术外、将会引进Cost Model 对查询进行动态评估、获取最佳物理计划等等；
+ 组件扩展方面 无论是 SQL 的语法解析器、分析器还是优化器都可以重新定义，进行扩展。

​        其中 SparkSQL 作为 Spark 生态的一员继续发展，而不再受限于 Hive，只是兼容 Hive；而Hive on Spark 是一个Hive 的发展计划，该计划将 Spark 作为Hive 的底层引擎之一，也就是说，Hive 将不再受限于一个引擎，可以采用 Map-Reduce、Tez、Spark 等引擎。

​		对于开发人员来讲，SparkSQL 可以简化RDD 的开发，提高开发效率，且执行效率非常快，所以实际工作中，基本上采用的就是 SparkSQL。Spark SQL 为了简化RDD 的开发， 提高开发效率，提供了 2 个编程抽象，类似Spark Core 中的RDD

+ DataFrame
+ DataSet



#### SparkSql的特点

+ 易整合：无缝的整合了 SQL 查询和 Spark 编程
+ 统一的数据访问：使用相同的方式连接不同的数据源
+ 兼容 Hive：在已有的仓库上直接运行 SQL 或者 HiveQL
+ 标准数据连接：通过 JDBC 或者 ODBC 来连接



#### DataFrame 是什么

​		在 Spark 中，DataFrame 是一种以 RDD 为基础的分布式数据集，类似于传统数据库中的二维表格。DataFrame 与 RDD 的主要区别在于，前者带有 schema 元信息，即 **DataFrame 所表示的二维表数据集的每一列都带有名称和类型。这使得 Spark SQL 得以洞察更多的结构信息**，从而对藏于 DataFrame 背后的数据源以及作用于 DataFrame 之上的变换进行了针对性的优化，最终达到大幅提升运行时效率的目标。反观 RDD，由于无从得知所存数据元素的具体内部结构，Spark Core 只能在 stage 层面进行简单、通用的流水线优化。

​		同时，与Hive 类似，DataFrame 也支持嵌套数据类型（struct、array 和 map）。从 API 易用性的角度上看，DataFrame API 提供的是一套高层的关系操作，比函数式的 RDD API 要更加友好，门槛更低。



#### DataSet 是什么

​		DataSet 是分布式数据集合。DataSet 是Spark 1.6 中添加的一个新抽象，是DataFrame的一个扩展。它提供了RDD 的优势（强类型，使用强大的 lambda 函数的能力）以及Spark SQL 优化执行引擎的优点。DataSet 也可以使用功能性的转换（操作 map，flatMap，filter等等）。

+ DataSet 是DataFrame API 的一个扩展，是SparkSQL 最新的数据抽象
+ 用户友好的 API 风格，既具有类型安全检查也具有DataFrame 的查询优化特性；
+ 用样例类来对DataSet 中定义数据的结构信息，样例类中每个属性的名称直接映射到

DataSet 中的字段名称；

+ DataSet 是强类型的。比如可以有 DataSet[Car]，DataSet[Person]。
+ DataFrame 是DataSet 的特列，DataFrame=DataSet[Row] ，所以可以通过 as 方法将DataFrame 转换为DataSet。Row 是一个类型，跟 Car、Person 这些的类型一样，所有的表结构信息都用 Row 来表示。获取数据时需要指定顺序



### 核心编程

#### 注意

​		本课件重点学习如何使用 Spark SQL 所提供的 DataFrame 和DataSet 模型进行编程.， 以及了解它们之间的关系和转换，关于具体的SQL 书写不是我们的重点。



#### 新的起点

​		Spark Core 中，如果想要执行应用程序，需要首先构建上下文环境对象 SparkContext， Spark SQL 其实可以理解为对 Spark Core 的一种封装，不仅仅在模型上进行了封装，上下文环境对象也进行了封装。

​		在老的版本中，SparkSQL 提供两种 SQL 查询起始点：一个叫 SQLContext，用于 Spark自己提供的SQL 查询；一个叫HiveContext，用于连接 Hive 的查询。

 ![img](img/clip_image002-16548410746442.jpg)


​		SparkSession 是 Spark 最新的 SQL 查询起始点，实质上是 SQLContext 和HiveContext 的组合，所以在 SQLContex 和HiveContext 上可用的API 在 SparkSession 上同样是可以使用的。SparkSession 内部封装了 SparkContext，所以计算实际上是由 sparkContext 完成的。当我们使用 spark-shell 的时候, spark 框架会自动的创建一个名称叫做 spark 的SparkSession 对象, 就像我们以前可以自动获取到一个 sc 来表示 SparkContext 对象一样

#### DataFrame

​		Spark SQL 的DataFrame API 允许我们使用 DataFrame 而不用必须去注册临时表或者生成 SQL 表达式。DataFrame API 既有 transformation 操作也有 action 操作。



##### 创建 DataFrame

在 Spark SQL 中 SparkSession 是创建DataFrame 和执行 SQL 的入口，创建 DataFrame有三种方式：

1. 通过Spark 的数据源进行创建；
2. 从一个存在的RDD 进行转换；
3. 还可以从HiveTable 进行查询返回。

##### SQL 语法

##### DSL 语法

​		DataFrame 提供一个特定领域语言(domain-specific language, DSL)去管理结构化的数据。可以在 Scala, Java, Python 和 R 中使用 DSL，使用 DSL 语法风格不必去创建临时视图了



##### RDD 转换为 DataFrame

​		在 IDEA 中开发程序时，如果需要RDD 与DF 或者DS 之间互相操作，那么需要引入 import spark.implicits._这里的 spark 不是Scala 中的包名，而是创建的 sparkSession 对象的变量名称，所以必须先创建 SparkSession 对象再导入。这里的 spark 对象不能使用var 声明，因为 Scala 只支持val 修饰的对象的引入。

##### DataFrame 转换为 RDD

​		DataFrame 其实就是对RDD 的封装，所以可以直接获取内部的RDD

####  创建 DataSet

#### DataFrame 和 DataSet 转换

​		DataFrame 其实是DataSet 的特例，所以它们之间是可以互相转换的。

#### RDD、DataFrame、DataSet 三者的关系

​		在 SparkSQL 中 Spark 为我们提供了两个新的抽象，分别是 DataFrame 和 DataSet。他们和 RDD 有什么区别呢？首先从版本的产生上来看：

+ Spark1.0 => RDD
+ Spark1.3 => DataFrame
+ Spark1.6 => Dataset

​    如果同样的数据都给到这三个数据结构，他们分别计算之后，都会给出相同的结果。不同是的他们的执行效率和执行方式。**在后期的 Spark 版本中，DataSet 有可能会逐步取代RDD和 DataFrame 成为唯一的API 接口**

##### 共性

+ RDD、DataFrame、DataSet 全都是 spark 平台下的分布式弹性数据集，为处理超大型数据提供便利;
+ 三者都有惰性机制，在进行创建、转换，如 map 方法时，不会立即执行，只有在遇到Action 如 foreach 时，三者才会开始遍历运算;
+ 三者有许多共同的函数，如 filter，排序等;
+  在对DataFrame 和Dataset 进行操作许多操作都需要这个包:import spark.implicits._（在创建好 SparkSession 对象后尽量直接导入）
+ 三者都会根据 Spark 的内存情况自动缓存运算，这样即使数据量很大，也不用担心会内存溢出
+ 三者都有 partition 的概念
+ DataFrame 和DataSet 均可使用模式匹配获取各个字段的值和类型

##### 区别

1. RDD
   1. RDD 一般和 spark mllib 同时使用
   2. RDD 不支持 sparksql 操作
2. DataFrame
   1. 与 RDD 和 Dataset 不同，DataFrame 每一行的类型固定为Row，每一列的值没法直接访问，只有通过解析才能获取各个字段的值
   2. DataFrame 与DataSet 一般不与 spark mllib 同时使用
   3. DataFrame 与DataSet 均支持 SparkSQL 的操作，比如 select，groupby 之类，还能注册临时表/视窗，进行 sql 语句操作
   4. DataFrame 与DataSet 支持一些特别方便的保存方式，比如保存成 csv，可以带上表头，这样每一列的字段名一目了然(后面专门讲解)
3. DataSet
   1. Dataset 和DataFrame 拥有完全相同的成员函数，区别只是每一行的数据类型不同
   2. DataFrame 其实就是DataSet 的一个特例 type DataFrame = Dataset[Row]
   3. DataFrame 也可以叫Dataset[Row],每一行的类型是 Row，不解析，每一行究竟有哪些字段，各个字段又是什么类型都无从得知，只能用上面提到的 getAS 方法或者共性中的第七条提到的模式匹配拿出特定字段。而Dataset 中，每一行是什么类型是不一定的，在自定义了 case class 之后可以很自由的获得每一行的信息

#### IDEA 开发SparkSQL

##### 添加依赖

~~~xml
<dependency>
    <groupId>org.apache.spark</groupId>
    <artifactId>spark-sql_2.12</artifactId>
    <version>3.0.0</version>
</dependency>

~~~

##### 代码实现

~~~scala
object SparkSQL01_Demo {
    def main(args: Array[String]): Unit = {
        //创建上下文环境配置对象
        val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkSQL01_Demo")

        //创建 SparkSession 对象
        val spark: SparkSession = SparkSession.builder().config(conf).getOrCreate()
        //RDD=>DataFrame=>DataSet 转换需要引入隐式转换规则，否则无法转换
        //spark 不是包名，是上下文环境对象名
        import spark.implicits._

        //读取 json 文件 创建 DataFrame {"username": "lisi","age": 18} val df: DataFrame = spark.read.json("input/test.json")
        //df.show()

        //SQL 风格语法
        df.createOrReplaceTempView("user")
        //spark.sql("select avg(age) from user").show

        //DSL 风格语法
        //df.select("username","age").show()

        //*****RDD=>DataFrame=>DataSet*****
        //RDD
        val rdd1: RDD[(Int, String, Int)] = spark.sparkContext
        						.makeRDD(List((1,"zhangsan",30),(2,"lisi",28),(3,"wangwu", 20)))

        //DataFrame
        val df1: DataFrame = rdd1.toDF("id","name","age")
        //df1.show()

        //DateSet
        val ds1: Dataset[User] = df1.as[User]
        //ds1.show()

        //*****DataSet=>DataFrame=>RDD*****
        //DataFrame
        val df2: DataFrame = ds1.toDF()

        //RDD 返回的 RDD 类型为 Row，里面提供的 getXXX 方法可以获取字段值，类似 jdbc 处理结果集， 但是索引从 0 开始
        val rdd2: RDD[Row] = df2.rdd
        //rdd2.foreach(a=>println(a.getString(1)))

        //*****RDD=>DataSet***** rdd1.map{
        case (id,name,age)=>User(id,name,age)
    }.toDS()

        //*****DataSet=>=>RDD***** ds1.rdd

        //释放资源spark.stop()
	}
}
case class User(id:Int,name:String,age:Int)

~~~





## Spark Streaming

### 概述

#### 概念

​		Spark 流使得构建可扩展的容错流应用程序变得更加容易。

​		Spark Streaming 用于流式数据的处理。Spark Streaming 支持的数据输入源很多，例如：Kafka、 Flume、Twitter、ZeroMQ 和简单的 TCP 套接字等等。数据输入后可以用 Spark 的高度抽象原语如：map、reduce、join、window 等进行运算。而结果也能保存在很多地方，如 HDFS，数据库等。

​		和 Spark 基于 RDD 的概念很相似，Spark Streaming 使用离散化流(discretized stream)作为抽象表示，叫作DStream。DStream 是随时间推移而收到的数据的序列。在内部，每个时间区间收到的数据都作为 RDD 存在，而 DStream 是由这些RDD 所组成的序列(因此得名“离散化”)。所以简单来将，DStream 就是对 RDD 在实时数据处理场景的一种封装。

#### 特点

1. 易用
2. 容错
3. 方便整合到Spark中

#### 架构图

1. 整体架构图

<img src="img/image-20220610143604296.png" alt="image-20220610143604296" style="zoom:150%;" />

2. Strraming 架构图

<img src="img/image-20220610143630385.png" alt="image-20220610143630385" style="zoom:150%;" />

### 案例实操

1. 添加依赖
2. 编写代码

~~~~scala
object StreamWordCount {

def main(args: Array[String]): Unit = {

    //1.初始化 Spark 配置信息
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamWordCount")

    //2.初始化 SparkStreamingContext
    val ssc = new StreamingContext(sparkConf, Seconds(3))

    //3.通过监控端口创建 DStream，读进来的数据为一行行
    val lineStreams = ssc.socketTextStream("linux1", 9999)

    //将每一行数据做切分，形成一个个单词
    val wordStreams = lineStreams.flatMap(_.split(" "))

    //将单词映射成元组（word,1）
    val wordAndOneStreams = wordStreams.map((_, 1))

    //将相同的单词次数做统计
    val wordAndCountStreams = wordAndOneStreams.reduceByKey(_+_)

    //打印wordAndCountStreams.print()

    //启动 SparkStreamingContext ssc.start() ssc.awaitTermination()
    }
}

~~~~

