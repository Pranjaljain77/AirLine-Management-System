package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;

@SuppressWarnings("serial")
public class Payment_Details extends JFrame{
	
	JTextField textField;
	JTable table;
	JLabel detail,PnrNo,amount,cheque,payDate,label;

	public static void main(String[] args) 
	{
		new Payment_Details();
	}
	
	public Payment_Details() {
		
		setTitle("PAYMENT DETAILS");
		getContentPane().setBackground(Color.white);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860,486);
		setLayout(null);
		

		PnrNo =new JLabel("PNR NO");
		PnrNo.setFont(new Font("Tahoma",Font.PLAIN,17));
		PnrNo.setBounds(79,270,83,20);
		add(PnrNo);
		
		textField=new JTextField();
		textField.setBounds(200,160,150,26);
		add(textField);	
		
		table= new JTable();
		table.setBounds(45,329,766,87);
		add(table);
		
		JButton show=new JButton("SHOW");
		show.setFont(new Font("Tanhoma",Font.PLAIN,17));
		show.setBackground(Color.black);
		show.setForeground(Color.white);
		show.setBounds(200,210,150,26);
		add(show);
		
		detail =new JLabel("PAYMENT DETAILS");
		detail.setFont(new Font("Tahoma",Font.PLAIN,31));
		detail.setForeground(Color.blue);
		detail.setBounds(51,17,300,39);
		add(detail);
		
		
		PnrNo =new JLabel("PNR NO");
		PnrNo.setFont(new Font("Tahoma",Font.PLAIN,13));
		PnrNo.setBounds(84,292,108,26);
		add(PnrNo);
				
		amount =new JLabel("PAID AMOUNT");
		amount.setFont(new Font("Tahoma",Font.PLAIN,13));
		amount.setBounds(183,298,92,14);
		add(amount);
		
		payDate =new JLabel("PAY DATE");
		payDate.setFont(new Font("Tahoma",Font.PLAIN,13));
		payDate.setBounds(322,294,101,24);
		add(payDate);

		cheque =new JLabel("CHEQUE NO");
		cheque.setFont(new Font("Tahoma",Font.PLAIN,13));
		cheque.setBounds(445,298,114,14);
		add(cheque);
		
		label= new JLabel("");
		label.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payment.png")));
		label.setBounds(459,15,239,272);
		add(label);
		
		JLabel Cardno = new JLabel("CARD NO");
		Cardno.setFont(new Font("Tahoma",Font.PLAIN,13));
		Cardno.setBounds(602,299,101,26);
		add(Cardno);
		
		JLabel Phoneno = new JLabel("PHONE NO");
		Phoneno.setFont(new Font("Tahoma",Font.PLAIN,13));
		Phoneno.setBounds(712,296,84,34);
		add(Phoneno);
		
		setVisible(true);
		
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				try {
					String code=textField.getText();
					
					//------------------------CONNECTION---------------------------------
					
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
					
					String str="select pnr_no,paid_amt,pay_date,cheque_no,card_no,ph_no from payment where pnr_no='"+code+"'";
					
					ResultSet rs=s.executeQuery(str);
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		
		setSize(960,600);
		setLocation(400,200);
		setVisible(true);
		
		
		
	}

}
