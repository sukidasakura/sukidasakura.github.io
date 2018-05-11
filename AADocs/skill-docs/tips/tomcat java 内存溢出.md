#### tomcat webapp下放的web程序过多，出现内存溢出的问题
java.lang.OutOfMemoryError: PermGen space  
PermGen space的全称是Permanent Generation space，是指内存的永久保存区域OutOfMemoryError:  
 PermGen space。从文字上看就是内存溢出，解决方法是加大内存。为什么会内存溢出，  
 这是由于这块内存主要是被JVM存放Class和Meta信息的，  
 Class在被Load的时候被放入PermGen space区域，它和存放Instance的Heap区域不同,  
 GC(Garbage Collection)不会在主程序运行期对PermGen space进行清理，  
 所以如果你的APP会LOAD很多CLASS的话，就很可能出现PermGen space错误。  
 这种错误常见在web服务器对JSP进行pre compile的时候。如果你的WEB APP下都用了大量的第三方jar,   
 其大小超过了jvm默认的大小(4M)那么就会产生此错误信息了。 

#### 解决方法： 手动设置MaxPermSize大小 
网上的解决方法是说在tomcat8w.exe中配置java参数，或者是在catalina.bat中添加java参数
改了以后都不生效。后来通过如下方式解决：  
https://blog.csdn.net/shiyong1949/article/details/52537566
直接在windows的环境变量中添加相关参数。  
添加参数如下：
 -Xms1024M -Xmx2048M -XX:PermSize=256M -XX:MaxNewSize=256M -XX:MaxPermSize=512M 

#### Java 参数的意思
-vmargs：说明后面是VM的参数
-Xms40m：虚拟通过机占用系统的最小内存
-Xmx256m：虚拟机占用系统的最大内存
-XX:PermSize：最小栈内存大小。一般报内存不足时,都是说这个太小,堆空间剩余小于5%就会警告,建议把这个稍微设大一点,不过要视自己机器内存大小来设置
-XX:MaxPermSize：最大栈内存大小。这个也适当大些

-Xmx512M的5%为25.6M，理论上要求-Xmx的数值与-XX:MaxPermSize必须大于25.6M

