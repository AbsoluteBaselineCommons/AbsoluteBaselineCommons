package abc.stringlist.listable;
import java.io.File;


/**
 * <h2>ListBasic</h2>
 * @author Gregory
 */
public class ListBasic extends AStringList {

  public ListBasic(boolean b, double d, File f) {
    super(b, d, f);
  }

  @Override
  public String toString() {
    return String.format("%s:%s", getClass().getSimpleName()," - A basic list.");
  }
}
