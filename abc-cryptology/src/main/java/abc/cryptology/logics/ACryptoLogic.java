package abc.cryptology.logics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * <h2>ACryptoLogic</h2>
 * A crypto-logic definition. This defines how the data input and output streams are used. It is the primary way to use
 * the {@link AbcCryptoLogic}
 * <h3>Cautions and Warnings.</h3>
 * Care must be taken that both the {@link #performDecryption(DataInputStream) performDecryption(DataInputStream)} and
 * the {@link #performEncryption(DataOutputStream) performEncryption(DataOutputStream)} methods are loading and saving
 * values in the same order, or else we will experience errors, somewhere down the line.
 * <p/>
 * Classes extending this one do not need to explicitly flush and close streams; the {@code Encryption} class does it.
 * <p/>
 * Besides the above two methods defined herein, do we also need to provide for key unwrapping and key wrapping?
 * @author Gregory
 */
abstract public class ACryptoLogic {
  /**
   * A public constructor. This does nothing; it only exists in case I want to add anything (at this point, unnecessary
   * for overall operation).
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @see ACryptoLogic
   */
  public ACryptoLogic() {
  }

  /**
   * Perform a data-encryption operation. This method reads data from an input stream with specific implementation code
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dis A {@link DataInputStream} object, representing the stream to read.
   * @see ACryptoLogic
   * @see #performEncryption(DataOutputStream) performEncryption(DataOutputStream)
   */
  abstract public void performDecryption(DataInputStream dis) throws IOException;

  /**
   * Perform a data-encryption operation. This method saves data into an input stream with specific implementation code
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dos A {@link DataOutputStream} object, representing the stream to write.
   * @see ACryptoLogic
   * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
   */
  abstract public void performEncryption(DataOutputStream dos) throws IOException;
}