####log4j日志文件的内容
```
#### 读取resources目录下面的文件
resources目录下有一个picFrom文件夹，读取方式如下  
String picFromPath = ClassLoader.getSystemResource("picFrom").getPath();

#### 线程池

threadPoolExecutor 中的 shutdown() 、 shutdownNow() 、 awaitTermination() 的用法和区别

Java等待线程池中的子线程执行完毕，再执行后续逻辑


调度
http://blog.csdn.net/guozebo/article/details/51090612


#### 设计模式
采用MVC 三层架构的思想来进行代码规划，  
M层： 模型层 （类似ProcessData）  
V层： 视图层（这里可以看做是返回值，即大报那里的最终的boolean 返回值）  
C层： 控制层（一般还有一个逻辑层，这里不用分那么清楚，控制层和业务逻辑层放在一起。）  
类似这样的代码，维护以及逻辑结构更加清晰一些。 


####mvn重新编包
mvn clean package

####字符串截取。
通过subString()方法来进行字符串截取。


####怎样往类中传参数
写一个类的有参构造函数
类与类之间的交互：通过参数的传递，或方法的调用
```

####想在控制台输出lo4j的日志信息
```
1、修改log4j.properties为以下内容：
log4j.rootLogger=INFO, R
log4j.appender.R=org.apache.log4j.ConsoleAppender
log4j.appender.R.layout=org.apache.log4j.PatternLayout
log4j.appender.R.layout.ConversionPattern= %d : %p : %c{1} : %m%n
2、修改pom.xml
以下这部分注释掉：
<excludes>
	<exclude>*.properties</exclude>
	<exclude>*.xml</exclude>
</excludes>
```