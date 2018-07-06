运行hbase报错：（hbase-client版本1.1.2）
原因是guava包冲突（ES的访问依赖这个包1.8.0版本。）
将Hbase-client版本改为1.3.0，错误解决（不知何原因）。

```
org.apache.hadoop.hbase.DoNotRetryIOException: java.lang.IllegalAccessError: tried to access method com.google.common.base.Stopwatch.<init>()V from class org.apache.hadoop.hbase.zookeeper.MetaTableLocator
	at org.apache.hadoop.hbase.client.RpcRetryingCaller.translateException(RpcRetryingCaller.java:229)
	at org.apache.hadoop.hbase.client.RpcRetryingCaller.callWithoutRetries(RpcRetryingCaller.java:202)
	at org.apache.hadoop.hbase.client.ClientScanner.call(ClientScanner.java:320)
	at org.apache.hadoop.hbase.client.ClientScanner.nextScanner(ClientScanner.java:295)
	at org.apache.hadoop.hbase.client.ClientScanner.initializeScannerInConstruction(ClientScanner.java:160)
	at org.apache.hadoop.hbase.client.ClientScanner.<init>(ClientScanner.java:155)
	at org.apache.hadoop.hbase.client.HTable.getScanner(HTable.java:821)
	at org.apache.hadoop.hbase.MetaTableAccessor.fullScan(MetaTableAccessor.java:602)
	at org.apache.hadoop.hbase.MetaTableAccessor.getTableRegionsAndLocations(MetaTableAccessor.java:523)
	at org.apache.hadoop.hbase.MetaTableAccessor.getTableRegions(MetaTableAccessor.java:399)
	at org.apache.hadoop.hbase.client.HBaseAdmin.getTableRegions(HBaseAdmin.java:2838)
	at com.supconit.server.HBaseControllerTest.getTableList(HBaseControllerTest.java:81)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:51)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:237)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
Caused by: java.lang.IllegalAccessError: tried to access method com.google.common.base.Stopwatch.<init>()V from class org.apache.hadoop.hbase.zookeeper.MetaTableLocator
	at org.apache.hadoop.hbase.zookeeper.MetaTableLocator.blockUntilAvailable(MetaTableLocator.java:596)
	at org.apache.hadoop.hbase.zookeeper.MetaTableLocator.blockUntilAvailable(MetaTableLocator.java:580)
	at org.apache.hadoop.hbase.zookeeper.MetaTableLocator.blockUntilAvailable(MetaTableLocator.java:559)
	at org.apache.hadoop.hbase.client.ZooKeeperRegistry.getMetaRegionLocation(ZooKeeperRegistry.java:61)
	at org.apache.hadoop.hbase.client.ConnectionManager$HConnectionImplementation.locateMeta(ConnectionManager.java:1185)
	at org.apache.hadoop.hbase.client.ConnectionManager$HConnectionImplementation.locateRegion(ConnectionManager.java:1152)
	at org.apache.hadoop.hbase.client.RpcRetryingCallerWithReadReplicas.getRegionLocations(RpcRetryingCallerWithReadReplicas.java:300)
	at org.apache.hadoop.hbase.client.ScannerCallableWithReplicas.call(ScannerCallableWithReplicas.java:151)
	at org.apache.hadoop.hbase.client.ScannerCallableWithReplicas.call(ScannerCallableWithReplicas.java:59)
[org.apache.zookeeper.ZooKeeper] - Session: 0x163d42b793a1973 closed
	at org.apache.hadoop.hbase.client.RpcRetryingCaller.callWithoutRetries(RpcRetryingCaller.java:200)
	... 32 more
```