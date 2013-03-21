package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.IOrderDAO;
import ua.kpi.carrentals.entities.Order;
/**
 * UpdateCommand class is the ICommand interface
 * implementation. The execution of this command update all information about order.
 * This command realizes redirection to the index page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class UpdateOrderCommand implements ICommand {
	private static Logger logger=Logger.getLogger(UpdateOrderCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page;
		Order order=new Order();
		DAOFactory factory = DAOFactory.getDAOFactory();
		IOrderDAO orderDAO = factory.getOrderDAO();
		order.setIdOrder(Integer.parseInt(request.getParameter("idorder")));
		order.setStateOrder(Boolean.parseBoolean(request.getParameter("stateorder")));
		order.setOrderExecuted(Boolean.parseBoolean(request.getParameter("orderexecuted")));
		order.setDescription(request.getParameter("description"));
		order.setDescriptionDamage(request.getParameter("descriptiondamage"));
		orderDAO.updateOrder(order);
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String message=langConfig.getText(LocaleConfig.MESSAGE_ORDER_CHANGE);
		request.setAttribute("message", message);

		logger.info("Order was change by administrator");
		logger.info("Redirection to the message page");
		
		page = PagePath.getInstance().getPage(PagePath.MESSAGE_PAGE_PATH);
		return page;
	}

}
