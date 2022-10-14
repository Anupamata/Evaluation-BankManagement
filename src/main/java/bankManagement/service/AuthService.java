/*
package bankManagement.service;

import bankManagement.model.Customer;
import bankManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;
import java.util.logging.Logger;


public class AuthService {
    @Autowired
    public CustomerRepository customerRepository;
    private static Logger log = Logger.getLogger(String.valueOf(AuthService.class));


    public boolean findUser(String uname,String upwd) {
        log.info("Checking the user in the database");
        boolean isValidUser = false;
        try {
            List<Customer> userObj = (List<Customer>) customerRepository.findAll();
            userObj.
            if(userObj != null && userObj.size() > 0) {
                log.info("Id= " + userObj.get(0).getCustomerId() + ", Name= " + userObj.get(0).getCustName() + ", Password= " + userObj.get(0).getPassword());
                isValidUser = true;
            }
        } catch(Exception e) {
            isValidUser = false;
            log.info("An error occurred while fetching the user details from the database");
        }
        return isValidUser;
    }
}
*/
