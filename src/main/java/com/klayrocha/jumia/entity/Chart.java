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
	private Long value;
	private String label;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
