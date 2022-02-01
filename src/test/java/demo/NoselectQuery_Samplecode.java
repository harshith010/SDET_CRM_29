package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NoselectQuery_Samplecode 
{
	public static void main(String[] args) throws SQLException 
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = conn.createStatement();
		String query = "insert into project values('TY_Project_310','Harshith','13/01/2022','State bank of India','on going',20)";
		int result = 0;
		result = stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Successfully inserted");
		}
		else{
		System.err.println("Not inserted");
		}
		conn.close();
		
}

}
