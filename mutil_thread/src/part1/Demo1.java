package part1;

import java.util.concurrent.*;


class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }
}

public class Demo1 {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());

        System.out.println("-------------");
        FutureTask<Integer> result2 = new FutureTask<>(new Task());
        executor.submit(result2);
        System.out.println(result2.get());
    }
}
