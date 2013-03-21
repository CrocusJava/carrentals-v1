package ua.kpi.carrentals.dao.entitiesinterface;

import ua.kpi.carrentals.entities.User;
/**
 * IUserDAO interface is used to realize DAO. Class 
 * that implement this interface should implement all methods.
 *
 * @author Tkachuk
 */
public interface IUserDAO {
	public User checkUserLogin(String login, String password);
	public User getUser(Integer idUser);
	public void createUser(User user);
	public void updateUser(User user);

}
