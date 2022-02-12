package heima_DesignPattern.创建者模式.工厂方法.抽象工厂模式;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Client {
    public static void main(String[] args) {
        //创建的是意大利风味甜品工厂对象
        //ItalyDessertFactory factory = new ItalyDessertFactory();
        AmericanDessertFactory factory = new AmericanDessertFactory();
        //获取拿铁咖啡和提拉米苏甜品
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
//抽象工厂不会类爆炸，每种产品都是以方法的形式呈现的，只不过缺点是如果类中的方法很多，但只创建一个对象，代价有点大

//没有咖啡店了
