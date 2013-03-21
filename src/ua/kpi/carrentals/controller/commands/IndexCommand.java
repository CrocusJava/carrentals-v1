package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
/**
 * IndexCommand class is the ICommand interface implementation.
 * This command realizes redirection to the index page
 * 
 * @author Tkachuk
 * @see ICommand
 */
public class IndexCommand implements ICommand{
	private static Logger logger=Logger.getLogger(IndexCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.info("Redirection to the index page");
		String page=PagePath.getInstance().getPage(PagePath.INDEX_PAGE_PATH);
		return page;
	}

}
