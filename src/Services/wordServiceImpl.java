package Services;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import Dao.WordDaoImpl;
import User.Word;

public class wordServiceImpl implements wordService {
	
	@Override
	public String append(Word word) {
		WordDaoImpl dao=new WordDaoImpl();	
		try {
		ResultSet eq=dao.find("word");
		while(eq.next()){
			if(Inflector.getInstance().singularize(eq.getString("english"))
					.equals(Inflector.getInstance().singularize(word.getEnglish()))){
				return "error";
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		dao.add(word);
		return "success";

	}
	@Override
	public String Update(Word word) {
		WordDaoImpl dao=new WordDaoImpl();	
		try{
		ResultSet eq=dao.find("word");
		while(eq.next()){
			if(eq.getInt("id")==word.getId())
				continue;
			if(Inflector.getInstance().singularize(eq.getString("english"))
					.equals(Inflector.getInstance().singularize(word.getEnglish()))){
				return "error";
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		dao.Refresh(word);
		return "success";
	}
	@Override
	public void Delete(int id) {
		WordDaoImpl dao=new WordDaoImpl();	
		dao.remove(id);
	}
	@Override
	public void Upload(String path) {
		int length=0;
		WordDaoImpl dao=new WordDaoImpl();	
		File file = new File(path);  
	    InputStream is = null;  
	    byte[] data = new byte[(int) file.length()];  
	    int len = 0;  
	    try {  
	       is = new FileInputStream(file);  
	       int read;  
	       while ((read = is.read()) != -1) {  
	           data[len++] = (byte) read;  
	          // System.out.write(read);  
	            }  
	        String result = new String(data, 0, len);  
	        for(int a=0;a<result.length();a++){
	        		if(result.charAt(a)==59){
	        for(int b=a+1;a<result.length()-3;b++){
	        		if(result.charAt(b)==59){
	        		String str = result.substring(a+1, b);
	        		Word word = new Word();
	        		word.setEnglish(str.substring(0,str.indexOf(",")));
	        		word.setChinese(str.substring(str.indexOf(",")+1,str.length()));
	        		dao.add(word);
	        		break;
	        		}
	        }		
	        		}
	        }   
	    } catch (IOException e) {  
	            e.printStackTrace();  
	     } finally {  
	            if (is!=null) {  
	                try {  
	                    is.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	}
	public void Download() {
		 File file = new File("../workspace/VocabularyBook/WebContent/resources/word.txt"); 
		 if(!(file.exists())){
			 try {
				 file= new File("../workspace/VocabularyBook/WebContent/resources/word.txt");
				 file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	     Writer writer = null;  
		 OutputStream os=null;
		 WordDaoImpl dao=new WordDaoImpl();	
		try {
			  writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8");  
			  ResultSet eq=dao.find("word");
				writer.write(";");
				while(eq.next()){
					writer.write(eq.getString("english")+","+eq.getString("chinese")+";");  
				}
				writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {  
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	@Override
	public String FindENbyCH(String english) {
		 WordDaoImpl dao=new WordDaoImpl();	
		  ResultSet eq=dao.find("word");
			try {
				while(eq.next()){
					if(eq.getString("english").equals(english))
						return eq.getString("chinese");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "抱歉，库中没有你想要的单词！";
	}
	

	

}
