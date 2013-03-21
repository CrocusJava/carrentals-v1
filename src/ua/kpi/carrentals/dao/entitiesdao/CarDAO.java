package ua.kpi.carrentals.dao.entitiesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.connection.PoolConnection;
import ua.kpi.carrentals.dao.entitiesinterface.ICarDAO;
import ua.kpi.carrentals.entities.Car;
import ua.kpi.carrentals.entities.enums.EClassCar;
import ua.kpi.carrentals.entities.enums.ETypeCar;
/**
 * CarDAO class is the ICarDAO interface implementation. 
 * 
 * @author Tkachuk
 * @see ICarDAO
 */
public class CarDAO implements ICarDAO {
	private static Logger logger=Logger.getLogger(CarDAO.class);
	
	private Car getCar(ResultSet resultSet) {
		Car car = new Car();
		try {
			car.setIdCar(resultSet.getInt("idcar"));
			car.setIdPlace(resultSet.getInt("idplace"));
			car.setPhoto(resultSet.getString("photo"));
			car.setPrice(resultSet.getInt("price"));
			car.setCarNumber(resultSet.getString("carnumber"));
			car.setCarBodyType(ETypeCar.valueOf(resultSet
					.getString("carbodytype")));
			car.setBrand(resultSet.getString("brand"));
			car.setModel(resultSet.getString("model"));
			car.setColor(resultSet.getString("color"));
			car.setClassCar(EClassCar.valueOf(resultSet.getString("class")));
			car.setTransmission(resultSet.getString("transmission"));
			car.setQuantitySeats(resultSet.getInt("quantityseats"));
			car.setQuantityDoors(resultSet.getInt("quantitydoors"));
			if (resultSet.getInt("conditioner") == 0) {
				car.setConditioner(false);
			} else
				car.setConditioner(true);
			car.setDescription(resultSet.getString("description"));
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public Car getCar(Integer idCar) {
		
		logger.info("Get car by id");
		
		Car car = new Car();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM car WHERE idcar=?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, idCar);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				car = getCar(resultSet);
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
		return car;
	}

	@Override
	public ArrayList<Car> getListCarSortedBy(String str) {

		logger.info("Get car list sorted by "+str);
		
		ArrayList<Car> listCar = new ArrayList<Car>();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM car ORDER BY ?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, str);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Car car = getCar(resultSet);
				listCar.add(car);
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
		return listCar;
	}
	
	@Override
	public ArrayList<Car> getSearchCarsSortedBy(String str, Integer idplace,
			Integer price) {

		logger.info("Get car list sorted by "+str+", where id place get "+idplace+" and price not more "+price);
		
		ArrayList<Car> listCar = new ArrayList<Car>();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM car WHERE idplace=? AND price<?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, idplace);
			preparedStatement.setInt(2, price);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Car car = getCar(resultSet);
				listCar.add(car);
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
		return listCar;
	}
}
