package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `user_rule_auth` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `rule_id` int(11) DEFAULT NULL COMMENT '规则ID',
  `pdu` varchar(20) NOT NULL COMMENT '绑定pdu',
  `is_open` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:关闭，1:开启',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `auth` varchar(1000) NOT NULL DEFAULT '',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PDU` (`pdu`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DELETED` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 * @generateTime Tue Apr 18 00:49:08 CST 2017
 */
@Table(name="user_rule_auth",database="crazy_invest")
public class UserRuleAuth implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Long id;
	
	/** 用户ID */
	@Column(name="user_id")
	private Long userId;
	
	/** 规则ID */
	@Column(name="rule_id")
	private Integer ruleId;
	
	/** 绑定pdu */
	@Column(name="pdu")
	private String pdu;
	
	/** 0:关闭，1:开启 */
	@Column(name="is_open")
	private Boolean isOpen;
	
	/** 用户余额 */
	@Column(name="balance")
	private java.math.BigDecimal balance;
	
	/**  */
	@Column(name="auth")
	private String auth;
	
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

	public Long getUserId(){
		return userId;
	}

	public void setUserId(Long userId){
		this.userId = userId;
	}

	public Integer getRuleId(){
		return ruleId;
	}

	public void setRuleId(Integer ruleId){
		this.ruleId = ruleId;
	}

	public String getPdu(){
		return pdu;
	}

	public void setPdu(String pdu){
		this.pdu = pdu;
	}

	public Boolean getIsOpen(){
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen){
		this.isOpen = isOpen;
	}

	public java.math.BigDecimal getBalance(){
		return balance;
	}

	public void setBalance(java.math.BigDecimal balance){
		this.balance = balance;
	}

	public String getAuth(){
		return auth;
	}

	public void setAuth(String auth){
		this.auth = auth;
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
		StringBuffer str = new StringBuffer("UserRuleAuth [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("userId=\"");
		str.append(userId);
		str.append("\"");
		str.append(",");
		str.append("ruleId=\"");
		str.append(ruleId);
		str.append("\"");
		str.append(",");
		str.append("pdu=\"");
		str.append(pdu);
		str.append("\"");
		str.append(",");
		str.append("isOpen=\"");
		str.append(isOpen);
		str.append("\"");
		str.append(",");
		str.append("balance=\"");
		str.append(balance);
		str.append("\"");
		str.append(",");
		str.append("auth=\"");
		str.append(auth);
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