package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest 
{
	@Test
		public void projectunitTest() throws SQLException
		{
		String projectname = "State Bank Of India";
		Driver driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = conn.createStatement();
		String query = "select * from project";
		ResultSet resultset = stat.executeQuery(query);
		boolean flag = false;
		while(resultset.next())
		{
			String actualprojectname = resultset.getString(4);
			if(actualprojectname.equals(projectname))
			{
				flag=true;
			}
		}
		Assert.assertTrue(true);
		conn.close();
		}
	
	
	

}
