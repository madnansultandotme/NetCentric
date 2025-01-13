
import java.io.File;
import java.util.Scanner;

class FileInfo {
static void show(String s) {
System.out.println(s); 
	}
public static void main(String args[]){
String fi;
Scanner in= new Scanner(System.in);
fi=in.next();
File f1 = new File(fi);
show(f1.getName()+(f1.exists()?" exists" : " does not exist"));
show ("File size   :"+f1.length()+" bytes");
show ("Is"+(f1.isDirectory()?" a directory":"not a directory"));
     show (f1.getName()+(f1.canWrite()? " is writable" : " is not writable"));
     show(f1.getName()+(f1.canRead()? " is readable" : " is not readable"));
 show("File was last modified :" + f1.lastModified());
	}
}
