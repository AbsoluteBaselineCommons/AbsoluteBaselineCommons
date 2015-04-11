package abc.cryptology;
import abc.cryptology.logics.ACryptoLogic;
import abc.errorlogs.log.AbcLogger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;


/**
 * <h2>Encryption</h2>
 * An encryption instance.
 * @author Gregory
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
  protected void performDecrypting(File f, String s) {
    if(f != null && f.exists() && logic != null && s != null && !s.isEmpty()) {
      Cipher cipher = getCipher(seed, Cipher.DECRYPT_MODE, s);
      try(FileInputStream fis = new FileInputStream(f);
          CipherInputStream cis = new CipherInputStream(fis, cipher);
          DataInputStream dis = new DataInputStream(cis)) {
        logic.performDecryption(dis);
        dis.close();
      } catch(IOException ex) {
        AbcLogger.logThis(AbcLogger.L1, "Encryption.performDecrypting(File,String) encountered an IOException", ex);
      }
    }
  }

  @Override
  protected void performEncrypting(File f, String s) {
    if(f != null && f.exists() && logic != null && s != null && !s.isEmpty()) {
      Cipher cipher = getCipher(seed, Cipher.ENCRYPT_MODE, s);
      try(FileOutputStream fos = new FileOutputStream(f);
          CipherOutputStream cos = new CipherOutputStream(fos, cipher);
          DataOutputStream dos = new DataOutputStream(cos)) {
        logic.performEncryption(dos);
        dos.flush();
        dos.close();
      } catch(IOException ex) {
        AbcLogger.logThis(AbcLogger.L1, "Encryption.performEncrypting(File,String) encountered an IOException", ex);
      }
    }
  }
}
