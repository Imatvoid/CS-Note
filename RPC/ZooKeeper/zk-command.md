# zk 命令行

## 常见命令



### zkCli.sh

```
$sh bin/zkServer.sh start   启动ZK服务 
$sh bin/zkServer.sh status  查看ZK服务状态
$sh bin/zkServer.sh stop    停止ZK服务
$sh bin/zkServer.sh restart 重启ZK服务

$sh bin/zkCli.sh -server 127.0.0.1:2181 连接到本机

```

https://blog.csdn.net/u012152619/article/details/52931409




### ls 与 ls2

ls 查看节点路径

ls2 查看数据的状态信息 ls + stat

``` 

cZxid Zookeeper为节点分配的Id

cTime 节点创建时间

mZxid 修改后的id

mtime 修改时间

pZxid 子节点id

cversion 子节点的version

dataVersion 当前节点数据的版本号

aclVersion 权限Version

dataLength 数据长度

numChildren  子节点个数

```

### get 获取数据


### exist



stat path [watch]

	set path data [version]
	
	ls path [watch]
	
	delquota [-n|-b] path
	
	ls2 path [watch]
	
	setAcl path acl
	
	setquota -n|-b val path
	
	history
	
	redo cmdno
	
	printwatches on|off


###	delete path [version]

	sync path


​	
​	listquota path
​	
	rmr path
	
	get path [watch]

###	create [-s] [-e] path data acl

	-e  临时节点  
	
	-s  顺序节点
	
	addauth scheme auth
	
	quit
	
	getAcl path
	
	close
	
	connect host:port

### watcher专题

ls path [watch]

ls2 path [watch]

get path [watch]



​	