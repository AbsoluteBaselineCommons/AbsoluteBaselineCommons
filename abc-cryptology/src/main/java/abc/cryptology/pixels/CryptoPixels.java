package abc.cryptology.pixels;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Encode and decode on a per-pixel basis. This "graphics helper" class allows interpreting to or from pixel-based data
 * via "pseudo-cryptology" techniques.
 * <p/>
 * While this is not true cryptology or cryptography so much as steganography, this class is included within this basic
 * module; its purpose is nothing more than parsing data in one direction to another. For example, an "editor" program
 * could transmit project data to this class, and output some kind of pixel-based graphic. Or, in the reverse, the same
 * editor could ask this class to "read" a series of pixels, and translate them to one or more {@link Color} values, a
 * way of controlling the output of data as pixels.
 * <p/>
 * This contains a few {@code public static final} methods that assist in taking a single graphic pixel's color values
 * and changing them into various raw data types.
 * @author Gregory
 */
public class CryptoPixels {
  /**
   * A private constructor.
   * @see CryptoPixels
   */
  private CryptoPixels() {
  }

  /**
   * Get a list of characters. A color value array &mdash; such as from a pixel's RGBA values &mdash; will be decoded,
   * one by one, with the results added to an array-list of characters.
   * @param colors A {@link Color} array, which wraps red, green, blue, and alpha values.
   * @return A {@link List} collection.
   * @see CryptoPixels
   */
  public static final List<Character> asListCharacters(Color[] colors) {
    List<Character> characters = new ArrayList<>(0);
    for(Color color : colors) {
      characters.add((char)color.getAlpha());
      characters.add((char)color.getBlue());
      characters.add((char)color.getGreen());
      characters.add((char)color.getRed());
    }
    return Collections.unmodifiableList(characters);
  }

  /**
   * Get a list of strings.
   * @param colors A {@link Color} array, which wraps red, green, blue, and alpha values.
   * @return A {@link List} collection.
   * @see CryptoPixels
   */
  public static final List<String> asListStrings(Color[] colors) {
    List<String> strings = new ArrayList<>(0);
    for(Color color : colors) {
      strings.add(Character.toString((char)color.getAlpha()));
      strings.add(Character.toString((char)color.getBlue()));
      strings.add(Character.toString((char)color.getGreen()));
      strings.add(Character.toString((char)color.getRed()));
    }
    return Collections.unmodifiableList(strings);
  }

  /**
   * Get a single pixel's colors as text.
   * @param color A {@link Color} object, which wraps red, green, blue, and alpha values.
   * @return A {@link String} object.
   * @see CryptoPixels
   */
  public static final String asString(Color color) {
    String string = "";
    char[] chars = asCharacters(color);
    for(char c : chars) {
      string += Character.toString(c);
    }
    return string;
  }

  /**
   * Get multiple pixels' colors as text.
   * @param colors A {@link Color} array, which wraps red, green, blue, and alpha values.
   * @return A {@link String} object.
   * @see CryptoPixels
   */
  public static final String asString(Color[] colors) {
    StringBuilder string = new StringBuilder(colors.length * 4);
    for(Color color : colors) {
      string.append(asString(color));
    }
    return string.toString();
  }

  /**
   * Get characters from color. This converts a color's integers into an array of {@code char} objects. These returned
   * characters can then be put together to make a four-letter {@link String} text.
   * @param color A {@link Color} object, which wraps red, green, blue, and alpha values.
   * @return A {@link Character} array.
   * @see CryptoPixels
   */
  public static final char[] asCharacters(Color color) {
    final int[] integers = asIntegers(color);
    char[] characters = new char[4];
    characters[0] = (char)integers[0];
    characters[1] = (char)integers[1];
    characters[2] = (char)integers[2];
    characters[3] = (char)integers[3];
    return characters;
  }

  /**
   * Get integers from color. It takes an {@link Color} object, and returns an array of four integer values, including
   * red, green, blue, and alpha values. Classes can use these values to parse out special class values.
   * @param color A {@link Color} object, representing the object to parse.
   * @return An {@link Integer} array.
   * @see CryptoPixels
   * @see Color#getAlpha()
   * @see Color#getBlue()
   * @see Color#getGreen()
   * @see Color#getRed()
   */
  public static final int[] asIntegers(Color color) {
    return new int[] {color.getAlpha(), color.getBlue(), color.getGreen(), color.getRed()};
  }
}
