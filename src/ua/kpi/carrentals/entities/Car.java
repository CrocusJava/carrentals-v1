package ua.kpi.carrentals.entities;

import java.io.Serializable;

import ua.kpi.carrentals.entities.enums.EClassCar;
import ua.kpi.carrentals.entities.enums.ETypeCar;
/**
 * Car class is entity that describe all fields that belong car
 * 
 * @author Tkachuk
 */
public class Car implements Serializable {
	protected Integer idCar;
	protected Integer idPlace;
	protected String photo;
	protected Integer price;
	protected String carNumber;
	protected ETypeCar carBodyType;
	protected String brand;
	protected String model;
	protected String color;
	protected EClassCar classCar;
	protected String transmission;
	protected Integer quantitySeats;
	protected Integer quantityDoors;
	protected boolean conditioner;
	protected String description;
	
	/**
     * Constructor creates Car with undefined field values
     */
	public Car() {

	}
	
	/**
     * Constructor creates Car with specified field values
     *
     * @param idCar car id
     * @param idPlace place where car is located
     * @param photo car photo
     * @param price car price per day
     * @param carNumber car number
     * @param carBodyType car body type
     * @param brand car brand
     * @param model car model
     * @param color car color
     * @param classCar car class
     * @param transmission type of transmission
     * @param quantitySeats quantity seats
     * @param quantityDoors quantity doors
     * @param conditioner conditioner
     * @param description information about car
     */
	public Car(Integer idCar, Integer idPlace, String photo, Integer price,
			String carNumber, ETypeCar carBodyType, String brand, String model,
			String color, EClassCar classCar, String transmission,
			Integer quantitySeats, Integer quantityDoors, boolean conditioner,
			String description) {
		this.idCar = idCar;
		this.idPlace = idPlace;
		this.photo = photo;
		this.price = price;
		this.carNumber = carNumber;
		this.carBodyType = carBodyType;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.classCar = classCar;
		this.transmission = transmission;
		this.quantitySeats = quantitySeats;
		this.quantityDoors = quantityDoors;
		this.conditioner = conditioner;
		this.description = description;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}

	public Integer getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(Integer idPlace) {
		this.idPlace = idPlace;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public ETypeCar getCarBodyType() {
		return carBodyType;
	}

	public void setCarBodyType(ETypeCar carBodyType) {
		this.carBodyType = carBodyType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public EClassCar getClassCar() {
		return classCar;
	}

	public void setClassCar(EClassCar classCar) {
		this.classCar = classCar;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public int getQuantitySeats() {
		return quantitySeats;
	}

	public void setQuantitySeats(Integer quantitySeats) {
		this.quantitySeats = quantitySeats;
	}

	public int getQuantityDoors() {
		return quantityDoors;
	}

	public void setQuantityDoors(Integer quantityDoors) {
		this.quantityDoors = quantityDoors;
	}

	public boolean isConditioner() {
		return conditioner;
	}

	public void setConditioner(boolean conditioner) {
		this.conditioner = conditioner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("\nBrand=").append(brand);
		desc.append("\nModel=").append(model);
		desc.append("\nCar number=").append(carNumber);
		return desc.toString();
	}

}
