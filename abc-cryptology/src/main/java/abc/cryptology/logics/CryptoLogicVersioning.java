package abc.cryptology.logics;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The cryptographic logic version-data. This allows reading and writing the versioned attributes; it contains an array
 * of byte-based values as the major, minor, release, and build of the respective library to be compared against.
 * <blockquote><b><i>WARNING:</i></b> If the data <u>must</u> respect the library version upon being read into the data
 * implementation, the logic class must also have methods to "upgrade" readable data to the modern format. This compare
 * operation need not be too obtuse; it is generally the case that only a few differences exist between one version and
 * another. For some cases, it is merely a matter of reading one or more additional values, for others it's a matter of
 * skipping the reading of some previous-version values.</blockquote>
 * @author Gregory
 * @see #versioning versioning
 * @see #CryptoLogicVersioning(byte[]) CryptoLogicVersioning(byte[])
 * @see #performDecryption(DataInputStream) performDecryption(DataInputStream)
 * @see #performEncryption(DataInputStream) performEncryption(DataInputStream)
 */
public class CryptoLogicVersioning extends Crypto {
  /**
   * The versioning values. This encompasses the major, minor, release, and build of the data. Each byte initializes as
   * zero; it is up to the implementing classes to use this. The individual bytes in the array are:
   * <ol>
   * <li/>The "Major" version. Represents a primary
   * <li/>The "Minor" version.
   * <li/>The "Release" version.
   * <li/>The "Build" version.
   * </ol>
   */
  private byte[] versioning;

  /**
   * A public constructor. This does nothing; it only exists in case I want to add anything (at this point, unnecessary
   * for overall operation).
   * <blockquote>See the javadoc in this abstract class, for general cautions and warnings.</blockquote>
   * @param bs A {@link Byte} array, representing the
   * @see Crypto
   */
  public CryptoLogicVersioning(byte[] bs) {
    super();
    versioning = bs;
  }

  @Override
  public final void performDecryption(DataInputStream dis) throws IOException {
    if(dis != null) {
      versioning = new byte[] {dis.readByte(), dis.readByte(), dis.readByte(), dis.readByte()};
    }
  }

  @Override
  public final void performEncryption(DataOutputStream dos) throws IOException {
    if(dos != null) {
      dos.writeByte(versioning[0]);
      dos.writeByte(versioning[1]);
      dos.writeByte(versioning[2]);
      dos.writeByte(versioning[3]);
    }
  }

  /**
   * Get the versioning. This encompasses the major, minor, release, and build of the data. It is up to an implementing
   * class to use this in comparison for.
   * @return An {@link Integer} array.
   */
  public final byte[] getVersioning() {
    return versioning.clone();
  }
}
