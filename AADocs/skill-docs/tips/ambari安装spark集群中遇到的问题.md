1. 查看某台机器是否已经安装了ambari
可以查看路径/var/log下面是否有ambari-agent文件夹
2. 查看ambari机器间通信的FQDN(Fully Qualified Domain Name)
vim /etc/sysconfig/network
HOSTNAME=data38
data38就是ambari的FQDN。

创建.ssh密钥
ssh-keygen -t rsa