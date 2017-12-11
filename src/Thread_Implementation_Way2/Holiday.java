package Thread_Implementation_Way2;

/**
 * Created by girijah on 12/9/2017.
 */
public class Holiday extends Thread {
    @Override
    public void run() {
        System.out.println("Happy holiday!");
        System.out.println( getName());
    }

    public static void main (String[] args) {

        new Holiday().start();
    }
}
