package JavaConcurrentPackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        scheduler.schedule(() -> System.out.println("Task executed after 3 seconds!"), 3, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> System.out.println("Periodic Task"), 1, 2, TimeUnit.SECONDS);

        scheduler.scheduleWithFixedDelay(() -> System.out.println("Task with delay"), 1, 2, TimeUnit.SECONDS);
    }
}
