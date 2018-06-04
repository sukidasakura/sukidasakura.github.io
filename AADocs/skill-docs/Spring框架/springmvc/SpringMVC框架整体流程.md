DispatcherServlet的处理流程可以简单概括如下：
1. HadnlerMapping先生（Web请求的处理协调人）
处理Web请求和具体的处理类之间的映射关系匹配。
例如：
```
<!-- 表示拦截的模式 -->
    <!-- 指定DispatcherServlet处理url-pattern的http请求（即所有匹配的请求都会被DispatcherServlet截获并处理） -->
    <servlet-mapping>
        <servlet-name>smart</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

当web请求到达DispatcherServlet之后，Dispatcher将寻求具体的HandlerMapping实例，以获取当前Web请求的具体处理类，即org.springframework.web.servlet.Controller

2. org.springframework.web.servlet.Controller（Web请求的具体处理者）
Controller是对应DispatcherServlet的次级控制器，本身实现了对应某个具体Web请求的处理逻辑。

3. Controller的处理方法执行完毕后，将返回一个ModelAndView实例，包含如下两部分信息：
 > 视图的逻辑名称（或具体的视图实例）。DispatcherServlet根据该视图的逻辑名称，来决定为用户显示哪个视图。
 > 模型数据。视图渲染过程中需要将这些模型数据并入视图的显示中。

DispatcherServlet只需根据Controller处理完毕后通过ModelAndView返回的逻辑视图名称查找到具体的View实现，然后委派该具体的View实现类来根据模型数据，输出具体的视图内容即可。