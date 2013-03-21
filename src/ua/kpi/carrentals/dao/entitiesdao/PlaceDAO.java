package ua.kpi.carrentals.dao.entitiesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.connection.PoolConnection;
import ua.kpi.carrentals.dao.entitiesinterface.IPlaceDAO;
import ua.kpi.carrentals.entities.Place;
/**
 * PlaceDAO class is the IPlaceDAO interface implementation. 
 * 
 * @author Tkachuk
 * @see IPlaceDAO
 */
public class PlaceDAO implements IPlaceDAO {
	private static Logger logger=Logger.getLogger(PlaceDAO.class);
	
	private Place getPlace(ResultSet resultSet) {
		Place place = new Place();
		try {
			place.setIdPlace(resultSet.getInt("idplace"));
			place.setCity(resultSet.getString("city"));
			place.setDescriptionPlace(resultSet.getString("descriptionplace"));
		} catch (SQLException e) {
			logger.error("SQL exception", e);
			e.printStackTrace();
		}
		return place;
	}

	@Override
	public Place getPlace(Integer idPlace) {

		logger.info("Get place by ID");
		
		Place place = new Place();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM place WHERE idplace=?";
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, idPlace);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				place = getPlace(resultSet);
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
		return place;
	}

	@Override
	public ArrayList<Place> getListPlaceSortedByCity() {

		logger.info("Get place list sorted by ID");
		
		ArrayList<Place> listPlace = new ArrayList<Place>();
		PoolConnection poolConnection = PoolConnection.getInstance();
		Connection connection = poolConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String queryString = "SELECT * FROM place ORDER BY city";
			preparedStatement = connection.prepareStatement(queryString);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Place place = getPlace(resultSet);
				listPlace.add(place);
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
		return listPlace;
	}
}
