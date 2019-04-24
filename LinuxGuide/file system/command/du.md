## du

>disk usage

````shell
# 找出某个文件(或多个文件)占用的磁盘空间 4K的整数倍，ll显示的是实际大小，大小B字节
$ du   FILENAME2 ..

4.0K	FILENAME1

# 递归地输出指定目录或多个目录中所有文件的统计结果
#执行du DIRECTORY也可以输出类似的结果，但是它只会显示子目录使用的 磁盘空间，而不显示每个文件占用空间的情况。要想显示文件的磁盘使用情况， 必须使用 -a。
$ du -a DIRECTORY

4	shell/datewho.sh
4	shell/num.sh
4	shell/ifthenelse.sh
4	shell/a.out
4	shell/place.sh
4	shell/testvar.sh
4	shell/testset.sh
32	shell/


#du默认显示文件占用的总字节数，但是以标准单位KB、MB或GB显示磁盘使用情况更方便人们阅读
$ du -h FILENAME
4.0K test/pcpu.sh

du的选项 -c可以输出作为命令参数的所有文件和目录的磁盘使用情况，它会在 输出结果末尾加上一行总计
$ du -c FILENAME1 FILENAME2..
8	findsh.sh
0	monitor/
8	total

$ du  -c DIRECTORY

#另一个选项 -s(summarize，合计)则只输出合计数据。它可以配合 -h打印出人们易读的格式
$ du -s FILES(s)
$ du -sh DIRECTORY
12K	common/


#打印以字节(默认输出)为单位的文件大小: 
$ du -b FILE(s)
#打印以KB为单位的文件大小: 
$ du -k FILE(s)
#打印以MB为单位的文件大小: 
$ du -m FILE(s)
#打印以指定块为单位的文件大小: 其中BLOCK_SIZE以字节为单位。
$ du -B BLOCK_SIZE FILE(s)

````



















