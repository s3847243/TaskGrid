public class Multithreading {
    public static void main(String[] args) {
        MultithreadThing myThing = new MultithreadThing();
        MultithreadThing myThing1 = new MultithreadThing();

        myThing.start();
        myThing1.start();

    }
    
}
