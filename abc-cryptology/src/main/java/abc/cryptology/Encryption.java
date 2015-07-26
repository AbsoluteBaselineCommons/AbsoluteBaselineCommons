package abc.cryptology;
import abc.cryptology.logics.ACryptoLogic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;


/**
 * An encryption instance. This subclass defines the implementation of an encryption methodology.
 * @author Gregory
 * @see AEncryption
 */
class Encryption extends AEncryption {
  /**
   * A protected constructor. This takes a String parameter to initialize the secret key and cipher. It would likely be
   * a value such as "{@code PBEWithMD5AndDES}".
   * @param l A {@link Long} value, representing the random {@link #seed seed}.
   * @param c An {@link ACryptoLogic} object, representing the {@link #logic logic}.
   * @param s A {@link String} object, representing the {@link #type type}.
   * @see Encryption
   * @see ACryptoLogic
   * @see AEncryption
   * @see AEncryption#AEncryption(long,ACryptoLogic,String)
   */
  protected Encryption(long l, ACryptoLogic c, String s) {
    super(l, c, s);
  }

  @Override
  protected void performDecrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException {
    if(f != null && f.exists() && logic != null && s != null && !s.isEmpty()) {
      Cipher cipher = getCipher(seed, Cipher.DECRYPT_MODE, s);
      FileInputStream fis = new FileInputStream(f);
      CipherInputStream cis = new CipherInputStream(fis, cipher);
      try(DataInputStream dis = new DataInputStream(cis)) {
        logic.performDecryption(dis);
      }
    }
  }

  @Override
  protected void performEncrypting(File f, String s) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException,
      IOException {
    if(f != null && f.exists() && logic != null && s != null && !s.isEmpty()) {
      Cipher cipher = getCipher(seed, Cipher.ENCRYPT_MODE, s);
      FileOutputStream fos = new FileOutputStream(f);
      CipherOutputStream cos = new CipherOutputStream(fos, cipher);
      try(DataOutputStream dos = new DataOutputStream(cos)) {
        logic.performEncryption(dos);
        dos.flush();
      }
    }
  }
}
