package semaphores;

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection instance = new Connection();
    private Semaphore sem = new Semaphore(10, true);  // if this semaphore will guarantee first-in first-out granting of permits under contention
    private int connections = 0;

    private Connection(){
    }

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        try {
            this.sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        }finally {
            this.sem.release();
        }
    }
    private void doConnect(){

        synchronized (this){
            this.connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this){
            this.connections--;
        }
    }


}
