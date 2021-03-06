package blog.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
    private String title;
    private String text;
    private String category;
    private Date createdDate;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
    private User user;

    public Post(String title, String text, String category, Date createdDate, SimpleDateFormat sdf, User user) {
        this.title = title;
        this.text = text;
        this.category = category;
        this.createdDate = createdDate;
        this.sdf = sdf;
        this.user = user;
    }

    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (title != null ? !title.equals(post.title) : post.title != null) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        if (category != null ? !category.equals(post.category) : post.category != null) return false;
        if (createdDate != null ? !createdDate.equals(post.createdDate) : post.createdDate != null) return false;
        if (sdf != null ? !sdf.equals(post.sdf) : post.sdf != null) return false;
        return user != null ? user.equals(post.user) : post.user == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (sdf != null ? sdf.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", category='" + category + '\'' +
                ", createdDate=" + createdDate +
                ", sdf=" + sdf +
                ", user=" + user +
                '}';
    }
}

