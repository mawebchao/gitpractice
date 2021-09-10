package cn.tedu.inner;

/*
匿名内部类
 */
public class TestInner5 {
    public static void main(String[] args) {
        Inter1 i1 = new Inter1() {

            @Override
            public void save() {
                System.out.println("正在保存");
            }

            @Override
            public void get() {
                System.out.println("正在获取");
            }
        };
        i1.save();
        i1.get();
        Inter2 i2 = new Inter2() {
            @Override
            public void fuck() {
                System.out.println("正在OOXX");
            }
        };
        i2.fuck();

        Inter3 i3= new Inter3(){
            @Override
            public void find() {
                System.out.println("正在查询，哈哈哈");
            }
        };
        i3.find();
    }
}

class Inter3 {
    public void find() {
        System.out.println("正在查询");
    }

    public void find2(){
        System.out.println("正在查询2");
    };
}

interface Inter1 {
    void save();

    void get();
}

abstract class Inter2 {
    public void study() {
        System.out.println("正在学习");
    }

    public abstract void fuck();
}

class Car {
    public void start() {
        System.out.println("启动");
    }

    public void stop() {
        System.out.println("停止");
    }
}
