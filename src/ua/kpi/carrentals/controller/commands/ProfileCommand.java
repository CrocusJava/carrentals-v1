package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.IClientDAO;
import ua.kpi.carrentals.dao.entitiesinterface.IUserDAO;
import ua.kpi.carrentals.entities.Client;
import ua.kpi.carrentals.entities.User;
/**
 * ProfileCommand class is the ICommand interface
 * implementation. The execution of this command show all information about user from database.
 * This command realizes redirection to the profile page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class ProfileCommand implements ICommand{
	private static Logger logger=Logger.getLogger(ProfileCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method use Database Access Object to get user and client
		 * from database with parameters from session
		 */
		DAOFactory factory=DAOFactory.getDAOFactory();
		IUserDAO userDAO=factory.getUserDAO();
		User user=userDAO.getUser((Integer)request.getSession().getAttribute("ID"));
		request.setAttribute("user", user);
		IClientDAO clientDAO=factory.getClientDAO();
		Client client=clientDAO.getClient((Integer)request.getSession().getAttribute("ID"));
		request.setAttribute("client", client);
		
		logger.info("Redirection to the profile page");
		
		String page=PagePath.getInstance().getPage(PagePath.PROFILE_PAGE_PATH);
		return page;
	}

}
