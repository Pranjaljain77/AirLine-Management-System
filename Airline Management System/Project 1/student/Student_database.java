package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_database 
{
	private static Connection connection=null;
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String []args)
	{
		Student_database studentdb=new Student_database();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURl="jdbc:mysql://localhost:3306/jdbcpc";
			String username="root";
			String password="";
			
			connection=DriverManager.getConnection(dbURl, username, password);
			
			System.out.println("Enter Choice");
			System.out.println("1.Insert record");
			
			int ch=Integer.parseInt(sc.nextLine());
			switch(ch)
			{
			case 1:
				studentdb.insertRecord();
				break;
			default:
					break;
			
			
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
	}
	private void insertRecord() throws SQLException
	{
			System.out.println("Inside insert record");
			
			//String sql="insert into student(roll_no,name,percentage,address) values(1,'pranjal',94.5,'Jaipur') ";
			
			String sql="insert into student(name,percentage,address) values(?,?,?) ";
			
			PreparedStatement prestat=connection.prepareStatement(sql);
			
//			prestat.setString(1, "Rahul");
//			prestat.setDouble(2, 87.2);
//			prestat.setString(3, "Delhi");
			
			System.out.println("Enter Name");
			prestat.setString(1, sc.nextLine());
			
			System.out.println("Enter Percentage");
			prestat.setDouble(2, Double.parseDouble(sc.nextLine()));
			
			System.out.println("Enter Address");
			prestat.setString(3, sc.nextLine());
			
			int rows= prestat.executeUpdate();
			
			if(rows>0)
				System.out.println("Record inserted succecfully");
	}
	

}
