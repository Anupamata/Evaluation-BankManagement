package bankManagement.repository;

import bankManagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("select loan from Loan loan where loan.customerId=:customerId")
    List<Loan> getByCustomerId(@Param("customerId") long id);
}
