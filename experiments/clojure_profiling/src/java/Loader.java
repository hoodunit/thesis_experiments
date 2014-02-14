import hello.core;
import com.yourkit.api.Controller;

public class Loader {
    public static void main(String[] args){
        try{
            Controller controller = new Controller();
            controller.startCPUSampling(null);
            new core().greet();
            controller.stopCPUProfiling();
            controller.captureMemorySnapshot();
        } catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
