package abc.errorlogs.err.callable.java;
import java.util.concurrent.Callable;


/**
 * A callable version report of the Java architecture.
 * @author Gregory
 * @see #call() call()
 */
public class CallableVersionJavaArch implements Callable<String> {
  @Override
  public String call() {
    return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
  }
}
