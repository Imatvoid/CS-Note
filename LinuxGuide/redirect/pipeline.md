## pipeline

> 我们用不着将命令输出重定向到文件中，可以将其直接重定向到另一个命令。这个过程叫作管道连接(piping)
>
> |  将一个命令的输出当成另一个命令的输入



#### command1 | command2 |command3

```shell
$ cat files | uniq

$ cat files | uniq	| grep txt


$ cat files | uniq	| grep txt |sort
```

