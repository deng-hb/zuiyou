package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `loan` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '借款ID',
  `url` varchar(100) DEFAULT NULL COMMENT '借款详情地址',
  `title` varchar(100) DEFAULT NULL COMMENT '借款标题',
  `pdu` varchar(100) DEFAULT NULL COMMENT '借款pdu',
  `pdu_url` varchar(100) DEFAULT NULL COMMENT '借款人信息地址',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '借款金额',
  `limit` int(11) DEFAULT NULL COMMENT '期限月',
  `rate` decimal(10,2) DEFAULT NULL COMMENT '利率',
  `grade` varchar(10) DEFAULT NULL COMMENT '魔镜等级',
  `is_pei` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1:赔，0:非赔',
  `is_yushen` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1:预审，0:非预审',
  `auth_register` tinyint(4) NOT NULL DEFAULT '0' COMMENT '户籍认证',
  `auth_mobile` tinyint(4) NOT NULL DEFAULT '0' COMMENT '手机认证',
  `auth_edu` tinyint(4) NOT NULL DEFAULT '0' COMMENT '学历认证',
  `auth_ren_bank` tinyint(4) NOT NULL DEFAULT '0' COMMENT '人行征信认证',
  `auth_idno` tinyint(4) NOT NULL DEFAULT '1' COMMENT '身份证认证（默认）',
  `auth_video` tinyint(4) NOT NULL DEFAULT '0' COMMENT '视频认证',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DELETED` (`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 * @generateTime Thu Apr 27 20:22:27 CST 2017
 */
@Table(name="loan",database="zuiyou")
public class Loan implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 借款ID */
	@Id@Column(name="id")
	private Integer id;
	
	/** 借款详情地址 */
	@Column(name="url")
	private String url;
	
	/** 借款标题 */
	@Column(name="title")
	private String title;
	
	/** 借款pdu */
	@Column(name="pdu")
	private String pdu;
	
	/** 借款人信息地址 */
	@Column(name="pdu_url")
	private String pduUrl;
	
	/** 借款金额 */
	@Column(name="amount")
	private java.math.BigDecimal amount;
	
	/** 期限月 */
	@Column(name="limit")
	private Integer limit;
	
	/** 利率 */
	@Column(name="rate")
	private java.math.BigDecimal rate;
	
	/** 魔镜等级 */
	@Column(name="grade")
	private String grade;
	
	/** 1:赔，0:非赔 */
	@Column(name="is_pei")
	private Boolean isPei;
	
	/** 1:预审，0:非预审 */
	@Column(name="is_yushen")
	private Boolean isYushen;
	
	/** 户籍认证 */
	@Column(name="auth_register")
	private Boolean authRegister;
	
	/** 手机认证 */
	@Column(name="auth_mobile")
	private Boolean authMobile;
	
	/** 学历认证 */
	@Column(name="auth_edu")
	private Boolean authEdu;
	
	/** 人行征信认证 */
	@Column(name="auth_ren_bank")
	private Boolean authRenBank;
	
	/** 身份证认证（默认） */
	@Column(name="auth_idno")
	private Boolean authIdno;
	
	/** 视频认证 */
	@Column(name="auth_video")
	private Boolean authVideo;
	
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

	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getPdu(){
		return pdu;
	}

	public void setPdu(String pdu){
		this.pdu = pdu;
	}

	public String getPduUrl(){
		return pduUrl;
	}

	public void setPduUrl(String pduUrl){
		this.pduUrl = pduUrl;
	}

	public java.math.BigDecimal getAmount(){
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}

	public Integer getLimit(){
		return limit;
	}

	public void setLimit(Integer limit){
		this.limit = limit;
	}

	public java.math.BigDecimal getRate(){
		return rate;
	}

	public void setRate(java.math.BigDecimal rate){
		this.rate = rate;
	}

	public String getGrade(){
		return grade;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public Boolean getIsPei(){
		return isPei;
	}

	public void setIsPei(Boolean isPei){
		this.isPei = isPei;
	}

	public Boolean getIsYushen(){
		return isYushen;
	}

	public void setIsYushen(Boolean isYushen){
		this.isYushen = isYushen;
	}

	public Boolean getAuthRegister(){
		return authRegister;
	}

	public void setAuthRegister(Boolean authRegister){
		this.authRegister = authRegister;
	}

	public Boolean getAuthMobile(){
		return authMobile;
	}

	public void setAuthMobile(Boolean authMobile){
		this.authMobile = authMobile;
	}

	public Boolean getAuthEdu(){
		return authEdu;
	}

	public void setAuthEdu(Boolean authEdu){
		this.authEdu = authEdu;
	}

	public Boolean getAuthRenBank(){
		return authRenBank;
	}

	public void setAuthRenBank(Boolean authRenBank){
		this.authRenBank = authRenBank;
	}

	public Boolean getAuthIdno(){
		return authIdno;
	}

	public void setAuthIdno(Boolean authIdno){
		this.authIdno = authIdno;
	}

	public Boolean getAuthVideo(){
		return authVideo;
	}

	public void setAuthVideo(Boolean authVideo){
		this.authVideo = authVideo;
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
		StringBuffer str = new StringBuffer("Loan [");
		str.append("id=\"");
		str.append(id);
		str.append("\"");
		str.append(",");
		str.append("url=\"");
		str.append(url);
		str.append("\"");
		str.append(",");
		str.append("title=\"");
		str.append(title);
		str.append("\"");
		str.append(",");
		str.append("pdu=\"");
		str.append(pdu);
		str.append("\"");
		str.append(",");
		str.append("pduUrl=\"");
		str.append(pduUrl);
		str.append("\"");
		str.append(",");
		str.append("amount=\"");
		str.append(amount);
		str.append("\"");
		str.append(",");
		str.append("limit=\"");
		str.append(limit);
		str.append("\"");
		str.append(",");
		str.append("rate=\"");
		str.append(rate);
		str.append("\"");
		str.append(",");
		str.append("grade=\"");
		str.append(grade);
		str.append("\"");
		str.append(",");
		str.append("isPei=\"");
		str.append(isPei);
		str.append("\"");
		str.append(",");
		str.append("isYushen=\"");
		str.append(isYushen);
		str.append("\"");
		str.append(",");
		str.append("authRegister=\"");
		str.append(authRegister);
		str.append("\"");
		str.append(",");
		str.append("authMobile=\"");
		str.append(authMobile);
		str.append("\"");
		str.append(",");
		str.append("authEdu=\"");
		str.append(authEdu);
		str.append("\"");
		str.append(",");
		str.append("authRenBank=\"");
		str.append(authRenBank);
		str.append("\"");
		str.append(",");
		str.append("authIdno=\"");
		str.append(authIdno);
		str.append("\"");
		str.append(",");
		str.append("authVideo=\"");
		str.append(authVideo);
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