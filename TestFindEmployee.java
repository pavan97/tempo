import java.util.ArrayList;
import java.util.List;

import com.pojo.Employee;

public class TestFindEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDAO dao= new EmployeeDAO();
		List<Employee> emps=dao.findAllEMployees();
		
		for (Employee employee:emps) {
			System.out.println(employee.getName());
		}
	}

}
