package trade.assignment.domain;

import java.security.Timestamp;

public class Photo {
    private int no;
    private String URL;
    private Timestamp regdate;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getURL() {
        return URL;
    }
    public void setURL(String uRL) {
        URL = uRL;
    }
    public Timestamp getRegdate() {
        return regdate;
    }
    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }
    @Override
    public String toString() {
        return "Photo [no=" + no + ", URL=" + URL + ", regdate=" + regdate + "]";
    }
}
