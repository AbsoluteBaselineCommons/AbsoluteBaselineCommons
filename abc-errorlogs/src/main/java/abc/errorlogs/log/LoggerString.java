package abc.errorlogs.log;


/**
 * The logger strings. This is basically for internationalization and localization of the logger messages, if needed.
 * @author Gregory
 */
public enum LoggerString {
  clsBaseInitNormal(""),
  clsBaseInitStatic(""),

  clsNormCtorBefore("logger.class.normal.constr.before"),
  clsNormCtorEmptyX("logger.class.normal.constr.emptyx"),
  clsNormCtorFinsih("logger.class.normal.constr.before"),
  clsNormMethBefore("logger.class.normal.method.before"),
  clsNormMethEmpty_("logger.class.normal.method.emptyx"),
  clsNormMethFinsih("logger.class.normal.method.finish"),

  clsSingCtorBefore("logger.class.single.constr.before"),
  clsSingCtorEmpty_("logger.class.single.constr.emptyx"),
  clsSingCtorFinish("logger.class.single.constr.finish"),
  clsSingMethBefore("logger.class.single.constr.before"),
  clsSingMethEmpty_("logger.class.single.constr.emptyx"),
  clsSingMethFinish("logger.class.single.constr.finish"),

  xyzMiscellany("");
  public final String text;

  private LoggerString(String s) {
    text = "";
  }
}
