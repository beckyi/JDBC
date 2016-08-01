package kr.ac.sungkyul.bookmall.vo;

public class BookVo {	//book 객체
	private Long no;
	private String title;
	private Integer price;
	private Long author_no;
	private Long category_no;
	
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Long getAuthor_no() {
		return author_no;
	}
	public void setAuthor_no(Long author_no) {
		this.author_no = author_no;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	
	@Override
	public String toString() {
		return "BookVo [title=" + title + ", price=" + price + "]";
	}
}
