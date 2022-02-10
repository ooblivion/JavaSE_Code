关键字break和continue都是结束循环的作用，但是它只能结束它外面的第一层循环，如果代码里面是一层一层又一层的循环，你想直接结束最外层循环又该怎么做呢？

此时，就需要outer了。

看如下代码：

```java
outer:for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if(j==0) {
                System.out.print(j);
            }else {
                break outer;   //break;
            }
        }
    }
```

如果只用break，那么只跳出了里面的for循环，外层还没结束。

用break;则输出：0000000000

用break outer;则输出：0

outer：就相当于表示它现在代表的某个循环。

如果想跳出它所代表的循环，那么就break outer;

如果想结束它所代表的此次循环，那么就continue outer;