package com.klayrocha.jumia.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelperTest {

	@Test
	public void testGetCountryName() {
		assertEquals("Morocco", Helper.getCountryName("(212) 6546545369"));
	}

	@Test
	public void testGetCountryCode() {
		assertEquals(new Integer(212), Helper.getCountryCode("(212) 6546545369"));
	}

	@Test
	public void testVerifyNumberInvalid() {
		assertEquals("Invalid", Helper.verifyNumber("(212) 6546545369"));
	}

	@Test
	public void testVerifyNumberValid() {
		assertEquals("Valid", Helper.verifyNumber("(212) 698054317"));
	}

}
