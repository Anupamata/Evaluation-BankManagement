package bankManagement.service.impl;

import bankManagement.dao.CustomerDao;
import bankManagement.model.Customer;
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
        Optional<Customer> optionalPersonModel=customerDao.getPersonById(personId);
        return optionalPersonModel.orElse(null);
    }
    @Override
    public Customer insertPerson(Customer customer) {
        customerDao.insertPerson(customer);
        return customer;
    }
}
