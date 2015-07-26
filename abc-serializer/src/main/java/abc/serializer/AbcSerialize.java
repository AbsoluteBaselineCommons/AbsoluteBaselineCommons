package abc.serializer;
import abc.serializer.logics.ASerialLogic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * The serialization core class.
 * @author Gregory
 * @see #instance instance
 * @see #AbcSerialize() AbcSerialize()
 * @see #performReading(ASerialLogic,File) performReading(ASerialLogic,File)
 * @see #performWriting(ASerialLogic,File) performWriting(ASerialLogic,File)
 */
public class AbcSerialize {
  /**
   * The default instance.
   * @see #AbcSerialize
   */
  public static final AbcSerialize instance;

  static {
    instance = new AbcSerialize();
  }

  /**
   * A private constructor.
   * @see #AbcSerialize
   */
  private AbcSerialize() {
  }

  /**
   * Perform a reading operation.
   * @param s A {@link ASerialLogic} object, representing the serial logic.
   * @param f A {@link File} object, representing the file to read.
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   * @see #AbcSerialize
   */
  public final void performReading(ASerialLogic s, File f) throws FileNotFoundException, IOException {
    Serializer serializer = new Serializer(s);
    serializer.serialReading(f);
  }

  /**
   * Perform a writing operation.
   * @param s A {@link ASerialLogic} object, representing the serial logic.
   * @param f A {@link File} object, representing the file to write.
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   * @see #AbcSerialize
   */
  public final void performWriting(ASerialLogic s, File f) throws FileNotFoundException, IOException {
    Serializer serializer = new Serializer(s);
    serializer.serialWriting(f);
  }
}
