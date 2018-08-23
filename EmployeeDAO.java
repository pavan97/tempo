import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.MyConnection;
import com.pojo.Employee;

public class EmployeeDAO {

	public int addEmployee(Employee emp) {
	
	String INSERT_EMPLOYEE="insert into employee1 values(?,?,?)";
	int r=0;
	
	try {
		PreparedStatement ps= MyConnection.getMyConnection().prepareStatement(INSERT_EMPLOYEE);
		ps.setInt(1, emp.getEmpId());
		ps.setString(2, emp.getName());
		ps.setInt(3, emp.getSalary());
		r=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return r;
}
	
	public List<Employee> findAllEMployees(){
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = MyConnection.getMyConnection();
		String FIND_ALL_EMPLOYEES="select * from employee1";
		
		try {
			Statement st=con.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_EMPLOYEES);
			while(set.next()) {
				
				int empId=set.getInt(1);
				String name = set.getString(2);
				int salary = set.getInt(3);
				Employee emp = new Employee(empId, name, salary);
				
				employees.add(emp);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public Employee updateEmployee(int empId,Employee employee) {
		Employee emp=new Employee();
		String UPDATE_EMPLOYEE="update employee1 set salary=? where empId=?";
		PreparedStatement ps;
		try {
			ps = MyConnection.getMyConnection().prepareStatement(UPDATE_EMPLOYEE);
			ps.setInt(1, employee.getSalary());
			ps.setInt(2, empId);
			int rows=ps.executeUpdate();
			if (rows >0)
				emp = employee;
			System.out.println("number of rows updated:-"+rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	public Employee findEmployeeById(int empId) {
		Employee emp=new Employee();
		String FIND_BY_ID="select * from employee1 where empId=?";
		
		try {
			PreparedStatement ps=MyConnection.getMyConnection().prepareStatement(FIND_BY_ID);
			ps.setInt(1, empId);
			
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				emp=new Employee(set.getInt("empId"), set.getString("name"), set.getInt("salary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
}