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

## Run time

Compile:

```
java -cp src:target/classes:../../clojure-1.5.1.jar -Dclojure.compile.path=target/classes clojure.lang.Compile hello.core 

# To elide metadata
java -cp src:target/classes:../../clojure-1.5.1.jar -Dclojure.compile.path=target/classes -Dclojure.compiler.elide-meta='[:doc :file :line :column :added]' clojure.lang.Compile hello.core 
```

Run:

```
time java -cp ../../clojure-1.5.1.jar:target/classes hello.core
```

| Time (s) |
| ---- |
| 1.00 |
| 0.99 |
| 0.97 |
| 1.01 |
| 1.00 |
| Average: 0.994 |


## Run time (metadata elided from compiler and program)

Compile:

```
java -cp src:target/classes:../../clojure-1.5.1-elided.jar -Dclojure.compile.path=target/classes -Dclojure.compiler.elide-meta='[:doc :file :line :column :added]' clojure.lang.Compile hello.core 
```

Run:

```
time java -cp ../../clojure-1.5.1-elided.jar:target/classes hello.core
```

| Time (s) |
| ---- |
| 0.96 |
| 0.94 |
| 0.96 |
| 0.97 |
| 0.94 |
| 0.94 |
| 0.97 |
| 0.98 |
| 0.94 |
| 0.97 |
| Average: 0.957 |
