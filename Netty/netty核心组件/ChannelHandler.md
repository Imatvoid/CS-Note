# ChannelHandler

## 介绍

ChannelHandler是一个接口，处理I/O事件或拦截I/O操作，并将其转发到其ChannelPipeline(业务处理链)中的下一个处理程序。

ChannelHandler本身并没有提供很多方法，因为这个接口有许多的方法需要实现，方便使用期间，可以继承它的子类：

- ChannelInboundHandler用于处理入站I/O事件
- ChannelOutboundHandler用于处理出站I/O操作

或者使用以下适配器类：

- ChannelInboundHandlerAdapter用于处理入站I/O事件
- ChannelOutboundHandlerAdapter用于处理出站I/O操作
- ChannelDuplexHandler用于处理入站和出站事件



## 事件驱动

ChannelHandler充当了处理入站和出站数据的应用程序逻辑的容器，该类是基于事件驱动的，它会响应相关的事件然后去调用其关联的回调函数，例如当一个新的连接被建立时，ChannelHandler的channelActive()方法将会被调用。

关于入站消息和出站消息的数据流向定义，如果以客户端为主视角来说的话，那么从客户端流向服务器的数据被称为出站，反之为入站。

入站事件是可能被入站数据或者相关的状态更改而触发的事件，包括：连接已被激活、连接失活、读取入站数据、用户事件、发生异常等。

出站事件是未来将会触发的某个动作的结果的事件，这些动作包括：打开或关闭远程节点的连接、将数据写（或冲刷）到套接字。

ChannelHandler的主要用途包括：

- 对入站与出站数据的业务逻辑处理
- 记录日志
- 将数据从一种格式转换为另一种格式，实现编解码器。以一次HTTP协议（或者其他应用层协议）的流程为例，数据在网络传输时的单位为字节，当客户端发送请求到服务器时，服务器需要通过解码器（处理入站消息）将字节解码为协议的消息内容，服务器在发送响应的时候（处理出站消息），还需要通过编码器将消息内容编码为字节。
- 捕获异常
- 提供Channel生命周期内的通知，如Channel活动时与非活动时

ChannelHandler接口定义了对它生命周期进行监听的回调函数，在ChannelHandler被添加到ChannelPipeline或者被移除时都会调用这些函数。

```java
package io.netty.channel;

public interface ChannelHandler {
    void handlerAdded(ChannelHandlerContext var1) throws Exception;

    void handlerRemoved(ChannelHandlerContext var1) throws Exception;

    /** @deprecated */
    @Deprecated
    void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception;
	
	// 该注解表明这个ChannelHandler可被其他线程复用
    @Inherited
    @Documented
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Sharable {
    }
}

```



入站消息与出站消息由其对应的接口`ChannelInboundHandler`与`ChannelOutboundHandler`负责，这两个接口定义了监听Channel的生命周期的状态改变事件的回调函数。

