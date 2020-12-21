package adapter;


public class Address {
	private String streetName;
	private int houseNumber;
	private int postalCode;
	private String city;
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString(){
		return " Street:"+this.getStreetName()+"\n"+" HouseNumber:"+this.getHouseNumber()+"\n"+
				" Postal Code:"+this.getPostalCode()+"\n"+" City:"+this.getCity();
	}
}
