import java.util.Scanner;

/*
 * Welcome to the payroll class. In this class, we can perform operations such as creating an array of employees, displaying certain credentials
 * of certain employees by adding in particular forms of identity(name,id).
 */
public class Payroll {

	private Employee[] emp;
	private int index = 0;
	private Employee emp1;
	Scanner sc = new Scanner(System.in);

	/*
	 * This is the constructor of the class which just initializes the array we are
	 * building. In this case, we will deal with at most a 100 employees.
	 */
	public Payroll() {
		emp = new Employee[100];
	}

	/*
	 * This is a helper method that I made which stores 5 default employee objects
	 * in the array. This helped me save time debugging the code when I was dealing
	 * with errors.
	 */
	public void testCase() {
		emp[0] = new HourlyEmployee("Lionel", "Messi", 20.0f);
		emp[1] = new HourlyEmployee("Cristiano", "Ronaldo", 30.0f);
		emp[2] = new HourlyEmployee("Neymar", "Jr", 40.0f);
		emp[3] = new HourlyEmployee("Sergio", "Ramos", 50.0f);
		emp[4] = new HourlyEmployee("Manuel", "Neur", 60.0f);
		index = 5;
	}

	/*
	 * This is a helper method which prints all the default employee objects that I
	 * had stored in the above array. It serves the same debugging purpose.
	 */
	public void printName() {
		for (int i = 0; i <= index - 1; i++) {
			System.out.println(emp[i]);
		}
	}
	/*
	 * 
	*/

	public static void printEmploees(Employee[] emps, int left, int right) {
		for (int i = left; i <= right; i++) {
			System.out.println(emps[i]);
		}
	}

	/*
	 * This is a helper method which tests if the name entered (in this program we
	 * enter the first and last names of an employee) is valid . If any of the
	 * name's characters do not belong in the domain of legal values that I set up,
	 * it is an invalid name and must be typed again
	 */
	public boolean isValidName(String name) {
		String domain = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz -";
		char ch;
		for (int i = 0; i < name.length(); i++) {
			ch = name.charAt(i);
			if (domain.indexOf(ch) == -1) {
				return false;
			}

		}
		return true;

	}

	/*
	 * This method helps us create an employee of any type(hourly, salaried, or
	 * commissioned)and adds it to the array of employees which we will use for
	 * further operations.
	 */
	public void createEmployee() {
		Scanner sc = new Scanner(System.in);
		String domain = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz -";
		String firstname;
		String lastname;
		do {
			System.out.println("Enter your first name");
			firstname = sc.next();
		} while (!isValidName(firstname));
		if (firstname.equals("q")) {
			return;
		}
		do {
			System.out.println("Enter your last name");
			lastname = sc.next();
		} while (!isValidName(lastname));

		if (lastname.equals("q")) {
			return;
		}
		System.out.println("Choose an employee type" + "1. Salaried Employee (S)" + "2. Hourly Employee (H)"
				+ "3. Commissioned Employee (C)");
		String type = sc.next();
		char ch2 = type.charAt(0);
		switch (ch2) {
		case 'S': {
			System.out.print("What is your yearly salary?");
			float yearly = sc.nextFloat();
			emp1 = new SalariedEmployee(firstname, lastname, yearly);
			break;
		}
		case 'H': {
			System.out.print("What is your payrate?");
			float pay = sc.nextFloat();
			emp1 = new HourlyEmployee(firstname, lastname, pay);
			break;
		}
		case 'C': {
			System.out.print("What is your yearly base pay?");
			float base = sc.nextFloat();
			System.out.println("Enter your commission schedule");
			System.out.println("Enter the number of rows for your schedule");
			int numentries = sc.nextInt();
			float[][] commission = new float[numentries][2];
			emp1 = new CommissionedEmployee(firstname, lastname, commission, base);
			String units;
			String value;
			for (int b = 0; b < numentries; b++) {
				System.out.print("Enter the number of units:");
				units = sc.next();
				int number_units = Integer.parseInt(units);
				commission[b][0] = number_units;
				System.out.println("Enter the value per units");
				value = sc.next();
				int num_values = Integer.parseInt(value);
				commission[b][1] = num_values;

			}
			break;
		}
		default: {
			System.out.println("You have entered an invalid option.");
			break;
		}
		}

		emp[index] = emp1;
		index++;
	}

