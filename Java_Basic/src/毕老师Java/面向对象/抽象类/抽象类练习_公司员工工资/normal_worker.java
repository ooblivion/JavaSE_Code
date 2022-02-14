package 毕老师Java.面向对象.抽象类.抽象类练习_公司员工工资;

/**
 * @version v1.0
 * @ClassName: normal_worker
 * @Description: TODO 类描述
 * @Author: Orange
 **/
class normal_worker extends Employee{
    normal_worker(String name, String id, double pay){
        super(name, id, pay);
    }
    public void work(){
        System.out.println("normal work");
    }
}
