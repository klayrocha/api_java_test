package com.klayrocha.jumia.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * Help class
 * 
 * @author Francis Klay Rocha
 *
 */
public class Helper {

	static Map<String, String> regexs = new HashMap<String, String>();
	static Map<String, String> countries = new HashMap<String, String>();

	static {
		regexs.put("237", "\\(237\\)\\ ?[2368]\\d{7,8}$");
		regexs.put("251", "\\(251\\)\\ ?[1-59]\\d{8}$");
		regexs.put("212", "\\(212\\)\\ ?[5-9]\\d{8}$");
		regexs.put("258", "\\(258\\)\\ ?[28]\\d{7,8}$");
		regexs.put("256", "\\(256\\)\\ ?\\d{9}$");

		countries.put("237", "Cameroon");
		countries.put("251", "Ethiopia");
		countries.put("212", "Morocco");
		countries.put("258", "Mozambique");
		countries.put("256", "Uganda");
	}

	/**
	 * Method responsible for returning the country name by phone
	 * 
	 * @param phone
	 * @return country name
	 */
	public static String getCountryName(String phone) {
		return countries.get(phone.substring(1, 4));
	}

	/**
	 * Method responsible for returning the country code by phone
	 * 
	 * @param phone
	 * @return country code
	 */
	public static Integer getCountryCode(String phone) {
		return Integer.parseInt(phone.substring(1, 4));
	}

	/**
	 * Method responsible for returning the phone state
	 * 
	 * @param phone
	 * @return phone state
	 */
	public static String verifyNumber(String phone) {
		String regex = regexs.get(phone.substring(1, 4));
		if (regex != null) {
			if (phone.matches(regex)) {
				return "Valid";
			}
		}
		return "Invalid";
	}
}
