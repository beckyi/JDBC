package kr.ac.sungkyul.bookmall.vo;

public class CustomerVo {
	private Long no;
	private String name;
	private String phone;
	private String email;
	private String Pass;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	@Override
	public String toString() {
		return "CustomerVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", Pass=" + Pass
				+ "]";
	}
	
}
