package abc.constraint;


/**
 * Short value constraint. This class has static methods to constrain a {@link Short} value in some specific ways.
 * @author Gregory
 * @see Short
 */
public class ConstrainShort {
  private ConstrainShort() {
  }

  /**
   * If a value is within a particular range.
   * @param val A {@link Short} value, representing the value to be tested against.
   * @param max A {@link Short} value, representing the maximum to be equal or less than.
   * @param min A {@link Short} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   * @see ConstrainShort
   * @see Short
   */
  public static final boolean isShortInside(short val, short max, short min) {
    return (val >= min) && (val <= max);
  }

  /**
   * Constrain a {@link Short} value to a maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param max A {@link Short} value, representing the maximum value to not be more than.
   * @return A {@link Short} value.
   * @see ConstrainShort
   * @see Short
   */
  public static final short constrainShortMax(short val, short max) {
    return (val > max) ? max : val;
  }

  /**
   * Constrain a {@link Short} value to a minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param min A {@link Short} value, representing the minimum value to not be less than.
   * @return A {@link Short} value.
   * @see ConstrainShort
   * @see Short
   */
  public static final short constrainShortMin(short val, short min) {
    return (val < min) ? min : val;
  }

  /**
   * Constrain a {@link Short} value to outside a particular range of values. The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns {@code max}.
   * <li/>If {@code val} is less than {@code min}, this returns {@code min}.
   * <li/>Otherwise, this returns {@code alt}, an alternate digit.
   * </ul>
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param max A {@link Short} value, representing the maximum value to not be more than.
   * @param min A {@link Short} value, representing the minimum value to not be less than.
   * @param alt A {@link Short} value, representing the digit to return if not outside the max/min ranges.
   * @return A {@link Short} value.
   * @see ConstrainShort
   * @see Short
   */
  public static final short constrainShortOuter(short val, short max, short min, short alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * Constrain a {@link Short} value to a particular range of values. The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this method returns the result of
   * {@link #constrainShortMax(short, short)}.
   * <li/>If {@code val} is less than {@code min}, this method returns the result of
   * {@link #constrainShortMin(short, short)}.
   * <li/>Otherwise, this returns {@code val}, not changed by any method.
   * </ul>
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param max A {@link Short} value, representing the maximum value to not be more than.
   * @param min A {@link Short} value, representing the minimum value to not be less than.
   * @return A {@link Short} value.
   * @see ConstrainShort
   * @see Short
   */
  public static final short constrainShortRange(short val, short max, short min) {
    return (val > max) ? max : (val < min) ? min : val;
  }
}
