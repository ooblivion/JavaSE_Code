package heima_DesignPattern.创建者模式.原型.深克隆.浅克隆;

/**
 * @version v1.0
 * @ClassName: Citation
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Citation implements Cloneable {
    private Student stu;

    public Student getStu(){
        return stu;
    }

    public void setStu(Student stu){
        this.stu = stu;
    }


    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation)super.clone();
    }

    public void show(){
        System.out.println(stu.getName()+"更是重量级");
    }
}
