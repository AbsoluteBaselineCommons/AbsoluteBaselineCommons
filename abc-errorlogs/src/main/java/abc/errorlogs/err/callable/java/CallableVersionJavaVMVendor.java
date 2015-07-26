package abc.errorlogs.err.callable.java;
import java.util.concurrent.Callable;


/**
 * A callable version report of the JVM vendor.
 * @author Gregory
 * @see #call() call()
 */
public class CallableVersionJavaVMVendor implements Callable<String> {
  @Override
  public String call() {
    return String.format("%s (%s) %s",
                         System.getProperty("java.vm.name"),
                         System.getProperty("java.vm.info"),
                         System.getProperty("java.vm.vendor"));
  }
}
