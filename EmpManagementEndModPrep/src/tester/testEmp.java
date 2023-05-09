package tester;

import static Utils.EmpUtils.populateEmpMap;
import static Utils.EmpValidationRules.parseAndValidateDept;
import static Utils.EmpValidationRules.validateAllinputs;
import static Utils.IoUtils.restoreEmpdetails;
import static Utils.IoUtils.storedEmpDetails;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Dept;
import com.app.core.Emp;

import CustionException.EmpExcptionHandling;
public class testEmp {

	public static void main(String[] args)  {
		
		try(Scanner sc = new Scanner(System.in))
		{
			
			Map<String,Emp> EmpMap= populateEmpMap();
			
//			// Serialization and Deserialization 
//				
//			System.out.println("Enter file name");
//			storedEmpDetails(sc.nextLine(), EmpMap);
//			System.out.println("Products stored!!! ");
//			
	
			System.out.println("Deserialization");
			System.out.println("Enter filename: ");
			restoreEmpdetails(sc.nextLine()).forEach((k,v) -> System.out.println(v));
			
				 
			
			
			boolean exit = false;
			System.out.println("1. Hire employee 2. Show Employee map 3. promote the emp 4. Delete emp details 5. Sort wrt joindate 0.Exit!!");
			
			while(!exit)
			{
				System.out.println("Enter choice: ");
				
				try {
					
					switch (sc.nextInt()) {
					
					case 1:                                // Hire new employee
						System.out.println("Enter: empId, empFirstName, empLastName, deptName, joinDate, salary)");
						Emp e = validateAllinputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), EmpMap);
						EmpMap.putIfAbsent(e.getEmpId(), e);
						System.out.println("Employee Added....!!");
						break;
						
					case 2:                                // Display all Employee Details
						// System.out.println("Displaying EmpMap: "+ EmpMap);
						EmpMap.values().stream().forEach(System.out::println);
						
						break;

					case 3:                                 // Promote an emp
						System.out.println("Enter empid & promoto to: ");
						String eid= sc.next();
						Dept dept= parseAndValidateDept(sc.next());
						if(EmpMap.containsKey(eid))
						{
							EmpMap.get(eid).setDeptName(dept);
						}
						
						break;
						
					case 4:                                    // Delete an emp from map
						System.out.println("Enter emp id: ");
						String empIddel =sc.next();
						if(EmpMap.containsKey(empIddel))
						{
							EmpMap.remove(empIddel);
							System.out.println("Emp with id: "+empIddel + " Removed!!!");
						}else
							System.out.println("Invalid id!!!!!!!!!");
						break;
						
					case 5:                         // 5. Sort emps as per join date n display the same.
					System.out.println("Sorted as per join date: ");
					EmpMap.values().stream()
					.sorted((e1,e2) -> e1.getJoinDate().compareTo(e2.getJoinDate())).forEach(System.out::println);
					
					case 0:
						System.out.println("Exiting the code...");
						exit=true;
						System.out.println("Entering Serialization: ");
						System.out.println("Enter file name");
						storedEmpDetails(sc.nextLine(), EmpMap);
						System.out.println("Products stored!!! ");
						break;
						
					default:
						System.out.println("Invalid Input !!!");
						break;
					}
					
					
					
				}catch (Exception e){
					e.printStackTrace();
					sc.nextLine();
				}
				
			}// end of while			
			
		}// sc.close()
 catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	}// end of main
}
