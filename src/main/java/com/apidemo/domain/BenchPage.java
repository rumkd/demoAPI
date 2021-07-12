package com.apidemo.domain;

import java.util.ArrayList;

/**
 * @author Urminder Deol
 *
 */
public class BenchPage {

    // would have liked to use this class to try to do paging

    private int totalCount;
    private int page;
    private ArrayList<Transaction> transactions;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
