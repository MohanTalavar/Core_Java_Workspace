package utils;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Color;
import com.app.core.Vehicle;

import CustomExp.VehicleHandlingExp;

public class VehicleValidationRules {
	
	public static Vehicle validateAllinputs( String chasisNo, String vehicleColor, double basePrice, String manufactureDate, String company,List<Vehicle> vehicles )
	throws VehicleHandlingExp
	{
		checkForDup(chasisNo, vehicles);
		Color ValidColor = parseAndValidateColor(vehicleColor);
		double netPrice = basePrice + ValidColor.getColorCost();
		LocalDate ValidDate = parseAndValidateDate(manufactureDate);
		return new Vehicle (chasisNo, ValidColor, netPrice, ValidDate,company );
		
	}
	
	//=========================================================================
	public static LocalDate parseAndValidateDate(String date) throws VehicleHandlingExp {
		
		LocalDate d1 = LocalDate.parse(date);
		LocalDate beginYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if(d1.isAfter(beginYear))
			return d1;
		throw new VehicleHandlingExp("vehicle should be mfg after 1st jan of curnt year!");
	}
	
	//=============================================================================
	public static Color parseAndValidateColor(String clr) throws IllegalArgumentException{
		
		return Color.valueOf(clr.toUpperCase());
	}
	
	//=====================================================================
	public static void checkForDup(String chasisNo, List<Vehicle> vehicles)
	throws VehicleHandlingExp{
		
		Vehicle newVehicle = new Vehicle(chasisNo);
		
		if(vehicles.contains(newVehicle))
			throw new VehicleHandlingExp("Dup chasis no!!!!!!!!!");
		System.out.println("No dup found");
			
	}

}
