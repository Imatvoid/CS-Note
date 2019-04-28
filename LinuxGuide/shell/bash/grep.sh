#!/bin/bash

text="abcdkajslghiuweyna,mdn,sam\ng,dsn,mnabc,sd"
echo -e $text
# -i 忽略大小写
echo $text | grep -E "[a-z]+" --color


echo ----------- grep line count----------------
echo $text |grep -c "abc" 
echo -e $text |grep -c "abc" 

# egrep -o 只输出符合regex的字符串
# word count单词的缩写 wc -l 以行统计
echo ------------grep count---------------------
#echo -e "1 2 3 4\nhello\n5 6" | egrep -o "[0-9]"|wc -l | sed 's/ //g'
echo -e "1 2 3 4\nhello\n5 6" | egrep -o "[0-9]"|wc -l | awk '{print $1}'

echo ------------grep -b -o---------------------

echo -e "1 2 3 4\nhello\n5 6" | egrep -n -b -o "[0-9]"

echo ------------grep -l------------------------
echo -e "1 2 3 4\nhello\n5 6" | egrep -l "[0-9]"
#和-l相反的选项是-L，它会返回一个不匹配的文件列表

echo ------------grep in dir------------------------
grep "text" . -R -n


echo ------------grep multi pattern-----------------
# grep是按行匹配的
echo -e "1 2 3 4\nhello\n5 6" | grep -e "1" -e "4"


#--include *.{c,cpp}

#-exclude "README"

#-exclude-dir


# -A after
# -B before
# -C all







