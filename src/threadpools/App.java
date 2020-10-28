package threadpools;

// Threads pools manage Locks and Threads at the same time.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

    private int id;

    public Processor(int id){
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("Starting: " + id);
            Thread.sleep(5000);
            System.out.println("Completed: " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class App {

    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++){
            executor.submit(new Processor(i));
        }
        executor.shutdown();

        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }
}
