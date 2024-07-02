/**
 * This is the abstract class, Employee, that gives us the basic credentials of
 * an employee such as his first name, last name, and his Id number.
 * 
 * @author yuvan
 *
 */
public abstract class Employee {
	private static int next_employee_id = 0; // Stores the id number of the next employee
	private int current_employee_id; // This variable is assigned the id stored by the previous variable.
	private String first_name; // First name of the employee.
	private String last_name; // Last name of the employee.

	/**
	 * This is the constructor of the class. It takes in the first name and last
	 * name of the employee.
	 * 
	 * @param first_name
	 * @param last_name
	 */
	public Employee(String first_name, String last_name) {
		this.first_name = first_name;
		this.last_name = last_name;
		next_employee_id++;
		current_employee_id = next_employee_id;
	}

	/**
	 * This method helps us in setting the first name of the employee.
	 * 
	 * @param fname - The string having the first name.
	 */
	public void setfirstname(String fname) {
		first_name = fname;
	}

	/**
	 * This is the getter method that helps us to get the first name of an employee.
	 * 
	 * @return - The first name of an employee.
	 */
	public String getfirstname() {
		return first_name;
	}

	/**
	 * This method helps us in setting the last name of the employee.
	 * 
	 * @param fname - The string having the last name.
	 */

	public void setlastname(String lname) {
		last_name = lname;
	}

	/**
	 * This is the getter method that helps us to get the last name of an employee.
	 * 
	 * @return - The last name of an employee.
	 */
	public String getlastname() {
		return last_name;
	}

	/**
	 * This is the getter method that helps us to get the Id number of an employee.
	 * 
	 * @return - The id number of an employee.
	 */
	public int getEmployee_Id() {
		return current_employee_id;
	}

	/**
	 * This is the toString method that prints necessary details such as the full
	 * name and Id number of the employee.
	 */
	public String toString() {
		return "Id:" + current_employee_id + " - " + last_name + ", " + first_name;
	}

	/**
	 * This is the abstract method that should return the paycheck of an
	 * employee.This will be implemented in the sub classes.
	 * 
	 * @return
	 */
	public abstract float GetPaycheck();

}
