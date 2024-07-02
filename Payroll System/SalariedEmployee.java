/**
 * This class helps us get the paycheck, usually given 26 times a year.It also
 * prints necessary details such as the annual income,and the employee's name.
 * 
 * @author yuvan
 *
 */
public class SalariedEmployee extends Employee {

	protected float yearly_pay; // This stores the annual income of an employee.

	/**
	 * This is the constructor of the class. It takes in the first name,last name,
	 * and the annual income of the employee as parameters.
	 * 
	 * @param first_name
	 * @param last_name
	 * @param annual_income
	 */
	public SalariedEmployee(String first_name, String last_name, float annual_income) {
		super(first_name, last_name);
		yearly_pay = annual_income;
	}

	/**
	 * This is the getter method that helps us get the paycheck (given 26 times a
	 * year). It can obtained by dividing the salary by 26.
	 */
	public float GetPaycheck() {
		return yearly_pay / 26.0f;
	}

	/**
	 * This method helps us set the salary for an employee.
	 * 
	 * @param yearly_pay
	 */
	public void setsalary(float yearly_pay) {
		this.yearly_pay = yearly_pay;
	}

	/**
	 * This is the getter method that helps us get the salary of an employee.
	 * 
	 * @return
	 */
	public float getsalary() {
		return yearly_pay;
	}

	/**
	 * This is the toString method that prints details such as the salary and name
	 * of the employee.
	 */
	public String toString() {
		return "Salaried, " + "Base : " + yearly_pay + "; " + super.toString();
	}

	public String superToString() {
		return super.toString();
	}
}
