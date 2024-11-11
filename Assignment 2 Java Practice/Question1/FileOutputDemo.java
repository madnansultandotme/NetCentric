import java.io.*;
class FileOutputDemo {
public static void main(String args[]) {
String s="Testing file output stream";
byte b[] = s.getBytes();
try {
FileOutputStream fos = new FileOutputStream("aa.txt");
 fos.write(b,0,b.length);
 System.out.println(b.length + " bytes are written!");
}  catch(IOException e) {
   System.out.println("Error creating file!");
	}
  }
}
