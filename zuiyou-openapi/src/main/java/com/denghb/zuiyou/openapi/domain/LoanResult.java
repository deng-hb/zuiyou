package com.denghb.zuiyou.openapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by denghb on 2017/4/29.
 */
public class LoanResult<T> {

    @JsonProperty("LoanInfos")
    private List<T> loanInfos;

    @JsonProperty("Result")
    private int result;

    @JsonProperty("ResultMessage")
    private String resultMessage;

    @JsonProperty("ResultCode")
    private Integer resultCode;

    public List<T> getLoanInfos() {
        return loanInfos;
    }

    public void setLoanInfos(List<T> loanInfos) {
        this.loanInfos = loanInfos;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
}
