package Java.MultiThreading.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        java.util.concurrent.Future<Integer> future = executor.submit(() -> 42);
        executor.shutdown();
        System.out.println(future.get());
    }
}
