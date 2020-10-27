package startingthreads.demo1;

// One way to implement multi threading is extends from Thread class.
// It requires to do an override of "run" method.
// Also, you can sleep/pause a thread using "Thread.sleep()" and passing an amount of time in milliseconds.
class Runner extends Thread {
    @Override
    public void run() {
        try {
            for(int i = 0; i < 10; i++){
                System.out.println("Hello " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class App {
    public static void main(String[] args){

        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();

    }
}
