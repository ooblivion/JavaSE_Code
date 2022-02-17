package heima_Java基础.集合框架.Map集合.Map遍历.键找值;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: TODO 类描述
 * @Author: Orange
 **/
public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        System.out.println(map);

        //1.键找值，先拿到集合的全部键
        Set<String> keys = map.keySet();
        //2.遍历每个键，根据键取值
        for(String key : keys){
            int value = map.get(key);
            System.out.println(key + "=>" + value);
        }
    }
}
