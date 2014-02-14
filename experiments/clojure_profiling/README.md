# Clojure Startup Profiling

This is a profiling test to see where the time goes when a Clojure application boots on the desktop.

## Setup Information

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_51-b13) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode) |
| Clojure | 1.5.1 |
| Operating System | Ubuntu Linux 13.10 64 bit |
| Computer | Lenovo Yoga 2 Pro i7-4500U 1.8 GHz, 4 GB RAM, 256 GB SSD |

## Application execution time

Compile sources:

```
javac -cp target/classes -d target/classes src/java/ExecutionTimeLoader.java
lein compile
```

Time program execution:

```
time java -cp lib/clojure-1.5.1.jar:target/classes ExecutionTimeLoader
```

| Time (s) |
| ---- |
| 1.03 |
| 1.05 |
| 1.01 |
| 1.03 |
| 1.01 |
| Average: 1.026 |

## Clojure bootstrap time

Compile sources:

```
javac -cp target/classes -d target/classes src/java/ClojureExecutionTimeLoader.java
lein compile
```

```
time java -cp lib/clojure-1.5.1.jar:target/classes ClojureExecutionTimeLoader
```

The `time` output gives us the total run time of the program and the printed time gives us the time to execute our Clojure function. However, I'm not sure how accurate this time is. For these measurements the total program execution time is about 1000 ms and the measured time for our Clojure call is 750 ms. This leaves 250 ms of time for Java. But if you run the program with the profiler it shows that almost all of the time goes to executing the Clojure call. Also, if you run it without the Clojure call it takes only about 40 ms.

There are two things that I think might be happening. First, part of the work for loading the hello.core class may be happening outside of our timing calls. And secondly, there might be some compiler optimizations that cause part of the function call to occur outside of our timing.

| Time (ms) |
| ---- |
| 746 |
| 746 |
| 749 |
| 750 |
| 729 |
| Average: 744 |

## Profiling

Compile the Clojure source and then the Loader class with the YourKit JAR:

```
javac -cp ~/app/yjp-2013-build-13072/lib/yjp.jar:target/classes -d target/classes src/java/ProfilingLoader.java
lein compile
```

Run the class to profile Clojure bootstrap time:

```
java -agentpath:$HOME/app/yjp-2013-build-13072/bin/linux-x86-64/libyjpagent.so=dir=logs/profiling,logdir=logs/profiling,sampling_settings_path=cpu_sampling_settings -cp $HOME/app/yjp-2013-build-13072/lib/yjp.jar:lib/clojure-1.5.1.jar:target/classes ProfilingLoader
```

This creates a single snapshot profiling the bootstrapping and execution of our Clojure code. 
