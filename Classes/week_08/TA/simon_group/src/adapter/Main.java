package adapter;

import java.util.ArrayList;
import java.util.List;

class Main {
	public static void main(String[] args) {
		OldCustomer oldCustomer = new OldCustomer();
		oldCustomer.setName("Vasia");
		oldCustomer.setAge("26");
		oldCustomer.setAddress("LP,30,20021,New York");
		

		List<Customer> customerList = new ArrayList<>();
		//customerList.add(oldCustomer); // Error:(26, 34) java: incompatible types: adapter.OldCustomer cannot be converted to adapter.Customer
		Customer customerAdapter = new CustomerAdapter(oldCustomer);
		customerList.add(customerAdapter);
		System.out.println(customerAdapter);



		}
}
