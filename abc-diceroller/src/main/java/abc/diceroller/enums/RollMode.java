package abc.diceroller.enums;


/**
 *
 * @author Gregory
 */
public enum RollMode {
  /**
   * Use the dice sum.
   * @see RollMode
   */
  add,
  /**
   * Use the dice average.
   * @see RollMode
   */
  avg,
  /**
   * Use the high value.
   * @see RollMode
   */
  high,
  /**
   * Use the low value.
   * @see RollMode
   */
  low,
  /**
   * Use the value of "A-B". This is useful for automatically subtracting a pool of dice from a "core" die value.
   * <p/>
   * In this case, "A" is the first die, and "B" are the remaining dice.
   * @see RollMode
   */
  AminusB,
  /**
   * Use the value of "A+B". This is useful for automatically adding a pool of dice from a "core" die value.
   * <p/>
   * In this case, "A" is the first die, and "B" are the remaining dice.
   * @see RollMode
   */
  AplusB,
  /**
   * Use the low value.
   * @see RollMode
   */
  nul;
}
