package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class St_db2 {

	private static Connection connection=null;
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String []args) 	
	{
		St_db2 stdb1=new St_db2();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURl="jdbc:mysql://localhost:3306/jdbcpc";
			String username="root";
			String password="";
			
			connection=DriverManager.getConnection(dbURl, username, password);
			
			System.out.println("Enter Choice");
			System.out.println("1.Insert record");
			System.out.println("2.Select record");
			
			int ch=Integer.parseInt(sc.nextLine());
			switch(ch)
			{
			case 1:
				stdb1.insertRecord();
				break;
			case 2:
				stdb1.selectRecord();
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
	
	private void selectRecord() throws SQLException
	{
		//System.out.println("Select meathod is called");
		System.out.println("Enter the roll no to find result=");
		int no=Integer.parseInt(sc.nextLine());
		
		
		String str="Select * From student where roll_no="+no;
		
		Statement statement= connection.createStatement() ;
		
		
		ResultSet rs= statement.executeQuery(str);
		
		if(rs.next())
		{
			int rollno=rs.getInt("roll_no");
			String name=rs.getString("name");
			double percentage=rs.getDouble("percentage");
			String address=rs.getString("address");
			
			System.out.println("Roll no is "+rollno);
			System.out.println("Name is "+name);
			
			System.out.println("Percentage is "+percentage);
			System.out.println("Address is "+address);

			
		}
		else
		{
			System.out.println("No record found ..");
		}
		
//		while(rs.next())
//		{
//			int rollno=rs.getInt("roll_no");
//			String name=rs.getString("name");
//			double percentage=rs.getDouble("percentage");
//			String address=rs.getString("address");
//			
//			System.out.println("Roll no is "+rollno);
//			System.out.println("Name is "+name);
//			
//			System.out.println("Percentage is "+percentage);
//			System.out.println("Roll no is "+address);
//
//		}
		
	}
	


}
