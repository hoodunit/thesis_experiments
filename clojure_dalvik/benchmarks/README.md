# Clojure Android Startup Benchmarks

Startup times are measured from when the START action is printed to the log to start the respective application to when the log message indicates that the main activity has been displayed e.g.

```
# Start time
03-06 19:07:49.003   801         ActivityManager  I  Start proc com.android.helloworldminimal for activity com.android.helloworldminimal/.HelloWorld: pid=25720 uid=10147 gids={50147}

# End time
03-06 19:07:50.653   801         ActivityManager  I  Displayed com.android.helloworldminimal/.HelloWorld: +1s664ms
```

The app is installed before each trial set. The phone is then restarted and left alone for at least two minutes to let any applications that start on boot load. The benchmark application is then started by selecting the icon in the application drawer. After it displays it is closed by swiping the app away in the recent applications list. This is repeated for the number of trials in the trial set.
