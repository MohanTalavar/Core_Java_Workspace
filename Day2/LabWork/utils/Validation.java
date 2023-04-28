package utils;

import java.security.InvalidAlgorithmParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Custom_Exceptions.InvalidLicenseExp;
import Custom_Exceptions.SpeedOutOfRangeExp;

public class Validation {
	
	public static final int MIN_SPEED;
	public static final int MAX_SPEED;
	public static SimpleDateFormat sdf;
	
	static {
		MIN_SPEED=40;
		MAX_SPEED=80;
		sdf= new SimpleDateFormat("dd/MM/yyyy");
	}

	// checking speed
	public static void CheckSpeed(int speed) throws SpeedOutOfRangeExp
	{
		if(speed < MIN_SPEED)
			throw new SpeedOutOfRangeExp("You are too SLOW!!");
		if(speed > MAX_SPEED)
			throw new SpeedOutOfRangeExp("Slow down: FATAL!!!");
		System.out.println("Speed within range: Carry ON..");	
		
	}// end of CheckSpeed
	
	// checking license
	public static Date CheckLicExpiry(String expiry) throws ParseException,
	InvalidLicenseExp
	{
		Date licExpDate = sdf.parse(expiry);
		
		Date today = new Date();
		if(licExpDate.after(today))
			return licExpDate;
		throw new InvalidLicenseExp("License Expired: Renew Bro!!");
		
	}// end of CheckLicExpiry
}
