package bankManagement.model;
import javax.persistence.*;

@Entity
@Table(name="loan")
public class Loan {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanId")
    private long loanId;
    @Column (name = "loanName")
    private String loanName;
    @Column (name = "loanAmount")
    private double loanAmount;
    @Column (name = "customerId")
    private long customerId;
    @Column(name = "status")
    private String status;

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long   customerId) {
        this.customerId = customerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
