### Main Differences Between a Lock and a Synchronized Block

The main differences between a Lock and a synchronized block are:

A synchronized block makes no guarantees about the sequence in which threads waiting to entering it are granted access.
You cannot pass any parameters to the entry of a synchronized block. Thus, having a timeout trying to get access to a 
synchronized block is not possible.
The synchronized block must be fully contained within a single method. A Lock can have it's calls to lock() and unlock() in separate methods.

### Lock Reentrance
A lock is called reentrant if the thread that holds the lock can lock it again. A non-reentrant lock is a lock which 
cannot be locked again if locked, not even by the thread that holds the lock. Non-reentrant locks may result in reentrance
lockout which is a situation similar to a deadlock.

The ReentrantLock class is a reentrant lock. That means, that even if a thread holds the hold it can lock
it again. Consequently the thread must unlock it as many times as it has locked it, in order to fully 
unlock the Reentrant lock for other threads. 