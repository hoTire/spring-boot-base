package com.googlecode.hotire.base.service;

import com.googlecode.hotire.base.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@ActiveProfiles("develop")
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookServiceTest {

    @Autowired BookService bookService;

    @Test
    public void findAll() {
        List<Book> result = bookService.findAll();
        log.info(result.toString());
    }

    @Test
    public void save() {
        Book book = new Book();
        book.setName("TEST BOOK");
        Book result = bookService.save(book);
        log.info(result.toString());
    }
}