package model;

import java.time.LocalDate;

abstract class BankStaff extends Person {
    int empNo;

    public BankStaff(String firstName, String lastName, String address, LocalDate dob, int empNo) {
        super(firstName, lastName, address, dob);
        this.empNo = empNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
}
