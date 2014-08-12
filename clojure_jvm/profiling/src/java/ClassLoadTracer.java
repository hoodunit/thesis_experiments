import java.lang.instrument.*;
import java.security.*;

public class ClassLoadTracer {
    public static void premain(String agentArgs, Instrumentation inst) {
		final java.io.PrintStream out = System.out;
		inst.addTransformer(new ClassFileTransformer() {
                public byte[] transform(ClassLoader loader, String className,
                                        Class classBeingRedefined,
                                        ProtectionDomain protectionDomain,
                                        byte[] classfileBuffer) throws IllegalClassFormatException {

                    out.print("" + System.currentTimeMillis() + " " 
                              + className + " (loaded by " 
                              + loader + ")\n");

                    // return class unmodified
                    return null;
                }
            });
	}
}
