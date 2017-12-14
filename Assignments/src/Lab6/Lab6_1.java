package Lab6;

@SuppressWarnings("serial")
class NullName extends Exception{
	String msg="Should not be empty";
	
	NullName(String msg){
		this.msg=msg;
	}
	NullName(){
		super();
	}
	@Override
	public String toString() {
		return msg;
	}
	
}
class Person2_3 {

		@Override
		public String toString() {
			return "Person2_3 [firstName=" + firstName + ", lastName=" + lastName
					+ ", Gender=" + Gender + "]";
		}

		String firstName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) throws NullName {
			if(firstName.trim().length() == 0){
				throw new NullName("firstName should not be empty");
			}
			else
			this.firstName = firstName;
			
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) throws NullName {
			if(lastName.trim().length() == 0){
				throw new NullName("lastName should not be empty");
			}
			
			else
			this.lastName = lastName;
		}

		public Person2_3(String firstName, String lastName, char gender)throws NullName {
			
			 if(firstName.trim().length() == 0){
				throw new NullName("firstName should not be empty");
			}
			 else if(lastName.trim().length() == 0){
					throw new NullName("lastName should not be empty");
				}
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
		
		

	}
public class Lab6_1{
	public static void main(String[] args) throws NullName  {
		// TODO Auto-generated method stub
		Person2_3 Person1=new Person2_3("A","B",'M');
		try{
		Person1.setFirstName("");}
		catch(NullName e){
			
			System.out.println(e);
		}
		System.out.println(Person1.toString());
		

	}
}
