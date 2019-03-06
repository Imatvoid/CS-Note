##  ServerAndClientByOldJavaIO


### 一个连接开启一个线程。

Server端

```java
public class IOServer {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8000);

        // (1) 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // (1) 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // (2) 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while (true) {
                                int len;
                                // (3) 按字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            }
                        } catch (IOException e) {
                        }
                    }).start();

                } catch (IOException e) {
                }

            }
        }).start();
    }
}

```


Client端 
```java
public class IOClient {

    public static void main(String[] args) {
        new Thread(() -> {
            try {

                Socket socket = new Socket("127.0.0.1", 8000);
                while (true){
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("hello server".getBytes());
                    outputStream.flush();
                    Thread.sleep(2000);
                }


            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {

            }
        }).start();


    }


}
```
