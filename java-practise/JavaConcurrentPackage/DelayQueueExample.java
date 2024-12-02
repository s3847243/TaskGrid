package JavaConcurrentPackage;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedElement implements Delayed {
    private final long delayTime;
    private final long creationTime;

    public DelayedElement(long delayTime) {
        this.delayTime = delayTime;
        this.creationTime = System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((creationTime + delayTime) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return "DelayedElement{" + "delayTime=" + delayTime + '}';
    }
}

public class DelayQueueExample {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> queue = new DelayQueue<>();
        queue.put(new DelayedElement(3000)); // 3-second delay

        System.out.println("Waiting for delayed element...");
        System.out.println(queue.take()); // Waits for the delay
    }
}
