package com.denghb.zuiyou.handler.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by denghb on 2017/4/29.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanDetail implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标的ID
     */
    private Integer id;

    /**
     * 利率
     */
    private java.math.BigDecimal rate;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 借款金额
     */
    private java.math.BigDecimal amount;

    /**
     * 期限月
     */
    private Integer months;

    /**
     * 标的等级
     */
    private String creditCode;

    /**
     * 借款人的用户名
     */
    private String pdu;

    /**
     * 性别	1 男 2 女 0 未知
     */
    private Integer gender;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 学历
     */
    private String educationDegree;

    /**
     * 截止时间
     */
    private String deadLineTime;

    /**
     * 剩余可投金额
     */
    private java.math.BigDecimal remain;

    /**
     * 学习形式
     */
    private String studyStyle;

    /**
     * 投标人数
     */
    private Integer lenderCount;

    /**
     * 首次投资时间
     */
    private java.util.Date fistBidTime;

    /**
     * 最后投资时间
     */
    private java.util.Date lastBidTime;

    /**
     * 成交日期
     */
    private java.util.Date auditingTime;

    /**
     * 成功借款次数
     */
    private Integer successCount;

    /**
     * 流标次数
     */
    private Integer wasteCount;

    /**
     * 撤标次数
     */
    private Integer cancelCount;

    /**
     * 失败次数
     */
    private Integer failedCount;

    /**
     * 正常还清次数
     */
    private Integer normalCount;

    /**
     * 逾期(1-15)还清次数
     */
    private Integer overdueLessCount;

    /**
     * 逾期(15天以上)还清次数
     */
    private Integer overdueMoreCount;

    /**
     * 剩余待还本金
     */
    private java.math.BigDecimal owingPrincipal;

    /**
     * 待还金额
     */
    private java.math.BigDecimal owingAmount;

    /**
     * 待收金额
     */
    private java.math.BigDecimal amountToReceive;

    /**
     * 第一次成功借款时间
     */
    private java.util.Date firstSuccessBorrowTime;

    /**
     * 注册时间
     */
    private java.util.Date registerTime;

    /**
     * 学历认证	0 未认证 1已认证
     */
    private Integer certificateValidate;

    /**
     * 户籍认证	0 未认证 1已认证
     */
    private Integer nciicIdentityCheck;

    /**
     * 手机认证	0 未认证 1已认证
     */
    private Integer phoneValidate;

    /**
     * 视屏认证	0 未认证 1已认证
     */
    private Integer videoValidate;

    /**
     * 征信认证	0 未认证 1已认证
     */
    private Integer creditValidate;

    /**
     * 学籍认证	0 未认证 1已认证
     */
    private Integer educateValidate;


    /**
     * 标题
     */
    private String title;
    /**
     * 还款方式(0:等额本息(按月还款) 1:一次性还本付息)
     */
    private Integer payWay;

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("ListingId")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("rate")
    public java.math.BigDecimal getRate() {
        return rate;
    }

    @JsonProperty("CurrentRate")
    public void setRate(java.math.BigDecimal rate) {
        this.rate = rate;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("Age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("amount")
    public java.math.BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty("Amount")
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    @JsonProperty("months")
    public Integer getMonths() {
        return months;
    }

    @JsonProperty("Months")
    public void setMonths(Integer months) {
        this.months = months;
    }

    @JsonProperty("creditCode")
    public String getCreditCode() {
        return creditCode;
    }

    @JsonProperty("CreditCode")
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    @JsonProperty("pdu")
    public String getPdu() {
        return pdu;
    }

    @JsonProperty("BorrowName")
    public void setPdu(String pdu) {
        this.pdu = pdu;
    }

    @JsonProperty("gender")
    public Integer getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @JsonProperty("graduateSchool")
    public String getGraduateSchool() {
        return graduateSchool;
    }

    @JsonProperty("GraduateSchool")
    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    @JsonProperty("educationDegree")
    public String getEducationDegree() {
        return educationDegree;
    }

    @JsonProperty("EducationDegree")
    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    @JsonProperty("deadLineTime")
    public String getDeadLineTime() {
        return deadLineTime;
    }

    @JsonProperty("DeadLineTimeOrRemindTimeStr")
    public void setDeadLineTime(String deadLineTime) {
        this.deadLineTime = deadLineTime;
    }

    @JsonProperty("remain")
    public java.math.BigDecimal getRemain() {
        return remain;
    }

    @JsonProperty("RemainFunding")
    public void setRemain(java.math.BigDecimal remain) {
        this.remain = remain;
    }

    @JsonProperty("studyStyle")
    public String getStudyStyle() {
        return studyStyle;
    }

    @JsonProperty("StudyStyle")
    public void setStudyStyle(String studyStyle) {
        this.studyStyle = studyStyle;
    }

    @JsonProperty("lenderCount")
    public Integer getLenderCount() {
        return lenderCount;
    }

    @JsonProperty("LenderCount")
    public void setLenderCount(Integer lenderCount) {
        this.lenderCount = lenderCount;
    }

    @JsonProperty("fistBidTime")
    public java.util.Date getFistBidTime() {
        return fistBidTime;
    }

    @JsonProperty("FistBidTime")
    public void setFistBidTime(java.util.Date fistBidTime) {
        this.fistBidTime = fistBidTime;
    }

    @JsonProperty("lastBidTime")
    public java.util.Date getLastBidTime() {
        return lastBidTime;
    }

    @JsonProperty("LastBidTime")
    public void setLastBidTime(java.util.Date lastBidTime) {
        this.lastBidTime = lastBidTime;
    }

    @JsonProperty("auditingTime")
    public java.util.Date getAuditingTime() {
        return auditingTime;
    }

    @JsonProperty("AuditingTime")
    public void setAuditingTime(java.util.Date auditingTime) {
        this.auditingTime = auditingTime;
    }

    @JsonProperty("successCount")
    public Integer getSuccessCount() {
        return successCount;
    }

    @JsonProperty("SuccessCount")
    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    @JsonProperty("wasteCount")
    public Integer getWasteCount() {
        return wasteCount;
    }

    @JsonProperty("WasteCount")
    public void setWasteCount(Integer wasteCount) {
        this.wasteCount = wasteCount;
    }

    @JsonProperty("cancelCount")
    public Integer getCancelCount() {
        return cancelCount;
    }

    @JsonProperty("CancelCount")
    public void setCancelCount(Integer cancelCount) {
        this.cancelCount = cancelCount;
    }

    @JsonProperty("failedCount")
    public Integer getFailedCount() {
        return failedCount;
    }

    @JsonProperty("FailedCount")
    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    @JsonProperty("normalCount")
    public Integer getNormalCount() {
        return normalCount;
    }

    @JsonProperty("NormalCount")
    public void setNormalCount(Integer normalCount) {
        this.normalCount = normalCount;
    }

    @JsonProperty("overdueLessCount")
    public Integer getOverdueLessCount() {
        return overdueLessCount;
    }

    @JsonProperty("OverdueLessCount")
    public void setOverdueLessCount(Integer overdueLessCount) {
        this.overdueLessCount = overdueLessCount;
    }

    @JsonProperty("overdueMoreCount")
    public Integer getOverdueMoreCount() {
        return overdueMoreCount;
    }

    @JsonProperty("OverdueMoreCount")
    public void setOverdueMoreCount(Integer overdueMoreCount) {
        this.overdueMoreCount = overdueMoreCount;
    }

    @JsonProperty("owingPrincipal")
    public java.math.BigDecimal getOwingPrincipal() {
        return owingPrincipal;
    }

    @JsonProperty("OwingPrincipal")
    public void setOwingPrincipal(java.math.BigDecimal owingPrincipal) {
        this.owingPrincipal = owingPrincipal;
    }

    @JsonProperty("owingAmount")
    public java.math.BigDecimal getOwingAmount() {
        return owingAmount;
    }

    @JsonProperty("OwingAmount")
    public void setOwingAmount(java.math.BigDecimal owingAmount) {
        this.owingAmount = owingAmount;
    }

    @JsonProperty("amountToReceive")
    public java.math.BigDecimal getAmountToReceive() {
        return amountToReceive;
    }

    @JsonProperty("AmountToReceive")
    public void setAmountToReceive(java.math.BigDecimal amountToReceive) {
        this.amountToReceive = amountToReceive;
    }

    @JsonProperty("firstSuccessBorrowTime")
    public java.util.Date getFirstSuccessBorrowTime() {
        return firstSuccessBorrowTime;
    }

    @JsonProperty("FirstSuccessBorrowTime")
    public void setFirstSuccessBorrowTime(java.util.Date firstSuccessBorrowTime) {
        this.firstSuccessBorrowTime = firstSuccessBorrowTime;
    }

    @JsonProperty("registerTime")
    public java.util.Date getRegisterTime() {
        return registerTime;
    }

    @JsonProperty("RegisterTime")
    public void setRegisterTime(java.util.Date registerTime) {
        this.registerTime = registerTime;
    }

    @JsonProperty("certificateValidate")
    public Integer getCertificateValidate() {
        return certificateValidate;
    }

    @JsonProperty("CertificateValidate")
    public void setCertificateValidate(Integer certificateValidate) {
        this.certificateValidate = certificateValidate;
    }

    @JsonProperty("nciicIdentityCheck")
    public Integer getNciicIdentityCheck() {
        return nciicIdentityCheck;
    }

    @JsonProperty("NciicIdentityCheck")
    public void setNciicIdentityCheck(Integer nciicIdentityCheck) {
        this.nciicIdentityCheck = nciicIdentityCheck;
    }

    @JsonProperty("phoneValidate")
    public Integer getPhoneValidate() {
        return phoneValidate;
    }

    @JsonProperty("PhoneValidate")
    public void setPhoneValidate(Integer phoneValidate) {
        this.phoneValidate = phoneValidate;
    }

    @JsonProperty("videoValidate")
    public Integer getVideoValidate() {
        return videoValidate;
    }

    @JsonProperty("VideoValidate")
    public void setVideoValidate(Integer videoValidate) {
        this.videoValidate = videoValidate;
    }

    @JsonProperty("creditValidate")
    public Integer getCreditValidate() {
        return creditValidate;
    }

    @JsonProperty("CreditValidate")
    public void setCreditValidate(Integer creditValidate) {
        this.creditValidate = creditValidate;
    }

    @JsonProperty("educateValidate")
    public Integer getEducateValidate() {
        return educateValidate;
    }

    @JsonProperty("EducateValidate")
    public void setEducateValidate(Integer educateValidate) {
        this.educateValidate = educateValidate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    @Override
    public String toString() {
        return "LoanDetail{" +
                "id=" + id +
                ", rate=" + rate +
                ", age=" + age +
                ", amount=" + amount +
                ", months=" + months +
                ", creditCode='" + creditCode + '\'' +
                ", pdu='" + pdu + '\'' +
                ", gender=" + gender +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", educationDegree='" + educationDegree + '\'' +
                ", deadLineTime='" + deadLineTime + '\'' +
                ", remain=" + remain +
                ", studyStyle='" + studyStyle + '\'' +
                ", lenderCount=" + lenderCount +
                ", fistBidTime=" + fistBidTime +
                ", lastBidTime=" + lastBidTime +
                ", auditingTime=" + auditingTime +
                ", successCount=" + successCount +
                ", wasteCount=" + wasteCount +
                ", cancelCount=" + cancelCount +
                ", failedCount=" + failedCount +
                ", normalCount=" + normalCount +
                ", overdueLessCount=" + overdueLessCount +
                ", overdueMoreCount=" + overdueMoreCount +
                ", owingPrincipal=" + owingPrincipal +
                ", owingAmount=" + owingAmount +
                ", amountToReceive=" + amountToReceive +
                ", firstSuccessBorrowTime=" + firstSuccessBorrowTime +
                ", registerTime=" + registerTime +
                ", certificateValidate=" + certificateValidate +
                ", nciicIdentityCheck=" + nciicIdentityCheck +
                ", phoneValidate=" + phoneValidate +
                ", videoValidate=" + videoValidate +
                ", creditValidate=" + creditValidate +
                ", educateValidate=" + educateValidate +
                ", title='" + title + '\'' +
                ", payWay=" + payWay +
                '}';
    }
}

