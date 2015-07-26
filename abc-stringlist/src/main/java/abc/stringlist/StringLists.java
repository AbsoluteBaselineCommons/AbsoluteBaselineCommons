package abc.stringlist;
import abc.stringlist.listable.AStringList;
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
 * @see #map stringLists
 */
public class StringLists {
  /**
   * The default instance.
   * @see StringLists
   */
  public static final StringLists instance;

  static {
    instance = new StringLists();
  }

  /**
   * A map of string lists.
   * @see StringLists
   */
  private final Map<String, AStringList> map;

  {
    map = new ConcurrentHashMap<>(0);
  }

  /**
   * A private constructor.
   * @see StringLists
   */
  private StringLists() {
  }

  /**
   * Get a random string from a specified list.
   * @param s A {@link String} object, representing the list name.
   * @return A {@link String} object.
   * @see StringLists
   */
  public final String getRandomString(String s) {
    return map.get(s).getRandomString();
  }

  /**
   * Get a specified string list.
   * @param s A {@link String} object, representing the list name.
   * @return An {@link AStringList} object.
   * @see StringLists
   */
  public final AStringList getStringList(String s) {
    return map.get(s);
  }

  /**
   * Add a string list.
   * @param s A {@link String} object, representing the list name.
   * @param l A {@link AStringList} object, representing a list object.
   * @see StringLists
   */
  public final void addStringList(String s, AStringList l) {
    map.put(s, l);
  }

  /**
   * Add some string lists.
   * @param s A {@link String} object, representing the list name.
   * @param l A {@link AStringList} object, representing a list array.
   * @see StringLists
   */
  public final void addStringList(String s, AStringList... l) {
  }

  /**
   * Delete a string list.
   * @param s A {@link String} object, representing the list name.
   * @see StringLists
   */
  public final void delStringList(String s) {
    map.remove(s);
  }
}
