#### parallelize
调用SparkContext 的 parallelize()，将一个存在的集合，变成一个RDD  
scala版本   
def parallelize[T](seq: Seq[T], numSlices: Int = defaultParallelism)(implicit arg0: ClassTag[T]): RDD[T] 
- 第一个参数一是一个 Seq集合 
- 第二个参数是分区数 
- 返回的是RDD[T]

#### collect
将RDD转成Scala数组，并返回。
函数原型

def collect(): Array[T]
def collect[U: ClassTag](f: PartialFunction[T, U]): RDD[U]

collect函数的定义有两种，我们最常用的是第一个。  
第二个函数需要我们提供一个标准的偏函数，然后保存符合的元素到MappedRDD中。

#### 打印spark rdd中的内容
2种方式：
1、rdd.collect().foreach {println}
2、rdd.take(10).foreach { println }