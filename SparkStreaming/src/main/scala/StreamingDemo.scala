import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.streaming.{Duration, Durations, StreamingContext}
import org.apache.spark.streaming.dstream.DStream
import org.scalatest.time.Seconds

object StreamingDemo {
	def main(args: Array[String]): Unit = {
		// 创建一个具有两个工作线程（working thread）并且批次间隔为 1 秒的本地 StreamingContext .
		// master 需要 2 个核, 以防止饥饿情况（starvation scenario）.
		val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
				.set("spark.testing.memory", "2147480000")
		val ssc = new StreamingContext(conf, Durations.seconds(3))

		// 使用该 context, 创建一个代表从 TCP 源流数据的离散流（DStream）,
		// 连接到 hostname:port 的 DStream，如 localhost:9999
		val lines = ssc.socketTextStream("172.18.18.182", 9999)

		// 在这个离散流（DStream）中的每一条记录都是一行文本（text）.
		// 我们想要通过空格字符（space characters）拆分这些数据行（lines）成单词（words）.
		// flatMap 是一种 one-to-many（一对多）的离散流（DStream）操作,
		// 它会通过在源离散流（source DStream）中根据每个记录（record）生成多个新纪录的形式创建一个新的离散流（DStream）.
		// 在这种情况下，每一行（each line）都将被拆分成多个单词（words）和代表单词离散流（words DStream）的单词流.
		val words = lines.flatMap(_.split(" "))

		// 接下来，我们想要计算这些单词.
		val pairs = words.map(word => (word, 1))
		val wordCounts = pairs.reduceByKey(_ + _)
		wordCounts.print()
		// 上一步的 words DStream 进行了进一步的映射（一对一的转换）为一个 (word, 1) paris 的离散流（DStream），
		// 这个 DStream 然后被规约（reduce）来获得数据中每个批次（batch）的单词频率.
		// 最后，wordCounts.print() 将会打印一些每秒生成的计数.

		// 请注意，当这些行（lines）被执行的时候， Spark Streaming 仅仅设置了计算, 只有在启动时才会执行，并没有开始真正地处理.
		// 为了在所有的转换都已经设置好之后开始处理，我们在最后调用:
		ssc.start()                      // 开始计算
		ssc.awaitTermination()     // 等待计算被中断
	}


}
