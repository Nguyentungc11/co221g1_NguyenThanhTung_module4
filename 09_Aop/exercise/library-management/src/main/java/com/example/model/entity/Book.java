package com.example.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;
    private String name;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
    Set<BorrowBook> codeSet;

    public Book() {
    }

    public Book(Integer id, String name, Integer quantity, Set<BorrowBook> codeSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.codeSet = codeSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<BorrowBook> getCodeSet() {
        return codeSet;
    }

    public void setCodeSet(Set<BorrowBook> codeSet) {
        this.codeSet = codeSet;
    }
}
