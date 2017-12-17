package CollectionOfFramework_SharedObject;

/**
 * Created by girijah on 12/17/2017.
 */
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

class Producer implements Runnable {
    private BlockingQueue<String> drop;

    public Producer(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };
        Random random = new Random();

        try {
            for (int i = 0; i < importantInfo.length; i++) {
                drop.put(importantInfo[i]);
                //Thread.sleep(random.nextInt(5000));
            }
            drop.put("DONE");

        } catch (InterruptedException e) {}
    }
}


class Consumer implements Runnable {
    private BlockingQueue<String> drop;

    public Consumer(BlockingQueue<String> drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        try {
            for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
                System.out.format("MESSAGE RECEIVED: %s%n", message);
                //Thread.sleep(random.nextInt(5000));
            }
        } catch (InterruptedException e) {}
    }
}


public class ProducerConsumerTester {

    public static void main(String[] args) {
        BlockingQueue<String> drop = new SynchronousQueue<String>();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
