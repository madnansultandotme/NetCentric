import java.io.*;
class ByteDemo {
	public static void main (String []args) {
		String str = "Testing Byte Array Input Stream.";
		byte[] b = str.getBytes();
		try (InputStream bais = new ByteArrayInputStream(b, 0, b.length)) {
			int ch;
			while((ch = bais.read()) != -1)
				System.out.print((char) ch);
			System.out.println();
			bais.reset();  //using reset ( ) method and again reading
			while((ch = bais.read()) != -1)
				System.out.print((char) ch);
		} catch (IOException e) {
		}
	}
}
