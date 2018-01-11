package com.bhuvanesh.utils;

public class SearchUtil {
	
	public static String generateSearchString(String queryText) {
		
//		return "/^" + queryText + "/i";
		return "^"+queryText+"(?i)";
	}

}
