/*
 * created by 김동수 on 게시판 모델
 * */

package trade.assignment.domain;

import java.sql.Date;

public class Board {
    private int no;
    private String writer;
    private String title;
    private String content;
    private Date createdate;
    private String photo;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Board [no=" + no + ", writer=" + writer + ", title=" + title + ", content=" + content + ", createdate="
                + createdate + ", photo=" + photo + "]";
    }
}
