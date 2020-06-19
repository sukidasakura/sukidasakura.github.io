## Linux基本命令



linux 查找带有某关键字的文件
grep -r "{关键字}"  {路径}
例如：
grep -r "test"  /data/reports

1、
find / -name '*' | xargs grep 'route'

在根文件夹下查找含有关键字route的文件，列出文件名和route所在行。

2、
find / -name '*.txt' | xargs grep 'route'

在根文件夹下查找后缀名为txt且含有关键字route的文件，列出文件名和route所在行。



#### 重启防火墙
systemctl disable firewalld
service  iptables stop
chkconfig iptables off
#### 配置免密登录
1. ssh-keygen -t rsa 生成密钥
2. 在data138上，执行
ssh-copy-id 10.10.77.137（ambari-agent的节点）

#### 启停mysql
10.10.77.143
su mysql
/usr/local/mysql/bin
启动命令：./mysqld --user=mysql
修改配置：
/etc/my.cnf

service mysqld restart

/usr/local/mysql/bin/mysqld --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data --plugin-dir=/usr/local/mysql/lib/plugin --user=mysql --log-error=/usr/local/mysql/data/data143.err --pid-file=/usr/local/mysql/data/data143.pid --socket=/tmp/mysql.sock --port=3306

/bin/sh /usr/local/mysql/bin/mysqld_safe --datadir=/usr/local/mysql/data --pid-file=/usr/local/mysql/data/data143.pid

#### 查找包含指定内容的文件
grep '指定内容' -r 目录
grep 'postgresql' -r /usr/local/greenplum-db
指定内容为postgresql
-r 递归查找文件


#### dos转unix文件格式
vim 编辑器 输入  
:set ff=unix

#### 查看进程信息
ps aux | grep ZeppelinServer
```
root     13774  2.0  2.9 4148308 477340 ?      Sl   09:17   0:12 /home/jdk1.8.0_111/bin/java -Dspark.executor.memory=512m -Dspark.executor.instances=2 -Dspark.yarn.queue=default -Dfile.encoding=UTF-8 -Xms1024m -Xmx1024m -XX:MaxPermSize=512m -Dlog4j.configuration=file:///usr/hdp/current/zeppelin/conf/log4j.properties -Dzeppelin.log.file=/usr/hdp/current/zeppelin/logs/zeppelin-root-data137.log -cp :.:/usr/hdp/current/jdk/lib/tools.jar:/usr/hdp/current/jdk/lib/dt.jar:/usr/hdp/current/zeppelin/lib/interpreter/*:/usr/hdp/current/zeppelin/lib/*:/usr/hdp/current/zeppelin/*::/usr/hdp/current/zeppelin/conf:/etc/hadoop/conf org.apache.zeppelin.server.ZeppelinServer
root     18009  0.0  0.0 103260   872 pts/102  S+   09:27   0:00 grep ZeppelinServer
```

#### 查看进程权限
ps -ef | grep ZeppelinServer


#### 回到行首
ctrl + A

#### 查看linux时间
date

#### 查看运行进程所在目录
ps -ef | grep xxx

#### mysql安装
1. rpm -qa | grep mysql 查看Mysql是否安装
2. Mysql rpm包安装顺序：
common -> libs -> clients -> server
3. 安装好后，检查是否存在Mysql的配置文件
ls /etc/my.cnf

或者有没有Mysql的命令在/usr/bin下
cd /usr/bin/
ls | grep mysql
4. 启动Mysql
/etc/init.d/mysqld start  
ps aux | grep mysqld
5. mysql rpm安装的初始密码
cat /var/log/mysqld.log | grep 'temporary password'
6. mysql -uroot -p
输入密码登录mysql后修改密码：
set password=password('supconit')


#### 查看linux系统版本信息。
lsb_release -a 

####vim行号的显示与隐藏
:set nu
:set nonu

#### rpm相关
 rpm -ivh  rmp文件 安装rpm
 rpm -e rpm文件 卸载rpm
 rpm -e rpm文件 --nodeps 不管依赖关系，强制卸载。
 rpm -q xxx 查找rpm包
 rpm -qa|grep libtirpc 查找是否已经有libtirpc这个rmp包

#### 修改脚本格式为linux格式 
set ff=unix
  
#### vim到文件最后
shift+g

#### Linux 查看逻辑CPU的个数
cat /proc/cpuinfo| grep "processor"| wc -l
48

#### 查看Linux文件夹用量
du -sh 文件夹

#### 查看机器磁盘用量
df -k -h

#### 查看显卡
nvidia-smi

#### 查看进程详细信息
ps -ef | grep FTP

#### 查看端口
lsof -i:2121 

#### 解压
tar -xf RealTimeCompare.tar.gz -C RealTimeCompare/

