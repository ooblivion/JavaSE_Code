package heima_Java基础.异常.自定义异常.自定义编译时异常;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args){
        try {
            checkAge(300);
        } catch (Demo demo) {
            demo.printStackTrace();
        }
    }

    public static void checkAge(int age) throws Demo{
        if (age < 0 || age > 200){
//            System.out.println("age false");
            throw new Demo(age + " is illegal");
        }else {
            System.out.println("年龄合法，开始推荐商品");
        }
    }
}
