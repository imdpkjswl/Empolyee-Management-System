package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Thread;

class welcome_page implements ActionListener {
	
	JFrame frame;
	JButton b;
	
	
	welcome_page(){
	
		frame = new JFrame("EMS");
		frame.setBackground(Color.red);
		frame.setLayout(null); // absolute layout used
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/welcome.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1050, 650, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		
		JLabel l1 =  new JLabel(i3); // set imageicon on label
		l1.setBounds(30,140,1165,430);
		frame.add(l1); // finally, add label on welcome frame.
		
		JButton b = new JButton("Click Here To Continue");
		b.setBackground(Color.DARK_GRAY);
		b.setForeground(Color.WHITE);
		b.setBounds(525,530,180,40);
		b.addActionListener(this);  // perform action on button click.
		
		
		JLabel id = new JLabel();
		id.setBounds(0,0,1165,650); // keep length as image length.
		id.setLayout(null);
		
		
		JLabel lid = new JLabel("EMPLOYEE MANAGEMENT SYSTEM"); // blinking label
		lid.setBounds(80,30,1140,100);
		lid.setFont(new Font("Serif",Font.PLAIN,63));
		id.add(lid);
		
		id.add(b);
		frame.add(id);
		
		frame.getContentPane().setBackground(Color.WHITE); // set frame background color
		
		frame.setVisible(true);
		frame.setSize(1260,650);
		frame.setLocation(50,50); // setting on window location 
		
		// For blinking text on frame
		while(true) {
			lid.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception ex1){}
			
				lid.setVisible(true);
				try {
					Thread.sleep(500);
				}catch(Exception ex2) {}
				
		}
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
			frame.setVisible(false);
			 new login_page();  // open login page on button click
		
	}
	
	public static void main(String [] args) {
		welcome_page wel = new welcome_page();
	}
	
}
