
class MyThread extends Thread {
    public  void run() {
        System.out.println("MyThread running");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("My Runnable running");
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(new MyRunnable());

        myThread.start();
        thread.start();

        Thread anonymousImplThread = new Thread(()->{
            System.out.println("My anonymous impl running");
        });

        anonymousImplThread.start();

        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("My lambda runnable running"+threadName);
                 try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finished processing "+threadName);

        };

        Thread anonymousImplThread2 = new Thread( runnable, " lambda thread" );

        anonymousImplThread2.start();

        //anonymousImplThread2.setDaemon(true); // runs as long as main thread runs


        myThread.join();
        thread.join();
    }
}