
class Counter{
    private long count = 0;
    private Lock lock = new ReentrantLock();

    public void increment(){
        try{
            lock.lock();
            count++;
        }finally {
            lock.unlock();
        }
    }

    public long getCount(){
        try{
            lock.lock();
            return count;
        }finally {
            lock.unlock();
        }
    }
}

void main(){

}
