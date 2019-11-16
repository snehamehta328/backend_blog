package com.example.blogBack.models;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="blogs")
@EntityListeners(AuditingEntityListener.class)
public class blog implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @Column(name = "image")
    private String image;
    @Column(nullable = false, columnDefinition = "int default '1'")
    private int active;
    @Column(name = "category")
    private String category;
    @Column(name="datee")
    LocalDate date;
 @ManyToOne(cascade = CascadeType.PERSIST)
 private user users;

//    public com.example.blogBack.models.user getUsers() {
//        return users;
//    }
//
//    public void setUsers(com.example.blogBack.models.user users) {
//        this.users = users;
//    }

    public user getUsers() {
        return users;
    }

    public void setUsers(user users) {
        this.users = users;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

