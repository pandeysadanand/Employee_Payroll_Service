package com.bl.EmployeePayrollService;

public class EmployeePayrollData {
	public int empId;
	public String empName;
	public double empSalary;

	public EmployeePayrollData(int empId2, String empName, double empSalary) {
		this.empId = empId2;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Id=" + empId + ", Name=" + empName + ", Salary=" + empSalary;
	}
}
