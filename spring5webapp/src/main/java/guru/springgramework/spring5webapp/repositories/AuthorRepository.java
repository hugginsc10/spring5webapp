package guru.springgramework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springgramework.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {


    
}
    
