package Lab4;

public class Lab4_3 {
	String Name;
	Float Age;
	@Override
	public String toString() {
		return "Name=" + Name + "\nAge=" + Age ;
	}
	public Lab4_3(String name, float age) {
		
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
	public void setAge(Float age) {
		Age = age;
	}
	

}
