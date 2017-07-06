package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Dao.WordDaoImpl;
import Dao.WordDaoUtil;
import Services.Inflector;
import User.Word;
import junit.framework.TestCase;

public class oneTest extends TestCase {
	public void test1(){
		Configuration cfg=new Configuration().configure();
		SchemaExport se=new SchemaExport(cfg);
		se.create(true, true);
	}
	public void test2(){
		System.out.println(Inflector.getInstance().singularize("wolves")); 
	}
	public void test3(){
		Configuration cfg=new Configuration().configure();
		Session session=new WordDaoUtil().getSession();
		Transaction tx = session.beginTransaction();
		Word word = new Word();
		word.setId(2);
		session.delete(word);
		tx.commit();
	}
	public void test4(){
		Configuration cfg=new Configuration().configure();
		Session session=new WordDaoUtil().getSession();
		Transaction tx = session.beginTransaction();
		Word word = new Word();
		
		session.update(word);
		tx.commit();
	}
	public void test5(){
		 File file = new File("../WordDateBase/WebContent/resources/word.txt"); 
		 if(!(file.exists())){
			 try {
				 file= new File("../WordDateBase/WebContent/resources/word.txt");
				 file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
	     Writer writer = null;  
		 OutputStream os=null;
		try {
			  writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8");  
			  Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system", "123456");
				Statement stat = conn.createStatement();
				ResultSet eq = stat.executeQuery("select * from word");
				while(eq.next()){
					writer.write(eq.getString("english")+","+eq.getString("chinese")+";");  
					writer.flush();
				}
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
	
	public void test6() {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into emp(name,entity) values(?,?)";
		try {
			conn=new WordDaoImpl().getconn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			ps.setString(2, "");
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			System.out.println("ÃÌº”ÕÍ≥…");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}



}
