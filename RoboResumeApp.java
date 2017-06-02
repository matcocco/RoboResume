
import java.util.Scanner;
import java.util.ArrayList;

public class RoboResumeApp {

	public static void main(String[] args) {
		ArrayList<Person> bobs = new ArrayList<Person>();
		ArrayList<Education> schools = new ArrayList<Education>();//Schools is the list of Education objects
		ArrayList<Experience> jobs = new ArrayList<Experience>();
		ArrayList<Skills> skls = new ArrayList<Skills>(); 

		Person bob = new Person();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Please enter your name");
		bob.setName(sc.nextLine());
		System.out.println("Please enter your email address");
		bob.setEmail(sc.nextLine());
		System.out.println("Please enter number of educational achievements");
		int edx = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < edx; i++){
			System.out.println("Enter your education");
			Education school = new Education();
			school.setDegree(sc.nextLine());
			schools.add(school);
		} if (edx == 0){
			System.out.println("Enter your work experience");
		}
		System.out.print("Now proceed to enter work experience...");
		System.out.println("Enter number of work experiences");
		int ex = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < ex; i++){
			System.out.println("Enter work experience");
			Experience job = new Experience();
			job.setWork(sc.nextLine());
			jobs.add(job);
		} 
		System.out.println("Enter your number of skills");
		int sk = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < sk; i++){
			System.out.println("Enter your skill");
			Skills skl = new Skills();
			skl.setSkills(sc.nextLine());
			skls.add(skl);
		}
		//Throw exception
		System.out.println(bob);
		System.out.println("Ecducation" + "\n");
		for (int i = 0; i < edx; i++){
			System.out.println(schools.get(i));
		}
		System.out.println("\n" + "Experience");
			for (int i = 0; i < ex; i++){
			System.out.println(jobs.get(i));
		}
		System.out.println("\n" + "Skills" );
		for (int i = 0; i < ex; i++){
			System.out.println(skls.get(i));
		}
	}	
}
