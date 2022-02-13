package heima_DesignPattern.创建者模式.原型.深克隆.深克隆_改进;

import java.io.Serializable;

/**
 * @version v1.0
 * @ClassName: Student
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Student implements Serializable {
    //学生姓名
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
