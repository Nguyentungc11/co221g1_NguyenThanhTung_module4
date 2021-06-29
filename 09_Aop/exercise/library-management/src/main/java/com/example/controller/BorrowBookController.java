package com.example.controller;

import com.example.model.entity.Book;
import com.example.model.entity.BorrowBook;
import com.example.model.service.IBookService;
import com.example.model.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BorrowBookController {
    @Autowired
    IBookService iBookService;
    @Autowired
    IBorrowBookService iBorrowBookService;
    @GetMapping(value = "/list")
    public String showList(Model model){
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("listBook",bookList);
        return "list";
    }
    @GetMapping(value = "/borrow")
    public String showBorrowForm(@RequestParam Integer id,Model model){
        Book book = iBookService.findById(id);
        model.addAttribute("book",book);
        return "info";
    }
    @PostMapping(value = "/borrow")
    public String borrow(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        Book book = iBookService.findById(id);
        Integer quantityBook =book.getQuantity();
        if (quantityBook==0){

        }
        book.setQuantity(book.getQuantity() - 1);
        iBookService.save(book);
        int code = (int) Math.floor(((Math.random() * 89999) + 10000));
        String borrowCode = Integer.toString(code);
        redirectAttributes.addFlashAttribute("borrowCode",borrowCode);
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setCodeBorrowBook(borrowCode);
        borrowBook.setBook(book);
        iBorrowBookService.save(borrowBook);
        return "redirect:/list";
    }
}
