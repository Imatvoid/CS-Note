### map



**map的建立**

```go
//初始值定义
m := map[string]string{
         "name":"yangxu",
         "id":"123",
}

//make定义空map
m2 := make(map[string]int)  m2 = empty map
//var定义空map
var m3 map[string]string    m3 = nil
	
fmt.Println(m,m2,m3)
```



**map的遍历和引用**

```go
#无序的，map默认是hashmap
for k,v := range m{
		fmt.Println(k,v)
}

name,ok  := map["name"] #如果 拼错会是初始值(zero value)  ok 是false


so

if name,ok  := map["name"]；ok{
    
} else{
    fmt.Println("key does not exist")
}

```



**map的删除**

```go
delete(m,"name")
```

**map的key和value能使用什么类型**

- map使用hash表必须能比较相等

    - 除了slice，map，function的内建类型都可以作为key

    - Struct类型不包含上述字段，也可以作为key


不需要像java一样需要实现 hashcode equals等



**map例题**

> 寻找最长不含有重复字符的子串

leetcode

```go
func lengthOfLongestSubstring(s string) int {
    lastOccurIndex := make(map[byte]int)
	start := 0
	maxLength := 0
	
	for i ,value := range []byte(s){
		if lastI,ok := lastOccurIndex[value]; ok && lastI >= start {
			start =  lastI + 1
		}

		if i-start+1 > maxLength{
			maxLength =  i-start+1
		}

		lastOccurIndex[value]=i

	}
	return  maxLength
   
}
```



支持中文

``` go

	str := "Yes我爱慕课网!" // utf -8 编码 中文三个字节
	fmt.Println(len(str))

    //19

	for _, b := range []byte(str) {
		fmt.Printf("%X ", b)
	}
   // 59 65 73 E6 88 91 E7 88 B1 E6 85 95 E8 AF BE E7 BD 91 21 

	fmt.Println()
	for i, ch := range str {
		fmt.Printf("(%d  %X)", i, ch) // ch is rune  int32
	}
   // (0  59)(1  65)(2  73)(3  6211)(6  7231)(9  6155)(12  8BFE)(15  7F51)(18  21)

	fmt.Println()
	fmt.Println("utf-8 rune count :", utf8.RuneCountInString(str))
   // utf-8 rune count : 9


	bytes := []byte(str)
	for len(bytes)> 0 {
		ch, size := utf8.DecodeRune(bytes)
		bytes = bytes[size:]
		fmt.Printf("%c ",ch)
	}
    //Y e s 我 爱 慕 课 网 ! 

	fmt.Println()
	for i,v := range  []rune(str){
		fmt.Printf("%d %c ", i,v)
	}
   // 0 Y 1 e 2 s 3 我 4 爱 5 慕 6 课 7 网 8 ! 
```




































