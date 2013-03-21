package ua.kpi.carrentals.dao.entitiesinterface;

import java.util.ArrayList;

import ua.kpi.carrentals.entities.Order;
/**
 * IOrderDAO interface is used to realize DAO. Class 
 * that implement this interface should implement all methods.
 *
 * @author Tkachuk
 */
public interface IOrderDAO {
	public void createOrder(Order order);
	public ArrayList<Order> getListOrderSortedByID();
	public void updateOrder(Order order);
	
	
}
