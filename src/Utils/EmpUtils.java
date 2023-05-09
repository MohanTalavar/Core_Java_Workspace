package Utils;

import static Utils.EmpValidationRules.validateAllinputs;

import java.util.HashMap;

import com.app.core.Emp;

import CustionException.EmpExcptionHandling;

public class EmpUtils {
	
	public static HashMap<String,Emp> populateEmpMap() {
		
		HashMap<String,Emp> empList= new HashMap<>();
		
		//public Emp(String empId, String empFirtsName, String empLastName, Dept deptName, LocalDate joinDate, double salary)
		try {
			empList.put("101", validateAllinputs("101", "Mohan", "Talavar", "RND", "2023-05-20", 10, empList) );
			empList.put("102", validateAllinputs("102", "Pranay", "Patil", "HR", "2023-01-20", 20, empList) );
			empList.put("103", validateAllinputs("103", "Tushar", "Pawar", "SALES", "2022-01-20", 30, empList) );
			empList.put("104", validateAllinputs("104", "Aahad", "Shail", "FINANCE", "2021-01-20", 40, empList) );
		} catch (EmpExcptionHandling e) {
			
			e.printStackTrace();
		}
		return empList;
		
	}

}
