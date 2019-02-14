# ls

显示目录内容列表

### 补充说明

**ls命令** 用来显示目标列表，在Linux中是使用率较高的命令。ls命令的输出信息可以进行彩色加亮显示，以分区不同类型的文件。

### 语法

```
ls（选项）（参数）
```



### 选项

```
-a, --all               不隐藏任何以. 开始的项目
-A, --almost-all        列出除. 及.. 以外的任何项目
    --author            与-l 同时使用时列出每个文件的作者
-d, --directory         list directories themselves, not their contents
-l                      使用较长格式列出信息
-t                      sort by modification time, newest first
-r, --reverse           逆序排列
-R, --recursive         递归显示子目录
-s, --size              以块数形式显示每个文件分配的尺寸
-S                      sort by file size
```







```shell
$  ls /usr  #指定别的目录
```

