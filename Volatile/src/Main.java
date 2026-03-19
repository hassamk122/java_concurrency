
class Exchanger{
    private Object object = null;
    private volatile boolean hasNewObject = false;

    public void setObject(Object obj){
        this.object = obj;
        this.hasNewObject = true;
    }

    public Object getObject(){
        while(!hasNewObject){
            // wait
        }

        Object returnObject = this.object;
        this.hasNewObject = false;
        return returnObject;
    }
}

class Counter{
    private volatile int count = 0;

    public boolean increase(){
        // read of var of mem
        // increment var of mem
        // write of var to mem
        count++;
        return true;
    }
}

void main() {
    Counter counter = new Counter();

    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 10_000; i++){
                counter.increase();
                System.out.println("incremented by "+Thread.currentThread().getName());
            }
        }
    });

    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 10_000; i++){
                counter.increase();
                System.out.println("incremented by "+Thread.currentThread().getName());
            }
        }
    });

    t1.start();
    t2.start();


    try{
        t1.join();
        t2.join();
    }catch(Exception e){
        e.printStackTrace();
    }

    System.out.println(counter.count);
}
