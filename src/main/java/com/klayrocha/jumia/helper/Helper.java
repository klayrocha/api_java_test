package com.klayrocha.jumia.helper;

public class Helper {

	public static String getCountryName(String phone) {
		String countryName = "None";
		Integer codeCountry = Integer.parseInt(phone.substring(1, 4));
		switch (codeCountry) {
		case 237:
			countryName = "Cameroon";
			break;
		case 251:
			countryName = "Ethiopia";
			break;
		case 212:
			countryName = "Morocco";
			break;
		case 258:
			countryName = "Mozambique";
			break;
		case 256:
			countryName = "Uganda";
			break;
		default:
			break;
		}
		return countryName;
	}

	public static Integer getCountryCode(String phone) {
		return Integer.parseInt(phone.substring(1, 4));
	}

	public static String verifyNumber(String phone) {
//		if(phone.matches("\\\\(237\\\\)\\\\?[2368]\\\\d{7,8}$")) {
//			this.state = "Valid";
//		} else {
//			this.state = "Invalid";
//		}
		return "Valid";
	}

//	public static void main(String[] args) {
//		// "(212) 6007989253"  (237) 6622284920
//		String phone = "(251) 9119454961";
//		// ?[2368]\d{7,8}$
//		if(phone.matches("^\\(251\\) ?:[1-59]\\d{8}$")) {
//			System.out.println("Valid");
//		} else {
//			System.out.println("Invalid");
//		}
//		
//	}

}
