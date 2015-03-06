/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gregory.abc.constraint;


/**
 *
 * @author Gregory
 */
public class ConstrainShort {

  /**
   * A public method to get whether a value is within a particular range.
   * @param val A {@link Short} value, representing the value to be tested against.
   * @param max A {@link Short} value, representing the maximum to be equal or less than.
   * @param min A {@link Short} value, representing the minimum to be equal or more than.
   * @return A {@link Boolean} value.
   */
  public static boolean isShortInside(short val, short max, short min) {
    return (val >= min) && (val <= max);
  }

  /**
   * A public method to constrain a {@link Short} value to a maximum value.
   * <p/>
   * The simple rule is that if {@code val} is more than {@code max}, this returns {@code max}, or {@code val}
   * otherwise.
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param max A {@link Short} value, representing the maximum value to not be more than.
   * @return A {@link Short} value.
   */
  public static short constrainShortMax(short val, short max) {
    return (val > max) ? max : val;
  }

  /**
   * A public method to constrain a {@link Short} value to a minimum value.
   * <p/>
   * The simple rule is that if {@code val} is less than {@code min}, this returns {@code min}, or {@code val}
   * otherwise.
   * @param val A {@link Short} value, representing the value to be constrained.
   * @param min A {@link Short} value, representing the minimum value to not be less than.
   * @return A {@link Short} value.
   */
  public static short constrainShortMin(short val, short min) {
    return (val < min) ? min : val;
  }

  /**
   * A public method to constrain a {@link Short} value to outside a particular range of values. The following rules
   * apply:
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
   */
  public static short constrainShortOuter(short val, short max, short min, short alt) {
    return (val > max) ? max : (val < min) ? min : alt;
  }

  /**
   * A public method to constrain a {@link Short} value to a particular range of values. The following rules apply:
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
   */
  public static short constrainShortRange(short val, short max, short min) {
    return (val > max) ? max : (val < min) ? min : val;
  }

}
