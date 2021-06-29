package com.example.model.repository;

import com.example.model.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowBookRepository extends JpaRepository<BorrowBook,Integer> {
}
