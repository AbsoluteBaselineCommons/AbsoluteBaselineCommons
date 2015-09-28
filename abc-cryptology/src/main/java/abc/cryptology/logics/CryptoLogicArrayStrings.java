package abc.cryptology.logics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The cryptographic logic of String arrays. This allows reading and writing lists of {@link String} object data in an
 * automatic manner.
 * @author Gregory
 * @see #CryptoLogicVersioning(byte[]) CryptoLogicVersioning(byte[])
 * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
 * @see #performEncryption(DataInputStream) performEncryption(DataInputStream)
 */
public class CryptoLogicArrayStrings extends Crypto {
  /**
   * A string array.
   * @see CryptoLogicArrayStrings
   */
  private String[] strings;

  /**
   * A public constructor. Only sets the string array.
   * @param ss A {@link String} array, representing the {@link #strings strings} to set.
   * @see CryptoLogicArrayStrings
   */
  public CryptoLogicArrayStrings(String[] ss) {
    strings = ss;
  }

  @Override
  public final void performDecryption(DataInputStream dis) throws IOException {
    if(dis != null) {
      strings = new String[dis.read()];
      for(int i = 0; i < strings.length; i++) {
        strings[i] = dis.readUTF();
      }
    }
  }

  @Override
  public final void performEncryption(DataOutputStream dos) throws IOException {
    if(dos != null) {
      dos.write(strings.length);
      for(String string : strings) {
        dos.writeUTF(string.trim());
      }
    }
  }

  /**
   * Get the array of strings. If {@link #strings strings} is empty, returns a new single-item null String array.
   * @return A {@link String} array.
   * @see CryptoLogicArrayStrings
   */
  public final String[] getStrings() {
    return (strings == null) ? new String[] {""} : strings.clone();
  }
}
