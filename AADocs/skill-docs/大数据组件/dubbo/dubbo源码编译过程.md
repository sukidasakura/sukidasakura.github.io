#### dubbo源码编译过程
https://blog.csdn.net/sxgyruan03mwp/article/details/53304161

1. 进入源码文件所在总目录下，执行mvn install -Dmaven.test.skip=true，  
2. 命令执行成功结束后，会在  dubbo-admin 下会出现target文件夹，  
3. 把dubbo-admin-2.5.4.war（可改名dubbo-admin）放到tomcat的webapps目录下，
4. 启动tomcat，访问：127.0.0.1:8081/dubbo-admin  