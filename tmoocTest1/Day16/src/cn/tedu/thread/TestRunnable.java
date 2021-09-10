package cn.tedu.thread;

public class TestRunnable {
    public static void main(String[] args) {
        TicketRunnalbe tr=new TicketRunnalbe();
        Thread t1=new Thread(tr,"售票厅1");
        Thread t2=new Thread(tr,"售票厅2");
        Thread t3=new Thread(tr,"售票厅3");
        Thread t4=new Thread(tr,"售票厅4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
//创建自定义的多线程类，完成自动售票业务
class TicketRunnalbe implements  Runnable{
    static int tickets = 100;
    Object o=new Object();
    @Override
    public void run() {
        //通过循环结构来一直卖票
        while (true) {
            synchronized (o){
                if(tickets>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets+"张票");
                    tickets--;
                }else{
                    break;
                }
            }


        }
    }
    //问题1：1张票卖给了多人，extends Thread类的方法可以用static变量方式来解决，implements  Runnable的方式可以自动解决
    //问题2：数据安全的隐患，什么隐患？即一个程序或者说是一段代码，同时被多个线程运行
}