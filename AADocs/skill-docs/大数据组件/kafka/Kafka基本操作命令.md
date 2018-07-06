## Kafka基本操作命令

#### 查看帮助信息  
    bin/kafka-topics.sh --help

#### 创建topic  
```
./kafka-topics.sh --create --topic test_msc --zookeeper 10.10.77.137:2181 --partitions 1 --replication-factor 1
 
--create： 指定创建topic动作  
--topic：指定新建topic的名称  
--zookeeper： 指定kafka连接zk的连接url，该值和server.properties文件中的配置项{zookeeper.connect}一样  
--config：指定当前topic上有效的参数值，参数列表参考文档为: Topic-level configuration  
--partitions：指定当前创建的kafka分区数量，默认为1个  
--replication-factor：指定每个分区的复制因子个数，默认1个
```

#### 删除topic
./kafka-topics.sh --delete --zookeeper 10.10.77.137:9092 --topic test_msc（这只是标记为删除）

若要真正删除：
1. 登录zk客户端：./zkCli.sh
2. 找到topic所在目录： ls /brokers/topics
3. 找到要删除的topic： rmr /brokers/topics/[topic name] 即可，此时topic被彻底删除。

#### 查看当前Kafka集群中Topic的情况  
    bin/kafka-topics.sh --list --zookeeper 10.10.77.137:2181
    
#### 查看对应topic的描述信息
    ./kafka-topics.sh --describe --zookeeper 10.10.77.136:2181 --topic test

#### 生产消息
./kafka-console-producer.sh --broker-list 10.10.77.136:9092,10.10.77.137:9092,10.10.99.38:9092 --topic chaizezhao

#### 消费消息
./kafka-console-consumer.sh --bootstrap-server 10.10.77.136:9092,10.10.77.137:9092,10.10.99.38:9092 --topic chaizezhao
