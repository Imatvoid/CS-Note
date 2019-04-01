## Leader-Election

### 发生的时机

- 服务器初始化启动。

- 服务器运行期间无法和Leader保持连接。


### 集群中已存在Leader
   
对于集群中已经存在Leader而言，此种情况一般都是某台机器启动得较晚，在其启动之前，

集群已经在正常工作，对这种情况，该机器试图去选举Leader时，会被告知当前服务器的Leader信息，对于该机器而言，仅仅需要和Leader机器建立起连接，并进行状态同步即可。
   
   
   
### 集群中不存在Leader



https://juejin.im/post/5b03d58a6fb9a07a9e4d8f01



    


