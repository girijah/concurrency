package JavaThreadSamples;

/**
 * Created by girijah on 12/17/2017.
 */

class Customer {

    private int amount = 2000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount<amount){
            System.out.println("Less balance; waiting for deposit...");
            try{
                wait();
            }catch(Exception e) {}
        }
        this.amount-=amount;
        System.out.println("withdraw completed...");

        System.out.println("Amount: "+ this.amount);
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();

        System.out.println("Amount: "+ this.amount);
    }

    public int getBalance() {
        return amount;
    }
}

public class BankTest {
    public static void main(String args[]){

        final Customer c = new Customer();

        new Thread(){
            public void run(){
                c.withdraw(11000);
            }
        }.start();

        new Thread(){
            public void run(){
                c.deposit(14000);
            }
        }.start();

        System.out.println(c.getBalance());

    }
}
