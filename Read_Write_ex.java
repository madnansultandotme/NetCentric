import java.io.*;
public class Read_Write_ex {
  public static void main(String[] argv) throws Exception {
    FileWriter fw = new FileWriter("aa.txt");
    String strs[] = { "abc", "def", "ghi", "jkl" };
    for (int i = 0; i < strs.length; i++) {
      fw.write(strs[i] + "\r\n");
    }
    fw.close();
  }
}
