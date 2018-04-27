//import org.apache.spark.{SparkConf, SparkContext}
//import org.apache.spark.streaming.StreamingContext
//import org.apache.spark.streaming.dstream.DStream
//import org.scalatest.time.Seconds
//
//object StreamingDemo {
//	def main(args: Array[String]): Unit = {
//		// 创建一个具有两个工作线程（working thread）并且批次间隔为 1 秒的本地 StreamingContext .
//		// master 需要 2 个核, 以防止饥饿情况（starvation scenario）.
//		val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
//		val ssc = new StreamingContext(conf, Seconds(1))
//
//		// 使用该 context, 创建一个代表从 TCP 源流数据的离散流（DStream）,
//		// 连接到 hostname:port 的 DStream，如 localhost:9999
//		val lines = ssc.socketTextStream("localhost", 9999)
//
//		// 在这个离散流（DStream）中的每一条记录都是一行文本（text）.
//		// 我们想要通过空格字符（space characters）拆分这些数据行（lines）成单词（words）.
//		// flatMap 是一种 one-to-many（一对多）的离散流（DStream）操作,
//		// 它会通过在源离散流（source DStream）中根据每个记录（record）生成多个新纪录的形式创建一个新的离散流（DStream）.
//		// 在这种情况下，每一行（each line）都将被拆分成多个单词（words）和代表单词离散流（words DStream）的单词流.
//		val words = lines.flatMap(_.split(" "))
//
////		val words = "Mr.Li is my husband".split(" ")
//		// 接下来，我们想要计算这些单词.
//		val pairs = words.map(word => (word, 1))
//		val wordCounts = pairs.reduceByKey(_ + _)
//		wordCounts.print()
//	}
//
//
//}
