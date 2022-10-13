package bankManagement.dao;

import bankManagement.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> fetchAllPersons();
}
