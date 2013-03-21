package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
/**
 * RegistrationFormCommand class is the ICommand interface
 * implementation.This command realizes redirection to the
 * registration form page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class RegistrationFormCommand implements ICommand{
	private static Logger logger=Logger.getLogger(RegistrationFormCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		logger.info("Redirection to the registration page");
		
		String page=PagePath.getInstance().getPage(PagePath.REGISTRATION_PAGE_PATH);
		return page;
	}

}
