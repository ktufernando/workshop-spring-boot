package ar.com.bbva.taller.app.repository;

import ar.com.bbva.taller.app.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by fer on 22/10/19.
 */
@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends MongoRepository<Book, String> {

    Book findByName(@Param("name") String name);
    List<Book> findByAuthor(@Param("author") String author);

    @Query("{'assessment': {$lt: ?0}}")
    List<Book> findBooksWithAssessmentLessThan(@Param("assessment") int assessment);

}
