package ua.kpi.carrentals.tag;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.entities.Place;
/**
 * SearchTag class is the TagSupport class extends - user tag that show
 * all information about search car.
 * 
 * @author Tkachuk
 * @see LocaleConfig
 */
public class SearchTag extends TagSupport {
	private Place [] value;

	public void setValue(Place [] value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String placeGet=langConfig.getText(LocaleConfig.ORDER_PLACE_GET);
		String placeReturn=langConfig.getText(LocaleConfig.ORDER_PLACE_RETURN);
		String dateGet=langConfig.getText(LocaleConfig.ORDER_DATE_GET);
		String dateReturn=langConfig.getText(LocaleConfig.ORDER_DATE_RETURN);
		String search=langConfig.getText(LocaleConfig.MENU_SEARCH);
		String price=langConfig.getText(LocaleConfig.CAR_PRICE_NOT_MORE);
		
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format(new Date());
		
		StringBuilder stringFormat = new StringBuilder();
		Formatter formatter = new Formatter(stringFormat);
		formatter.format("<table><tr><td><form name=\"search\" method=\"POST\" action=\"carrentals\">");
		formatter.format("<input type=\"hidden\" name=\"command\" value=\"searchcars\" />");
		formatter.format(placeGet+"</td><td><select name=\"idplaceget\">");
		for (Place place : value) {
			formatter.format("<option value=\"%d\">%s,%s</option>", place.getIdPlace(), place.getCity(), place.getDescriptionPlace());
		}
		formatter.format("</select></td></tr><tr><td>");	
		formatter.format(placeReturn+"</td><td><select name=\"idplacereturn\">");
		for (Place place : value) {
			formatter.format("<option value=\"%d\">%s,%s</option>", place.getIdPlace(), place.getCity(), place.getDescriptionPlace());
		}
		formatter.format("</select></td></tr><tr><td>");
		formatter.format(dateGet+"</td><td><input tpye=\"text\" name=\"dateget\" value=\"%s\"/></td></tr><tr><td>",date);
		formatter.format(dateReturn+"</td><td><input tpye=\"text\" name=\"datereturn\" value=\"%s\"/></td></tr><tr><td>",date);
		formatter.format(price+"</td><td><input tpye=\"text\" name=\"pricenotmore\" value=\"%d\"/></td></tr>",100);
		formatter.format("<tr><td><input type=\"submit\" value=\"%s\"></td><td></td></tr>",search);	
		formatter.format("</form></table>");
		
		try {
			pageContext.getOut().write(stringFormat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
