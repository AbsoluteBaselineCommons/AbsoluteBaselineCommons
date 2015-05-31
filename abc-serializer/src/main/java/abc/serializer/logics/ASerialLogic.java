package abc.serializer.logics;
import abc.serializer.AbcSerialize;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Definition of serialization logic. This defines how data input and output streams are used in serialization of data.
 * Besides the singleton class {@link Serializer}, this is the only class you need to subclass to create your own type
 * of serialization.
 * <h1>How It Works.</h1>
 * By creating a subclass of this class, and overriding its two methods, we already have the heart of the serialization
 * infrastructure. That subclass will be given as a parameter of the {@link AbcSerialize} class methods to perform the
 * #performReading(ASerialLogic, File)
 * @author Gregory
 * @see AbcSerialize
 */
abstract public class ASerialLogic {
  /**
   * A public constructor. This does nothing; it only exists in case I want to add anything (at this point, unnecessary
   * for overall operation).
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @see ASerialLogic
   */
  public ASerialLogic() {
  }

  /**
   * Perform a serial reading operation. This method gets data from a data-stream with specific implementation code for
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dis A {@link DataInputStream} object, representing the stream to read.
   * @throws IOException on any file-io exceptions.
   * @see #serialWriting(DataOutputStream) serialWriting(DataOutputStream)
   */
  abstract public void serialReading(DataInputStream dis) throws IOException;

  /**
   * Perform a serial writing operation. This method puts data into a data-stream with specific implementation code for
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dos A {@link DataOutputStream} object, representing the stream to write.
   * @throws IOException on any file-io exceptions.
   * @see #serialReading(DataInputStream) serialReading(DataInputStream)
   */
  abstract public void serialWriting(DataOutputStream dos) throws IOException;
}
