package tester;

import static utils.ShowRomutils.populateShowroom;
import static utils.VehicleValidationRules.parseAndValidateDate;
import static utils.VehicleValidationRules.validateAllinputs;
import static utils.VehicleValidationRules.parseAndValidateColor;
import utils.VehicleValidationRules;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Color;
import com.app.core.Vehicle;

import CustomExp.VehicleHandlingExp;

public class testerVehicle {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			List<Vehicle> vehicleList = populateShowroom(); // Declaring List<Vehicle> vehicleList !!!!!
			boolean exit = false;

			while (!exit) {

				// Displaying the colors and there costs
//                System.out.println("Vehicle Colors wrts their cost: ");
//				for(Color e : Color.values())
//					System.out.print(e+ " ");

				System.out.println("Options 1. Add a Vehicle 2. Display all "
						+ "\n3. Get specific vehicle details 4. Apply discount  "
						+ "\n5. Delete vehicle details  by ch no 6. Delete vehicles by color "
						+ "\n7. Sort the vehicles as per ch no " + "8. Sort the vehicles as per price "
						+ "\n9. Sort the vehicles as per date n price " + "10. Sort the vehicles as per date 0. Exit");
				System.out.println("Choose an option");

				try {
					switch (sc.nextInt()) {

					case 1: // add a new vechile
						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  basePrice,  manufactureDate(yr-mon-day),  company");
						Vehicle vehicle = validateAllinputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(),
								vehicleList);
						vehicleList.add(vehicle);
						System.out.println("Vehicle Added !!!!!!!!!");
						break;

					case 2: // Display all vehicles;
						for (Vehicle v : vehicleList)
							System.out.println(v);

						break;

					case 3: // 3. Get specific vehicle details ip = chasis no

						System.out.println("Enter Chasis No");
						Vehicle anotherVechicle = new Vehicle(sc.next());
						int index = vehicleList.indexOf(anotherVechicle);
						if (index == -1)
							throw new VehicleHandlingExp(" Invalid ch no | Vehicle not found!!!!!!");
						System.out.println("Vehicle Found!!! ");
						System.out.println("Vehicle details : " + vehicleList.get(index));
						break;

					case 4: // Enter date and discunted amount
						System.out.println("Enter date(yyyy-mm-dd) and Disc amount: ");
						LocalDate date = parseAndValidateDate(sc.next());
						double discamt = sc.nextDouble();
						for (Vehicle v : vehicleList)
							if (v.getManufacturingDate().isBefore(date))
								v.setNetprice(v.getNetprice() - discamt);
						System.out.println("Discount applied!!!!!!");
						break;

					case 5: // ip= ch no | act to remove/ delete the vechicle

						System.out.println("Enther chasis no: ");
						Vehicle anotherVehicle = new Vehicle(sc.next());
						int index1 = vehicleList.indexOf(anotherVehicle);
						if (index1 == -1)
							throw new VehicleHandlingExp("Invalid Input : vhicle not found!!!!!1");
						vehicleList.remove(index1);
						System.out.println("Vehicle removed!!!!!!!");
						

						break;

					case 6: // remove vehicles of specified color
						System.out.println("ENter color: ");
						Color chosenClr = parseAndValidateColor(sc.next());
						Iterator<Vehicle> itr = vehicleList.iterator();
						while (itr.hasNext())
							if (itr.next().getVehicleColor() == chosenClr)
								itr.remove();
						System.out.println("vehicles removed of color:"+chosenClr.name());
						break;
						

					case 7: // sort as per PK = chasis no

						Collections.sort(vehicleList);
						System.out.println(vehicleList);

						break;

					case 8: // sort the vehicles as per price

						Collections.sort(

								vehicleList, new Comparator<Vehicle>() {

									@Override
									public int compare(Vehicle v1, Vehicle v2) {
										System.out.println("in innerclass sorting price");
										if (v1.getNetprice() < v2.getNetprice())
											return -1;
										if (v1.getNetprice() == v2.getNetprice())
											return 0;
										return 1;

									}
								}

						);

						break;
						
					case 9:  // sort vehicles as per date and price
						
						Collections.sort(
								
								vehicleList, new Comparator<Vehicle>() {
									
									public int compare(Vehicle v1, Vehicle v2) {
										System.out.println("in innerclas sorting date and price");
										int retVal = v1.getManufacturingDate().compareTo(v2.getManufacturingDate());
										if(retVal==0)
										{
											if(v1.getNetprice()<v2.getNetprice())
												return -1;
											if(v1.getNetprice()==v2.getNetprice())
												return 0;
											return 1;
											
										}
										return retVal;
										
									}//method
									
								}// inner class
								
								);
						break;
						
					case 10: //// sort vehicles as per date
						
								Collections.sort(
								
								vehicleList, new Comparator<Vehicle>() {
									
									public int compare(Vehicle v1, Vehicle v2) {
										System.out.println("in innerclass sorting date");
										return v1.getManufacturingDate().compareTo(v2.getManufacturingDate());	
									}//method
									
								}// inner class
								
								);
						
						break;
						
					case 0: // exit
						System.out.println(Exitng the code);
						exit=true;
						break;
						
					default:
						System.out.println("Invalid Input!!!!!!!!!!!!111");
						break;

					}// Switch case

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			} // end of while

		} // sc.close()
	}// end of main

}
