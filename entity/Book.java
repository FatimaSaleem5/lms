package com.task2.lms.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", length = 12)
    private int bookid;

    @Column(name = "book_title", length = 25)
    private String title;

    @Column(name = "published_date", length = 25)
    private String publisheddate;

    @Column(name = "isbn", length = 25)
    private String isbn;

    @ManyToOne
    @JoinColumn(name= "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<Borrower> borrowers;

    //########## CONSTRUCTOR ##########
    public Book(int bookid, String title, String publisheddate, String isbn, Author author) {
        this.bookid = bookid;
        this.title = title;
        this.publisheddate = publisheddate;
        this.isbn = isbn;
        this.author = author;
    }

    public Book(String title, String publisheddate, String isbn, Author author) {
        this.title = title;
        this.publisheddate = publisheddate;
        this.isbn = isbn;
        this.author = author;
    }

    public Book() {
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisheddate() {
        return publisheddate;
    }

    public void setPublisheddate(String publisheddate) {
        this.publisheddate = publisheddate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", title='" + title + '\'' +
                ", publisheddate='" + publisheddate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                '}';
    }
}
