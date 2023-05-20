package custom_ordering;
import java.util.Comparator;
import com.app.core.*;
//comparator comparable method
public class VehicleDatePriceComparator implements Comparator<Vehicle> {
	public int compare (Vehicle v1, Vehicle v2) {
		int retVal=v1.getManufactureDate().compareTo(v2.getManufactureDate());
			if (retVal==0){

				if(v1.getBasePrice()< v2.getBasePrice())
					return -1;
				if(v1.getBasePrice()== v2.getBasePrice())
					return 0;
				return 1;
		}
			return retVal;
	}

}
