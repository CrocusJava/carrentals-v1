package ua.kpi.carrentals.filters;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.log4j.Logger;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.dao.entitiesdao.CarDAO;
/**
 * LocaleFilter class is the Filter interface implementation.
 * This class set default Locale to all project - US.
 * 
 * @author Tkachuk
 * @see LocaleConfig
 */
public class LocaleFilter implements Filter{
	private static Logger logger=Logger.getLogger(CarDAO.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Locale filter set us default - US");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest=(HttpServletRequest)request;
		Locale locale = LocaleConfig.getCurrentLocale();
		HttpSession session = servletRequest.getSession(true);
		Config.set(session, Config.FMT_LOCALE, locale);
		
		if (chain != null) {
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		
	}
	
}
