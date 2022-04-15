package airline;

import java.sql.*;
import java.util.Scanner;
public class Conn {

	public static Scanner sc=new Scanner(System.in);
	public static Statement s;
	private static Connection c;
	public static void main(String[] args) 
	{
		
		//@SuppressWarnings("unused")
	//	 Statement s;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","");
			s=c.createStatement();
			
			System.out.println("Enter Choice");
			System.out.println("1.Insert record");
			
			insertRecord();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	

	}
	public static void insertRecord() throws SQLException
	{
			System.out.println("Inside insert record");
			
			//String sql="insert into student(roll_no,name,percentage,address) values(1,'pranjal',94.5,'Jaipur') ";
		
			
			String sql="insert into login(username,password) values(?,?) ";
			
			PreparedStatement prestat=c.prepareStatement(sql);
			
			System.out.println("Enter Name");
			prestat.setString(1, sc.nextLine());
			
			System.out.println("Enter PASSWORD");
			prestat.setString(2, sc.nextLine());
			
			
			int rows= prestat.executeUpdate();
			
			if(rows>0)
				System.out.println("Record inserted succecfully");
	}
	//public Object s;
	

}
