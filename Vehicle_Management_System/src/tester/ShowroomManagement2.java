package tester;
import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exception.VehicleHandlingException;
import utils.ValidationRules;
import custom_ordering.VehicleDatePriceComparator;
import custom_ordering.VehiclePriceComparator;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import static utils.ValidationRules.*;
import static utils.ValidationRules.validateAllInputs;
import static utils.ShowroomUtils.populateShowroom;
import static utils.ValidationRules.parseAndValidateColor;
import static utils.ValidationRules.parseAndValidateDate;

public class ShowroomManagement2 {

	public static void main(String[] args) throws VehicleHandlingException {
		try(Scanner sc=new Scanner(System.in)){
			
			List<Vehicle> showroom=populateShowroom();
			boolean exit=false;
			//int counter=0;
			while(!exit) {
				System.out.println("Options 1. Add a Vehicle 2. Display all "
						+ "3. Get specific vehicle details 4. Apply discount  "
						+ "5. Delete vehicle details  by ch no 6. Delete vehicles by color "
						+ "7. Sort the vehicles as per ch no " + "8. Sort the vehicles as per price "
						+ "9. Sort the vehicles as per date n price " + "10. Sort the vehicles as per date 0. Exit");
				System.out.println("Choose an option");
				try {
				switch(sc.nextInt()) {
				case 1:
					//add vehicle 
					System.out.println("enter the details ( chasisNo,vehicleColor, basePrice,manufactureDate,company");
					Vehicle  vehicle = validateAllInputs(sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),showroom);
					showroom.add(vehicle);
					System.out.println("Vehicle is loaded to showroom");
				break;
				
				case 2:  //display  all details 
					System.out.println(" showroom content  :");
				showroom.forEach(v->System.out.println(v));
					break;
					
				case 3: //get specific vehive details
					System.out.println("enter the chasisNo");
					Vehicle vehicle1 =new Vehicle(sc.next());
					
					int index = showroom.indexOf(vehicle1);
					if (index == -1)
						throw new VehicleHandlingException(" invalid chasis no");
					System.out.println(showroom.get(index));
					System.out.println("vehive details");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 4:  //discount 
					System.out.println(" enter the date and discount amount ");
					LocalDate date=parseAndValidateDate(sc.next());
					
					double discount=sc.nextDouble();
					for(Vehicle  v : showroom)
						if(v.getManufactureDate().isBefore(date))
					v.setBasePrice(v.getBasePrice()-discount);
					System.out.println("discount applied");
					
					System.out.println(" after Discount : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 5://Delete vehicle details  by ch no
					System.out.println("enter the chasis no to delete the vehicle ");
					index=showroom.indexOf(new Vehicle(sc.next()));
					if(index == -1)
						throw new VehicleHandlingException(
								"Invalid ch no , Vehicle not found, can't be remove");
					System.out.println("removed "+ showroom.remove(index));
					System.out.println(" after Delete vehicle details  by ch no : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 6:  //Delete vehicles by color
					System.out.println("enter the color");
					Color chosenClr=parseAndValidateColor(sc.next());
					Iterator<Vehicle> itr=showroom.iterator();
					while(itr.hasNext())
						if(itr.next().getVehicleColor()== chosenClr)
							itr.remove();
					System.out.println(" after deleting vehicle buy  color  : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 7:// Sort the vehicles as per ch no
					Collections.sort( showroom);
					System.out.println(" after Sort the vehicles as per chasis No : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 8:// Sort the vehicles as per price "
					Collections.sort(showroom, new VehiclePriceComparator());
					System.out.println(" after Sort the vehicles as per price : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 9://Sort the vehicles as per date n price
					Collections.sort(showroom,new VehicleDatePriceComparator());
					System.out.println(" after Sort the vehicles as per date n price : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 10://Sort the vehicles as per date 
					Collections.sort(showroom,new Comparator<Vehicle>(){
						@Override 
						public int compare(Vehicle o1, Vehicle o2) {
							System.out.println(" compare : date anonymous inner class");
							return o1.getManufactureDate().compareTo(o2.getManufactureDate());
							
						}
					});
					System.out.println(" after Sort the vehicles as per date  : showroom content ");
					showroom.forEach(v->System.out.println(v));
					break;
					
				case 0:
					exit=true;
					break;
					
				}
				
				}
				catch(Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			
			}
					
		}
	
	}



}
