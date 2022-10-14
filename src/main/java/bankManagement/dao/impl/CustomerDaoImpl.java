package bankManagement.dao.impl;

import bankManagement.dao.CustomerDao;
import bankManagement.model.Customer;
import bankManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    CustomerRepository customerRepository;
    @Transactional
    public List<Customer> fetchAllPersons() {
        return customerRepository.findAll();
    }
    @Transactional
    public Customer login(String username, String password) {
        return customerRepository.login(username,password);
    }
    @Transactional
    public Optional<Customer> getPersonNameById(long id) {
        return customerRepository.findById(id);

    }
    @Transactional
    public void  insertPerson(Customer customer) {
        customerRepository.save(customer);
    }
}
