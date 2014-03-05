import hello.core;

public class ClojureExecutionTimeLoader {
    public static void main(String[] args){
        long startTimeNs = System.nanoTime();
        new core();
        long endTimeNs = System.nanoTime();
        long runTimeNs = endTimeNs - startTimeNs;
        long runTimeMs = runTimeNs / 1000 / 1000;
        System.out.println("Run time: " + runTimeMs);
    }
}
