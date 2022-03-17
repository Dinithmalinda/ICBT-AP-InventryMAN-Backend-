package com.Dinithm.ICBT.INVOICE;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

@Entity
@Table
public class Invoce {
    @Id
    @SequenceGenerator(name="invoice_sequence",sequenceName = "invoice_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "invoice_sequence")

    private  long invoiceid;
    private  long customerid,branchcode;
    private String itemcodelist;
    private LocalDate date;

    public Invoce() {}

    public Invoce( long customerid, long branchcode, String itemcodelist, LocalDate date) {
        this.customerid = customerid;
        this.branchcode = branchcode;
        this.itemcodelist = itemcodelist;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoce{" +
                "invoiceid=" + invoiceid +
                ", customerid=" + customerid +
                ", branchcode=" + branchcode +
                ", itemcodelist='" + itemcodelist + '\'' +
                ", date=" + date +
                '}';
    }

    public long getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(long invoiceid) {
        this.invoiceid = invoiceid;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public long getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(long branchcode) {
        this.branchcode = branchcode;
    }

    public String getItemcodelist() {
        return itemcodelist;
    }

    public void setItemcodelist(String itemcodelist) {
        this.itemcodelist = itemcodelist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
