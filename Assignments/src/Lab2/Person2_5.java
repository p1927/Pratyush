package Lab2;

enum Gender {
	M, F;
}

public class Person2_5 {
	String firstName;
	String lastName;
	Gender gender;
	int phoneNumber;

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public Person2_5(String firstName, String lastName, Gender gender, int Phone) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = Phone;
	}

	public Person2_5() {
		System.out.println("Object Created With Default Constructor");
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void displayDetails() {
		System.out.println("Person Details:");
		System.out.println("_______________");
		System.out.println("\nFirst Name: " + this.firstName);
		System.out.println("Last Name: " + this.lastName);
		System.out.println("Gender: " + this.gender);
		System.out.println("Gender: " + this.phoneNumber);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person2_5 Person1 = new Person2_5("Chandan", "Pandey", Gender.M,
				523232112);
		Person1.displayDetails();

	}

}
