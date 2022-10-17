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
        ModelAndView modelAndView =  new ModelAndView("managerLogin");
        modelAndView.addObject("manager" , new Manager());
        return modelAndView;
    }
    @RequestMapping(value = "/loginResult",method = RequestMethod.POST)
    public ModelAndView newManagerValidation(@ModelAttribute("manager") Manager manager) {
        Manager newManager=managerService.login(manager.getUsername(),manager.getPassword());
        if(newManager==null)
        {
            return new ModelAndView("managerError");
        }
        else
        {
            ModelAndView modelAndView =  new ModelAndView("servicesOfManager");
            modelAndView.addObject("manager" , newManager);
            return modelAndView;
        }
    }
    @RequestMapping(value="/getAllCustomers", headers = "Accept=application/json")
    public ModelAndView ListOfAllCustomers() {
        List<Customer> listCustomer = customerService.fetchAllPerson();
        ModelAndView mav = new ModelAndView("listOfAllCustomers");
        mav.addObject("customer", new Customer());
        mav.addObject("allPersons", listCustomer);
        return mav;
    }
    @RequestMapping("/fetchById")
    public ModelAndView fetchCustomerById() {
        ModelAndView modelAndView =  new ModelAndView("searchCustomer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @RequestMapping("/searchResult")
    public ModelAndView searchPersonResult(@RequestParam long  id) {
        try {
            ModelAndView mav = new ModelAndView("singleCustomerDetails");
            Customer customer = customerService.getPersonById(id);
            mav.addObject("customer", customer);
            Address address = addressService.getAddressById(customer.getAddressId());
            mav.addObject("address", address);
            return mav;
        } catch (NullPointerException e) {
            return(new ModelAndView("customerNotPresentError"));
        }
    }
    @RequestMapping("/newCustomer")
    public ModelAndView newCustomerForm() {
        ModelAndView modelAndView =  new ModelAndView("newCustomerAdd");
        Customer customer=new Customer();
        modelAndView.addObject("customer" , customer);
        return modelAndView;
    }
    @RequestMapping(value = "/saveNewCustomer" , method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("addressDetailsAdd");
        Address address=new Address();
      customerService.insertPerson(customer);
        mv.addObject("address" , address);
        mv.addObject("customer" , customer);
        return mv;
    }
    @RequestMapping(value = "/saveAddress/{id}", method = RequestMethod.POST)
    public ModelAndView saveAddress(@ModelAttribute("address") Address address,@PathVariable long id) {
        ModelAndView mv =  new ModelAndView("newCustomerAdded");
        addressService.insertNewAddress(address);
        Customer customer=customerService.getPersonById(id);
        customer.setAddressId(address.getAddressId());
        customerService.insertPerson(customer);
        return mv;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveEditedCustomer(@ModelAttribute("customer") Customer customer) {
        ModelAndView mv =  new ModelAndView("successPage");
        customerService.insertPerson(customer);
        return mv;
    }

    @RequestMapping(value="/pendingLoan")
    public ModelAndView pendingLoanDetails() {
        ModelAndView mav = new ModelAndView("pendingLoanList");
        List<Loan> loanList = loanService.fetchAllLoan();
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
        ModelAndView modelAndView=new ModelAndView("loanApprovalSuccess");
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
        ModelAndView modelAndView=new ModelAndView("loanRejectMsg");
        Loan loan = loanService.getLoanById(loanId);
        loan.setStatus("Rejected");
        loanService.insertLoan(loan);
        modelAndView.addObject("loan",loan);
        return modelAndView;
    }
}
