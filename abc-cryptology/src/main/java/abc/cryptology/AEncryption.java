package abc.cryptology;
import abc.cryptology.logics.ACryptoLogic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * An encryption definition. This abstract class breaks up the {@link Encryption} class, moving some of the prototyped
 * methodology into this one, allowing Encryption to be a subclass of this one.
 * @author Gregory
 * @see #logic logic
 * @see #seed seed
 * @see #AEncryption(long,ACryptoLogic,String) AEncryption(long,ACryptoLogic,String)
 * @see #getCipher(long,int,String) getCipher(long,int,String)
 * @see #performDecrypting(File,String) performDecrypting(File,String)
 * @see #performEncrypting(File,String) performEncrypting(File,String)
 */
abstract class AEncryption {
  /**
   * The cryptographic type. This is meant to be something like "{@code PBEWithMD5AndDES}".
   * @see AEncryption
   * @see String
   * @see #getCipher(long,int,String) getCipher(long,int,String)
   */
  private final String type;
  /**
   * The cryptographic logic. This allows for providing your own implementation that will be used in an instance of the
   * cryptographic methods; see that class javadoc for more information.
   * @see AEncryption
   * @see ACryptoLogic
   */
  protected final ACryptoLogic logic;
  /**
   * The cryptographic seed.
   * @see AEncryption
   * @see Long
   */
  protected final long seed;

  /**
   * A protected constructor. This takes a String parameter to initialize the secret key and cipher. It would likely be
   * a value such as "{@code PBEWithMD5AndDES}".
   * @param l A {@link Long} value, representing the random {@link #seed seed}.
   * @param c An {@link ACryptoLogic} object, representing the {@link #logic logic}.
   * @param s A {@link String} object, representing the {@link #type type}.
   * @see AEncryption
   * @see ACryptoLogic
   * @see #logic logic
   */
  protected AEncryption(long l, ACryptoLogic c, String s) {
    seed = l;
    logic = c;
    type = s;
  }

  /**
   * Get a cipher. This uses a cipher mode, encryption key, and parameter specs to initialize a cypher object. Mode may
   * likely be either Cipher.DECRYPT_MODE or Cipher.ENCRYPT_MODE....
   * <p/>
   * Also, this implementation catches but does not throw the following exceptions: {@link NoSuchAlgorithmException},
   * {@link InvalidKeySpecException}, {@link NoSuchPaddingException}, {@link InvalidKeyException}, and finally,
   * {@link InvalidAlgorithmParameterException}. (I may revisit it at a later time, as my knowledge of crypto grows.)
   * @param l A {@link Long} value, representing a seed value for our {@link Random} instance.
   * @param i An {@link Integer} value, representing the cryptography "direction".
   * @param s A {@link String} object, representing the cryptography "key".
   * @return A {@link Cipher} instance.
   * @throws java.security.NoSuchAlgorithmException
   * @throws java.security.spec.InvalidKeySpecException
   * @throws javax.crypto.NoSuchPaddingException
   * @throws java.security.InvalidKeyException
   * @throws java.security.InvalidAlgorithmParameterException
   * @see AEncryption
   * @see Encryption
   * @see Random
   * @see PBEParameterSpec
   * @see PBEKeySpec
   * @see SecretKey
   * @see SecretKeyFactory
   * @see Cipher
   */
  protected final Cipher getCipher(long l, int i, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException {
    Random random = new Random(l);
    byte[] salt = new byte[8];
    random.nextBytes(salt);
    PBEParameterSpec pspecs = new PBEParameterSpec(salt, 5);
    SecretKey pbeKey = SecretKeyFactory.getInstance(type).generateSecret(new PBEKeySpec(s.toCharArray()));
    Cipher cipher = Cipher.getInstance(type);
    cipher.init(i, pbeKey, pspecs);
    return cipher;
  }

  /**
   * Perform a cryptographic load operation. This method uses the {@link #logic logic} object, which should have been
   * instantiated in the constructor.
   * <p/>
   * The {@link Encryption#cryptoLoad(File,ACryptoLogic,String)} implementation closes the input stream.
   * @param f A {@link File} object, representing the source file.
   * @param s A {@link String} object, representing the cipher key to use.
   * @throws java.security.NoSuchAlgorithmException
   * @throws java.security.spec.InvalidKeySpecException
   * @throws javax.crypto.NoSuchPaddingException
   * @throws java.security.InvalidKeyException
   * @throws java.security.InvalidAlgorithmParameterException
   * @throws java.io.FileNotFoundException
   * @see AEncryption
   * @see #performEncrypting(File,String) performEncrypting(File,String)
   */
  abstract protected void performDecrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException;

  /**
   * Perform a cryptographic save operation. This method uses the {@link #logic logic} object, which should have been
   * instantiated in the constructor.
   * <p/>
   * The {@link Encryption#cryptoSave(File,ACryptoLogic,String)} implementation flushes and closes the output stream.
   * @param f A {@link File} object, representing the target file.
   * @param s A {@link String} object, representing the cipher key to use.
   * @throws java.security.NoSuchAlgorithmException
   * @throws java.security.spec.InvalidKeySpecException
   * @throws javax.crypto.NoSuchPaddingException
   * @throws java.security.InvalidKeyException
   * @throws java.security.InvalidAlgorithmParameterException
   * @throws java.io.FileNotFoundException
   * @see AEncryption
   * @see #performDecrypting(File,String) performDecrypting(File,String)
   */
  abstract protected void performEncrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException;
}
