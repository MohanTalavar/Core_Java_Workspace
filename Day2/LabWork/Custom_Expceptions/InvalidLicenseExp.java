package Custom_Exceptions;

@SuppressWarnings("serial")
public class InvalidLicenseExp extends Exception{
	
	public InvalidLicenseExp(String msg)
	{
		super(msg);
		
	}
}
