package JavaConcurrentPackage;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Main thread registers

        Runnable task = () -> {
            phaser.register();
            System.out.println(Thread.currentThread().getName() + " reached phase " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + " completed phase.");
        };

        new Thread(task).start();
        new Thread(task).start();

        phaser.arriveAndDeregister(); // Main thread deregisters
        System.out.println("All threads finished phase.");
    }
}
