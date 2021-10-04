package muleSoftInternship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRecords {

	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:C://sqlite/MoviesCollection.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void selectAll() {
		String sql = "SELECT * FROM movies";

		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("actor") + "\t"
						+ rs.getString("actress") + "\t" + rs.getString("director") + "\t" + rs.getInt("year"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void actorMovies(String actname) {
		String sql1 = "SELECT name FROM movies WHERE actor = actname ";

		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(sql1);

			// loop through the result set
			while (rs1.next()) {
				System.out.println(rs1.getInt("id") + "\t" + rs1.getString("name") + "\t" + rs1.getString("actor"));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		SelectRecords app = new SelectRecords();
		app.selectAll();
		app.actorMovies("Ryan Gosling");
	}
}
