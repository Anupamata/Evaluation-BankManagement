package bankManagement.service;

import bankManagement.model.Customer;
import bankManagement.model.Loan;

import java.util.List;

public interface LoanService {
    void insertLoan(Loan loan);
    List<Loan> getByCustomerId(long id);
    List<Loan> fetchAllPerson();
    Loan getLoanById(long id);
}

