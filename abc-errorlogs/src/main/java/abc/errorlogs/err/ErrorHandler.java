package abc.errorlogs.err;


/**
 * The error handler.
 * @author Gregory
 * @see #instance instance
 * @see #ErrorHandler ErrorHandler
 */
public class ErrorHandler {
  /**
   * The default instance.
   * @see ErrorHandler
   */
  public static final ErrorHandler instance;

  static {
    instance = new ErrorHandler();
  }

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see ErrorHandler
   */
  private ErrorHandler() {
  }

  //TODO: Fill out the "error-handler" methodology with fields and methods.
}
