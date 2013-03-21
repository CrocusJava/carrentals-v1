package ua.kpi.carrentals.dao.entitiesdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.connection.PoolConnection;
import ua.kpi.carrentals.dao.entitiesinterface.IClientDAO;
import ua.kpi.carrentals.dao.entitiesinterface.IOrderDAO;
import ua.kpi.carrentals.entities.Order;
/**
 * OrderDAO class is the IOrderDAO interface implementation. 
 * 
 * @author Tkachuk
 * @see IClientDAO
 */
public class OrderDAO implements IOrderDAO {
	private static Logger logger=Logger.getLogger(OrderDAO.class);
	
	private Order getOrder(ResultSet resultSet) {
		Order order = new Order();
		try {
			order.setIdOrder(resultSet.getInt("idorder"));
			order.setIdClient(resultSet.getInt("idclient"));
			order.setIdCar(resultSet.getInt("idcar"));
			order.setIdPlaceGet(resultSet.getInt("idplaceget"));
			order.setIdPleceReturn(resultSet.getInt("idplacereturn"));
			order.setDateGet(resultSet.getDate("dateget"));
			order.setDateReturn(resultSet.getDate("datereturn"));
			if (resultSet.getInt("stateorder") == 0) {
				order.setStateOrder(false);
			} else{
				order.setStateOrder(true);
			}
			order.setDescription(resultSet.getString("description"));
			if (resultSet.getInt("orderexecuted") == 0) {
				order.setOrderExecuted(false);
			} else{
				order.setOrderExecuted(true);
			}
			order.setDescriptionDamage(resultSet.getString("descriptiondamage"));
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		}
		return order;
	}
	
	@Override
	public void createOrder(Order order) {

		logger.info("Create new order");
		
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String queryString = "INSERT INTO orderlist(idclient, idcar, idplaceget, idplacereturn, dateget, datereturn) VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, order.getIdClient());
			preparedStatement.setInt(2, order.getIdCar());
			preparedStatement.setInt(3, order.getIdPlaceGet());
			preparedStatement.setInt(4, order.getIdPleceReturn());
			preparedStatement.setDate(5, new Date((order.getDateGet()).getTime()));
			preparedStatement.setDate(6, new Date((order.getDateReturn()).getTime()));
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
	public ArrayList<Order> getListOrderSortedByID() {

		logger.info("Get list order sorted by ID");
		
		ArrayList<Order> listOrder = new ArrayList<Order>();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM orderlist ORDER BY idorder";
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order order = getOrder(resultSet);
				listOrder.add(order);
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
		return listOrder;
	}

	@Override
	public void updateOrder(Order order) {

		logger.info("Update order");
		
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String queryString = "UPDATE orderlist SET stateorder=?, orderexecuted=?, description=?, descriptiondamage=? WHERE idorder = ?";
			preparedStatement = connection.prepareStatement(queryString);
			if (!order.isStateOrder()) {
				preparedStatement.setInt(1, 0);
			} else{
				preparedStatement.setInt(1, 1);
			}
			if (!order.isOrderExecuted()) {
				preparedStatement.setInt(2, 0);
			} else{
				preparedStatement.setInt(2, 1);
			}
			preparedStatement.setString(3, order.getDescription());
			preparedStatement.setString(4, order.getDescriptionDamage());
			preparedStatement.setInt(5, order.getIdOrder());
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
