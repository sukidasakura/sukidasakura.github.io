## Mysql基本命令

https://blog.csdn.net/hello_zhou/article/details/51864566

####连接MySql  
    1、连接到本机上的mysql  
    mysql -u root -p  
      
    2、连接到远程主机上的mysql  
    远程主机的IP为：110.110.110.110，用户名为root,密码为abcd123。  
    mysql -h110.110.110.110 -u root -p 123;


####操作技巧
    1、如果你打命令时，回车后发现忘记加分号，你无须重打一遍命令，只要打个分号回车就可以了。  
    也就是说你可以把一个完整的命令分成几行来打，完后用分号作结束标志就OK。  
      
    2、你可以使用光标上下键调出以前的命令。


####对数据库的操作
    1、显示当前数据库服务器中的数据库列表：
    mysql> SHOW DATABASES;
    注意：mysql库里面有MYSQL的系统信息，我们改密码和新增用户，实际上就是用这个库进行操作。
      
    2、显示数据库中的数据表：
    mysql> USE 库名；
    mysql> SHOW TABLES;
      
    3、显示use的数据库名：
    mysql> SELECT DATABASE();
      
    4、建立数据库：
    mysql> CREATE DATABASE 库名;
      
    5、删除数据库：
    mysql> DROP DATABASE 库名;
      
    6、导入.sql文件命令：
    mysql> USE 数据库名;
    mysql> SOURCE d:/mysql.sql;
    也可以在DOS环境下键入以下命令进行导入：
    mysql -uroot -proot databasename < databasename.sql
    注意：导入前请保证mysql中必须有databasename这个数据库;
    
####对表的操作

    1、显示数据表的结构：
    mysql> DESCRIBE 表名; （DESC 表名）
      
    2、建立数据表：
    mysql> USE 库名; //进入数据库
    mysql> CREATE TABLE 表名 (字段名 VARCHAR(20), 字段名 CHAR(1));
      
    3、删除数据表：
    mysql> DROP TABLE 表名；
      
    4、重命名数据表
    alter table t1 rename t2;
      
    5、显示表中的记录：
    mysql> SELECT * FROM 表名;
      
    6、往表中插入记录：
    mysql> INSERT INTO 表名 VALUES (”hyq”,”M”);
      
    7、更新表中数据：
    mysql-> UPDATE 表名 SET 字段名1=’a',字段名2=’b’ WHERE 字段名3=’c';
      
    8、将表中记录清空：
    mysql> DELETE FROM 表名;
      
    9、用文本方式将数据装入数据表中：
    mysql> LOAD DATA LOCAL INFILE “D:/mysql.txt” INTO TABLE 表名;
      
    10、 显示表的定义，还可以看到表的约束，例如外键
    mysql> SHOW CREATE TABLE yourtablename   ; 
    还可以通过 mysqldump 将表的完整定义转储到文件中，当然包括外键定义。     
      
    还可以通过下面的指令列出表 T 的外键约束：     
    mysql> SHOW TABLE STATUS FROM yourdatabasename LIKE 'T'   
    外键约束将会在表注释中列出。
      
    [存储过程]
      
    11、创建存储过程
    CREATE PROCEDURE procedureName (in paramentName type, in paramentName type,……)
    BEGIN
    SQL sentences;
    END
      
    12、调用存储过程
    mysql> CALL procedureName(paramentList);
    例：mysql> CALL addMoney(12, 500);
      
    13、查看特定数据库的存储过程
    方法一：mysql> SELECT `name` FROM mysql.proc WHERE db = 'your_db_name' AND `type` = 'PROCEDURE';
    方法二：mysql> show procedure status;
      
    14、删除存储过程
    mysql> DROP PROCEDURE procedure_name;
    mysql> DROP PROCEDURE IF EXISTS procedure_name;
      
    15、查看指定的存储过程定义
    mysql> SHOW CREATE PROCEDURE proc_name;
    mysql> SHOW CREATE FUNCTION func_name;
    ---------- 示例一-----------
    mysql> DELIMITER [Math Processing Error]   //选择数据库
    mysql> DROP PROCEDURE IF EXISTS `addMoney`[Math Processing Error]
    mysql> END$$   //终止
    mysql> DELIMITER ;    //把分割符改回分号";"
    mysql> call addMoney(5,1000); //执行存储过程
    ---------- 示例二-----------
    mysql> delimiter // 
    mysql> create procedure proc_name (in parameter integer) 
    mysql> begin 
    mysql> if parameter=0 then 
    mysql> select * from user order by id asc; 
    mysql> else 
    mysql> select * from user order by id desc; 
    mysql> end if; 
    mysql> end; 
    mysql> //        //此处“//”为终止符
    mysql> delimiter ; 
    mysql> show warnings; 
    mysql> call proc_name(1); 
    mysql> call proc_name(0);