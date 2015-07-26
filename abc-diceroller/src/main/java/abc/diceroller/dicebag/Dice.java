package abc.diceroller.dicebag;
import java.util.Random;


/**
 * A dice-instance. This is also used in a "dice-bag" for complex automated rolls.
 * @author Gregory
 * @see #random random
 * @see #modifier modifier
 * @see #sides sides
 * @see #Dice() Dice()
 * @see #Dice(int) Dice(int)
 * @see #Dice(int,int) Dice(int,int)
 * @see #roll() roll()
 * @see #roll(int) roll(int)
 */
public class Dice {
  /**
   * A randomizer.
   * @see Dice
   */
  private final Random random;
  /**
   * A roll modifier.
   * @see Dice
   */
  private final int modifier;
  /**
   * The number of sides.
   * @see Dice
   */
  private final int sides;

  {
    random = new Random(System.currentTimeMillis());
  }

  /**
   * A public constructor. This turns this die instance into a "percentile" die; its roll will produce a result in the
   * range of one to one-hundred, as an integer.
   * @see Dice
   */
  public Dice() {
    this(100);
  }

  /**
   * A public constructor. This takes a value for the number of sides; the sides should be a number between two and the
   * maximum positive value of an integer.
   * @param i An {@link Integer} value, representing the number of die {@link #sides sides}.
   */
  public Dice(int i) {
    this(i, 0);
  }

  /**
   * A public constructor. This takes a value for the number of sides; the sides should be a number between two and the
   * maximum positive value of an integer.
   * @param i An {@link Integer} value, representing the number of die {@link #sides sides}.
   * @param j An {@link Integer} value, representing the additional {@link #modifier modifier}.
   */
  public Dice(int i, int j) {
    sides = i;
    modifier = j;
  }

  /**
   * Roll the die. Returns the sum of the current roll.
   * <p/>
   * This obtains the result of only one roll; for multiple rolls, use {@link #roll(int) roll(int) instead.
   * @return An {@link Integer} value.
   */
  public final int roll() {
    return modifier + (int)(Math.floor(random.nextFloat() * sides) + 1);
  }

  /**
   * Roll the die. Returns the sum of all rolls.
   * <p/>
   * This obtains the result of as many die rolls as the parameter specifies. The parameter must be a positive integer,
   * with a minimum value of one, and a maximum value of {@link Integer#MAX_VALUE}.
   * @param i An {@link Integer} value, representing the number of times to roll this die.
   * @return An {@link Integer} value.
   */
  public final int roll(int i) {
    int sum = 0;
    if(i < 2 || i >= Integer.MAX_VALUE / i) {
      sum = roll();
    } else {
      for(int j = 0; j < i; j++) {
        sum += roll();
      }
    }
    return sum;
  }
}
