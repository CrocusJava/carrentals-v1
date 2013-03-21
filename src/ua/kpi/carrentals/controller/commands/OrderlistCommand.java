package ua.kpi.carrentals.controller.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.IOrderDAO;
import ua.kpi.carrentals.entities.Order;
/**
 * OrderlistCommand class is the ICommand interface implementation. This command
 * realizes redirection to the orders list page. The execution of this command
 * reads all orders from database sorted by id and sets a result page
 * as orders list page.
 * 
 * @author Tkachuk
 * @see ICommand
 */
public class OrderlistCommand implements ICommand{
	private static Logger logger=Logger.getLogger(OrderlistCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method use Database Access Object to get list cars from database
		 */
		DAOFactory factory = DAOFactory.getDAOFactory();
		IOrderDAO orderDAO = factory.getOrderDAO();
		ArrayList<Order> listOrder = orderDAO.getListOrderSortedByID();
		request.setAttribute("orders", listOrder);
		
		logger.info("Redirection to the order list page for Administrator");
		
		String page=PagePath.getInstance().getPage(PagePath.ORDERLIST_PAGE_PATH);
		return page;
	}

}
