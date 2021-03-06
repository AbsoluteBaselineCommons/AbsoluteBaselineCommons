package abc.serializer;
import abc.serializer.logics.ASerialLogic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * A serializable abstract class.
 * @author Gregory
 */
abstract class ASerializer {
  /**
   * Serialization logic. This allows us to provide our own serialization implementation, while much of the boilerplate
   * code to instantiate data input and output streams are in another class. Serialization could be greatly simplified.
   */
  protected final ASerialLogic logic;

  protected ASerializer(ASerialLogic l) {
    logic = l;
  }

  /**
   * Perform a serial-reading operation. This method uses the {@link #logic logic} object, which is instantiated within
   * the constructor.
   * @param f A {@link File} object, representing the source file.
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   * @see ASerializer
   */
  abstract protected void serialReading(File f) throws FileNotFoundException, IOException;

  /**
   * Perform a serial-writing operation. This method uses the {@link #logic logic} object, which is instantiated within
   * the constructor.
   * @param f A {@link File} object, representing the target file.
   * @throws java.io.FileNotFoundException
   * @throws java.io.IOException
   * @see ASerializer
   */
  abstract protected void serialWriting(File f) throws FileNotFoundException, IOException;
}
