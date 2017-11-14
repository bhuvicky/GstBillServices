package com.bhuvanesh.vo;

import java.util.List;

public class Client {
	
	public long clientId;
    public int gstTreatment;
    public String name;
    public String emailId;
    public List<String> phoneNoList;

    public String nameOfBusiness;
    public String GstinNo;
    public PlaceOfSupply placeOfSupply;
    public int paymentTerms;
    public int customDaysForPayment;

    public Address billingAddress, shippingAddress;
}
