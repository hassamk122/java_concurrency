void main(){
    ThreadLocal<String> threadLocal = new ThreadLocal<>(){
        @Override
        protected String initialValue(){
            return "I am default value";
        }
    };

    Thread thread = new Thread(()->{
        threadLocal.set("Thread 1");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        String value = threadLocal.get();
        System.out.println(value);
    });

    Thread thread2 = new Thread(()->{
        threadLocal.set("Thread 2");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        String value = threadLocal.get();
        System.out.println(value);
    });

    Thread thread3 = new Thread(()->{
        threadLocal.set("Thread 3");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        threadLocal.remove();

        if(threadLocal.get() != null){
            String value = threadLocal.get();
            System.out.println(value);
        }

    });

    thread.start();
    thread2.start();
    thread3.start();
}