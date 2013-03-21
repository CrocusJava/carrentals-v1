package ua.kpi.carrentals.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.controller.commands.CarsCommand;
import ua.kpi.carrentals.controller.commands.CheckLoginCommand;
import ua.kpi.carrentals.controller.commands.ICommand;
import ua.kpi.carrentals.controller.commands.IndexCommand;
import ua.kpi.carrentals.controller.commands.LocaleCommand;
import ua.kpi.carrentals.controller.commands.MakeOrderCommand;
import ua.kpi.carrentals.controller.commands.OrderCommand;
import ua.kpi.carrentals.controller.commands.OrderlistCommand;
import ua.kpi.carrentals.controller.commands.ProfileCommand;
import ua.kpi.carrentals.controller.commands.RegistrationCommand;
import ua.kpi.carrentals.controller.commands.RegistrationFormCommand;
import ua.kpi.carrentals.controller.commands.SearchCarsCommand;
import ua.kpi.carrentals.controller.commands.SearchCommand;
import ua.kpi.carrentals.controller.commands.UpdateCommand;
import ua.kpi.carrentals.controller.commands.UpdateOrderCommand;
import ua.kpi.carrentals.controller.commands.UserOutCommand;
/**
 * CommandRequest class is used to get appropriate
 * ICommand by the String value, using Singleton 
 * pattern.
 * 
 * @author Tkachuk
 * @see ICommand
 */
public class CommandRequest {
	private static Logger logger=Logger.getLogger(CommandRequest.class);
	
	private static CommandRequest instance = null;
	private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();

	private CommandRequest() {
		commands.put("index", new IndexCommand());
		commands.put("cars", new CarsCommand());
		commands.put("orderlist", new OrderlistCommand());
		commands.put("order", new OrderCommand());
		commands.put("makeorder", new MakeOrderCommand());
		commands.put("profile", new ProfileCommand());
		commands.put("registrationform", new RegistrationFormCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("search", new SearchCommand());
		commands.put("searchcars", new SearchCarsCommand());
		commands.put("checklogin", new CheckLoginCommand());
		commands.put("userout", new UserOutCommand());
		commands.put("local", new LocaleCommand());
		commands.put("updateprofile", new UpdateCommand());
		commands.put("updateorder", new UpdateOrderCommand());
		
		logger.debug("CommandExtractor was create");
	}

	public static CommandRequest getInstance() {
		if (instance == null) {
			instance = new CommandRequest();
		}
		return instance;
	}
	
	public ICommand getCommand(HttpServletRequest request){
		String action=request.getParameter("command");
		
		logger.debug("action = " + action);
		
		ICommand command=commands.get(action);
		return command;
	}

}
