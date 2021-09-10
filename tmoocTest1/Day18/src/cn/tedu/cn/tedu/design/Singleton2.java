package cn.tedu.cn.tedu.design;

//懒汉式/饿汉式
//懒汉式：是指不会在第一时间就把对象创建好来占用内存，而是什么时候用到，什么时候再去创建这个类的对象
public class Singleton2 {
    public static void main(String[] args) {
        MySingle2 mySingle21 = MySingle2.getMySingle();
        System.out.println(mySingle21);
        MySingle2 mySingle22 = MySingle2.getMySingle();
        System.out.println(mySingle22);
    }
}

class MySingle2 {
    private MySingle2() {
    }

    private static MySingle2 mySingle2 = null;
    private static Object o=new Object();
    public static MySingle2 getMySingle() {
        if (mySingle2 == null) {
            mySingle2 = new MySingle2();
        }
        return mySingle2;
    }
}


