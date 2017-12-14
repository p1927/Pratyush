package Lab3_string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person3_7 {
	String firstName;
	String lastName;
	char Gender;
	LocalDate DOB;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = LocalDate.parse(dOB, formatter);

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

	public Person3_7(String firstName, String lastName, char gender) {

		this.firstName = firstName;
		this.lastName = lastName;
		Gender = gender;
	}

	public Person3_7() {
		System.out.println("Object Created With Default Constructor");
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public void getAge() {
		System.out.println("Enter Date of Birth (dd/MM/yyyy): ");
		Scanner sc = new Scanner(System.in);
		String DOB = sc.nextLine();
		setDOB(DOB);
		LocalDate today = LocalDate.now();
		System.out.println("Age of Person is: "
				+ getDOB().until(today).getYears() + " Years "
				+ getDOB().until(today).getMonths() + " Months "
				+ getDOB().until(today).getDays() + " days ");
		sc.close();
	}

	public String getFullName() {
		return this.firstName.concat(" " + this.lastName);
	}

	@Override
	public String toString() {
		return "firstName=" + firstName + "\nlastName=" + lastName
				+ "\nGender=" + Gender;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person3_7 Person1 = new Person3_7("Chandan", "Pandey", 'M');
		System.out.println("Your Full Name is : " + Person1.getFullName());
		System.out.println(Person1.toString());
		Person1.getAge();

	}

}
