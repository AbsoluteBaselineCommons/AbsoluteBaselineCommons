package abc.constraint;


/**
 * Constrain an integer value.
 * @author Gregory
 */
public class ConstrainInteger {
  private ConstrainInteger() {
  }

  /**
   * Get whether a value is within a particular range.
   * @param val An {@link Integer} value, representing the value to be tested against.
   * @param max An {@link Integer} value, representing the maximum to be equal or less than.
   * @param min An {@link Integer} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   */
  public static final boolean isIntegerInside(int val, int max, int min) {
    return (val >= min) && (val <= max);
  }

  /**
   * Constrain an {@link Integer} value to maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val An {@link Integer} value, representing the value to be constrained.
   * @param max An {@link Integer} value, representing the maximum value to not be more than.
   * @return An {@link Integer} value.
   */
  public static final int constrainIntegerMax(int val, int max) {
    return (val > max) ? max : val;
  }

  /**
   * Constrain an {@link Integer} value to minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val An {@link Integer} value, representing the value to be constrained.
   * @param min An {@link Integer} value, representing the minimum value to not be less than.
   * @return An {@link Integer} value.
   */
  public static final int constrainIntegerMin(int val, int min) {
    return (val < min) ? min : val;
  }

  /**
   * Constrain a {@link Integer} value to outside a particular range of values.
   * <p/>
   * The following rules apply:<ul>
   * <li/>If {@code val} is more than {@code max}, this returns {@code max}.
   * <li/>If {@code val} is less than {@code min}, this returns {@code min}.
   * <li/>Otherwise, this returns {@code alt}, an alternate digit.
   * </ul>
   * @param val An {@link Integer} value, representing the value to be constrained.
   * @param max An {@link Integer} value, representing the maximum value to not be more than.
   * @param min An {@link Integer} value, representing the minimum value to not be less than.
   * @param alt An {@link Integer} value, representing the digit to return if not outside the max/min ranges.
   * @return An {@link Integer} value.
   */
  public static final int constrainIntegerOuter(int val, int max, int min, int alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * Constrain an {@link Integer} value to a particular range of values.
   * <p/>
   * The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns the result of {@link #constrainIntegerMax(int, int)}.
   * <li/>If {@code val} is less than {@code min}, this returns the result of {@link #constrainIntegerMin(int, int)}.
   * <li/>Otherwise, this returns {@code val}, not changed by any method.
   * </ul>
   * @param val An {@link Integer} value, representing the value to be constrained.
   * @param max An {@link Integer} value, representing the maximum value to not be more than.
   * @param min An {@link Integer} value, representing the minimum value to not be less than.
   * @return An {@link Integer} value.
   */
  public static final int constrainIntegerRange(int val, int max, int min) {
    return (val > max) ? max : (val < min) ? min : val;
  }
}
