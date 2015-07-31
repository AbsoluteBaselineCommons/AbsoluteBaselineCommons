package abc.errorlogs.err.callable;
import java.util.concurrent.Callable;


/**
 * A callable memory-statistics report. This adds to the error-log various aspects of the user's memory specifications.
 * It tells the maximum JVM memory, the total JVM memory, and the current free JVM memory.
 * @author Gregory
 * @see #call() call()
 */
public class CallableMemoryStatistics implements Callable<String> {
  @Override
  public String call() {
    Runtime runtime = Runtime.getRuntime();
    long l0 = runtime.maxMemory();
    long l3 = l0 / 1024L / 1024L;
    long l1 = runtime.totalMemory();
    long l4 = l1 / 1024L / 1024L;
    long l2 = runtime.freeMemory();
    long l5 = l2 / 1024L / 1024L;
    return String.format("%s bytes (%s MB) / %s bytes (%s MB) up to %s bytes (%s MB)", l2, l5, l1, l4, l0, l3);
  }
}
