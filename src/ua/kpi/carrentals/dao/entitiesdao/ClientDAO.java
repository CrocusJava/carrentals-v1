package ua.kpi.carrentals.dao.entitiesdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.connection.PoolConnection;
import ua.kpi.carrentals.dao.entitiesinterface.IClientDAO;
import ua.kpi.carrentals.entities.Client;
/**
 * ClientDAO class is the IClientDAO interface implementation. 
 * 
 * @author Tkachuk
 * @see IClientDAO
 */
public class ClientDAO implements IClientDAO{
	private static Logger logger=Logger.getLogger(ClientDAO.class);
	
	private Client getClient(ResultSet resultSet) {
		Client client=new Client();
		try {
			client.setIdClient(resultSet.getInt("idclient"));
			client.setIdUser(resultSet.getInt("iduser"));
			client.setBirthday(resultSet.getDate("birthday"));
			client.setPassportseries(resultSet.getString("passportseries"));
			client.setPassportnumber(resultSet.getInt("passportnumber"));
			client.setPhonenumber(resultSet.getInt("phonenumber"));
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		} 
		return client;
	}

	@Override
	public Client getClient(Integer idUser) {

		logger.info("Get client by user id");
		
		Client client=new Client();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM client WHERE iduser=?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				client=getClient(resultSet);
			}
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					poolConnection.freeConnection(connection);
				}
			} catch (SQLException e) {
				logger.error("SQL exception", e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error("Exception", e);
				e.printStackTrace();
			}
		}
		return client; 
	}
	
	@Override
	public void createClient(Client client) {

		logger.info("Get client");
		
		PoolConnection poolConnection=PoolConnection.getInstance();
		Connection connection=poolConnection.getConnection(); 
		PreparedStatement preparedStatement=null;
		try {
			String queryString = "INSERT INTO client(iduser, birthday, passportseries, passportnumber, phonenumber) VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, client.getIdUser());
			preparedStatement.setDate(2, new Date((client.getBirthday()).getTime()));
			preparedStatement.setString(3, client.getPassportseries());
			preparedStatement.setInt(4, client.getPassportnumber());
			preparedStatement.setInt(5, client.getPhonenumber());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					poolConnection.freeConnection(connection);
				}
			} catch (SQLException e) {
				logger.error("SQL exception", e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error("Exception", e);
				e.printStackTrace();
			}

		}
	}
	
	@Override
	public void updateClient(Client client) {

		logger.info("Update client");
		
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String queryString = "UPDATE client SET birthday=?, passportseries=?, passportnumber=?, phonenumber=? WHERE iduser = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setDate(1, new Date((client.getBirthday()).getTime()));
			preparedStatement.setString(2, client.getPassportseries());
			preparedStatement.setInt(3, client.getPassportnumber());
			preparedStatement.setInt(4, client.getPhonenumber());
			preparedStatement.setInt(5, client.getIdUser());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					poolConnection.freeConnection(connection);
				}
			} catch (SQLException e) {
				logger.error("SQL exception", e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error("Exception", e);
				e.printStackTrace();
			}
		}		
	}

}
