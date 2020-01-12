package attendance;

import java.sql.*;

import javax.swing.JOptionPane;

public class sqliteConnection {

	Connection conn=null;
	
	public static Connection dbConnector() {
	
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:userdb.db");
//			JOptionPane.showMessageDialog(null,"Connecting to the database was successful.");
			return conn;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"The connection to the database was unsuccessful.Error: "+e);
			return null;
		}
		
	}
	
}
