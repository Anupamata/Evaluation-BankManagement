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

    @GetMapping(value = "/login")
    public ModelAndView customerLoginForm() {
        ModelAndView modelAndView =  new ModelAndView("customerLogin");
        modelAndView.addObject("customer" , new Customer());
        return modelAndView;
    }
    @PostMapping(value = "/loginResult")
    public ModelAndView newCustomerValidation(@ModelAttribute("customer") Customer customer) {
        Customer newCustomer =customerService.login(customer.getUsername(),customer.getPassword());
        if(newCustomer ==null)
        {
            return new ModelAndView("customerError");
        }
        else
        {

            ModelAndView modelAndView =  new ModelAndView("servicesOfCustomer");
            modelAndView.addObject("customer" , newCustomer);
            return modelAndView;

        }
    }
    @RequestMapping("/fetchById/{id}")
    public ModelAndView searchCustomerById(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("singleCustomerDetails");
        Customer customer = customerService.getPersonById(id);
        mav.addObject("customer", customer);
        Address address = addressService.getAddressById(customer.getAddressId());
        mav.addObject("address", address);
        return mav;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCustomerDetails(@PathVariable long  id) {
        ModelAndView mav = new ModelAndView("editCustomer");
        Customer customer = customerService.getPersonById(id);
        mav.addObject("customer", customer);
        return mav;
    }
    @RequestMapping("/editAddress")
    public ModelAndView editAddressDetails(@RequestParam long  id) {
        ModelAndView mav = new ModelAndView("editAddress");
        Address address = addressService.getAddressById(id);
        mav.addObject("address", address);
        return mav;
    }
    @PostMapping(value = "/customerSave")
    public ModelAndView saveEditedCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("successPage");
        customerService.insertPerson(customer);
        return mv;
    }

    @PostMapping(value = "/saveAddress")
    public ModelAndView saveEditedAddress(@ModelAttribute("address") Address address) {
        ModelAndView mv =  new ModelAndView("successPage");
        addressService.insertNewAddress(address);
        return mv;
    }
    @RequestMapping(value = "/withdraw/{id}")
    public ModelAndView withdrawMoney(@PathVariable long  id) {
        ModelAndView mv =  new ModelAndView("withdrawHome");
        Customer customer = customerService.getPersonById(id);
        mv.addObject("customer", customer);
        return mv;
    }
    @GetMapping(value = "/withdrawResult/{id}/{amount}")
    public ModelAndView withdrawResult(@PathVariable long id,@PathVariable double  amount) {
        ModelAndView mv =  new ModelAndView("updatedBalance");
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
            return new ModelAndView("exceedWithdrawAmount");
        }

    }
    @RequestMapping(value = "/loanHome/{id}")
    public ModelAndView loanHome(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("loanHome");
        Customer customer = customerService.getPersonById(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @RequestMapping(value = "/applyNewLoan/{id}")
    public ModelAndView newLoan(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("newLoan");
        Customer customer = customerService.getPersonById(id);
        Loan loan = new Loan();
        loan.setCustomerId(customer.getCustomerId());
        modelAndView.addObject("loan",loan);
        return modelAndView;
    }
    @PostMapping(value = "/loanSave")
    public ModelAndView saveLoan(@ModelAttribute("loan") Loan loan) {
        if(loan.getLoanAmount()==0|| loan.getLoanName() == null)
        {
            ModelAndView modelAndView=new ModelAndView("invalidLoanCredentials");
            modelAndView.addObject("loan",loan);
            return modelAndView;
        }
        ModelAndView mv =  new ModelAndView("loanSuccessPage");
        loan.setStatus("Pending");
        loanService.insertLoan(loan);
        mv.addObject("loan",loan);
        return mv;
    }
    @RequestMapping(value = "/statusOfLoan/{id}")
    public ModelAndView statusOfLoan(@PathVariable long  id) {
        ModelAndView modelAndView = new ModelAndView("loanDetailsOneCustomer");
        List<Loan> loanList=loanService.getLoanByCustomerId(id);
        modelAndView.addObject("loan", new Loan());
        modelAndView.addObject("loanList",loanList);
        return modelAndView;
    }

}

