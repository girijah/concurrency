package Multithreading_Cache_Volatile;

/**
 * Created by girijah on 12/12/2017.
 */
public class VolatileTester {

    public static void main (String[] args) {

        // volatile cannot be debugged properly - in fact that's the nature of concurrency
        // Here name can output null if you run, that doesn't mean though volatile variable is defined, other threads not getting it's value
        // Nevertheless the reason is that the thread already terminated by the time the other thread that is set with a name start executing.
        // This doesn't mean volatile didn't do its task/job!
        // volatile keyword in java guarantees that value of the volatile variable will always be read from main memory


        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Output: "+Singleton.getInstance());
                Singleton.setObjName("Meow!!");
                System.out.println("t1 Name: "+Singleton.getName());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Output: "+Singleton.getInstance());
                System.out.println("t2 Name: "+Singleton.getName());

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Output: "+Singleton.getInstance());
                Singleton.setObjName("WolWol");
                System.out.println("t3 Name: "+Singleton.getName());

            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Output: "+Singleton.getInstance());
                System.out.println("t4 Name: "+Singleton.getName());

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

 class Singleton {

    private volatile static Singleton _instance; //volatile variable
    private volatile static String objName;

    public static Singleton getInstance() {
        if (_instance == null) {
            synchronized (Singleton.class) {
                if (_instance == null)
                    _instance = new Singleton();
            }
        }
        return _instance;
    }

     public static String getName() {
         return objName;
     }

     public static void setObjName(String objectName) {
         objName = objectName;
     }

}
