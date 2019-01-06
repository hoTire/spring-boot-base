package com.googlecode.hotire.base.service;

import static org.junit.Assert.assertNotNull;

import com.googlecode.hotire.base.entity.Book;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("develop")
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookServiceTest {

    @Autowired BookService bookService;

    @Test
    public void findAll() {
        List<Book> result = bookService.findAll();
        assertNotNull(result);
    }

    @Test
    public void save() {
        Book book = Book.builder().name("TEST BOOK").build();
        Book result = bookService.save(book);
        assertNotNull(result);
    }
}