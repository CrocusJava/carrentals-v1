package ua.kpi.carrentals.controller.commands;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.IClientDAO;
import ua.kpi.carrentals.dao.entitiesinterface.IUserDAO;
import ua.kpi.carrentals.entities.Client;
import ua.kpi.carrentals.entities.User;
/**
 * UpdateCommand class is the ICommand interface
 * implementation. The execution of this command update all information about user.
 * If user is a client that update client information, otherwise will be create new client.
 * This command realizes redirection to the index page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class UpdateCommand implements ICommand {
	private static Logger logger=Logger.getLogger(UpdateCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		LocaleConfig langConfig=LocaleConfig.getInstance();
		/**
		 * This method use Database Access Object
		 * to get user and client from database.
		 */
		DAOFactory factory = DAOFactory.getDAOFactory();
		IUserDAO userDAO = factory.getUserDAO();
		user = userDAO.checkUserLogin(login, password);
		/**
		 * if new login user is exists in database - show error page,
		 * otherwise change information.
		 */
		if (((user.getRole()).equals("user") || (user.getRole()).equals("admin"))
				&& (!(user.getId()).equals((Integer) request.getSession().getAttribute("ID")))) {
			String messageError=langConfig.getText(LocaleConfig.MESSAGE_ERROR_USER);

			logger.info("Error. User update profile. User with this login already exists");
			
			request.setAttribute("message", messageError);
		} else {
			user.setId((Integer) request.getSession().getAttribute("ID"));
			user.setRole((String) request.getSession().getAttribute("role"));
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setMiddlename(request.getParameter("middlename"));
			user.setEmail(request.getParameter("email"));
			userDAO.updateUser(user);
			if (!(request.getSession().getAttribute("role")).equals("admin")) {
				IClientDAO clientDAO = factory.getClientDAO();
				Client client = new Client();
				try{
					client.setIdUser((Integer) request.getSession().getAttribute("ID"));
					client.setPassportseries(request.getParameter("passportseries"));
					client.setPassportnumber(Integer.parseInt(request.getParameter("passportnumber")));
					client.setPhonenumber(Integer.parseInt(request.getParameter("phonenumber")));
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					try {
						client.setBirthday(dateFormat.parse(request.getParameter("birthday")));
					} catch (ParseException e) {
						logger.error("Parse exception. Birthday", e);
						e.printStackTrace();
					}
					if ((request.getParameter("idClient")).equals("null")) {
						clientDAO.createClient(client);
					
						logger.info("Create new client");
					} else {
						clientDAO.updateClient(client);
						
						logger.info("Update client");
					}
					} catch (RuntimeException e){
					
						logger.info("Runtime exception",e);
					
						String messageNotUpdate=langConfig.getText(LocaleConfig.MESSAGE_FIELDS);
						request.setAttribute("message", messageNotUpdate);
						String page = PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
						return page;
					}
			}
		}
		String messageUpdate=langConfig.getText(LocaleConfig.MESSAGE_UPDATE_PROFILE);
		request.setAttribute("message", messageUpdate);
		
		logger.info("Redirection to the message page");
		
		String page = PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
		return page;
	}

}
