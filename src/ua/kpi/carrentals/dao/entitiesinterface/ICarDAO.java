package ua.kpi.carrentals.dao.entitiesinterface;

import java.util.ArrayList;

import ua.kpi.carrentals.entities.Car;
/**
 * ICarDAO interface is used to realize DAO. Class 
 * that implement this interface should implement all methods.
 *
 * @author Tkachuk
 */
public interface ICarDAO {
	public Car getCar(Integer idCar);
	public ArrayList<Car> getListCarSortedBy(String str);
	public ArrayList<Car> getSearchCarsSortedBy(String str, Integer idplace, Integer price);
	
}
