package EmployeePayrollService;

import java.io.File;

public class FileUtil {

	public static boolean deleteFile( File containToDelete) {
		File[] contain = containToDelete.listFiles();
		if(contain != null) {
			for(File file : contain) {
				deleteFile(file);
			}
			}
	
	return containToDelete.delete();
	}
}
