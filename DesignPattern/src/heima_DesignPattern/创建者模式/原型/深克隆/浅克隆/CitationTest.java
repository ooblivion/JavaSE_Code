package heima_DesignPattern.创建者模式.原型.深克隆.浅克隆;

/**
 * @version v1.0
 * @ClassName: CitationTest
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1.创建原型对象
        Citation citation = new Citation();

        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation.setStu(stu);

        //2.克隆奖状对象
        Citation citation1 = citation.clone();
        Student stu1 = citation1.getStu();
        stu1.setName("李四");

        /*citation.setName("张三");
        citation1.setName("李四");*/

        //3.调用show方法展示
        citation.show();
        citation1.show();
    }
}

