## rune

在各个方面基本等于int32,说成int32的别名也不算错,用来表示一个unicode 码点,也就是一个数字。

```go
    fmt.Printf("%T \n", rune)
    >> int32
```


```go
 	s := "我"
 	r := []rune(s)
 	fmt.Println(r)
```

