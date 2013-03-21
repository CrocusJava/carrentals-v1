package ua.kpi.carrentals.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * Client class is entity that describe personal information about user
 * 
 * @author Tkachuk
 */
public class Client implements Serializable {
	protected Integer idClient;
	protected Integer idUser;
	protected Date birthday;
	protected String passportseries;
	protected Integer passportnumber;
	protected Integer phonenumber;
	
	/**
     * Constructor creates Client with undefined field values
     */
	public Client() {

	}
	/**
     * Constructor creates Client with specified field values
     *
     * @param idClient client id
     * @param idUser user id
     * @param birthday client birthday
     * @param passportseries client passport series
     * @param passportnumber client passport number
     * @param phonenumber client phone number
     */
	public Client(Integer idClient, Integer idUser, Date birthday,
			String passportseries, Integer passportnumber, Integer phonenumber) {
		this.idClient = idClient;
		this.idUser = idUser;
		this.birthday = birthday;
		this.passportseries = passportseries;
		this.passportnumber = passportnumber;
		this.phonenumber = phonenumber;
	}
	
	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassportseries() {
		return passportseries;
	}

	public void setPassportseries(String passportseries) {
		this.passportseries = passportseries;
	}

	public Integer getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(Integer passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID Client=").append(idClient);
		desc.append("\nBirthday=").append(birthday);
		desc.append("\nPassport=").append(passportseries + " " + passportnumber);
		desc.append("\nPhone=").append(phonenumber);
		return desc.toString();
	}

}
