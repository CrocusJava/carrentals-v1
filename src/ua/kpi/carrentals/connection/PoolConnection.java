package ua.kpi.carrentals.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * PoolConnection class realizes connection pool using Singleton 
 * pattern. The PoolConnection has defined limit of connections.
 * 
 * @author Tkachuk
 */
public class PoolConnection {
	private static Logger logger=Logger.getLogger(PoolConnection.class);
	
	// the maximum number of connections in the pool
	private int maxSize;
	private static PoolConnection instance;
	private List<Connection> poolConnection;

	private PoolConnection(){
		maxSize=30;
		poolConnection=new ArrayList<Connection>();
		logger.info("Create new instance with maxsize pool: "+maxSize);
	}
	
	public static synchronized PoolConnection getInstance(){
		if (instance==null){
			instance= new PoolConnection();
		}
		return instance;
	}
		
	public synchronized Connection getConnection(){
		Connection connection=null;
		if (!poolConnection.isEmpty()){
			connection=poolConnection.get(poolConnection.size()-1);
			poolConnection.remove(connection);
		}else {
			connection=ConnectionManagerMySQL.getInstance().getConnection();
		}
		logger.info("Get new connection");
		return connection;
	}
	/**
	 * Method freeConnection returns free connection in the pool if pool isn't full,
	 * otherwise connection will close
	 *
	 */
	public synchronized void freeConnection(Connection connection){
		if ((connection!=null) && (poolConnection.size()<=maxSize)){
			poolConnection.add(connection);
			logger.info("Connection was return to pool");
		} else
			try {
				connection.close();
				logger.info("Size pool more than max size. Connection closed");
			} catch (SQLException e) {
				logger.error("SQL Exception. Problem connection to close", e);
				e.printStackTrace();
			}
	}

}
