## ENV



可以使用 env命令查看所有与终端相关的环境变量



对于进程来说,其运行时的环境变量可以使用下面的命令来查看:

```shell
cat /proc/$PID/environ  # 彼此之间由null字符( \0 )分隔
$ cat /proc/12501/environ | tr '\0' '\n'

XDG_SEAT_PATH=/org/freedesktop/DisplayManager/Seat0
XDG_CONFIG_DIRS=/etc/xdg/xdg-cinnamon:/etc/xdg
LANG=zh_CN.UTF-8
DISPLAY=:0

```



