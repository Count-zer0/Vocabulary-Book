package Actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Action;

import Services.wordService;
import Services.wordServiceImpl;
import User.Word;

public class FindENbyCH implements Action,ServletRequestAware {
	private Word word;
	private HttpServletRequest request;
	public Word getWord() {
		return word;
	}

	public void setWord(Word word) {
		this.word = word;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}

	@Override
	public String execute() throws Exception {
		wordService service=new wordServiceImpl();
		word.setChinese(service.FindENbyCH(word.getEnglish()));
		return Action.SUCCESS;
	}


}
