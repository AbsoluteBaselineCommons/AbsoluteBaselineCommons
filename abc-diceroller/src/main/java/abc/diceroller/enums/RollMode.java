package abc.diceroller.enums;


/**
 * The dice-roll methodology. This is the enumerated types for multi-dice operations, defining how more than one values
 * will be summed or selected.
 * @author Gregory
 * @see #add add
 * @see #avg avg
 * @see #high high
 * @see #low low
 * @see #AminusB AminusB
 * @see #AplusB AplusB
 * @see #nul nul
 */
public enum RollMode {
  /**
   * Use the dice sum. All values are added together and returned as-is.
   * @see RollMode
   */
  add,
  /**
   * Use the dice average. All values are added together, as with {@link #add add}, but divided by the total number of
   * dice, in order to obtain an average value.
   * @see RollMode
   */
  avg,
  /**
   * Use the high value. The highest value is returned.
   * @see RollMode
   */
  high,
  /**
   * Use the low value. The lowest value is returned.
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
   * No operation is performed.
   * @see RollMode
   */
  nul;
  //TODO: Add additional roll-modes as necessary; for the most part, what is here should work for most cases.
}
