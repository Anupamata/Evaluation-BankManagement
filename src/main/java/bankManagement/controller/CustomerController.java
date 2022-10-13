package bankManagement.controller;

import bankManagement.model.Customer;
import bankManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/all", headers = "Accept=application/json")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.fetchAllPerson();
        ModelAndView mav = new ModelAndView("list-of-all");
        mav.addObject("customer", new Customer());
        mav.addObject("allPersons", listCustomer);
        return mav;
    }
}
