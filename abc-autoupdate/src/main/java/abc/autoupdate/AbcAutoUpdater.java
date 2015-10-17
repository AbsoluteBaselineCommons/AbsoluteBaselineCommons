package abc.autoupdate;
import abc.autoupdate.enumeration.UpdateResult;


/**
 * The Auto-Updater infrastructure.
 * @author Gregory <gregory.cheyney@gmail.com>
 * @see #instance instance
 * @see #AbcAutoUpdater() AbcAutoUpdater()
 */
public class AbcAutoUpdater {
  /**
   * The default instance.
   * @see AbcAutoUpdater
   */
  public static final AbcAutoUpdater instance;

  static {
    instance = new AbcAutoUpdater();
  }

  /**
   * @see AbcAutoUpdater
   */
  private AbcAutoUpdater() {
  }

  /**
   * @param b A {@link Boolean} condition, representing whether to auto-apply updates.
   * @param s A {@link String} object, representing a target update location.
   * @return An {@link UpdateResult} instance.
   * @see AbcAutoUpdater
   */
  public UpdateResult checkUpdates(boolean b, String s) {
    //TODO: Perform the update check(s).
    return UpdateResult.urp0;
  }

  /**
   * @param b A {@link Boolean} condition, representing whether to auto-apply updates.
   * @param s A {@link String} array, representing a target update locations.
   * @return An {@link UpdateResult} instance.
   * @see AbcAutoUpdater
   */
  public UpdateResult checkUpdates(boolean b, String[] s) {
    //TODO: Perform the update check(s).
    return UpdateResult.urp0;
  }
}
