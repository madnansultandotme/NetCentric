
import java.io.*;

public class CopyFileTV_ex {
  public static void main(String[] args) throws IOException {
    //  File fil = new File("a1.txt");
      FileInputStream fin = new FileInputStream("a1.txt");//or: (fil)
      FileOutputStream fout = new FileOutputStream("xyz.txt");
      byte[] buffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = fin.read(buffer)) > 0) {
        fout.write(buffer, 0, bytesRead);
      }
      fin.close();
      fout.close();
    }
  }
// int size = 0;
// try {
// size = fin.available();
// byte[] b = new byte[size];
// fin.read(b,0,size);
// fout.write(b,0,size);
// } catch (IOException e) {
// // TODO e.printStackTrace();
// 	}
