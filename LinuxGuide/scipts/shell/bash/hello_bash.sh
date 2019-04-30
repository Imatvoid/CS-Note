#!/bin/bash
#上面的是shebang 当脚本独自运行时候的解释器位置,当脚本作为命令行参数运行时 不需要 

# echo
fruit=apple
count=5
echo 'We have $count ${fruit}(s)'
echo "We have $count ${fruit}(s)"


# 字符串长度
var=12345678901234567890$
echo ${#var}

# 使用的shell 
echo $SHELL

#文件名
echo $0


# 是否是超级用户
if [ $UID -ne 0 ]; then
   echo Non root user. Please run as root.
else
   echo Root user
fi



#变量	含义
#$0	当前脚本的文件名
#$n	传递给脚本或函数的参数。n 是一个数字，表示第几个参数。例如，第一个参数是$1，第二个参数是$2。
#$#	传递给脚本或函数的参数个数。
#$*	传递给脚本或函数的所有参数。
#$@	传递给脚本或函数的所有参数。被双引号(" ")包含时，与 $* 稍有不同。
#$?	上个命令的退出状态，或函数的返回值。
#$$	当前Shell进程ID。对于 Shell 脚本，就是这些脚本所在的进程ID。
