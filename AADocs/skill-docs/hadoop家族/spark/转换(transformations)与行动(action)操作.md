#### transformation操作
得到一个新的RDD，例如从数据源生成一个新的RDD，从RDD生成一个新的RDD
map
filter
flatMap
mapPartitions
union
distinct
groupByKey
reduceByKey
sortByKey
join
....



#### action操作
得到一个值，或者一个结果（直接将RDD cache到内存中）
1. reduce(func)：将RDD中的元素凉凉传递给输入函数，同时产生一个新的值，新产生的值与RDD中下一个元素再被传递给输入函数知道最后只有一个值为止。e.x: c.reduce((x, y) => x + y)
2. collect()：一般在filter或者足够小的结果的时候，再用collect封装返回一个数组。
3. count()
4. first()
5. take(n)
6. saveAsTextFile(path)
7. countByKey()
10. foreach(func)