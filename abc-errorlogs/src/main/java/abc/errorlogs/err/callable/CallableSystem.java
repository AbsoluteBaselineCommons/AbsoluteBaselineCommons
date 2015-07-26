package abc.errorlogs.err.callable;
import java.util.concurrent.Callable;


/**
 * A callable operating-system method. This outputs the OS name, architecture name, and version, all as a String value.
 * @author Gregory
 * @see #call() call()
 */
public class CallableSystem implements Callable<String> {
  @Override
  public String call() throws Exception {
    String osname = System.getProperty("os.name");
    String osarch = System.getProperty("os.arch");
    String osvers = System.getProperty("os.version");
    String s = String.format("%s (%s) version %s", osname, osarch, osvers);
    return String.format("OPERATING SYSTEM:\n  %s", s);
  }
}
