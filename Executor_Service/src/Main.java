void main(){
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    executorService.execute(newRunnable("task1"));
    executorService.execute(newRunnable("task2"));
    executorService.execute(newRunnable("task3"));
    Future future = executorService.submit(newCallable("callable task"));

    System.out.println(future.isDone());

    try{
        String result = (String) future.get();
        System.out.println(result);
    }catch (Exception e){
        e.printStackTrace();
    }

    System.out.println(future.isDone());
    executorService.shutdown();

    ExecutorService singleThread = Executors.newSingleThreadExecutor();

    singleThread.execute(newRunnable("single thread task"));

    singleThread.shutdown();


}

private static Callable newCallable(String message){
    return new Callable() {
        @Override
        public Object call() throws Exception {
            String msg = Thread.currentThread().getName()+" "+message;
            return msg;
        }
    };
}

private static Runnable newRunnable(String msg){
    return new Runnable() {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" "+msg);
        }
    };
}