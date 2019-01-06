package com.googlecode.hotire.base.service;

import com.googlecode.hotire.base.entity.Book;
import com.googlecode.hotire.base.exception.NotFoundException;
import com.googlecode.hotire.base.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book Id  : " + id));
    }
}
