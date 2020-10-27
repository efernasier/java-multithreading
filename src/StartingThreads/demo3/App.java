package StartingThreads.demo3;

// If you don't want create a new classes.
// You can create a new Runnable instance and override the run method as constructor.
// or, using a lambda expression.
public class App {

    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++){
                        System.out.println("Hello quickly " + i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread( ()-> {
            try {
                for(int i = 0; i < 10; i++){
                    System.out.println("Hello quickly " + i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();



    }



}
