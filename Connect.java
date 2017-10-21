import java.sql.*;
import java.io.*;
class Connect
{

	public static void main(String args[])
	{
		try
		{
			//Step 1:load JDBC driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(Exception e)
		{
			System.out.println("Class not found");
		}
		try
		{
			//step 2:Open database Connection
			String url = "jdbc:odbc:SSRMS";
			Connection con = DriverManager.getConnection(url);
			System.out.println("Made connection");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
