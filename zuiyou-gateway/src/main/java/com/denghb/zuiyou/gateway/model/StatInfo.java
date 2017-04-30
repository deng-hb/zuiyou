package com.denghb.zuiyou.gateway.model;

import java.math.BigDecimal;

/**
 * Created by ppd on 2017/4/10.
 */
public class StatInfo {

    private int loanCount;
    private int pduCount;
    private BigDecimal totalAmount;

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    public int getPduCount() {
        return pduCount;
    }

    public void setPduCount(int pduCount) {
        this.pduCount = pduCount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "StatInfo{" +
                "loanCount=" + loanCount +
                ", pduCount=" + pduCount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
