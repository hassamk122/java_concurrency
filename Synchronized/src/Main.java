
class SynchronizedExchanger{
    protected Object object = null;

    // these methods could be static
    public synchronized Object getObject(){
        return object;
    }

    public synchronized void setObject(Object object){
        this.object = object;
    }

    public void setObj(Object object){
        synchronized (this){
           this.object = object;
        }
    }

    public Object getObj(){
        synchronized (this){
            return object;
        }
    }
}

class  SynchronizedExchangerWithMonitorObj{
    Object monitor = null;
    Object myobject = null;


    public Object getObject(){
        synchronized (this.monitor){
            return myobject;
        }
    }

    public void setObject(Object object){
        synchronized (this.monitor){
            this.myobject = object;
        }
    }

}

void main() {
    SynchronizedExchanger exchanger = new SynchronizedExchanger();

    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 1_000; i++){
                exchanger.setObject(" "+i);
            }
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 1_000; i++){
                IO.println(exchanger.getObject());
            }
        }
    });

    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 1_000; i++){
                exchanger.setObj(" "+i);
            }
        }
    });

    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 1_000; i++){
                IO.println(exchanger.getObj());
            }
        }
    });


    thread3.start();
    thread4.start();

}
