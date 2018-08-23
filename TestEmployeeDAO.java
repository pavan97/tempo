import java.util.Scanner;

import com.pojo.Employee;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		System.out.println("enter empID:-");
		int eid=sc.nextInt();
		String ename=sc.next();
		int esalary = sc.nextInt();
		Employee myEmployee = new Employee(eid,ename,esalary);
		EmployeeDAO dao=new EmployeeDAO();
		
		int rows = dao.addEmployee(myEmployee);
		if(rows>0)
			System.out.println("print successful");
		else
			System.out.println("sorry");
	
	}

}
