package 毕老师Java.集合框架.Set.TreeSet.TreeSet排序;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Demo1 {
}

/*
1. 让元素自身具备比较性，元素需要实现comparable接口，覆盖compareTo方法，这种方式也成为元素的自然顺序
2. 当元素自身不具备比较性时，或具备比较性不是所需要的，这时就要让**集合自身**具备比较性
   - 在集合初始化时就有比较方式，也就是构造函数（下面的实现Comparable
   - 定义了比较器，将比较器对象作为参数传递给TreeSet集合的构造函数
   - 具体方法：定义一个类，是心啊Comparable接口，覆盖compareTo方法
3. 当两种排序都存在时，以比较器为准（比较器的权重更大
*/