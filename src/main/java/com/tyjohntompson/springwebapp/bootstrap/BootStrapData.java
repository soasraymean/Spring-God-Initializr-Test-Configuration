package com.tyjohntompson.springwebapp.bootstrap;

import com.tyjohntompson.springwebapp.model.Author;
import com.tyjohntompson.springwebapp.model.Book;
import com.tyjohntompson.springwebapp.model.Publisher;
import com.tyjohntompson.springwebapp.repository.AuthorRepository;
import com.tyjohntompson.springwebapp.repository.BookRepository;
import com.tyjohntompson.springwebapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Author author = new Author("George", "Orwell", new HashSet<>());
        Book book = new Book("1984", "9780151660346", new HashSet<>());
        Publisher publisher = new Publisher("Secker and Warburg", "", "", new HashSet<>());

        book.setPublisher(publisher);
        book.getAuthors().add(author);
        publisher.getBooks().add(book);
        author.getBooks().add(book);

        authorRepository.save(author);

        publisherRepository.save(publisher);
        bookRepository.save(book);

        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
