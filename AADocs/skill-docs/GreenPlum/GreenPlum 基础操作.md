## GreenPlum基础操作

#### 启动gp
gpstart

#### 重启gp
gpstop -r

#### 不重启数据库，reload配置文件
gpstop -u

#### 停止gp
gpstop
该命令等待所有事务完成后才进行停止

#### 快速停止gp
gpstop -M fast

#### 显示Greenplum数据库运行状态，详细配置等信息
gpstate