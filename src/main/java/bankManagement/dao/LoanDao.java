package bankManagement.dao;

import bankManagement.model.Loan;

import java.util.List;

public interface LoanDao {
    void insertLoan(Loan loan);
    List<Loan> getByCustomerId(long id);
}
