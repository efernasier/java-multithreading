package countdownlatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CountDownLatch works in latch principle, main thread will wait until gate is open.
// One thread waits for n number of threads specified while creating CountDownLatch in java.

// Any thread, usually main thread of application, which call CountDownLatch.await() will wait until count reaches zero
// or its interrupted by other thread. All other thread are required to do count down by calling CountDownLatch.countDown()
// once they are completed or ready.

// As soon as count reaches zero, Thread awaiting starts running. One of the disadvantages/advantages of CountDownLatch is that it's not reusable
// once count reaches to zero you can not use CountDownLatch any more.
class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch){
        this.latch = latch;
    }

    public void run() {
        System.out.println("Starting...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}

public class App {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++){
            executor.submit(new Processor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }
}
