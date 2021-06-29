package com.example.model.entity;

import javax.persistence.*;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Integer id;
    private String codeBorrowBook;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "book_id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(Integer id, String codeBorrowBook, Book book) {
        this.id = id;
        this.codeBorrowBook = codeBorrowBook;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeBorrowBook() {
        return codeBorrowBook;
    }

    public void setCodeBorrowBook(String codeBorrowBook) {
        this.codeBorrowBook = codeBorrowBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
