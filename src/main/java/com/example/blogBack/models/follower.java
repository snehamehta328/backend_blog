package com.example.blogBack.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class follower implements Serializable {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followerid;
  @ManyToOne
    private user user1;
  @ManyToOne
    private user user2;

    public follower(user user1, user user2) {
        this.user1 = user1;
        this.user2 = user2;
    }
    public follower()
    {

    }

    public Long getFollowerid() {
        return followerid;
    }

    public void setFollowerid(Long followerid) {
        this.followerid = followerid;
    }

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    public user getUser2() {
        return user2;
    }

    public void setUser2(user user2) {
        this.user2 = user2;
    }
}
