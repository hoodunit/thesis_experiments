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
```
time java -jar target/hello-0.1.0-SNAPSHOT-standalone.jar
```

| Time |
| ---- |
|  |
|  |
|  |
| Average:  |

## Clojure start time

```
time java -jar target/hello-0.1.0-SNAPSHOT-standalone.jar
```

| Time |
| ---- |
|  |
|  |
|  |
| Average:  |

## Profiling

Profiling information is obtained using YourKit with the following command:

```
java -agentpath:$HOME/app/yjp-2013-build-13072/bin/linux-x86-64/libyjpagent.so=onexit=snapshot,sampling -jar target/hello-0.1.0-SNAPSHOT-standalone.jar
```

This creates a single snapshot profiling the startup of the Hello World JAR using sampling.
