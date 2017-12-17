package JavaThreadSamples;

/**
 * Created by girijah on 12/17/2017.
 */
public class Sample {

    static String message;

    private static class CorrectorThread extends Thread {

        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "Mares do eat oats.";
            System.out.println(message);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        (new CorrectorThread()).start();
        message = "Mares do not eat oats.";
        System.out.println(message);
        Thread.sleep(2000);
        // Key statement 2:
        System.out.println(message);
    }
}
