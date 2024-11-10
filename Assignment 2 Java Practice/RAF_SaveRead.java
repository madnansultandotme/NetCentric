import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF_SaveRead {
  public static void main(String[] args) throws IOException {
    RandomAccessFile rf = new RandomAccessFile("test.dat", "rw");
    for (int i = 0; i < 10; i++)
      rf.writeByte(i );
    rf.close();
    rf = new RandomAccessFile("test.dat", "rw");
    rf.seek(5); //seek at the byte 5th
    rf.writeByte(100); //change value to 100
    rf.close();
    rf = new RandomAccessFile("test.dat", "r");
    for (int i = 0; i < 10; i++)
      System.out.println("Value " + i + ": " + rf.readByte());
    rf.close();
  }
}
