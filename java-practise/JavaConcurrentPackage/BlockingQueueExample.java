package JavaConcurrentPackage;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("Added: 1");
                queue.put(2);
                System.out.println("Added: 2");
                queue.put(3);
                System.out.println("Added: 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
                System.out.println("Removed: " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
