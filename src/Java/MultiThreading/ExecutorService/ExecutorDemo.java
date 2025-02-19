package Java.MultiThreading.ExecutorService;

import LLD.TaskManagement.Task;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=1;i<10;i++){
            int finalI = i;
            executorService.submit(() -> {
                long result = 0;
                try {
                    result = factorial(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(result);
            });
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("Waiting...");
        }
        System.out.println("Done with the task");
    }

    private static long factorial(int num) throws InterruptedException {
        int fact = 1;
        Thread.sleep(1000);
        for(int i=1;i<=num;i++){
            fact=fact*i;
        }
        return fact;
    }
}
