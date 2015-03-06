package abc.diceroller.dicebag;
import abc.diceroller.enums.RollMode;

/**
 * <h2>Dicebag</h2>
 * The dice bag. This is the object from which an ordinary roll-sequence can be obtained.
 * @author Gregory
 */
public class Dicebag {
  private final Dice[] dice;
  private final RollMode mode;

  /**
   * A public constructor. This instantiates what amounts to a "dice bag" in tabletop role-playing games, with the dice
   * being set to a "percentile" die.
   */
  public Dicebag(RollMode rm) {
    this(RollMode.add, new Dice());
  }

  /**
   * A public constructor. This instantiates what amounts to a "dice bag" in tabletop role-playing games, with the dice
   * being set to the dice parameters.
   */
  public Dicebag(RollMode rm, Dice... ds) {
    mode = rm;
    dice = ds;
  }

  /**
   */
  private final int doRollModeAdd() {
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
   */
  private final int doRollModeAminusB() {
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
   */
  private final int doRollModeAvg() {
    return doRollModeAdd() / dice.length;
  }

  /**
   * @deprecated Not really; just not fully implemented yet.
   */
  @Deprecated
  private final int doRollModeHigh() {
    //TODO: The dice should also have a method to return the result as a list...
    return 0;
  }

  /**
   * @deprecated Not really; just not fully implemented yet.
   */
  @Deprecated
  private final int doRollModeLow() {
    //TODO: The dice should also have a method to return the result as a list...
    return 0;
  }

  /**
   * @deprecated Not really; just not fully implemented yet.
   */
  @Deprecated
  private final int doRollModeNul() {
    return 0;
  }

  /**
   * Roll all the dice. This is used to obtain the full value of the cumulative pool of dice.
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
