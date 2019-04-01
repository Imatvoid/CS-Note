## ZooKeeper-watcher

> Zookeeper中可以通过Watcher来实现事件监听机制。客户端可以向服务端注册Watcher用以监听某些事件,一旦该事件发生,服务端即会向客户端发送一个通知。其主要工作流程如下图所示

![](assets/ZooKeeper-watcher_images/4bfe78fe.png)


watcher都是一次性的，可以通过第三方包实现永久性的watcher


### watcher 事件类型

NodeCreated 创建


https://www.cnblogs.com/takumicx/p/9508706.html
