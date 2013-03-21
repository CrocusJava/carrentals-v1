package ua.kpi.carrentals.tag;

import java.io.IOException;
import java.util.Formatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.entities.Order;
/**
 * OrderListTag class is the TagSupport class extends - user tag that allows 
 * to update order's parameters.
 * 
 * @author Tkachuk
 * @see LocaleConfig
 */
public class OrderListTag extends TagSupport {
	private Order value;
	public void setValue(Order value) {
		this.value = value;
	}
	
	public int doStartTag() throws JspException {
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String order=langConfig.getText(langConfig.ORDER);
		String confirm=langConfig.getText(langConfig.ORDER_CONFIRM);
		String reject=langConfig.getText(langConfig.ORDER_REJECT);
		String executed=langConfig.getText(langConfig.ORDER_EXECUTED);
		String notexecuted=langConfig.getText(langConfig.ORDER_NOTEXECUTED);
		String description=langConfig.getText(langConfig.ORDER_DESCRIPTION);
		String damage=langConfig.getText(langConfig.ORDER_DAMAGE);
		String save=langConfig.getText(langConfig.ORDER_SAVE);
		String state=langConfig.getText(langConfig.ORDER_STATE);
	
		StringBuilder stringFormat = new StringBuilder();
		Formatter formatter = new Formatter(stringFormat);
		formatter.format("<table width=\"%d\"><tr><td><form name=\"orderlist\" method=\"POST\" action=\"carrentals\">",680);
		formatter.format("<input type=\"hidden\" name=\"command\" value=\"updateorder\" />");
		formatter.format("<input type=\"hidden\" name=\"idorder\" value=\"%s\" />", value.getIdOrder());
		formatter.format(order+"¹ %s</td><td>", value.getIdOrder());
		formatter.format("<select name=\"stateorder\">");
		formatter.format("<option value=\"true\">%s</option>", confirm);
		formatter.format("<option value=\"false\">%s</option>", reject);
		formatter.format("</select></td>");	
		formatter.format("<td>%s: %s</td><td>",state, value.isStateOrder());
		formatter.format("%s<input type=\"text\" name=\"description\" value=\" %s\"></td></tr>", description, (value.getDescription()==null)?"":value.getDescription());
		formatter.format("<tr><td><input type=\"submit\" value=\"%s\"></td><td><select name=\"orderexecuted\">",save);
		formatter.format("<option value=\"true\">%s</option>", executed);
		formatter.format("<option value=\"false\">%s</option>", notexecuted);
		formatter.format("</select></td>");	
		formatter.format("<td>%s: %s</td><td>",executed, value.isOrderExecuted());
		formatter.format("%s<input type=\"text\" name=\"descriptiondamage\" value=\" %s\"></td></tr>",damage,(value.getDescriptionDamage()==null)?"":value.getDescriptionDamage());	
		formatter.format("</form></table>");

		try {
			pageContext.getOut().write(stringFormat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
