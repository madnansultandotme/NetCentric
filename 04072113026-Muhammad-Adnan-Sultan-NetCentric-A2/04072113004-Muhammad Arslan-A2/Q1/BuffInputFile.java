
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BuffInputFile {
public static void main(String[] args) throws Exception {
    byte[] buffer = new byte[1024];
    try (BufferedInputStream bi = new BufferedInputStream(new FileInputStream("b.txt"))) {
        int bytesRead = 0;
        while ((bytesRead = bi.read(buffer)) != -1)
        {
            String chunk = new String(buffer, 0, bytesRead);
            System.out.print(chunk);
        }
    }
  }
}