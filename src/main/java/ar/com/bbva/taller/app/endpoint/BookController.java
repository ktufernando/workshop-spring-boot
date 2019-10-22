package ar.com.bbva.taller.app.endpoint;

import ar.com.bbva.taller.app.model.Book;
import ar.com.bbva.taller.app.model.Customer;
import ar.com.bbva.taller.app.repository.BookRepository;
import ar.com.bbva.taller.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookController")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public @ResponseBody ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookRepository.save(book));
    }

    @GetMapping("/{author}")
    public @ResponseBody ResponseEntity<List<Book>> byName(@PathVariable String author){
        return ResponseEntity.ok(bookRepository.findByAuthor(author));
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Iterable<Book>> all() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        bookRepository.deleteById(id);
    }

}
