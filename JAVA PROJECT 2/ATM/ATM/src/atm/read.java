package atm;
//THIS IS HOW YOU READ FROM A FILE
// read.java
import java.io.*;
public class read
{
	public static void main(String args[])
        {
//		Test testobj = null;
		try
		{
			FileInputStream fis = new FileInputStream("./file.out");
                        // a realative path is ./ means the realative path of where the program was started its the relative path.
                        // But the path ./file.out is called the Absolute path C:/Temp/file.out its when yuou want to change the path from where you started the program to another place is ABSOLOUTE PATH
			ObjectInputStream ois = new ObjectInputStream(fis);
//			testobj = (Test)ois.readObject();
			fis.close();
		}
		catch (Throwable e)
		{
			System.err.println(e);
		}
//		System.out.println(testobj.str);
//		System.out.println(testobj.ivalue);
	}
}
