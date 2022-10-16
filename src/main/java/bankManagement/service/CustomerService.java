package bankManagement.service;

import bankManagement.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> fetchAllPerson();
     Customer login(String username,String password);
    Customer getPersonById(long personId);
    Customer insertPerson(Customer customer);

}
