package airline;

//import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Add_customer extends JFrame
{
	public static void main(String[] args) 
	{
		new Add_customer();
	
	}
	
	JTextField textField1,txtf2,txtf3,txtf4,txtf5,txtf6,txtf7;
	
	public Add_customer() {
		
		getContentPane().setForeground(Color.blue);
		getContentPane().setBackground(Color.white);
		setTitle("ADD CUSTOMER DETAILS");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(778,486);
		getContentPane().setLayout(null);
		
		JLabel Passportno=new JLabel("PASSPORT NO");
		Passportno.setFont(new Font("Tahoma",Font.PLAIN,17));
		Passportno.setBounds(60,80,150,27);
		add(Passportno);
		
		textField1 = new JTextField();
		textField1.setBounds(200,80,150,27);
		add(textField1);
		
		JButton next =new JButton("SAVE");
		next.setBounds(200,420,150,30);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		add(next);
		
		JLabel Pnrno=new JLabel("PNR NO");
		Pnrno.setFont(new Font("Tahoma",Font.PLAIN,17));
		Pnrno.setBounds(60,120,150,27);
		add(Pnrno);
		
		txtf2=new JTextField();
		txtf2.setBounds(200,120,150,27);
		add(txtf2);
		
		JLabel Address=new JLabel("ADDRESS");
		Address.setFont(new Font("Tahoma",Font.PLAIN,17));
		Address.setBounds(60,170,150,27);
		add(Address);
		
		txtf3=new JTextField();
		txtf3.setBounds(200,170,150,27);
		add(txtf3);
		
		JLabel Nationality=new JLabel("NATIONALITY");
		Nationality.setFont(new Font("Tahoma",Font.PLAIN,17));
		Nationality.setBounds(60,220,150,27);
		add(Nationality);
		
		txtf4=new JTextField();
		txtf4.setBounds(200,220,150,27);
		add(txtf4);
		
		JLabel Name=new JLabel("NAME");
		Name.setFont(new Font("Tahoma",Font.PLAIN,17));
		Name.setBounds(60,270,150,27);
		add(Name);
		
		txtf5=new JTextField();
		txtf5.setBounds(200,270,150,27);
		add(txtf5);
		
		JLabel Gender=new JLabel("GENDER");
		Gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		Gender.setBounds(60,320,150,27);
		add(Gender);
		
		JRadioButton NewRadioButton= new JRadioButton("MALE");
		NewRadioButton.setBackground(Color.white);
		NewRadioButton.setBounds(200,320,70,27);
		add(NewRadioButton);
		
		JRadioButton Female= new JRadioButton("FEMALE");
		Female.setBackground(Color.white);
		Female.setBounds(280,320,90,27);
		add(Female);
		
		JLabel Phno=new JLabel("PH NO");
		Phno.setFont(new Font("Tahoma",Font.PLAIN,17));
		Phno.setBounds(60,370,150,27);
		add(Phno);
		
		txtf6=new JTextField();
		txtf6.setBounds(200,370,150,27);
		add(txtf6);
		
		setVisible(true);
		
		JLabel AddPassengers=new JLabel("ADD CUSTOMER DETAILS");
		AddPassengers.setFont(new Font("Tahoma",Font.PLAIN,31));
		AddPassengers.setForeground(Color.blue);
		AddPassengers.setBounds(420,24,442,35);
		add(AddPassengers);
		
		JLabel FlightCode=new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma",Font.PLAIN,17));
		FlightCode.setBounds(60,30,150,27);
		add(FlightCode);
		
		txtf7=new JTextField();
		txtf7.setBounds(200,30,150,27);
		add(txtf7);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/emp.png"));
		JLabel image=new JLabel(i1);
		image.setBounds(450,80,280,410);
		add(image);
		
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				String Passportno= textField1.getText();
				String Pnrno = txtf2.getText();
				String Address= txtf3.getText();
				String Nationality= txtf4.getText();
				String Name= txtf5.getText();
				
				String gender = null;
				
				String Phoneno= txtf6.getText();
				String FlightCode= txtf7.getText();
				
				if(NewRadioButton.isSelected())
				{
					gender="MALE";
				}
				else if(Female.isSelected())
				{
					gender="FEMALE";
				}
				
				try 
				{
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
					
					String str="Insert into passenger values( '"+Pnrno+"', '"+Address+"','"+Nationality+"', '"+Name+"', '"+gender+"', '"+Phoneno+"','"+Passportno+"', '"+FlightCode+"')";
					
				    s.executeUpdate(str);
					
					JOptionPane.showMessageDialog(null, "Customer Added");
					setVisible(false);
				}
				catch(Exception e)
				{
			 		e.printStackTrace();
		 		}
		 	}
		 	
		 	
		});
		setSize(900,600);
		setVisible(true);
		setLocation(400,200);
		
		
	}
	
	

}
