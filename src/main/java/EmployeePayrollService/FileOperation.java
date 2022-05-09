package EmployeePayrollService;

import java.io.File;
import java.io.FileOutputStream;

public class FileOperation {

	public static void main(String[] args) {
		String data = "2 tourists drown in sea in Bengal as Cyclone Asani intensifies into severe cyclonic storm";
		try {
			FileOutputStream newFileOutputStream = new FileOutputStream("test.txt");
			byte[] array = data.getBytes();
			newFileOutputStream.write(array);
			newFileOutputStream.close();
			
			File file = new File("test.txt");
			boolean b = file.delete();
			if(b) {
				System.out.println("File is deleted");
			}
			else {
				System.out.println("file not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
