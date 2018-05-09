mvn dependency:lis
不是编译，只是列出列出依赖项。  

一般你mvn install 的生命周期是 mvn compile  mvn test  mvn package,  最后才是install
而mvn package 是经过 compile test package
这三个过程。
install 你可以看具体打印的值， 把package 好的jar 包，安装到你的本地maven 仓库。
看一下打印日记。