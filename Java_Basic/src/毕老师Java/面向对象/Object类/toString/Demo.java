package 毕老师Java.面向对象.Object类.toString;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Demo {
    private int num;

    Demo(int num) {
        this.num = num;
    }

    //复写toString，很多情况下都要复写
    public String toString() {
        return "demo:" + num;
    }
}
