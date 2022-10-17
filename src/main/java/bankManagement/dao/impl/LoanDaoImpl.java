package bankManagement.dao.impl;

import bankManagement.dao.LoanDao;
import bankManagement.model.Loan;
import bankManagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class LoanDaoImpl implements LoanDao {
    @Autowired
    LoanRepository loanRepository;
    @Transactional
    public void  insertLoan(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public List<Loan> getLoanByCustomerId(long id) {
        return loanRepository.getByCustomerId(id);
    }
    @Transactional
    public List<Loan> fetchAllLoan() {
        return loanRepository.findAll();
    }
    @Transactional
    public Optional<Loan> getLoanById(long id) {
        return loanRepository.findById(id);

    }
}
