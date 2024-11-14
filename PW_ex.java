import java.io.FileWriter;
import java.io.PrintWriter;
public class PW_ex{
  public static void main(String[] args) throws Exception {
    String filename = "aa.txt";
    String[] linesToWrite = new String[] { "a", "b" };
    boolean appendToFile = true;
    PrintWriter pw = null;
    if (appendToFile) {
      pw = new PrintWriter(new FileWriter(filename, true));
    } else {
      pw = new PrintWriter(new FileWriter(filename)); }
    for (int i = 0; i < linesToWrite.length; i++) {
      pw.println(linesToWrite[i]);   }
	 pw.format("This is a %s program", "test");
    pw.flush();    pw.close();
  }
}
