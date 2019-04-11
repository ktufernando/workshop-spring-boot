package ar.com.bbva.taller.app.endpoint;

import ar.com.bbva.taller.app.model.Customer;
import ar.com.bbva.taller.app.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    ////private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Customer save(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @RequestMapping(value="/{name}", method = RequestMethod.GET)
    public @ResponseBody List<Customer> byName(@PathVariable String name){
        return customerRepository.findByName(name);
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Iterable<Customer> all() {
        return customerRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        customerRepository.deleteById(id);
    }

}
