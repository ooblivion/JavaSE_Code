package BigTalkDesignPattern.职责型;

public class 责任链 {
    public static void main(String[] args) {
        Testchain();
    }

    public static void Testchain(){
        T3 t3 = new T3();
        T2 t2 = new T2(t3);
        T1 t1 = new T1(t2);
        t1.run();
    }
}
interface Ta{
    public void run();
}

class T1 implements Ta{
    private Ta t;
    public T1(){}
    public T1(Ta t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("T1 run");
        if(t != null){
            t.run();
        }
    }
}

class T2 implements Ta{
    private Ta t;
    public T2(){}
    public T2(Ta t){
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("T2 run");
        if(t!=null){
            t.run();
        }
    }
}
class T3 implements Ta{
    private Ta t;
    public T3(){}
    public T3(Ta t){
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("T3 run");
        if(t!=null){
            t.run();
        }
    }
}