## 概念：

1、用来处理字符串常用的类有3种：String、StringBuffer和StringBuilder

2、三者之间的区别：

都是final类，都不允许被继承；

String类长度是不可变的，StringBuffer和StringBuilder类长度是可以改变的；

StringBuffer类是线程安全的，StringBuilder不是线程安全的；

## String 和 StringBuffer：

1、String类型和StringBuffer类型的主要性能区别：String是不可变的对象，因此每次在对String类进行改变的时候都会生成一个新的string对象，然后将指针指向新的string对象，所以经常要改变字符串长度的话不要使用string，因为每次生成对象都会对系统性能产生影响，特别是当内存中引用的对象多了以后，JVM的GC就会开始工作，性能就会降低；

2、使用StringBuffer类时，每次都会对StringBuffer对象本身进行操作，而不是生成新的对象并改变对象引用，所以多数情况下推荐使用StringBuffer，特别是字符串对象经常要改变的情况；

3、在某些情况下，String对象的字符串拼接其实是被Java Compiler编译成了StringBuffer对象的拼接，所以这些时候String对象的速度并不会比StringBuffer对象慢，例如：

> String s1 = “This is only a” + “ simple” + “ test”;
>
> StringBuffer Sb = new StringBuilder(“This is only a”).append(“ simple”).append(“ test”);

生成 String s1对象的速度并不比 StringBuffer慢。其实在Java Compiler里，自动做了如下转换：

> Java Compiler直接把上述第一条语句编译为：
>
> String s2 = “This is only a”;
>
> String s3 = “ simple”;
>
> String s4 = “ test”;
>
> String s1 = s2 + s3 + s4;

这时候，Java Compiler会规规矩矩的按照原来的方式去做，String的concatenation（即+）操作利用了StringBuilder（或StringBuffer）的append方法实现，此时，对于上述情况，若s2，s3，s4采用String定义，拼接时需要额外创建一个StringBuffer（或StringBuilder），之后将StringBuffer转换为String；若采用StringBuffer（或StringBuilder），则不需额外创建StringBuffer

## StringBuilder

StringBuilder是5.0新增的，此类提供一个与 StringBuffer 兼容的 API，但不保证同步。该类被设计用作 StringBuffer 的一个简易替换，用在字符串缓冲区被单个线程使用的时候（这种情况很普遍）。如果可能，建议优先采用该类，因为在大多数实现中，它比 StringBuffer 要快。两者的方法基本相同

使用策略

1、基本原则：如果要操作少量的数据，用String ；单线程操作大量数据，用StringBuilder ；多线程操作大量数据，用StringBuffer。

2、不要使用String类的”+”来进行频繁的拼接，因为那样的性能极差的，应该使用StringBuffer或StringBuilder类，这在Java的优化上是一条比较重要的原则，例如：

```java
String result = "";

for (String s : hugeArray) {

result = result + s;

}

// 使用StringBuilder

StringBuilder sb = new StringBuilder();

for (String s : hugeArray) {

sb.append(s);

}

String result = sb.toString();
```

当出现上面的情况时，显然我们要采用第二种方法，因为第一种方法，每次循环都会创建一个String result用于保存结果，除此之外二者基本相同

3、 StringBuilder一般使用在方法内部来完成类似”+”功能，因为是线程不安全的，所以用完以后可以丢弃。StringBuffer主要用在全局变量中

4、相同情况下使用 StirngBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。而在现实的模块化编程中，负责某一模块的程序员不一定能清晰地判断该模块是否会放入多线程的环境中运行，因此：除非确定系统的瓶颈是在 StringBuffer 上，并且确定你的模块不会运行在多线程模式下，才可以采用StringBuilder；否则还是用StringBuffer

## String、StringBuffer、StringBuilder区别

无论是做Java或是Android，都避免不了遇到这个问题，其实开发过程中一般情况下是不会纠结，这个问题是面试必选经典题，今天有时间，就总结一下。

StringBuffer、StringBuilder和String一样，也用来代表字符串。String类是不可变类，任何对String的改变都 会引发新的String对象的生成；StringBuffer则是可变类，任何对它所指代的字符串的改变都不会产生新的对象。既然可变和不可变都有了，为何还有一个StringBuilder呢？相信初期的你，在进行append时，一般都会选择StringBuffer吧！

