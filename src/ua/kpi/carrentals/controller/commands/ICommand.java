package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ICommand interface is used to realize Command pattern. Classes that implement
 * this interface should implement a single method execute.
 * 
 * @author Tkachuk
 */
public interface ICommand {
	/**
	 * Depending on request parameters and attributes values should do
	 * appropriate operations and return the results of these operations as
	 * request attribute values. Returns the result page's path
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @return the result page's path
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;
}
