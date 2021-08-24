package employeepayrollservice;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import employeepayrollservice.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest {
	

	@Test
	public void given3EmployeesWhenWrittenToFileShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = { new EmployeePayrollData(1, "Krati Gupta", 400000.0),
				new EmployeePayrollData(2, "Nishu Tyagi", 500000.0), new EmployeePayrollData(3, "Vanshika", 600000.0) };

		EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
		
	}
}
