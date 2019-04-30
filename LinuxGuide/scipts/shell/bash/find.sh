#!/bin/bash


# 目录所有文件
#echo `find .`


#print 指明打印出匹配文件的文件名(路径)。当使用 -print 时, '\n' 作为用于对输出的文件名进行分隔。就算你忽略 -print , find 命令仍会打印出文件名。
echo ----------find    -----------------

echo `find . -print`
#-print0 指明使用 '\0' 作为匹配的文件名之间的定界符。当文件名中包含换行符时,这个方法就有用武之地了。
#echo `find . -print0`

echo ----------find *.sh-----------------
echo `find . -name "*.sh" -print`  # 忽略大小写 echo `find . -iname "*.sh" -print`

echo ----------find or-----------------

echo `find . \( -name "f*.sh" -o -name "a*.sh" \) -print`


echo ----------find path-----------------

echo `find . -path "*/dir1/*" -print`

echo ----------find regex-----------------

echo `find . -regex ".*\(\.py\|\.sh\)$"` # find . -iregex ".*\(\.py\|\.sh\)$"


echo ----------find ! *.sh-----------------
echo `find . ! -name "*.sh" -print`


echo ----------find depth-----------------
echo `find . -maxdepth 1 -name "f*" -print`

echo `find . -mindepth 2 -name "*f*" -print`


echo ----------find by type-----------------

echo  dir: `find . -type d -print`

echo  file: `find . -type f -print`

echo linkfile: `find . -type l -print`

echo ----------find by time-----------------
#访问时间( -atime ) 用户最近一次访问文件的时间。
#修改时间( -mtime ) 文件内容最后一次被修改的时间。
#变化时间( -ctime ) 文件元数据(例如权限或所有权)最后一次改变的时间。
#计量单位是“天”
echo 7天内被访问过的文件: `find . -type f -atime -7 -print`
echo 打印出访问时间超过7天的所有文件: `find . -type f -atime +7 -print`


#访问时间( -amin ) 用户最近一次访问文件的时间。
#修改时间( -mmin ) 文件内容最后一次被修改的时间。
#变化时间( -cmin ) 文件元数据(例如权限或所有权)最后一次改变的时间。
echo 打印出访问时间超过7分钟的所有文件: `find . -type f -amin +7 -print`


echo 比alias.sh修改时间更近的所有文件: `find . -type f -newer alias.sh -print`


echo ----------find by size-----------------

echo 大于2KB的文件: `find . -type f -size +2k`

echo 小于2KB的文件: `find . -type f -size -2k`

echo 等于2KB的文件: `find . -type f -size 2k`
#b —— 块(512字节)
#c —— 字节。
#w —— 字(2字节)
#k —— 1024字节。
#M —— 1024K字节。
#G —— 1024M字节。

echo  ----------find by perm-----------------

echo 打印出权限为764的文件: `find . -type f -perm 764 -print`

echo ----------find and rm----------------- 
#find . -type f -name "*.swp" -delete
#



echo ----------find by user----------------- 
echo 打印出用户atvoid拥有的所有文件: `find . -type f -user atvoid -print`


echo ----------find by exec----------------- # find 命令可以借助选项 -exec 与其他命名进行结合。 -exec 算得上是 find 最强大的特性之一。
#echo `find . -type f -user root -exec chown slynux {} \;`
#有时候我们并不希望对每个文件都执行一次命令。我们更希望使用文件列表作为命令参数,这样就可以少运行几次命令了。如果是这样,可以在 exec 中使
#用 + 来代替 ; 。

find . -type f -name "*.sh" -exec cat {} \;>all_sh_files.txt

# 我们无法在 -exec 参数中直接使用多个命令。它只能够接受单个命令,不过
#我们可以耍一个小花招。把多个命令写到一个shell脚本中(例如 command.sh ),然
#后在 -exec 中使用这个脚本:


find . -type f -name "*.sh" -exec printf "sh file: %s\n" {} \;


echo ----------find ignore-----------------
echo `find . \( -name ".git" -prune \) -o \( -type f -print \)`





























