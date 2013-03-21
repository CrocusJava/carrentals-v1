package ua.kpi.carrentals.dao;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.dao.entitiesdao.CarDAO;
import ua.kpi.carrentals.dao.entitiesdao.ClientDAO;
import ua.kpi.carrentals.dao.entitiesdao.OrderDAO;
import ua.kpi.carrentals.dao.entitiesdao.PlaceDAO;
import ua.kpi.carrentals.dao.entitiesdao.UserDAO;
/**
 * DAOMySQL class extends DAOFactory abstract class
 * and override all abstract method.
 * 
 * @author Tkachuk
 */
public class DAOMySQL extends DAOFactory {
	private static Logger logger=Logger.getLogger(DAOMySQL.class);
	
	@Override
	public CarDAO getCarDAO() {
		logger.info("Create new car DAO");
		return new CarDAO();
	}

	@Override
	public ClientDAO getClientDAO() {
		logger.info("Create new client DAO");
		return new ClientDAO();
	}

	@Override
	public OrderDAO getOrderDAO() {
		logger.info("Create new order DAO");
		return new OrderDAO();
	}

	@Override
	public PlaceDAO getPlaceDAO() {
		logger.info("Create new place DAO");
		return new PlaceDAO();
	}

	@Override
	public UserDAO getUserDAO() {
		logger.info("Create new user DAO");
		return new UserDAO();
	}
}
