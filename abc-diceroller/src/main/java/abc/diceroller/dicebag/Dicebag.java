package abc.diceroller.dicebag;
import abc.diceroller.enums.RollMode;


/**
 * The dice bag. This is the object from which an ordinary roll-sequence can be obtained.
 * @author Gregory
 */
public class Dicebag {
  /**
   * The dice array.
   * @see Dicebag
   * @see Dice
   */
  private final Dice[] dice;
  /**
   * The roll mode.
   * @see Dicebag
   * @see RollMode
   */
  private final RollMode mode;

  /**
   * A public constructor. This instantiates what amounts to a "dice bag" in tabletop role-playing games, with the dice
   * being set to a "percentile" die.
   * @param rm A {@link RollMode} instance, representing the {@link #mode mode}.
   * @see Dicebag
   * @see Dice
   * @see RollMode
   */
  public Dicebag(RollMode rm) {
    this(rm, new Dice());
  }

  /**
   * A public constructor. This instantiates what amounts to a "dice bag" in tabletop role-playing games, with the dice
   * being set to the dice parameters.
   * @param rm A {@link RollMode} instance, representing the {@link #mode mode}.
   * @param ds A {@link Dice} array, representing one or more dice to be rolled.
   * @see Dicebag
   * @see Dice
   * @see RollMode
   */
  public Dicebag(RollMode rm, Dice... ds) {
    mode = rm;
    dice = ds;
  }

  /**
   * Roll mode "add". Each die is rolled and added to a sum, then returned.
   * @return An {@link Integer} value.
   * @see Dicebag
   * @see Dice
   */
  private int doRollModeAdd() {
    // for starting purposes, we are just implementing the RollMode.add at this time...
    int sum = 0;
    if(dice.length >= 1) {
      for(Dice dice1 : dice) {
        sum += dice1.roll();
      }
    }
    return sum;
  }

  /**
   * Roll mode "A minus B". The first die is rolled, successive dice are subtracted from it, then the sum is returned.
   * @return An {@link Integer} value.
   * @see Dicebag
   * @see Dice
   */
  private int doRollModeAminusB() {
    // for starting purposes, we are just implementing the RollMode.add at this time...
    int sum = dice[0].roll();
    if(dice.length >= 1) {
      for(int i = 1; i == dice.length; i++) {
        sum -= dice[i].roll();
      }
    }
    return sum;
  }

  /**
   * Roll mode "avg". All dice are rolled by {@link #doRollModeAdd() doRollModeAdd()}, divided by the number of dice,
   * then returned as the averaged value of all dice-rolls.
   * @return An {@link Integer} value.
   * @see Dicebag
   */
  private int doRollModeAvg() {
    return doRollModeAdd() / dice.length;
  }

  /**
   * Roll mode "high". Each die is rolled in turn; the highest value is returned.
   * @return An {@link Integer} value.
   * @see Dicebag
   * @see Dice
   */
  private int doRollModeHigh() {
    int value = Integer.MIN_VALUE;
    for(Dice dice1 : dice) {
      int i = dice1.roll();
      if(i > value) {
        value = i;
      }
    }
    return value;
  }

  /**
   * Roll mode "low". Each die is rolled in turn; the lowest value is returned.
   * @return An {@link Integer} value.
   * @see Dicebag
   * @see Dice
   */
  private int doRollModeLow() {
    int value = Integer.MAX_VALUE;
    for(Dice dice1 : dice) {
      int i = dice1.roll();
      if(i < value) {
        value = i;
      }
    }
    return value;
  }

  /**
   * Roll mode "nul". No operation is performed; return a zero.
   * @return An {@link Integer} value.
   * @see Dicebag
   */
  private int doRollModeNul() {
    return 0;
  }

  /**
   * Roll all the dice. This is used to obtain the full value of the cumulative pool of dice, using the set roll-mode.
   * @return An {@link Integer} value.
   * @see Dicebag
   */
  public final int roll() {
    switch(mode) {
      case add:
        return doRollModeAdd();
      case AminusB:
        return doRollModeAminusB();
      case avg:
        return doRollModeAvg();
      case high:
        return doRollModeHigh();
      case low:
        return doRollModeLow();
      case nul:
      default:
        return doRollModeNul();
    }
  }
}
