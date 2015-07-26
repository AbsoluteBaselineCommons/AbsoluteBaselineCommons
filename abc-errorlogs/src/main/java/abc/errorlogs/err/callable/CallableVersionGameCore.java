package abc.errorlogs.err.callable;
import java.util.concurrent.Callable;


/**
 * A callable version method. This is meant to output the version of the {@code abc.core} modules; additional modules
 * may need to add their own callable object.
 * @author Gregory
 * @see #call() call()
 */
public class CallableVersionGameCore implements Callable<String> {
  @Override
  public String call() throws Exception {
    //TODO: This should be the version of the platform modules!
    return "versions";
  }
}
