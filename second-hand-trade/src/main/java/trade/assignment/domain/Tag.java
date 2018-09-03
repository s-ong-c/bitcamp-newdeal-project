package trade.assignment.domain;

import java.util.Date;
public class Tag {
	private Integer id;
	private String name;
	private Integer tagcount;
	private Date regdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTagcount() {
		return tagcount;
	}
	public void setTagcount(Integer tagcount) {
		this.tagcount = tagcount;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
}
