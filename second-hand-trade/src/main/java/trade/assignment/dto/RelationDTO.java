package trade.assignment.dto;

public class RelationDTO {
	private String name;
	private int userid;
	private int loginid;
	private int postid;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	
	@Override
	public String toString() {
		return "RelationDTO [name=" + name + ", userid=" + userid + ", loginid=" + loginid + ", postid="
				+ postid + "]";
	}
	
	
}