package tests.java.codes.apps;

import tests.java.codes.database.JDBCConnection;
import tests.java.codes.io.ImportUtil;

public class ClassifyTests {

	public static void main(String[] args) {
		
		ImportUtil importUtil = new ImportUtil();
		importUtil.importToDatabase("C:\\temp\\stations-fixed-width.txt");
//		
//		JDBCConnection jdbcConnection = new JDBCConnection();
//		jdbcConnection.connect();
		
	}
	
}
