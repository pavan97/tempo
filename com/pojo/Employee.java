package com.pojo;

public class Employee {

	private int empId,salary;
	private String name;
	public Employee(int empId,String name, int salary ) {
		super();
		this.empId = empId;
		this.salary = salary;
		this.name = name;
	}
	public Employee() {
		super();
		empId =1;
		salary=10000;
		name="citi";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
