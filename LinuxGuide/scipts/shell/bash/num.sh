#!/bin/bash

#在Bash shell环境中,可以利用 let 、 (( )) 和 [] 执行基本的算术操作。而在进行高级操作时,
#expr 和 bc 这两个工具也会非常有用

#let

no1=4;
no2=5;

let result=no1+no2
echo "4+5=$result"


let result++
let result++
let result+=6
let result-=6

# []

result=$[ no1 + no2 ]
echo "4+5=$result"

#expr
result=`expr 3 + 4`
echo "3+4=$result"

result=$(expr $no1 + 5)
result=`(expr $no1 + 5)`
echo "4+5=$result"

echo ---------------------bc--------------------------------
#bc bc 是一个用于数学运算的高级工具,这个精密计算器包含了大量的选项。我们可以
#借助它执行浮点数运算并应用一些高级函数
echo "计算浮点数4 * 0.56"
echo "4 * 0.56" | bc

no=54;
result=`echo "$no * 1.5" | bc`
echo $result

echo "设定小数精度.2 3/8"
echo "scale=2;3/8" | bc


echo bc进制转换
no=100
echo 100的2进制：
echo "obase=2;$no" | bc

no=1100100
echo 1100100的10进制：
echo "obase=10;ibase=2;$no" | bc

echo 计算平方以及平方根
echo "sqrt(100)" | bc #Square root
echo "10^10" | bc #Square



