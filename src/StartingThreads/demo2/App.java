package demo2;

// Another way to using threads is implementing "Runnable" interface and,
// do an override of "run" method.
// It requires to use a new Tread instance and pass a new Runner in order to launch a thread.
class Runner implements Runnable{
    @Override
    public void run() {
        try {
            for(int i = 0; i < 10; i++){
                System.out.println("Hello with runnable " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args){

        Thread t1 = new Thread(new Runner()); // You can pass a new instance of runner directly

        Runner runner = new Runner(); // Or create an instance previously and, pass it.
        Thread t2 = new Thread(runner);

        t1.start();
        t2.start();
    }
}
