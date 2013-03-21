package ua.kpi.carrentals.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * Order class is entity that describe all fields that belong order
 * 
 * @author Tkachuk
 */
public class Order implements Serializable {
	protected Integer idOrder;
	protected Integer idClient;
	protected Integer idCar;
	protected Integer idPlaceGet;
	protected Integer idPleceReturn;
	protected Date dateGet;
	protected Date dateReturn;
	protected boolean stateOrder;
	protected String description;
	protected boolean orderExecuted;
	protected String descriptionDamage;
	
	/**
     * Constructor creates Order with undefined field values
     */
	public Order(){
		
	}
	/**
     * Constructor creates Client with specified field values
     *
     * @param idOrder order id
     * @param idClient client id
     * @param idCar car id
     * @param idPlaceGet place get id
     * @param idPleceReturn place return id
     * @param dateGet date get
     * @param dateReturn date return
     * @param stateOrder order state
     * @param description order description in case deviation
     * @param orderExecuted order executed
     * @param descriptionDamage description damage
     * 
     */
	public Order(Integer idOrder, Integer idClient, Integer idCar, Integer idPlaceGet,
			Integer idPleceReturn, Date dateGet, Date dateReturn,
			boolean stateOrder, String description, boolean orderExecuted, String descriptionDamage) {

		this.idOrder = idOrder;
		this.idClient = idClient;
		this.idCar = idCar;
		this.idPlaceGet = idPlaceGet;
		this.idPleceReturn = idPleceReturn;
		this.dateGet = dateGet;
		this.dateReturn = dateReturn;
		this.stateOrder = stateOrder;
		this.description = description;
		this.orderExecuted = orderExecuted;
		this.descriptionDamage = descriptionDamage;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public int getIdCar() {
		return idCar;
	}

	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}

	public int getIdPlaceGet() {
		return idPlaceGet;
	}

	public void setIdPlaceGet(Integer idPlaceGet) {
		this.idPlaceGet = idPlaceGet;
	}

	public int getIdPleceReturn() {
		return idPleceReturn;
	}

	public void setIdPleceReturn(Integer idPleceReturn) {
		this.idPleceReturn = idPleceReturn;
	}

	public Date getDateGet() {
		return dateGet;
	}

	public void setDateGet(Date dateGet) {
		this.dateGet = dateGet;
	}

	public Date getDateReturn() {
		return dateReturn;
	}

	public void setDateReturn(Date dateReturn) {
		this.dateReturn = dateReturn;
	}

	public boolean isStateOrder() {
		return stateOrder;
	}

	public void setStateOrder(boolean stateOrder) {
		this.stateOrder = stateOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isOrderExecuted() {
		return orderExecuted;
	}

	public void setOrderExecuted(boolean orderExecuted) {
		this.orderExecuted = orderExecuted;
	}

	public String getDescriptionDamage() {
		return descriptionDamage;
	}

	public void setDescriptionDamage(String descriptionDamage) {
		this.descriptionDamage = descriptionDamage;
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID Ored=").append(idOrder);
		desc.append("\nID Client=").append(idClient);
		desc.append("\nID Car=").append(idCar);
		desc.append("\nID Place get=").append(idPlaceGet);
		desc.append("\nID Place return=").append(idPleceReturn);
		desc.append("\nState order=").append(stateOrder);
		return desc.toString();
	}

}
