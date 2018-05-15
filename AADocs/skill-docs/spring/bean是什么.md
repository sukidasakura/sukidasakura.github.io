https://www.cnblogs.com/bossen/p/5824067.html
一、Bean是啥

1、Java面向对象，对象有方法和属性，那么就需要对象实例来调用方法和属性（即实例化）；

2、凡是有方法或属性的类都需要实例化，这样才能具象化去使用这些方法和属性；

3、规律：凡是子类及带有方法或属性的类都要加上注册Bean到Spring IoC的注解；

4、把Bean理解为类的代理或代言人（实际上确实是通过反射、代理来实现的），这样它就能代表类拥有该拥有的东西了

5、我们都在微博上@过某某，对方会优先看到这条信息，并给你反馈；
那么在Spring中，你标识一个@符号，那么Spring就会来看看，并且从这里拿到一个Bean或者给出一个Bean。

二、注解分为两类：

1、一类是使用Bean，即是把已经在xml文件中配置好的Bean拿来用，完成属性、方法的组装；  
比如@Autowired , @Resource，可以通过byTYPE（@Autowired）、byNAME（@Resource）的方式获取Bean；

2、一类是注册Bean,@Component , @Repository , @Controller , @Service , @Configration  
这些注解都是把你要实例化的对象转化成一个Bean，放在IoC容器中，等你要用的时候，  
它会和上面的@Autowired , @Resource配合到一起，把对象、属性、方法完美组装。