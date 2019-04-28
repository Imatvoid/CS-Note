#!/bin/bash
#声明函数
fname()
{
echo 我是一个函数
}
#  调用函数
fname ;



fadd()
{
echo `expr $1 + $2`
}
fadd 1 2


fname2()
{
echo $1, $2; #访问参数1和参数2
echo "$@"; #以列表的方式一次性打印所有参数
echo "$*"; #类似于$@,但是参数被作为单个实体
return 0; #返回值
}


fadd2()
{
return `expr $1 + $2`;
}
fadd2 255 2

if [ $? -eq 0 ];
then
echo "executed successfully"
else
echo "terminated unsuccessfully"
fi

#export
#export -f fname