#### 解压时去除目录结构解压到指定目录
tar -xf zeppelin-0.8.0-bin-all.tgz --strip-components=1

#### 压缩
tar -czf XXX.tar.gz XXX

#### 设置权限
chmod -R 755 path

#### 根据字段读取
ES_IP=$(grep es_servernode project-conf.properties|cut -d '=' -f2)
或：
ROCKET_NAMESERVER=`sed '/rocketmq_nameserver/!d;s/.*=//' ${CONF_FILE} | tr -d '\r'`

#### 替换
sed -i "s####^address=.*####address=${ROCKET_NAMESERVER}####g" ${CONF_FTP_DIR}/rocketmq.properties

#### 注意
禁止进行 rm -rf /tmp/*  这样的操作，
/tmp/hsperfdata_${username}/${pid}  目录下这样的文件保存了正在运行的 java 进程的信息，
删除后，虽然进程还在运行,  但是jps 会显示没有进程。

#### 读取某一行
sed -n '4p' ${CONF_DIR}/install_home.properties

#### 查找yarn-site.xml中的<name>yarn.scheduler.minimum这行，并获取这行的行号
cat yarn-site.xml  | cat -n | grep  \<name\>yarn.scheduler.minimum | awk '{print $1}'

#### 在文件/etc/profile_test中，删除匹配到“export JAVA_HOME=”的这一行
sed -i '/export JAVA_HOME=/d' /etc/profile_test

「##」号截取，删除左边字符，保留右边字符。  
「##*/」表示从左边开始删除最后（最右边）一个 / 号及左边的所有字符。  
若输入的为文件，截取到文件名  
var=/etc/profile;echo ${var##*/}

#### 判断是目录还是文件
if [ -d /etc ];then echo "是一个目录";fi

#### 压缩服务器上当前目录的内容为xxx.zip文件
zip -r xxx.zip ./*  
解压zip文件到当前目录  
unzip filename.zip


#### 在当前目录查找以 .log 结尾的文件。
find . -name "*.log" 

#### 显示/var/lib/ambari-server目录下的文件（包含子目录）包含install_packages的行
grep -r install_packages /var/lib/ambari-server

#### 查找目录下的所有文件中是否含有某个字符串 
find .|xargs grep -ri "zookeeper.log" 

#### dos2unix整个目录
find . -type f -exec dos2unix {} \;
#### 解释：find . = find files in the current directory

-type f  
= of type f  
 
-exec dos2unix {} \;  
= and execute dos2unix on each file found  

#### 判断目录是否存在 不存在则创建
if [ ! -d $LOG_DIR ];then  
    mkdir -p $LOG_DIR;  
fi 

#### 判断是否执行成功
if [ $? = 0 ];then  
    echo "执行成功..."  
fi  

#### 在linux中使用vi 打开文件时，能显示行号
显示所有行号，在VI的命令模式下输入  
:set nu 

#### 将主机名转化为IP
ip=$(cat /etc/hosts|grep "$host_name" | awk '{print $1}')

#### 显示rados进程
ps axu | grep rados  
1）ps a 显示现行终端机下的所有程序，包括其他用户的程序。  
2）ps x 　 显示所有程序，不以终端机来区分。  
3）ps u 　 以用户为主的格式来显示程序状况。  

#### 查看Linux所有用户信息
cat /etc/password

#### root用户切换hadoop用户
su hadoop

#### data用户切换root用户
exit

sudo su  
如有需要再输入密码

#### 修改文件权限
chown -R gpadmin /usr/local/greenplum-db
chgrp -R gpadmin /usr/local/greenplum-db

chown -R hadoop:hadoop hdfs-2.7.7/

#### shell 判断变量中是否包含某个字符串
str="this is a string"  
[[ $str =~ "this" ]] && echo "$str contains this"   

#### 下载全站资料，把一个网站整个静态化到本地。
wget -r -p -np -k -P /home/data/Documents/msc http://docs.ceph.com/docs/master/  
-P 表示下载到哪个目录  
-r 表示递归下载  
-np 表示不下载旁站连接  
-k 表示将下载的网页里的链接修改为本地链接  
-p 获得所有显示网页所需的元素  

#### 从detect1.log中检索出带pp字段的文本，读取每行冒号后的值，取所有值的平均值。
检测出来如下  
pp1:value  
pp2:value  
grep "pp" detect1.log | cut -d ":" -f2 | awk '{sum+=$1} END {print "Avg =",sum/NR}'

#### scp拷贝文件夹 
scp -r /home/test/ftp/ root@172.18.18.107:/home/test/ftp/

#### .>>和>的区别
    >> 是追加内容
    > 是覆盖原有内容