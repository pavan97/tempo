package com.annotation;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.connection.MyConnection;

public class DemoFetchData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = MyConnection.getMyConnection();
		String FIND_ALL_EMPLOYEES="select * from employee1";
		try {
			Statement st=con.createStatement();
			ResultSet set = st.executeQuery(FIND_ALL_EMPLOYEES);
			
			DatabaseMetaData metaData = con.getMetaData();
			System.out.println(metaData.getDatabaseProductName());
			
			ResultSetMetaData resultSetMetaData = set.getMetaData();
			
			System.out.println("no of col:-"+resultSetMetaData.getColumnCount());
			for (int i=1;i<=resultSetMetaData.getColumnCount();i++) {
				System.out.println(resultSetMetaData.getColumnLabel(i));
			}
			
//			while(set.next()) {
//				
//				int empId=set.getInt(1);
//				String name = set.getString(2);
//				int salary = set.getInt(3);
//				System.out.println(empId+"\t"+name+"\t"+salary);
//				set.updateInt(3, 15000);
//				set.updateRow();
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
