package Java_Scheduling_Mechanism;

class Racer extends Thread {

    Racer(int id) {
        super("Racer[" + id + "]");
    }

    public void run() {
        for (int i = 1; i < 40; i++) {
            if (i % 10 == 0) {
                System.out.println(getName() + ", i = " + i);
                yield();
            }
        }
    }
}

class RaceStarter {
    public static void main(String args[]) {
        Racer[] racer = new Racer[4];

        for (int i = 0; i < 4; i++) {
            racer[i] = new Racer(i);
        }

        racer[3].setPriority(7);
        racer[0].setPriority(2);

        for (int i = 0; i < 4; i++) {
            racer[i].start();
        }
    }
}

