package heima_DesignPattern.创建者模式.原型.深克隆.深克隆_改进;

import java.io.*;

/**
 * @version v1.0
 * @ClassName: CitationTest
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class CitationTest {
    public static void main(String[] args) throws Exception {
        //1.创建原型对象
        Citation citation = new Citation();

        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation.setStu(stu);

        //深克隆使用对象操作流，把奖状对象写到文件中，或称为序列化到硬盘上，再多次读取
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\Project\\IDEA_Java\\Java_Basic\\src\\IO_Document\\obj.txt"));
        //将对象写入文件，需要序列化的类要实现序列化接口
        oos.writeObject(citation);
        //释放资源
        oos.close();

        //读取对象，创建对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("G:\\Project\\IDEA_Java\\Java_Basic\\src\\IO_Document\\obj.txt"));
        //读取对象
        Citation citation1 = (Citation) ois.readObject();
        //释放资源
        ois.close();

        Student stu1 = citation1.getStu();
        stu1.setName("李四");

        //3.调用show方法展示
        citation.show();
        citation1.show();
    }
}

//序列化，反序列化本来就是深拷贝

//这是克隆吗？克隆接口有啥用？不是序列化弄了一个新奖状吗