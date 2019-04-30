#!/bin/bash

# 只显示当点shell
echo -----------------ps----------------
ps

echo -----------------ps -f 多列---------------
ps -f


  # UID   PID  PPID   C STIME   TTY           TIME CMD
  # 501 20765 20762   0  5:07下午 ttys000    0:00.03 /Applications/iTerm.app/Contents/MacOS/iTerm2 --server login -fp yangxu
  # 501 20767 20766   0  5:07下午 ttys000    0:00.01 -bash
  # 501 20771 20767   0  5:07下午 ttys000    0:00.00 /bin/bash ./ps.sh

# USER    用户名
# UID    用户ID（User ID）
# PID    进程ID（Process ID）
# PPID    父进程的进程ID（Parent Process id）
# C      CPU 使用的资源百分比
# SID    会话ID（Session id）
# %CPU    进程的cpu占用率
# %MEM    进程的内存占用率
# VSZ    进程所使用的虚存的大小（Virtual Size）
# RSS    进程使用的驻留集大小或者是实际内存的大小，Kbytes字节。
# TTY    与进程关联的终端（tty）
# STAT    进程的状态：进程状态使用字符表示的（STAT的状态码）
# R 运行    Runnable (on run queue)            正在运行或在运行队列中等待。
# S 睡眠    Sleeping                休眠中, 受阻, 在等待某个条件的形成或接受到信号。
# I 空闲    Idle
# Z 僵死    Zombie（a defunct process)        进程已终止, 但进程描述符存在, 直到父进程调用wait4()系统调用后释放。
# D 不可中断    Uninterruptible sleep (ususally IO)    收到信号不唤醒和不可运行, 进程必须等待直到有中断发生。
# T 终止    Terminate                进程收到SIGSTOP, SIGSTP, SIGTIN, SIGTOU信号后停止运行运行。
# P 等待交换页
# W 无驻留页    has no resident pages        没有足够的记忆体分页可分配。
# X 死掉的进程
# < 高优先级进程                    高优先序的进程
# N 低优先    级进程                    低优先序的进程
# L 内存锁页    Lock                有记忆体分页分配并缩在记忆体内
# s 进程的领导者（在它之下有子进程）；
# l 多进程的（使用 CLONE_THREAD, 类似 NPTL pthreads）
# + 位于后台的进程组 
# START    进程启动时间和日期
# TIME    进程使用的总cpu时间
# COMMAND    正在执行的命令行命令
# NI    优先级(Nice)
# PRI    进程优先级编号(Priority)
# WCHAN    进程正在睡眠的内核函数名称；该函数的名称是从/root/system.map文件中获得的。
# FLAGS    与进程相关的数字标识


echo -----------------ps -ef -e=every/ax 多列---------------
#ps -ef



echo -----------------"ps -e|head 前10项目"-----------------
ps -e | head



echo -----------------"ps -e -o comm pcpu| head "-----------------
# comm表示COMMAND，pcpu表示CPU占用率
ps -e -o  comm,pcpu | head



# pcpu CPU占用率 
# pid  进程ID
# ppid 父进程ID 
# pmem 内存使用率 
# comm 可执行文件名
# cmd  简单命令1
# user 启动进程的用户
# nice 优先级
# time 累计的CPU时间 
# etime 进程启动后流逝的时间 
# tty  所关联的TTY设备 
# euid 有效用户ID
# stat 进程状态


echo ------------------"ps -eo comm,pcpu --sort -pcpu | head"---------------------
ps -eo comm,pcpu --sort -pcpu | head
























