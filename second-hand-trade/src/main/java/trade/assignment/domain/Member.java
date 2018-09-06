package trade.assignment.domain;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private static final long serialVersionUID = 1L;
    

    
    private int no;
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String phonenumber;
	private String profilephoto; //memberPicture
	private String website;
	private String intro;
	private String snsID;
	
	private int prilevel; //userState
	private int userlevel; //비공개여부
	private String sessionkey;
	private String memberAuthKey;
	
	private Date regdate;
	private int postCount;
	
	private int sex;
	public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getProfilephoto() {
		return profilephoto;
	}
	public void setProfilephoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getSnsID() {
		return snsID;
	}
	public void setSnsID(String snsID) {
		this.snsID = snsID;
	}
	public int getPrilevel() {
		return prilevel;
	}
	public void setPrilevel(int prilevel) {
		this.prilevel = prilevel;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public String getSessionkey() {
		return sessionkey;
	}
	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}
	public String getMemberAuthKey() {
		return memberAuthKey;
	}
	public void setMemberAuthKey(String memberAuthKey) {
		this.memberAuthKey = memberAuthKey;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", email=" + email + ", password=" + password + ", name=" + name + ", nickname="
				+ nickname + ", phonenumber=" + phonenumber + ", profilephoto=" + profilephoto + ", website=" + website
				+ ", intro=" + intro + ", snsID=" + snsID + ", prilevel=" + prilevel + ", userlevel=" + userlevel
				+ ", sessionkey=" + sessionkey + ", memberAuthKey=" + memberAuthKey + ", regdate=" + regdate
				+ ", postCount=" + postCount + "]";
	}
	
    
	
   
}