package bankManagement.dao;

import bankManagement.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> fetchAllPersons();

    Customer login(String username, String password);
    Optional<Customer> getPersonNameById(long id);
    void insertPerson(Customer customer);
}
