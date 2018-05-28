## 问题一
spark-submit --master yarn --deploy-mode cluster  --class SparkSubmit /user/mashencai/spark/sparkbasic.jar
用yarn-cluster模式在10.10.99.37上提交sparkr任务，报错：


Caused by: org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.security.AccessControlException): Permission denied: user=root, access=WRITE, inode="/user/root/.sparkStaging/application_1527210354246_0004":hdfs:hdfs:drwxr-xr-x


dfs.permissions = true
如果是 true，则打开前文所述的权限系统。如果是 false，权限检查 就是关闭的，但是其他的行为没有改变。这个配置参数的改变并不改变文件或目录的模式、所有者和组等信息。


## 问题二

出现循环的如下消息：  
18/05/28 14:10:02 INFO Client: Application report for application_1527210354246_0007 (state: ACCEPTED)
18/05/28 14:10:03 INFO Client: Application report for application_1527210354246_0007 (state: ACCEPTED)
18/05/28 14:10:04 INFO Client: Application report for application_1527210354246_0007 (state: ACCEPTED)
18/05/28 14:10:05 INFO Client: Application report for application_1527210354246_0007 (state: ACCEPTED)
18/05/28 14:10:06 INFO Client: Application report for application_1527210354246_0007 (state: ACCEPTED)

原因：资源不足

解决方法：（未验证）
http://www.itkeyword.com/doc/4214879305995466x649/application-report-for-application-state-accepted-never-ends-for-spark-submi