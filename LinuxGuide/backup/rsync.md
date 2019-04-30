##  rsync





```shell
$ rsync -av source_path destination_path

#-a 表示要进行归档
#-v 表示在stdout上打印出细节信息或进度
#路径可以是本地 也可以是远程


$ rsync -av /home/test/ /home/backups
#这条命令将源目录(/home/test)中的内容(不包括目录本身)复制到现有的backups 目录中。

$ rsync -av /home/test /home/backups
#这条命令将包括源目录本身(/home/test)在内的内容复制到新创建的目录backups中。

#以下命令复制test目录到目的端目录中:
$ rsync -av /home/test /home/backups/
$ rsync -av /home/test /home/backups
#如果在destination_path末尾使用/，那么rsync会将来自源端的内容复制到目的端目录中。 
#如果没有使用/，rsync会在目的端路径尾部创建一个同名目录，然后将源端内容复制到这个目录中。

#通过网络进行传输时，压缩数据能够明显改善传输效率。我们可以用rsync的选项 -z 指定在网络传输时压缩数据。例如:
$ rsync -avz source destination

$ rsync -avz SOURCE DESTINATION --delete
#在更新rsync备份时，删除不存在的文件
```

