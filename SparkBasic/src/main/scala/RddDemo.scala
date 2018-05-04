import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Sydney on 2018/5/4.
  */

/**
  * 有如下数据：第一列表示姓名，第二列表示性别，第三列表示上网时间（单位分钟）
  * 统计女性中上网时间超过2个小时的网民信息
  * InternetTime1.txt
  * LiuYang,female,20
  * YuanJing,male,10
  * GuoYijun,male,5
  * CaiXuyu,female,50
  * Liyuan,male,20
  * FangBo,female,50
  * LiuYang,female,20
  *  YuanJing,male,10
  * GuoYijun,male,50
  * CaiXuyu,female,50
  * FangBo,female,60
  */
object RddDemo {
    def main(args: Array[String]): Unit = {
        // SparkConf包括集群配置的各种参数
        val conf = new SparkConf().setAppName("RddDemo").setMaster("local[*]")
        val sc = new SparkContext(conf)
        // 1, RDD创建，从数据集合中创建
        val dataRdd = sc.parallelize(1 to 5)
        // 累加
        val dataSum = dataRdd.reduce((x, y) => x + y)
        // 遍历打印Rdd
        dataRdd.foreach(println)
        //输出总和
        println(dataSum)

        // 2, RDD创建，从数据源如HDFS 或者本地文件系统创建
        val text = sc.textFile("file:/E:/Documents/Project/InternetTime1.txt")
        val data2 = text.filter(_.contains("female"))
        val femaleData:RDD[(String, Int)] = data2.map{line =>
                val t = line.split(",")
                (t(0), t(2).toInt)
        }.reduceByKey(_ + _) // 同一个网民的上网时间相加

        // 筛选出时间大于两个小时的女性网民信息，并输出
        val result = femaleData.filter(line => line._2 > 40)
        result.foreach(println)
        sc.stop()

    }

}
