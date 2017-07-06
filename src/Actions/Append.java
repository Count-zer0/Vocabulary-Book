package Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

import Dao.WordDaoImpl;
import Services.wordServiceImpl;
import User.Word;

public class Append implements Action,ServletRequestAware{
	private final String englishERROR="µ•¥ “—¥Ê‘⁄!";
	private Word word;
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}

	@Override
	public String execute() throws Exception {
		wordServiceImpl service = new wordServiceImpl();
		String result = service.append(word);
		if(result.equals("error")){
			request.setAttribute("englishError", englishERROR);
		}
		//service.Download();
		return result;
	}
	
}
