import java.io.BufferedInputStream;
import java.io.IOException;
public class BuffInput {
public static void main(String[] args) {
System.out.println("Enter a line:");
BufferedInputStream bi = new BufferedInputStream(System.in);
try {
for (int i=0; i<=bi.available(); i++ ){
	int x = bi.read();
	System.out.print((char)x + " ");}
	} catch (IOException e) {		}
	}
}
