package ua.kpi.carrentals.controller.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.PagePath;
import ua.kpi.carrentals.entities.User;
/**
 * UserOutCommand class is the ICommand interface
 * implementation. This command realizes user's logout. The execution of this
 * command sets default values to role and ID and sets result page as an
 * index page.
 *
 * @author Tkachuk
 * @see ICommand
 */
public class UserOutCommand implements ICommand {
	private static Logger logger=Logger.getLogger(UserOutCommand.class);
	
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("role", new User().getRole());
        request.getSession().setAttribute("ID",  new User().getId());
      
        logger.info("User is logout");
        logger.info("Redirection to the index page");
        
        String page=PagePath.getInstance().getPage(PagePath.INDEX_PAGE_PATH);
		return page;
	}

}
