package blog.model;

import java.util.Date;

public class Post {

    private String title;
    private String text = new String();
    private blog.model.Category Category;
    private Date createdDate;

    public Post() {
    }

    public Post(String title, String text, blog.model.Category category, Date createdDate) {
        this.title = title;
        this.text = text;
        Category = category;
        this.createdDate = createdDate;
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

    public Date getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {

        this.createdDate = createdDate;
    }

    public blog.model.Category getCategory() {

        return Category;
    }

    public void setCategory(blog.model.Category category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", Category=" + Category +
                ", createdDate=" + createdDate +
                '}';
    }
}
