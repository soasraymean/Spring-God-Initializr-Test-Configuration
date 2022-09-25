package com.tyjohntompson.springwebapp.bootstrap;

import com.tyjohntompson.springwebapp.model.Author;
import com.tyjohntompson.springwebapp.model.Book;
import com.tyjohntompson.springwebapp.repository.AuthorRepository;
import com.tyjohntompson.springwebapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author author = new Author();
        author.setFirstName("George");
        author.setLastName("Orwell");
        author.setBooks(new HashSet<>());

        Book book = new Book();
        book.setTitle("1984");
        book.setIsbn("9780151660346");
        book.setAuthors(new HashSet<>());

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        System.out.println("Number of books: " + bookRepository.count());

    }
}
