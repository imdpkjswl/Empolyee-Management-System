package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class login_page implements ActionListener {

	JFrame frame;
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2;
	
	login_page(){
	
		frame = new JFrame("Login");
		frame.setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(380,230);
		
		l1 = new JLabel("Username");
		l1.setBounds(40,20,100,30);
		frame.add(l1);
		
		
		l2 = new JLabel("Password");
		l2.setBounds(40,70,100,30);
		frame.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150,20,150,30);
		frame.add(t1);
		
		
		t2 = new JPasswordField();
		t2.setBounds(150,70,150,30);
		frame.add(t2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); // resize our image size.
		ImageIcon i3 = new ImageIcon(i2);  // convert image into imageicon
		JLabel l3 =  new JLabel(i3); // set imageicon on label
		l3.setBounds(350,20,150,150);
		frame.add(l3); // finally, add label on welcome frame.
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,140,120,30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);  // perform action on button click.
		frame.add(b1);
		
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(180,140,120,30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);  // perform action on button click.
		frame.add(b2);
		
		
		frame.getContentPane().setBackground(Color.WHITE);
		
		frame.setVisible(true);
		frame.setSize(600,300);
		
		
	}
	
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b2) {
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		try {
			conn c1 = new conn();
			String u = t1.getText();
			String p = t2.getText();
			
			String q = "select * from login where username='"+u+"' and password='"+p+"' ";
			
			ResultSet rs = c1.st.executeQuery(q); // used to retrieve data from database using conn.s.executeQuery()
			
			if(rs.next()) {  //used to match username and password
				new details_page().frame.setVisible(true); // open details page and make visible also. 
				frame.setVisible(false); // close login page
			}else {
				JOptionPane.showMessageDialog(null, "Invalid login"); // when not matched.
				frame.setVisible(false); // close login page
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		login_page login =  new login_page();
	}
	
}
