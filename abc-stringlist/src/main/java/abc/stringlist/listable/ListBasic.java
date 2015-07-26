package abc.stringlist.listable;
import java.io.File;
import java.io.IOException;


/**
 * A basic string list.
 * @author Gregory
 */
public class ListBasic extends AStringList {
  /**
   * A public constructor.
   * @param b A {@link Boolean} condition, representing whether the list is reversable.
   * @param d A {@link Double} value, representing the turnover rate.
   * @param f A {@link File} object, representing the file for the list.
   * @throws java.io.FileNotFoundException
   * @see ListBasic
   */
  public ListBasic(boolean b, double d, File f) throws IOException {
    super(b, d, f);
  }

  @Override
  public String toString() {
    return String.format("%s:%s", getClass().getSimpleName(), " - A basic list.");
  }
}
