package ua.kpi.carrentals.dao.entitiesinterface;

import ua.kpi.carrentals.entities.Client;
/**
 * IClientDAO interface is used to realize DAO. Class 
 * that implement this interface should implement all methods.
 *
 * @author Tkachuk
 */
public interface IClientDAO {
	public Client getClient(Integer idUser);
	public void createClient(Client client);
	public void updateClient(Client client);
}
