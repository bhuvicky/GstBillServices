package com.bhuvanesh.vo;

import com.bhuvanesh.constants.AppConstants;

public class ClientListRequest {
	
	public static final int SEARCH_BY_NAME = 1;
    public static final int SEARCH_BY_MOBILE = SEARCH_BY_NAME + 1;

    private String name;
    private String mobileNo;
    private int searchType; 
    private int from;
    private int pageLimit = AppConstants.PAGE_LIMIT;
    
    public String getName() {
		return name;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
}
