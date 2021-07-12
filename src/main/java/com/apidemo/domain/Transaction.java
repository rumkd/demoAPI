package com.apidemo.domain;

/**
 * @author Urminder Deol
 * Represents each transaction entity returned from the api
 */
public class Transaction {
    private String Date;
    private String Ledger;
    private String Amount;
    private String Company;

    public Transaction(String date, String ledger, String amount, String company) {
        Date = date;
        Ledger = ledger;
        Amount = amount;
        Company = company;
    }

    public String getDate() {
        return Date;
    }

    public String getLedger() {
        return Ledger;
    }

    public String getAmount() {
        return Amount;
    }

    public String getCompany() {
        return Company;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setLedger(String ledger) {
        Ledger = ledger;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
