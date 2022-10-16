package bankManagement.service.impl;

import bankManagement.dao.ManagerDao;
import bankManagement.model.Manager;
import bankManagement.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerDao managerDao;

    @Override
    public Manager login(String username, String password) {
        return managerDao.login(username,password);
    }

}
