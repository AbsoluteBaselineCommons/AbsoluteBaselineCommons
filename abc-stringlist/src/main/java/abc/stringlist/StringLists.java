package abc.stringlist;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * <h2>StringLists</h2>
 * The string lists. This provides a container for handling any and all individual lists of {@link String}s from given
 * {@link File} objects, so that a more randomized collection of words and texts can be obtained at runtime.
 * <p/>
 * @author Gregory
 * @see #instance instance
 * @see #StringLists StringLists
 */
public class StringLists {
  /**
   * The default {@link StringLists} instance.
   */
  public static final StringLists instance;

  static {
    instance = new StringLists();
  }

  private final Map<String, StringList> stringLists;

  {
    stringLists = new ConcurrentHashMap<>(0);
  }

  private StringLists() {
  }

  public final String getRandomString(String s) {
    return stringLists.get(s).getRandomString();
  }

  public final StringList getStringList(String s) {
    return stringLists.get(s);
  }

  public final void addStringList(String s, StringList l) {
  }

  public final void delStringList(String s) {
    stringLists.remove(s);
  }
}
