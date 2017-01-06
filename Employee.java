package EmployeeSort2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private String name;
	private Employee left;
	private Employee right;

	public Employee(String name) {
		this.setName(name);
	}

	public Employee getLeft() {
		return left;
	}

	public void setLeft(Employee left) {
		this.left = left;
	}

	public Employee getRight() {
		return right;
	}

	public void setRight(Employee right) {
		this.right = right;
	}

	public void addSubordinate(Employee subordinate) {
		if (left == null) {
			left = subordinate;
		} else if (right == null) {
			right = subordinate;
		} else {
			//throw exception
		}		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getSubordinates() {
		List<Employee> subordinates = new ArrayList<Employee>();

		if (left != null) {
			subordinates.add(left);
		}
		
		if (right != null) {
			subordinates.add(right);
		}

		return subordinates;
	}

	public boolean hasSubordinateNamed(String name) {
		boolean result = false;
		
		if ((left != null && name.equals(left.getName()) || (right != null && name.equals(right.getName())))) {
			result = true;
		}
		
		return result;
	}

	public EmployeeDepth findLowestManager(int depth) {
		EmployeeDepth result = null;
		
		if ((!left.isManager()) && (!right.isManager())) {
			result = new EmployeeDepth (this, depth);
		} else if (!left.isManager() && right.isManager()) {
			result = right.findLowestManager(depth+1);
		} else if (left.isManager() && !right.isManager()) {
			result = left.findLowestManager(depth+1);
		} else {
			EmployeeDepth d1 = left.findLowestManager(depth+1);
			EmployeeDepth d2 = right.findLowestManager(depth+1);
			
			if (d2.getDepth() > d1.getDepth()) {
				result = d2;
			} else {
				result = d1;
			}
		}
		
		return result;
	}

	private boolean isManager() {
		return (left != null && right != null);
	}

	public EmployeeDepth findLowestEmployee(int depth) {
		if (left == null || right == null) {
			return new EmployeeDepth (this, depth);
		} else {
			EmployeeDepth d1 = left.findLowestEmployee(depth+1);
			EmployeeDepth d2 = right.findLowestEmployee(depth+1);
			
			if (d2.getDepth() > d1.getDepth()) {
				return d2;
			} else {
				return d1;
			}
			
		}
	}

}
