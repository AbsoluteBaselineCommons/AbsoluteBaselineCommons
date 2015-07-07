package abc.cryptology.logics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The cryptographic logic of String arrays. This allows reading and writing lists of {@link String} object data in an
 * automatic manner.
 * @author Gregory
 */
public class CryptoLogicArrayStrings extends ACryptoLogic {
  private String[] strings;

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
   * @return A {@link String} array;
   */
  public final String[] getStrings() {
    return (strings == null) ? new String[] {""} : strings.clone();
  }
}
