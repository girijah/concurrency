package Thread_Implementation_Way2;

/**
 * Created by girijah on 12/9/2017.
 */
public class Vacation implements  Runnable {

    @Override
    public void run() {
        System.out.println("Happy Vacation!");
    }

    public static void main(String[] args) {
        new Thread(new Vacation()).start();
    }
}
