package JDBC.pojo;

/**
 * @version v1.0
 * @ClassName: Employee
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Employee {
    //id NAME salary
    private int id;
    private String NAME;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", NAME='" + NAME + '\'' +
                ", salary=" + salary +
                '}';
    }
}
