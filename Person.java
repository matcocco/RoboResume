
public class Person {
	private String name;
	private String email;
	private int Id;
	
	public int getId(){
		return Id;
	}
	public String toString (){
		return name + "\n" + email + "\n";
	}
	public String getName(){
		return name;
	}
	public void setName (String c){
		this.name = c;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail (String cemail){
		this.email = cemail;
	}
	//Throw and exception handle to address number input
}
