package com.denghb.zuiyou.openapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Created by denghb on 2017/4/29.
 */
public class LoanInfo {

    @JsonProperty("ListingId")
    private int id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("CreditCode")
    private String creditCode;

    @JsonProperty("Amount")
    private BigDecimal amount;

    @JsonProperty("Rate")
    private int rate;

    @JsonProperty("Months")
    private int months;

    @JsonProperty("PayWay")
    private Integer payWay;

    @JsonProperty("RemainFunding")
    private BigDecimal remain;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        return "LoanInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creditCode='" + creditCode + '\'' +
                ", amount=" + amount +
                ", rate=" + rate +
                ", months=" + months +
                ", payWay=" + payWay +
                ", remain=" + remain +
                '}';
    }
}
