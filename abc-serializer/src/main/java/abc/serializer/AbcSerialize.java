package abc.serializer;
import abc.serializer.logics.ASerialLogic;
import java.io.File;


/**
 * The serialization core class.
 * @author Gregory
 * @see #instance instance
 * @see #AbcSerialize() AbcSerialize()
 */
public class AbcSerialize {
  /**
   * The default {@link AbcSerialize} instance.
   * @see #AbcSerialize
   */
  public static final AbcSerialize instance;

  static {
    instance = new AbcSerialize();
  }

  private AbcSerialize() {
  }

  public final void performReading(ASerialLogic s, File f) {
    Serializer serializer = new Serializer(s);
    serializer.serialReading(f);
  }

  public final void performWriting(ASerialLogic s, File f) {
    Serializer serializer = new Serializer(s);
    serializer.serialWriting(f);
  }
}
