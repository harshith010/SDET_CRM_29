package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery_Samplecode 
{
	public static void main(String[] args) throws Throwable
	{
		Connection conn = null;
		Driver driverRef = new Driver();
		//step 1: load/register "mySQL" the database
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to db
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("conncection done");
		//step 3: create quary statement
		Statement stat = conn.createStatement();
		String query = "select * from project";
		//step 4 : execute the quaryi
		ResultSet resultset = stat.executeQuery(query);
		while (resultset.next())
		{
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+resultset.getString(4));
		}
		conn.close();
		
	}

}
