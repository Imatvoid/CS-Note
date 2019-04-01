## DistributedLock
> 分布式锁

### 工具和资源
```
# set命令 附加参数可以设置过期时间 和NX XX
SET key value EX(秒)|PX（毫秒） max-lock-time  NX(不存在则设置)|XX（存在则设置）

# get+del  使用lua脚本实现命令原子性。


# 返回老值并获取新值
GETSET key value

```
### tip

1.先set（老）/setNx，然后 expire,没有原子性,若设置set/setNx后异常，未执行expire会导致永不过期。

2.lock时候set的value应该是每个客户端唯一的,比如客户端唯一id/currentTime,这样在unlock时候,只会释放自己的锁,不会误释放。

3.关于得到锁后,由于执行时间过长,导致的超时过期释放锁的问题,redis实现的分布式锁很难解决,需考虑其他方案。



