package ua.kpi.carrentals.controller;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;
/**
 * PagePath class using Singleton pattern.
 * The PagePath get page path from resource bundle.
 * 
 * @author Tkachuk
 */
public class PagePath {
	private static Logger logger=Logger.getLogger(PagePath.class);
	
	private static PagePath instance;
	private static ResourceBundle resource;
	private static final String FILE_PROPERTIES = "ua.kpi.carrentals.propertiefiles.pagepath";
	public static final String CARS_PAGE_PATH = "CARS_PAGE_PATH";
	public static final String INDEX_PAGE_PATH = "INDEX_PAGE_PATH";
	public static final String MESSAGE_PAGE_PATH = "MESSAGE_PAGE_PATH";
	public static final String ORDER_PAGE_PATH = "ORDER_PAGE_PATH";
	public static final String ORDERLIST_PAGE_PATH = "ORDERLIST_PAGE_PATH";
	public static final String PROFILE_PAGE_PATH = "PROFILE_PAGE_PATH";
	public static final String REGISTRATION_PAGE_PATH = "REGISTRATION_PAGE_PATH";
	public static final String SEARCH_PAGE_PATH = "SEARCH_PAGE_PATH";
	
	private PagePath() {
		resource = ResourceBundle.getBundle(FILE_PROPERTIES);
		logger.info("Create new instance. Resource bundle complete");
	}

	public static synchronized PagePath getInstance() {
		if (instance == null) {
			instance = new PagePath();
		}
		return instance;
	}

	public String getPage(String pathName) {
		String path = resource.getString(pathName);
		return path;
	}
}
