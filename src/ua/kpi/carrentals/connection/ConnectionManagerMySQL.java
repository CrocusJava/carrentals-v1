package ua.kpi.carrentals.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
/**
 * ConnectionManagerMySQL class realizes connection to database using Singleton 
 * pattern. The ConnectionManagerMySQL get all connection parameters from resource bundle.
 * 
 * @author Tkachuk
 */
public class ConnectionManagerMySQL {
	private static Logger logger=Logger.getLogger(ConnectionManagerMySQL.class);
	
	private static ConnectionManagerMySQL instance;
	private static Connection connection;
	private static ResourceBundle resource;
	// The name of the properties file
	private static final String FILE_PROPERTIES = "ua.kpi.carrentals.propertiefiles.database";
	// Databases properties specifies keys
	private static final String DB_DRIVER = "DB_DRIVER";
	private static final String DB_URL = "DB_URL";
	private static final String DB_USER = "DB_USER";
	private static final String DB_PASSWORD = "DB_PASSWORD";

	private ConnectionManagerMySQL() {
		resource = ResourceBundle.getBundle(FILE_PROPERTIES);
		logger.info("Create new instance. Resource bundle complete");
	}

	public static synchronized ConnectionManagerMySQL getInstance() {
		if (instance == null) {
			instance = new ConnectionManagerMySQL();
			
		}
		return instance;
	}

	public  synchronized Connection getConnection() {
		String driver = resource.getString(DB_DRIVER);
		String url = resource.getString(DB_URL);
		String user = resource.getString(DB_USER);
		String password = resource.getString(DB_PASSWORD);
		try {
			Class.forName(driver);
			logger.info("Registered JDBC driver ");
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Create new coonection");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
