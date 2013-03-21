package ua.kpi.carrentals.dao.entitiesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.connection.PoolConnection;
import ua.kpi.carrentals.dao.entitiesinterface.IUserDAO;
import ua.kpi.carrentals.entities.User;
/**
 * UserDAO class is the IUserDAO interface implementation. 
 * 
 * @author Tkachuk
 * @see IUserDAO
 */
public class UserDAO implements IUserDAO {
	private static Logger logger=Logger.getLogger(UserDAO.class);
	
	private User getUser(ResultSet resultSet) {
		User user = new User();
		try {
			user.setId(resultSet.getInt("iduser"));
			user.setLogin(resultSet.getString("login"));
			user.setPassword(resultSet.getString("password"));
			user.setName(resultSet.getString("name"));
			user.setSurname(resultSet.getString("surname"));
			user.setMiddlename(resultSet.getString("middlename"));
			user.setEmail(resultSet.getString("email"));
			user.setRole(resultSet.getString("role"));
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User checkUserLogin(String login, String password) {

		logger.info("Check user login and password");
		
		User user = new User();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM user WHERE login = ? AND password = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = getUser(resultSet);
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
		return user;
	}
	
	@Override
	public User getUser(Integer idUser) {

		logger.info("Get user by ID");
		
		User user = new User();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM user WHERE iduser = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, idUser);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = getUser(resultSet);
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
		return user;
	}

	@Override
	public void createUser(User user) {

		logger.info("Create user");
		
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String queryString = "INSERT INTO user(login, password, name, surname, middlename, email, role) VALUES(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getSurname());
			preparedStatement.setString(5, user.getMiddlename());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setString(7, user.getRole());
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
	public void updateUser(User user) {

		logger.info("Update user");
		
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String queryString = "UPDATE user SET login=?, password=?, name=?, surname=?, middlename=?, email=? WHERE iduser = ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getSurname());
			preparedStatement.setString(5, user.getMiddlename());
			preparedStatement.setString(6, user.getEmail());
			preparedStatement.setInt(7, user.getId());
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
