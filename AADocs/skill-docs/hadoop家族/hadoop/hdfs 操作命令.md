切换到Hdfs用户
su hdfs

将Linux本地的文件上传到hdfs中，前面为服务器中文件路径，后面为hdfs中文件路径
hdfs dfs -put /home/hdfs/files/test.txt   /input

列出文件
./hadoop dfs -ls /

显示文件内容
hdfs dfs -cat /input/test.txt

