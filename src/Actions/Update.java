package Actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.inject.Context;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import Services.wordServiceImpl;
import User.Word;

public class Update implements Action,ServletRequestAware {
	private final String englishERROR="修改后的单词已存在！！";
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
		String result = service.Update(word);
		if(result.equals("error")){
			request.setAttribute("englishError", englishERROR);
		}
		//service.Download();
		return result;
	}

}
