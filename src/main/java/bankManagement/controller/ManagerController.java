package bankManagement.controller;

import bankManagement.model.Address;
import bankManagement.model.Customer;
import bankManagement.model.Loan;
import bankManagement.model.Manager;
import bankManagement.service.AddressService;
import bankManagement.service.CustomerService;
import bankManagement.service.LoanService;
import bankManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
     private  AddressService addressService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView managerLoginForm() {
        ModelAndView modelAndView =  new ModelAndView("manager_login");
        modelAndView.addObject("manager" , new Manager());
        return modelAndView;
    }
    @RequestMapping(value = "/loginResult",method = RequestMethod.POST)
    public ModelAndView newManagerValidation(@ModelAttribute("manager") Manager manager) {
        Manager newManager=managerService.login(manager.getUsername(),manager.getPassword());
        if(newManager==null)
        {
            ModelAndView modelAndView =  new ModelAndView("manager_error");
            modelAndView.addObject("error" , "login failed");
            return modelAndView;
        }
        else
        {
            ModelAndView modelAndView =  new ModelAndView("services_of_manager");
            modelAndView.addObject("manager" , newManager);
            return modelAndView;
        }
    }
    @RequestMapping(value="/getAllCustomers", headers = "Accept=application/json")
    public ModelAndView ListOfAllCustomers() {
        List<Customer> listCustomer = customerService.fetchAllPerson();
        ModelAndView mav = new ModelAndView("list_of_all_customers");
        mav.addObject("customer", new Customer());
        mav.addObject("allPersons", listCustomer);
        return mav;
    }
    @RequestMapping("/fetchById")
    public ModelAndView search() {
        ModelAndView modelAndView =  new ModelAndView("search_customer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @RequestMapping("/searchResult")
    public ModelAndView searchPerson(@RequestParam long  id) {
        try {
            ModelAndView mav = new ModelAndView("single_customer_details");
            Customer customer = customerService.getPersonById(id);
            mav.addObject("customer", customer);
            Address address = addressService.getAddressById(customer.getAddressId());
            mav.addObject("address", address);
            return mav;
        } catch (NullPointerException e) {
            return(new ModelAndView("customer_not_present_error"));
        }
    }
/*    @RequestMapping("/newCustomer")
    public ModelAndView newCustomer(@ModelAttribute("customer") Customer customer ,BindingResult resultCustomer, @ModelAttribute("address") Address address,BindingResult resultsAddress) {
        ModelAndView modelAndView =  new ModelAndView("new_customer_creation");
        modelAndView.addObject("customer" , customer);
        modelAndView.addObject("address", address);
        return modelAndView;
    }
    @RequestMapping(value = "/customerSave", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("address") Address address,@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("success_page");
        addressService.insertPerson(address);
        customer.setAddressId(address.getAddressId());
        customerService.insertPerson(customer);
        return mv;
    }*/
    @RequestMapping("/newCustomer")
    public ModelAndView newCustomerForm() {
        ModelAndView modelAndView =  new ModelAndView("new_customer_add");
        Customer customer=new Customer();
        Address address=new Address();
        addressService.insertPerson(address);
        customer.setAddressId(address.getAddressId());
        modelAndView.addObject("customer" , customer);
        return modelAndView;
    }
    @RequestMapping(value = "/saveNewCustomer/{addressId}" , method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer,@PathVariable long addressId) {
        ModelAndView mv =  new ModelAndView("address_details_add");
        customerService.insertPerson(customer);
        Address address=addressService.getAddressById(addressId);
        mv.addObject("address" , address);
        return mv;
    }
    @RequestMapping(value = "/saveAddress/{id}", method = RequestMethod.POST)
    public ModelAndView saveAddress(@ModelAttribute("address") Address address,@PathVariable long id) {
        ModelAndView mv =  new ModelAndView("new_customer_added");
        address.setAddressId(id);
        addressService.insertPerson(address);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEditedCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("success_page");
        customerService.insertPerson(customer);
        return mv;
    }

    @RequestMapping(value="/pendingLoan")
    public ModelAndView pendingLoan() {
        ModelAndView mav = new ModelAndView("pending_loan_list");
        List<Loan> loanList = loanService.fetchAllPerson();
        List<Loan> newLoanList= new ArrayList<Loan>();
        for(Loan loan:loanList)
        {
           if(loan.getStatus().equals("Pending"))
           {
               newLoanList.add(loan);
           }
        }
        mav.addObject("loan", new Loan());
        mav.addObject("allPendingList", newLoanList);
        return mav;
    }
    @RequestMapping(value="/approveLoan/{loanId}/{customerId}")
    public ModelAndView approveLoan(@PathVariable long loanId,@PathVariable long customerId)
    {
        ModelAndView modelAndView=new ModelAndView("loan_approval_success");
        Loan loan = loanService.getLoanById(loanId);
        loan.setStatus("Approved");
        loanService.insertLoan(loan);
        Customer customer = customerService.getPersonById(customerId);
        customer.setBalance((loan.getLoanAmount())+(customer.getBalance()));
        customerService.insertPerson(customer);
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("loan",loan);
        return modelAndView;
    }

    @RequestMapping(value="/rejectLoan/{loanId}")
    public ModelAndView rejectLoan(@PathVariable long loanId)
    {
        ModelAndView modelAndView=new ModelAndView("loan_reject_msg");
        Loan loan = loanService.getLoanById(loanId);
        loan.setStatus("Rejected");
        loanService.insertLoan(loan);
        modelAndView.addObject("loan",loan);
        return modelAndView;
    }




}
