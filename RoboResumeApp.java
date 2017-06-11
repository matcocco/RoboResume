
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoboResumeApp {

	private static Object Name;

	public static void main(String[] args) throws SQLException {
		ArrayList<Person> bobs = new ArrayList<Person>();
		ArrayList<Education> schools = new ArrayList<Education>();//Schools is the list of Education objects
		ArrayList<Experience> jobs = new ArrayList<Experience>();
		ArrayList<Skills> skls = new ArrayList<Skills>(); 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		String sql = "select * from Person";
		String sql1 = "select * from Education";
		String sql2 = "select * from Experience";
		String sql3 = "select * from Skills";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB", "root", "password");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				System.out.print(rs.getString("FullName") + "\t");
				System.out.print(rs.getString("Email") + "\t");
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB", "root", "password");
			stmt = con.createStatement();
			rs1 = stmt.executeQuery(sql1);

			while(rs1.next()){
				System.out.print(rs1.getString("Degree") + "\t");
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB", "root", "password");
			stmt = con.createStatement();
			rs2 = stmt.executeQuery(sql2);

			while(rs2.next()){
				System.out.print(rs2.getString("Experience") + "\t");
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/RoboResumeDB", "root", "password");
			stmt = con.createStatement();
			rs3 = stmt.executeQuery(sql3);

			while(rs3.next()){
				System.out.print(rs3.getString("Skill") + "\t");
				System.out.println();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Person bob = new Person();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Please enter your name");
		bob.setName(sc.nextLine());
		System.out.println("Please enter your email address");
		bob.setEmail(sc.nextLine());
		java.sql.PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("Insert into Person (FullName, Email) values (?, ?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				pstmt.setString(1, bob.getName());
				pstmt.setString(2, bob.getEmail());
				pstmt.executeUpdate();
		System.out.println("Please enter number of educational achievements");
		int edx = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < edx; i++){
			System.out.println("Enter your education");
			Education school = new Education();
			school.setDegree(sc.nextLine());
			java.sql.PreparedStatement pstmt1 = null;
			try {
				pstmt1 = con.prepareStatement("Insert into Education (Degree, PersonId) values (?,?)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					pstmt1.setString(1, (school.getDegree()));
					pstmt1.setInt(2, (bob.getPersonId()));
					pstmt1.executeUpdate();
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
			java.sql.PreparedStatement pstmt2 = null;
			try {
				pstmt2 = con.prepareStatement("Insert into Experience (Experience, PersonId) values (?,?)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					pstmt2.setString(1, (job.getWork()));
					pstmt2.setInt(2, (bob.getPersonId()));
					pstmt2.executeUpdate();
			jobs.add(job);
		} 
		System.out.println("Enter your number of skills");
		int sk = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < sk; i++){
			System.out.println("Enter your skill");
			Skills skl = new Skills();
			skl.setSkills(sc.nextLine());
			java.sql.PreparedStatement pstmt3 = null;
			try {
				pstmt3 = con.prepareStatement("Insert into Skills (Skill, PersonId) values (?,?)");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					pstmt3.setString(1, (skl.getSkills()));
					pstmt3.setInt(2, (bob.getPersonId()));
					pstmt3.executeUpdate();
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
		
		try {
			rs.close();
			rs1.close();
			rs2.close();
			rs3.close();
			stmt.close();
			con.close();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
