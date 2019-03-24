## 安装zookeeper

#### 下载

``` shell
wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" 
"http://mirrors.shu.edu.cn/apache/zookeeper/zookeeper-3.4.13/zookeeper-3.4.13.tar.gz"

tar zxvf zookeeper-3.4.13.tar.gz /合适的目录
```

#### 配置环境变量
```
# ~/.bashrc
export ZOOKEEPER_HOME=/home/xu/coding-soft-ware/zookeeper-3.4.13
export  PATH=$ZOOKEEPER_HOME/bin:$PATH
```