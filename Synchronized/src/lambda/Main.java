package lambda;

import java.util.function.Consumer;

public class Main{

    public  static void main(String[] args){
    Consumer<String> func = (String param) ->{
        synchronized (Main.class) {
            System.out.println(Thread.currentThread().getName()+" Step 1:"+param);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" step 2:"+param);
    };

    Thread thread1 = new Thread(()->{
        func.accept("Parameter");
    });

    Thread thread2 = new Thread(()->{
        func.accept("Parameter");
    });

    thread1.start();
    thread2.start();
}
}