package abc.autoupdate.enumeration;


/**
 * The update result. This is the actual final result of any update check or updater user-interface query.
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public enum UpdateResult {
  //=========================================================================
  //  Update Failed results: 3 possible resolutions.

  /**
   * Update Failed: Location Absent. This is to report that no update locations are passed into the update methodology.
   * @see UpdateResult
   */
  urf0(""),
  /**
   * Update Failed: Location Errors. This is to report that multiple locations resulted in errors. A further diagnostic
   * step may show what the error or obstacle is, if it can be determined.
   * @see UpdateResult
   */
  urf1(""),
  /**
   * Update Failed: Miscellaneous. This is for any failed update status that is otherwise non-categorized in any of the
   * above. In time, if enough errors are reported so as to determining one or more failure causes being present, a few
   * more result types may be added above.
   * @see UpdateResult
   */
  urf9(""),

  //=========================================================================
  //  Update Passed results: 6 possible resolutions.

  /**
   * Update Passed: Already Updated. This is for an update process where it is found that no further action is required
   * because all modules are equal or newer versions than what is found in the update location(s).
   * @see UpdateResult
   */
  urp0(""),
  /**
   * Update Passed: Found Some Updates. This is to report that updates were found at the target location, but they were
   * not applied automatically; further actions might be required to finish the updating process, such as accepting any
   * license requirements, etc.
   * @see UpdateResult
   */
  urp1(""),
  /**
   * Update Passed: Normal Completion. This is to report that updates were found and installed in place, and no further
   * action is required.
   * @see UpdateResult
   */
  urp3(""),
  /**
   * Update Passed: Restart Recommended.
   * @see UpdateResult
   */
  urp5(""),
  /**
   * Update Passed: Restart Recommended.
   * @see UpdateResult
   */
  urp7(""),
  /**
   * Update Passed: Restart Required.
   * @see UpdateResult
   */
  urp9("");
  private final String i18n;

  private UpdateResult(String s) {
    i18n = s;
  }
}
