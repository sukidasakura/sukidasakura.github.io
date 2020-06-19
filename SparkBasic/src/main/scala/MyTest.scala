import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object MyTest {
  def main(args: Array[String]): Unit = {
    /**
      * 本地运行master设置为
      */
    val conf = new SparkConf().setAppName("wordCount").setMaster("local[*]")

    val sparkContext = new SparkContext(conf)

    val lines:RDD[String] =sparkContext.textFile(path = "G:/writeFile.txt",minPartitions = 1)

    val data=lines.flatMap(_.split(" "))

    val  mappedData = data.map((_,1))

    val reduceData =mappedData.reduceByKey(_ + _)

    var sortedData = reduceData.sortBy(_._2,false)

    var result= sortedData.collect()

    println(result.toBuffer)
  }
}
