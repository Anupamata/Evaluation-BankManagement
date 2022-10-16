package bankManagement.dao;

import bankManagement.model.Customer;
import bankManagement.model.Manager;

public interface ManagerDao {
    Manager login(String username, String password);
}
