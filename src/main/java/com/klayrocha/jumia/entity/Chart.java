package com.klayrocha.jumia.entity;

import java.io.Serializable;

/**
 * Class representing the chart
 * 
 * @author Francis Klay Rocha
 *
 */
public class Chart implements Serializable {

	private static final long serialVersionUID = 5691998636175999750L;
	private Long phoneQuantity;
	private String countryName;

	public Long getPhoneQuantity() {
		return phoneQuantity;
	}

	public void setPhoneQuantity(Long phoneQuantity) {
		this.phoneQuantity = phoneQuantity;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result + ((phoneQuantity == null) ? 0 : phoneQuantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chart other = (Chart) obj;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (phoneQuantity == null) {
			if (other.phoneQuantity != null)
				return false;
		} else if (!phoneQuantity.equals(other.phoneQuantity))
			return false;
		return true;
	}

}
