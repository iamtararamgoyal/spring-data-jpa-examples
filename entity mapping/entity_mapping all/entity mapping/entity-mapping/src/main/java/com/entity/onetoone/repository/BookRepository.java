package com.entity.onetoone.repository;

import com.entity.onetoone.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
