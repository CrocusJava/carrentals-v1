package ua.kpi.carrentals.tag;

import java.io.IOException;
import java.util.Formatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import ua.kpi.carrentals.configuration.LocaleConfig;
import ua.kpi.carrentals.entities.Client;
import ua.kpi.carrentals.entities.User;
/**
 * ProfileTag class is the TagSupport class extends - user tag that show
 * all information about user and allows to update.
 * 
 * @author Tkachuk
 * @see LocaleConfig
 */
public class ProfileTag extends TagSupport {
	private	User vuser;
	private Client vclient;
	public void setVuser(User vuser) {
		this.vuser = vuser;
	}
	public void setVclient(Client vclient) {
		this.vclient = vclient;
	}
	public int doStartTag() throws JspException {
		
		LocaleConfig langConfig=LocaleConfig.getInstance();
		String login=langConfig.getText(LocaleConfig.USER_LOGIN);
		String password=langConfig.getText(LocaleConfig.USER_PASSWORD);
		String name=langConfig.getText(LocaleConfig.USER_NAME);
		String surnmae=langConfig.getText(LocaleConfig.USER_SURNAME);
		String middlename=langConfig.getText(LocaleConfig.USER_MIDDLENAME);
		String email=langConfig.getText(LocaleConfig.USER_EMAIL);
		String birthday=langConfig.getText(LocaleConfig.CLIENT_BIRTHDAY);
		String passportseries=langConfig.getText(LocaleConfig.CLIENT_PASSPORTSERIES);
		String passportnumber=langConfig.getText(LocaleConfig.CLIENT_PASSPORTNUMBER);
		String phonenumber=langConfig.getText(LocaleConfig.CLIENT_PHONENUMBER);
		String updateprofile=langConfig.getText(LocaleConfig.UPDATE_PROFILE);
		
		StringBuilder stringFormat = new StringBuilder();
		Formatter formatter = new Formatter(stringFormat);
		formatter.format("<table><tr><td><form name=\"profile\" method=\"POST\" action=\"carrentals\">");
		formatter.format("<input type=\"hidden\" name=\"command\" value=\"updateprofile\" />");
		formatter.format(login+"</td><td><input tpye=\"text\" name=\"login\" value=\"%s\"/></td></tr><tr><td>",vuser.getLogin());
		formatter.format(password+"</td><td><input tpye=\"text\" name=\"password\" value=\"%s\"/></td></tr><tr><td>",vuser.getPassword());
		formatter.format(email+"</td><td><input tpye=\"text\" name=\"email\" value=\"%s\"/></td></tr><tr><td>",vuser.getEmail());
		formatter.format(name+"</td><td><input tpye=\"text\" name=\"name\" value=\"%s\"/></td></tr><tr><td>",vuser.getName());
		formatter.format(surnmae+"</td><td><input tpye=\"text\" name=\"surname\" value=\"%s\"/></td></tr><tr><td>",vuser.getSurname());
		formatter.format(middlename+"</td><td><input tpye=\"text\" name=\"middlename\" value=\"%s\"/></td></tr><tr><td>",vuser.getMiddlename());
		if (!(vuser.getRole()).equals("admin")){
			formatter.format("<input type=\"hidden\" name=\"idClient\" value=\"%s\" />", vclient.getIdClient());
			formatter.format(birthday+"</td><td><input tpye=\"text\" name=\"birthday\" value=\"%s\"/></td></tr><tr><td>",(vclient.getBirthday()==null)?"":vclient.getBirthday());
			formatter.format(passportseries+"</td><td><input tpye=\"text\" name=\"passportseries\" value=\"%s\"/></td></tr><tr><td>",(vclient.getPassportseries()==null)?"":vclient.getPassportseries());
			formatter.format(passportnumber+"</td><td><input tpye=\"text\" name=\"passportnumber\" value=\"%s\"/></td></tr><tr><td>",(vclient.getPassportnumber()==null)?"":vclient.getPassportnumber());
			formatter.format(phonenumber+"</td><td><input tpye=\"text\" name=\"phonenumber\" value=\"%s\"/></td></tr><tr><td>",(vclient.getPhonenumber()==null)?"":vclient.getPhonenumber());
		}
		formatter.format("<input type=\"submit\" value=\"%s\"></td><td></td></tr>",updateprofile);	
		formatter.format("</form></table>");
		
		try {
			pageContext.getOut().write(stringFormat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

}
