package ua.kpi.carrentals.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.commands.ICommand;
/**
 * CarRentals class realizes the controller of the MVC pattern.
 * CarRentals gets command from the request and redirects user 
 * to the appropriate page returned by this command
 *
 * @author Tkachuk
 * @see CommandRequest
 */
public class CarRentals extends HttpServlet {
	private static Logger logger=Logger.getLogger(CarRentals.class);
	
	private CommandRequest commandRequest = CommandRequest.getInstance();
	 /** 
     * Processes requests for both HTTP GET and POST methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String page = null;
		try {
			ICommand command = commandRequest.getCommand(request);
			logger.debug("Command "+command);
			page = command.execute(request, response);
			logger.debug("Page "+page);
		} catch (ServletException e) {
			logger.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        logger.debug("Current user role = " + role);
        Integer ID = (Integer) session.getAttribute("ID");
        logger.debug("current user id = " + ID);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
