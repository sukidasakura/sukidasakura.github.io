## Linux基本命令

####vim行号的显示与隐藏
:set nu
:set nonu

####安装rpm安装包
 rpm -ivh  rmp文件

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

#### data用户切换root用户
sudo su  
如有需要再输入密码

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