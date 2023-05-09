package Utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.EmptyStackException;
import java.util.Map;

import com.app.core.Dept;
import com.app.core.Emp;

import CustionException.EmpExcptionHandling;


public class EmpValidationRules {
	
	//=================================== Validate all Inputs
	
	public static Emp validateAllinputs(String empId, String FirstName, String empLastName, 
			String deptName, String joinDate, double salary,Map<String,Emp> emps) throws EmpExcptionHandling
	{
		checkForDup(empId, emps);
		LocalDate joinDate1= parseAndValidateDate(joinDate);
		Dept parsedDept= parseAndValidateDept(deptName);
		
		//public Emp(String empId, String empFirtsName, String empLastName, Dept deptName, LocalDate joinDate, double salary)
		
		return new Emp(empId,FirstName,empLastName,parsedDept,joinDate1,salary);
	}
	
	
	
	
	//=================================== Date Validation
	
	public static LocalDate parseAndValidateDate(String date) throws EmpExcptionHandling
	{
		LocalDate joinDate =  LocalDate.parse(date);
		int differenceInYears = Period.between(joinDate, LocalDate.now()).getYears();
		if(differenceInYears > 3)
			throw new EmpExcptionHandling("Invalid join Date!!!!!!!!!!");
		return joinDate;		
	}
	//=================================== Dept enum Validation

	public static Dept parseAndValidateDept(String deptName) throws EmptyStackException{
		
		return Dept.valueOf(deptName.toUpperCase());
	}
	
	//==================================== Check for Dup
	
	public static void checkForDup(String empId, Map<String,Emp> emps) throws EmpExcptionHandling {
		
		if(emps.containsKey(empId))
			throw new EmpExcptionHandling("Duplication of emp!!!!!");	
	}
	
	//===================================  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// end 
