package Actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.Action;

import Services.wordServiceImpl;

public class Upload  {
	private String myFileFileName;
	private File myFile;
	private String myFileContentType;

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String execute() throws Exception {
		wordServiceImpl service = new wordServiceImpl();
		InputStream is=null;
		OutputStream os=null;
		is=new BufferedInputStream(new FileInputStream(myFile));
		os=new BufferedOutputStream (new FileOutputStream("e:\\"+myFileFileName));
		System.out.println("e:\\"+myFileFileName);
		byte[] buffer=new byte[1024];
		int length=0;
		while((length=is.read(buffer))>0){
			os.write(buffer, 0, length);
		}
		if(is!=null)
			is.close();
		if(os!=null)
			os.close();
		service.Upload("e:\\"+myFileFileName);
		//service.Download();
		return Action.SUCCESS;
	}

}
