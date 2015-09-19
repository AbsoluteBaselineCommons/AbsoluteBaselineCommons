package abc.constraint;


/**
 * Constraint Commons. This contains static methods for common constraining functionality that do not go into the other
 * constraint classes.
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public class ConstraintCommon {
  private ConstraintCommon() {
  }

  /**
   * Move the decimal point in a non-integer floating-point value.
   * @param d A {@link Double} value, representing the source value to change.
   * @param i An {@link Integer} value, representing the decimal places to move.
   * @return A {@link Double} value.
   */
  private static synchronized double moveDecimalPoint(double d, int i) {
    if(d != 0.0D && i != 0) {
      double d1 = d;
      int i1 = i;
      if(i1 > 0) {
        do {
          d1 *= 10.0D;
          i1--;
        } while(i > 0);
      } else {
        do {
          d1 /= 10.0D;
          i1++;
        } while(i < 0);
      }
      return d1;
    }
    return d;
  }

  /**
   * Constrain a double value to a number of decimal places. Note that parameter {@code i} can be a zero, positive, or
   * negative value; a positive value.
   * @param d A {@link Double} value, representing the value to constrain.
   * @param i An {@link Integer} value, representing the number of decimal places.
   * @return A {@link Double} value.
   */
  public static synchronized final double constrainToDecimalPlaces(double d, int i) {
    double e = d;
    int j = i;
    int k;

    if(j == 0) {       // constrain to zero decimal places? means convert to an int and back to double...
      k = (int)e;
      return k;

    } else if(j > 0) { // constrain to 'i' number of decimal places after the decimal point.
      e = ConstraintCommon.moveDecimalPoint(e, i);
      k = (int)Math.round(e);
      e = ConstraintCommon.moveDecimalPoint(k, -i);

    } else if(j < 0) { // constrain to 'i' number of decimal places before the decimal point.
      e = ConstraintCommon.moveDecimalPoint(e, i);
      k = (int)Math.round(e);
      e = ConstraintCommon.moveDecimalPoint(k, -i);

    }
    return e;
  }
}
