Exception in thread "main" redis.clients.jedis.exceptions.JedisConnectionException: Could not get a resource from the pool
	at redis.clients.util.Pool.getResource(Pool.java:53)
	at redis.clients.jedis.JedisPool.getResource(JedisPool.java:99)
	at com.redislabs.provider.redis.ConnectionPool$.connect(ConnectionPool.scala:33)
	at com.redislabs.provider.redis.RedisEndpoint.connect(RedisConfig.scala:67)
	at com.redislabs.provider.redis.RedisConfig.clusterEnabled(RedisConfig.scala:139)
	at com.redislabs.provider.redis.RedisConfig.getNodes(RedisConfig.scala:250)
	at com.redislabs.provider.redis.RedisConfig.getHosts(RedisConfig.scala:166)
	at com.redislabs.provider.redis.RedisConfig.<init>(RedisConfig.scala:89)
	at com.redislabs.provider.redis.RedisContext.fromRedisList$default$3(redisFunctions.scala:67)
	at StreamingRedis$.main(StreamingRedis.scala:20)
	at StreamingRedis.main(StreamingRedis.scala)
Caused by: redis.clients.jedis.exceptions.JedisConnectionException: java.net.SocketTimeoutException: connect timed out
	at redis.clients.jedis.Connection.connect(Connection.java:164)
	at redis.clients.jedis.BinaryClient.connect(BinaryClient.java:80)
	at redis.clients.jedis.BinaryJedis.connect(BinaryJedis.java:1677)
	at redis.clients.jedis.JedisFactory.makeObject(JedisFactory.java:87)
	at org.apache.commons.pool2.impl.GenericObjectPool.create(GenericObjectPool.java:868)
	at org.apache.commons.pool2.impl.GenericObjectPool.borrowObject(GenericObjectPool.java:435)
	at org.apache.commons.pool2.impl.GenericObjectPool.borrowObject(GenericObjectPool.java:363)
	at redis.clients.util.Pool.getResource(Pool.java:49)
	... 10 more
Caused by: java.net.SocketTimeoutException: connect timed out
	at java.net.DualStackPlainSocketImpl.waitForConnect(Native Method)
	at java.net.DualStackPlainSocketImpl.socketConnect(DualStackPlainSocketImpl.java:85)
	at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)
	at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)
	at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)
	at java.net.PlainSocketImpl.connect(PlainSocketImpl.java:172)
	at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
	at java.net.Socket.connect(Socket.java:589)
	at redis.clients.jedis.Connection.connect(Connection.java:158)
	... 17 more
	
解决方法：
由于redis服务器是内网地址，而个人电脑连着外网，因此会报这个错。
把外网关掉即可。