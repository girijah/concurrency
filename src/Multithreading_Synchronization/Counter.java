package Multithreading_Synchronization;

/**
 * Created by girijah on 12/11/2017.
 */
public class Counter {
    private int balance = 0;

    public static void main(String[] args) {

        Counter c = new Counter();
        c.countMultiple();

        System.out.println("m balance: " + c.balance);

    }

    public void countMultiple() {

        // race condition

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10000; i++) {
                    add();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10000; i++) {
                    subtract();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("balance: " + balance);
        // join() is there up coz this print line should execute after both threads died
        // else though the methods are synchronized this print line can be in a inner stage of the threads' execution
    }

    // synchronization is for locking purpose
    // Solution for the race condition problem - Synchronization
    public synchronized void add() {
        balance++;
    }

    public synchronized void subtract() {
        balance--;
    }


}

