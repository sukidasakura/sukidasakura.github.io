## maven导入项目

#### 自动下载pom的依赖jar包
导入项目时，File-open-选择pom文件-open as project  
这样打开，都会自动引入pom的依赖。

#### supconit的两个中央仓库。
http://hc.supconit.com/nexus/
http://10.10.77.102:8081/nexus/


#### 遇到问题

maven在执行中报错
```
: Failure to find com.sup
conit.data:data_common:jar:1.1.00.170331-SNAPSHOT in http://10.10.77.102:8081/nexus/content/groups/public/ was cached in the local repository, resolution will not be reattempted until the u
pdate interval of nexus has elapsed or updates are forced -> [Help 1]
```
原因是有些jar包没有完全下载下来，在编译中找不到jar包。  
解决方法：在setting.xml中增加一个更新策略，如下：
```
<profile>
<id>data_dev_nexus</id>
<repositories>
<repository>
<id>nexus</id>
<!--url>http://hc.supconit.com/nexus/content/groups/public/</url-->
<url>http://10.10.77.102:8081/nexus/content/groups/public/</url>
<releases>
<enabled>true</enabled>
<updatePolicy>always</updatePolicy>【2】
</releases>
<snapshots>
<enabled>true</enabled>
<updatePolicy>always</updatePolicy>【2】
</snapshots>
</repository>
</repositories>
</profile>
```
