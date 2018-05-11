## spring中bean配置和bean注入

### bean与spring容器的关系
Bean配置信息定义了Bean的实现及依赖关系，
Spring容器根据各种形式的Bean配置信息在容器内部建立Bean定义注册表，
然后根据注册表加载、实例化Bean，并建立Bean和Bean的依赖关系，
最后将这些准备就绪的Bean放到Bean缓存池中，以供外层的应用程序进行调用。

### bean定义

<beans…/>元素是Spring配置文件的根元素，<bean…/>元素是<beans../>元素的子元素，  
<beans…/>元素可以包含多个<bean…/>子元素，  
每个<bean…/>元素可以定义一个Bean实例，  
每一个Bean对应Spring容器里的一个Java实例定义Bean时通常需要指定两个属性。
#### 1.Id
确定该Bean的唯一标识符，容器对Bean管理、访问、以及该Bean的依赖关系，都通过该属性完成。  
Bean的id属性在Spring容器中是唯一的。    

#### 2.Class：指定该Bean的具体实现类。注意这里不能使接口。  
通常情况下，Spring会直接使用new关键字创建该Bean的实例，因此，这里必须提供Bean实现类的类名。

#### 下面是定义一个Bean的简单配置
```
<?xml version="1.0" encoding="UTF-8"?>  
<beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
    xmlns="http://www.springframework.org/schema/beans"  
    xsi:schemaLocation="http://www.springframework.org/schema/beans  
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">  
    <!-- 定义第一个Bean实例：bean1 -->  
    <bean id="bean1" class="com.Bean1" />  
      
    <!-- 定义第二个Bean实例：bean2 -->  
    <bean id="bean2" class="com.Bean2" />  
      
</bean> 
```
当我们在配置文件中通过<bean id=”xxxx” class=”xx.XxClass”/>方法配置一个Bean时，
这样就需要该Bean实现类中必须有一个无参构造器。故Spring底层相当于调用了如下代码：

Xxx = new xx.XxClass()  



#### bean配置
bean配置有三种方法：

基于xml配置Bean  
使用注解定义Bean 
基于java类提供Bean定义信息  
