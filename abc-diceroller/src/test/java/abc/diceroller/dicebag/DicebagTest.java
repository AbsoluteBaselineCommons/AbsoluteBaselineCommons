package abc.diceroller.dicebag;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 *
 * @author Gregory
 */
public class DicebagTest {

  public DicebagTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of roll method, of class Dicebag.
   */
  @Test
  public void testRoll() {
    System.out.println("roll");
    Dicebag instance = null;
    int expResult = 0;
    int result = instance.roll();
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

}
