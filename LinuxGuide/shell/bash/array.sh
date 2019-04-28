#!/bin/bash
echo --------- 1-----------
array_var=(1 2 3 4 5 6)

echo $array_var
echo ${array_var[1]}

echo ----------2------------
array_var[0]="test1"
array_var[1]="test2"
array_var[2]="test3"
array_var[3]="test4"
array_var[4]="test5"
array_var[5]="test6"

echo ${array_var[*]}

echo ----------3------------


echo "打印数组长度:"
echo ${#array_var[*]}






#定义关联数组
echo ----------4关联数组------------
declare -A fruits_value
fruits_value=([apple]='100dollars' [orange]='150 dollars')
echo "Apple costs ${fruits_value[apple]}"


declare -A fruits_value
fruits_value=([apple]=100dollars [orange]=150dollars)
echo "Apple costs ${fruits_value[apple]}"

echo 获得数组索引:
echo ${!fruits_value[*]}




