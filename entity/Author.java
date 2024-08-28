package com.task2.lms.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id", length = 12)
    private int authorid;

    @Column(name = "author_name", length = 45)
    private String name;

    @Column(name = "author_bio", length = 45)
    private String bio;

    //1 Author has many book relation create
    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Author(int authorid, String name, String bio) {
        this.authorid = authorid;
        this.name = name;
        this.bio = bio;
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Author() {
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorid=" + authorid +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
