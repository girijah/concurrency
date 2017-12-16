package Interthread_Communication;

/**
 * Created by girijah on 12/13/2017.
 */

public class Chat {
    boolean flag = false;

    public synchronized void Question(String msg) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void Answer(String msg) {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(msg);
        flag = false;
        notify();
    }
}


class ChatObject1 implements Runnable {
    Chat chat;
    String[] d1 = { "Hi", "How are you ?", "I am also doing fine!" };

    public ChatObject1(Chat c) {
        this.chat = c;
        new Thread(this, "Question").start();
    }

    public void run() {
        for (int i = 0; i < d1.length; i++) {
            chat.Question(d1[i]);
        }
    }
}


class ChatObject2 implements Runnable {
    Chat chat;
    String[] d2 = { "Hey", "I am good, what about you?", "Great!" };

    public ChatObject2(Chat c) {
        this.chat = c;
        new Thread(this, "Answer").start();
    }

    public void run() {
        for (int i = 0; i < d2.length; i++) {
            chat.Answer(d2[i]);
        }
    }
}


class TestThread {
    public static void main(String[] args) {
        Chat chat = new Chat();
        new ChatObject1(chat);
        new ChatObject2(chat);
    }
}