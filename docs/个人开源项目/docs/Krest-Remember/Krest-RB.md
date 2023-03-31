# Krest-remember

## Raft 算法

### 概述

raft算法是分布式系统中的保持数据一致性的算法

### 数据的一致性

raft有三种角色：

+ leader：管理节点，负责告诉其他节点如何处理数据或者消息
+ follower：跟随节点，负责处理leader和candidate的请求
+ candidate：候选节点，用于选举，（不工作节点）

数据传输只能是Leader节点向Follower节点单向传输

### 状态转化

所有一致性算法都会涉及到状态机，而状态机保证系统从一个一致的状态开始，以相同的顺序执行一些列指令最终会达到另一个一致的状态。

其中集群的各节点的状态转化如下：

1. 所有节点初始状态都是Follower角色
2. 超时时间内没有收到Leader的请求则转换为Candidate进行选举
3. Candidate收到大多数节点的选票则转换为Leader；发现Leader或者收到更高任期的请求则转换为Follower
4. Leader在收到更高任期的请求后转换为Follower

### 任期

每个任期都由一次选举开始，若选举失败则这个任期内没有Leader；如果选举出了Leader则这个任期内有Leader负责集群状态管理。

### 领导人选举

1. 首先，刚开始所有结点都是follower的状态，为了避免同时去竞争选票
2. raft给每个结点分配随机超时时间，这样会有一个率先称为candidate然后去拉选票。
3. 如果收到了至少(N/2+1)个投票就将自己变成leader。
4. 如果此时收到了别的结点的心跳包，会判断别的结点的任期和此结点的任期，如果<别的结点的就将自己变成follower。
5. 如果同时有别的结点参与争抢，那么可能这一轮票数平局，都无法满足，且这个任期就跳过。因为每个结点都是随机超时，所以下一轮很大概率能选出主。





## Remember

### 系统角色

+ Leader 领导角色
+ Follower 从节点，负责同步 Leader 的数据
+ Candidate 候选者，可以参与到 Leader 选举

### 交互信息结构

| Code           | 含义                                             |
| -------------- | ------------------------------------------------ |
| Leader         | 当前集群内的Leader信息                           |
| term           | Leader 的任期                                    |
| tickets        | 当前Leader的选票信息                             |
| status         | 当前节点的状态 1. leader 2 follower 3. candidate |
| currentNode    | 当前节点的信息                                   |
| aliveFollowers | 存活节点的列表信息                               |



~~~json
{
    "leader": {
        "id": 1,
        "ip": "localhost",
        "port": "8001"
    },
    "term": 1,
    "tickets": 2,
    "status": 1,
    "currentNode": {
        "id": 1,
        "ip": "localhost",
        "port": "8001"
    },
    "aliveFollowers": [
        {
            "id": 1,
            "ip": "localhost",
            "port": "8001"
        },
        {
            "id": 2,
            "ip": "localhost",
            "port": "8002"
        },
        {
            "id": 3,
            "ip": "localhost",
            "port": "8003"
        },
        {
            "id": 4,
            "ip": "localhost",
            "port": "8004"
        },
        {
            "id": 5,
            "ip": "localhost",
            "port": "8005"
        }
    ]
}
~~~



### 工作流程

#### 初次启动

+ 初次启动，节点为Candidate
+ 执行定时任务，遍历所有的ConfigNode，找到集群中的Leader
+ 向Leader注册自己的信息
+ Leader 节点收到新的注册信息后，开始向集群同步Cluster信息

#### Leader 重新选举

+ Leader奔溃，follower节点进行反向探测，如果Leader存活，那么就进行重新注册
+ 如果Leader死亡，那么follower会转变为Candidate进行选举，然后向其他的节点请求投票的信息
+ 其他节点投票原则：
  + 请求投票的节点Id要小于当前节点
+ 一轮投票后，统计票数信息，如果票数大于存活节点的1/2，那么久会成为新的Leader
+ 然后开始广播信息
+ 如果存在多个Leader，那么票数相同的就当选为新的Leader，然后将自己置为follower
+ 如果同一届Leader，票数相同，那么比对节点id，较小的成为新的 Leader，较大的成为 Follower，
+ 然后Follower重新向Leader注册，
+ 最后，集群内只有一个Leader

#### 数据传输

+ follower 收到数据后，先同步给Leader
+ 然后Leader向所有的Follower传输，进行同步

