package heima_DesignPattern.创建者模式.建造者.another;

/**
 * @version v1.0
 * @ClassName: Phone
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    //私有构造方法
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        //使用构建者创建Phone对象
        public Phone build() {
            return new Phone(this);
        }
    }
}

