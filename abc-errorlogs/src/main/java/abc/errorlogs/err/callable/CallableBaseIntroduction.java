package abc.errorlogs.err.callable;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;


/**
 * A callable baseline introduction instance. This is for beginning an error log with a localizable message to send the
 * error report to the development team, or report it to the Github repository's issue tracker&hellip;.
 * @author Gregory
 * @see #call() call()
 */
public class CallableBaseIntroduction implements Callable<String> {
  private final ResourceBundle bundle;
  private final String[] strings;

  public CallableBaseIntroduction() {
    bundle = ResourceBundle.getBundle("abc.errorlogs.i18n.Callable");
    strings = new String[] {
      "callable.intro0", "callable.intro1", "callable.intro2", "callable.intro3", "callable.intro4", "callable.intro5",
      "callable.intro6", "callable.intro7", "callable.intro8", "callable.intro9", "callable.introA", "callable.introB"
    };
  }

  @Override
  public String call() {
    String output = "";
    output += "======================================== CREATE TRANSMISSION ========================================\n";
    for(String string : strings) {
      output += String.format("%s\n", bundle.getString(string));
    }
    output += "======================================== FINISH TRANSMISSION ========================================\n";
    return output;
  }
}
