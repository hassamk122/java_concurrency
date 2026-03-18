### Notes
While a platform thread can only execute a single virtual thread at a time, it has the ability to switch to executing a 
different virtual thread when the currently executed virtual thread makes a blocking call(e.g. network or concurrency data structure).

New virtual threads are queued up until a platform thread is ready to execute it. When a platform thread becomes ready, it will take a virtual thread and start executing it.

the platform thread does not switch between executing multiple virtual threads - except in the case of blocking network calls


virtual threads are managed by the JVM. Therefore, their allocation doesn’t require a system call, and they’re free of the operating system’s context switch.

Read more: <a href="https://jenkov.com/tutorials/java-concurrency/java-virtual-threads.html">https://jenkov.com/tutorials/java-concurrency/java-virtual-threads.html</a>
Comparision with normal threads <a href="https://www.baeldung.com/java-virtual-thread-vs-thread">https://www.baeldung.com/java-virtual-thread-vs-thread</a>