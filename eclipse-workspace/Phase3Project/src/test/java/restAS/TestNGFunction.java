package restAS;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGFunction extends EndToEndTest {

	
	
		@Test
		public void test1() {
			
			System.out.println("Get All Employees");
			response = GetAllEmployee();
			Assert.assertEquals(200, response.getStatusCode());
			
			System.out.println("Get Single Employee");
			
			response=GetSingleEmp(2);
			Assert.assertEquals(200, response.getStatusCode());
			System.out.println("Create new Employee");
			
			
			response=CreateEmp("Harsh" , "5000");
			Assert.assertEquals(201, response.getStatusCode());
			
			System.out.println("Update Employee");
			
			response=UpdateEmp(5,"Sam" , "7000");
			Assert.assertEquals(200, response.getStatusCode());
			
			
			System.out.println("Delete Employee");
			response=DeleteEmp(3);
			Assert.assertEquals(200, response.getStatusCode());
			System.out.println("Validate statuscode for created employee");
			response=GetSingleEmp(25);
			Assert.assertEquals(404, response.getStatusCode());
			
			System.out.println("Validate Deleted Employee");
			response=GetAllEmployee();
		}
	}

