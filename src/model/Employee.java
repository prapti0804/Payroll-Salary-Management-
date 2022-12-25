package model;

public class Employee {
	private long employeeId;
	private String employeeName;
	private String designation;
	private double basicSalary;
	private double grossSalary;
	private double salary;
	private double bonus;
	private double overtime;
	private int halfDays;
	private int holidays;
	private Department department;
	
	
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getOvertime() {
		return overtime;
	}
	public void setOvertime(double overtime) {
		this.overtime += overtime;
	}
	public int getHalfDays() {
		return halfDays;
	}
	public void setHalfDays(int halfDays) {
		this.halfDays += halfDays;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public int getHolidays() {
		return holidays;
	}
	public void setHolidays(int holidays) {
		this.holidays = holidays;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	
}
