package abc.cryptology.logics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Definition of cryptographic logic. This defines how data input and output streams are used in cryptography of data.
 * Beside the singleton class {@link AbcCryptology}, this is the only class you need to subclass to make your own type
 * of serialization.
 * <blockquote><b><i>WARNING:</i></b> Care must be taken that both of the cryptological operations
 * ({@link #performDecryption(DataInputStream) performDecryption(DataInputStream)} and
 * {@link #performEncryption(DataOutputStream) performEncryption(DataOutputStream)}) are loading and saving values in
 * the same order, or else we will experience errors, somewhere down the line.</blockquote>
 * Classes extending this one do not need to explicitly flush and close streams; the {@code Encryption} class does it.
 * <p/>
 * Besides the above two methods defined herein, do we also need to provide for key unwrapping and key wrapping?
 * @author Gregory
 * @see #Crypto() Crypto()
 * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
 * @see #performEncryption(DataInputStream) performEncryption(DataInputStream)
 */
abstract public class Crypto {
  /**
   * A public constructor. This does nothing; it only exists in case I want to add anything (at this point, unnecessary
   * for overall operation).
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @see Crypto
   */
  public Crypto() {
  }

  /**
   * Perform a data-encryption operation. This method reads data from an input stream with specific implementation code
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dis A {@link DataInputStream} object, representing the stream to read.
   * @throws IOException on any file-IO exceptions.
   * @see Crypto
   * @see #performEncryption(DataOutputStream) performEncryption(DataOutputStream)
   */
  abstract public void performDecryption(DataInputStream dis) throws IOException;

  /**
   * Perform a data-encryption operation. This method saves data into an input stream with specific implementation code
   * handling the particulars that you define for the particular file.
   * <p/>
   * See the javadoc in this abstract class, for general cautions and warnings.
   * @param dos A {@link DataOutputStream} object, representing the stream to write.
   * @throws java.io.IOException on any file-IO exceptions.
   * @see Crypto
   * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
   */
  abstract public void performEncryption(DataOutputStream dos) throws IOException;
}
