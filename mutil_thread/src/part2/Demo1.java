package part2;

public class Demo1 {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread " +Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread " +Thread.currentThread().getName());
        }); testThread.start();
        System.out.println(" main " + Thread.currentThread().getName());
    }
}
