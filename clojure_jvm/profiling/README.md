# Clojure Startup Profiling

This is a profiling test to see where the time goes when a Clojure application boots on the desktop. The test program is the following:

```clojure
(ns hello.core
  (:gen-class))

(defn -main []
  (println "Hello world"))
```

It is run from the command line using YourKit profiler sampling to get class load timestamps.

## Environment

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_60-b19) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.60-b09, mixed mode) |
| Clojure | 1.6.0 |
| Operating System | Ubuntu Linux 13.10 64 bit |
| Computer | Lenovo Yoga 2 Pro i7-4500U 1.8 GHz, 4 GB RAM, 256 GB SSD |

## Setup

Compile Clojure sources:

```
java -cp src/clj:../../clojure-1.6.0.jar -Dclojure.compile.path=classes clojure.lang.Compile hello.core
```

Compile Java sources:

```
javac -cp $YJP_HOME/lib/yjp.jar:classes -d classes src/java/ProfilingLoader.java
```

Execute program with class loading probe and snapshot:

```
java -agentpath:$YJP_HOME/bin/linux-x86-64/libyjpagent.so=dir=logs,logdir=logs,sampling_settings_path=cpu_sampling_settings,onexit=snapshot,probe_disable=com.yourkit.probes.builtin.*,probe_on=com.yourkit.probes.builtin.ClassLoading -cp $YJP_HOME/lib/yjp.jar:../../clojure-1.6.0.jar:classes hello.core
```

Execute program with only class loading probe:

```
java -agentpath:$YJP_HOME/bin/linux-x86-64/libyjpagent.so=dir=logs,logdir=logs,probe_disable=com.yourkit.probes.builtin.*,probe_on=com.yourkit.probes.builtin.ClassLoading -cp $YJP_HOME/lib/yjp.jar:../../clojure-1.6.0.jar:classes hello.core
```

Execute program with sampling profiling:

```
java -agentpath:$YJP_HOME/bin/linux-x86-64/libyjpagent.so=dir=logs,logdir=logs,probe_disable=com.yourkit.probes.builtin.*,probe_on=com.yourkit.probes.builtin.ClassLoading -cp $YJP_HOME/lib/yjp.jar:../../clojure-1.6.0.jar:classes ProfilingLoader
```

Environment variable YJP_HOME must be set to the YourKit profiler installation directory.
