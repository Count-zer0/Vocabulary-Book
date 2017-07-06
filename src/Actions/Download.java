package Actions;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import Services.wordServiceImpl;

public class Download   {
	private InputStream is;
	private String fileName;
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String execute() throws Exception {
		
		wordServiceImpl service = new wordServiceImpl();
		service.Download();
		fileName="word.txt";
		is=ServletActionContext.getServletContext().getResourceAsStream("/resources/"+fileName);	
		//InputStream in=ServletActionContext.getServletContext().getResourceAsStream("/resources/"+fileName);
		//System.out.println(in);
		return Action.SUCCESS;
	}

	
		
		
	}


