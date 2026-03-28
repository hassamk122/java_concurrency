### Notes
The Java ExecutorService is very similar to a thread pool. 

### Runnable vs. Callable
The Runnable interface is very similar to the Callable interface. The Runnable interface represents a
task that can be executed concurrently by a thread or an ExecutorService. The Callable can only be
executed by an ExecutorService. 



The main difference between the Runnable run() method and the Callable call() method is that the call() method 
can return an Object from the method call. Another difference between call() and run() is that call() 
can throw an exception, whereas run() cannot (except for unchecked exceptions - subclasses of 
RuntimeException). 


You can cancel a task (Runnable or Callable) submitted to a Java ExecutorService by calling the 
cancel() method on the Future returned when the task is submitted. 