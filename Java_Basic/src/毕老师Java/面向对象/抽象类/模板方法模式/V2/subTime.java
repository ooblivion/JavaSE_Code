package 毕老师Java.面向对象.抽象类.模板方法模式.V2;

/**
 * @version v1.0
 * @ClassName: subTime
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class subTime extends GetTime{
    public void runcode(){
        for(int x = 0; x < 40000; x++)
            System.out.println(x);
    }
}

//代码完成后就可以解决这类问题，这种方式称为模板方法设计模式
//什么是模板方法？在定义功能的时候，功能的一部分是确定的，但是有一部分是不确定的，而确定的部分在使用不确定的部分。那么就将不确定的部分暴露出去，由该类的子类去完成。提高了拓展性，复用性
