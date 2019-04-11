package com.klayrocha.jumia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.klayrocha.jumia.helper.Helper;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 8456904141665434758L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String phone;

	@Transient
	private Integer countryCode;

	@Transient
	private String countryName;

	@Transient
	private String state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCountryCode() {
		this.countryCode = Helper.getCountryCode(getPhone());
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		this.countryName = Helper.getCountryName(getPhone());
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getState() {
		this.state = Helper.verifyNumber(getPhone());
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}