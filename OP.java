import java.sql.*;
import java.io.*;
class OP
{

	public static void main(String args[])
	{
		try
		{
			//Register driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(Exception e)
		{
			System.out.println("Class not found");
		}
		try
		{
			//Establish connection
			String url = "jdbc:odbc:SSRMS";
			Connection con = DriverManager.getConnection(url);
			System.out.println("Made connection");
			Statement stmt = con.createStatement();

			//Execute query                                                                             
			stmt.executeUpdate("CREATE TABLE emp(id int Primary key,name varchar(100),salary money)");
			stmt.executeUpdate("INSERT INTO emp VALUES('1','Sagar','75000')");
			stmt.executeUpdate("INSERT INTO emp VALUES('2','Shravan', '80000')");


			//retriving information

			ResultSet rs= stmt.executeQuery("SELECT * FROM emp");

			while(rs.next())
				System.out.println(rs.getString(1)+'\t'+rs.getString("name") +'\t'+rs.getString("salary"));               

			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}
