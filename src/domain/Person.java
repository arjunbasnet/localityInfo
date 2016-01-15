package domain;

public class Person {
	private String firstName;
	private String lastName;
	private String adds;
	private long  phone;
	
	public Person(String firstName, String lastName, String adds, long phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adds = adds;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdds() {
		return adds;
	}

	public void setAdds(String adds) {
		this.adds = adds;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
