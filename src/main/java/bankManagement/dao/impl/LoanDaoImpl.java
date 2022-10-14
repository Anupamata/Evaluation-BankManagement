package bankManagement.dao.impl;

import bankManagement.dao.LoanDao;
import bankManagement.model.Loan;
import bankManagement.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class LoanDaoImpl implements LoanDao {
    @Autowired
    LoanRepository loanRepository;
    @Transactional
    public void  insertLoan(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public List<Loan> getByCustomerId(long id) {
        return loanRepository.getByCustomerId(id);
    }
}
