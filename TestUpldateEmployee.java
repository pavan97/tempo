import com.pojo.Employee;

public class TestUpldateEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int id_update = 12;
		Employee emp=new Employee(0,"citi",8900);
		
		EmployeeDAO dao=new EmployeeDAO();
		Employee emp_updated=dao.updateEmployee(id_update, emp);
		System.out.println(emp_updated.getName()+":::"+emp_updated.getSalary());
	}
}
