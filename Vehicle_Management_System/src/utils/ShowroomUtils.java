package utils;
import java.util.ArrayList;
import java.util.List;
import com.app.core.Vehicle;
import static utils.ValidationRules.validateAllInputs;
import custom_exception.VehicleHandlingException;
public class ShowroomUtils {
	//add static method for return popuated list ( hardcoded data
	public static List<Vehicle> populateShowroom() throws VehicleHandlingException{
	
		
		//Hard Coded List By Using ArrayList
			ArrayList<Vehicle> vehicles=new ArrayList<>();
			//vehicles.add(validateAllInputs("as-121","Red",15000,"2023-02-02","tata",vehicles));
			vehicles.add(validateAllInputs("as-122","black",20000,"2023-02-02","tata",vehicles));
			vehicles.add(validateAllInputs("as-123","white",10000,"2023-02-02","tata",vehicles));
			vehicles.add(validateAllInputs("as-124","Silver",25000,"2023-02-02","tata",vehicles));
			vehicles.add(validateAllInputs("as-125","red",15000,"2023-02-02","tata",vehicles));
			
			return vehicles;
	
	}



}
