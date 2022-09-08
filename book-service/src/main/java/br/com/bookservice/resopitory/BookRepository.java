package br.com.bookservice.resopitory;

import br.com.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
