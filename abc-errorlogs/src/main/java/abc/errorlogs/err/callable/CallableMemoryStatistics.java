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
    long i = runtime.maxMemory();
    long j = runtime.totalMemory();
    long k = runtime.freeMemory();
    long l = i / 1024L / 1024L;
    long m = j / 1024L / 1024L;
    long n = k / 1024L / 1024L;
    return String.format("%s bytes (%s MB) / %s bytes (%s MB) up to %s bytes (%s MB)", k, n, j, m, i, l);
  }
}
