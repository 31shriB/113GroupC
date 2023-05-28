

	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.CallableStatement;

	public class AdminConn {
	    public static void main(String[] args) {
	        // Database credentials
	        String url = "jdbc:mysql://localhost:3306/DB"; // Replace "mydatabase" with your database name
	        String username = "local_host"; // Replace with your MySQL username
	        String password = "mysql@123456"; // Replace with your MySQL password

	        // Connection and statement objects
	        Connection connection = null;
	        CallableStatement callableStatement = null;

	        try {
	            // Register the JDBC driver
	            Class.forName("com.mysql.jdbc.Driver");

	            // Create a connection to the database
	            connection = DriverManager.getConnection(url, username, password);

	            // Call the stored procedure
	            String procedureCall = "{CALL CopyStudentsToAdmin()}";
	            callableStatement = connection.prepareCall(procedureCall);
	            callableStatement.execute();

	            System.out.println("Stored procedure executed successfully.");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            // Close all resources
	            try {
	                if (callableStatement != null) {
	                    callableStatement.close();
	                }
	                if (connection != null) {
	                    connection.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }



}
