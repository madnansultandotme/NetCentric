import java.io.*;
class FileDemo {
  public static void main(String args[]) throws 	Exception {
      try (InputStream f = new FileInputStream("a.txt")) {
          int size= f.available();
          System.out.println("Bytes available: " + size);
          byte[] buff = new byte[size];
          f.read(buff,0,size);
          String s = new String(buff);
          System.out.print(s);
      }
   }
}