	/*
	 * This method performs the quicksort algorithm for names.
	 */
	public static void quicksort(Employee[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		Employee pivot = a[right];
		int leftindex = left;
		int rightindex = right;
		while (leftindex < rightindex) {
			while (compareNames(a[leftindex], pivot) <= 0 && leftindex < rightindex) {
				leftindex++;
			}
			while (compareNames(a[rightindex], pivot) >= 0 && leftindex < rightindex) {
				rightindex--;
			}
			swap(a, leftindex, rightindex);

		}
		swap(a, leftindex, right);
		quicksort(a, left, leftindex - 1);
		quicksort(a, leftindex + 1, right);
	}

	/*
	 * This is a helper method for the above quicksort algorithm. This compares
	 * names lexicographically and returns the difference in order between two
	 * strings. if -1 : The name entered is lexicographically lesser than the second
	 * name. if 1: The name entered is lexicographically greater than the second
	 * name.
	 */
	public static int compareNames(Employee emp1, Employee emp2) {
		if (emp1.getlastname().compareTo(emp2.getlastname()) < 0) {
			return -1;
		} else if (emp1.getlastname().compareTo(emp2.getlastname()) > 0) {
			return 1;
		} else {
			if (emp1.getfirstname().compareTo(emp2.getfirstname()) < 0) {
				return -1;
			} else if (emp1.getfirstname().compareTo(emp2.getfirstname()) > 0) {
				return 1;
			} else
				return 0;
		}
	}

	/*
	 * This is a helper method which helps us swap two values in an array if we know
	 * their positions (index).
	 * 
	 */
	public static void swap(Employee[] a, int index1, int index2) {
		Employee temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;

	}

	/*
	 * This method helps us attain the details of the employee that we are searching
	 * for, which we do by typing in the last name of the employee whose details we
	 * interested in.
	 */
	public void searchname() {
		System.out.println("Enter your last name");
		String lastname = sc.next();
		while (!isValidName(lastname)) {
			System.out.println("Enter the last name");
			lastname = sc.next();
		}

		int left = 0;
		int right = index - 1;
		quicksort(emp, left, right);
		for (int i = 0; i <= index - 1; i++) {
			if (lastname.equals(emp[i].getlastname())) {
				System.out.print(emp[i].getfirstname() + " " + emp[i].getlastname() + " " + emp[i].getEmployee_Id());
				System.out.println();
			}
		}

	}

	/*
	 * This is a helper method that performs the quicksort algorithm. Unlike the
	 * previous one, this one arranges the employees in order of their employee ids.
	 */
	public static void quicksort1(Employee[] a, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivot = a[right].getEmployee_Id();
		int leftindex = left;
		int rightindex = right;
		while (leftindex < rightindex) {
			while (a[leftindex].getEmployee_Id() <= pivot && leftindex < rightindex) {
				leftindex++;
			}
			while (a[rightindex].getEmployee_Id() >= pivot && leftindex < rightindex) {
				rightindex--;
			}
			swap(a, leftindex, rightindex);

		}

		swap(a, leftindex, right);
		quicksort1(a, left, leftindex - 1);
		quicksort1(a, leftindex + 1, right);
	}

	/*
	 * This is a helper method that performs the binary search method after the
	 * array of employees is sorted.
	 */
	public static int binaryhelper(Employee[] a, int lower, int upper, int x) {
		if (lower > upper)
			return -1;
		int middle = (lower + upper) / 2;
		if (x == a[middle].getEmployee_Id()) {
			return middle;
		}
		if (x > a[middle].getEmployee_Id())
			return binaryhelper(a, middle + 1, upper, x);

		else
			return binaryhelper(a, lower, middle - 1, x);
	}

	/*
	 * This is a helper method that performs the quicksort and binary search that I
	 * made one after the other. The result will give us the location of the item we
	 * want.
	 */
	public static int binarySearch(Employee[] a, int lower, int upper, int x) {

		quicksort1(a, lower, upper);
		return binaryhelper(a, lower, upper, x);
	}

	/*
	 * This method displays the details of an employee we want to find simply by
	 * typing in his employee number.
	 */
	public void displayName() {
		System.out.print("Enter an employee number: ");
		int empNumber = sc.nextInt();
		int left = 0;
		int right = index - 1;
		int location = binarySearch(emp, left, right, empNumber);
		System.out.println(emp[location].toString());
	}

	/*
	 * This is a helper method which performs the selection sort algorithm. This
	 * method arranges the employees in order of the highest paycheck (highest to
	 * lowest).
	 */
	public void selectionSort(Employee[] a) {
		for (int i = 0; i <= index - 1; i++) {
			int largest = i;
			for (int j = i + 1; j <= index - 1; j++) {
				if (a[j].GetPaycheck() > a[largest].GetPaycheck())
					largest = j;

			}
			if (!a[largest].equals(a[i])) {
				Employee temp = a[i];
				a[i] = a[largest];
				a[largest] = temp;
			}
			System.out.println(a[i].getfirstname() + " " + a[i].getlastname() + "         "
					+ String.format("%.2f", a[i].GetPaycheck()));
		}

	}

	/*
	 * This is a helper method that allows us to enter a quantity of something(hours
	 * and units in this case) and asks us if we want to continue or not IF we press
	 * q for the quantity. If we want to quit, it will take us to the main menu,
	 * else it will allow us to continue.
	 */
	public int StringtoInteger(String type) {
		int value = -3;
		do {
			System.out.println("Enter the number of" + type);
			String quantity = sc.next();
			if (quantity.equals("q")) {
				System.out.println(
						"If you quit here, you will lose all the values you have entered so far. If you want to quit, type Y, else N");
				char ch = sc.next().charAt(0);
				switch (ch) {
				case 'Y':
					value = -1;
					break;
				case 'N': {
					value = 0;
				}
				}
			} else
				value = Integer.parseInt(quantity);
		} while (value == 0);

		return value;
	}

	/*
	 * This method helps us print the names and paychecks of all the employees that
	 * we have collected in the array so far. It asks us to enter certain values of
	 * input based on the type of employee we have collected.
	 */
	public void runPayroll() {
		for (int i = 0; i <= index - 1; i++) {
			if (emp[i] instanceof HourlyEmployee) {
				int numHours = StringtoInteger("hours");
				if (numHours == -1)
					return;
				else
					((HourlyEmployee) emp[i]).setHours(numHours);
			} else if (emp[i] instanceof CommissionedEmployee) {
				int numunits = StringtoInteger("units");
				if (numunits == -1)
					return;
				else
					((CommissionedEmployee) emp[i]).setunits(numunits);
			} else
				System.out.println("No questions to be asked ");
		}
		selectionSort(emp);
	}

	/*
	 * This is the main method which provides for us a menu of possible operations
	 * we can perform in this class.
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Payroll payroll = new Payroll();
		int ch;
		do {
			System.out.println("1)	Create an employee\r\n" + "2)	Search for an employee by last name\r\n"
					+ "3)	Display an employee by employee number\r\n" + "4)	Run payroll\r\n" + "5)	Quit\r\n");
			System.out.println("Enter an option for what operation you would like to perform ");
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				payroll.createEmployee();
				break;
			}
			case 2: {

				payroll.searchname();
				break;
			}
			case 3: {
				payroll.displayName();
				break;
			}
			case 4: {
				payroll.runPayroll();
				break;
			}
			case 5: {
				break;
			}
			case 6: {
				payroll.testCase();
				break;
			}
			case 7: {
				payroll.printName();
				break;
			}
			default: {
				System.out.println("You have entered an invalid entry");
				break;
			}
			}
		} while (ch != 5);

	}
}
