package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `user_auth` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `pdu` varchar(20) DEFAULT '' COMMENT '绑定pdu',
  `is_open` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:关闭，1:开启',
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '用户余额',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:授权失败,1:授权成功',
  `token` text NOT NULL COMMENT 'cookie',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PDU` (`pdu`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DELETED` (`deleted`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 * @generateTime Sat Apr 29 22:22:27 CST 2017
 */
@Table(name="user_auth",database="zuiyou")
public class UserAuth implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Long id;
	
	/** 用户ID */
	@Column(name="user_id")
	private Long userId;
	
	/** 绑定pdu */
	@Column(name="pdu")
	private String pdu;
	
	/** 0:关闭，1:开启 */
	@Column(name="is_open")
	private Boolean isOpen;
	
	/** 用户余额 */
	@Column(name="balance")
	private java.math.BigDecimal balance;
	
	/** 0:授权失败,1:授权成功 */
	@Column(name="status")
	private Integer status;
	
	/** cookie */
	@Column(name="token")
	private String token;
	
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

	public Integer getStatus(){
		return status;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token){
		this.token = token;
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
		StringBuffer str = new StringBuffer("UserAuth [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("userId=\"");
		str.append(userId);
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
		str.append("status=\"");
		str.append(status);
		str.append("\"");
		str.append(",");
		str.append("token=\"");
		str.append(token);
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