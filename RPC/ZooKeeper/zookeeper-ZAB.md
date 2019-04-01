## Zookeeper-ZAB

> Zookeeper采用ZAB(Zookeeper Atomic Broadcast)协议来保证分布式数据一致性。ZAB并不是一种通用的分布式一致性算法,而是一种专为Zookeeper设计的崩溃可恢复的原子消息广播算法。ZAB协议包括两种基本模式:崩溃恢复模式和消息广播模式。崩溃恢复模式主要用来在集群启动过程,或者Leader服务器崩溃退出后进行新的Leader服务器的选举以及数据同步;消息广播模式主要用来进行事务请求的处理。

其他的一致性算法还有Paxos 和 Raft

### ZAB主要解决的问题

ZooKeeper 集群崩溃恢复，以及主从同步数据问题。


### ZAB协议定义的三种节点状态

Looking： 选举状态

Following： Follower从节点所处的状态

Leading： Leader主节点所处的状态

### ZXID

最大ZXID也就是节点本地的最新事务编号，包含epoch和计数两部分。epoch是纪元的意思，相当于Raft算法选主时候的term。




Zab协议既不是强一致性，也不是弱一致性，而是处于两者之间的单调一致性。它依靠事务ID和版本号，保证了数据的更新和读取是有序的。



https://juejin.im/post/5b037d5c518825426e024473

https://segmentfault.com/a/1190000016349824