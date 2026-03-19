### Solves visibility problem across threads
The Java volatile keyword guarantees visibility of changes to variables across threads.

In a multithreaded application where the threads operate on non-volatile variables, each thread may copy variables from
main memory into a CPU registers while working on them, for performance reasons. If your computer contains 
more than one CPU, each thread may run on a different CPU. That means, that each thread may copy the 
variables into the CPU registers of different CPUs.

With non-volatile variables there are no guarantees about when the Java Virtual Machine (JVM) reads data from main
memory into CPU registers, or writes data from CPU registers to main memory. This can cause several problems

The problem with threads not seeing the latest value of a variable because it has not yet been written back
to main memory by another thread, is called a "visibility" problem


Read more: <a href="https://jenkov.com/tutorials/java-concurrency/volatile.html">https://jenkov.com/tutorials/java-concurrency/volatile.html</a>