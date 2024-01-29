package anil.it.entity;

import java.time.LocalTime;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private Long phoneNum;
	
	private Integer cid;
	
	private Integer sid;
	
	private Integer cityId;
	
	private String passwordUpdated;
	
	@CreationTimestamp
	private LocalTime createdDate; 
	
	@UpdateTimestamp
	private LocalTime updatedDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String name, String email, String password, Long phoneNum, Integer cid, Integer sid,
			Integer cityId, String passwordUpdated, LocalTime createdDate, LocalTime updatedDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNum = phoneNum;
		this.cid = cid;
		this.sid = sid;
		this.cityId = cityId;
		this.passwordUpdated = passwordUpdated;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getPasswordUpdated() {
		return passwordUpdated;
	}

	public void setPasswordUpdated(String passwordUpdated) {
		this.passwordUpdated = passwordUpdated;
	}

	public LocalTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNum=" + phoneNum + ", cid=" + cid + ", sid=" + sid + ", cityId=" + cityId
				+ ", passwordUpdated=" + passwordUpdated + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	

}
