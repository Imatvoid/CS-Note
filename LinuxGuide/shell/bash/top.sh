#!/bin/bash


top

# 序号	列名	含义
# 1	PID	进程id
# 2	PPID	父进程id
# 3	RUSER	Real user name
# 4	UID	进程所有者的用户id
# 5	USER	进程所有者的用户名
# 6	GROUP	进程所有者的组名
# 7	TTY	启动进程的终端名.不是从终端启动的进程则显示为 ?
# 8	PR	优先级
# 9	NI	nice值.负值表示高优先级，正值表示低优先级
# 10	P	最后使用的CPU,仅在多CPU环境下有意义
# 11	%CPU	上次更新到现在的CPU时间占用百分比
# 12	TIME	进程使用的CPU时间总计,单位秒
# 13	TIME+	进程使用的CPU时间总计,单位1/100秒
# 14	%MEM	进程使用的物理内存百分比
# 15	VIRT	进程使用的虚拟内存总量,单位kb,VIRT=SWAP+RES
# 16	SWAP	进程使用的虚拟内存中,被换出的大小,单位kb.
# 17	RES	进程使用的、未被换出的物理内存大小,单位kb,RES=CODE+DATA
# 18	CODE	可执行代码占用的物理内存大小,单位kb
# 19	DATA	可执行代码以外的部分(数据段+栈)占用的物理内存大小,单位kb
# 20	SHR	    共享内存大小,单位kb
# 21	nFLT	页面错误次数
# 22	nDRT	最后一次写入到现在,被修改过的页面数.
# 23	S	进程状态:
#             D=不可中断的睡眠状态
#             R=运行
#             S=睡眠
#             T=跟踪/停止
#             Z=僵尸进程
# 24	COMMAND	命令名/命令行
# 25	WCHAN	若该进程在睡眠,则显示睡眠中的系统函数名
# 26	Flags	任务标志,参考 sched.h



#https://blog.csdn.net/lgstudyvc/article/details/53421161