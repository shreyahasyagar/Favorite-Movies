package muleSoftInternship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

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

	public void insert(String name, String actor, String actress, String director, int year) {
		String sql = "INSERT INTO movies(name, actor,actress,director,year) VALUES(?,?,?,?,?)";

		try {
			Connection conn = this.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, actor);
			pstmt.setString(3, actress);
			pstmt.setString(4, director);
			pstmt.setInt(5, year);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		InsertRecords app = new InsertRecords();
		// insert three new rows
		app.insert("The Notebook", "Ryan Gosling", "Rachel McAdams", "Nick Cassavetes", 2004);
		app.insert("Titanic", "Leonardo DiCaprio", " Kate Winslet", "James Cameron", 1997);
		app.insert("Rocky", "Sylvester Stallone", "Talia Shire", "John G. Avildsen", 1976);
		app.insert("Spider-Man: Far from Home", "Tom Holland", "Zendaya", "Jon Watts", 2019);
		app.insert("Avengers: Endgame", "Robert Downey Jr.", "Scarlett Johansson", "Anthony Russo", 2019);
	}

}