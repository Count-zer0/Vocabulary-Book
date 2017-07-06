package Actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

import Services.wordServiceImpl;
import User.Word;

public class Delete implements Action,ServletRequestAware{
	private Word word;
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	public Word getWord() {
		return word;
	}
	public void setWord(Word word) {
		this.word = word;
	}
	public String execute() throws Exception {
		String strID = request.getParameter("id");
		System.out.println(strID);
		int id = Integer.parseInt(strID);
		wordServiceImpl service = new wordServiceImpl();
		service.Delete(id);
		//service.Download();
		return "success";
	}


}
