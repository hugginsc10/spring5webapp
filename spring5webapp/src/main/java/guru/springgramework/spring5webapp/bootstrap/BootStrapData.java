package guru.springgramework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springgramework.spring5webapp.domain.Author;
import guru.springgramework.spring5webapp.domain.Book;
import guru.springgramework.spring5webapp.repositories.AuthorRepository;
import guru.springgramework.spring5webapp.repositories.BookRepository;

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
       Author eric = new Author("Eric", "Evans");
       Book ddd = new Book("Domain Driven Design", "123123");
       eric.getBooks().add(ddd);
       ddd.getAuthors().add(eric);

       authorRepository.save(eric);
       bookRepository.save(ddd);

       Author rod = new Author("Rod", "Johnson");
       Book noEJB = new Book("J2EE Development without EJB", "3939459459");
       rod.getBooks().add(noEJB);
       noEJB.getAuthors().add(rod);

       System.out.println("Started in Bootstrap");
       System.out.println("Number of Books: " + bookRepository.count());
    }
    
}
    
