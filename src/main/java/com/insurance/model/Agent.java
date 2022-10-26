package com.insurance.model;

public class Agent {
	int id;
	
	public Agent(int i,String v,String c, String b) {
		this.id=i;
		this.vendor=v;
		this.contact=c;
		this.branch=b;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	String vendor, contact, branch;

}
