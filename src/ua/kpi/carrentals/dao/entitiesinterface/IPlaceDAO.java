package ua.kpi.carrentals.dao.entitiesinterface;

import java.util.ArrayList;

import ua.kpi.carrentals.entities.Place;
/**
 * IPlaceDAO interface is used to realize DAO. Class 
 * that implement this interface should implement all methods.
 *
 * @author Tkachuk
 */
public interface IPlaceDAO {
	public Place getPlace(Integer idPlace);
	public ArrayList<Place> getListPlaceSortedByCity();
}
