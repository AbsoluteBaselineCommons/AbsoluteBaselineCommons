package abc.cryptology;
import abc.cryptology.logics.Crypto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;


/**
 * A cryptology implementation. This static class defines the methodology of a plain-Java cryptology implementation.
 * <h1>Final Note</h1>
 * Originally by MrDeathJockey's YouTube video, <a href="https://youtu.be/NpaUuEvKXqs?list=PL7EB0FF7711646514">Enhanced
 * String encryption with PBE, DES and MD5 - Java Intermediate Tutorial #18</a>", several cryptology classes were quite
 * heavily modified to be what they are now. Many things have been tweaked: made the abstract class {@link Encryption}
 * to be the parent of {@link EncryptionBase} to introduce the level of abstraction, then created that EncryptionBase
 * class to provide the utility methodology.
 * @author Gregory
 * @see #instance instance
 * @see #AbcCryptology() AbcCryptology()
 * @see #performDecryption(long,Crypto,String,File,String) performDecryption(long,Crypto,String,File,String)
 * @see #performEncryption(long,Crypto,String,File,String) performEncryption(long,Crypto,String,File,String)
 */
public class AbcCryptology {
  /**
   * The default {@link AbcCryptology} instance.
   * @see AbcCryptology
   * @see #AbcCryptology() AbcCryptology()
   */
  public static final AbcCryptology instance;

  static {
    instance = new AbcCryptology();
  }

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see AbcCryptology
   */
  private AbcCryptology() {
  }

  /**
   * Perform the decryption operation. This converts encrypted data into decrypted data, using a series of values.
   * <p/>
   * The parameter for {@code t} (the cipher key) can be any String value that Java Cryptography can use; however, the
   * example from the class javadoc used "PBEWithMD5AndDES" as the implementation.
   * @param l A {@link Long} value, representing a {@link #seed seed} value.
   * @param c A {@link Crypto} object, representing the implementation.
   * @param s A {@link String} object, representing the cryptographic type.
   * @param f A {@link File} object, representing the source file object.
   * @param t A {@link String} object, representing the cipher key to use.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
   * @throws FileNotFoundException
   * @see AbcCryptology
   * @see #performEncryption(long,Crypto,String,File,String)
   */
  public final void performDecryption(long l, Crypto c, String s, File f, String t)
      throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
      InvalidAlgorithmParameterException, FileNotFoundException, IOException {
    EncryptionBase eb = new EncryptionBase(l, c, s);
    eb.performDecrypting(f, t);
  }

  /**
   * Perform the encryption operation. This converts decrypted data into encrypted data, using a series of values.
   * <p/>
   * The parameter for {@code t} (the cipher key) can be any String value that Java Cryptography can use; however, the
   * example from the class javadoc used "PBEWithMD5AndDES" as the implementation.
   * @param l A {@link Long} value, representing a {@link #seed seed} value.
   * @param c A {@link Crypto} object, representing the implementation.
   * @param s A {@link String} object, representing the cryptographic type.
   * @param f A {@link File} object, representing the target file object.
   * @param t A {@link String} object, representing the cipher key to use.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
   * @throws FileNotFoundException
   * @see AbcCryptology
   * @see #performDecryption(long,Crypto,String,File,String)
   */
  public final void performEncryption(long l, Crypto c, String s, File f, String t)
      throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
      InvalidAlgorithmParameterException, FileNotFoundException, IOException {
    EncryptionBase eb = new EncryptionBase(l, c, s);
    eb.performEncrypting(f, t);
  }
}
