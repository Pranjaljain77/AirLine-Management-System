package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Mainframe extends JFrame{

	public static void main(String[] args) 
	{
		new Mainframe().setVisible(true);
	}
	
	public Mainframe() 
	{
		super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
		initialize();
		
	}
	private void initialize() 
	{
		getContentPane().setForeground(Color.cyan);
		setLayout(null);
		
		JLabel NewLabel =new JLabel("");
		NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/front.jpg")));
		NewLabel.setBounds(0,0,1920,990);
		add(NewLabel);
		
		JLabel AirlineMgsys =new JLabel("Air India Welcomes you");
		AirlineMgsys.setForeground(Color.blue);
		AirlineMgsys.setFont(new Font("Tahoma",Font.PLAIN,36));
		AirlineMgsys.setBounds(700,60,1000,55);
		NewLabel.add(AirlineMgsys);
		
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu AirlineSystem =new JMenu("AIRLINE SYSTEM");
		AirlineSystem.setForeground(Color.blue);
		menuBar.add(AirlineSystem);
		
		JMenuItem FlightDetails=new JMenuItem("FLIGHT INFO");
		AirlineSystem.add(FlightDetails);
		
		JMenuItem ReservationDetails=new JMenuItem("ADD_CUSTOMER_DETAILS");
		AirlineSystem.add(ReservationDetails);
		
		JMenuItem PassengerDetails =new JMenuItem("JOURNEY DETAILS");
		AirlineSystem.add(PassengerDetails);
		
		JMenuItem SectorDetails= new JMenuItem("PAYMENT DETAILS");
		AirlineSystem.add(SectorDetails);
		
		JMenuItem Cancellation= new JMenuItem("CANCELLATION");
		AirlineSystem.add(Cancellation);
		
		
		JMenu Ticket =new JMenu("TICKET");
		Ticket.setForeground(Color.black);
		menuBar.add(Ticket);
		
		JMenu List =new JMenu("LIST");
		List.setForeground(Color.black);
		menuBar.add(List);
		
		JMenu Misc =new JMenu("Help");
		Misc.setForeground(Color.black);
		menuBar.add(Misc);
		
		FlightDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
            try {
            	 new Flight_Info();
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
			
			
		});
		
		ReservationDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				try {
					new Add_customer();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
		});
		
		PassengerDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				
			try 
			{
				new Journey_Details();
					
			}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			
		});
		SectorDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
				try {
					new Payment_Details();
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
			
			
		});
		Cancellation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) 
			{
			try {
				new Cancel();
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			
			
		});
		setSize(1950,1090);
		setVisible(true);
		
	}

}
