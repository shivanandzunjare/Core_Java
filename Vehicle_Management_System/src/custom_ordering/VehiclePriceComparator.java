package custom_ordering;

import java.util.Comparator;
import com.app.core.*;

public class VehiclePriceComparator implements Comparator<Vehicle>{
	@Override
	
	public int compare(Vehicle v1,Vehicle v2) {
		System.out.println("in  vehicle compare ");
		if(v1.getBasePrice() < v2.getBasePrice())
			return -1;
		if(v1.getBasePrice() == v2.getBasePrice())
			return 0;
		return 1;
	}

}
