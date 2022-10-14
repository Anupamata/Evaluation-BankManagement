package bankManagement.service.impl;

import bankManagement.dao.LoanDao;
import bankManagement.model.Loan;
import bankManagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanDao loanDao;
    @Override
    public void insertLoan(Loan loan) {
        loanDao.insertLoan(loan);
    }
}
