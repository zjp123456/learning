package part3;

public class VolatileTest {
    private static boolean flag = true;
    private static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new ThreadB().start();
        Thread.sleep(1000);
        new ThreadA().start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            flag = false;
            a = 1;
            System.out.println("ThreadA 修改flag" + "  =>" + flag + "  " + a);
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (flag) {// flag被设置为false之后，退出线程
//                System.out.println();
//                System.out.println("threadB print:  flag:" + flag + "  a:" + a);
//                System.out.println("threadB print: a:" + a);
//                System.out.println("threadB print: flag:" + flag);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("ThreadB 退出："+"flag:"+flag+"  a:"+a);
        }
    }
}
