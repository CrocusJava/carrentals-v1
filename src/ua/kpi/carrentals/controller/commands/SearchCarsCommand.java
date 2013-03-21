package ua.kpi.carrentals.controller.commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.dao.DAOFactory;
import ua.kpi.carrentals.dao.entitiesinterface.ICarDAO;
import ua.kpi.carrentals.entities.Car;
/**
 * SearchCarsCommand class is the ICommand interface
 * implementation. The execution of this command show information about cars that
 * matches the input parameters. This command realizes redirection to the cars list page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class SearchCarsCommand implements ICommand{
	private static Logger logger=Logger.getLogger(SearchCarsCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method use Database Access Object
		 * to get cars that matches place get and price.
		 */
		DAOFactory factory=DAOFactory.getDAOFactory();
		ICarDAO carDAO=factory.getCarDAO();
		String idplace = request.getParameter("idplaceget");
		Integer numberIdPlace = Integer.parseInt(idplace);
        String price = request.getParameter("pricenotmore");
        Integer numberPrice = Integer.parseInt(price);
        ArrayList<Car> listCars=carDAO.getSearchCarsSortedBy("price", numberIdPlace, numberPrice);
		Car [] cars=new Car[listCars.size()];
		cars=listCars.toArray(cars);
		request.setAttribute("cars", cars);

		logger.info("Redirection to the cars list from search page");
		
		String page=PagePath.getInstance().getPage(PagePath.CARS_PAGE_PATH);
		return page;
	}

}
