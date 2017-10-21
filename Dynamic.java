import java.sql.*;
import java.io.*;
import java.util.*;
class Dynamic
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch(Exception e)
		{
			System.out.println("Class not found");
		}
		try
		{
			String url = "jdbc:odbc:SSRMS";
			Connection con = DriverManager.getConnection(url);
			System.out.println("Made connection");
			PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?)");
			
			// taking values from keyboard
			// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			Scanner sc = new Scanner(System.in);
			
			Statement stmt = con.createStatement();
			
			System.out.println("Enter Employee ID:");
			int empid= sc.nextInt();
			
			
			System.out.println("Enter Salary:");
			int sal = sc.nextInt();
			
			
			System.out.println("Enter Name:");
			String name = sc.next();

			pst.setInt(1, empid);
			pst.setString(2, name);
			pst.setInt(3, sal);

			pst.executeUpdate();                 // PreparedStatement JDBC executed


			ResultSet rs= stmt.executeQuery("SELECT * FROM emp");
			System.out.println("Details of Employees:");
			while(rs.next()){
				System.out.print(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("salary"));
				System.out.println();
			}
				               

			pst.close();

			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
