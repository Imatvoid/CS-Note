## centos_or_other_linux_java_8.md


#### 下载
``` shell

# 错误
wget https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.tar.gz


wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" 

"https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.tar.gz"


tar zxvf jdk-8u201-linux-x64.tar.gz


```

#### 配置环境变量
```
# ~/.bachrc
export JAVA_HOME=/home/xxx/coding-soft-ware/jdk1.8.0_201
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=.:$JAVA_HOME/bin:$PATH
```

https://tecadmin.net/install-java-8-on-centos-rhel-and-fedora/#
