package ua.kpi.carrentals.configuration;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
/**
 * LangConfig class used in users tags and using Singleton 
 * pattern. The LangConfig get all text information from properties files.
 * 
 * @author Tkachuk
 */
public class LocaleConfig {
	private static Logger logger=Logger.getLogger(LocaleConfig.class);
	
	private static LocaleConfig instance = null;
	private ResourceBundle resourceBundle;
	private static Locale currentLocale = new Locale("en","US");
	private static final String FILE_TEXT = "ua.kpi.carrentals.propertiefiles.text";

	public static final String CAR_PRICE = "CAR_PRICE";
	public static final String CAR_PRICE_NOT_MORE = "CAR_PRICE_NOT_MORE";
	public static final String CAR_NUMBER = "CAR_NUMBER";
	public static final String CAR_BODY_TYPE = "CAR_BODY_TYPE";
	public static final String CAR_BRAND = "CAR_BRAND";
	public static final String CAR_MODEL = "CAR_MODEL";
	public static final String CAR_COLOR = "CAR_COLOR";
	public static final String CAR_CLASS = "CAR_CLASS";
	public static final String CAR_TRANSMITION = "CAR_TRANSMITION";
	public static final String CAR_QUANTITY_SEATS = "CAR_QUANTITY_SEATS";
	public static final String CAR_QUANTITY_DOORS = "CAR_QUANTITY_DOORS";
	public static final String CAR_CONDITIONER = "CAR_CONDITIONER";
	public static final String CAR_BODY_NUMBER = "CAR_BODY_NUMBER";
	public static final String CAR_DESCRIPTION = "CAR_DESCRIPTION";
	public static final String CAR_STATE = "CAR_STATE";
	public static final String ORDER = "ORDER";
	public static final String ORDER_MAKE = "ORDER_MAKE";
	public static final String ORDER_CONFIRM= "ORDER_CONFIRM";
	public static final String ORDER_PLACE_GET = "ORDER_PLACE_GET";
	public static final String ORDER_PLACE_RETURN = "ORDER_PLACE_RETURN";
	public static final String ORDER_DATE_GET = "ORDER_DATE_GET";
	public static final String ORDER_DATE_RETURN = "ORDER_DATE_RETURN";
	public static final String ORDER_STATE_ORDER = "ORDER_STATE_ORDER";
	public static final String ORDER_DESCRIPTION = "ORDER_DESCRIPTION";
	public static final String ORDER_REJECT= "ORDER_REJECT";
	public static final String ORDER_NOTEXECUTED= "ORDER_NOTEXECUTED";
	public static final String ORDER_EXECUTED = "ORDER_EXECUTED";
	public static final String ORDER_STATE = "ORDER_STATE";
	public static final String ORDER_DAMAGE = "ORDER_DAMAGE";
	public static final String ORDER_SAVE= "ORDER_SAVE";
	public static final String MENU_SEARCH = "MENU_SEARCH";
	public static final String CLIENT_BIRTHDAY= "CLIENT_BIRTHDAY";
	public static final String CLIENT_PASSPORTSERIES= "CLIENT_PASSPORTSERIES";
	public static final String CLIENT_PASSPORTNUMBER= "CLIENT_PASSPORTNUMBER";
	public static final String CLIENT_PHONENUMBER= "CLIENT_PHONENUMBER";
	public static final String USER_LOGIN= "USER_LOGIN";
	public static final String USER_PASSWORD= "USER_PASSWORD";
	public static final String USER_NAME= "USER_NAME";
	public static final String USER_SURNAME= "USER_SURNAME";
	public static final String USER_MIDDLENAME= "USER_MIDDLENAME";
	public static final String USER_EMAIL= "USER_EMAIL";
	public static final String UPDATE_PROFILE= "UPDATE_PROFILE";
	public static final String MESSAGE_ERROR_LOGIN= "MESSAGE_ERROR_LOGIN";
	public static final String MESSAGE_ERROR_USER= "MESSAGE_ERROR_USER";
	public static final String MESSAGE_HELLO_USER= "MESSAGE_HELLO_USER";
	public static final String MESSAGE_ORDER_CHANGE= "MESSAGE_ORDER_CHANGE";
	public static final String MESSAGE_ORDER_WAS_CREATE= "MESSAGE_ORDER_WAS_CREATE";
	public static final String MESSAGE_LOCALE_CHANGE= "MESSAGE_LOCALE_CHANGE";
	public static final String MESSAGE_UPDATE_PROFILE= "MESSAGE_UPDATE_PROFILE";
	public static final String MESSAGE_FIELDS= "MESSAGE_FIELDS";
	
	private LocaleConfig() {
		
	}

	public static LocaleConfig getInstance() {
		if (instance == null) {
			instance = new LocaleConfig();
			instance.resourceBundle = ResourceBundle.getBundle(FILE_TEXT, currentLocale);
			logger.info("Create new instance. Resource bundle complete");
			
		}
		return instance;
	}

	public static void changeLocale(Locale locale) {
		currentLocale = locale;
		getInstance().resourceBundle = ResourceBundle.getBundle(FILE_TEXT,
				currentLocale);
		logger.info("Locale was change");
	}
	
	public static Locale getCurrentLocale() {
		return currentLocale;
	}

	public String getText(String textName) {
		String text = resourceBundle.getString(textName);
		return text;
	}
}
