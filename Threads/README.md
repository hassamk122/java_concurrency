### Calling run() Instead of start()
At first you may not notice anything because the Runnable's run() method is executed like you expected. 
However, it is NOT executed by the new thread you just created. Instead the run() method is executed
by the thread that created the thread. In other words, the thread that executed the above two lines of code.
To have the run() method of the MyRunnable instance called by the new created thread, newThread, you MUST call the newThread.start() method. 

### Daemon Threads
A daemon thread in Java is a thread that does not keep the Java Virtual Machine (JVM) running if the main thread exits the application.
A non-daemon thread will keep the JVM running even if the main thread exits the application. 


The last call to thread.join() is done only to make sure the main application thread does not exit (and shut down the JVM) before the daemon thread has had a chance to execute.

Read more: <a href="https://jenkov.com/tutorials/java-concurrency/creating-and-starting-threads.html">https://jenkov.com/tutorials/java-concurrency/creating-and-starting-threads.html</a>
