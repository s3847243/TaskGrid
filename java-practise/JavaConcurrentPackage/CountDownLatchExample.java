package JavaConcurrentPackage;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " completed.");
            latch.countDown();
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }

        try {
            latch.await(); // Wait for all threads
            System.out.println("All tasks are completed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
