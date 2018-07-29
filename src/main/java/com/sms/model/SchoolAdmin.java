package com.sms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sms_admin")
public class SchoolAdmin {
	@Id
	private Integer admin_id;
	private String admin_name;
	private String admin_pwd;
	private String role;
	
	public Integer getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	@Override
	public String toString() {
		return "SchoolAdmin [admin_name=" + admin_name + ", admin_pwd=" + admin_pwd + "]";
	}
	
}
