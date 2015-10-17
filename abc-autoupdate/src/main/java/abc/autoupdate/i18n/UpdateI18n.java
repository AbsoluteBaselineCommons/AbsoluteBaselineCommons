package abc.autoupdate.i18n;
import java.util.ResourceBundle;


/**
 * The updater internationalization. This is an interface holding references to the resource bundles that localize text
 * for various updater components.
 * @author Gregory <gregory.cheyney@gmail.com>
 * @see #enums enums
 */
public interface UpdateI18n {
  /**
   * The enumeration bundle. This properties file contains localized strings used in various enumeration instances.
   * @see UpdateI18n
   */
  public static final ResourceBundle enums
      = ResourceBundle.getBundle("/abc/autoupdate/i18n/Enumerations.properties");
}
