package com.example.loansystemcalculator;

public class DisplayLoan {
    private String applicationID;
    private String email;
    private String loanType;
    private String loanAmount;
    private String dateApproved;
    private String status;

    public DisplayLoan(String applicationID, String email, String loanType, String loanAmount, String dateApproved, String status) {
        this.applicationID = applicationID;
        this.email = email;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.dateApproved = dateApproved;
        this.status = status;
    }
    public String getApplicationID() { return applicationID; }
    public String getEmail() { return email; }
    public String getLoanType() { return loanType; }
    public String getLoanAmount() { return loanAmount; }
    public String getDateApproved() { return dateApproved; }
    public String getStatus() { return status; }


    public void setApplicationID(String applicationID) { this.applicationID = applicationID; }
    public void setEmail(String email) { this.email = email; }
    public void setLoanType(String loanType) { this.loanType = loanType; }
    public void setLoanAmount(String loanAmount) { this.loanAmount = loanAmount; }
    public void setDateApproved(String dateApproved) { this.dateApproved = dateApproved; }
    public void setStatus(String status) { this.status = status; }
}
