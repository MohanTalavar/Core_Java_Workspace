package tester;

import static Utils.EmpValidationRules.parseAndValidateDept;
import static Utils.EmpValidationRules.validateAllinputs;
import static Utils.IoUtils.*;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Dept;
import com.app.core.Emp;

public class testEmp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			// Map<String,Emp> EmpMap= populateEmpMap();
		
			System.out.println("Deserialization");
			System.out.println("Enter filename: ");
			String filename = sc.nextLine();
			Map<String, Emp> EmpMap = restoreEmpdetails1(filename);
			System.out.println("Restored Map " + EmpMap);

			// Empmap2= populateEmpMap();

			boolean exit = false;
			System.out.println(
					"1. Hire employee 2. Show Employee map 3. promote the emp 4. Delete emp details 5. Sort wrt joindate 0.Exit!!");

			while (!exit) {
				System.out.println("Enter choice: ");

				try {

					switch (sc.nextInt()) {

					case 1: // Hire new employee
						System.out.println("Enter: empId, empFirstName, empLastName, deptName, joinDate, salary)");
						Emp e = validateAllinputs(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(),
								sc.nextDouble(), EmpMap);
						EmpMap.putIfAbsent(e.getEmpId(), e);
						System.out.println("Employee Added....!!");
						break;

					case 2: // Display all Employee Details
						// System.out.println("Displaying EmpMap: "+ EmpMap);
						EmpMap.values().stream().forEach(System.out::println);

						break;

					case 3: // Promote an emp
						System.out.println("Enter empid & promoto to: ");
						String eid = sc.next();
						Dept dept = parseAndValidateDept(sc.next());
						if (EmpMap.containsKey(eid)) {
							EmpMap.get(eid).setDeptName(dept);
						}

						break;

					case 4: // Delete an emp from map
						System.out.println("Enter emp id: ");
						String empIddel = sc.next();
						if (EmpMap.containsKey(empIddel)) {
							EmpMap.remove(empIddel);
							System.out.println("Emp with id: " + empIddel + " Removed!!!");
						} else
							System.out.println("Invalid id!!!!!!!!!");
						break;

					case 5: // 5. Sort emps as per join date n display the same.
						System.out.println("Sorted as per join date: ");
						EmpMap.values().stream().sorted((a, b) -> a.getJoinDate().compareTo(b.getJoinDate()))
								.forEach(System.out::println);
						break;

					case 0:
						System.out.println("Exiting the code...");
						exit = true;
						System.out.println("Entering Serialization: ");
						storedEmpDetails(filename, EmpMap);
						System.out.println("Products stored!!! ");

						break;

					default:
						System.out.println("Invalid Input !!!");
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}

			} // end of while

		} // sc.close()

	}// end of main
}
