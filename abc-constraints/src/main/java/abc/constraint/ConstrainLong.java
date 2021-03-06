package abc.constraint;


/**
 * Long value constraint. This class has static methods to constrain a {@link Long} value in some specific ways.
 * @author Gregory
 * @see Long
 */
public class ConstrainLong {
  private ConstrainLong() {
  }

  /**
   * If a value is within a particular range.
   * @param val A {@link Long} value, representing the value to be tested against.
   * @param max A {@link Long} value, representing the maximum to be equal or less than.
   * @param min A {@link Long} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   * @see ConstrainLong
   * @see Long
   */
  public static final boolean isLongInside(long val, long max, long min) {
    return (val >= min) && (val <= max);
  }

  /**
   * Constrain a {@link Long} value to a maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val A {@link Long} value, representing the value to be constrained.
   * @param max A {@link Long} value, representing the maximum value to not be more than.
   * @return A {@link Long} value.
   * @see ConstrainLong
   * @see Long
   */
  public static final long constrainLongMax(long val, long max) {
    return (val > max) ? max : val;
  }

  /**
   * Constrain a {@link Long} value to a minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val A {@link Long} value, representing the value to be constrained.
   * @param min A {@link Long} value, representing the minimum value to not be less than.
   * @return A {@link Long} value.
   * @see ConstrainLong
   * @see Long
   */
  public static final long constrainLongMin(long val, long min) {
    return (val < min) ? min : val;
  }

  /**
   * Constrain a {@link Long} value to outside a particular range of values.
   * <p/>
   * The following rules apply:<ul>
   * <li/>If {@code val} is more than {@code max}, this returns {@code max}.
   * <li/>If {@code val} is less than {@code min}, this returns {@code min}.
   * <li/>Otherwise, this returns {@code alt}, an alternate digit.
   * </ul>
   * @param val A {@link Long} value, representing the value to be constrained.
   * @param max A {@link Long} value, representing the maximum value to not be more than.
   * @param min A {@link Long} value, representing the minimum value to not be less than.
   * @param alt A {@link Long} value, representing the digit to return if not outside the max/min ranges.
   * @return A {@link Long} value.
   * @see ConstrainLong
   * @see Long
   */
  public static final long constrainLongOuter(long val, long max, long min, long alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * Constrain a {@link Long} value to a particular range of values. The following rules apply:
   * <ul>
   * <li/>If {@code val} is more than {@code max}, this returns the result of {@link #constrainLongMax(long, long)}.
   * <li/>If {@code val} is less than {@code min}, this returns the result of {@link #constrainLongMin(long, long)}.
   * <li/>Otherwise, this returns {@code val}, not changed by any method.
   * </ul>
   * @param val A {@link Long} value, representing the value to be constrained.
   * @param max A {@link Long} value, representing the maximum value to not be more than.
   * @param min A {@link Long} value, representing the minimum value to not be less than.
   * @return A {@link Long} value.
   * @see ConstrainLong
   * @see Long
   */
  public static final long constrainLongRange(long val, long max, long min) {
    return (val > max) ? max : (val < min) ? min : val;
  }
}
