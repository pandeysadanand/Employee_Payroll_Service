package com.bl.EmployeePayrollService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author sadanand Pandey
 * Creating Employee Payroll Service for employee
 *
 */
public class EmployeePayrollService {

	private List<EmployeePayrollData> employeePayrollList;

	// using constructor storing value in employeeList
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
		EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
		employeePayrollService.readEmployeePayrollData();
		employeePayrollService.writeEmployeePayrollData();
	}

	// in this method .. reading inputs from console
	private void readEmployeePayrollData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee id : ");
		int empId = scanner.nextInt();
		System.out.println("Enter employee name :");
		String empName = scanner.next();
		System.out.println("Enter employee salary : ");
		double empSalary = scanner.nextDouble();
		EmployeePayrollData employeePayrollData = new EmployeePayrollData(empId, empName, empSalary);
		employeePayrollList.add(employeePayrollData);
	}

	// writing outputs console
	private void writeEmployeePayrollData() {
		System.out.println("Writing employee payroll on console :\n " + employeePayrollList);
	}
}
