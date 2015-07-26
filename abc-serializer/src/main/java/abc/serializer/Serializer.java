package abc.serializer;
import abc.serializer.logics.ASerialLogic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
  protected void serialReading(File f) throws FileNotFoundException, IOException {
    if(f != null && f.exists() && logic != null) {
      FileInputStream fis = new FileInputStream(f);
      try(DataInputStream dis = new DataInputStream(fis)) {
        logic.serialReading(dis);
      }
    }
  }

  @Override
  protected void serialWriting(File f) throws FileNotFoundException, IOException {
    if(f != null && f.exists() && logic != null) {
      FileOutputStream fos = new FileOutputStream(f);
      try(DataOutputStream dos = new DataOutputStream(fos)) {
        logic.serialWriting(dos);
        dos.flush();
      }
    }
  }
}
