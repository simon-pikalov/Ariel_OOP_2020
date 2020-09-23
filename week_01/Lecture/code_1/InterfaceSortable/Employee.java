//  class Employee -- a class for Employees
package InterfaceSortable;
public class Employee implements Sortable {
	private int SSNum;          //  the social security number
	private String firstname;
	private String lastname;
	private int salary;

	public Employee(){}

	public Employee(int SSN, String first, String last, int sal) {
		SSNum = SSN;
		firstname = first;
		lastname = last;
		salary = sal;
	}
	//  compare function required by Sortable interface
	//  orders Employees by social security number
@Override
	public int compare(Sortable another) {
		if (another instanceof Employee)
			return this.SSNum - ((Employee) another).SSNum;
		else
			throw new RuntimeException("another is not Employee");
	}

	//  allows us to print an Employee

	public String toString() {
		String emp;
		emp = Integer.toString(SSNum) + "     " + lastname + "  "
				+ firstname + "     " + Integer.toString(salary);
		return emp;
	}
}	// end class Employee

