package cn.tedu.map;

import org.junit.Test;

import java.util.*;

public class TestMap {
    //Entry
    public static void main(String[] args) {
        //1.创建Map对象，注意接口不能实例化，所以创建的是多态对象
        //结构中的数据要符合映射规则，一定哟啊同时指定key和value的数据类型


    }
    @Test
    public void method1(){
        HashMap<Integer, String> map = new HashMap<>();
        //2.向集合中添加测试数据
        map.put(1, "敖烈");
        map.put(2, "白虎精");
        map.put(3, "鲤鱼精");
        map.put(4, "白龙马");
        System.out.println(map);
        //测试clear()
//        map.clear();
        System.out.println(map);
        //测试clone()
        Map<Integer, String> map_clone=null;
        map_clone=(HashMap<Integer, String>)map.clone();
        //测试containsKey
        System.out.println(map.containsKey(1));
        //测试containsValue
        System.out.println(map.containsValue("白龙马"));
        //测试get
        System.out.println(map.get(1));
        //测试isEmpty
        System.out.println(map.isEmpty());
        //测试size
        System.out.println(map.size());
        //测试values
        System.out.println(map.values());
        //测试entrySet
        System.out.println(map.entrySet());
        for (Map.Entry<Integer,String> entry:
                map.entrySet() ) {
            System.out.println(entry);
        }
        for (Integer key:
                map.keySet() ) {
            System.out.println("Key:"+key+",Value:"+map.get(key));
        }
        HashMap<Integer,String> map1=new HashMap<>();
        map1.put(5, "tgrsdfg");
        map1.put(6, "trgfd");
        map1.put(7, "gtrfd");
        map1.put(8, "hbtr");
        map.putAll(map1);
        System.out.println(map);
    }
    @Test
    public void method2(){
        HashMap<Integer, String> map = new HashMap<>();
        //2.向集合中添加测试数据
        map.put(1, "敖烈");
        map.put(2, "白虎精");
        map.put(3, "鲤鱼精");
        map.put(4, "白龙马");
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));

        Set<String> values= (Set<String>) map.values();
        System.out.println(values);
    }
    @Test
    public void method3(){
        HashMap<Integer, String> map = new HashMap<>();
        //2.向集合中添加测试数据
        map.put(1, "敖烈");
        map.put(2, "白虎精");
        map.put(3, "鲤鱼精");
        map.put(4, "白龙马");
        //Map需要转换成Set集合，再迭代
        //把Map中所有的Key取出来放到集合中
        Set<Integer> keyset=map.keySet();
        System.out.println(keyset.size());
        Iterator i=keyset.iterator();
        while(i.hasNext()){
            System.out.println("Key:"+i+",Value:"+map.get(i.next()));
        }
        //把Map中的每一个键值对看作是一个个的Entry<Eky,Value>对象
        Set<Map.Entry<Integer,String>> entryset= map.entrySet();

        //将两个hashmap合并（添加一对键值对）
        map.merge(1, "USA", (oldValue, newValue) -> oldValue + "/" + newValue);
        System.out.println(map);
    }
}
