package EmployeePayrollService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * @author sadanand Pandey
 * Creating Employee Payroll Service for employee
 *
 */
public class EmployeePayrollService {
    public enum IOServices {
        FILE_IO, CONSOLE_IO
    }

    public List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {
        employeePayrollList = new ArrayList<>();
    }

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList = employeePayrollList;
    }

    public static void main(String[] args) {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        Scanner scanner = new Scanner(System.in);
        employeePayrollService.readEmpPayrollData(scanner);
        employeePayrollService.writeEmpPayrollData(IOServices.FILE_IO);
        employeePayrollService.ioServicesCount(IOServices.FILE_IO);
        System.out.println(employeePayrollService.ioServicesCount(IOServices.FILE_IO));
        employeePayrollService.printPayroll(IOServices.FILE_IO);
        employeePayrollService.readDataFromFile(IOServices.FILE_IO);

    }

    public void printPayroll(IOServices ioServices) {
        if (ioServices.equals(IOServices.FILE_IO)) {
            new EmployeePayrollIOServices().printPayroll();
        }
    }

    private void readEmpPayrollData(Scanner scanner) {
        System.out.println("Enter employee id : ");
        String empId = scanner.next();
        System.out.println("Enter employee name :");
        String empName = scanner.next();
        System.out.println("Enter employee salary : ");
        double empSalary = scanner.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(empId, empName, empSalary));
    }

    private void writeEmpPayrollData(IOServices ioServices) {

        if (ioServices.equals(IOServices.CONSOLE_IO)) {
            System.out.println("Writing employee payroll on console : " + employeePayrollList);
        } else if (ioServices.equals(IOServices.FILE_IO)) {
            new EmployeePayrollIOServices().writeData(employeePayrollList);

        }
    }

    public long ioServicesCount(IOServices ioServices) {
        if (ioServices.equals(IOServices.FILE_IO)) {
            return new EmployeePayrollIOServices().countEntries();
        }
        return 0;
    }

    public long readDataFromFile(IOServices ioServices) {
        List<String> employeePayrollDataFromFile = new ArrayList<String>();
        if (ioServices.equals(IOServices.FILE_IO)) {
            System.out.println("-----------------------------------");
            System.out.println("Empyoyee details from payroll.txt :");
            System.out.println("------------------------------------");
            employeePayrollDataFromFile = new EmployeePayrollIOServices().readDataFromFile();
        }
        return employeePayrollDataFromFile.size();
    }
}
