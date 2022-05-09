package EmployeePayrollService;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollIOServices {
    public static String payRollName = "payroll.txt";

    public void writeData(List<EmployeePayrollData> employeePayrollDataList) {
        StringBuffer employeeBuffer = new StringBuffer();
        employeePayrollDataList.forEach(employee -> {
            String employeeDataString = employee.toString().concat("\n");
            employeeBuffer.append(employeeDataString);
        });
        try {
            Files.write(Paths.get(payRollName), employeeBuffer.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entry = 0;
        try {
            entry = Files.lines(new File("payroll.txt").toPath()).count();
        } catch (IOException io) {
            io.printStackTrace();
        }
        return entry;
    }

    public void printPayroll() {
        try {
            Files.lines(new File("payroll.txt").toPath()).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> readDataFromFile() {
        List<String> employeePayrollList = new ArrayList<String>();

        try {
            Files.lines(new File("payroll.txt").toPath())
                    .map(employee -> employee.trim())
                    .forEach(employee -> {
                        System.out.println(employee);
                        employeePayrollList.add(employee);
                    });

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return employeePayrollList;
    }
}
