package Thread_Implementation_Way1;

/**
 * Created by girijah on 12/9/2017.
 */
public class Christmas extends Thread {

    public void countDown() {

        for(int counter = 10; counter>0; counter--) {
            System.out.println("# "+ counter);

            /*try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }

    @Override
    public void run() {
        countDown();
        System.out.println("In Run method: "+getName());
        System.out.println("In Run method Thread state: " + getState());
        System.out.println("In Run method Current Thread: " + Thread.currentThread().getName());
    }
}

class ChristmasTester {
/* Instance.run() call or Thread.run() is just a method call. That doesn't create a new Thread or
 * run in a new Thread. That just executes in the main method itself. Just like a method call.
 */
    public static void main(String[] args) {

        System.out.println("In Main Method Current Thread Name: " + Thread.currentThread().getName());
        /*Christmas c1 = new Christmas(); // NEW stated Thread - Thread not yet started. c1 instance cannot be used in multiple threads. new Thread
        c1.start();

        Christmas c2 = new Christmas(); // NEW stated Thread - Thread not yet started
        c2.start();

        Christmas c3 = new Christmas(); // NEW stated Thread - Thread not yet started
        c3.start();

        */

        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("Merry Christmas!");

        for (int i = 10; i > 0; i--) {
            System.out.println("" + i);
        }

        Christmas c4 = new Christmas(); // NEW stated Thread - Thread not yet started
        c4.run();                       // Thread not started - just call run method on main Thread
        System.out.println("Thread state: " + c4.getState());
        c4.setName("Festival Thread"); // Name the thread on your own
        System.out.println("Thread Name: " + c4.getName());
        System.out.println("In Main Method Current Thread Name: " + Thread.currentThread().getName());

        Christmas c5 = new Christmas(); // NEW stated Thread - Thread not yet started
        c5.start();                       // executes in the c5 Thread - not just the method call - Runnable Thread started
        System.out.println("Thread state: " + c5.getState());
        System.out.println("Thread Name: " + c5.getName());
        System.out.println("In Main Method Current Thread Name: " + Thread.currentThread().getName());

    }
}
