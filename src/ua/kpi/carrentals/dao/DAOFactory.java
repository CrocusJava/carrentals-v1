package ua.kpi.carrentals.dao;

import ua.kpi.carrentals.dao.entitiesdao.CarDAO;
import ua.kpi.carrentals.dao.entitiesdao.ClientDAO;
import ua.kpi.carrentals.dao.entitiesdao.OrderDAO;
import ua.kpi.carrentals.dao.entitiesdao.PlaceDAO;
import ua.kpi.carrentals.dao.entitiesdao.UserDAO;
/**
 * DAOFactory abstract class using Factory pattern, the allows to create
 * object concrete entity.
 * 
 * @author Tkachuk
 */
public abstract class DAOFactory {
	public abstract CarDAO getCarDAO();
	public abstract ClientDAO getClientDAO();
	public abstract OrderDAO getOrderDAO();
	public abstract PlaceDAO getPlaceDAO();
	public abstract UserDAO getUserDAO();
	
	public static DAOMySQL getDAOFactory(){
		return new DAOMySQL();
	}
}