```java
package io.netty.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

public interface ChannelInboundHandler extends ChannelHandler {
	// 当channel被注册到EventLoop时被调用
    void channelRegistered(ChannelHandlerContext var1) throws Exception;
	
	// 当channel已经被创建，但还未注册到EventLoop（或者从EventLoop中注销）被调用
    void channelUnregistered(ChannelHandlerContext var1) throws Exception;
	
	// 当channel处于活动状态（连接到远程节点）被调用
    void channelActive(ChannelHandlerContext var1) throws Exception;

	// 当channel处于非活动状态（没有连接到远程节点）被调用
    void channelInactive(ChannelHandlerContext var1) throws Exception;
	
	// 当从channel读取数据时被调用
    void channelRead(ChannelHandlerContext var1, Object var2) throws Exception;
	
	// 当channel的上一个读操作完成时被调用
    void channelReadComplete(ChannelHandlerContext var1) throws Exception;
	
	// 当ChannelInboundHandler.fireUserEventTriggered()方法被调用时被调用
    void userEventTriggered(ChannelHandlerContext var1, Object var2) throws Exception;
	
	// 当channel的可写状态发生改变时被调用
    void channelWritabilityChanged(ChannelHandlerContext var1) throws Exception;
	
	// 当处理过程中发生异常时被调用
    void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception;
}

package io.netty.channel;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import java.net.SocketAddress;

public interface ChannelOutboundHandler extends ChannelHandler {

	// 当请求将Channel绑定到一个地址时被调用
	// ChannelPromise是ChannelFuture的一个子接口，定义了如setSuccess(),setFailure()等方法
    void bind(ChannelHandlerContext var1, SocketAddress var2, ChannelPromise var3) throws Exception;
	
	// 当请求将Channel连接到远程节点时被调用
    void connect(ChannelHandlerContext var1, SocketAddress var2, SocketAddress var3, ChannelPromise var4) throws Exception;
	
	// 当请求将Channel从远程节点断开时被调用
    void disconnect(ChannelHandlerContext var1, ChannelPromise var2) throws Exception;

	// 当请求关闭Channel时被调用
    void close(ChannelHandlerContext var1, ChannelPromise var2) throws Exception;

	// 当请求将Channel从它的EventLoop中注销时被调用
    void deregister(ChannelHandlerContext var1, ChannelPromise var2) throws Exception;
	
	// 当请求从Channel读取数据时被调用
    void read(ChannelHandlerContext var1) throws Exception;

	// 当请求通过Channel将数据写到远程节点时被调用
    void write(ChannelHandlerContext var1, Object var2, ChannelPromise var3) throws Exception;
	
	// 当请求通过Channel将缓冲中的数据冲刷到远程节点时被调用
    void flush(ChannelHandlerContext var1) throws Exception;
}

```



通过实现ChannelInboundHandler或者ChannelOutboundHandler就可以完成用户自定义的应用逻辑处理程序，不过Netty已经帮你实现了一些基本操作，用户只需要继承并扩展ChannelInboundHandlerAdapter或ChannelOutboundHandlerAdapter来作为自定义实现的起始点。

ChannelInboundHandlerAdapter与ChannelOutboundHandlerAdapter都继承于ChannelHandlerAdapter，该抽象类简单实现了ChannelHandler接口。

``` java
public abstract class ChannelHandlerAdapter implements ChannelHandler {
    boolean added;

    public ChannelHandlerAdapter() {
    }
	
	// 该方法不允许将此ChannelHandler共享复用
    protected void ensureNotSharable() {
        if(this.isSharable()) {
            throw new IllegalStateException("ChannelHandler " + this.getClass().getName() + " is not allowed to be shared");
        }
    }
	
	// 使用反射判断实现类有没有@Sharable注解，以确认该类是否为可共享复用的
    public boolean isSharable() {
        Class clazz = this.getClass();
        Map cache = InternalThreadLocalMap.get().handlerSharableCache();
        Boolean sharable = (Boolean)cache.get(clazz);
        if(sharable == null) {
            sharable = Boolean.valueOf(clazz.isAnnotationPresent(Sharable.class));
            cache.put(clazz, sharable);
        }

        return sharable.booleanValue();
    }

    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
    }

    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}

```

ChannelInboundHandlerAdapter与ChannelOutboundHandlerAdapter默认只是简单地将请求传递给ChannelPipeline中的下一个ChannelHandler，源码如下：

```java
public class ChannelInboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelInboundHandler {
    public ChannelInboundHandlerAdapter() {
    }

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelRegistered();
    }

    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelUnregistered();
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
    }

    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ctx.fireChannelRead(msg);
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelReadComplete();
    }

    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ctx.fireUserEventTriggered(evt);
    }

    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelWritabilityChanged();
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.fireExceptionCaught(cause);
    }
}

public class ChannelOutboundHandlerAdapter extends ChannelHandlerAdapter implements ChannelOutboundHandler {
    public ChannelOutboundHandlerAdapter() {
    }

    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
    }

    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
    }

    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.disconnect(promise);
    }

    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.close(promise);
    }

    public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        ctx.deregister(promise);
    }

    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.read();
    }

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        ctx.write(msg, promise);
    }

    public void flush(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }
}

```



对于处理入站消息，另外一种选择是继承SimpleChannelInboundHandler，它是Netty的一个继承于ChannelInboundHandlerAdapter的抽象类，并在其之上实现了自动释放资源的功能。

