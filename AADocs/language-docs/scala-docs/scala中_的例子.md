## 例子。
```
scala 中map(_._2) 和map(_._2, _)什么意思？  
map(_._2) 等价于 map(t => t._2) //t是个2项以上的元组  
map(_._2, _) 等价与 map(t => t._2, t) //这会返回第二项为首后面项为旧元组的新元组  
._n 为获取元组第n项_ 则为eta-conversion (lambda表达式支持的一种变换 )的入参缩写形式，  
scala里 a => foo(a) 经过eta-conversion后，直接就是右边的函数名foo，缩写为foo(_)，  
这里t => t._2 (lambda表达式 ) 可直接写成 _._2
```