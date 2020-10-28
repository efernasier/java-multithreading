package reentrantlock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for(int i = 0; i < 10000; i++){
            this.count++;
        }
    }

    public void firstThread() throws InterruptedException {
        this.lock.lock();
        try{
            System.out.println("Waiting...");
            this.cond.await();
            System.out.println("Woke up!");
            increment();
        }finally {
            this.lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        this.lock.lock();
        try{
            System.out.println("Press return key!");
            new Scanner(System.in).nextLine();
            System.out.println("Got return key!");
            this.cond.signal();
            increment();
        }finally {
            this.lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + this.count);
    }
}
