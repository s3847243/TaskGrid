package JavaConcurrentPackage;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(5000); // Simulate work
            return 42; // Result
        });

        try {
            System.out.println("Result: " + future.get()); // Wait and get the result
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
