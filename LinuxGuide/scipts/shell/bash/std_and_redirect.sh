#!/bin/bash

#在编写脚本的时候会频繁使用标准输入( stdin )、标准输出( stdout )和标准错误
#( stderr )
# 文件描述符
# 0 —— stdin (标准输入)
# 1 —— stdout (标准输出)
# 2 —— stderr (标准错误)


DIRNAME=$( dirname "$0")
DIR=$( cd "$DIRNAME" && pwd)

if [ -f "$DIR/temp.txt" -o -f "$DIR/out.txt" -o -f "$DIR/output.txt"  ];then
    rm -r  "$DIR/temp.txt"
    rm -r  "$DIR/out.txt"
    rm -r  "$DIR/output.txt"
    
fi

echo "This is a sample text 1" > temp.txt
echo "This is sample text 2" >> temp.txt
echo "是否成功：$? 0=成功"

#127	"command not found"	 	估计是$PATH不对, 或者是拼写错误
#cmd > output.txt 2>&1 
echo "是否成功：$?  127=command not found"
cmd 2>&1 | tee output.txt


# 错误重定向 
ls + 2> out.txt #正常运行
echo "是否成功：$? 2=严重错误"
#https://unix.stackexchange.com/questions/477390/ls-error-code-2



# 覆盖模式
cat<<EOF>log.txt
LOG FILE HEADER
This is a test log file
Function: System statistics
EOF

#cmd 2>/dev/null
#echo "是否成功：$?"



