package part3;

public class VolatileTest2 {
//    private static volatile boolean flag = true; //不用volatile修饰
    private static Object obj;

    public static void main(String[] args) throws InterruptedException {
        new Thread1().start();
        Thread.sleep(1000); //暂停1秒 保证线程1 启动并运行。
        new Thread2().start();
    }

    /**
     * 线程1 一个循环，如果 flag为false 跳出循环
     */
    static class Thread1 extends Thread {
        @Override
        public void run() {
            while (obj==null) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Thread1 running flag:"+flag);
            }
            System.out.println("thread1-run");
        }
    }

    /**
     * 线程2  2秒后将flag改成false
     */
    static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2-run");
//            flag = false;
            obj=new Object();
            System.out.println("flag 被改成false");
        }
    }
}
