class PoolThreadRunnable implements Runnable {

    private Thread thread;
    private BlockingQueue taskQueue;
    private boolean isStopped = false;

    public PoolThreadRunnable(BlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }



    @Override
    public void run() {
        thread = Thread.currentThread();

        while (!isStopped) {
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            }catch(InterruptedException e){

            }
        }
    }

    public synchronized void doStop() {
        isStopped = true;

        thread.interrupt();
    }


    public synchronized boolean isStopped() {
        return isStopped;
    }
}

class ThreadPool{

    private BlockingQueue taskQueue;
    private List<PoolThreadRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;


    public ThreadPool(int noOfThreads, int maxTasks){
        taskQueue = new ArrayBlockingQueue<>(maxTasks);

        for(int i = 0; i < noOfThreads; i++){
            PoolThreadRunnable poolThreadRunnable
                    = new PoolThreadRunnable(taskQueue);

            runnables.add(poolThreadRunnable);
        }

        for(PoolThreadRunnable poolThreadRunnable : runnables){
            new Thread(poolThreadRunnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if(isStopped){
            throw new IllegalStateException("Pool is stopped");
        }
        taskQueue.add(task);
    }

    public synchronized void stop(){
        isStopped = true;
        for(PoolThreadRunnable poolThreadRunnable : runnables){
            poolThreadRunnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished(){
        while(!taskQueue.isEmpty()){
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}


void main() throws Exception {
    ThreadPool threadPool = new ThreadPool(3, 10);

    for(int i = 0; i < 10; i++){
        int taskNo = i;
        threadPool.execute( ()->{
            String message = Thread.currentThread().getName() +" Task: " + taskNo;
            System.out.println(message);
        });
    }

    threadPool.waitUntilAllTasksFinished();
    threadPool.stop();
}
