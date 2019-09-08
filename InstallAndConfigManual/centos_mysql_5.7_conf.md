### Mysql配置



##### 查看端口

```mysql
$ netstat -tlpn | grep mysql
tcp6       0      0 :::3306          :::*            LISTEN      796/mysqld  
mysql>  show global variables like 'port';
+---------------+-------+
| Variable_name | Value |
+---------------+-------+
| port          | 3306  |
+---------------+-------+
1 row in set (0.00 sec)
```



##### 配置文件

```bash
$sudo vim /etc/my.cnf
[mysqld]
port = 13006
:wq
$systemctl restart mysqld.service

```

##### Mysql文件目录

- `/etc/my.cnf` 这是mysql的主配置文件
- `/var/lib/mysql` mysql数据库的数据库文件存放位置
- `/var/log mysql` 数据库的日志输出存放位置



##### 配置数据库和用户（5.7 默认禁用了root用户的远程连接）

```mysql
mysql> CREATE DATABASE datebasename CHARACTER SET utf8; #创建数据库
mysql> CREATE USER 'username'@'host' IDENTIFIED BY 'password';  #创建用户
mysql> GRANT ALL PRIVILEGES ON databasename.tablename TO 'username'@'host';
#privileges：用户的操作权限，如 SELECT，INSERT，UPDATE 等，如果要授予所的权限则使用ALL
mysql> SHOW GRANTS FOR 'username'@'host';
mysql> REVOKE privilege ON databasename.tablename FROM 'username'@'host';
mysql> DROP USER 'username'@'host';

```



- username：你将创建的用户名
- host：指定该用户在哪个主机上可以登陆，如果是本地用户可用 localhost，如果想让该用户可以从任意远程主机登陆，可以使用通配符 %
- password：该用户的登陆密码，密码可以为空，如果为空则该用户可以不需要密码登陆服务器
- privileges：用户的操作权限，如 SELECT，INSERT，UPDATE 等，如果要授予所的权限则使用ALL
- databasename：数据库名
- tablename：表名，如果要授予该用户对所有数据库和表的相应操作权限则可用 * 表示，如 *.*









https://www.jianshu.com/p/18b01006d336

