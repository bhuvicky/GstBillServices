package com.bhuvanesh.vo;

public class Product {
	
	private long productId;
    private int prodcutType;
    private String productName;
    private int quantity;
    private double unitPrice;
    private int unit;
    private String hsnSacCode;
    private int discountType;
    private float discountValue;
    private int taxRate;
    private String productDescription;
    private long lastUpdateTimestamp;
    
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getProdcutType() {
		return prodcutType;
	}
	public void setProdcutType(int prodcutType) {
		this.prodcutType = prodcutType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getHsnSacCode() {
		return hsnSacCode;
	}
	public void setHsnSacCode(String hsnSacCode) {
		this.hsnSacCode = hsnSacCode;
	}
	public int getDiscountType() {
		return discountType;
	}
	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}
	public float getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(float discountValue) {
		this.discountValue = discountValue;
	}
	public int getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(int taxRate) {
		this.taxRate = taxRate;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public long getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(long lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}
	
}
