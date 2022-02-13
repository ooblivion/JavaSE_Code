package heima_DesignPattern.创建者模式.原型.原型模式案例_三好学生_浅克隆;

/**
 * @version v1.0
 * @ClassName: CitationTest
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        //1.创建原型对象
        Citation citation = new Citation();
        //2.克隆奖状对象
        Citation citation1 = citation.clone();

        citation.setName("jack");
        citation1.setName("linda");

        //3.调用show方法展示
        citation.show();
        citation1.show();
    }
}
