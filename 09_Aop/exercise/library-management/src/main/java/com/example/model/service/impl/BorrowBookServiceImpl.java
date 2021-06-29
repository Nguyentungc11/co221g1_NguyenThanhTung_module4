package com.example.model.service.impl;

import com.example.model.entity.BorrowBook;
import com.example.model.repository.IBorrowBookRepository;
import com.example.model.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBookServiceImpl implements IBorrowBookService {
    @Autowired
    IBorrowBookRepository iBorrowBookRepository;
    @Override
    public void save(BorrowBook borrowBook) {
        iBorrowBookRepository.save(borrowBook);
    }
}
