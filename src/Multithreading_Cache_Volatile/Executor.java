package Multithreading_Cache_Volatile;

/**
 * Created by girijah on 12/11/2017.
 */
public class Executor {

    private static volatile boolean running = true;
    // Couldn't see any cache problem in this example. However, since multiple threads try
    // accessing the same variable/resource, there is possible the variable not get updated. So, prevent it by using the keyword Volatile

    public static void main(String[] args) {

        for (int i=0; i<1000; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        System.out.println("running "+Thread.currentThread().getName());
                    }
                }
            }).start();

        }

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // Unless this thread update the running bool variable, all other thread will keep on running forever
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<10001; i++) {
                   running = true;
                    if(i==10000) {
                        running = false;
                    }
                }

            }
        }).start();


        System.out.println("Process finished with the last line executed..................!");

    }

}