package bankManagement.service;

import bankManagement.model.Customer;
import org.springframework.data.repository.query.Param;

import java.security.acl.LastOwnerException;
import java.util.List;

public interface CustomerService {
    List<Customer> fetchAllPerson();
    public Customer login(String username,String password);
    Customer getPersonById(long personId);
    void insertPerson(Customer customer);

}
