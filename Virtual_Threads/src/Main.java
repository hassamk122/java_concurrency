void main(){

    Runnable r = ()->{
            IO.println("Hello World");
    };

    Thread thread = Thread.ofVirtual().start(r);




    Thread MyThread = Thread.ofVirtual().start(new Runnable(){
        @Override
        public void run(){
            System.out.println("my thread");
        }
    });

    try{
        thread.join();
        MyThread.join();
    }catch(InterruptedException e){
        e.printStackTrace();
    }


    Thread thread2 = Thread.ofVirtual().unstarted(new Runnable(){
        @Override
        public void run(){
            System.out.println("my thread2");
        }
    });

    thread2.start();

}
