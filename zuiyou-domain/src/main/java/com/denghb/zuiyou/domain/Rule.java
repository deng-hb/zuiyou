package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `rule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '规则名称',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '投标金额',
  `age_min` int(11) DEFAULT NULL COMMENT '最小年龄',
  `age_max` int(11) DEFAULT NULL COMMENT '最大年龄',
  `sex_is_men` tinyint(4) DEFAULT NULL COMMENT '性别男',
  `sex_is_women` tinyint(4) DEFAULT NULL COMMENT '性别女',
  `limit_min` int(11) DEFAULT NULL COMMENT '最短期限',
  `limit_max` int(11) DEFAULT NULL COMMENT '最长期限',
  `rate_min` int(11) DEFAULT NULL COMMENT '最小利率',
  `rate_max` int(11) DEFAULT NULL COMMENT '最大利率',
  `loan_amount_min` decimal(10,2) DEFAULT NULL COMMENT '最小借款金额',
  `loan_amount_max` decimal(10,2) DEFAULT NULL COMMENT '最大借款金额',
  `wait_repay_min` decimal(10,2) DEFAULT NULL COMMENT '最小待还金额',
  `wait_repay_max` decimal(10,2) DEFAULT NULL COMMENT '最大待还金额',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DELETED` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 * @generateTime Sat Apr 29 22:22:27 CST 2017
 */
@Table(name="rule",database="zuiyou")
public class Rule implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Long id;
	
	/** 规则名称 */
	@Column(name="name")
	private String name;
	
	/** 投标金额 */
	@Column(name="amount")
	private java.math.BigDecimal amount;
	
	/** 最小年龄 */
	@Column(name="age_min")
	private Integer ageMin;
	
	/** 最大年龄 */
	@Column(name="age_max")
	private Integer ageMax;
	
	/** 性别男 */
	@Column(name="sex_is_men")
	private Boolean sexIsMen;
	
	/** 性别女 */
	@Column(name="sex_is_women")
	private Boolean sexIsWomen;
	
	/** 最短期限 */
	@Column(name="limit_min")
	private Integer limitMin;
	
	/** 最长期限 */
	@Column(name="limit_max")
	private Integer limitMax;
	
	/** 最小利率 */
	@Column(name="rate_min")
	private Integer rateMin;
	
	/** 最大利率 */
	@Column(name="rate_max")
	private Integer rateMax;
	
	/** 最小借款金额 */
	@Column(name="loan_amount_min")
	private java.math.BigDecimal loanAmountMin;
	
	/** 最大借款金额 */
	@Column(name="loan_amount_max")
	private java.math.BigDecimal loanAmountMax;
	
	/** 最小待还金额 */
	@Column(name="wait_repay_min")
	private java.math.BigDecimal waitRepayMin;
	
	/** 最大待还金额 */
	@Column(name="wait_repay_max")
	private java.math.BigDecimal waitRepayMax;
	
	/** 插入时间 */
	@Column(name="created_time")
	private java.util.Date createdTime;
	
	/** 更新时间 */
	@Column(name="updated_time")
	private java.util.Date updatedTime;
	
	/** 逻辑删除 */
	@Column(name="deleted")
	private Boolean deleted;
	

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public java.math.BigDecimal getAmount(){
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}

	public Integer getAgeMin(){
		return ageMin;
	}

	public void setAgeMin(Integer ageMin){
		this.ageMin = ageMin;
	}

	public Integer getAgeMax(){
		return ageMax;
	}

	public void setAgeMax(Integer ageMax){
		this.ageMax = ageMax;
	}

	public Boolean getSexIsMen(){
		return sexIsMen;
	}

	public void setSexIsMen(Boolean sexIsMen){
		this.sexIsMen = sexIsMen;
	}

	public Boolean getSexIsWomen(){
		return sexIsWomen;
	}

	public void setSexIsWomen(Boolean sexIsWomen){
		this.sexIsWomen = sexIsWomen;
	}

	public Integer getLimitMin(){
		return limitMin;
	}

	public void setLimitMin(Integer limitMin){
		this.limitMin = limitMin;
	}

	public Integer getLimitMax(){
		return limitMax;
	}

	public void setLimitMax(Integer limitMax){
		this.limitMax = limitMax;
	}

	public Integer getRateMin(){
		return rateMin;
	}

	public void setRateMin(Integer rateMin){
		this.rateMin = rateMin;
	}

	public Integer getRateMax(){
		return rateMax;
	}

	public void setRateMax(Integer rateMax){
		this.rateMax = rateMax;
	}

	public java.math.BigDecimal getLoanAmountMin(){
		return loanAmountMin;
	}

	public void setLoanAmountMin(java.math.BigDecimal loanAmountMin){
		this.loanAmountMin = loanAmountMin;
	}

	public java.math.BigDecimal getLoanAmountMax(){
		return loanAmountMax;
	}

	public void setLoanAmountMax(java.math.BigDecimal loanAmountMax){
		this.loanAmountMax = loanAmountMax;
	}

	public java.math.BigDecimal getWaitRepayMin(){
		return waitRepayMin;
	}

	public void setWaitRepayMin(java.math.BigDecimal waitRepayMin){
		this.waitRepayMin = waitRepayMin;
	}

	public java.math.BigDecimal getWaitRepayMax(){
		return waitRepayMax;
	}

	public void setWaitRepayMax(java.math.BigDecimal waitRepayMax){
		this.waitRepayMax = waitRepayMax;
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
		StringBuffer str = new StringBuffer("Rule [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("name=\"");
		str.append(name);
		str.append("\"");
		str.append(",");
		str.append("amount=\"");
		str.append(amount);
		str.append("\"");
		str.append(",");
		str.append("ageMin=\"");
		str.append(ageMin);
		str.append("\"");
		str.append(",");
		str.append("ageMax=\"");
		str.append(ageMax);
		str.append("\"");
		str.append(",");
		str.append("sexIsMen=\"");
		str.append(sexIsMen);
		str.append("\"");
		str.append(",");
		str.append("sexIsWomen=\"");
		str.append(sexIsWomen);
		str.append("\"");
		str.append(",");
		str.append("limitMin=\"");
		str.append(limitMin);
		str.append("\"");
		str.append(",");
		str.append("limitMax=\"");
		str.append(limitMax);
		str.append("\"");
		str.append(",");
		str.append("rateMin=\"");
		str.append(rateMin);
		str.append("\"");
		str.append(",");
		str.append("rateMax=\"");
		str.append(rateMax);
		str.append("\"");
		str.append(",");
		str.append("loanAmountMin=\"");
		str.append(loanAmountMin);
		str.append("\"");
		str.append(",");
		str.append("loanAmountMax=\"");
		str.append(loanAmountMax);
		str.append("\"");
		str.append(",");
		str.append("waitRepayMin=\"");
		str.append(waitRepayMin);
		str.append("\"");
		str.append(",");
		str.append("waitRepayMax=\"");
		str.append(waitRepayMax);
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