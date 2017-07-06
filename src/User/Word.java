package User;

public class Word {
	private int id;
	private String english;
	private String chinese;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public Word(int id, String english, String chinese) {
		super();
		this.id = id;
		this.english = english;
		this.chinese = chinese;
	}
	public Word(String english, String chinese) {
		super();
		this.english = english;
		this.chinese = chinese;
	}
	public Word() {
		super();
	}
	
	
}
