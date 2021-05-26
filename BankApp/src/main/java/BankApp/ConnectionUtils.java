package BankApp;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class ConnectionUtils {
	 public static Connection getConnection() throws SQLException
	   {
		   try
		   {
			   Class.forName("org.postgresql.Driver");
		   }
		   catch(ClassNotFoundException e)
		   {
			   e.getStackTrace();
		   }
		   String url="";
		   String username="";
		   String password="";
		   try {
			FileInputStream file=new FileInputStream("../BankApp/src/test/resources/PropertyFile.properties");
			Properties prop=new Properties();
			prop.load(file);
			url=prop.getProperty("DB_Url");
			username=prop.getProperty("DB_Username");
			password=prop.getProperty("DB_Password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return DriverManager.getConnection(url, username, password);
	   }
}
