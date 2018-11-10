package com.googlecode.hotire.base.repository;

import com.googlecode.hotire.base.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long> {
}
