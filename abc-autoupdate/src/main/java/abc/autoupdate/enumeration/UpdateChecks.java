package abc.autoupdate.enumeration;
import abc.autoupdate.i18n.UpdateI18n;


/**
 * The initial update check results. This allows handling the result of an update check, which is returned from an
 * initial check.
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public enum UpdateChecks {
  /**
   * No update available. This indicates that all modules are at their current versions, that no new updates need to be
   * downloaded and applied.
   * @see UpdateChecks
   */
  uc0("uc0"),
  /**
   * Updates are available. One or more modules may be downloaded and applied, a process which might require a restart.
   * Generally, a restart of the application is only mandatory if any module being replaced is in use at the time.
   * @see UpdateChecks
   */
  uc1("uc1"),
  uc2("uc2"),
  /**
   * Update timed out. This will be returned by the updater if the Update Center cannot be contacted, due to the target
   * connection timed out. Try again, with a longer timeout duration?
   * @see UpdateChecks
   */
  uc3("uc3"),
  /**
   * Connection error. This will be returned by the updater if the Update Center cannot be contacted, due to an unknown
   * error or interruption to the update process. Perhaps a hardware or software firewall is halting the connection?
   * @see UpdateChecks
   */
  uc4("uc4");
  /**
   * The internationalization key. This is used for the other strings to obtain the proper internationalized text.
   * @see UpdateChecks
   */
  private final String i18n;
  /**
   * The result name. This is a brief capitalized text that focuses as the primary result descriptor.
   * @see UpdateChecks
   */
  public final String name;
  /**
   * The result note. This is a brief sentence that forms a more complete description of the result.
   * @see UpdateChecks
   */
  public final String note;
  /**
   * The result text. This is a further few lines of text describing how this affects, or is affected by, situations in
   * general; it may include a hint on what action might be taken, or in the case of the error instances, what might be
   * the cause of the error.
   * @see UpdateChecks
   */
  public final String text;

  /**
   * A private constructor. This sets up the internationalization string that can be used for a message
   * @param s A {@link String} object, representing the {@link #i18n internationalization} key.
   * @see UpdateChecks
   * @see UpdateI18n#enums
   * @see #i18n i18n
   * @see #name name
   * @see #note note
   * @see #text text
   */
  private UpdateChecks(String s) {
    i18n = s;
    name = UpdateI18n.enums.getString(String.format("UpdateChecks.%s.name", i18n));
    note = UpdateI18n.enums.getString(String.format("UpdateChecks.%s.note", i18n));
    text = UpdateI18n.enums.getString(String.format("UpdateChecks.%s.text", i18n));
  }
}
