package muleSoftInternship;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create {

	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:/sqlite/" + fileName;
		//create the required database

		try {
			Connection conn = DriverManager.getConnection(url);
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		createNewDatabase("MoviesCollection.db");
	}
}
