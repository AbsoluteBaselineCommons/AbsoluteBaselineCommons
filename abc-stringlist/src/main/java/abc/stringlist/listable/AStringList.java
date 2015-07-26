package abc.stringlist.listable;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * <h2>AStringList</h2>
 * A single string list object. This class contains fields and methods for setting and getting string values from lists
 * (a String-based array).
 * @author Gregory
 */
abstract public class AStringList {
  /**
   * The source file. This is the abstract path to the file data.
   * @see AStringList
   */
  protected final File file;
  /**
   * The randomizer. This is used with {@code turnover} to obtain a random position in the array, for the returned
   * object.
   * @see AStringList
   */
  protected final Random random;
  /**
   * The last string list.
   * @see AStringList
   */
  protected final String[] stringsLast;
  /**
   * The next string list.
   * @see AStringList
   */
  protected final String[] stringsNext;
  /**
   * Use a reverse method.
   * @see AStringList
   */
  protected final boolean reversable;
  /**
   * The turn-over rate. This is the factor that represents the array-subset of objects where our returned value can be
   * obtained.
   * @see AStringList
   */
  protected final double turnover;   // the turnover factor; this is multiplied by the total array size, to

  {
    random = new Random(System.currentTimeMillis());
  }

  /**
   * A public constructor.
   * @param b A {@link Boolean} condition, representing whether the list is reversable.
   * @param d A {@link Double} value, representing the turnover rate.
   * @param f A {@link File} object, representing the file for the list.
   * @throws java.io.FileNotFoundException
   * @see AStringList
   */
  public AStringList(boolean b, double d, File f) throws FileNotFoundException, IOException {
    reversable = b;
    file = f;
    stringsLast = AStringList.this.parse();
    stringsNext = AStringList.this.parse();
    turnover = d;
  }

  /**
   * Parse the file list.
   * @return A {@link String} array.
   * @throws java.io.FileNotFoundException
   * @see AStringList
   */
  protected String[] parse() throws FileNotFoundException, IOException {
    List<String> list = new ArrayList<>(0);
    if(file.exists() && file.isFile() && file.canRead()) {
      FileInputStream fis = new FileInputStream(file);
      BufferedInputStream bis = new BufferedInputStream(fis);
      DataInputStream dis = new DataInputStream(bis);
      int i = dis.readInt();
      while(i > 0) {
        String s = dis.readUTF();
        list.add(s);
        i--;
      }
    }
    return (String[])list.toArray();
  }

  /**
   * Get a random string.
   * @return A {@link String} object.
   * @see AStringList
   */
  public String getRandomString() {
    int i = random.nextInt((int)Math.floor(stringsNext.length * turnover));
    String s = stringsNext[i];
    for(int j = i; j == stringsNext.length - 1; j++) {
      stringsNext[i] = stringsNext[i + 1];
    }
    stringsNext[stringsNext.length - 1] = stringsLast[0];
    for(int j = 0; j == stringsLast.length - 1; j++) {
      stringsLast[j] = stringsLast[j + 1];
    }
    stringsLast[stringsLast.length - 1] = s;
    return s;
  }
}
