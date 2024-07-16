package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamUtilityProgram {

	public static void main(String[] args) {

		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, "Infosys", 11));
		companyList.add(new Company(2, "Syntel", 11));
		companyList.add(new Company(3, "Infogain", 12));
		companyList.add(new Company(4, "Cognizant", 14));
		List<Department> departmentList = new ArrayList<Department>();
		departmentList.add(new Department(11, "Sales and Marketing", 101));
		departmentList.add(new Department(12, "Product Development", 101));
		departmentList.add(new Department(13, "Account", 102));
		departmentList.add(new Department(14, "Product Development", 101));
		departmentList.add(new Department(15, "Product Development", 101));
		departmentList.add(new Department(16, "Account and Finance", 103));
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(101, "Mayur", "Developer", 50000));
		employeeList.add(new Employee(102, "Rohan", "Lead", 70000));
		employeeList.add(new Employee(103, "Sunil", "HR", 15000));
		employeeList.add(new Employee(104, "Sachin", "HR", 20000));
		employeeList.add(new Employee(105, "Rahul", "Developer", 40000));
		
		//Cheapest Employee of 'Developer' category
		Map<String, Optional<Employee>> groupByMinSalary = employeeList.stream()
				.filter(emp -> emp.getPosition().equalsIgnoreCase("Developer")).collect(Collectors.groupingBy(
						Employee::getPosition, Collectors.minBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("Employee of Developer category with lowest salary :" + (groupByMinSalary));
		
		//List od department belong to position developer with salary > 10000
		Map<String, List<Employee>> groupBySalary = employeeList.stream()
				.filter(emp -> emp.getPosition().equalsIgnoreCase("Developer") && emp.getSalary() > 10000)
				.collect(Collectors.groupingBy(Employee::getPosition));
		System.out.println("Employee of Developer category with salary greater than 10000: "+ groupBySalary);
		
		//Top 3 highest paid employees
		List<Employee> topPaidEmployees = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
		System.out.println("Top 3 highest paid employees: "+topPaidEmployees);
		
		//Total salary of developer category
		int totalSalary = employeeList.stream().filter(emp -> emp.getPosition().equalsIgnoreCase("Developer"))
				.collect(Collectors.summingInt(Employee::getSalary));
		System.out.println("Total sum of salary of Developer category: "+ totalSalary);
		
		//Department with most employees
		Map<String, Long> groupByCount = departmentList.stream()
				.collect(Collectors.groupingBy(Department::getName, Collectors.counting()));
		Optional<Map.Entry<String, Long>> maxDept = groupByCount.entrySet().stream()
				.max(Map.Entry.comparingByValue());
		if (maxDept.isPresent()) {
			System.out.println("Department with most employees " + maxDept.get().getKey() + " ("
					+ maxDept.get().getValue() + " employees)");
		} else {
			System.out.println("No record found");
		}
		
	}

}
