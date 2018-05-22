## Spring基于注解配置bean

### 一、隐式发现和装配bean的方法
主要是通过两步来实现Bean的装配和使用。
1. 组件扫描（component scanning）:Spring 会自动发现应用上下文中所创建的bean。
2. 自动装配（autowiring）:Spring 自动将满足类型或名称的Bean注入到使用到的类。

##### 具体举例如下：
1. 声明一个组件dog：
```
@Component("dog")
public class Dog {
    public void call(){
        System.out.println("汪汪汪...");
}
```
2. 再声明一个组件My，使用了组件Dog:
```
@Component("my")
public class My {
    @Autowired(required=true)
    private Dog dog;
    
    public void shout(){
        dog.call();
    }
}
```
3. 由于组件扫描默认是不启动的，所以我们要配置一下Spring，让它去寻找含有注解@Respository的类，然后为他们创建Bean。  
下面是使用XML进行组件扫描，使用Spring context命名空间的 <context:component-scan>元素：
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:task="http://www.springframework.org/schema/task"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xmlns:cache="http://www.springframework.org/schema/cache"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/cache
        http://www.springframework.org/schema/cache/spring-cache.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/task http://www.springframework.org/schema/task/spring-task-4.0.xsd">
    <!-- 自动扫描 --> <!-- 自动扫描指定的包中的类上的注解 -->
    <context:component-scan base-package="com.cache"/>
</beans>

```
做完这些之后就能使用注入到Spring容器中的Bean了。

### 二、@Component及3个相似注解

    @Component("userDao")
        public class UserDao{
    }

等价于以下XML配置：
```
<bean id="userDao" class="com.paris..."/>
```
Spring提供了另外三个与component功能基本相似的注解，列出如下：
1. @controller 控制器（注入服务）  
用于标注控制层，相当于struts中的action层

2. @service 服务（注入dao）  
用于标注服务层，主要用来进行业务的逻辑处理

3. @repository（实现dao访问）  
用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件。

4. @component 
把普通pojo实例化到spring容器中，相当于配置文件中的 
<bean id="" class=""/>。  

```
component 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
```
5. 案例： 
```
<context:component-scan base-package=”com.*”> 
```
上面的这个例子是引入Component组件的例子，其中base-package表示为需要扫描的所有子包。 
6. 共同点  
被@controller 、@service、@repository 、@component 注解的类，都会把这些类纳入进spring容器中进行管理。


### @Resource与@Autowired注解

1. @Resource和@Autowired注解都是用来实现*依赖注入*的。  
2. 都可以写在字段上，或写在setter方法上。
3. @Autowired按byType自动注入，而@Resource默认按 byName自动注入。 

#### @Resource 注解

 @Resource有两个重要的属性，分别是name和type。 
 ```
1. Spring将@Resource name属性解析为bean的name(而非bean的id)，而type属性则解析为bean的类型。
2. 如果使用name属性，则使用byName的自动注入策略。
3. 使用type属性时则使用byType自动注入策略。
4. 如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。 
```

#### 两者的区别
1. @Resource默认是按照名称来装配注入的，只有当找不到与名称匹配的bean才会按照类型来装配注入；
2. @Autowired默认是按照类型装配注入的，如果想按照名称来转配注入，则需要结合@Qualifier一起使用；
3. @Resource注解是由JDK提供，而@Autowired是由Spring提供
4. @Resource和@Autowired都可以书写标注在字段或者该字段的setter方法之上