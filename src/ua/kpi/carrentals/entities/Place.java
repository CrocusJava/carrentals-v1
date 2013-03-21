package ua.kpi.carrentals.entities;

import java.io.Serializable;
/**
 * Place class is entity that describe place where user can get and return car
 * 
 * @author Tkachuk
 */
public class Place implements Serializable {
	protected Integer idPlace;
	protected String city;
	protected String descriptionPlace;
	
	/**
     * Constructor creates Place with undefined field values
     */
	public Place(){
		
	}
	/**
     * Constructor creates Car with specified field values
     *
     * @param idPlace place id
     * @param city city
     * @param descriptionPlace description place
     */
	public Place(Integer idPlace, String city, String descriptionPlace) {
		this.idPlace = idPlace;
		this.city = city;
		this.descriptionPlace = descriptionPlace;
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescriptionPlace() {
		return descriptionPlace;
	}

	public void setDescriptionPlace(String descriptionPlace) {
		this.descriptionPlace = descriptionPlace;
	}
	
	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID Place=").append(idPlace);
		desc.append("\nCity=").append(city);
		desc.append("\nDescription=").append(descriptionPlace);
		return desc.toString();
	}
}
