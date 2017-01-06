package EmployeeSort2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Staff {
	private List<Employee> unsortedEmployees = new ArrayList<Employee>();
	private Employee root;

	public Staff(String testInput) {
		Scanner scanner = new Scanner(testInput);

		// First line is the number of lines in the input. I don't care what this is.
		scanner.nextLine();
		unsortedEmployees.add(new Employee(scanner.nextLine()));
		unsortedEmployees.add(new Employee(scanner.nextLine()));
		
		while (scanner.hasNext()) {
			String[] namePair = scanner.nextLine().split(" ");
			Employee manager = addOrCreateEmployee(namePair[0]);
			Employee subordinate = addOrCreateEmployee(namePair[1]);
			
			manager.addSubordinate(subordinate);
		}
		
		scanner.close();
		
		findRoot();
	}

	private void findRoot() {
		for (int i = 0; root == null && i < unsortedEmployees.size(); i++) {
			if (hasNoBoss(unsortedEmployees.get(i))) {
				root = unsortedEmployees.get(i);
			}
		}
	}

	private boolean hasNoBoss(Employee employee) {
		boolean result = true;
		
		for (int i = 0; result && i < unsortedEmployees.size(); i++) {
			if (unsortedEmployees.get(i).hasSubordinateNamed(employee.getName())) {
				result = false;
			}
		}
		
		return result;
	}

	private Employee addOrCreateEmployee(String name) {
		Employee employee = new Employee(name);
		boolean existingEmployee = false;
		
		for (int i = 0; !existingEmployee && i < unsortedEmployees.size(); i++) {
			if (unsortedEmployees.get(i).getName().equals(name)) {
				employee = unsortedEmployees.get(i);
				existingEmployee = true;
			}
		}
		
		if (!existingEmployee) {
			unsortedEmployees.add(employee);
		}
		
		return employee;
	}

	public boolean contains(String name) {
		boolean result = false;
		for (int i = 0; !result && i < unsortedEmployees.size(); i++) {
			result = unsortedEmployees.get(i).getName().equals(name);
		}
		return result;
	}

	public String findSubordinates(String name) {
		List<Employee> subordinates = getEmployeeByName(name).getSubordinates();
		String result = "";
		for (int i = 0; i < subordinates.size(); i++) {
			if (i > 0) {
				result = result + " ";
			}
			result = result + subordinates.get(i).getName();
		}
		return result;
	}

	private Employee getEmployeeByName(String name) {
		Employee result = null;
		for (int i = 0; result == null && i < unsortedEmployees.size(); i++) {
			if (name.equals(unsortedEmployees.get(i).getName())) {
				result = unsortedEmployees.get(i);
			}
		}
		return result;
	}

	public Employee getRoot() {
		return root;
	}
	

	public Employee findLowestManager() {
		return root.findLowestManager(0).getEmployee();
	}
	
	public Employee findLowestEmployee() {
		return root.findLowestEmployee(0).getEmployee();
	}
}
