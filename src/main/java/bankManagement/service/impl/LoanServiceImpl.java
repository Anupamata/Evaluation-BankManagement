package bankManagement.service.impl;

import bankManagement.dao.LoanDao;
import bankManagement.model.Customer;
import bankManagement.model.Loan;
import bankManagement.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanDao loanDao;
    @Override
    public void insertLoan(Loan loan) {
        loanDao.insertLoan(loan);
    }

    @Override
    public List<Loan> getByCustomerId(long id) {
        return loanDao.getByCustomerId(id);
    }
    @Override
    public List<Loan> fetchAllPerson() {
        return loanDao.fetchAllPersons();
    }
    @Override
        public Loan getLoanById(long id)  {
        Optional<Loan> optionalLoan=loanDao.getLoanById(id);
        return optionalLoan.orElse(null);
    }


}
