import java.io.*;
import java.util.*;
import java.util.zip.*;
public class ZipFileTest {
public static void main(String[] args) throws Exception{
	 ZipFile zipFile = new ZipFile("test.zip");
	// Get a single entry from a zip file 
	ZipEntry zipEntry = zipFile.getEntry("test/test.txt");
	if (zipEntry != null) {
		InputStream inputStream = zipFile.getInputStream(zipEntry);
		int i ;
		while ((i=inputStream.read())!=-1)
			System.out.print((char)i);
	} else {
		System.out.println("Entry 'test/test.txt' not found in the zip file.");
	}
	//list all entries in a zip file 
 	Enumeration<? extends ZipEntry> entries = zipFile.entries();
 	while(entries.hasMoreElements()){
    		ZipEntry entry = entries.nextElement();
    		if(entry.isDirectory()){
        		System.out.println("dir  : " + entry.getName());
    		} else {
       			System.out.println("file : " + entry.getName());
    		}
	}
}
}
