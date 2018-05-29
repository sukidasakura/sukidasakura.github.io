## Spark插拨式资源管理
Spark支持Yarn, Mesos, Standalone三种集群部署模式，它们的共同点：  
Master服务(Yarn ResourceManager,Mesos master,Spark standalone)来决定 
哪些应用可以运行以及在哪什么时候运行，Slave服务(Yarn NodeManger)运行在每个节点上，  
节点上实际运行着Executor进程，此外还监控着它们的运行状态以及资源的消耗。

## Spark On Yarn的优势
1. Spark支持资源动态共享，运行于Yarn的框架都共享一个集中配置好的资源池
2. 可以很方便的利用Yarn的资源调度特性来做分类，隔离以及优先级控制负载，拥有更灵活的调度策略
3. Yarn可以自由地选择executor数量
4. Yarn是唯一支持Spark安全的集群管理器，使用Yarn，Spark可以运行于Kerberized Hadoop之上，在它们进程之间进行安全认证 
 
## Yarn-cluster VS Yarn-client
当在Spark On Yarn模式下，每个Spark Executor作为一个Yarn container在运行，  
同时支持多个任务在同一个container中运行，极大地节省了任务的启动时间

## Appliaction Master
为了更好的理解这两种模式的区别先了解下Yarn的Application Master概念。
在Yarn中，每个application都有一个Application Master进程，它是Appliaction启动的第一个容器，  
它负责从ResourceManager中申请资源，分配资源，同时通知NodeManager来为Application启动container，Application Master避免了需要一个活动的client来维持，启动Applicatin的client可以随时退出，而由Yarn管理的进程继续在集群中运行。
 
## Yarn-cluster
在Yarn-cluster模式下，driver运行在Appliaction Master上，Appliaction Master进程同时负责驱动Application和从Yarn中申请资源，该进程运行在Yarn container内，所以启动Application Master的client可以立即关闭而不必持续到Application的生命周期，下图是yarn-cluster模式