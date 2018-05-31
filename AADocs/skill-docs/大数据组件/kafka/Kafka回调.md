##kafka回调

SendCallback发送回调对象
onCompletion()发送回调接口

在kafka异步发送函数send()中注册，在收到Broker返回的发送是否成功信息后，会触发该函数，并调用ProducerEvent对象的onSendMsg()函数，向调用者发送成功与否结果。

成功则返回调用者RecordMetadata信息(BrokerServer中的数据offset，Partition位置ID，Topic主题)
失败者返回调用者原始数据信息，便于日后恢复。