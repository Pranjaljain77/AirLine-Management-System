package airline;

import net.proteanit.sql.DbUtils;
//import java.lang.Object;	
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Flight_Info extends JFrame 
{
	private JTable table;
	private JTextField textField;

	public static void main(String[] args) 
	{
		new Flight_Info().setVisible(true);
	}
	
	public Flight_Info() 
	{
		getContentPane().setBackground(Color.white);
		getContentPane().setFont(new Font("Tahoma",Font.PLAIN,13));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850,510);
		setLayout(null);
		setVisible(true);
		
		JLabel Fcode =new JLabel("FLIGHT CODE");
		Fcode.setFont(new Font("Tahoma",Font.PLAIN,17));
		Fcode.setBounds(50,100,200,30);
		add(Fcode);
		
		JLabel Flight_Details= new JLabel("FLIGHT INFORMATION");
		Flight_Details.setFont(new Font("Tahoma",Font.PLAIN,31));
		Flight_Details.setForeground(new Color(100,149,237));
		Flight_Details.setBounds(50,20,570,35);
		add(Flight_Details);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Tahoma",Font.PLAIN,20));
		
		btnShow.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				String code= textField.getText();
				
				try 
				{
					//Statement s;
					//Conn2 c=new Conn2();
					
					//This will print all the details of sector table;
					//String str="select f_code,f_name,src,dst,capacity,class_code,class_name from flight,sector where f_code ='"+code+"'";
					
					String str="select f_code,f_name,src,dst,capacity,class_code,class_name from flight,sector where f_code ='"+code+"'&& flight_code='"+code+"'";
					
					//CONNECTION WORK IS DONE IN THIS-------------------------------------------------------			
					Connection c;
					Statement s = null;
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","");
						s=c.createStatement();
						
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				
		
					
					
					
					ResultSet rs=s.executeQuery(str);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		
		
		btnShow.setBounds(220,150,120,30);
		add(btnShow);
		
		table= new JTable();
		table.setBackground(Color.white);
		table.setBounds(23,250,800,300);
		
		JScrollPane pane= new JScrollPane(table);
		pane.setBounds(23,250,800,300);
		pane.setBackground(Color.white);
		add(pane);
		
		textField= new JTextField();
		textField.setBounds(220,100,200,30);
		add(textField);
		
		JLabel FlightCode =new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma",Font.PLAIN,13));
		FlightCode.setBounds(23,220,126,14);
		add(FlightCode);
		
		JLabel FlightName =new JLabel("FLIGHT NAME");
		FlightName.setFont(new Font("Tahoma",Font.PLAIN,13));
		FlightName.setBounds(145,220,120,14);
		add(FlightName);
		
		JLabel source =new JLabel("SOURCE");
		source.setFont(new Font("Tahoma",Font.PLAIN,13));
		source.setBounds(275,220,111,14);
		add(source);
		
		JLabel Destination =new JLabel("DESTINATION");
		Destination.setFont(new Font("Tahoma",Font.PLAIN,13));
		Destination.setBounds(380,220,120,14);
		add(Destination);
		
		JLabel Capacity =new JLabel("CAPACITY");
		Capacity.setFont(new Font("Tahoma",Font.PLAIN,13));
		Capacity.setBounds(500,220,111,14);
		add(Capacity);
		
		JLabel ClassCode =new JLabel("CLASS CODE");
		ClassCode.setFont(new Font("Tahoma",Font.PLAIN,13));
		ClassCode.setBounds(610,220,120,14);
		add(ClassCode);
		
		JLabel ClassName =new JLabel("CLASS NAME");
		ClassName.setFont(new Font("Tahoma",Font.PLAIN,13));
		ClassName.setBounds(730,220,111,14);
		add(ClassName);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(860,600);
		setLocation(280,150);
		setVisible(true);
		
	}

}
