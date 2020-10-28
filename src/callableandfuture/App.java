package callableandfuture;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {

    public static void main(String... args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        // if you don't want get the result
        //Future<?> future = executor.submit(new Callable<Void>() {
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {   // public Void call() throws Exception {
                Random ramdom = new Random();
                int duration = ramdom.nextInt(4000);

                if(duration  > 2000) {
                    throw new IOException("Sleeping for too long.");
                }

                System.out.println("Starting...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");

                return duration; // return null;
            }
        });
    
        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) { // If Something happened with the execution of a thread thereby produce an InterruptedException
            e.printStackTrace();
        } catch (ExecutionException e) { // If something happened attempting to use a Callable, It returns an ExecutionException
            System.out.println(e);
            System.out.println(e.getMessage());

            // If you want to get original exception
            IOException ex = (IOException) e.getCause();
            ex.getMessage();
        }

    }
}
