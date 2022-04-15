package airline;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class Cancel extends JFrame 
{

	public static void main(String[] args) 
	{
		new Cancel();
	}
	
	JTextField textField1,txtf2,txtf3,txtf4,txtf5;
	
	public Cancel() {
		initialize();
	}
	
	private void initialize() {
		
		setTitle("CANCELLATION");
		getContentPane().setBackground(Color.white);
		setBounds(100,100,801,472);
		setLayout(null);
		
		
		JLabel Cancellation=new JLabel("CANCELLATION");
		Cancellation.setFont(new Font("Tahoma",Font.PLAIN,31));
		Cancellation.setBounds(185,34,259,38);
		add(Cancellation);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
		Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		
		JLabel NewLabel=new JLabel(i3);
		NewLabel.setBounds(470,100,250,250);
		add(NewLabel);
		
		JLabel PassengerNo=new JLabel("PASSENGER NO");
		PassengerNo.setFont(new Font("Tahoma",Font.PLAIN,17));
		PassengerNo.setBounds(60,100,132,26);
		add(PassengerNo);
		
		JLabel CancellationNo=new JLabel("CANCELLATION NO");
		CancellationNo.setFont(new Font("Tahoma",Font.PLAIN,17));
		CancellationNo.setBounds(60,150,150,27);
		add(CancellationNo);
		
		JLabel CancellationDate=new JLabel("CANCELLATION DATE");
		CancellationDate.setFont(new Font("Tahoma",Font.PLAIN,17));
		CancellationDate.setBounds(60,200,180,27);
		add(CancellationDate);
		
		JLabel TicketId=new JLabel("TICKET ID");
		TicketId.setFont(new Font("Tahoma",Font.PLAIN,17));
		TicketId.setBounds(60,250,150,27);
		add(TicketId);
		
		JLabel FlightCode=new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma",Font.PLAIN,17));
		FlightCode.setBounds(60,300,150,27);
		add(FlightCode);
		
		JButton cancel=new JButton("CANCEL");
		cancel.setFont(new Font("Tanhoma",Font.PLAIN,14));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(250,350,150,30);
		add(cancel);
		
		textField1 =new JTextField();
		textField1.setBounds(250,100,150,27);
		add(textField1);
		
		txtf2 =new JTextField();
		txtf2.setBounds(250,150,150,27);
		add(txtf2);
		
		txtf3 =new JTextField();
		txtf3.setBounds(250,200,150,27);
		add(txtf3);
		
		txtf4 =new JTextField();
		txtf4.setBounds(250,250,150,27);
		add(txtf4);
		
		txtf5 =new JTextField();
		txtf5.setBounds(250,300,150,27);
		add(txtf5);
		
		//Button name "cancel"
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
				String PassengerNo= textField1.getText();
				String CancellationNo = txtf2.getText();
				String CancellationDate= txtf3.getText();
				String TicketId= txtf4.getText();
				String FlightCode= txtf5.getText();
				
				try {
					Connection c;
					Statement s=null;
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						c=DriverManager.getConnection("jdbc:mysql://localhost:3306/Airline","root","");
						s=c.createStatement();
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					String str="Insert into cancellation values('"+PassengerNo+"', '"+CancellationNo+"','"+CancellationDate+"','"+TicketId+"', '"+FlightCode+"')";
					
					s.executeUpdate(str);
					JOptionPane.showMessageDialog(null,"Ticket Cancelled");
					setVisible(false);
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
			
		setSize(860,500);
		setVisible(true);
		setLocation(400,200);
		
	}

}
