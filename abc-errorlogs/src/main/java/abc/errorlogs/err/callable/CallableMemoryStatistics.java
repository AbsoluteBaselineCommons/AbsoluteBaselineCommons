package abc.errorlogs.err.callable;
import java.util.concurrent.Callable;


/**
 * <h2>CallableVersionGameCore</h2>
 * @author Gregory
 */
public class CallableMemoryStatistics implements Callable<String> {
  @Override
  public String call() {
    Runtime runtime = Runtime.getRuntime();
    long i = runtime.maxMemory();
    long j = runtime.totalMemory();
    long k = runtime.freeMemory();
    long l = i / 1024L / 1024L;
    long i1 = j / 1024L / 1024L;
    long j1 = k / 1024L / 1024L;
    return String.format("%s bytes (%s MB) / %s bytes (%s MB) up to %s bytes (%s MB)",
                         k, j1, j, i1, i, l);
  }
}
