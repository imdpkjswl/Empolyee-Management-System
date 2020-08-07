package Employee;

import java.sql.*;

public class conn {

	//Create two interface
	public Connection c;  // used to set up connection with mysql
	public Statement st;  // used to execute all queries of mysql
	
	public conn() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load mysql jdbc driver
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-management-system?useSSL=false&serverTimezone=UTC","root","");
			st = c.createStatement(); // helpful to execute query
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
