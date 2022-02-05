public class 面向对象_类与对象的关系 {
    public static void main(String[] args) {
        Car C1 = new Car();
        System.out.println(C1.color);
        C1.color = "blue";
        System.out.println(C1.color);
        C1.run();

        new Car().while_num = 5;
        new Car().color = "bluesss";
        new Car().run();

        System.out.println(C1.color + C1.while_num);

    }
    public static class Car{
        //描述颜色
        String color = "red";
        //描述轮胎数量
        int while_num = 4;
        //描述功能
        void run(){
            System.out.println("i can run");
        }
    }
}
