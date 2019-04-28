## echo

输出字符

```shell
echo "this is 'echo'"
# 不换行输出
echo -n ""
# 开启处理特殊字符
echo -e ""
# \a 发出警告声 \b 删除前一个字符
```





#### 终端颜色高亮显示

echo -e 终端颜色  显示内容 结束后的颜色

```shell
echo -e "\033[1;35m" "hello" $(tput sgr0)
```



 