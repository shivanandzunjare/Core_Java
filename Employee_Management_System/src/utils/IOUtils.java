package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;

import com.app.Employee;
public interface IOUtils {
	
	//1.add static method to store  employee detaills //
	//store at end 
	static void storeEmpDetails(String filename,  Map<String, Employee> emMap) throws IOException
	{
		//I/O Stream :Serialization
		//java app ----> OOS ---> FOS ------> binary source file 
		try ( ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream(filename) ) )
		{
			//Serialization
			out.writeObject(emMap);
		}
	}
	//2. static method  to restore //restore at begining 
	
	
	@SuppressWarnings(" unchecked")
	static Map<String,Employee> restoreEmpDetails(String filename) throws IOException, ClassNotFoundException{
		try ( ObjectInputStream in = new ObjectInputStream (new FileInputStream(filename) ) )
		{
			//de-Serialization
			////java app <---- OIR <--- FIR <------ binary dest file 
			return (Map<String, Employee>)in.readObject();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return new HashMap<>();
		}
	}
	

	
	
	
}
