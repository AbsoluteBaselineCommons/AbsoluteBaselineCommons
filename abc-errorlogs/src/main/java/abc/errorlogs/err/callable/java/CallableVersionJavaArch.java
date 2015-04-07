package abc.errorlogs.err.callable.java;
import java.util.concurrent.Callable;


/**
 * <h2>CallableAppVer</h2>
 * @author Gregory
 */
public class CallableVersionJavaArch implements Callable<String> {
  @Override
  public String call() {
    return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
  }
}
