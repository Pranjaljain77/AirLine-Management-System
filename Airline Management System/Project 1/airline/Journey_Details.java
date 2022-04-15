package airline;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;

@SuppressWarnings("serial")
public class Journey_Details extends JFrame{

	JTable table;
	JLabel ReservationDetails,PnrNo,TicketId,Fcode,JnDate,JnTime,Src,Des,label,label1;
	JButton show;
	
	public static void main(String[] args) 
	{
		new Journey_Details();
	}
	
	
	public Journey_Details() 
	{
		setTitle("JOURNEY DETAILS");
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		Src =new JLabel("SOURCE");
		Src.setFont(new Font("Tahoma",Font.PLAIN,19));
		Src.setBounds(60,100,150,27);
		add(Src);
		
		Des =new JLabel("DESTINATION");
		Des.setFont(new Font("Tahoma",Font.PLAIN,19));
		Des.setBounds(350,100,150,27);
		add(Des);
		
		show= new JButton("SHOW");
		show.setBounds(680,100,100,30);
		add(show);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		ReservationDetails =new JLabel("JOURNEY DETAILS");
		ReservationDetails.setFont(new Font("Tahoma",Font.PLAIN,31));
		ReservationDetails.setForeground(Color.blue);
		ReservationDetails.setBounds(280,17,359,31);
		add(ReservationDetails);

		PnrNo =new JLabel("PNR NO");
		PnrNo.setFont(new Font("Tahoma",Font.PLAIN,13));
		PnrNo.setBounds(79,270,83,20);
		add(PnrNo);

		TicketId =new JLabel("TICKET ID");
		TicketId.setFont(new Font("Tahoma",Font.PLAIN,13));
		TicketId.setBounds(172,270,71,20);
		add(TicketId);	

		Fcode =new JLabel("F_CODE");
		Fcode.setFont(new Font("Tahoma",Font.PLAIN,13));
		Fcode.setBounds(297,270,103,20);
		add(Fcode);

		JnDate =new JLabel("JOURNEY DATE");
		JnDate.setFont(new Font("Tahoma",Font.PLAIN,13));
		JnDate.setBounds(390,270,94,20);
		add(JnDate);
		
		JnTime =new JLabel("JOURNEY TIME");
		JnTime.setFont(new Font("Tahoma",Font.PLAIN,13));
		JnTime.setBounds(494,270,95,20);
		add(JnTime);

		Src =new JLabel("SOURCE");
		Src.setFont(new Font("Tahoma",Font.PLAIN,13));
		Src.setBounds(613,270,94,20);
		add(Src);

		Des =new JLabel("DESTINATION");
		Des.setFont(new Font("Tahoma",Font.PLAIN,13));
		Des.setBounds(717,270,94,20);
		add(Des);
		
		String []items1= {"BANGALORE","MUMBAI","CHENNAI","PATNA","DELHI","HYDERABAD"};
		//--------OBJECT------------------ComboBox
		JComboBox<Object> comboBox=new JComboBox<>(items1);
		
		comboBox.setBounds(150,100,150,27);
		add(comboBox);
		
		String []items2= {"BANGALORE","MUMBAI","CHENNAI","PATNA","DELHI","HYDERABAD"};
		
		JComboBox<Object> comboBox2=new JComboBox<>(items2);
		
		comboBox2.setBounds(500,100,150,27);
		add(comboBox2);
		
		table=new JTable();
		table.setBounds(38,310,770,130);
		add(table);
		
		show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				try {
					String src=(String)comboBox.getSelectedItem();
					String des=(String)comboBox2.getSelectedItem();
					
					//---CONNECTION---------------------------------------------------------------------------
					
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
					
					String str="select pnr_no,ticket_id,f_code,jny_date,jny_time,src,dst from reservation where src='"+src+"' and dst='"+des+"'";
					
					ResultSet rs= s.executeQuery(str);
					
					if(rs.next())
					{
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else
					{
						JOptionPane.showMessageDialog(null,"NO FLIGHTS BETWEEN "+src+" and "+des);
					}
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			
		});
		
		setSize(860,600);
		setLocation(400,200);
		setVisible(true);
		


		
		
		
		
		
		
		
		
		
	}

}
