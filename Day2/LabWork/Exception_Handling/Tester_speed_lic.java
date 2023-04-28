package Exception_Handling;
import static utils.Validation.*;

import java.util.Scanner;

public class Tester_speed_lic {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
		System.out.println("Enter the speed:");
		CheckSpeed(sc.nextInt());
		
		System.out.println("Enter license Exp Date: dd/MM/yyyy ");
		System.out.println("Your license is expiring on "+ CheckLicExpiry(sc.next()));
		System.out.println("Good TOGO For Now!!!");
		System.out.println("End of try block");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());	
		}
		finally
		{System.out.println("In finally block");}
		
		System.out.println("End of main: No Error/ Altered Path");
	}//main
	
}
