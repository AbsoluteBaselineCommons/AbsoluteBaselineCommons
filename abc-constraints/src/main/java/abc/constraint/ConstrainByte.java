package abc.constraint;


/**
 * Byte value constraint. This class has static methods to constrain a {@link Byte} value in some specific ways.
 * @author Gregory
 * @see Byte
 */
public class ConstrainByte {
  private ConstrainByte() {
  }

  /**
   * If a value is within a particular range.
   * @param val A {@link Byte} value, representing the value to be tested against.
   * @param max A {@link Byte} value, representing the maximum to be equal or less than.
   * @param min A {@link Byte} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   * @see ConstrainByte
   * @see Byte
   */
  public static final boolean isByteInside(byte val, byte max, byte min) {
    return (val >= min) && (val <= max);
  }

  /**
   * Constrain a {@link Byte} value to maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val A {@link Byte} value, representing the value to be constrained.
   * @param max A {@link Byte} value, representing the maximum value to not be more than.
   * @return A {@link Byte} value.
   * @see ConstrainByte
   * @see Byte
   */
  public static final byte constrainByteMax(byte val, byte max) {
    return (val > max) ? max : val;
  }

  /**
   * Constrain a {@link Byte} value to minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val A {@link Byte} value, representing the value to be constrained.
   * @param min A {@link Byte} value, representing the minimum value to not be less than.
   * @return A {@link Byte} value.
   * @see ConstrainByte
   * @see Byte
   */
  public static final byte constrainByteMin(byte val, byte min) {
    return (val < min) ? min : val;
  }

  /**
   * Constrain a {@link Byte} value to outside a particular range of values.
   * <p/>
   * The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns {@code max}.
   * <li/>If {@code val} is less than {@code min}, this returns {@code min}.
   * <li/>Otherwise, this returns {@code alt}, an alternate digit.
   * </ul>
   * @param val A {@link Byte} value, representing the value to be constrained.
   * @param max A {@link Byte} value, representing the maximum value to not be more than.
   * @param min A {@link Byte} value, representing the minimum value to not be less than.
   * @param alt A {@link Byte} value, representing the digit to return if not outside the max/min ranges.
   * @return A {@link Byte} value.
   * @see ConstrainByte
   * @see Byte
   */
  public static final byte constrainByteOuter(byte val, byte max, byte min, byte alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * Constrain a {@link Byte} value to a particular range of values.
   * <p/>
   * The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns the result of {@link #constrainByteMax(byte, byte)}.
   * <li/>If {@code val} is less than {@code min}, this returns the result of {@link #constrainByteMin(byte, byte)}.
   * <li/>Otherwise, this returns {@code val}, not changed by any method.
   * </ul>
   * @param val A {@link Byte} value, representing the value to be constrained.
   * @param max A {@link Byte} value, representing the maximum value to not be more than.
   * @param min A {@link Byte} value, representing the minimum value to not be less than.
   * @return A {@link Byte} value.
   * @see ConstrainByte
   * @see Byte
   */
  public static final byte constrainByteRange(byte val, byte max, byte min) {
    return (val > max) ? max : (val < min) ? min : val;
  }
}
