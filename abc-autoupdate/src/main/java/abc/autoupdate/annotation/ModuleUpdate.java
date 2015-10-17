package abc.autoupdate.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * A module update annotation. This annotation defines relevant details of the updateable module, so that an annotation
 * processor can handle it.
 * @author Gregory <gregory.cheyney@gmail.com>
 * @see #coreVersion() coreVersion()
 * @see #delayUpdate() delayUpdate()
 * @see #updaterBasePath() updaterBasePath()
 * @see #updaterLastTime() updaterLastTime()
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface ModuleUpdate {
  /**
   * Get the core version. This is the module-developer's specified version string. The updater methodology may compare
   * against its value.
   * <p/>
   * As a version string, it is up to the implementer to decide what format to use. The text could be a dotted list of
   * numbers in the order of year, month, date, and possibly even the time; or it could be a dotted list of numbers for
   * major, minor, release, and build values. The general idea is that successive versions would, in a sorting method,
   * legitimately come later than existing versions....
   * @return A {@link String} object.
   * @see ModuleUpdate
   */
  public String coreVersion();

  /**
   * Get the updater base path. This is the base path that is used to show where the updated library module is located.
   * <p/>
   * This is a {@link URL} of a publicly-accessible web-page or folder, anywhere that the update modules will be found
   * and be retrieved.
   * @return A {@link String} object.
   * @see ModuleUpdate
   */
  public String updaterBasePath() default "";

  /**
   * Get the updater last time. This is the last time of this module definition, indicating that something with a newer
   * date and time will also match.
   * <p/>
   * This is an alternative way to compare a version, based upon the date + time of the last release.
   * @return A {@link String} object.
   * @see ModuleUpdate
   */
  public String updaterLastTime() default "";

  /**
   * Delay updates. This determines whether the updating process for this module is delayed until last in the updating.
   * <p/>
   * If multiple modules are delayed, they will be processed in the same order as those which are not delayed.
   * @return A {@link Boolean} condition.
   * @see ModuleUpdate
   */
  public boolean delayUpdate();
}
