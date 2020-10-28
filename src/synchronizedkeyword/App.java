package synchronizedkeyword;

public class App {

    public int count = 0;

    // synchronized keyword allow one thread at once to change count state.
    private synchronized void increment(){
        this.count++;
    }

    public static void main(String[] args){
        App app = new App();
        app.doWork();
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        try{

            t1.join();
            t2.join();
            System.out.println("Count is: " + count);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

    }

}
