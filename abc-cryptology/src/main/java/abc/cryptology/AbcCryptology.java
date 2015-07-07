package abc.cryptology;
import abc.cryptology.logics.ACryptoLogic;
import java.io.File;


/**
 * A cryptology implementation. This static class defines the methodology of a plain-Java cryptology implementation.
 * <h3>Final Note</h3>
 * Originally from MrDeathJockey's YouTube video, named "Enhanced String encryption with PBE, DES and MD5 - Java
 * Intermediate Tutorial #18", the contents of the {@link Encryption} class was heavily modified to be what it is now.
 * I have tweaked several things: I created an abstract class AEncryption to be the parent of Encryption to introduce a
 * level of abstraction.
 * <p/>
 * Link to the YouTube video: https://youtu.be/NpaUuEvKXqs?list=PL7EB0FF7711646514
 * @author Gregory
 * @see #instance instance
 * @see #AbcCryptoLogicAbcCryptology
 */
public class AbcCryptology {
  /**
   * The default {@link AbcCryptology} instance.
   */
  public static final AbcCryptology instance;

  static {
    instance = new AbcCryptology();
  }

  private AbcCryptology() {
  }

  /**
   * Perform the decryption operation. This converts encrypted data into decrypted data, using a series of values.
   * <p/>
   * The parameter for the cipher key can be any String value that Java Cryptography can use; however, the example from
   * the class javadoc used "PBEWithMD5AndDES" as the implementation.
   * @param l A {@link Long} value, representing a {@link #seed seed} value.
   * @param c An {@link ACryptoLogic} object, representing the implementation.
   * @param r A {@link String} object, representing the cryptographic type.
   * @param f A {@link File} object, representing the source file object.
   * @param s A {@link String} object, representing the cipher key to use.
   */
  public final void performDecryption(long l, ACryptoLogic c, String r, File f, String s) {
    Encryption encryption = new Encryption(l, c, r);
    encryption.performDecrypting(f, s);
  }

  /**
   * Perform the encryption operation. This converts decrypted data into encrypted data, using a series of values.
   * <p/>
   * The parameter for the cipher key can be any String value that Java Cryptography can use; however, the example from
   * the class javadoc used "PBEWithMD5AndDES" as the implementation.
   * @param l A {@link Long} value, representing a {@link #seed seed} value.
   * @param c An {@link ACryptoLogic} object, representing the implementation.
   * @param r A {@link String} object, representing the cryptographic type.
   * @param f A {@link File} object, representing the target file object.
   * @param s A {@link String} object, representing the cipher key to use.
   */
  public final void performEncryption(long l, ACryptoLogic c, String r, File f, String s) {
    Encryption encryption = new Encryption(l, c, r);
    encryption.performEncrypting(f, s);
  }
}
