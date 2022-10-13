package bankManagement.dao.impl;

import bankManagement.dao.CustomerDao;
import bankManagement.model.Customer;
import bankManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> fetchAllPersons() {
        return customerRepository.findAll();

    }
}
