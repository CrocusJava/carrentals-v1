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
import ua.kpi.carrentals.dao.entitiesinterface.IClientDAO;
import ua.kpi.carrentals.dao.entitiesinterface.IPlaceDAO;
import ua.kpi.carrentals.entities.Car;
import ua.kpi.carrentals.entities.Client;
import ua.kpi.carrentals.entities.Place;
import ua.kpi.carrentals.entities.User;
/**
 * OrderCommand class is the ICommand interface
 * implementation. The execution of this command set attribute car, place (get) and places (return)
 * for order form. This command realizes redirection to the order page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class OrderCommand implements ICommand{
	private static Logger logger=Logger.getLogger(OrderCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String idCar=request.getParameter("idcar");
		/**
		 * This method use Database Access Object to get car and places
		 * from database with entered parameters
		 */
		DAOFactory factory=DAOFactory.getDAOFactory();
		ICarDAO carDAO=factory.getCarDAO();
		Integer numberIdCar=Integer.parseInt(idCar);
		Car car=carDAO.getCar(numberIdCar);
		IPlaceDAO placeDAO=factory.getPlaceDAO();
		Place placeGet=placeDAO.getPlace(car.getIdPlace());
		request.setAttribute("car", car);
		request.setAttribute("place", placeGet);
		ArrayList<Place> listPlaces=placeDAO.getListPlaceSortedByCity();
		Place [] places=new Place[listPlaces.size()];
		places=listPlaces.toArray(places);
		request.setAttribute("places", places);
		IClientDAO clientDAO=factory.getClientDAO();
		if ((request.getSession().getAttribute("ID"))==null){
			User user=new User();
			request.getSession().setAttribute("role", user.getRole());
	        request.getSession().setAttribute("ID", user.getId());
		}
		Client client=clientDAO.getClient((Integer)request.getSession().getAttribute("ID"));
		request.setAttribute("client", client);
		
		logger.info("Redirection to the order page");
		
		String page=PagePath.getInstance().getPage(PagePath.ORDER_PAGE_PATH);
		return page;
	}

}
