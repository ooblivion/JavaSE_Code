package 毕老师Java.面向对象.抽象类.抽象类练习_公司员工工资;

/**
 * @version v1.0
 * @ClassName: Employee
 * @Description: TODO 类描述
 * @Author: Orange
 **/
abstract class Employee{
    private String name;
    private String id;
    private double pay;
    Employee(String name, String id, double pay){
        this.name = name;
        this.id = id;
        this.pay = pay;
    }

    public abstract void work();
}
