package heima_Java基础.集合框架.Map集合.Map遍历.键值对;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version v1.0
 * @ClassName: Demo
 * @Description: entrySet()获取键值对 getKey getValue
 * @Author: Orange
 **/
public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("bbb", 222);
        map.put("ccc", 333);
        System.out.println(map);//{aaa=111, ccc=333, bbb=222}

        //1.调用Map的方法entrySet将Map集合转换成Set集合
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);//[aaa=111, ccc=333, bbb=222]

        //2.通过Set集合遍历
        for(Map.Entry<String, Integer> entry : entrySet){
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "=>" +value);
        }
    }
}
