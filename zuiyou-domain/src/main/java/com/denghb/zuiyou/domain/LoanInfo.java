package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `loan_info` (
  `id` int(11) unsigned NOT NULL COMMENT '标的ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `rate` decimal(10,2) DEFAULT NULL COMMENT '利率',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '借款金额',
  `months` int(11) DEFAULT NULL COMMENT '期限月',
  `credit_code` varchar(20) DEFAULT NULL COMMENT '标的等级',
  `pdu` varchar(20) DEFAULT NULL COMMENT '借款人的用户名 ',
  `gender` int(11) DEFAULT NULL COMMENT '性别	1 男 2 女 0 未知 ',
  `pay_way` int(11) DEFAULT NULL COMMENT '还款方式(0:等额本息(按月还款) 1:一次性还本付息)',
  `graduate_school` varchar(100) DEFAULT NULL COMMENT '毕业院校 ',
  `education_degree` varchar(100) DEFAULT NULL COMMENT '学历',
  `dead_line_time` varchar(100) DEFAULT NULL COMMENT '截止时间',
  `remain` decimal(10,2) DEFAULT NULL COMMENT '剩余可投金额',
  `study_style` varchar(20) DEFAULT NULL COMMENT '学习形式',
  `lender_count` int(11) DEFAULT NULL COMMENT '投标人数',
  `fist_bid_time` datetime DEFAULT NULL COMMENT '首次投资时间',
  `last_bid_time` datetime DEFAULT NULL COMMENT '最后投资时间',
  `auditing_time` datetime DEFAULT NULL COMMENT '成交日期',
  `success_count` int(11) DEFAULT NULL COMMENT '成功借款次数',
  `waste_count` int(11) DEFAULT NULL COMMENT '流标次数',
  `cancel_count` int(11) DEFAULT NULL COMMENT '撤标次数',
  `failed_count` int(11) DEFAULT NULL COMMENT '失败次数',
  `normal_count` int(11) DEFAULT NULL COMMENT '正常还清次数',
  `overdue_less_count` int(11) DEFAULT NULL COMMENT '逾期(1-15)还清次数 ',
  `overdue_more_count` int(11) DEFAULT NULL COMMENT '逾期(15天以上)还清次数',
  `owing_principal` decimal(10,2) DEFAULT NULL COMMENT '剩余待还本金 ',
  `owing_amount` decimal(10,2) DEFAULT NULL COMMENT '待还金额 ',
  `amount_to_receive` decimal(10,2) DEFAULT NULL COMMENT '待收金额',
  `first_success_borrow_time` datetime DEFAULT NULL COMMENT '第一次成功借款时间',
  `register_time` datetime DEFAULT NULL COMMENT '注册时间',
  `certificate_validate` int(11) DEFAULT NULL COMMENT '学历认证	0 未认证 1已认证 ',
  `nciic_identity_check` int(11) DEFAULT NULL COMMENT '户籍认证	0 未认证 1已认证 ',
  `phone_validate` int(11) DEFAULT NULL COMMENT '手机认证	0 未认证 1已认证 ',
  `video_validate` int(11) DEFAULT NULL COMMENT '视屏认证	0 未认证 1已认证 ',
  `credit_validate` int(11) DEFAULT NULL COMMENT '征信认证	0 未认证 1已认证 ',
  `educate_validate` int(11) DEFAULT NULL COMMENT '学籍认证	0 未认证 1已认证',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DETELED` (`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
 <pre>
 * @author DbHelper
 * @generateTime Sat Apr 29 22:22:26 CST 2017
 */
@Table(name="loan_info",database="zuiyou")
public class LoanInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 标的ID */
	@Id@Column(name="id")
	private Integer id;
	
	/** 标题 */
	@Column(name="title")
	private String title;
	
	/** 利率 */
	@Column(name="rate")
	private java.math.BigDecimal rate;
	
	/** 年龄 */
	@Column(name="age")
	private Integer age;
	
	/** 借款金额 */
	@Column(name="amount")
	private java.math.BigDecimal amount;
	
	/** 期限月 */
	@Column(name="months")
	private Integer months;
	
	/** 标的等级 */
	@Column(name="credit_code")
	private String creditCode;
	
	/** 借款人的用户名  */
	@Column(name="pdu")
	private String pdu;
	
	/** 性别	1 男 2 女 0 未知  */
	@Column(name="gender")
	private Integer gender;
	
	/** 还款方式(0:等额本息(按月还款) 1:一次性还本付息) */
	@Column(name="pay_way")
	private Integer payWay;
	
	/** 毕业院校  */
	@Column(name="graduate_school")
	private String graduateSchool;
	
	/** 学历 */
	@Column(name="education_degree")
	private String educationDegree;
	
	/** 截止时间 */
	@Column(name="dead_line_time")
	private String deadLineTime;
	
	/** 剩余可投金额 */
	@Column(name="remain")
	private java.math.BigDecimal remain;
	
	/** 学习形式 */
	@Column(name="study_style")
	private String studyStyle;
	
	/** 投标人数 */
	@Column(name="lender_count")
	private Integer lenderCount;
	
	/** 首次投资时间 */
	@Column(name="fist_bid_time")
	private java.util.Date fistBidTime;
	
	/** 最后投资时间 */
	@Column(name="last_bid_time")
	private java.util.Date lastBidTime;
	
	/** 成交日期 */
	@Column(name="auditing_time")
	private java.util.Date auditingTime;
	
	/** 成功借款次数 */
	@Column(name="success_count")
	private Integer successCount;
	
	/** 流标次数 */
	@Column(name="waste_count")
	private Integer wasteCount;
	
	/** 撤标次数 */
	@Column(name="cancel_count")
	private Integer cancelCount;
	
	/** 失败次数 */
	@Column(name="failed_count")
	private Integer failedCount;
	
	/** 正常还清次数 */
	@Column(name="normal_count")
	private Integer normalCount;
	
	/** 逾期(1-15)还清次数  */
	@Column(name="overdue_less_count")
	private Integer overdueLessCount;
	
	/** 逾期(15天以上)还清次数 */
	@Column(name="overdue_more_count")
	private Integer overdueMoreCount;
	
	/** 剩余待还本金  */
	@Column(name="owing_principal")
	private java.math.BigDecimal owingPrincipal;
	
	/** 待还金额  */
	@Column(name="owing_amount")
	private java.math.BigDecimal owingAmount;
	
	/** 待收金额 */
	@Column(name="amount_to_receive")
	private java.math.BigDecimal amountToReceive;
	
	/** 第一次成功借款时间 */
	@Column(name="first_success_borrow_time")
	private java.util.Date firstSuccessBorrowTime;
	
	/** 注册时间 */
	@Column(name="register_time")
	private java.util.Date registerTime;
	
	/** 学历认证	0 未认证 1已认证  */
	@Column(name="certificate_validate")
	private Integer certificateValidate;
	
	/** 户籍认证	0 未认证 1已认证  */
	@Column(name="nciic_identity_check")
	private Integer nciicIdentityCheck;
	
	/** 手机认证	0 未认证 1已认证  */
	@Column(name="phone_validate")
	private Integer phoneValidate;
	
	/** 视屏认证	0 未认证 1已认证  */
	@Column(name="video_validate")
	private Integer videoValidate;
	
	/** 征信认证	0 未认证 1已认证  */
	@Column(name="credit_validate")
	private Integer creditValidate;
	
	/** 学籍认证	0 未认证 1已认证 */
	@Column(name="educate_validate")
	private Integer educateValidate;
	
	/** 插入时间 */
	@Column(name="created_time")
	private java.util.Date createdTime;
	
	/** 更新时间 */
	@Column(name="updated_time")
	private java.util.Date updatedTime;
	
	/** 逻辑删除 */
	@Column(name="deleted")
	private Boolean deleted;
	

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public java.math.BigDecimal getRate(){
		return rate;
	}

	public void setRate(java.math.BigDecimal rate){
		this.rate = rate;
	}

	public Integer getAge(){
		return age;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	public java.math.BigDecimal getAmount(){
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}

	public Integer getMonths(){
		return months;
	}

	public void setMonths(Integer months){
		this.months = months;
	}

	public String getCreditCode(){
		return creditCode;
	}

	public void setCreditCode(String creditCode){
		this.creditCode = creditCode;
	}

	public String getPdu(){
		return pdu;
	}

	public void setPdu(String pdu){
		this.pdu = pdu;
	}

	public Integer getGender(){
		return gender;
	}

	public void setGender(Integer gender){
		this.gender = gender;
	}

	public Integer getPayWay(){
		return payWay;
	}

	public void setPayWay(Integer payWay){
		this.payWay = payWay;
	}

	public String getGraduateSchool(){
		return graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool){
		this.graduateSchool = graduateSchool;
	}

	public String getEducationDegree(){
		return educationDegree;
	}

	public void setEducationDegree(String educationDegree){
		this.educationDegree = educationDegree;
	}

	public String getDeadLineTime(){
		return deadLineTime;
	}

	public void setDeadLineTime(String deadLineTime){
		this.deadLineTime = deadLineTime;
	}

	public java.math.BigDecimal getRemain(){
		return remain;
	}

	public void setRemain(java.math.BigDecimal remain){
		this.remain = remain;
	}

	public String getStudyStyle(){
		return studyStyle;
	}

	public void setStudyStyle(String studyStyle){
		this.studyStyle = studyStyle;
	}

	public Integer getLenderCount(){
		return lenderCount;
	}

	public void setLenderCount(Integer lenderCount){
		this.lenderCount = lenderCount;
	}

	public java.util.Date getFistBidTime(){
		return fistBidTime;
	}

	public void setFistBidTime(java.util.Date fistBidTime){
		this.fistBidTime = fistBidTime;
	}

	public java.util.Date getLastBidTime(){
		return lastBidTime;
	}

	public void setLastBidTime(java.util.Date lastBidTime){
		this.lastBidTime = lastBidTime;
	}

	public java.util.Date getAuditingTime(){
		return auditingTime;
	}

	public void setAuditingTime(java.util.Date auditingTime){
		this.auditingTime = auditingTime;
	}

	public Integer getSuccessCount(){
		return successCount;
	}

	public void setSuccessCount(Integer successCount){
		this.successCount = successCount;
	}

	public Integer getWasteCount(){
		return wasteCount;
	}

	public void setWasteCount(Integer wasteCount){
		this.wasteCount = wasteCount;
	}

	public Integer getCancelCount(){
		return cancelCount;
	}

	public void setCancelCount(Integer cancelCount){
		this.cancelCount = cancelCount;
	}

	public Integer getFailedCount(){
		return failedCount;
	}

	public void setFailedCount(Integer failedCount){
		this.failedCount = failedCount;
	}

	public Integer getNormalCount(){
		return normalCount;
	}

	public void setNormalCount(Integer normalCount){
		this.normalCount = normalCount;
	}

	public Integer getOverdueLessCount(){
		return overdueLessCount;
	}

	public void setOverdueLessCount(Integer overdueLessCount){
		this.overdueLessCount = overdueLessCount;
	}

	public Integer getOverdueMoreCount(){
		return overdueMoreCount;
	}

	public void setOverdueMoreCount(Integer overdueMoreCount){
		this.overdueMoreCount = overdueMoreCount;
	}

	public java.math.BigDecimal getOwingPrincipal(){
		return owingPrincipal;
	}

	public void setOwingPrincipal(java.math.BigDecimal owingPrincipal){
		this.owingPrincipal = owingPrincipal;
	}

	public java.math.BigDecimal getOwingAmount(){
		return owingAmount;
	}

	public void setOwingAmount(java.math.BigDecimal owingAmount){
		this.owingAmount = owingAmount;
	}

	public java.math.BigDecimal getAmountToReceive(){
		return amountToReceive;
	}

	public void setAmountToReceive(java.math.BigDecimal amountToReceive){
		this.amountToReceive = amountToReceive;
	}

	public java.util.Date getFirstSuccessBorrowTime(){
		return firstSuccessBorrowTime;
	}

	public void setFirstSuccessBorrowTime(java.util.Date firstSuccessBorrowTime){
		this.firstSuccessBorrowTime = firstSuccessBorrowTime;
	}

	public java.util.Date getRegisterTime(){
		return registerTime;
	}

	public void setRegisterTime(java.util.Date registerTime){
		this.registerTime = registerTime;
	}

	public Integer getCertificateValidate(){
		return certificateValidate;
	}

	public void setCertificateValidate(Integer certificateValidate){
		this.certificateValidate = certificateValidate;
	}

	public Integer getNciicIdentityCheck(){
		return nciicIdentityCheck;
	}

	public void setNciicIdentityCheck(Integer nciicIdentityCheck){
		this.nciicIdentityCheck = nciicIdentityCheck;
	}

	public Integer getPhoneValidate(){
		return phoneValidate;
	}

	public void setPhoneValidate(Integer phoneValidate){
		this.phoneValidate = phoneValidate;
	}

	public Integer getVideoValidate(){
		return videoValidate;
	}

	public void setVideoValidate(Integer videoValidate){
		this.videoValidate = videoValidate;
	}

	public Integer getCreditValidate(){
		return creditValidate;
	}

	public void setCreditValidate(Integer creditValidate){
		this.creditValidate = creditValidate;
	}

	public Integer getEducateValidate(){
		return educateValidate;
	}

	public void setEducateValidate(Integer educateValidate){
		this.educateValidate = educateValidate;
	}

	public java.util.Date getCreatedTime(){
		return createdTime;
	}

	public void setCreatedTime(java.util.Date createdTime){
		this.createdTime = createdTime;
	}

	public java.util.Date getUpdatedTime(){
		return updatedTime;
	}

	public void setUpdatedTime(java.util.Date updatedTime){
		this.updatedTime = updatedTime;
	}

	public Boolean getDeleted(){
		return deleted;
	}

	public void setDeleted(Boolean deleted){
		this.deleted = deleted;
	}

	@Override
	public String toString(){
		StringBuffer str = new StringBuffer("LoanInfo [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("title=\"");
		str.append(title);
		str.append("\"");
		str.append(",");
		str.append("rate=\"");
		str.append(rate);
		str.append("\"");
		str.append(",");
		str.append("age=\"");
		str.append(age);
		str.append("\"");
		str.append(",");
		str.append("amount=\"");
		str.append(amount);
		str.append("\"");
		str.append(",");
		str.append("months=\"");
		str.append(months);
		str.append("\"");
		str.append(",");
		str.append("creditCode=\"");
		str.append(creditCode);
		str.append("\"");
		str.append(",");
		str.append("pdu=\"");
		str.append(pdu);
		str.append("\"");
		str.append(",");
		str.append("gender=\"");
		str.append(gender);
		str.append("\"");
		str.append(",");
		str.append("payWay=\"");
		str.append(payWay);
		str.append("\"");
		str.append(",");
		str.append("graduateSchool=\"");
		str.append(graduateSchool);
		str.append("\"");
		str.append(",");
		str.append("educationDegree=\"");
		str.append(educationDegree);
		str.append("\"");
		str.append(",");
		str.append("deadLineTime=\"");
		str.append(deadLineTime);
		str.append("\"");
		str.append(",");
		str.append("remain=\"");
		str.append(remain);
		str.append("\"");
		str.append(",");
		str.append("studyStyle=\"");
		str.append(studyStyle);
		str.append("\"");
		str.append(",");
		str.append("lenderCount=\"");
		str.append(lenderCount);
		str.append("\"");
		str.append(",");
		str.append("fistBidTime=\"");
		str.append(fistBidTime);
		str.append("\"");
		str.append(",");
		str.append("lastBidTime=\"");
		str.append(lastBidTime);
		str.append("\"");
		str.append(",");
		str.append("auditingTime=\"");
		str.append(auditingTime);
		str.append("\"");
		str.append(",");
		str.append("successCount=\"");
		str.append(successCount);
		str.append("\"");
		str.append(",");
		str.append("wasteCount=\"");
		str.append(wasteCount);
		str.append("\"");
		str.append(",");
		str.append("cancelCount=\"");
		str.append(cancelCount);
		str.append("\"");
		str.append(",");
		str.append("failedCount=\"");
		str.append(failedCount);
		str.append("\"");
		str.append(",");
		str.append("normalCount=\"");
		str.append(normalCount);
		str.append("\"");
		str.append(",");
		str.append("overdueLessCount=\"");
		str.append(overdueLessCount);
		str.append("\"");
		str.append(",");
		str.append("overdueMoreCount=\"");
		str.append(overdueMoreCount);
		str.append("\"");
		str.append(",");
		str.append("owingPrincipal=\"");
		str.append(owingPrincipal);
		str.append("\"");
		str.append(",");
		str.append("owingAmount=\"");
		str.append(owingAmount);
		str.append("\"");
		str.append(",");
		str.append("amountToReceive=\"");
		str.append(amountToReceive);
		str.append("\"");
		str.append(",");
		str.append("firstSuccessBorrowTime=\"");
		str.append(firstSuccessBorrowTime);
		str.append("\"");
		str.append(",");
		str.append("registerTime=\"");
		str.append(registerTime);
		str.append("\"");
		str.append(",");
		str.append("certificateValidate=\"");
		str.append(certificateValidate);
		str.append("\"");
		str.append(",");
		str.append("nciicIdentityCheck=\"");
		str.append(nciicIdentityCheck);
		str.append("\"");
		str.append(",");
		str.append("phoneValidate=\"");
		str.append(phoneValidate);
		str.append("\"");
		str.append(",");
		str.append("videoValidate=\"");
		str.append(videoValidate);
		str.append("\"");
		str.append(",");
		str.append("creditValidate=\"");
		str.append(creditValidate);
		str.append("\"");
		str.append(",");
		str.append("educateValidate=\"");
		str.append(educateValidate);
		str.append("\"");
		str.append(",");
		str.append("createdTime=\"");
		str.append(createdTime);
		str.append("\"");
		str.append(",");
		str.append("updatedTime=\"");
		str.append(updatedTime);
		str.append("\"");
		str.append(",");
		str.append("deleted=\"");
		str.append(deleted);
		str.append("\"");
		
		str.append("]");
	
		return str.toString();
	}
}