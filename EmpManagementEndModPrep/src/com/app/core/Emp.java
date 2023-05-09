package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;
 

public class Emp implements Serializable{
	
	private String empId;
	private String empFirtsName;
	private String empLastName;
	private Dept deptName;
	private LocalDate joinDate;
	private double salary;
	
	//                                    Para const
	public Emp(String empId, String empFirstName, String empLastName, Dept deptName, LocalDate joinDate, double salary) {
		super();
		this.empId = empId;
		this.empFirtsName = empFirstName;
		this.empLastName = empLastName;
		this.deptName = deptName;
		this.joinDate = joinDate;
		this.salary = salary;
	}
	// end of para cons
	
	// Pk para Not Required!!!!!
//	
//	public Emp(String empId) {
//		this.empId = empId;
//	}
//	

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Dept getDeptName() {
		return deptName;
	}

	public void setDeptName(Dept deptName) {
		this.deptName = deptName;
	}

	public String getEmpId() {
		return empId;
	}

	@Override                            // toString
	public String toString() {
		return "Emp [empId=" + empId + ", empFirtsName=" + empFirtsName + ", empLastName=" + empLastName + ", dept="
				+ deptName + ", joinDate=" + joinDate + ", salary=" + salary + "]";
	}
	
	
	
	

}
