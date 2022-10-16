package bankManagement.service;

import bankManagement.model.Manager;

public interface ManagerService {
     Manager login(String username, String password);
}
