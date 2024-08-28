package com.task2.lms.entity;

import jakarta.persistence.*;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="borrow")

public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String name;

   @ManyToOne
   @JoinColumn(name = "book_id")
   private Book book;

   @JoinColumn(name = "borrowDate")
   private LocalDate borrowDate;
   @JoinColumn(name = "returnDate")
   private LocalDate returnDate;

   private boolean isReturned;

// ####### Generate Constructors #########

    public Borrower(int id, String email, String name, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrower(String email, String name, Book book, LocalDate borrowDate, LocalDate returnDate) {
        this.email = email;
        this.name = name;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Borrower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }
    //

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
