## 远程连接SSH

![1549896868746](/home/deep/.config/Typora/typora-user-images/1549896868746.png)



# ssh-keygen

为ssh生成、管理和转换认证密钥

### 补充说明

**ssh-keygen命令** 用于为“ssh”生成、管理和转换认证密钥，它支持RSA和DSA两种认证密钥。

### 语法

```
ssh-keygen(选项)
```

### 选项

```
-b：指定密钥长度；
-e：读取openssh的私钥或者公钥文件；
-C：添加注释；
-f：指定用来保存密钥的文件名；
-i：读取未加密的ssh-v2兼容的私钥/公钥文件，然后在标准输出设备上显示openssh兼容的私钥/公钥；
-l：显示公钥文件的指纹数据；
-N：提供一个新密语；
-P：提供（旧）密语；
-q：静默模式；
-t：指定要创建的密钥类型。
```







# ssh-copy-id

把本地的ssh公钥文件安装到远程主机对应的账户下

### 补充说明

**ssh-copy-id命令** 可以把本地主机的公钥复制到远程主机的authorized_keys文件上，ssh-copy-id命令也会给远程主机的用户主目录（home）和`~/.ssh`, 和`~/.ssh/authorized_keys`设置合适的权限。

### 语法

```
ssh-copy-id [-i [identity_file]] [user@]machine
```

### 选项

```
-i：指定公钥文件
```

### 实例

1、把本地的ssh公钥文件安装到远程主机对应的账户下：

```shell
ssh-copy-id user@server
ssh-copy-id -i ~/.ssh/id_rsa.pub user@server
```