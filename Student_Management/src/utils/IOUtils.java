package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.Student;

public interface IOUtils {
	
	public static void storeStuDetails(String filename,Map<Integer, Student> stuMap)
			throws FileNotFoundException, IOException {

		//java app ----> OOS ---> FOS ------> binary source file 
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
         // serialization 			
			out.writeObject(stuMap);

		}
	}

	 public static Map<Integer, Student> restoreStuDetails(String filename) throws FileNotFoundException, IOException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			//java app <---- OIS <--- FIS <------ binary dest file 
			//de -serialization
			
			return (Map<Integer, Student>) in.readObject();

		} catch (Exception e) {
			System.out.println(" error in deserialization " + e);
			return new HashMap<>();
		}
		
		
	}

}
