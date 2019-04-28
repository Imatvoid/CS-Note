#!/bin/bash

# awk是一款设计用于数据流的工具。它颇有玩头的原因就在于可以对列和行进行操作。
# awk 有很多内建的功能，比如数组、函数等，这是它和C语言的相同之处。灵活性是awk最大的 优势。


#awk ' BEGIN{  print "start" } pattern { commands } END{ print "end" } file

echo ----------"awk first"------------
#awk 'BEGIN { i=0 } { i++ } END{ print i}'  out.txt
echo ----------"awk 1"------------
echo -e "line1\nline2" | awk 'BEGIN{ print "Start" } { print } END{ print "End" } '
echo ----------"awk 2"------------
echo | awk '{ var1="v1"; var2="v2"; var3="v3"; \
    print var1,var2,var3 ; }'

echo ----------"awk 3"------------
echo -e "line1 f2 f3\nline2 f4 f5\nline3 f6 f7" | \
awk '{ \
    print "Line no:"NR",No of fields:"NF, "$0="$0, "$1="$1,"$2="$2,"$3="$3 \
    }'    



  # 再来看awk的一些基本用法。打印每一行的第2和第3个字段: 
  # awk '{ print $3,$2 }' file
echo ----------"awk count lines"------------
  # 要统计文件中的行数，使用下面的命令:
 awk 'END{ print NR }' ./ps.sh

#  NR:表示记录数量，在执行过程中对应于当前行号。
#  NF:表示字段数量，在执行过程中对应于当前行的字段数。
#  $0:这个变量包含执行过程中当前行的文本内容。
#  $1:这个变量包含第一个字段的文本内容。 
#  $2:这个变量包含第二个字段的文本内容。

echo ----------"awk print external VARIABLE "------------
VAR=10000
echo | awk -v VARIABLE=$VAR '{ print VARIABLE }'


var1="Variable1" ; var2="Variable2"
echo | awk '{ print v1,v2 }' v1=$var1 v2=$var2 

#  awk '{ print v1,v2 }' v1=$var1 v2=$var2 filename

echo ----------"awk get line"------------
seq 5 | awk 'BEGIN { getline ; print "Read ahead first line", $0 } { print $0 }' 
