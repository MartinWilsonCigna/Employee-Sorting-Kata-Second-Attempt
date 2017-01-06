package EmployeeSort2;

public class EmployeeDepth {
	private Employee employee;
	private int depth;
	
	public EmployeeDepth(Employee employee, int depth) {
		this.employee = employee;
		this.depth = depth;
	}

	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}

}
