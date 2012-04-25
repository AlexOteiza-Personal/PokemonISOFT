package graphics.betatesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest {

	public ConnectTest() throws SQLException {
		Connection conection = 
		DriverManager.getConnection("jdbc:mysql://178.79.183.191/test", "root","password");
		Statement query = conection.createStatement();
		ResultSet result = query.executeQuery("SELECT * FROM users;");
		System.out.println(result);
	}
	public static void main(String[] args) throws SQLException {
		new ConnectTest();
	}
}
