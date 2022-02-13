package heima_DesignPattern.创建者模式.原型.原型模式案例_三好学生_浅克隆;

/**
 * @version v1.0
 * @ClassName: Citation
 * @Description: 奖状类，实现Clonable接口
 * @Author: Orange
 **/
public class Citation implements Cloneable{
    //三好学生的姓名
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    protected Citation clone() throws CloneNotSupportedException {
        return (Citation)super.clone();
    }

    public void show(){
        System.out.println(name+"是三好学生");
    }
}
