/**
 * This class calculates the paycheck of an employee on the basis of commissions
 * (the number of units he sold), which is then added to his base pay.
 * 
 * @author yuvan
 *
 */
public class CommissionedEmployee extends SalariedEmployee {
	private int units; // This variable stores the number of units sold.
	private float commission_schedule[][]; // This is the commission schedule for an employee.

	/**
	 * This is the constructor of the class. It takes in the first name,last name
	 * and the commission schedule of an employee (in the form of a 2D array)
	 * 
	 * @param firstname
	 * @param lastname
	 * @param commission_schedule
	 * @param yearly_pay
	 */
	public CommissionedEmployee(String firstname, String lastname, float[][] commission_schedule, float yearly_pay) {
		super(firstname, lastname, yearly_pay);
		this.commission_schedule = commission_schedule;
	}

	/**
	 * This method helps us in setting the number the units an employee sold.
	 * 
	 * @param units - The number of units he sold.
	 */
	public void setunits(int units) {
		this.units = units;
	}

	/**
	 * This method helps us in setting the commission schedule of an employee.
	 * 
	 * @param commission_schedule - The schedule in the form of a 2D array.
	 */
	public void setcommission(float[][] commission_schedule) {
		this.commission_schedule = commission_schedule;
	}

	/**
	 * This is the getter method that helps us to get the number of units an
	 * employee sold.
	 * 
	 * @return - The number of units sold.
	 */
	public int getunits() {
		return units;
	}

	/**
	 * This is the getter method that helps us to get the commission schedule of an
	 * employee.
	 * 
	 * @return - The commission schedule.
	 */
	public float[][] getcommission() {
		return commission_schedule;
	}

	/**
	 * This is the getter method that helps us to get the paycheck of the employee
	 * which is the sum of the money earned from selling those units and the salary.
	 */
	public float GetPaycheck() {
		float valuegpa = 0.0f;
		for (int i = 0; i < commission_schedule.length; i++) {

			if (units >= commission_schedule[i][0]) {
				valuegpa = commission_schedule[i][1];

			}
		}
		return units * valuegpa + super.getsalary();
	}

	/**
	 * This is the toString method which prints all necessary details such as the
	 * salary and the full name of the employee.
	 */
	public String toString() {
		return "Commission : " + "Base : " + super.getsalary() + ";" + super.superToString();

	}
}
