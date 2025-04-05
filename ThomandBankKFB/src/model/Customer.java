package model;

import java.time.LocalDate;

public class Customer extends Person {
    int custNo;

    public Customer(String firstName, String lastName, String address, LocalDate dob, int custNo) {
        super(firstName, lastName, address, dob);
    }

    public int getCustNo() {
        return custNo;
    }

    public void setCustNo(int custNo) {
        this.custNo = custNo;
    }
}
