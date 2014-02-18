# Clojure Android Hello World Compilation Example

This is an example of the compilation of a Clojure Hello World app for Android with a few startup time measurements.

## Setup Information

| Tool | Version |
| --- | --- |
| Java Runtime | Java(TM) SE Runtime Environment (build 1.7.0_51-b13) |
| JVM | Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode) |
| Java target | 1.6 |
| Clojure | 1.5.1 |
| Android SDK | 19 |
| Android phone | Nexus 4 |
| Android version | 4.4.2 |

## Compilation

The application was built using `lein release`. This produces an APK file. The APK file can be opened by renaming it to a zip file, from which the `classes.dex` file can be extracted. This is dedexed with [dex2jar](http://code.google.com/p/dex2jar/).

## Run time

Run times are measured from when the START action is printed to the log to start `org.helloandroid.core/SplashActivity` to when the log message indicates that the `org.helloandroid.core/MyActivity` activity has been displayed. Note that this includes displaying a splash screen and loading of some neko libraries. Initially I thought that the effect of this would be negligible but with removing those actually reduces start times by a few seconds.

| Time (s) | Log file |
| ---- | --- |
| 5.486 | 20140127_1550 |
| 5.626 | 20140127_1552 |
| Average: 5.556 |
