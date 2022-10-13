package bankManagement.service.impl;

import bankManagement.dao.CustomerDao;
import bankManagement.model.Customer;
import bankManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> fetchAllPerson() {
        return customerDao.fetchAllPersons();
    }
}
