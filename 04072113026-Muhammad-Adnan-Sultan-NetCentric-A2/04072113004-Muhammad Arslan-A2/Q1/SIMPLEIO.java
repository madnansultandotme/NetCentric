
import java.io.IOException;

class SimpleIO{
	public static void main(String args[])	{
 		byte bytearr[] = new byte[30];
		try 			{	
		  	System.out.println("Enter a line: ");
		 // Reads up to len bytes of data from the //input stream into an array of bytes
				System.in.read(bytearr,0,30);
	  	 System.out.print("The line typed was: ");
     	String str = new String(bytearr);
			System.out.println(str);
   	} catch(IOException e)	{ 
	   		System.err.print("Error occurred:" + e);
									}
 	}
}
