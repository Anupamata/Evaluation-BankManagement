package bankManagement.controller;

import bankManagement.model.Address;
import bankManagement.model.Customer;
import bankManagement.model.Loan;
import bankManagement.service.AddressService;
import bankManagement.service.CustomerService;
import bankManagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private LoanService loanService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView customerLoginForm() {
        ModelAndView modelAndView =  new ModelAndView("customer_login");
        modelAndView.addObject("customer" , new Customer());
        return modelAndView;
    }
    @RequestMapping(value = "/loginResult",method = RequestMethod.POST)
    public ModelAndView newCustomerValidation(@ModelAttribute("customer") Customer customer) {
        Customer newCustomer =customerService.login(customer.getUsername(),customer.getPassword());
        if(newCustomer ==null)
        {
            ModelAndView modelAndView =  new ModelAndView("customer_error");
            modelAndView.addObject("error" , "login failed");
            return modelAndView;
        }
        else
        {

            ModelAndView modelAndView =  new ModelAndView("services_of_Customer");
            modelAndView.addObject("customer" , newCustomer);
            return modelAndView;

        }
    }
    @RequestMapping("/fetchById/{id}")
    public ModelAndView searchCustomerById(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("single_customer_details");
        Customer customer = customerService.getPersonById(id);
        mav.addObject("customer", customer);
        Address address = addressService.getAddressById(customer.getAddressId());
        mav.addObject("address", address);
        return mav;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomer(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("edit_customer");
        Customer customer = customerService.getPersonById(id);
        mav.addObject("customer", customer);
        return mav;
    }
    @RequestMapping("/editAddress")
    public ModelAndView editAddress(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("edit_address");
        Address address = addressService.getAddressById(id);
        mav.addObject("address", address);
        return mav;
    }
    @RequestMapping(value = "/customerSave", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("success_page");
        customerService.insertPerson(customer);
        return mv;
    }

    @RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
    public ModelAndView saveAddress(@ModelAttribute("address") Address address) {
        ModelAndView mv =  new ModelAndView("success_page");
        addressService.insertPerson(address);
        return mv;
    }
    @RequestMapping(value = "/withdraw/{id}")
    public ModelAndView withdrawMoney(@PathVariable long  id) {
        ModelAndView mv =  new ModelAndView("withdraw_home");
        Customer customer = customerService.getPersonById(id);
        mv.addObject("customer", customer);
        return mv;
    }
    @RequestMapping(value = "/withdrawResult/{id}/{amount}", method = RequestMethod.GET)
    public ModelAndView withdrawResult(@PathVariable long id,@PathVariable double  amount) {
        ModelAndView mv =  new ModelAndView("updated_balance");
        Customer customer = customerService.getPersonById(id);
        if(amount<= customer.getBalance()) {
            double newAmount = (customer.getBalance()) - amount;
            customer.setBalance(newAmount);
            customerService.insertPerson(customer);
            mv.addObject("customer", customer);
            return mv;
        }
        else
        {
            ModelAndView modelAndView =  new ModelAndView("exceed_withdraw_amount");
//            modelAndView.addObject("customer", customer);
            return modelAndView;
        }

    }
    @RequestMapping(value = "/loanHome/{id}")
    public ModelAndView loanHome(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("loan_Home");
        Customer customer = customerService.getPersonById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "/applyNewLoan/{id}")
    public ModelAndView newLoan(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("new_loan");
        Customer customer = customerService.getPersonById(id);
        Loan loan = new Loan();
        loan.setCustomerId(customer.getCustomerId());
        modelAndView.addObject("loan",loan);
        return modelAndView;
    }
    @RequestMapping(value = "/loanSave", method = RequestMethod.POST)
    public ModelAndView saveLoan(@ModelAttribute("loan") Loan loan) {
        ModelAndView mv =  new ModelAndView("loan_success_page");
        loan.setStatus("Pending");
        loanService.insertLoan(loan);
        mv.addObject("loan",loan);
        return mv;
    }
    @RequestMapping(value = "/statusOfLoan/{id}")
    public ModelAndView statusOfLoan(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("loan_Details_One_Customer");
        List<Loan> loanList=loanService.getByCustomerId(id);
        modelAndView.addObject("loan", new Loan());
        modelAndView.addObject("loanList",loanList);
        return modelAndView;
    }

}

