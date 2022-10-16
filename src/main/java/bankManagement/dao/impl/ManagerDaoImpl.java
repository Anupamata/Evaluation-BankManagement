package bankManagement.dao.impl;

import bankManagement.dao.ManagerDao;
import bankManagement.model.Customer;
import bankManagement.model.Manager;
import bankManagement.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class ManagerDaoImpl implements ManagerDao {
    @Autowired
    ManagerRepository managerRepository;
    @Transactional
    public Manager login(String username, String password) {
        return managerRepository.login(username,password);
    }
}
