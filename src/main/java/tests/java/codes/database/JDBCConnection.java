package tests.java.codes.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCConnection {
	
	private Connection connectionJDBC;
	
	public Connection connect() {
		try {
			Class.forName("org.postgresql.Driver");
			connectionJDBC = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tests", "postgres", "postgres");
			System.out.println("Connected to postgres database successfully");
		} catch (SQLException | ClassNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
		return connectionJDBC;
	}
	
	public void saveLines(List<String> lines) {
		Connection connection = null;
		for (String line : lines) {
			try {
				connection = this.connect();
				PreparedStatement statement = connection.prepareStatement("insert into tbl_budget (description) values (?);");
				statement.setString(1, line);
				statement.execute();
				System.out.println("line " + line + "saved with success");
			} catch (SQLException sqlException) {
				throw new RuntimeException(sqlException.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException exception) {
					System.out.println("Error while closing connection");
				}
			}
		}
	}
	
	public void saveAccount(String account) {
		
		
	}

	public void saveClassification(String classification) {
		
	}
	
}
