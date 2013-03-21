package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.IUserDAO;
import ua.kpi.carrentals.entities.User;
/**
 * RegistrationCommand class is the ICommand interface
 * implementation. The execution of this command create new user.
 * This command realizes redirection to the "hello" page or if user with
 * entered parameters is exists to the "error" page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class RegistrationCommand implements ICommand {
	private static Logger logger=Logger.getLogger(RegistrationCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page;
		/**
		 * This method use Database Access Object to create new use.
		 */
		DAOFactory factory=DAOFactory.getDAOFactory();
		IUserDAO userDAO=factory.getUserDAO();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String middlename = request.getParameter("middlename");
		String email = request.getParameter("email");
		User user=userDAO.checkUserLogin(login, password);
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String messageError=langConfig.getText(LocaleConfig.MESSAGE_ERROR_USER);
		String messageHello=langConfig.getText(LocaleConfig.MESSAGE_HELLO_USER);
		if ((user.getRole()).equals("guest")) {
			user = new User("user", login, password, email, name, surname, middlename);
			userDAO.createUser(user);
			logger.info("User was create");
			request.setAttribute("message", messageHello);
		} else {
			logger.info("User with this login already exists");
			request.setAttribute("message", messageError);
		}

		logger.info("Redirection to the message page");
				
		page = PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
		return page;
	}

}
