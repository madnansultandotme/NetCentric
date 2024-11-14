import java.io.*;
public class FileDescriptorDemoOne {
public static void main(String[] args) throws IOException {
    File file = new File("test.txt");
    FileOutputStream fos1 = new FileOutputStream(file);
    FileDescriptor fd = fos1.getFD(); 
    //passing FileDescriptor to another  FileOutputStream
    FileOutputStream fos2 = new FileOutputStream(fd);
    fos2.write("Hello World!".getBytes());
    fos1.close();
    fos2.close();
}
} 
