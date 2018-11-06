1. 查看某台机器是否已经安装了ambari
可以查看路径/var/log下面是否有ambari-agent文件夹
2. 查看ambari机器间通信的FQDN(Fully Qualified Domain Name)
vim /etc/sysconfig/network
HOSTNAME=data38
data38就是ambari的FQDN。

创建.ssh密钥
ssh-keygen -t rsa


  File "/usr/bin/hdp-select", line 226
    print "ERROR: Invalid package - " + name
                                    ^
SyntaxError: Missing parentheses in call to 'print'. Did you mean print("ERROR: Invalid package - " + name)?
  File "/usr/bin/hdp-select", line 226
    print "ERROR: Invalid package - " + name
                                    ^
SyntaxError: Missing parentheses in call to 'print'. Did you mean print("ERROR: Invalid package - " + name)?
starting org.apache.spark.deploy.master.Master, logging to /var/log/spark2/spark-root-org.apache.spark.deploy.master.Master-1-data37.out
failed to launch: nice -n 0 /usr/hdp/current/spark2-client/bin/spark-class org.apache.spark.deploy.master.Master --host data37 --port 7077 --webui-port 8080
  Exception in thread "main" java.lang.IllegalStateException: hdp.version is not set while running Spark under HDP, please set through HDP_VERSION in spark-env.sh or add a java-opts file in conf with -Dhdp.version=xxx
  	at org.apache.spark.launcher.Main.main(Main.java:118)
full log in /var/log/spark2/spark-root-org.apache.spark.deploy.master.Master-1-data37.out

解决方案：
在配置文件/usr/hdp/current/spark2-client/spark-env.sh中添加：

