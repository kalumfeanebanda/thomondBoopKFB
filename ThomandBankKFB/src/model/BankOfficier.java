package model;

import java.time.LocalDate;

public class BankOfficier extends BankStaff {
    String jobTitle;

    public BankOfficier(String firstName, String lastName, String address, LocalDate dob, int empNo , String jobTitle) {
        super(firstName, lastName, address, dob, empNo);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
