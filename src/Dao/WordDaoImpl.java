package Dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import User.Word;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.mysql.jdbc.Connection;
import Services.ServiceUtil;


public class WordDaoImpl implements WordDao {
	public Connection getconn() {
		Connection conn=null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system", "123456");
			Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?"
			  + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
		conn= (Connection) DriverManager.getConnection(url);
		return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;		
	}

	@Override
	public void add(Word word) {
		/*Configuration cfg=new Configuration().configure();
		Session session=new WordDaoUtil().getSession();
		Transaction tx = session.beginTransaction();
		session.save(word);
		tx.commit();*/
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into word(id,english,chinese) values(?,?,?)";
		try {
			conn=new WordDaoImpl().getconn();
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, word.getId());
			ps.setString(2, word.getEnglish());
			ps.setString(3, word.getChinese());
			int i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
			if(conn!=null)
				conn.close();
			if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void remove(int id) {
		Configuration cfg=new Configuration().configure();
		Session session=new WordDaoUtil().getSession();
		Transaction tx = session.beginTransaction();
		Word word = new Word();
		word.setId(id);
		session.delete(word);
		tx.commit();
	}

	public void Refresh(Word word) {
		int OLDid = word.getId();
		String OLDenglish = word.getEnglish();
		String OLDchinese = word.getChinese();
		Configuration cfg=new Configuration().configure();
		Session session=new WordDaoUtil().getSession();
		Transaction tx = session.beginTransaction();
		Word newWord = new Word();
		newWord.setId(OLDid);
		newWord.setEnglish(OLDenglish);
		newWord.setChinese(OLDchinese);
		session.update(newWord);
		session.save(newWord);
		tx.commit();
	}

	@Override
	public ResultSet find(String table) {
		Connection conn=null;
		Statement stat=null;
		ResultSet eq=null;
		try {
		conn=new WordDaoImpl().getconn();
		stat = conn.createStatement();
		eq = stat.executeQuery("select * from "+table);
		return eq;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	


}
