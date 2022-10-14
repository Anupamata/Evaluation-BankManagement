package bankManagement.service.impl;

import bankManagement.dao.CustomerDao;
import bankManagement.model.Customer;
import bankManagement.repository.CustomerRepository;
import bankManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> fetchAllPerson() {
        return customerDao.fetchAllPersons();
    }

    @Override
    public Customer login(String username, String password) {
        return customerDao.login(username,password);
    }
    @Override
    public Customer getPersonById(long personId)  {
        Optional<Customer> optionalPersonModel=customerDao.getPersonNameById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public void insertPerson(Customer customer) {
        validatePerson(customer);
        customerDao.insertPerson(customer);
    }
    private void validatePerson(Customer customer) {
        if(customer.getCustomerId() == 0)
        {
            throw new NullPointerException("Customer Id is empty in the request!");
        }
        if(customer.getCustName()==null)
        {
            throw new NullPointerException("Customer Name is empty in the request");
        }
        /*if(customer.getAge()==0)
        {
            throw new NullPointerException("Person Age is empty in the request");
        }
        if(customer.getMobileNumber()==null)
        {
            throw new NullPointerException("Person Mobile Number is empty in the request");
        }*/
    }
}
