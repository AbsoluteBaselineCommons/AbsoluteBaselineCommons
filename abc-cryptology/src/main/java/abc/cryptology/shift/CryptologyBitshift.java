package abc.cryptology.shift;


/**
 * The cryptology "bit-shift" implementation. This is a little less "crypto-secure" than my implementation that is from
 * {@link AbcCryptology} class, although it is still useful for lesser-demanding methodologies, or even in cooperation
 * with aspects of {@code AbcCryptology} itself.
 * <p/>
 * For example, it is possible to make a global "index" that uses this class, while other data-encrypted files will use
 * the other implementation. Having more than one methodology may strengthen the security of a program's data, perhaps.
 * @author Gregory
 * @see #decrypt(String)
 * @see #encrypt(String)
 */
public class CryptologyBitshift {
  /**
   * A key-chain array.
   * @see CryptologyBitshift
   */
  private static final int[] keychain;
  /**
   * The character's integer value.
   * @see CryptologyBitshift
   */
  private static char ch;
  /**
   * The character in the key-chain.
   * @see CryptologyBitshift
   */
  private static int ck;
  /**
   * The length of the string.
   * @see CryptologyBitshift
   */
  private static int length;

  static {
    //TODO: Our "keychain" is fine for now, but replace with some static method to read binary integers from a file?
    keychain = new int[] {
      1941, 12394, 23093, 9023, 2111, 193, 93, 293
    };
    clear();
  }

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see CryptologyBitshift
   */
  private CryptologyBitshift() {
  }

  /**
   * Clear the values. This ensures encoding and decoding values cannot be "copied" from memory....
   * @see CryptologyBitshift
   */
  private static void clear() {
    length = Integer.MIN_VALUE;
    ch = Character.MIN_VALUE;
    ck = Integer.MIN_VALUE;
  }

  /**
   * Decrypt data by bit-shifting.
   * @param s A {@link String} object, representing the data to decrypt.
   * @return A {@link String} object.
   * @see CryptologyBitshift
   */
  public static final String decrypt(String s) {
    clear();
    String result = "";
    length = s.length();
    ck = 0;
    for(int i = 0; i < length; i++) {
      if(ck >= keychain.length) {
        ck = 0;
      }
      ch = s.charAt(i);
      ch -= keychain[ck];
      result += ch;
      ck++;
    }
    clear();
    return result;
  }

  /**
   * Encrypt data by bit-shifting.
   * @param s A {@link String} object, representing the data to decrypt.
   * @return A {@link String} object.
   * @see CryptologyBitshift
   */
  public static final String encrypt(String s) {
    clear();
    String result = "";
    length = s.length();
    ck = 0;
    for(int i = 0; i < length; i++) {
      if(ck >= keychain.length) {
        ck = 0;
      }
      ch = s.charAt(i);
      ch += keychain[ck];
      result += ch;
      ck++;
    }
    clear();
    return result;
  }
}
