package abc.serializer;
import abc.errorlogs.log.AbcLogger;
import abc.serializer.logics.ASerialLogic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * The default serialization.
 * @author Gregory
 */
class Serializer extends ASerializer {
  protected Serializer(ASerialLogic l) {
    super(l);
  }

  @Override
  protected void serialReading(File f) {
    if(f != null && f.exists() && logic != null) {
      try(FileInputStream fis = new FileInputStream(f);
          DataInputStream dis = new DataInputStream(fis)) {
        //logic.serialReading(dis);
        dis.close();
      } catch(IOException ex) {
        AbcLogger.logThis(AbcLogger.L1, "Serializer.serialReading(File) encountered an IOException", ex);
      }
    }
  }

  @Override
  protected void serialWriting(File f) {
    if(f != null && f.exists() && logic != null) {
      try(FileOutputStream fos = new FileOutputStream(f);
          DataOutputStream dos = new DataOutputStream(fos)) {
        //logic.serialWriting(dos);
        //dos.flush();
        //dos.close();
      } catch(IOException ex) {
        AbcLogger.logThis(AbcLogger.L1, "Serializer.serialWriting(File) encountered an IOException", ex);
      }
    }
  }
}
