package ua.kpi.carrentals.tag;

import java.io.IOException;
import java.util.Formatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.entities.Car;
/**
 * CarTag class is the TagSupport class extends - user tag that describe 
 * all information about car in the tables tag.
 * 
 * @author Tkachuk
 * @see LocaleConfig
 */
public class CarTag extends TagSupport {
	private Car value;

	public void setValue(Car value) {
		this.value = value;
	}

	public int doStartTag() throws JspException {
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String brand=langConfig.getText(LocaleConfig.CAR_BRAND);
		String model=langConfig.getText(LocaleConfig.CAR_MODEL);
		String classCar=langConfig.getText(LocaleConfig.CAR_CLASS);
		String quantityDoors=langConfig.getText(LocaleConfig.CAR_QUANTITY_DOORS);
		String quantitySeats=langConfig.getText(LocaleConfig.CAR_QUANTITY_SEATS);
		String transmission=langConfig.getText(LocaleConfig.CAR_TRANSMITION);
		String price=langConfig.getText(LocaleConfig.CAR_PRICE);
		String order=langConfig.getText(LocaleConfig.ORDER);
		
		StringBuilder stringFormat = new StringBuilder();
		Formatter formatter = new Formatter(stringFormat);
		formatter.format("<table width=\"%d\"><tr><td width=\"%d\" ><img src=\"%s\"/></td>",680, 300, value.getPhoto());
		formatter.format("<td><table><tr><td>%s</td><td>%s</td></tr>",brand,value.getBrand());
		formatter.format("<tr><td>%s</td><td>%s</td></tr>",model,value.getModel());
		formatter.format("<tr><td>%s</td><td>%s</td></tr>",classCar,value.getClassCar());
		formatter.format("<tr><td>%s</td><td>%s</td></tr>",quantityDoors,value.getQuantityDoors());
		formatter.format("<tr><td>%s</td><td>%s</td></tr>",quantitySeats,value.getQuantitySeats());
		formatter.format("<tr><td>%s</td><td>%s</td></tr>",transmission,value.getTransmission());
		formatter.format("<tr><td>%s</td><td>%d$</td></tr></table>",price,value.getPrice());
		formatter.format("<a href=\"carrentals?command=order&idcar=%d\"style=\"font-weight:bold\">%s</a></td></tr></table>", value.getIdCar(),order);
		
		try {
			pageContext.getOut().write(stringFormat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
