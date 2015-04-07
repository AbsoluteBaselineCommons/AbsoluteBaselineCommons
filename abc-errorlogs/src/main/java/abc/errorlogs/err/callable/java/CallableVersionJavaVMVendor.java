package abc.errorlogs.err.callable.java;
import java.util.concurrent.Callable;


/**
 * <h2>CallableVersionGameCore</h2>
 * @author Gregory
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