我们在了解ByteBuf时就已经知道了Netty使用了一套自己实现的引用计数算法来主动释放资源，假设你的ChannelHandler继承于ChannelInboundHandlerAdapter或ChannelOutboundHandlerAdapter，那么你就有责任去管理你所分配的ByteBuf，一般来说，一个消息对象（ByteBuf）已经被消费（或丢弃）了，并且不会传递给ChannelHandler链中的下一个处理器（如果该消息到达了实际的传输层，那么当它被写入或Channel关闭时，都会被自动释放），那么你就需要去手动释放它。通过一个简单的工具类ReferenceCountUtil的release方法，就可以做到这一点。

```java
// 这个泛型为消息对象的类型
public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean autoRelease;

    protected SimpleChannelInboundHandler() {
        this(true);
    }

    protected SimpleChannelInboundHandler(boolean autoRelease) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = autoRelease;
    }

    protected SimpleChannelInboundHandler(Class<? extends I> inboundMessageType) {
        this(inboundMessageType, true);
    }

    protected SimpleChannelInboundHandler(Class<? extends I> inboundMessageType, boolean autoRelease) {
        this.matcher = TypeParameterMatcher.get(inboundMessageType);
        this.autoRelease = autoRelease;
    }

    public boolean acceptInboundMessage(Object msg) throws Exception {
        return this.matcher.match(msg);
    }
	
	// SimpleChannelInboundHandler只是替你做了ReferenceCountUtil.release()
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        boolean release = true;

        try {
            if(this.acceptInboundMessage(msg)) {
                this.channelRead0(ctx, msg);
            } else {
                release = false;
                ctx.fireChannelRead(msg);
            }
        } finally {
            if(this.autoRelease && release) {
                ReferenceCountUtil.release(msg);
            }

        }

    }
	// 这个方法才是我们需要实现的方法
    protected abstract void channelRead0(ChannelHandlerContext var1, I var2) throws Exception;
}
	
	// ReferenceCountUtil中的源码，release方法对消息对象的类型进行判断然后调用它的release()方法
    public static boolean release(Object msg) {
        return msg instanceof ReferenceCounted?((ReferenceCounted)msg).release():false;
    }

```





## ChannelFuture

Netty中到处都充满了异步与事件驱动，而回调函数正是用于响应事件之后的操作。由于异步会直接返回一个结果，所以Netty提供了ChannelFuture（实现了java.util.concurrent.Future）来作为异步调用返回的占位符，真正的结果会在未来的某个时刻完成，到时候就可以通过ChannelFuture对其进行访问，每个Netty的出站I/O操作都将会返回一个ChannelFuture。

Netty还提供了ChannelFutureListener接口来监听ChannelFuture是否成功，并采取对应的操作。

```java
Channel channel = ...
ChannelFuture future = channel.connect(new InetSocketAddress("192.168.0.1",6666));
// 注册一个监听器
future.addListener(new ChannelFutureListener() {
	@Override
	public void operationComplete(ChannelFuture future) {
		if (future.isSuccess()) {
			// do something....
		} else {
			// 输出错误信息
			Throwable cause = future.cause();
			cause.printStackTrace();
			// do something....
		}
	}
});

```

ChannelFutureListener接口中还提供了几个简单的默认实现，方便我们使用。

```java
package io.netty.channel;

import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.GenericFutureListener;

public interface ChannelFutureListener extends GenericFutureListener<ChannelFuture> {
	// 在Future完成时关闭
    ChannelFutureListener CLOSE = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) {
            future.channel().close();
        }
    };
	// 如果失败则关闭
    ChannelFutureListener CLOSE_ON_FAILURE = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) {
            if(!future.isSuccess()) {
                future.channel().close();
            }

        }
    };
	// 将异常信息传递给下一个ChannelHandler
    ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE = new ChannelFutureListener() {
        public void operationComplete(ChannelFuture future) {
            if(!future.isSuccess()) {
                future.channel().pipeline().fireExceptionCaught(future.cause());
            }

        }
    };
}
```

