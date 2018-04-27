## reduceByKey  
  
#### 功能  
```
Spark RDD reduceByKey function merges the values for each key   
using an associative reduce function.  
Spark的RDD的reduceByKey是使用一个相关的函数，来合并每个key的value的值的一个算子。  
（reduceByKey是个算子/函数）。
```
reduceByKey的作用域是key-value类型的键值对，并且是只对每个key的value进行处理，  
如果含有多个key的话，那么就对多个values进行处理。  
这里的函数是我们自己传入的，也就是说是可人为控制的。

#### 例子
```
scala> val x = sc.parallelize(Array(("a", 1), ("b", 1), ("a", 1),  
     | ("a", 1), ("b", 1), ("b", 1),  
     | ("b", 1), ("b", 1)), 3)  // 此处表示分区数为3
```
此处创建了一个Array的字符串，并把其存入spark的集群上，设置了三个分区【这里我们不关注分区，只关注操作】。  
调用reduceByKey并且传入函数进行相应操作【对相同key的value进行相加操作，类似于统计单词出现次数】：
```
scala> val y = x.reduceByKey((pre, after) => (pre + after))
```

Basically reduceByKey function works only for RDDs which contains key and value pairs kind of  
 elements(i.e RDDs having tuple or Map as a data element). It is a transformation operation   
which means it is lazily evaluated.We need to pass one associative function as a parameter,   
which will be applied to the source RDD and will create anew RDD as with resulting values(i.e.  
key value pair). This operation is a wide operation as data shuffling may happen across the   
partitions.  【本质上来讲，reduceByKey函数（说算子也可以）只作用于包含key-value的RDDS上，它是  
transformation类型的算子，这也就意味着它是懒加载的（就是说不调用Action的方法，是不会去计算的  
）,在使用时，我们需要传递一个相关的函数作为参数，这个函数将会被应用到源RDD上并且创建一个新的  
RDD作为返回结果，这个算子作为data Shuffling 在分区的时候被广泛使用】  