1）首先启动hadoop

① 在Master节点上进入hadoop安装目录下，执行sbin/start-dfs.sh

② 在Slave1节点上进入hadoop安装目录下，执行sbin/start-yarn.sh

③ 在Master节点上进入hadoop安装目录下，执行sbin/mr-jobhistory-daemon.sh start historyserver

④ 在Slave1节点上进入hadoop安装目录下，执行sbin/yarn-daemon.sh start proxyserver

在Master节点命令中输入jps，显示进程为NodeManager, JobhistoryServer, DataNode, NameNode

在Slave1节点中输入jps，显示进程为DataNode, NodeManager, WebAppProxyServer, ResourceManager

在Slave2节点中输入jps，显示进程为SecondaryNameNode, DataNode, NodeManager

2）启动spark

在Master节点上，进入spark安装目录，执行sbin/start-master.sh  然后执行sbin/start-slaves.sh

Master节点
[root@Master 桌面]# jps  
3646 JobHistoryServer  
3219 DataNode  
3119 NameNode  
3482 NodeManager  
3923 Worker  
10217 Jps  
3820 Master  

Slave1节点
[root@Slave1 桌面]# jps  
2837 Worker  
2359 NodeManager  
2710 WebAppProxyServer  
4514 Jps  
2120 DataNode  
2257 ResourceManager  

Slave2节点
[root@Slave2 桌面]# jps  
2508 Worker  
2186 SecondaryNameNode  
2327 NodeManager  
5136 Jps  
2127 DataNode 

此时，Master节点多了Master和Worker进程，两个子节点上多了Worker进程，则全部启动成功，Spark UI地址为：Master:4040


提交任务
spark-submit --master spark://localhost:7077  --class StreamingDemo /user/mashencai/spark/sparkstreaming.jar

spark-submit --master yarn --deploy-mode client  --class StreamingDemo /user/mashencai/spark/sparkstreaming.jar