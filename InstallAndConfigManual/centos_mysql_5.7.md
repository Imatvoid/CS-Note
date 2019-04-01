###  Mysql安装



环境**  centos 7.5

**安装软件**  mysql **版本** 5.7

##### 下载安装源

MySQL安装源 https://dev.mysql.com/downloads/repo/yum/

版本号:mysql80-community-release-el7-1.noarch.rpm

The repository packages available below will provide MySQL Server 8.0 by default. Other versions can be obtained by editing the repo setup file installed by the package. See the [Quick Guide to Using the MySQL Yum Repository](https://dev.mysql.com/doc/mysql-yum-repo-quick-guide/en/) for details.

```powershell
$wget 'https://dev.mysql.com/get/mysql80-community-release-el7-1.noarch.rpm'

```

##### 改变版本

```shell
$sudo rpm -Uvh mysql57-community-release-el7-11.noarch.rpm  #升级软件包

$yum repolist all | grep mysql  #查看所有软件包

$vim /etc/yum.repos.d/mysql-community.repo  #更改版本

# Enable to use MySQL 5.7
[mysql57-community]
name=MySQL 5.7 Community Server
baseurl=http://repo.mysql.com/yum/mysql-5.7-community/el/7/$basearch/
enabled=0
gpgcheck=1
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-mysql

# default
[mysql80-community]
name=MySQL 8.0 Community Server
baseurl=http://repo.mysql.com/yum/mysql-8.0-community/el/7/$basearch/
enabled=1
gpgcheck=1
gpgkey=file:///etc/pki/rpm-gpg/RPM-GPG-KEY-mysql

$yum repolist enabled | grep mysql  #更改版本 查看enable的
mysql-connectors-community/x86_64    MySQL Connectors Community               74
mysql-tools-community/x86_64         MySQL Tools Community                    74
mysql57-community/x86_64             MySQL 5.7 Community Server              307

```



如果想安装最新版本的，直接使用 yum 命令即可

```shell
$sudo yum install mysql-community-server
```



##### 执行安装

```powershell
$sudo yum install mysql-community-server  #中间会有确认GPG key的步骤，输y即可
```

##### 启动mysql

```powershell
$sudo service mysqld start  #启动mysql 服务
EL7-based platforms: $systemctl start mysqld.service

$sudo service mysqld status
EL7-based platforms: $systemctl status mysqld.service
```



##### 配置

```shell
$sudo grep 'temporary password' /var/log/mysqld.log   #查看临时密码
2018-12-12T14:42:44.314585Z 1 [Note] A temporary password is generated for root@localhost: wur)yCBM!5k_

```

Change the root password as soon as possible by logging in with the generated, temporary password and set a custom password for the superuser account:

```terminal
shell> mysql -uroot -p
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'MyNewPass4!';
```

https://dev.mysql.com/doc/mysql-yum-repo-quick-guide/en/

https://www.jianshu.com/p/7cccdaa2d177

