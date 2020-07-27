package part2;

public class Demo2 {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("t1"); threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread"); thread.setPriority(9);
        System.out.println(" "+threadGroup.getMaxPriority());
        System.out.println(" "+thread.getPriority());
        //当线程的优先级大于该线程组的优先级时，默认该线程的优先级为线程组的优先级
    }
}
