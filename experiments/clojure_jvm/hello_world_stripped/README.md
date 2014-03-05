# Clojure Hello World Startup Time Testing

This is a simple Clojure Hello World app for testing startup times. 

## Setup Information

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_51-b13) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode) |
| Clojure | 1.5.1 |
| Operating System | Ubuntu Linux 13.10 64 bit |
| Computer | Lenovo Yoga 2 Pro i7-4500U 1.8 GHz, 8 GB RAM, 256 GB SSD |

## Run time (JAR)

```
# Compile
lein uberjar

# Remove .clj files from uberjar (or they will slow startup)

# Run
time java -jar target/hello-0.1.0-SNAPSHOT-standalone.jar
```

| Time (s) |
| ---- |
| 1.03 |
| 1.07 |
| 1.04 |
| 0.99 |
| 1.11 |
| Average: 1.048 |

## Run time (without JAR)

```
# Compile
lein compile

# Run
time java -cp ../../clojure-1.5.1.jar:target/classes hello.core
```

| Time (s) |
| ---- |
| 1.03 |
| 1.04 |
| 1.02 |
| 1.03 |
| 0.99 |
| Average: 1.022 |

## Profiling

Profiling information is obtained using YourKit with the following command:

```
java -agentpath:$HOME/app/yjp-2013-build-13072/bin/linux-x86-64/libyjpagent.so=onexit=snapshot,sampling -jar target/hello-0.1.0-SNAPSHOT-standalone.jar
```

This creates a single snapshot profiling the startup of the Hello World JAR using sampling.
