package Thread_Implementation_Way1;

/**
 * Created by girijah on 12/9/2017.
 */
public class NewYear implements Runnable {

    public void countDown() {

        for(int counter = 10; counter > 0; counter--) {
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
    }
}


 class NewYearTester {

    public static void main (String[] args) {

        NewYear ny1 = new NewYear(); // Benefit of Runnable way of Threading is you can use this one ny1 instance in multiple threads

        Thread t1 = new Thread(ny1, "Festival Thread"); // new Thread. ny1 is runnable target. Custom thread name given 'Festival Thread'
        t1.start();                     // Runnable Thread started
        System.out.println(""+t1.getName());

        Thread t2 = new Thread(ny1); // NEW stated Thread - Thread not yet started
        t2.start();                     // Runnable Thread started
        System.out.println(""+t2.getName());

        NewYear ny2 = new NewYear();
        Thread t3 = new Thread(ny2); // NEW stated Thread - Thread not yet started

        System.out.println("Thread state: " + t3.getState());
        System.out.println("Thread Name: " + t3.getName());
        System.out.println("In Main Method Current Thread Name: " + Thread.currentThread().getName());

        t3.start();                     // Runnable Thread started
        System.out.println("Thread state: " + t3.getState());
        System.out.println("Thread Name: " + t3.getName());
        System.out.println("In Main Method Current Thread Name: " + Thread.currentThread().getName());

        NewYear ny3 = new NewYear();
        ny3.run();       // just the method call - not execute in a Thread - executes in main method


        /*try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("Happy New Year!");

        for(int i = 10; i>0; i--) {
            System.out.println(""+i);
        }

    }
}
