package kr.ac.sungkyul.bookmall.vo;

public class AuthorVo {	//데이터 객체
	private long no;
	private String name;
	private String description;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
