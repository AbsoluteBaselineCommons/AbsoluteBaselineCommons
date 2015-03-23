package abc.stringlist;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <h2>StringList</h2>
 * A single string list object. This class contains fields and methods for setting and getting string values from lists
 * (a String-based array).
 * @author Gregory
 */
public class StringList {
  /**
   * The source file. This is the abstract path to the file data.
   */
  private final File file;
  /**
   * The randomizer. This is used with {@code turnover} to obtain a random position in the array, for the returned
   * object.
   */
  private final Random random;
  /**
   * The string list.
   */
  private final String[] stringsLast;
  private final String[] stringsNext;
  /**
   * Use a reverse method.
   */
  private final boolean reversable;
  /**
   * The turn-over rate. This is the factor that represents the array-subset of objects where our returned value can be
   * obtained.
   */
  private final double turnover;   // the turnover factor; this is multiplied by the total array size, to

  {
    random = new Random(System.currentTimeMillis());
  }

  public StringList(boolean b, double d, File f) {
    reversable = b;
    file = f;
    stringsLast = parse();
    stringsNext = parse();
    turnover = d;
  }

  private String[] parse() {
    List<String> list;
    String[] stringlist = null;
    if(file.exists() && file.isFile() && file.canRead()) {
      list = new ArrayList<>((int)file.length() / 8);
      try(FileInputStream fis = new FileInputStream(file)) {
        BufferedInputStream bis = new BufferedInputStream(fis);
      } catch(FileNotFoundException ex) {
        Logger.getLogger(StringList.class.getName()).log(Level.SEVERE, null, ex);
      } catch(IOException ex) {
        Logger.getLogger(StringList.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return stringlist;
  }

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
