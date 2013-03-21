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
import ua.kpi.carrentals.dao.entitiesinterface.IOrderDAO;
import ua.kpi.carrentals.entities.Client;
import ua.kpi.carrentals.entities.Order;
/**
 * MakeOrderCommand class is the ICommand interface
 * implementation. The execution of this command to create order in the database.
 * Besides if user isn't client will create new client. This command realizes
 * redirection to the index page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class MakeOrderCommand implements ICommand{
	private static Logger logger=Logger.getLogger(MakeOrderCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Order order=new Order();
		LocaleConfig langConfig=LocaleConfig.getInstance();
		/**
		 * This method use Database Access Object to get list cars from database
		 */
		DAOFactory factory = DAOFactory.getDAOFactory();
		IOrderDAO orderDAO = factory.getOrderDAO();
		order.setIdCar(Integer.parseInt(request.getParameter("idcar")));
		order.setIdPlaceGet(Integer.parseInt(request.getParameter("idplaceget")));
		order.setIdPleceReturn(Integer.parseInt(request.getParameter("idplacereturn")));
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			order.setDateGet(dateFormat.parse(request.getParameter("dateget")));
			order.setDateReturn(dateFormat.parse(request.getParameter("datereturn")));
		} catch (ParseException e) {
			logger.error("Parse exception. Date", e);
			e.printStackTrace();
		}
		if ((request.getParameter("idclient")).equals("null")){
			
			try{
				IClientDAO clientDAO = factory.getClientDAO();
				Client client=new Client();
				client.setIdUser((Integer) request.getSession().getAttribute("ID"));
				client.setPassportseries(request.getParameter("passportseries"));
				client.setPassportnumber(Integer.parseInt(request.getParameter("passportnumber")));
				client.setPhonenumber(Integer.parseInt(request.getParameter("phonenumber")));
				try {
					client.setBirthday(dateFormat.parse(request.getParameter("birthday")));
				} catch (ParseException e) {
					logger.error("Parse exception. Birthday", e);
					e.printStackTrace();
				}
				
				clientDAO.createClient(client);
				client=clientDAO.getClient((Integer) request.getSession().getAttribute("ID"));
				order.setIdClient(client.getIdClient());
				
				
			} catch (RuntimeException e){
				
				logger.info("Runtime exception",e);
			
				String messageNotUpdate=langConfig.getText(LocaleConfig.MESSAGE_FIELDS);
				request.setAttribute("message", messageNotUpdate);
				String page = PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
				return page;
			}
			
		} else {
			order.setIdClient(Integer.parseInt(request.getParameter("idclient")));
		}
		orderDAO.createOrder(order);
		
		String message=langConfig.getText(LocaleConfig.MESSAGE_ORDER_WAS_CREATE);
		request.setAttribute("message", message);
		
		logger.info("Redirection to the message page");
		
		String page=PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
		return page;
	}

}
