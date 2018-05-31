##  在linux上安装idea并使用
    1、登录到172.18.18.179
    2、拷贝以下三个文件到相应目录，并解压
    ① cd /root
    root.IdeaIC2017.2
    ② cd /root
    ll -al
    .m2.tar.gz
    ③ cd /home/steve.shencai.ma/
    tool.tar.gz
    
    3、配置环境变量
    vim /root/.bashrc
    
    
    # .bashrc
    
    # User specific aliases and functions
    
    alias rm='rm -i'
    alias cp='cp -i'
    alias mv='mv -i'
    
    # Source global definitions
    if [ -f /etc/bashrc ]; then
            . /etc/bashrc
    fi
    
    alias ..='cd ..'
    alias ...='cd ../../'
    alias idea='idea.sh'
    
    export JAVA_HOME=/home/steve.shencai.ma/tool/jdk
    export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH
    
    export MVN_HOME=/home/steve.shencai.ma/tool/maven
    export PATH=$MVN_HOME/bin:$PATH
    
    export IDEA_HOME=/home/steve.shencai.ma/tool/idea
    export PATH=$IDEA_HOME/bin:$PATH
    
    export SCALA_HOME=/home/steve.shencai.ma/tool/scala
    export PATH=$SCALA_HOME/bin:$PATH
    
    export SBT_HOME=/home/steve.shencai.ma/tool/sbt
    export PATH=$SBT_HOME/bin:$PATH
    
    
    4、安装git
    yum install git
    
    配置git的用户名
    $ git config --global user.name "John Doe"
    $ git config --global user.email johndoe@example.com
    
    5、启动idea：执行idea
    需要在Project Structure里设置一下JDK
