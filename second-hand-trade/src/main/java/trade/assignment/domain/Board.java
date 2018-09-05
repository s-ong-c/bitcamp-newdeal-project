/*
 * created by 김동수 on 게시판 모델
 * */

package trade.assignment.domain;

import java.sql.Date;

public class Board {
    private int no;
    private String name;
    private String title;
    private String content;
    private Date createdate;
    private String photo;
    //회진 추가
    private int price;
    private int category;
    //0:의류,패션잡화  1:뷰티,미용  2:디지털,가전  3:생활,식품  4:기타
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Board [no=" + no + ", name=" + name + ", title=" + title + ", content=" + content + ", createdate="
                + createdate + ", photo=" + photo+ ", price=" + price+ ", category=" + category + "]";
    }
}
