package 毕老师Java.面向对象.Object类.equal;

/**
 * @version v1.0
 * @ClassName: Self
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Self {//比较类中的成员
    private int num;

    Self(int num) {
        this.num = num;
    }

    public boolean compare(Self self) {
        return this.num == self.num;
    }

    //父类中已经有相同功能的方法，没必要自己写
    //可以复写Object中的方法
    public boolean equals(Self s) {//这个和下面的equals方法之间的关系是重载（不同类型，数量，顺序）
        return this.num == s.num;
    }

    public boolean equals(Object obj) {//这个和Object中的equals方法之间的关系是重写
        //return this.num == obj.num;
        //报错：Object中没有num
        //多态想使用子类中的对象：向下转型

        //Self s = (Self)obj;
        //return this.num == s.num;

        //如果用到了对象中的特有数据要进行判断
        if (!(obj instanceof Self))
            return false;//以后会改为抛出异常
        Self s = (Self) obj;
        return this.num == s.num;
    }
}
