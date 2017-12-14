package com.cg.mobilesystem.dto;

import java.sql.Date;


public class Purchase {
	private int purId;
	private String cusName;
	private String eMail;
	private long phone;
	private Date purDate;
	private int mobileId;
	

	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	
	public Purchase(int purId, String cusName, String eMail, long phone,
			Date purDate, int mobileId) {
		super();
		this.purId = purId;
		this.cusName = cusName;
		this.eMail = eMail;
		this.phone = phone;
		this.purDate = purDate;
		this.mobileId = mobileId;
	}
	
	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}	
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getPurId() {
		return purId;
	}
	public void setPurId(int purId) {
		this.purId = purId;
	}
	public Date getPurDate() {
		return purDate;
	}
	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}

	@Override
	public String toString() {
		return "Purchase [purId=" + purId + ", cusName=" + cusName + ", eMail="
				+ eMail + ", phone=" + phone + ", purDate=" + purDate
				+ ", mobileId=" + mobileId + "]";
	}	
}
                                                                                                                                                                                                                 