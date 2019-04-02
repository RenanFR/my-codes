package tests.java.codes.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tests.java.codes.database.JDBCConnection;

public class ImportUtil {

	public void importToDatabase(String filePath) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)))) {
			List<String> lines = new ArrayList<>();
			String nextLine = bufferedReader.readLine();
			lines.add(nextLine);
			while (nextLine != null) {
				nextLine = bufferedReader.readLine();
				lines.add(nextLine);
			}
			JDBCConnection jdbcConnection = new JDBCConnection();
			jdbcConnection.saveLines(lines);
			bufferedReader.close();
		} catch (IOException ioException) {
			System.out.println("Error while reading the file");
		}
	}
	
}
