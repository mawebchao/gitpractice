package cn.tedu.thread;

/**
 * 需求：设计多线程编程模型，完成总计售票100张的业务
 * 通过继承Thread类的方式来完成多线程售票的案例
 */
public class TestThread {
    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3= new TicketThread();
        TicketThread t4 = new TicketThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class TicketThread extends Thread {
    //定义变量用来保存票数
    //tickets成员变量需要被所有成员变量共享
    static int tickets = 100;
    @Override
    public void run() {

        //通过循环结构来一直卖票
         while (true) {
             synchronized (TicketThread.class){
                 if(tickets>0){
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println(getName() + "=" + tickets);
                     tickets--;
                 }else{
                     break;
                 }
             }


        }
    }
}
