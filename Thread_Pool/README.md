### Notes
A thread pool is a pool threads that can be "reused" to execute tasks, so that each thread may execute more than one task.
A thread pool is an alternative to creating a new thread for each task you need to execute. 


How a Thread Pool Works

Instead of starting a new thread for every task to execute concurrently, the task can be passed to a thread
pool. As soon as the pool has any idle threads the task is assigned to one of them and executed. Internally
the tasks are inserted into a Blocking Queue which the threads in the pool are dequeuing from. When a 
task is inserted into the queue one of the idle threads will dequeue it successfully and execute it.
The rest of the idle threads in the pool will be blocked waiting to dequeue tasks. 