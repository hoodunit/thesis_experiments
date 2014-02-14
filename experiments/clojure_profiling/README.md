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
java -cp lib/clojure-1.5.1.jar:target/classes ClojureExecutionTimeLoader
```

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
