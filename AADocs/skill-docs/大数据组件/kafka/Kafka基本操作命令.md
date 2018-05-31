## Kafka基本操作命令

#### 查看帮助信息  
    bin/kafka-topics.sh --help

#### 创建topic  
```
./kafka-topics.sh --create --topic feature --zookeeper 172.18.18.163:2181 --partitions 6 --replication-factor 1
 
--create： 指定创建topic动作  
--topic：指定新建topic的名称  
--zookeeper： 指定kafka连接zk的连接url，该值和server.properties文件中的配置项{zookeeper.connect}一样  
--config：指定当前topic上有效的参数值，参数列表参考文档为: Topic-level configuration  
--partitions：指定当前创建的kafka分区数量，默认为1个  
--replication-factor：指定每个分区的复制因子个数，默认1个
```

#### 查看当前Kafka集群中Topic的情况  
    bin/kafka-topics.sh --list --zookeeper 172.18.18.163:2181