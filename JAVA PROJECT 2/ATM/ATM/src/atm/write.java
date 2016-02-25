package atm;
//THIS IS HOW YOU WRITE TO A FILE 
//IN the IT world reading and writing from a file is the duck tape of the IT world. 

import java.io.*;
public class write 
{
	public static void main(String args[])
	{
		try
		{
        		FileOutputStream fos = new FileOutputStream("./file.out");
        		ObjectOutputStream oos = new ObjectOutputStream(fos);
        		//Test x = new Test("testing", 37);
//			Test y = new Test();
//			y.str = "testing";
//			y.ivalue = 37;
//			oos.writeObject(y);
        		oos.flush();
        		fos.close();
        	}
        	catch (Throwable e)
		{
        		System.err.println(e);
        	}
	}
}
