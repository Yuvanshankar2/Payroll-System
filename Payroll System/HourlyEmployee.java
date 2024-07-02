/**
 * This class helps us get the paycheck of an employee who gets paid hourly.
 * 
 * @author yuvan
 *
 */
public class HourlyEmployee extends Employee {
	private int hours; // This variable stores the number of hours an employee works.
	private float payrate; // This variable stores the hourly rate of pay for an employee.

	/**
	 * This is the constructor of the class. It takes in the employee's first name,
	 * and last name along with the rate of pay per hour as parameters.
	 * 
	 * @param first_name
	 * @param last_name
	 * @param payrate
	 */
	public HourlyEmployee(String first_name, String last_name, float payrate) {
		super(first_name, last_name);
		this.payrate = payrate;
	}

	/**
	 * This is the getter method that helps us get the paycheck of the employee
	 */
	public float GetPaycheck() {
		return hours * payrate;
	}

	/**
	 * This method helps us in setting the number of hours that an employee works.
	 * 
	 * @param hours - The number of hours an employee has worked.
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * This method helps us in setting the rate of pay per hour an employee works.
	 * 
	 * @param payrate - The hourly rate of pay that an employee receives.
	 */
	public void setpayrate(float payrate) {
		this.payrate = payrate;
	}

	/**
	 * This is the getter method that helps us get the number of hours an employee
	 * has worked
	 * 
	 * @return - The number of hours an employee has worked.
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * This is the getter method that helps us get the payrate.
	 * 
	 * @return - The hourly rate of pay.
	 */
	public float get_payrate() {
		return payrate;
	}

	/**
	 * This is the toString method that prints necessary details such as the hourly
	 * rate of pay and the full name of the employee.
	 */

	public String toString() {
		return "Hourly: " + payrate + "; " + super.toString();
	}

}
