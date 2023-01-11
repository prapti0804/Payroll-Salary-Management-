package main;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.Department;
import model.Employee;

public class MenuHandler {
	final Scanner s = new Scanner(System.in);
	private List<Department> d;
	private List<Employee> l;

	public MenuHandler() {
		l = new LinkedList<>();
		d = new LinkedList<>();
		createDepartments();
	}

	public void handle() {
		int choice;
		do {
			System.out.println("1.Add Employee\n" + "2.Show All Employees \n" + "3.Delete Employee\n"
					+ "4.Calculate Salary\n" + "Other than above to exit\n");
			choice = Integer.parseInt(s.nextLine());
			switch (choice) {
			case 1:
				addEmployee();
				break;
			case 2:
				if (l.size() != 0) {
					showEmployees();
				} else {
					System.out.println("No Employee added please add first");
				}
				break;
			case 3:
				if (l.size() != 0) {
					deleteEmployee();
				} else {
					System.out.println("No Employee added please add first");
				}
				break;
			case 4:
				if (l.size() != 0) {
					System.out.println("Enter the employee ID from following: ");
					showEmployees();
					long id = Long.parseLong(s.nextLine());
					Optional<Employee> employee;
					do {
						employee = l.stream().filter(t -> t.getEmployeeId() == id).findFirst();
						if (!employee.isPresent()) {
							System.err.println("Please enter the valid department ID");
						}
						else {
							break;
						}
					} while (true);
					calculateSalary(employee.get());
				} else {
					System.out.println("No Employee added please add first");
				}
				break;
			default:
				System.err.println("You have entered wrong choice");
			}
		} while (true);
	}

	private void createDepartments() {
		d.add(new Department(101, "IT"));
		d.add(new Department(102, "Electronics"));
		d.add(new Department(103, "Account"));
		d.add(new Department(104, "HR"));
	}

	private long showDepartments() {
		long choice;
		System.out.println("______________________________");
		System.out.printf("%4s %20s\n", "ID", "Name");
		System.out.println("==============================");
		d.forEach(t -> {
			System.out.printf("%4d %20s\n", t.getDepartmentId(), t.getDepartmentName());
		});
		System.out.println("_______________________________");
		while (true) {
			long id = Integer.parseInt(s.nextLine());
			Optional<Department> findFirst = d.stream().filter(t -> t.getDepartmentId()==id).findFirst();
			if(id<=0 || !findFirst.isPresent() ) {
				System.err.println("Invalid ID \n Please select valid department id from above");
			}
			else {
				choice =id;
				break;
			}
		}
		return choice;
	}

	private void addEmployee() {
		Employee e = new Employee();
		e.setEmployeeId(System.currentTimeMillis());
		System.out.print("Enter the Name of the Employee:");
		e.setEmployeeName(s.nextLine());
		System.out.print("Enter the basic salary for : ");
		e.setBasicSalary(Double.parseDouble(s.nextLine()));
		System.out.print("Enter the designation: ");
		e.setDesignation(s.nextLine());
		System.out.println("Choose the department from following:");
		long id = showDepartments();
		Department dept = d.stream().filter(t -> t.getDepartmentId() == id).findFirst().get();
		e.setDepartment(dept);
		l.add(e);
		System.out.println("Employee Added");
	}
	private boolean containsDigit(String s) {
	    boolean containsDigit = false;

	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (containsDigit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }

	    return containsDigit;
	}
	private void showEmployees() {
		System.out.println(
				"__________________________________________________________________________________________________________");
		System.out.printf("%20s %20s %20s %20s %20s \n", "ID", "Name", "Designation", "Basic Salary", "Department");
		System.out.println(
				"==========================================================================================================");
		l.forEach(t -> {
			System.out.printf("%20d %20s %20s %20s %20s\n", t.getEmployeeId(), t.getEmployeeName(), t.getDesignation(),
					t.getBasicSalary(), t.getDepartment().getDepartmentName());
		});
		System.out.println(
				"__________________________________________________________________________________________________________");
	}

	private void calculateSalary(Employee e) {
		System.out.print("Enter the number of halfdays: ");
		int halfDays = Integer.parseInt(s.nextLine());
		System.out.print("Enter the number of overtime days: ");
		int overtime = Integer.parseInt(s.nextLine());
		System.out.print("Enter the number of holidays: ");
		int holidays = Integer.parseInt(s.nextLine());
		System.out.print("Enter the bonus amount: ");
		int bonus = Integer.parseInt(s.nextLine());
		e.setBonus(bonus);
		e.setOvertime((e.getBasicSalary() / 30) * overtime);
		e.setHolidays(holidays);
		e.setHalfDays(halfDays);
		double spd = e.getBasicSalary() / 30;
		double gs = e.getBasicSalary();
		gs = gs - ((e.getHalfDays()) * (spd / 2));
		gs = gs - (spd * holidays);
		gs = gs + (spd * overtime);
		gs = gs + bonus;
		e.setGrossSalary(gs);
		printSalarySlip(e);
	}

	private void printSalarySlip(Employee e) {
		double spd = e.getBasicSalary() / 30;
		System.out.println("Name: " + e.getEmployeeName());
		System.out.println("=================================================================================");
		System.out.printf("%-20s %30s\n", "Basic Salary", e.getBasicSalary());
		System.out.printf("%-20s +%30s\n", "Overtime", e.getOvertime());
		System.out.printf("%-20s +%30s\n", "Bonus", e.getBonus());
		System.out.printf("%-20s -%30s\n", "Halfdays", (e.getHalfDays() / 2) * spd);
		System.out.printf("%-20s -%30s\n", "Holidays", e.getHolidays() * spd);
		System.out.println("=================================================================================");
		System.out.printf("%-20s =%30s\n", "Gross salary", e.getGrossSalary());
	}

	private void deleteEmployee() {
		System.out.println("Enter the employee ID from following to delete employee: ");
		showEmployees();
		long id = Long.parseLong(s.nextLine());
		Optional<Employee> employee = l.stream().filter(t -> t.getEmployeeId() == id).findFirst();
		if (!employee.isPresent()) {
			System.err.println("Invalid Employee ID \n Employee deletion failed");
		} else {
			l.remove(employee.get());
			System.out.println("Employee Deleted Successfully");
		}
	}
}
