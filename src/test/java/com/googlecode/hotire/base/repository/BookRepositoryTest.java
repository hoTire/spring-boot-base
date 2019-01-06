package com.googlecode.hotire.base.repository;

import static org.junit.Assert.assertEquals;

import com.googlecode.hotire.base.entity.Book;
import com.googlecode.hotire.base.exception.NotFoundException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  BookRepository bookRepository;

  @Before
  public void di() throws SQLException {
    try( final Connection connection = dataSource.getConnection()) {
      final DatabaseMetaData databaseMetaData = connection.getMetaData();
      log.info(databaseMetaData.getUserName());
    } catch (SQLException e) {
      throw e;
    }
  }

  @Test
  public void findById() {
    String author = "tire.ho";

    Book book = Book.builder().name(author).build();
    book = bookRepository.save(book);
    final Long id = book.getId();
    book = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book Id" + id));

    assertEquals(book.getName(), author);
  }

  @Test
  public void findAll() {
    List<Book> books = bookRepository.findAll();
    log.info(books.toString());
  }

}