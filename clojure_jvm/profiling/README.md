# Clojure Startup Profiling

This is a profiling test to see where the time goes when a Clojure application boots on the desktop. The test program is the following:

```clojure
(ns hello.core
  (:gen-class))

(defn -main []
  (println "Hello world"))
```

It is run from the command line like any other Java program using various techniques to profile the startup time.

## Environment

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_60-b19) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.60-b09, mixed mode) |
| Clojure | 1.6.0 |
| Operating System | Ubuntu Linux 13.10 64 bit |
| Computer | Lenovo Yoga 2 Pro i7-4500U 1.8 GHz, 4 GB RAM, 256 GB SSD |

## Setup for all experiments

Compile Clojure sources:

```
java -cp src/clj:../../clojure-1.6.0.jar -Dclojure.compile.path=classes clojure.lang.Compile hello.core
```

## No profiling (for comparison)

This test runs the program without any profiling. This is to provide a baseline to see how much overhead the different profiling techniques introduce.

Execute program:
```
java -cp ../../clojure-1.6.0.jar:classes hello.core
```

## Class loading timestamps

This test introduces a simple Java profiling agent to get timestamps for class loading events. The profiling agent wraps class loading to print the current time before each class is loaded. By observing these times one can infer roughly the amount of wall time spent on JVM startup, Clojure runtime startup, loading core Clojure classes, and executing the user's Clojure code. This introduces a small amount of overhead.

Compile and build Java profiling agent:

```
javac -d classes src/java/ClassLoadTracer.java
jar -cvfm classes/tracer.jar src/java/manifest.mf classes/ClassLoadTracer*.class
```

Execute program with profiling agent:

```
java -javaagent:classes/tracer.jar -cp ../../clojure-1.6.0.jar:classes hello.core
```

## Tracing

This uses the YourKit Java profiler to get more detailed profiling information. The YourKit profiler must be available through the `YJP_PATH` environment variable.

Execute program with profiling agent:

```
java -agentpath:$YJP_HOME/bin/linux-x86-64/libyjpagent.so=dir=logs,logdir=logs,probe_disable=*,quiet,disablealloc,disablestacktelemetry,disableexceptiontelemetry,disabletracing,tracing -cp $YJP_HOME/lib/yjp.jar:../../clojure-1.6.0.jar:classes hello.core
```

## Sampling

The YourKit sampling profiler can also be used by substituting `sampling` for `tracing`.

Execute program with profiling agent:

```
java -agentpath:$YJP_HOME/bin/linux-x86-64/libyjpagent.so=dir=logs,logdir=logs,probe_disable=*,quiet,disablealloc,disablestacktelemetry,disableexceptiontelemetry,disabletracing,sampling -cp $YJP_HOME/lib/yjp.jar:../../clojure-1.6.0.jar:classes hello.core
```
