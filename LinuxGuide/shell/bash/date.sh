#!/bin/bash

echo 当前时间：--------------------------------------
echo `date`

echo UTC时间钟：--------------------------------------
echo `date +%s`

echo 获取时间:--------------------------------------
echo `date --date "Thu Nov 18 08:07:21 IST 2010" +%s`


#星期  %a(例如:Sat)  %A(例如:Saturday)
#月    %b(例如:Nov)  %B(例如:November)  %m(11)
#日    %d(例如:31)
#固定格式日期(mm/dd/yy) %D(例如:10/18/10)
#年    %y(例如:10) %Y(例如:2010)
#小时 %I或%H(例如:08)
#分钟 %M(例如:33)
#秒 %S(例如:10)
#纳秒 %N(例如:695208515)
#Unix纪元时(以秒为单位) %s(例如:1290049486)

echo 格式:--------------------------------------
echo `date "+%d %B %Y"`

echo `date "+%d %m %Y"`





yesterday=`date -d last-day +%Y-%m-%d`
echo $yesterday
 
curday=`date +%Y-%m-%d`
echo $curday
 
echo "现在时间：`date '+%Y%m%d %T'`"
echo "现在时间：`date '+%Y%m%d %H%M%S'`"
 
echo `date '+%Y%m%d-%H%M%S'`
 
t3=`date '+%Y-%m-%d %H:%M:%S'`
echo $t3
 
send=`date '+%Y-%m-%d %H:%M:%S'`
echo $send
 
t4=`date '+%Y-%m-%d %H:%M:%S'`



echo 计算时间差：--------------------------------------
start=$(date +%s)

sleep 5

end=$(date +%s)
difference=$(( end - start))
echo Time taken to execute commands is $difference seconds.



