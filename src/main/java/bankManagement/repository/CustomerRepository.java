package bankManagement.repository;

import bankManagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select customer from Customer customer where customer.username=:username and customer.password=:password")
    public Customer login(@Param("username") String username,@Param("password") String password);
}
