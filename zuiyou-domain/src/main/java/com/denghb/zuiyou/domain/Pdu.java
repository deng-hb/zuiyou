package com.denghb.zuiyou.domain;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

/**
 * 
 * DDL
 * 
 <pre>
CREATE TABLE `pdu` (
  `pdu` varchar(50) NOT NULL DEFAULT '' COMMENT '用户编号',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '0:女,1:男',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `grade` varchar(20) DEFAULT NULL COMMENT '魔镜等级',
  `school` varchar(11) DEFAULT NULL COMMENT '学校',
  `edu` varchar(20) DEFAULT NULL COMMENT '学历',
  `study_mode` varchar(20) DEFAULT NULL COMMENT '学习形式',
  `auth_mobile` tinyint(4) NOT NULL DEFAULT '0' COMMENT '手机认证',
  `auth_idno` tinyint(4) NOT NULL DEFAULT '0' COMMENT '身份证认证',
  `auth_edu` tinyint(4) NOT NULL DEFAULT '0' COMMENT '学历认证',
  `auth_register` tinyint(4) NOT NULL DEFAULT '0' COMMENT '户籍认证',
  `auth_ren_bank` tinyint(4) NOT NULL DEFAULT '0' COMMENT '人行征信认证',
  `auth_video` tinyint(4) NOT NULL DEFAULT '0' COMMENT '视频认证',
  `succ_loan_size` int(11) DEFAULT NULL COMMENT '成功借款次数',
  `first_loan_date` varchar(20) DEFAULT NULL COMMENT '第一次借款日期',
  `un_loan_size` int(11) DEFAULT NULL COMMENT '流标次数',
  `cancel_loan_size` int(11) DEFAULT NULL COMMENT '撤销次数',
  `lose_loan_size` int(11) DEFAULT NULL COMMENT '失败次数',
  `succ_repay_size` int(11) DEFAULT NULL COMMENT '成功还款次数',
  `delay_lt15_repay_size` int(11) DEFAULT NULL COMMENT '逾期小于15天还款次数',
  `delay_gt15_repay_size` int(11) DEFAULT NULL COMMENT '逾期大于15天还款次数',
  `max_delay_repay_size` int(11) DEFAULT NULL COMMENT '最大逾期天数',
  `total_loan_amount` decimal(10,2) DEFAULT NULL COMMENT '累计借款金额',
  `single_max_loan_amount` decimal(10,2) DEFAULT NULL COMMENT '单笔最大借款金额',
  `wait_repay_amount` decimal(10,2) DEFAULT NULL COMMENT '待还金额',
  `wait_collect_amount` decimal(10,2) DEFAULT NULL COMMENT '待收金额',
  `history_high_owe` decimal(10,2) DEFAULT NULL COMMENT '历史最高负债',
  `auth_amount` decimal(10,2) DEFAULT NULL COMMENT '授权额度',
  `auth_balance` decimal(10,2) DEFAULT NULL COMMENT '借款余额',
  `header_img_url` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`pdu`),
  KEY `IDX_CREATED_TIME` (`created_time`),
  KEY `IDX_UPDATED_TIME` (`updated_time`),
  KEY `IDX_DELETED` (`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 <pre>
 * @author DbHelper
 * @generateTime Sat Apr 22 23:35:45 CST 2017
 */
