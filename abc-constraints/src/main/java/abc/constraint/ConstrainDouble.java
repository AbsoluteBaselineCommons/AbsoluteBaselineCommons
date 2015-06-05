package abc.constraint;


/**
 * Constrain a double value.
 * @author Gregory
 */
public class ConstrainDouble {
  private ConstrainDouble() {
  }

  /**
   * Get whether a value is within a particular range.
   * @param val A {@link Double} value, representing the value to be tested against.
   * @param max A {@link Double} value, representing the maximum to be equal or less than.
   * @param min A {@link Double} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   */
  public static final boolean isDoubleInside(double val, double max, double min) {
    return (val >= min) && (val <= max);
  }

  /**
   * Constrain a {@link Double} value to maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val A {@link Double} value, representing the value to be constrained.
   * @param max A {@link Double} value, representing the maximum value to not be more than.
   * @return A {@link Double} value.
   */
  public static final double constrainDoubleMax(double val, double max) {
    return (val > max) ? max : val;
  }

  /**
   * Constrain a {@link Double} value to minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val A {@link Double} value, representing the value to be constrained.
   * @param min A {@link Double} value, representing the minimum value to not be less than.
   * @return A {@link Double} value.
   */
  public static final double constrainDoubleMin(double val, double min) {
    return (val < min) ? min : val;
  }

  /**
   * Constrain a {@link Double} value to outside a particular range of values.
   * <p/>
   * The following rules apply:<ul>
   * <li/>If {@code val} is more than {@code max}, this returns {@code max}.
   * <li/>If {@code val} is less than {@code min}, this returns {@code min}.
   * <li/>Otherwise, this returns {@code alt}, an alternate digit.
   * </ul>
   * @param val A {@link Double} value, representing the value to be constrained.
   * @param max A {@link Double} value, representing the maximum value to not be more than.
   * @param min A {@link Double} value, representing the minimum value to not be less than.
   * @param alt A {@link Double} value, representing a digit to return if not outside the max/min ranges.
   * @return A {@link Double} value.
   */
  public static final double constrainDoubleOuter(double val, double max, double min, double alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * Constrain a {@link Double} value to a particular range of values.
   * <p/>
   * The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns the result of
   * {@link #constrainDoubleMax(double, double)}.
   * <li/>If {@code val} is less than {@code min}, this returns the result of
   * {@link #constrainDoubleMin(double, double)}.
   * <li/>Otherwise, this returns {@code val}, not changed by any method.
   * </ul>
   * @param val A {@link Double} value, representing the value to be constrained.
   * @param max A {@link Double} value, representing the maximum value to not be more than.
   * @param min A {@link Double} value, representing the minimum value to not be less than.
   * @return A {@link Double} value.
   */
  public static final double constrainDoubleRange(double val, double max, double min) {
    return (val > max) ? max : (val < min) ? min : val;
  }
}
