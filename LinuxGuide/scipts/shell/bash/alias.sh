#!/bin/bash

echo "检查是否默认情况下shell脚本中是否开启alias扩展"
shopt expand_aliases 



#shopt [-psu] [optname …]
#-s 开启某个选项.
#-u 关闭某个选项.
#-p 列出所有选项的当前生效命令. （不带-p表示列出所有选项的当前状态）

echo "shell中开启alias扩展"
shopt -s  expand_aliases  

alias install='sudo apt-get install'

alias echo2='echo'

echo2 我使用的是echo2

alias rm='cp $@ ~/backup && rm $@'
