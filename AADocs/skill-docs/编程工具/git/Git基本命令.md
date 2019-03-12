## Git基本命令

#### 提交所有变化的文件
git add -u --update 更新所有改变的文件，但不包括被删除的文件
git add -A 提交已被修改和已被删除文件，但是不包括新的文件

#### 撤销所有本地未提交的修改
git clean -df
只删除所有untracked的文件，如果文件已经被tracked，修改过的文件不会被回退。
git reset --hard
把tracked的文件revert到前一个版本，对于untracked的文件都不会被删除。

#### 查看不同
git diff   比较文件
git log -p   比较提交


#### 使用Git下载指定分支

git clone -b 分支名仓库地址
使用Git下载v.2.8.1分支代码：
git clone -b v2.8.1 https://git.oschina.net/oschina/android-app.git


#### 查看依赖
    mvn dependency:tree
    查看依赖中有scala的部分
    mvn dependency:tree | grep scala
#### mvn 打包某一模块的包
    mvn clean install -pl presto-elasticsearch -am -Dmaven.test.skip=true

#### 本地新建项目，推送到远程库
    1，在远程库建立同名的仓库
    2，git remote add origin git@github.com:sukidasakura/FtpTestUtil.git  
      git push -u origin master
    3，idea的配置可以参考：
    https://www.cnblogs.com/jinjiyese153/p/6796668.html


#### 撤销已经从本地版本库推送到远程版本库的内容
    1, 查看历史记录
    git log --pretty  
    2,reset
    git reset --hard <commit hash>，然后push的时候加上-f 强制更新。

#### 放弃本地修改强制下载拉取
    git reset --hard origin/master
    git pull origin/master

#### push时为本地当前分支设置upstream
    git push --set-upstream origin ceph

#### 同步dev分支的代码到远程服务器
    git push origin dev:dev  这样远程仓库也有一个dev分支了

#### 远程仓库
    git remote -v  查看远程仓库  
    git remote add [shortname] [url]   添加远程仓库  
    git remote rm origin  删除远程库

#### 分支相关
    git branch --all  查看所有分支  
    git checkout local_branch 切换分支
    git branch dev  创建本地分支
    git checkout -b local_branch 创建本地分支local_branch 并切换到local_branch分支  
    git branch -D br  删除本地分支  
    git push origin [空格]:[我的分支名字]  (origin 后面有空格)  删除远程分支

#### 添加别人的远程库分支，命名为upstream
    git remote add upstream https://github.com/XXXX/RealTimeFaceCompare.  
    从该分支拉取ceph分支  
    git fetch upstream ceph:ceph  
    切换到ceph分支  
    git checkout ceph  

#### 从远程获取最新版本并merge到本地
    git pull origin master
     
    这个命令相当于以下两条
    git fetch origin master 相当于是从远程获取最新版本到本地，不会自动merge  
    git merge origin/master

#### 基础命令
    git status  
    git add --all  把更新的代码同步到本地的版本库  
    git commit -m "此次提交的备注信息"  把更新代码同步到本地的当前分支  
    git push origin master  把更新代码推送到远程分支  