@Table(name="pdu",database="crazy_invest")
public class Pdu implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 用户编号 */
	@Id@Column(name="pdu")
	private String pdu;
	
	/** 年龄 */
	@Column(name="age")
	private Integer age;
	
	/** 0:女,1:男 */
	@Column(name="sex")
	private Integer sex;
	
	/** 注册时间 */
	@Column(name="reg_date")
	private String regDate;
	
	/** 魔镜等级 */
	@Column(name="grade")
	private String grade;
	
	/** 学校 */
	@Column(name="school")
	private String school;
	
	/** 学历 */
	@Column(name="edu")
	private String edu;
	
	/** 学习形式 */
	@Column(name="study_mode")
	private String studyMode;
	
	/** 手机认证 */
	@Column(name="auth_mobile")
	private Boolean authMobile;
	
	/** 身份证认证 */
	@Column(name="auth_idno")
	private Boolean authIdno;
	
	/** 学历认证 */
	@Column(name="auth_edu")
	private Boolean authEdu;
	
	/** 户籍认证 */
	@Column(name="auth_register")
	private Boolean authRegister;
	
	/** 人行征信认证 */
	@Column(name="auth_ren_bank")
	private Boolean authRenBank;
	
	/** 视频认证 */
	@Column(name="auth_video")
	private Boolean authVideo;
	
	/** 成功借款次数 */
	@Column(name="succ_loan_size")
	private Integer succLoanSize;
	
	/** 第一次借款日期 */
	@Column(name="first_loan_date")
	private String firstLoanDate;
	
	/** 流标次数 */
	@Column(name="un_loan_size")
	private Integer unLoanSize;
	
	/** 撤销次数 */
	@Column(name="cancel_loan_size")
	private Integer cancelLoanSize;
	
	/** 失败次数 */
	@Column(name="lose_loan_size")
	private Integer loseLoanSize;
	
	/** 成功还款次数 */
	@Column(name="succ_repay_size")
	private Integer succRepaySize;
	
	/** 逾期小于15天还款次数 */
	@Column(name="delay_lt15_repay_size")
	private Integer delayLt15RepaySize;
	
	/** 逾期大于15天还款次数 */
	@Column(name="delay_gt15_repay_size")
	private Integer delayGt15RepaySize;
	
	/** 最大逾期天数 */
	@Column(name="max_delay_repay_size")
	private Integer maxDelayRepaySize;
	
	/** 累计借款金额 */
	@Column(name="total_loan_amount")
	private java.math.BigDecimal totalLoanAmount;
	
	/** 单笔最大借款金额 */
	@Column(name="single_max_loan_amount")
	private java.math.BigDecimal singleMaxLoanAmount;
	
	/** 待还金额 */
	@Column(name="wait_repay_amount")
	private java.math.BigDecimal waitRepayAmount;
	
	/** 待收金额 */
	@Column(name="wait_collect_amount")
	private java.math.BigDecimal waitCollectAmount;
	
	/** 历史最高负债 */
	@Column(name="history_high_owe")
	private java.math.BigDecimal historyHighOwe;
	
	/** 授权额度 */
	@Column(name="auth_amount")
	private java.math.BigDecimal authAmount;
	
	/** 借款余额 */
	@Column(name="auth_balance")
	private java.math.BigDecimal authBalance;
	
	/** 头像地址 */
	@Column(name="header_img_url")
	private String headerImgUrl;
	
	/** 插入时间 */
	@Column(name="created_time")
	private java.util.Date createdTime;
	
	/** 更新时间 */
	@Column(name="updated_time")
	private java.util.Date updatedTime;
	
	/** 逻辑删除 */
	@Column(name="deleted")
	private Boolean deleted;
	

	public String getPdu(){
		return pdu;
	}

	public void setPdu(String pdu){
		this.pdu = pdu;
	}

	public Integer getAge(){
		return age;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	public Integer getSex(){
		return sex;
	}

	public void setSex(Integer sex){
		this.sex = sex;
	}

	public String getRegDate(){
		return regDate;
	}

	public void setRegDate(String regDate){
		this.regDate = regDate;
	}

	public String getGrade(){
		return grade;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getSchool(){
		return school;
	}

	public void setSchool(String school){
		this.school = school;
	}

	public String getEdu(){
		return edu;
	}

	public void setEdu(String edu){
		this.edu = edu;
	}

	public String getStudyMode(){
		return studyMode;
	}

	public void setStudyMode(String studyMode){
		this.studyMode = studyMode;
	}

	public Boolean getAuthMobile(){
		return authMobile;
	}

	public void setAuthMobile(Boolean authMobile){
		this.authMobile = authMobile;
	}

	public Boolean getAuthIdno(){
		return authIdno;
	}

	public void setAuthIdno(Boolean authIdno){
		this.authIdno = authIdno;
	}

	public Boolean getAuthEdu(){
		return authEdu;
	}

	public void setAuthEdu(Boolean authEdu){
		this.authEdu = authEdu;
	}

	public Boolean getAuthRegister(){
		return authRegister;
	}

	public void setAuthRegister(Boolean authRegister){
		this.authRegister = authRegister;
	}

	public Boolean getAuthRenBank(){
		return authRenBank;
	}

	public void setAuthRenBank(Boolean authRenBank){
		this.authRenBank = authRenBank;
	}

	public Boolean getAuthVideo(){
		return authVideo;
	}

	public void setAuthVideo(Boolean authVideo){
		this.authVideo = authVideo;
	}

	public Integer getSuccLoanSize(){
		return succLoanSize;
	}

	public void setSuccLoanSize(Integer succLoanSize){
		this.succLoanSize = succLoanSize;
	}

	public String getFirstLoanDate(){
		return firstLoanDate;
	}

	public void setFirstLoanDate(String firstLoanDate){
		this.firstLoanDate = firstLoanDate;
	}

	public Integer getUnLoanSize(){
		return unLoanSize;
	}

	public void setUnLoanSize(Integer unLoanSize){
		this.unLoanSize = unLoanSize;
	}

	public Integer getCancelLoanSize(){
		return cancelLoanSize;
	}

	public void setCancelLoanSize(Integer cancelLoanSize){
		this.cancelLoanSize = cancelLoanSize;
	}

	public Integer getLoseLoanSize(){
		return loseLoanSize;
	}

	public void setLoseLoanSize(Integer loseLoanSize){
		this.loseLoanSize = loseLoanSize;
	}

	public Integer getSuccRepaySize(){
		return succRepaySize;
	}

	public void setSuccRepaySize(Integer succRepaySize){
		this.succRepaySize = succRepaySize;
	}

	public Integer getDelayLt15RepaySize(){
		return delayLt15RepaySize;
	}

	public void setDelayLt15RepaySize(Integer delayLt15RepaySize){
		this.delayLt15RepaySize = delayLt15RepaySize;
	}

	public Integer getDelayGt15RepaySize(){
		return delayGt15RepaySize;
	}

	public void setDelayGt15RepaySize(Integer delayGt15RepaySize){
		this.delayGt15RepaySize = delayGt15RepaySize;
	}

	public Integer getMaxDelayRepaySize(){
		return maxDelayRepaySize;
	}

	public void setMaxDelayRepaySize(Integer maxDelayRepaySize){
		this.maxDelayRepaySize = maxDelayRepaySize;
	}

	public java.math.BigDecimal getTotalLoanAmount(){
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(java.math.BigDecimal totalLoanAmount){
		this.totalLoanAmount = totalLoanAmount;
	}

	public java.math.BigDecimal getSingleMaxLoanAmount(){
		return singleMaxLoanAmount;
	}

	public void setSingleMaxLoanAmount(java.math.BigDecimal singleMaxLoanAmount){
		this.singleMaxLoanAmount = singleMaxLoanAmount;
	}

	public java.math.BigDecimal getWaitRepayAmount(){
		return waitRepayAmount;
	}

	public void setWaitRepayAmount(java.math.BigDecimal waitRepayAmount){
		this.waitRepayAmount = waitRepayAmount;
	}

	public java.math.BigDecimal getWaitCollectAmount(){
		return waitCollectAmount;
	}

	public void setWaitCollectAmount(java.math.BigDecimal waitCollectAmount){
		this.waitCollectAmount = waitCollectAmount;
	}

	public java.math.BigDecimal getHistoryHighOwe(){
		return historyHighOwe;
	}

	public void setHistoryHighOwe(java.math.BigDecimal historyHighOwe){
		this.historyHighOwe = historyHighOwe;
	}

	public java.math.BigDecimal getAuthAmount(){
		return authAmount;
	}

	public void setAuthAmount(java.math.BigDecimal authAmount){
		this.authAmount = authAmount;
	}

	public java.math.BigDecimal getAuthBalance(){
		return authBalance;
	}

	public void setAuthBalance(java.math.BigDecimal authBalance){
		this.authBalance = authBalance;
	}

	public String getHeaderImgUrl(){
		return headerImgUrl;
	}

	public void setHeaderImgUrl(String headerImgUrl){
		this.headerImgUrl = headerImgUrl;
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
		StringBuffer str = new StringBuffer("Pdu [");
		str.append("pdu=\"");
		str.append(pdu);
		str.append("\"");
		str.append(",");
		str.append("age=\"");
		str.append(age);
		str.append("\"");
		str.append(",");
		str.append("sex=\"");
		str.append(sex);
		str.append("\"");
		str.append(",");
		str.append("regDate=\"");
		str.append(regDate);
		str.append("\"");
		str.append(",");
		str.append("grade=\"");
		str.append(grade);
		str.append("\"");
		str.append(",");
		str.append("school=\"");
		str.append(school);
		str.append("\"");
		str.append(",");
		str.append("edu=\"");
		str.append(edu);
		str.append("\"");
		str.append(",");
		str.append("studyMode=\"");
		str.append(studyMode);
		str.append("\"");
		str.append(",");
		str.append("authMobile=\"");
		str.append(authMobile);
		str.append("\"");
		str.append(",");
		str.append("authIdno=\"");
		str.append(authIdno);
		str.append("\"");
		str.append(",");
		str.append("authEdu=\"");
		str.append(authEdu);
		str.append("\"");
		str.append(",");
		str.append("authRegister=\"");
		str.append(authRegister);
		str.append("\"");
		str.append(",");
		str.append("authRenBank=\"");
		str.append(authRenBank);
		str.append("\"");
		str.append(",");
		str.append("authVideo=\"");
		str.append(authVideo);
		str.append("\"");
		str.append(",");
		str.append("succLoanSize=\"");
		str.append(succLoanSize);
		str.append("\"");
		str.append(",");
		str.append("firstLoanDate=\"");
		str.append(firstLoanDate);
		str.append("\"");
		str.append(",");
		str.append("unLoanSize=\"");
		str.append(unLoanSize);
		str.append("\"");
		str.append(",");
		str.append("cancelLoanSize=\"");
		str.append(cancelLoanSize);
		str.append("\"");
		str.append(",");
		str.append("loseLoanSize=\"");
		str.append(loseLoanSize);
		str.append("\"");
		str.append(",");
		str.append("succRepaySize=\"");
		str.append(succRepaySize);
		str.append("\"");
		str.append(",");
		str.append("delayLt15RepaySize=\"");
		str.append(delayLt15RepaySize);
		str.append("\"");
		str.append(",");
		str.append("delayGt15RepaySize=\"");
		str.append(delayGt15RepaySize);
		str.append("\"");
		str.append(",");
		str.append("maxDelayRepaySize=\"");
		str.append(maxDelayRepaySize);
		str.append("\"");
		str.append(",");
		str.append("totalLoanAmount=\"");
		str.append(totalLoanAmount);
		str.append("\"");
		str.append(",");
		str.append("singleMaxLoanAmount=\"");
		str.append(singleMaxLoanAmount);
		str.append("\"");
		str.append(",");
		str.append("waitRepayAmount=\"");
		str.append(waitRepayAmount);
		str.append("\"");
		str.append(",");
		str.append("waitCollectAmount=\"");
		str.append(waitCollectAmount);
		str.append("\"");
		str.append(",");
		str.append("historyHighOwe=\"");
		str.append(historyHighOwe);
		str.append("\"");
		str.append(",");
		str.append("authAmount=\"");
		str.append(authAmount);
		str.append("\"");
		str.append(",");
		str.append("authBalance=\"");
		str.append(authBalance);
		str.append("\"");
		str.append(",");
		str.append("headerImgUrl=\"");
		str.append(headerImgUrl);
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