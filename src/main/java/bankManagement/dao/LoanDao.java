package bankManagement.dao;

import bankManagement.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDao {
    void insertLoan(Loan loan);
    List<Loan> getByCustomerId(long id);
    List<Loan> fetchAllPersons();
    Optional<Loan> getLoanById(long id);
}
