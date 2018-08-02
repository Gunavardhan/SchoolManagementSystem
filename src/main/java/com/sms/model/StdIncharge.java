package com.sms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.sms.securityforpwd.SecurePassword;

@Entity
@Table(name="sms_std_incharge")
public class StdIncharge {
	@Id
	@GeneratedValue
	private Integer incharge_id;
	private String firstname;
	private String lastname;
	private String email;
	private String inchargePwd;
	private String mobile;
	@Generated(GenerationTime.ALWAYS)
	@Temporal(TemporalType.DATE)
	private Date date_of_reg = new java.sql.Date(new java.util.Date().getTime());
	public Integer getIncharge_id() {
		return incharge_id;
	}
	public void setIncharge_id(Integer incharge_id) {
		this.incharge_id = incharge_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getInchargePwd() {
		return inchargePwd;
	}
	public void setInchargePwd(String inchargePwd) throws Exception {
		SecurePassword sp = new SecurePassword();
		this.inchargePwd = sp.encrypt(inchargePwd);
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDate_of_reg() {
		return date_of_reg;
	}
	public void setDate_of_reg(Date date_of_reg) {
		this.date_of_reg = date_of_reg;
	}
	@Override
	public String toString() {
		return "StdIncharge [incharge_id=" + incharge_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", mobile=" + mobile + ", date_of_reg=" + date_of_reg + "]";
	}
	
}
