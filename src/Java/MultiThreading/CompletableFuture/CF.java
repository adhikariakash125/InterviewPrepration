package Java.MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CF {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String string = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("inside worker");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Okay";
        }).thenApply(x -> x + " done").get();

        System.out.println(string);
    }
}
