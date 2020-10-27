package basicthreadsynchronization;

// There are two problems that you encounter if you have more than one thread sharing the same
// data, two kinds of problems.

// The first is when the data being cached

// And the second kind of problem which is more vicious has to do
// with threats interleaving

// Purposes of Volatile keyword.

// And in fact I must confess I've never seen this kind of setup not to work.
// Because, here's the catch because apparently under some conditions are under some on some systems or maybe.
// I don't know  with some imperfect implementation of Java.

import java.util.Scanner;

class Processor extends Thread {

    // private boolean running = true;
    private volatile boolean running = true; // using to prevent threads caching variables when they're not changed from withing that thread

    public void run(){
        try {
            while(running){
                System.out.println("Hello");
                Thread.sleep(100);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void shutdown(){
        this.running = false;
    }
}

public class App {

    public static void main(String[] args){

        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return key to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }

}
