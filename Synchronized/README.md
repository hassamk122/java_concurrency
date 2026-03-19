### The Java synchronized Keyword
All synchronized blocks synchronized on the same object can only have one thread executing inside them 
at the same time. All other threads attempting to enter the synchronized block are blocked until the 
thread inside the synchronized block exits the block. 

### Synchronized Block Performance Overhead
There is a small performance overhead associated with entering and exiting a synchronized block in Java. As Jave 
have evolved this performance overhead has gone down, but there is still a small price to pay.

The performance overhead of entering and exiting a synchronized block is mostly something to worry 
about if you enter and exit a synchronized block lots of times within a tight loop or so. 