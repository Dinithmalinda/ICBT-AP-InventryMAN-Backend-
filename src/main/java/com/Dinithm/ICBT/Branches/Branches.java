package com.Dinithm.ICBT.Branches;

import javax.persistence.*;

@Entity
@Table
public class Branches {

    @Id
    @SequenceGenerator(name="branches_sequence",sequenceName = "branches_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "branches_sequence")

    private int branchcode;
    private String name,address,TPnumber;

    public Branches(){}

    @Override
    public String toString() {
        return "Branches{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", TPnumber='" + TPnumber + '\'' +
                ", branchcode=" + branchcode +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTPnumber() {
        return TPnumber;
    }

    public void setTPnumber(String TPnumber) {
        this.TPnumber = TPnumber;
    }

    public int getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(int branchcode) {
        this.branchcode = branchcode;
    }
}
