/**
 * 
 */
package Lab2;




public class Person2_3 {

	@Override
	public String toString() {
		return "Person2_3 [firstName=" + firstName + ", lastName=" + lastName
				+ ", Gender=" + Gender + "]";
	}

	String firstName;

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

	public Person2_3(String firstName, String lastName, char gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		Gender = gender;
	}

	public Person2_3() {
		System.out.println("Object Created With Default Constructor");
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	String lastName;
	char Gender;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person2_3 Person1=new Person2_3("Chandan","Pandey",'M');
		Person1.toString();
		

	}
	

}
