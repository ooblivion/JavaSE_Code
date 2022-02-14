package 毕老师Java.面向对象.抽象类.抽象类练习_公司员工工资;

/**
 * @version v1.0
 * @ClassName: Manager
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class Manager extends Employee{
    private double bonus;
    Manager(String name, String id, double pay, double bonus){
        super(name, id, pay);
        this.bonus = bonus;
    }
    public void work(){
        System.out.println("manager work");
    }
}