package muleSoftInternship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void createNewTable() {
		// SQLite connection string
		String url = "jdbc:sqlite:C://sqlite/MoviesCollection.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS movies (\n" + " id integer PRIMARY KEY,\n" + " name text NOT NULL,\n"
				+ " actor text NOT NULL,\n" + " actress text NOT NULL,\n" + " director text NOT NULL,\n"
				+ " year integer\n" + ");";

		try {
			Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		createNewTable();
	}

}