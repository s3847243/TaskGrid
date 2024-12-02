package JavaConcurrentPackage;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("All threads reached the barrier!"));

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting.");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " passed the barrier.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}
