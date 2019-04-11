package ar.com.bbva.taller.app.endpoint;

import ar.com.bbva.taller.app.model.Customer;
import ar.com.bbva.taller.app.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ResponseEntity save(@RequestBody Customer customer, HttpServletRequest request){
        return ResponseEntity.ok(customerRepository.save(customer));
    }

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity byName(@PathVariable String name){
        return ResponseEntity.ok(customerRepository.findByName(name));
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<Iterable<Customer>> all() {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        customerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
