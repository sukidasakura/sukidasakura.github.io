## What have I learned
1，Spark（Simple）  
2，Elastic（Simple）   
3，Linux（Middle）   
4，Hive(Less Than Simple)  
5，Hadoop（More Than Simple）  
6，Drill（More Than Simple）  
7，phoenix（None）  
8，Hbase（Middle）  
9，Flume （None）  
10，Java（Middle）  
11，Kafka(Simple)   
12，RockMq(Less Than Simple)  
13，Docker（None）  
14，Jenkins（None）   
15，Azkaban  
16，OpenStack and Ceph（Simple）  
# Conclusion The Year
1，从零开始参与大数据项目架构，提供源码管理，编译，项目发布支撑，方便组员间的相互协作开发，提高项目管理的效率。  
2，主持大数据开源集群搭建脚本规范和自动化部署安装，给大数据服务提供基础组件服务，自动化流程，减少项目部署时间。  
3，参与其中多个大数据服务模块的设计，代码编写，不断提高静态信息库以图搜图效率。  
4，参与大数据各个组件调研，不断优化大集群的项目架构，在elasticsearch、hbase、shell脚本、自动化管理工具方面涉略较深，支撑现阶段的整个大数据服务架构。  
5，处理承担组内脚本编写，代码测试，项目发布遇到的问题，给出合理的不断优化的解决方案。  
6，负责对新入组成员的shell脚本，项目架构，大数据组件，构建和项目管理工具的使用培训，提升整个团队的技能。  
7，多个版本迭代过程中，不断地进行优化代码设计和项目架构，目前整个大数据服务，个人负责的模块性能稳定，效率不断得到提升。  
(备注: 大数据开发工程师，面试题)
（研读代码，总结整个项目架构，）

# Conclusion in 2016
1，熟悉Linux操作和Shell 脚本。  
2，熟悉jenkins 搭建，项目工程管理。  
3，负责Spark 大数据编译测试环境。  


# 集群部署安装
#### 1，[Spark Stanalone HA 模式搭建](Docs/sparkbasic-docs/standalone.md)

# 规范代码
1，接口定义，对外接口，对内接口，对外提供统一的接口,    
2，方法实现：提取公共实现代码、即工具类，松耦合，单一功能，  
3，脚本格式规范，变量名统一命名，放在一处，不要写死  
4，项目模块，模块名定了之后，不要改，涉及到的地方很多，不易于维护。  
5，模块分离，集群分离，ETL（Extract-Transform-Load 抽取转换加载）（数据采集集群），计算集群，存储集群，对外服务，负载均衡，成本


