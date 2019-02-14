## 目录文件查找find

![1549896323310](assets/1549896323310.png)

```shell
$ find .  -type f #当前目录 查找文件

$ find .  -type f  | grep a.txt #当前目录 查找文件

$ find .  -type d #当前目录 查找目录



$ find .  -type f -exec ls -l '{}' ';' #当前目录 查找文件


```

