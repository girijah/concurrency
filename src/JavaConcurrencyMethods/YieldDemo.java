package JavaConcurrencyMethods;

/**
 * Created by girijah on 12/16/2017.
 */
import java.lang.*;

public class YieldDemo {
    /*
    yield() - A hint to the scheduler that the current thread is willing to yield its current use of a processor
     */

    public static void main(String[]args) {
        MyThread t = new MyThread();
        t.start();

        for (int i=0; i<5; i++) {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }
}


// MyThread extending Thread
class MyThread extends Thread {

    public void run() {
        for (int i=0; i<5 ; i++)
            System.out.println(Thread.currentThread().getName() + " in control");
    }
}

/*
Output may vary in machine to machine with multi-core system but chances of execution of yield() thread first is higher
than the other thread because main thread is always pausing its execution and giving chance to child thread(with same priority).
 */
