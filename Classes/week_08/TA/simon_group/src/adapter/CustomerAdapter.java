package adapter;


public class CustomerAdapter extends NewCustomer implements Customer{

	public CustomerAdapter(OldCustomer oldCustomer){
		this.adaptData(oldCustomer);
	}
	
	private void adaptData(OldCustomer oldCustomer){
		this.setName(oldCustomer.getName());
		this.setAge(Integer.valueOf(oldCustomer.getAge()));
		Address address = new Address();
		String[] oldAddress = oldCustomer.getAddress().split(",");
		address.setStreetName(oldAddress[0]);
		address.setHouseNumber(Integer.valueOf(oldAddress[1]));
		address.setPostalCode(Integer.valueOf(oldAddress[2]));
		address.setCity(oldAddress[3]);
		this.setAddress(address);
	}
	
	
}
