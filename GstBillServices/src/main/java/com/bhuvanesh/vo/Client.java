package com.bhuvanesh.vo;

import java.util.List;

public class Client {
	
	private long clientId;
    private int gstTreatment;
    private String name;
    private String emailId;
    private List<String> phoneNoList;
    private String nameOfBusiness;
    private String GstinNo;
    private PlaceOfSupply placeOfSupply;
    private int paymentTerms;
    private int customDaysForPayment;
    private Address billingAddress, shippingAddress;
    
    public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public int getGstTreatment() {
		return gstTreatment;
	}

	public void setGstTreatment(int gstTreatment) {
		this.gstTreatment = gstTreatment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<String> getPhoneNoList() {
		return phoneNoList;
	}

	public void setPhoneNoList(List<String> phoneNoList) {
		this.phoneNoList = phoneNoList;
	}

	public String getNameOfBusiness() {
		return nameOfBusiness;
	}

	public void setNameOfBusiness(String nameOfBusiness) {
		this.nameOfBusiness = nameOfBusiness;
	}

	public String getGstinNo() {
		return GstinNo;
	}

	public void setGstinNo(String gstinNo) {
		GstinNo = gstinNo;
	}

	public PlaceOfSupply getPlaceOfSupply() {
		return placeOfSupply;
	}

	public void setPlaceOfSupply(PlaceOfSupply placeOfSupply) {
		this.placeOfSupply = placeOfSupply;
	}

	public int getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(int paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public int getCustomDaysForPayment() {
		return customDaysForPayment;
	}

	public void setCustomDaysForPayment(int customDaysForPayment) {
		this.customDaysForPayment = customDaysForPayment;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
