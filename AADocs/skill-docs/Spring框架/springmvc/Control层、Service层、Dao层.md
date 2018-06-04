## View层
1. 表示层，负责前端jsp页面表示。
> 项目中写在_web模块，ex: monitoring_web

## Control层
1. 标注@Controller，e.x:DataMonitorControl类，为了接受来自DispatcherServlet（web）的请求，负责url映射。
2. 负责具体业务模块流程的控制，即调用Service层的接口来控制业务流程。
3. 禁止直接调用Dao层。
> 项目中写在_impl模块，ex: data_monitoring_impl

## Service层
建立在Dao层之上，Controller层之下，调用Dao层接口，为Controller层提供接口，负责业务模块的逻辑应用设计，首先设计接口，再设计其实现的类。
> 项目中，service接口写在_api模块，ex: monitoring_api
> serviceImpl（实现）写在_impl模块，ex: monitoring_impl

## Dao层
1. 负责数据持久化，与数据库进行联络的任务都封装在其中，Dao层的数据源以及相关的数据库连接参数都在Spring配置文件中进行配置。
2. 每个实体（数据库表）就是一个Dao，Dao接口中的方法都大同小异，因为对数据库的操作基本类似：insert, delete, update, select。在Dao层定义的一些方法，在Service中没有被使用的情况：Dao层的操作经过抽象后基本都是通用的，在Dao层完成相关方法的定义，有利于支持后期Service层的扩展。
3. Dao中与数据库交互， 与对应的Mapper对应。

## Entity层（JavaBean）
java对象，与数据库表一一对应，是其对应的实现类。一个Entity就是对应表中的一条记录。

## 开发原则
1. 面向接口编程。表示层调用控制层，控制层调用业务层，业务层调用数据访问层。
2. Dao层设计与设计的数据库表，和实现类（对应的Entity或者JavaBean）一一对应。
3. View层与Controller层结合紧密，需要二者结合协同开发。Service层、Dao层和其他层次耦合很低，完全可以单独开发。