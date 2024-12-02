package JavaConcurrentPackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample {
    public static void main(String[] args) {
        ThreadFactory factory = r -> new Thread(r, "CustomThread-" + System.currentTimeMillis());
        factory.newThread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
