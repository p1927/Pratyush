package Lab6;

@SuppressWarnings("serial")
class AgeRestriction extends Exception{

	public AgeRestriction(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

class Person {
	String Name;
	Float Age;
	@Override
	public String toString() {
		return "Name=" + Name + "\nAge=" + Age ;
	}
	public Person(String name, float age) {
		
		Name = name;
		Age = age;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Float getAge() {
		return Age;
	}
	public void setAge(Float age) throws AgeRestriction {
		if(age<15){
			throw new AgeRestriction("Age should be greater than 15");
		}
		else
		Age = age;
	}
	

}


public class Lab6_2 {

	public static void main(String[] args) {
		Person Per1=new Person("Chandan", 24);
		try {
			Per1.setAge(14f);
		} catch (AgeRestriction e) {
			
			System.out.println(e.getMessage());
		}
		System.out.println("out of catch");
		System.out.println(Per1.toString());
	
	}

}
