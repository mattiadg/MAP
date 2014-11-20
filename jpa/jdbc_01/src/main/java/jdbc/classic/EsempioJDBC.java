package jdbc.classic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EsempioJDBC {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/commerce";

	static final String USER = "root";
	static final String PASS = "password";

	public static void main(String[] args) {
		Connection conn = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			// stmt.execute("INSERT INTO Utente (nome) VALUES ('elisa')");

			PreparedStatement pp = conn
					.prepareStatement("INSERT INTO Utente (nome) VALUES (?)");

			String[] nomi = { "pippo", "pluto", "ettore" };

			for (String nome : nomi) {
				pp.setString(1, nome);
				pp.execute();
			}

			ResultSet rs = stmt.executeQuery("SELECT * FROM Utente");
			while (rs.next()) {
				int id = rs.getInt("idUtente");
				String nome = rs.getString("nome");
				System.out.println("id:" + id + "\tnome:" + nome);
			}
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Fine!");
	}
}