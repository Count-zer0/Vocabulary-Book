package Dao;

import java.sql.ResultSet;
import java.util.List;

import User.Word;

public interface WordDao {
	public void add(Word word);
	public void remove(int id);
	public void Refresh(Word word);
	public ResultSet find(String table);

}
