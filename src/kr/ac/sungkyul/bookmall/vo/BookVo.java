package kr.ac.sungkyul.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private Integer rate;
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
		return "BookVo [no=" + no + ", title=" + title + ", rate=" + rate + ", author_no=" + author_no + "]";
	}
	
	
	
	
}
