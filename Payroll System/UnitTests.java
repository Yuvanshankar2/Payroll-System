import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This unit test code tests all the classes that were written concerning the
 * employee
 * 
 * @author Yuvanshankar Mahesh
 * 
 */
public class UnitTests {
	/**
	 * Tests the implementations related to the SalariedEmployee class.
	 * 
	 * @throws Exception if an error occurs
	 */
	@Test
	public void test1() throws Exception {
		SalariedEmployee emp = new SalariedEmployee("Yuvanshankar", "Mahesh", 200000);
		assertEquals("Yuvanshankar", emp.getfirstname());
		assertEquals("Mahesh", emp.getlastname());
		assertEquals(1, emp.getEmployee_Id());
		assertEquals(200000.0f, emp.getsalary(), 0.001);
		assertEquals(200000.0f / 26, emp.GetPaycheck(), 0.001);
		emp.setfirstname("Rohit");
		emp.setlastname("Khali");
		emp.setsalary(30000.0f);
		assertEquals("Rohit", emp.getfirstname());
		assertEquals("Khali", emp.getlastname());
		assertEquals(1, emp.getEmployee_Id());
		assertEquals(30000.0f, emp.getsalary(), 0.001);
		assertEquals(30000.0f / 26, emp.GetPaycheck(), 0.001);
		SalariedEmployee emp1 = new SalariedEmployee("Virat", "Kohli", 1000);
		assertEquals(2, emp1.getEmployee_Id());
		assertEquals("Salaried, Base : 1000.0; Id:2 - Kohli, Virat", emp1.toString());

	}

	/**
	 * Tests the implementations related to the HourlyEmployee class.
	 * 
	 * @throws Exception if an error occurs
	 */

	@Test
	public void test2() throws Exception {
		HourlyEmployee emp2 = new HourlyEmployee("Cristiano", "Ronaldo", 15.25f);
		assertEquals("Cristiano", emp2.getfirstname());
		assertEquals("Ronaldo", emp2.getlastname());
		assertEquals(3, emp2.getEmployee_Id());
		assertEquals(15.25f, emp2.get_payrate(), 0.001);
		emp2.setHours(30);
		assertEquals(30, emp2.getHours());
		assertEquals(457.5f, emp2.GetPaycheck(), 0.001);
		emp2.setpayrate(12.2f);
		assertEquals(366.0f, emp2.GetPaycheck(), 0.001);
		assertEquals("Hourly: 12.2; Id:3 - Ronaldo, Cristiano", emp2.toString());
		HourlyEmployee emp3 = new HourlyEmployee("Lionel", "Messi", 10.3f);
		assertEquals("Hourly: 10.3; Id:4 - Messi, Lionel", emp3.toString());
		emp3.setHours(5);
		assertEquals(51.5f, emp3.GetPaycheck(), 0.001);
	}

	/**
	 * Tests the implementations related to the CommissionedEmployee class.
	 * 
	 * @throws Exception if an error occurs
	 */
	@Test
	public void test3() throws Exception {
		float commission_schedule[][] = { { 20.0f, 3.2f } };
		CommissionedEmployee emp4 = new CommissionedEmployee("Neymar", "Jr", commission_schedule, 20000.0f);
		assertEquals("Neymar", emp4.getfirstname());
		assertEquals("Jr", emp4.getlastname());
		emp4.setunits(50);
		assertEquals(50, emp4.getunits());
		assertEquals(20000.0f, emp4.getsalary(), 0.001);
		emp4.setcommission(commission_schedule);
		assertEquals(20160.0f, emp4.GetPaycheck(), 0.001);
		assertEquals(5, emp4.getEmployee_Id());
		assertEquals("Commission : Base : 20000.0;Id:5 - Jr,Neymar", emp4.toString());

	}

}
