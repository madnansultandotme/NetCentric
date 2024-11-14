import java.io.*;
public class ReadWrite_UTF {
public static void main(String[] args) {
    try {
     String st="test";
OutputStreamWriter wri = new OutputStreamWriter(
     new FileOutputStream("b.txt"), "UTF-8");
     char[] chars1 = st.toCharArray();
     wri.write(chars1); //write
     wri.close();
InputStreamReader rea = new InputStreamReader(
      new FileInputStream("b.txt"), "UTF-8");
      char[] chars2 = new char[50];
      rea.read(chars2); // read 
      for (int i=0; i< chars2.length; i++) 
      System.out.print(chars2[i]); 
    } catch (IOException e) {
    System.out.println(e.toString());   }
  }
}
