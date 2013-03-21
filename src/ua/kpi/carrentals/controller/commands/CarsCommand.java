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
 * CarsCommand class is the ICommand interface implementation. This command
 * realizes redirection to the cars list page. The execution of this command
 * reads all cars from database sorted by price per day and sets a result page
 * as cars list page.
 * 
 * @author Tkachuk
 * @see ICommand
 */
public class CarsCommand implements ICommand {
	private static Logger logger=Logger.getLogger(CarsCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method use Database Access Object to get list cars from database
		 */
		DAOFactory factory = DAOFactory.getDAOFactory();
		ICarDAO carDAO = factory.getCarDAO();
		
		ArrayList<Car> listCars=carDAO.getListCarSortedBy("price");
		Car [] cars=new Car[listCars.size()];
		cars=listCars.toArray(cars);
		request.setAttribute("cars", cars);
		
		logger.info("Redirection to the list cars page");
		
		String page = PagePath.getInstance().getPage(PagePath.CARS_PAGE_PATH);
		return page;
	}

}
