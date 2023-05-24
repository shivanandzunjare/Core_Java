package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;

import com.app.Customer;
public interface IOUtils  {
	
	static void storeCustDetails(String filename,Map<Integer,Customer> custMap) throws FileNotFoundException, IOException
	{
		//serializable
		//java app -------------->binary file 
		try( ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)) )
		{
			out.writeObject(custMap);
		}

	}
	
	@SuppressWarnings("unchecked")
	static Map<Integer,Customer> restoreCustDetails(String filename) throws FileNotFoundException, IOException ,ClassNotFoundException
	{
		//de-seriaizable
		//java  <---------------- binary (char file 
		try( ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)) )
		{
			return (Map<Integer,Customer>)in.readObject();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return new HashMap<>();	
		}

	}
}