先说一下集合的故事，HashTable是线程安全的，很多方法都是synchronized方法，而HashMap不是线程安全的，但其在单线程程序中的性能比HashTable要高。StringBuffer和StringBuilder类的区别也是如此，他们的原理和操作基本相同，区别在于StringBufferd支持并发操作，线性安全的，适 合多线程中使用。StringBuilder不支持并发操作，线性不安全的，不适合多线程中使用。新引入的StringBuilder类不是线程安全的，但其在单线程中的性能比StringBuffer高。

接下来，我直接贴上测试过程和结果的代码，一目了然：

```java
public class StringTest {
	public static String BASEINFO = "Mr.Y";
	public static final int COUNT = 2000000;
	/**
	 * 执行一项String赋值测试
	 */
	public static void doStringTest() {
		String str = new String(BASEINFO);
		long starttime = System.currentTimeMillis();
        
		for (int i = 0; i < COUNT / 100; i++) {
			str = str + "miss";
		}

		long endtime = System.currentTimeMillis();

		System.out.println((endtime - starttime) + " millis has costed when used String.");
	}

	/**
	 * 执行一项StringBuffer赋值测试
	 */
	public static void doStringBufferTest() {
		StringBuffer sb = new StringBuffer(BASEINFO);
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			sb = sb.append("miss");
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + " millis has costed when used StringBuffer.");
	}

	/**
	 * 执行一项StringBuilder赋值测试
	 */
	public static void doStringBuilderTest() {
		StringBuilder sb = new StringBuilder(BASEINFO);
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			sb = sb.append("miss");
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - starttime) + " millis has costed when used StringBuilder.");
	}
    
	/**
	 * 测试StringBuffer遍历赋值结果
	 * 
	 * @param mlist
	 */
	public static void doStringBufferListTest(List<String> mlist) {
		StringBuffer sb = new StringBuffer();
		long starttime = System.currentTimeMillis();
		for (String string : mlist) {
			sb.append(string);
		}
		long endtime = System.currentTimeMillis();
		System.out.println(sb.toString() + "buffer cost:" + (endtime - starttime) + " millis");
	}

	/**
	 * 测试StringBuilder迭代赋值结果
	 * 
	 * @param mlist
	 */
	public static void doStringBuilderListTest(List<String> mlist) {
		StringBuilder sb = new StringBuilder();
		long starttime = System.currentTimeMillis();
		for (Iterator<String> iterator = mlist.iterator(); iterator.hasNext();) {
			sb.append(iterator.next());
		}
		long endtime = System.currentTimeMillis();
		System.out.println(sb.toString() + "builder cost:" + (endtime - starttime) + " millis");
	}

	public static void main(String[] args) {
		doStringTest();
		doStringBufferTest();
		doStringBuilderTest();
		List<String> list = new ArrayList<String>();
		list.add(" I ");
		list.add(" like ");
		list.add(" BeiJing ");
		list.add(" tian ");
		list.add(" an ");
		list.add(" men ");
		list.add(" . ");
		doStringBufferListTest(list);
		doStringBuilderListTest(list);
	}
}
```


看一下执行结果：

2711 millis has costed when used String.
211 millis has costed when used StringBuffer.
141 millis has costed when used StringBuilder.
 I  like  BeiJing  tian  an  men  . buffer cost:1 millis
 I  like  BeiJing  tian  an  men  . builder cost:0 millis

