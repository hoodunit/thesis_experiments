import hello.core;
import com.yourkit.api.Controller;

public class ProfilingLoader {
    public static void main(String[] args){
        try{
            Controller controller = new Controller();
            controller.startCPUSampling(null);
            new core();
            controller.stopCPUProfiling();
            controller.captureSnapshot(Controller.SNAPSHOT_WITHOUT_HEAP);
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
