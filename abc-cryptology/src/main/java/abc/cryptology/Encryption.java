package abc.cryptology;
import abc.cryptology.logics.Crypto;
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
 * An encryption definition. This abstract object breaks up the {@code EncryptionBase} object, moving some prototyped
 * methodologies into this one, allowing EncryptionBase to be a subclass of this one.
 * @author Gregory
 * @see #logic logic
 * @see #seed seed
 * @see #Encryption(long,Crypto,String)Encryption(long,Crypto,String)
 * @see #getCipher(long,int,String) getCipher(long,int,String)
 * @see #performDecrypting(File,String) performDecrypting(File,String)
 * @see #performEncrypting(File,String) performEncrypting(File,String)
 * @see EncryptionBase
 * @see AbcCryptology
 * @see NoSuchAlgorithmException
 * @see InvalidKeySpecException
 * @see NoSuchPaddingException
 * @see InvalidKeyException
 * @see InvalidAlgorithmParameterException
 * @see FileNotFoundException
 * @see IOException
 */
abstract class Encryption {
  /**
   * The cryptographic type. This should be something like {@code PBEWithMD5AndDES}, though other types might be used.
   * @see String
   * @see Encryption
   * @see #Encryption(long,Crypto,String)Encryption(long,Crypto,String)
   * @see #getCipher(long,int,String) getCipher(long,int,String)
   */
  private final String type;
  /**
   * The cryptographic logic. This allows for providing your own implementation that will be used in an instance of the
   * cryptographic methods; see that class javadoc for more information.
   * <p/>
   * This should be the outer-most logic class for this respective cryptographic instance. A logic class can, and often
   * does, contain objects that are classes that themselves extend {@link Crypto} to control logic flow. Thus our
   * outermost logic class passed into the constructor should further pass on the data input and output streams to their
   * decryption and encryption methods.
   * @see Crypto
   * @see Encryption
   * @see #Encryption(long,Crypto,String) Encryption(long,Crypto,String)
   */
  protected final Crypto logic;
  /**
   * The cryptographic seed.
   * <p/>
   * This should be the same seed from where it is set in the {@link AbcCryptology} instance to initiate a decryption or
   * encryption methodology.
   * @see Long
   * @see Encryption
   * @see #Encryption(long,Crypto,String) Encryption(long,Crypto,String)
   */
  protected final long seed;

  /**
   * A protected constructor. This takes a series of parameters to initialize the encryption object. See the parameters
   * and their javadoc links to their target fields for further information.
   * <p/>
   * The {@code s} parameter sets the encryption {@link #type type} which represents a core methodology; it may likely
   * be a value such as "{@code PBEWithMD5AndDES}". Research other cryptology types for other methodologies.
   * @param l A {@link Long} value, representing the random {@link #seed seed}.
   * @param c A {@link Crypto} object, representing the {@link #logic logic}.
   * @param s A {@link String} object, representing the {@link #type type}.
   * @see Crypto
   * @see Encryption
   * @see #seed seed
   * @see #logic logic
   * @see #type type
   */
  protected Encryption(long l, Crypto c, String s) {
    seed = l;
    logic = c;
    type = s;
  }

  /**
   * Get a cipher. This uses a cipher mode, encryption key, and parameter specs to initialize a cypher object. Mode may
   * likely be either {@link Cipher#DECRYPT_MODE} or {@link Cipher#ENCRYPT_MODE}....
   * <p/>
   * Also, this implementation catches but does not throw the following exceptions: {@link NoSuchAlgorithmException},
   * {@link InvalidKeySpecException}, {@link NoSuchPaddingException}, {@link InvalidKeyException}, and finally,
   * {@link InvalidAlgorithmParameterException}. (I may revisit it at a later time, as my knowledge of crypto grows.)
   * @param l A {@link Long} value, representing a seed value for our {@link Random} instance.
   * @param i An {@link Integer} value, representing the cryptography "direction".
   * @param s A {@link String} object, representing the cryptography "key".
   * @return A {@link Cipher} instance.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
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
   * Perform a cryptographic reading. This uses the {@link #logic logic} object which should have been instantiated in
   * the constructor. The {@link EncryptionBase#performDecrypting(File,String)} method closes the stream.
   * @param f A {@link File} object, representing the source file.
   * @param s A {@link String} object, representing the cipher key to use.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
   * @throws FileNotFoundException
   * @see Encryption
   * @see EncryptionBase
   * @see #performEncrypting(File,String) performEncrypting(File,String)
   */
  abstract protected void performDecrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException;

  /**
   * Perform a cryptographic writing. This uses the {@link #logic logic} object which should have been instantiated in
   * the constructor. The {@link EncryptionBase#performEncrypting(File,String)} method flushes and closes the stream.
   * @param f A {@link File} object, representing the target file.
   * @param s A {@link String} object, representing the cipher key to use.
   * @throws NoSuchAlgorithmException
   * @throws InvalidKeySpecException
   * @throws NoSuchPaddingException
   * @throws InvalidKeyException
   * @throws InvalidAlgorithmParameterException
   * @throws FileNotFoundException
   * @see Encryption
   * @see EncryptionBase
   * @see #performDecrypting(File,String) performDecrypting(File,String)
   */
  abstract protected void performEncrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException;
}