![img](https://img-blog.csdn.net/20140520182905546?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvbWFkMTk4OQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

从上面的结果可以看出，不考虑多线程，采用String对象时（我把Count/100），执行时间比其他两个都要高，而采用StringBuffer对象和采用StringBuilder对象的差别也比较明显。由此可见，如果我们的程序是在单线程下运行，或者是不必考虑到线程同步问题，我们应该优先使用StringBuilder类；如果要保证线程安全，自然是StringBuffer。

从后面List的测试结果可以看出，除了对多线程的支持不一样外，这两个类的使用方式和结果几乎没有任何差别，

## StringBuffer常用方法

（由于StringBuffer和StringBuilder在使用上几乎一样，所以只写一个，以下部分内容网络各处收集，不再标注出处）

StringBuffer s = new StringBuffer();

这样初始化出的StringBuffer对象是一个空的对象，

 StringBuffer sb1=new StringBuffer(512);
分配了长度512字节的字符缓冲区。 

StringBuffer sb2=new StringBuffer(“how are you?”)

创建带有内容的StringBuffer对象，在字符缓冲区中存放字符串“how are you?”

### append方法
public StringBuffer append(boolean b)
该方法的作用是追加内容到当前StringBuffer对象的末尾，类似于字符串的连接，调用该方法以后，StringBuffer对象的内容也发生改 变，例如：
StringBuffer sb = new StringBuffer(“abc”);
sb.append(true);
则对象sb的值将变成”abctrue”

使用该方法进行字符串的连接，将比String更加节约内容，经常应用于数据库SQL语句的连接。

### deleteCharAt方法
public StringBuffer deleteCharAt(int index)
该方法的作用是删除指定位置的字符，然后将剩余的内容形成新的字符串。例如：
StringBuffer sb = new StringBuffer(“KMing”);
sb. deleteCharAt(1);
该代码的作用删除字符串对象sb中索引值为1的字符，也就是删除第二个字符，剩余的内容组成一个新的字符串。所以对象sb的值变 为”King”。
还存在一个功能类似的delete方法：
public StringBuffer delete(int start,int end)
该方法的作用是删除指定区间以内的所有字符，包含start，不包含end索引值的区间。例如：
StringBuffer sb = new StringBuffer(“TestString”);
sb. delete (1,4);
该代码的作用是删除索引值1(包括)到索引值4(不包括)之间的所有字符，剩余的字符形成新的字符串。则对象sb的值是”TString”。 

### insert方法
public StringBuffer insert(int offset, boolean b),
该方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。例如：
StringBuffer sb = new StringBuffer(“TestString”);
sb.insert(4,false);
该示例代码的作用是在对象sb的索引值4的位置插入false值，形成新的字符串，则执行以后对象sb的值是”TestfalseString”。 

### reverse方法
public StringBuffer reverse()
该方法的作用是将StringBuffer对象中的内容反转，然后形成新的字符串。例如：
StringBuffer sb = new StringBuffer(“abc”);
sb.reverse();
经过反转以后，对象sb中的内容将变为”cba”。 

### setCharAt方法
public void setCharAt(int index, char ch)该方法的作用是修改对象中索引值为index位置的字符为新的字符ch。例如：
StringBuffer sb = new StringBuffer(“abc”);
sb.setCharAt(1,’D’);
则对象sb的值将变成”aDc”。 

### trimToSize方法
public void trimToSize()
该方法的作用是将StringBuffer对象的中存储空间缩小到和字符串长度一样的长度，减少空间的浪费，和String的trim()是一样的作用，不在举例。

### length方法
该方法的作用是获取字符串长度 ，不用再说了吧。

### setlength方法
该方法的作用是设置字符串缓冲区大小。
StringBuffer sb=new StringBuffer();
sb.setlength(100);
如果用小于当前字符串长度的值调用setlength()方法，则新长度后面的字符将丢失。 

### sb.capacity方法
该方法的作用是获取字符串的容量。
StringBuffer sb=new StringBuffer(“string”);
int i=sb.capacity(); 

### ensureCapacity方法
该方法的作用是重新设置字符串容量的大小。
StringBuffer sb=new StringBuffer();
sb.ensureCapacity(32); //预先设置sb的容量为32 

### getChars方法
该方法的作用是将字符串的子字符串复制给数组。
getChars(int start,int end,char chars[],int charStart); 

StringBuffer sb = new StringBuffer("I love You");
int begin = 0;
int end = 5;
//注意ch字符数组的长度一定要大于等于begin到end之间字符的长度
//小于的话会报ArrayIndexOutOfBoundsException
//如果大于的话，大于的字符会以空格补齐
char[] ch  = new char[end-begin];
sb.getChars(begin, end, ch, 0);
System.out.println(ch);

结果：I lov

补充一下可以吗： String对象做拼接操，在JDK1.5之前会转换为StringBuffer的连续append操作，但是在JDK1.5之后将会转换为StringBuilder。 原因是JDK1.5之后对锁机制进行了优化，在单个线程中，经过“逃逸分析”算法确定累加操作不会逃出当前方法所在作用域时，将会去除StringBuffer append操作时的锁行为（在解释运行时仍会加锁，在编译过程中会去锁）所以经过去锁之后的append实则为StringBuild。（HotSport虚拟机实现是这样。）详情请参考《深入理解JVM虚拟机》

这种行为，为“锁优化”方案中的“锁消除”的一个例子

