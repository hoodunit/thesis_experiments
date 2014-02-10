# Clojure Hello World AOT Compilation Example - with uberjar

This is an example of the compilation of a Clojure Hello World app and packaging into an uberjar. Compile and package with `lein uberjar`.

## Setup Information

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_51-b13) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode) |
| Clojure | 1.5.1 |

## Run time

`time java -jar target/hello-0.1.0-SNAPSHOT-standalone.jar`

| Time |
| ---- |
| 1.03 |
| 1.07 |
| 1.04 |
| 0.99 |
| 1.11 |
| Average: 1.048 |
