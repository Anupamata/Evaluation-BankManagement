package bankManagement.dao;

import bankManagement.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDao {
    void insertLoan(Loan loan);
    List<Loan> getLoanByCustomerId(long id);
    List<Loan> fetchAllLoan();
    Optional<Loan> getLoanById(long id);
}
