package Interthread_Communication;

import java.util.LinkedList;

/**
 * Created by girijah on 12/18/2017.
 */

class BoundedBufferTester {

    public static void main(String[] args) throws InterruptedException {
        // Object of a class that has both produce()
        // and consume() methods
        final BoundedBuffer pc = new BoundedBuffer(5);

        // Create producer thread
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.produce();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    pc.consume();
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}


// This class has a list, producer (adds items to list
// and consumer (removes items).
 public class BoundedBuffer {
    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int bufferSize;
    int value = 0;

    int PRODUCTION_PER_DAY = 25;

    public BoundedBuffer(int size) {
        bufferSize = size;
    }

    // Function called by producer thread
    public void produce() throws InterruptedException {

        while (value<PRODUCTION_PER_DAY) {

            synchronized (this) {
                // producer thread waits while list
                // is full
                while (list.size()==bufferSize)
                    wait();

                System.out.println("Producer produced-"
                        + value);

                // to insert the jobs in the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to  understand
                Thread.sleep(1000);
            }
        }
    }

    // Function called by consumer thread
    public void consume() throws InterruptedException {
    int count = 0;
        while (count<PRODUCTION_PER_DAY) {

            synchronized (this) {
                // consumer thread waits while list
                // is empty
                while (list.size()==0)
                    wait();

                //to retrive the ifrst job in the list
                int val = list.removeFirst();

                System.out.println("Consumer consumed-" + val);

                // Wake up producer thread
                notify();


                // and sleep
                Thread.sleep(1000);
            }
        }
    }
}


