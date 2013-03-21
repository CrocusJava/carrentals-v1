package ua.kpi.carrentals.entities;

import java.io.Serializable;
/**
 * User class is entity that describe information about user
 * 
 * @author Tkachuk
 */
public class User implements Serializable{
	//set default role and id fields
	protected String role = "guest";
	protected Integer id = -1;
	protected String login;
	protected String password;
	protected String email;
	protected String name;
	protected String surname;
	protected String middlename;
	
	/**
     * Constructor creates User with undefined field values
     */
	public User() {
	}
	
	/**
     * Constructor creates User with specified field values
     *
     * @param role user role
     * @param id user id
     * @param login user login
     * @param password user password
     * @param email user email
     * @param name user name
     * @param surname user surname
     * @param middlename user middlename
     */
	public User(String role, String login, String password,
			String email, String name, String surname, String middlename) {
		this.role = role;
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.middlename = middlename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		StringBuilder desc = new StringBuilder();
		desc.append("ID User=").append(id);
		desc.append("\nLogin=").append(login);
		desc.append("\nPassword=").append(password);
		desc.append("\nRole=").append(role);
		desc.append("\nName=").append(name);
		desc.append("\nSurname=").append(surname);
		desc.append("\nMiddlename=").append(middlename);
		desc.append("\nEmail=").append(email);
		return desc.toString();
	}
}
