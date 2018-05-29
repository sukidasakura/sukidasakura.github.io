## redis命令

进入到redis-server/src，启动redis客户端./redis-cli 

redis 就像是一个队列。

#### KEYS *  
匹配数据库内所有 key

#### llen AFTER_VEHICLE  
返回列表AFTER_VEHICLE的长度
如果 key 不存在，则 key 被解释为一个空列表，返回 0 .
如果 key 不是列表类型，返回一个错误。

#### LPOP key
移除并返回列表 key 的头元素。

#### BLPOP key [key ...] timeout
e.x: blpop AFTER_VEHICLE 0  
BLPOP 是列表的阻塞式(blocking)弹出原语。
它是 LPOP 命令的阻塞版本，连接将被 BLPOP 命令阻塞，直到等待超时或发现可弹出元素为止。

#### LINDEX key index
返回列表 key 中，下标为 index 的元素。

下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。

你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。

如果 key 不是列表类型，返回一个错误。

#### LRANGE key start stop
lrange AFTER_VEHICLE 0 2
返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。

下标(index)参数 start 和 stop 都以 0 为底，也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。

你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。