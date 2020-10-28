package waitandnotify;

import java.util.Scanner;

public class Processor {

    public void producer() throws InterruptedException {
        synchronized (this){
            System.out.println("Producer thread running...");
            wait(); // from the ancestor
            System.out.println("Resumed.");
        }
    }

    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed");
            notify();
            Thread.sleep(5000);
        }

    }
}
