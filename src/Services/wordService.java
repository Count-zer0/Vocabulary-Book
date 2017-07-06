package Services;

import java.io.File;
import java.util.List;

import User.Word;

public interface wordService {
	public String append(Word word);
	public void Delete(int id);
	public String Update(Word word);
	public void Upload(String string);
	public void Download();
	public String FindENbyCH(String english);
}
