package kr.ac.sungkyul.bookmall.vo;

public class BookVo {	//book 객체
	private Long no;
	private String title;
	private Integer rate;
	private Integer status;
	private String authorName;
	
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Long author_no;
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getRate() {
		return rate;
	}
	
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	public Long getAuthor_no() {
		return author_no;
	}
	
	public void setAuthor_no(Long author_no) {
		this.author_no = author_no;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", rate=" + rate + ", status=" + status + ", author_no="
				+ author_no + "]";
	}
	
}
