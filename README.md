## Spring MVC First demo

Spring MVC处理/user.html的整个过程：
1. DispatcherServlet接收到客户端的/user.html请求
2. DispatcherServlet使用DefaultAnnotationHandlerMapping查找负责处理该请求的处理器
3. DispatcherServlet将请求分发给名为/user.html的UserController处理器
4. 处理器完成业务处理后，返回ModelAndView对象，其中View的逻辑名为/user/createSuccess，而模型包含一个键为user的User对象。
5. DispatcherServlet调用InternalResourceViewResolver组件对ModelAndView中的逻辑视图名进行解析，得到真实的/WEB-INF/view/user/createSuccess.jsp视图对象。
6. DispatcherServlet使用/WEB-INF/view/user/createSuccess.jsp对模型中的user模型对象进行渲染。
7. 返回响应页面给客户端。