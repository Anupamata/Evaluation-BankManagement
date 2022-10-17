package bankManagement.service;

import bankManagement.model.Loan;

import java.util.List;

public interface LoanService {
    void insertLoan(Loan loan);
    List<Loan> getLoanByCustomerId(long id);
    List<Loan> fetchAllLoan();
    Loan getLoanById(long id);
}

