package trade.assignment.dto;

public class LoginDTO {
	/* 로그인시 이메일 패스워드 + 쿠키 체크 */
	
	
	private String email;   
	private String password;
	private boolean useCookie;
	private String snsID;
	private String name;
	
	public String getSnsID() {
		return snsID;
	}
	public void setSnsID(String snsID) {
		this.snsID = snsID;
	}
	public String getMemberName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

}
