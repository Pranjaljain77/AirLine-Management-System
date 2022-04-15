package airline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn2 {
	
	//public static Statement s;
	//private static Connection c;
	//public static Object s;
	

	//public static Statement s;

	public static void main(String[] args) 
	{
		Connection c;
		@SuppressWarnings("unused")
		Statement s;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","");
			s=c.createStatement();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	

	}



}
