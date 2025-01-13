import java.io.FileInputStream;
class Read_File_Disp {

  public static void main(String args[]) throws Exception {
      // Read and display data (int type)
      try (FileInputStream fis = new FileInputStream("a.txt")) {
          // Read and display data (int type)
          int i;
          while ((i = fis.read()) != -1) {
              System.out.print((char)i + " ");
          } }
  }
}
